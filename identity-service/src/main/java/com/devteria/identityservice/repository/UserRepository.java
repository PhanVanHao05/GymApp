package com.devteria.identityservice.repository;

import java.util.List;
import java.util.Optional;

import com.devteria.identityservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devteria.identityservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    // Tìm tất cả user theo role
    List<User> findAllByRoles(Role role);

    // Tìm tất cả user theo danh sách roles
    List<User> findAllByRolesIn(List<Role> roles);
}
