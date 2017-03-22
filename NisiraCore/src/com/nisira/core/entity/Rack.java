/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class Rack implements Serializable{
    private String idempresa;
    private String idcamara;
    private String idrack;
    private String descripcion;
    private ArrayList<Pisos> listapisos;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdrack() {
        return idrack;
    }

    public void setIdrack(String idrack) {
        this.idrack = idrack;
    }

    public String getIdcamara() {
        return idcamara;
    }

    public void setIdcamara(String idcamara) {
        this.idcamara = idcamara;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public ArrayList<Pisos> getListapisos() {
        return listapisos;
    }

    public void setListapisos(ArrayList<Pisos> listapisos) {
        this.listapisos = listapisos;
    }

    
    
}
