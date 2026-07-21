package com.SpringProject.Lovable_Clone.service;

import com.SpringProject.Lovable_Clone.dto.project.ProjectResponse;
import com.SpringProject.Lovable_Clone.dto.project.ProjectSummaryResponse;
import com.SpringProject.Lovable_Clone.dto.project.ProjectRequest;
import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects();
    ProjectResponse getUserProjectById(Long projectId);
    ProjectResponse createProject(ProjectRequest request);
    ProjectResponse updateProject(Long projectId, ProjectRequest request);
    void softDelete(Long projectId);
}
