/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class PisosBean implements Serializable{
    private String idempresa;
    private String idcamara;
    private String idpiso;
    private String descripcion;
    private ArrayList<FilaBean> listafilas;

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

    public ArrayList<FilaBean> getListafilas() {
        return listafilas;
    }

    public void setListafilas(ArrayList<FilaBean> listafilas) {
        this.listafilas = listafilas;
    }


    
}
