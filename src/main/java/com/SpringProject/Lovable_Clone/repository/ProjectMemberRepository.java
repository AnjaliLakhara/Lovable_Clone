package com.SpringProject.Lovable_Clone.repository;

import com.SpringProject.Lovable_Clone.entity.ProjectMember;
import com.SpringProject.Lovable_Clone.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {
    List<ProjectMember>findByIdProjectId(Long projectId);


}
