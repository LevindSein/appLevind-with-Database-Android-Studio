package com.example.levindmopro.model;

public class MantanModel {

    String name;
    String asal;
    String keahlian;
    String DesCription;
    int fotoMantan;

    public MantanModel(String name, String asal, String keahlian, String desCription, int fotoMantan) {
        this.name = name;
        this.asal = asal;
        this.keahlian = keahlian;
        this.DesCription = desCription;
        this.fotoMantan = fotoMantan;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public String getDesCription() {
        return DesCription;
    }

    public void setDesCription(String desCription) {
        DesCription = desCription;
    }

    public int getFotoMantan() {
        return fotoMantan;
    }

    public void setFotoMantan(int fotoMantan) {
        this.fotoMantan = fotoMantan;
    }
}
