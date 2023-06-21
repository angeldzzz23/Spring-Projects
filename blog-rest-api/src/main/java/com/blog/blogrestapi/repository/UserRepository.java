package com.blog.blogrestapi.repository;

import com.blog.blogrestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String Email);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
