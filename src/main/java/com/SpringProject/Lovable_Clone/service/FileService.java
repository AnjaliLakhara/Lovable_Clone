package com.SpringProject.Lovable_Clone.service;

import java.util.List;
import com.SpringProject.Lovable_Clone.dto.project.FileNode;
import com.SpringProject.Lovable_Clone.dto.project.FileContentResponse;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);
    FileContentResponse getFileContent(Long projectId, Long userId, String path);
}
