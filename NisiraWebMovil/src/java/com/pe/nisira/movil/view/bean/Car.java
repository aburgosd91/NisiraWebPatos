/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class Car implements Serializable{
    private String id;
    private String brand;
    private int year;
    private String color;
    private int price;
    private boolean soldState;
    
    public Car(String id, String brand,int year,String color, int price, boolean soldState){
        this.id=id;
        this.brand=brand;
        this.year=year;
        this.color=color;
        this.price=price;
        this.soldState=soldState;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the soldState
     */
    public boolean isSoldState() {
        return soldState;
    }

    /**
     * @param soldState the soldState to set
     */
    public void setSoldState(boolean soldState) {
        this.soldState = soldState;
    }
    /**
     * @return the id
     */
    
}
