/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.util.Date;
import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 *
 * @author Antenor
 */

public class DistribucionUbicacion {    
    private String idempresa;
    private String idcamara;
    private String tipo;
    private ArrayList<Rack> listaracks;
    private ArrayList<Columna> listacolumnas_total;

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

    public ArrayList<Rack> getListaracks() {
        return listaracks;
    }

    public void setListaracks(ArrayList<Rack> listaracks) {
        this.listaracks = listaracks;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Columna> getListacolumnas_total() {
        return listacolumnas_total;
    }

    public void setListacolumnas_total(ArrayList<Columna> listacolumnas_total) {
        this.listacolumnas_total = listacolumnas_total;
    }
    
    
}
