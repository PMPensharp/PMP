package com.example.pmp;

public class Data {
    private String name;
    private Double power;

    public Data(String name,Double power){
        this.name=name;
        this.power=power;
    }

    public String getDataName(){
        return name;
    }

    public Double getDataPower(){
        return power;
    }

    public void setDataName(String name){
        this.name=name;
    }

    public void setDataPower(Double power){
        this.power=power;
    }
}
