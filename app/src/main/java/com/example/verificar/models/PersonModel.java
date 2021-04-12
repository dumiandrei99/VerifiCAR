package com.example.verificar.models;


import java.util.Date;

public class PersonModel {
    private String userName;
    private String password;
    private String nume;
    private String prenume;
    private String email;
    private String CNP;
    private String KZ;
    private int nrBuletin;
    private String adresa;
    private int telefon;
    private Date dataPermis;

    public PersonModel(){

    }

    public PersonModel(String userName, String password, String nume, String prenume, String email, String CNP, String KZ, int nrBuletin, String adresa, int telefon, Date dataPermis) {
        this.userName = userName;
        this.password = password;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.KZ = KZ;
        this.CNP = CNP;
        this.nrBuletin = nrBuletin;
        this.adresa = adresa;
        this.telefon = telefon;
        this.dataPermis = dataPermis;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKZ() {
        return KZ;
    }

    public void setKZ(String KZ) {
        this.KZ = KZ;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public int getNrBuletin() {
        return nrBuletin;
    }

    public void setNrBuletin(int nrBuletin) {
        this.nrBuletin = nrBuletin;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public Date getDataPermis() {
        return dataPermis;
    }

    public void setDataPermis(Date dataPermis) {
        this.dataPermis = dataPermis;
    }

}
