package com.SpringProject.Lovable_Clone.service.impl;

import com.SpringProject.Lovable_Clone.service.FileService;
import java.util.List;
import com.SpringProject.Lovable_Clone.dto.project.FileNode;
import com.SpringProject.Lovable_Clone.dto.project.FileContentResponse;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
 

    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, Long userId, String path) {
        return null;
    }
}
