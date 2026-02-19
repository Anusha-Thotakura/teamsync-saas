package com.teamsync.teamsync_backend.repository;

import com.teamsync.teamsync_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}