package com.teamsync.teamsync_backend.repository;

import com.teamsync.teamsync_backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}