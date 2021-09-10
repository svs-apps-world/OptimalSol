package com.example.optimalsolutions;

public class TicketsData {

    String equipmentName;
    String issue;
    String description;
    String resolution;
    String dateOfIssue;
    long id;

    public TicketsData() {
    }

    public TicketsData(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public TicketsData(String equipmentName, String issue, String description, String resolution, String dateOfIssue) {
        this.equipmentName = equipmentName;
        this.issue = issue;
        this.description = description;
        this.resolution = resolution;
        this.dateOfIssue = dateOfIssue;
        this.id = System.currentTimeMillis();
    }
}
