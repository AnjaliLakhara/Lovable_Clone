package com.SpringProject.Lovable_Clone.mapper;

import com.SpringProject.Lovable_Clone.dto.auth.UserProfileResponse;
import com.SpringProject.Lovable_Clone.dto.project.ProjectResponse;
import com.SpringProject.Lovable_Clone.dto.project.ProjectSummaryResponse;
import com.SpringProject.Lovable_Clone.entity.Project;
import com.SpringProject.Lovable_Clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    @Mapping(target = "projectName", source = "name")
    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

    UserProfileResponse toUserProfileResponse(User user);
}
