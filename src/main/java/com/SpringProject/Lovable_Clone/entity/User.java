package com.SpringProject.Lovable_Clone.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
   
    private Long id;

    private String email;
    private String passwordHash;
    private String name;

    private String avatarUrl;

    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;
}
