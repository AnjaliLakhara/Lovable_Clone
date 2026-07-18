package com.SpringProject.Lovable_Clone.repository;

import com.SpringProject.Lovable_Clone.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
    @Query("SELECT p FROM Project p WHERE p.owner.id = :userId OR p.isPublic = true")
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

    @Query("""
            SELECT p FROM Project p
            LEFT JOIN FETCH p.owner
            WHERE p.id = :projectId
              AND p.deletedAt is NULL
              AND p.owner.id = :userId
            """)
    Optional<Project> findAccessibleProjectById(@Param("projectId") Long projectId,
                                                @Param("userId")Long userId);
}
