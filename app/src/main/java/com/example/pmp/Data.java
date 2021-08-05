package com.example.pmp;

public class Data {
    private String name;
    private Double power;
    private String imageID;
    private int image;

    public Data(String name,Double power,String imageID){
        this.name=name;
        this.power=power;
        this.imageID=imageID;

    }

    public String getDataName(){
        return name;
    }

    public Double getDataPower(){
        return power;
    }

    public String getDataColor(){ return imageID; }



    public void setDataName(String name){
        this.name=name;
    }

    public void setDataPower(Double power){
        this.power=power;
    }

    public void setDataColor(String imageID){this.imageID=imageID;}


}
