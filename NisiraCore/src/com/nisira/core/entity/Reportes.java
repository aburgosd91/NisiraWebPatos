/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.io.Serializable;



/**
 *
 * @author JLuisCQ
 */
public class Reportes implements Serializable {
    
    private String cNombre;
    private Integer iCantidad;
    private Double iCantidadD;

   
    public Reportes() {
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public Integer getICantidad() {
        return iCantidad;
    }

    public void setICantidad(Integer iCantidad) {
        this.iCantidad = iCantidad;
    }

    public Double getICantidadD() {
        return iCantidadD;
    }

    public void setICantidadD(Double iCantidadD) {
        this.iCantidadD = iCantidadD;
    }


   
    
}
