package com.SpringProject.Lovable_Clone.service;

import com.SpringProject.Lovable_Clone.dto.project.ProjectResponse;
import com.SpringProject.Lovable_Clone.dto.project.ProjectSummaryResponse;
import com.SpringProject.Lovable_Clone.dto.project.ProjectRequest;
import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);
    ProjectResponse getUserProjectById(Long userId,Long projectId);
    ProjectResponse createProject(ProjectRequest request, Long userId);
    ProjectResponse updateProject(Long projectId, ProjectRequest request, Long userId);
    void softDelete(Long projectId,Long userId);
}
