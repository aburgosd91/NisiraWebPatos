/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DistribucionNivel implements Serializable{
    private String IDRACK;
    private String IDTIPO;
    private String DESCRIPCION;

    /**
     * @return the IDRACK
     */
    public String getIDRACK() {
        return IDRACK;
    }

    /**
     * @param IDRACK the IDRACK to set
     */
    public void setIDRACK(String IDRACK) {
        this.IDRACK = IDRACK;
    }

    /**
     * @return the IDTIPO
     */
    public String getIDTIPO() {
        return IDTIPO;
    }

    /**
     * @param IDTIPO the IDTIPO to set
     */
    public void setIDTIPO(String IDTIPO) {
        this.IDTIPO = IDTIPO;
    }

    /**
     * @return the DESCRIPCION
     */
    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    /**
     * @param DESCRIPCION the DESCRIPCION to set
     */
    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }
}
