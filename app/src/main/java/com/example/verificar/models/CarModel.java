package com.example.verificar.models;

public class CarModel {

    private String username;
    private String numePropietar;
    private String prenumePropietar;
    private String modelAuto;
    private String categorieAuto;
    private String seriseSasiu;
    private int cm3;
    private int caiPutere;
    private float masa;
    private String serieCiv;
    private String tipCombustibil;
    private int anFabricatie;
    private int RCA;

    public CarModel(String username, String numePropietar, String prenumePropietar, String modelAuto, String categorieAuto, String seriseSasiu, int cm3, int caiPutere, float masa, String serieCiv, String tipCombustibil, int anFabricatie) {
        this.username = username;
        this.numePropietar = numePropietar;
        this.prenumePropietar = prenumePropietar;
        this.modelAuto = modelAuto;
        this.categorieAuto = categorieAuto;
        this.seriseSasiu = seriseSasiu;
        this.cm3 = cm3;
        this.caiPutere = caiPutere;
        this.masa = masa;
        this.serieCiv = serieCiv;
        this.tipCombustibil = tipCombustibil;
        this.anFabricatie = anFabricatie;
        this.RCA = 0;
    }

    public String getNumePropietar() {
        return numePropietar;
    }

    public void setNumePropietar(String numePropietar) {
        this.numePropietar = numePropietar;
    }

    public String getPrenumePropietar() {
        return prenumePropietar;
    }

    public void setPrenumePropietar(String prenumePropietar) {
        this.prenumePropietar = prenumePropietar;
    }

    public String getModelAuto() {
        return modelAuto;
    }

    public void setModelAuto(String modelAuto) {
        this.modelAuto = modelAuto;
    }

    public String getSeriseSasiu() {
        return seriseSasiu;
    }

    public void setSeriseSasiu(String seriseSasiu) {
        this.seriseSasiu = seriseSasiu;
    }

    public String getCategorieAuto() {
        return categorieAuto;
    }

    public void setCategorieAuto(String categorieAuto) {
        this.categorieAuto = categorieAuto;
    }

    public int getCm3() {
        return cm3;
    }

    public void setCm3(int cm3) {
        this.cm3 = cm3;
    }

    public int getCaiPutere() {
        return caiPutere;
    }

    public void setCaiPutere(int caiPutere) {
        this.caiPutere = caiPutere;
    }

    public float getMasa() {
        return masa;
    }

    public void setMasa(float masa) {
        this.masa = masa;
    }

    public String getSerieCiv() {
        return serieCiv;
    }

    public void setSerieCiv(String serieCiv) {
        this.serieCiv = serieCiv;
    }

    public String getTipCombustibil() {
        return tipCombustibil;
    }

    public void setTipCombustibil(String tipCombustibil) {
        this.tipCombustibil = tipCombustibil;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public int hasRCA() {
        return RCA;
    }

    public void setRCA(int RCA) {
        this.RCA = RCA;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
