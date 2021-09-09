package com.example.optimalsolutions;

public class TicketsData {

    String title;
    String issue;
    String description;
    String resolution;
    String dateOfIssue;
    long id;

    public TicketsData(String title) {
        this.title = title;
    }

    public TicketsData(String title, String issue, String description, String resolution, String dateOfIssue) {
        this.title = title;
        this.issue = issue;
        this.description = description;
        this.resolution = resolution;
        this.dateOfIssue = dateOfIssue;
        this.id = System.currentTimeMillis();
    }
}
