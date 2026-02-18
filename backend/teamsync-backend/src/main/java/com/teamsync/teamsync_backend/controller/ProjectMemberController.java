package com.teamsync.teamsync_backend.controller;

import com.teamsync.teamsync_backend.entity.ProjectMember;
import com.teamsync.teamsync_backend.service.ProjectMemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project-members")
public class ProjectMemberController {

    private final ProjectMemberService service;

    public ProjectMemberController(ProjectMemberService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ProjectMember addMember(@RequestBody ProjectMember member) {
        return service.addMember(member);
    }
}