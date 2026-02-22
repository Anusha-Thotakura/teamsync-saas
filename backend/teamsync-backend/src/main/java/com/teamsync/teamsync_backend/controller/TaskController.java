package com.teamsync.teamsync_backend.controller;

import com.teamsync.teamsync_backend.entity.Task;
import com.teamsync.teamsync_backend.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/update-status/{taskId}")
    public Task updateStatus(
            @PathVariable Long taskId,
            @RequestParam String status
    ) {
        Task task = taskService.getTaskById(taskId);
        task.setStatus(status);
        return taskService.saveTask(task);
    }

    @GetMapping("/project/{projectId}")
    public java.util.List<Task> getTasksByProject(@PathVariable Long projectId) {
        return taskService.getTasksByProject(projectId);
    }
    @GetMapping("/my")
    public java.util.List<Task> getMyTasks(@RequestParam String email) {
        return taskService.getTasksByUser(email);
    }
    @GetMapping("/stats")
    public java.util.Map<String, Long> getStats(@RequestParam String email) {
        return taskService.getTaskStats(email);
    }
    @GetMapping("/my/paged")
    public org.springframework.data.domain.Page<Task> getMyTasksPaged(
            @RequestParam String email,
            @RequestParam int page,
            @RequestParam int size
    ) {
        return taskService.getTasksByUserPaged(email, page, size);
    }
}