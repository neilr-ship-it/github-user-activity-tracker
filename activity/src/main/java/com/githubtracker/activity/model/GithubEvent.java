package com.githubtracker.activity.model;

public class GithubEvent {
    private String eventType;
    private String repo;
    private String timestamp;
    private String details;

    public GithubEvent(String eventType, String repo, String timestamp, String details) {
        this.eventType = eventType;
        this.repo = repo;
        this.timestamp = timestamp;
        this.details = details;
    } 

    public String getEventType() {
        return eventType;
    }

    public String getRepo() {
        return repo;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }
}
