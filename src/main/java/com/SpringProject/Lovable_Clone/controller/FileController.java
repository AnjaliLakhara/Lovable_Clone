package com.SpringProject.Lovable_Clone.controller;

import com.SpringProject.Lovable_Clone.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.SpringProject.Lovable_Clone.dto.project.FileContentResponse;
import com.SpringProject.Lovable_Clone.dto.project.FileNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileTree(projectId,userId));
    }

    @GetMapping("/{*path}") //src/hooks/Apphook.js
    public ResponseEntity<FileContentResponse> getFile(
        @PathVariable Long projectId,
        @PathVariable String path
    ){
        Long userId = 1L;
        FileContentResponse response = fileService.getFileContent(projectId,userId,path);
        return ResponseEntity.ok(response);
        
    }
}
