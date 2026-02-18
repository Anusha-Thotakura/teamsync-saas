package com.teamsync.teamsync_backend.service;

import com.teamsync.teamsync_backend.entity.ProjectMember;
import com.teamsync.teamsync_backend.repository.ProjectMemberRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberService {

    private final ProjectMemberRepository repository;

    public ProjectMemberService(ProjectMemberRepository repository) {
        this.repository = repository;
    }

    public ProjectMember addMember(ProjectMember member) {
        return repository.save(member);
    }
}