package com.teamsync.teamsync_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project_members")
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;

    private String userEmail;

    private String role;  // OWNER / MANAGER / MEMBER

    public ProjectMember() {}

    public Long getId() { return id; }

    public Long getProjectId() { return projectId; }

    public void setProjectId(Long projectId) { this.projectId = projectId; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}