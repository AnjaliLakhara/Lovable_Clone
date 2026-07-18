package com.SpringProject.Lovable_Clone.service.impl;

import com.SpringProject.Lovable_Clone.dto.project.ProjectRequest;
import com.SpringProject.Lovable_Clone.dto.project.ProjectResponse;
import com.SpringProject.Lovable_Clone.dto.project.ProjectSummaryResponse;
import com.SpringProject.Lovable_Clone.entity.Project;
import com.SpringProject.Lovable_Clone.entity.User;
import com.SpringProject.Lovable_Clone.mapper.ProjectMapper;
import com.SpringProject.Lovable_Clone.repository.ProjectRepository;
import com.SpringProject.Lovable_Clone.repository.UserRepository;
import com.SpringProject.Lovable_Clone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner = userRepository.findById(userId).orElseThrow();

        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();

        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {

//         return projectRepository.findAllAccessibleByUser(userId)
//                .stream()
//                .map(projectMapper::toProjectSummaryResponse)
//                .collect(Collectors.toList());

        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        Project project =  getAccessibleProjectById(id, userId);
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project =getAccessibleProjectById(id, userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("You are not allowed to delete this project.");
        }

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    //Internal Functions
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
