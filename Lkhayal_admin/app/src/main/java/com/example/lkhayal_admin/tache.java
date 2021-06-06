package com.example.lkhayal_admin;

public class tache {
    String  tasksID, startDate, durationMinut, detail, title, user_Fk,isDone;

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }

    public String getUser_Fk() {
        return user_Fk;
    }

    public void setUser_Fk(String user_Fk) {
        this.user_Fk = user_Fk;
    }

    public String getTasksID() {
        return tasksID;
    }

    public void setTasksID(String tasksID) {
        this.tasksID = tasksID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDurationMinut() {
        return durationMinut;
    }

    public void setDurationMinut(String durationMinut) {
        this.durationMinut = durationMinut;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public tache(String tasksID, String startDate, String durationMinut, String detail, String title) {
        this.tasksID = tasksID;
        this.startDate = startDate;
        this.durationMinut = durationMinut;
        this.detail = detail;
        this.title = title;
    }

    public tache(String startDate, String durationMinut, String detail, String title) {
        this.startDate = startDate;
        this.durationMinut = durationMinut;
        this.detail = detail;
        this.title = title;
    }

    public tache(String tasksID, String startDate, String durationMinut, String detail, String title, String user_Fk) {
        this.tasksID = tasksID;
        this.startDate = startDate;
        this.durationMinut = durationMinut;
        this.detail = detail;
        this.title = title;
        this.user_Fk = user_Fk;
    }

}
