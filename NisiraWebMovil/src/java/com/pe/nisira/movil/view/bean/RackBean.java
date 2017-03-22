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
public class RackBean implements Serializable{
    private String idempresa;
    private String idcamara;
    private String idrack;
    private String descripcion;
    private ArrayList<PisosBean> listapisos;

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

    public ArrayList<PisosBean> getListapisos() {
        return listapisos;
    }

    public void setListapisos(ArrayList<PisosBean> listapisos) {
        this.listapisos = listapisos;
    }

    
    
}
