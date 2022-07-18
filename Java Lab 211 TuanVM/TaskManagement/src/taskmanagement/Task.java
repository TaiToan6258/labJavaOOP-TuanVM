/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement;


public class Task {

    private int id;
    private String requirementName;
    private String taskType;
    private String date;
    private String planFrom;
    private String planTo;
    private String asignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String requirementName, String taskType, String date, String planFrom, String planTo, String asignee, String reviewer) {
        this.id = id;
        this.requirementName = requirementName;
        this.taskType = taskType;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.asignee = asignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public String getAsignee() {
        return asignee;
    }

    public void setAsignee(String asignee) {
        this.asignee = asignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public void display() {
        System.out.printf("%-5d%-13s%-15s%-15s%-8.1f%-10s%-10s\n",
                this.id, this.requirementName, this.taskType,
                this.date, (Double.parseDouble(this.planTo) - Double.parseDouble(this.planFrom)), this.asignee, this.reviewer);
    }

}
