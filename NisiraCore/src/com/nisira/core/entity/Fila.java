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
public class Fila implements Serializable{
    private String idempresa;
    private String idcamara;
    private String idrack;
    private String idpiso;
    private String idfila;
    private String descripcion;
    private ArrayList<Columna> listacolumnas;
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdfila() {
        return idfila;
    }

    public void setIdfila(String idfila) {
        this.idfila = idfila;
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

    public ArrayList<Columna> getListacolumnas() {
        return listacolumnas;
    }

    public void setListacolumnas(ArrayList<Columna> listacolumnas) {
        this.listacolumnas = listacolumnas;
    }

    public String getIdpiso() {
        return idpiso;
    }

    public void setIdpiso(String idpiso) {
        this.idpiso = idpiso;
    }

    public String getIdrack() {
        return idrack;
    }

    public void setIdrack(String idrack) {
        this.idrack = idrack;
    }

    
}
