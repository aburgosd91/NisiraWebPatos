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
public class DistribucionUbicacionBean implements Serializable{
    private String idempresa;
    private String idcamara;
    private String tipo;
    private ArrayList<RackBean> listaracks;

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

    public ArrayList<RackBean> getListaracks() {
        return listaracks;
    }

    public void setListaracks(ArrayList<RackBean> listaracks) {
        this.listaracks = listaracks;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
