package com.teamsync.teamsync_backend.repository;

import com.teamsync.teamsync_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);
    List<Task> findByAssignedToEmail(String email);
    Page<Task> findByAssignedToEmail(String email, Pageable pageable);
}