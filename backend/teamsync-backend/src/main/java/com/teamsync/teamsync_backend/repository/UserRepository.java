package com.teamsync.teamsync_backend.repository;

import com.teamsync.teamsync_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}