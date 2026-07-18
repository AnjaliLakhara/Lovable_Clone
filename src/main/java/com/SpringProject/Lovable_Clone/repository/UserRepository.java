package com.SpringProject.Lovable_Clone.repository;

import com.SpringProject.Lovable_Clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findByEmail(String email);
}
