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
public class Pisos implements Serializable{
    private String idempresa;
    private String idcamara;
    private String idpiso;
    private String idrack;
    private String descripcion;
    private ArrayList<Fila> listafilas;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdpiso() {
        return idpiso;
    }

    public void setIdpiso(String idpiso) {
        this.idpiso = idpiso;
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

    public ArrayList<Fila> getListafilas() {
        return listafilas;
    }

    public void setListafilas(ArrayList<Fila> listafilas) {
        this.listafilas = listafilas;
    }

    public String getIdrack() {
        return idrack;
    }

    public void setIdrack(String idrack) {
        this.idrack = idrack;
    }


    
}
