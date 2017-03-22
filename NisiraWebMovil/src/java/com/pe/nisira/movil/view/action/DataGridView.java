/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.pe.nisira.movil.view.bean.Car;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean
@RequestScoped
public class DataGridView implements Serializable {
    private ArrayList<Car> cars;
    private Car selectedCar;
    @ManagedProperty("#{carService}")
    private CarService service;
    @PostConstruct
    public void init() {
        cars = (ArrayList<Car>) service.createCars(48);
    }
 
    public List<Car> getCars() {
        return cars;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}
