/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.Afp;
import com.nisira.core.service.AfpService;
import com.pe.nisira.movil.view.bean.Car;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.mobile.event.SwipeEvent;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean
@ViewScoped
public class DtMobileView {
    private List<Car> cars1;
    private List<Car> cars2;
    private List<Car> cars3;
    private List<Car> selectedCars;
    private List<Afp> afp;
    private List<Afp> afpTemp;
    private String mensaje;
    @ManagedProperty("#{carService}")
    private CarService service;
     
    @PostConstruct
    public void init() {
        cars1 = service.createCars(10);
        cars2 = service.createCars(10);
        cars3 = service.createCars(50);
        afp=(new AfpService()).findByBaseDatos();
        afpTemp=afp;
        mensaje="";
    }
    public String getMensaje() {
        return this.mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public List<Afp> getAfp() {
        return afp;
    }
    public List<Afp> getAfpTemp() {
        return afpTemp;
    }
    public List<Car> getCars1() {
        return cars1;
    }
 
    public List<Car> getCars2() {
        return cars2;
    }
 
    public List<Car> getCars3() {
        return cars3;
    }
    public void setService(CarService service) {
        this.service = service;
    }
    public List<Car> getSelectedCars() {
        return selectedCars;
    }
    public void setAfpFiltrado(){
        this.afp=filtrar(mensaje);
        RequestContext.getCurrentInstance().update("contenedor:Form1:mensaje");
        RequestContext.getCurrentInstance().update("contenedor:Form1:afp");
//        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
    }
    public void setSelectedCars(List<Car> selectedCars) {
        this.selectedCars = selectedCars;
    }
    public void listener(AjaxBehaviorEvent event) {
        FacesMessage msg = new FacesMessage("Mensajito",event.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
    public void onRowSwipeRight(SwipeEvent event) {
        Car car = ((Car) event.getData());
        cars3.remove(car);
         
        if(selectedCars != null && !selectedCars.isEmpty()) {
            selectedCars.remove(car);
        }
    }
    public void onRowSwipeLeft(SwipeEvent event) {
        FacesMessage msg = new FacesMessage("Swiped Left", ((Car) event.getData()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public List<Afp> filtrar(String parametro){
        ArrayList<Afp> temp=new ArrayList<Afp>();
        for(int i=0;i<afpTemp.size();i++){
            if(afpTemp.get(i).getDescripcion().indexOf(parametro.toUpperCase())!=-1){
                temp.add(afpTemp.get(i));
            }
        }
        return temp;
    }
}
