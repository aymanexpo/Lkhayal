package com.example.lkhayal_client;

public class client {
    private String clientID;
    private String fName,lName, birthDate , photo,identityDoc, identityNumber , inscriptionDate , clientEmail,passwd , clientPhone, priceRate , notes;


    public client() {
    }

    public client(String clientID, String fName, String lName, String clientEmail, String passwd, String clientPhone) {
        this.clientID = clientID;
        this.fName = fName;
        this.lName = lName;
        this.clientEmail = clientEmail;
        this.passwd = passwd;
        this.clientPhone = clientPhone;
    }

   /* public client(String fName, String lName, String clientEmail, String passwd, String clientPhone) {
        this.fName = fName;
        this.lName = lName;
        this.clientEmail = clientEmail;
        this.passwd = passwd;
        this.clientPhone = clientPhone;
    }*/

    /*public client(String clientID, String fName, String lName, String birthDate, String photo, String identityDoc, String identityNumber, String inscriptionDate, String clientEmail, String passwd, String clientPhone, String priceRate, String notes) {
        this.clientID = clientID;
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.photo = photo;
        this.identityDoc = identityDoc;
        this.identityNumber = identityNumber;
        this.inscriptionDate = inscriptionDate;
        this.clientEmail = clientEmail;
        this.passwd = passwd;
        this.clientPhone = clientPhone;
        this.priceRate = priceRate;
        this.notes = notes;
    }*/


    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIdentityDoc() {
        return identityDoc;
    }

    public void setIdentityDoc(String identityDoc) {
        this.identityDoc = identityDoc;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(String inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

