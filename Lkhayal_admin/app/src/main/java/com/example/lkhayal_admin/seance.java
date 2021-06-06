package com.example.lkhayal_admin;


public class seance {

    private String seanceID,clientID,monitorID;
    String startDate,Duree, comments;

    public seance() {
    }

    public String getSeanceID() {
        return seanceID;
    }

    public void setSeanceID(String seanceID) {
        this.seanceID = seanceID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getMonitorID() {
        return monitorID;
    }

    public void setMonitorID(String monitorID) {
        this.monitorID = monitorID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDuree() {
        return Duree;
    }

    public void setDuree(String duree) {
        Duree = duree;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public seance(String seanceID, String clientID, String monitorID, String startDate, String duree, String comments) {
        this.seanceID = seanceID;
        this.clientID = clientID;
        this.monitorID = monitorID;
        this.startDate = startDate;
        Duree = duree;
        this.comments = comments;
    }
}
