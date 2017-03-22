/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class TreeAlmacenes implements Serializable{
    private String tipo;
    private String id;
    private String iddist;
    private String descripcion;
    private int prioridad;
    private List<DAlmacen_Columnas> lstcol;
    private boolean seleccionado;
    private List<Integer> arregloTemp;
    public TreeAlmacenes() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getIddist() {
        return iddist;
    }
 
    public void setIddist(String iddist) {
        this.iddist = iddist;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<DAlmacen_Columnas> getLstcol() {
        return lstcol;
    }

    public void setLstcol(List<DAlmacen_Columnas> lstcol) {
        this.lstcol = lstcol;
    }

    public List<Integer> getArregloTemp() {
        return arregloTemp;
    }

    public void setArregloTemp(List<Integer> arregloTemp) {
        this.arregloTemp = arregloTemp;
    }

    
}
