package com.SpringProject.Lovable_Clone.service;

import java.util.List;
import com.SpringProject.Lovable_Clone.dto.member.InviteMemberRequest;
import com.SpringProject.Lovable_Clone.dto.member.MemberResponse;
import com.SpringProject.Lovable_Clone.entity.ProjectMember;

public interface ProjectMemberService {
    List<ProjectMember> getProjectMembers(Long projectId, Long userId);
    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);
    MemberResponse updateMemberRole(Long projectId, Long memberId, InviteMemberRequest request, Long userId);
    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
