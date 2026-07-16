package com.SpringProject.Lovable_Clone.repository;

import com.SpringProject.Lovable_Clone.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
    @Query("SELECT p FROM Project p WHERE p.owner.id = :userId OR p.isPublic = true")
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);
}
