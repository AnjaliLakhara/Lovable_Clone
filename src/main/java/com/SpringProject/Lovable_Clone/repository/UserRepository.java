package com.SpringProject.Lovable_Clone.repository;

import com.SpringProject.Lovable_Clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
