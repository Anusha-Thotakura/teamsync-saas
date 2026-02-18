package com.teamsync.teamsync_backend.repository;

import com.teamsync.teamsync_backend.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
}