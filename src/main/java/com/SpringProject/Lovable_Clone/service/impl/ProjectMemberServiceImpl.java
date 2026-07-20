package com.SpringProject.Lovable_Clone.service.impl;


import com.SpringProject.Lovable_Clone.dto.member.InviteMemberRequest;
import com.SpringProject.Lovable_Clone.dto.member.MemberResponse;
import com.SpringProject.Lovable_Clone.dto.member.UpdateMemberRoleRequest;
import com.SpringProject.Lovable_Clone.entity.Project;
import com.SpringProject.Lovable_Clone.entity.ProjectMember;
import com.SpringProject.Lovable_Clone.entity.ProjectMemberId;
import com.SpringProject.Lovable_Clone.entity.User;
import com.SpringProject.Lovable_Clone.mapper.ProjectMemberMapper;
import com.SpringProject.Lovable_Clone.repository.ProjectMemberRepository;
import com.SpringProject.Lovable_Clone.repository.ProjectRepository;
import com.SpringProject.Lovable_Clone.repository.UserRepository;
import com.SpringProject.Lovable_Clone.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
     Project project = getAccessibleProjectById(projectId, userId);

    return projectMemberRepository.findByIdProjectId(projectId).stream()
            .map(projectMemberMapper:: toProjectMemberResponseFromMember)
            .toList();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);


        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

            if(projectMemberRepository.existsById(projectMemberId)){
                throw new RuntimeException("Cannot invite once again");
            }
        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

          projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);


        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if(projectMemberRepository.existsById(projectMemberId)){
        }
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
            Project project = getAccessibleProjectById(projectId, userId);

            ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
           if(!projectMemberRepository.existsById(projectMemberId)){
               throw new RuntimeException("member not found in project");
           }

            projectMemberRepository.deleteById(projectMemberId);
    }

    //Internal Functions
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
