package com.example.lkhayal_salarie;

public class Note {
    String clientID, notes, fName,lName;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Note(String clientID, String notes) {
        this.clientID = clientID;
        this.notes = notes;
    }

    public Note() {
    }

    public Note(String clientID, String notes, String fName, String lName) {
        this.clientID = clientID;
        this.notes = notes;
        this.fName = fName;
        this.lName = lName;
    }
}
