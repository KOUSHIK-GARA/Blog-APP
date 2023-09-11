package com.blog.repository;

import com.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,String> {
    public Optional<Role> findByRoleName(String roleName);
}
