/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Victor Zavala Llanos
 */
public class FechaCampanaAnual implements Serializable{
    private String idempresa;
    private String idfecha;
    private String descripcion;
    private Date fechainicio;
    private Date fechafinal;
    private String idcultivo;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getIdcultivo() {
        return idcultivo;
    }

    public void setIdcultivo(String idcultivo) {
        this.idcultivo = idcultivo;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdfecha() {
        return idfecha;
    }

    public void setIdfecha(String idfecha) {
        this.idfecha = idfecha;
    }
    
    
    
}

