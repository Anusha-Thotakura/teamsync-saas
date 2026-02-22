package com.teamsync.teamsync_backend.service;

import com.teamsync.teamsync_backend.entity.Task;
import com.teamsync.teamsync_backend.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }


    public java.util.List<Task> getTasksByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }
    public java.util.List<Task> getTasksByUser(String email) {
        return taskRepository.findByAssignedToEmail(email);
    }
    public java.util.Map<String, Long> getTaskStats(String email) {

        java.util.List<Task> tasks = taskRepository.findByAssignedToEmail(email);

        long total = tasks.size();
        long todo = tasks.stream().filter(t -> "TODO".equals(t.getStatus())).count();
        long inProgress = tasks.stream().filter(t -> "IN_PROGRESS".equals(t.getStatus())).count();
        long done = tasks.stream().filter(t -> "DONE".equals(t.getStatus())).count();

        java.util.Map<String, Long> stats = new java.util.HashMap<>();
        stats.put("total", total);
        stats.put("todo", todo);
        stats.put("inProgress", inProgress);
        stats.put("done", done);

        return stats;
    }
    public Page<Task> getTasksByUserPaged(String email, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return taskRepository.findByAssignedToEmail(email, pageable);
    }
}