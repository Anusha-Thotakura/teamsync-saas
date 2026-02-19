package com.teamsync.teamsync_backend.service;

import com.teamsync.teamsync_backend.entity.Task;
import com.teamsync.teamsync_backend.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
}