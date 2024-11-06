package com.day7.model;

import java.sql.Timestamp;

public class Bug {
    private int bugId;
    private String title;
    private String description;
    private String status;
    private int createdBy;
    private int assignedTo;
    private Timestamp createdAt;

    public Bug(int bugId, String title, String description, String status, int createdBy, int assignedTo, Timestamp createdAt) {
        this.bugId = bugId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
    }

    public Bug(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = "New";
        this.createdBy = 0;
        this.assignedTo = 0;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public int getBugId() {
        return bugId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "bugId=" + bugId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdBy=" + createdBy +
                ", assignedTo=" + assignedTo +
                ", createdAt=" + createdAt +
                '}';
    }
}
