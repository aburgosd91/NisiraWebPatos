/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author aburgos
 */
@XStreamAlias("TABLASINCRONIZA")
public class TablaSincroniza {
    private String TABLA;
    private int PENDIENTES;
    private int AFECTADOS;

    public String getTABLA() {
        return TABLA;
    }

    public void setTABLA(String TABLA) {
        this.TABLA = TABLA;
    }

    public int getPENDIENTES() {
        return PENDIENTES;
    }

    public void setPENDIENTES(int PENDIENTES) {
        this.PENDIENTES = PENDIENTES;
    }

    public int getAFECTADOS() {
        return AFECTADOS;
    }

    public void setAFECTADOS(int AFECTADOS) {
        this.AFECTADOS = AFECTADOS;
    }
}
