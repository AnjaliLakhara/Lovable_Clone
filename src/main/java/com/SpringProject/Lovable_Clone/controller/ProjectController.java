package com.SpringProject.Lovable_Clone.controller;

import com.SpringProject.Lovable_Clone.security.AuthUtil;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.SpringProject.Lovable_Clone.dto.project.ProjectResponse;
import com.SpringProject.Lovable_Clone.dto.project.ProjectSummaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.SpringProject.Lovable_Clone.dto.project.ProjectRequest;
import com.SpringProject.Lovable_Clone.service.ProjectService;


import com.SpringProject.Lovable_Clone.security.JwtUserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectSummaryResponse>> getMyProjects(@AuthenticationPrincipal JwtUserPrincipal userPrincipal){
        return ResponseEntity.ok(projectService.getUserProjects());
    }

    @GetMapping("/{id}") 
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id, @AuthenticationPrincipal JwtUserPrincipal userPrincipal){
        Long userId = userPrincipal.userId();
        return ResponseEntity.ok(projectService.getUserProjectById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody @Valid ProjectRequest request, @AuthenticationPrincipal JwtUserPrincipal userPrincipal){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id, @RequestBody @Valid ProjectRequest request, @AuthenticationPrincipal JwtUserPrincipal userPrincipal){
        return ResponseEntity.ok(projectService.updateProject(id, request));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id, @AuthenticationPrincipal JwtUserPrincipal userPrincipal){
        projectService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
