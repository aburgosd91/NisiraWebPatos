/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.nisira.core.dao.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
@XStreamAlias("DACCIONESVISTA")
public class DAccionesVista {
    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDACCION")
    private int IDACCION;
    @XStreamAlias("VISTA")
    private String VISTA;
    @XStreamAlias("ORDEN")
    private int ORDEN;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    
    @XStreamOmitField
    private String ACCIONES;

    /**
     * @return the IDEMPRESA
     */
    public int getIDEMPRESA() {
        return IDEMPRESA;
    }

    /**
     * @param IDEMPRESA the IDEMPRESA to set
     */
    public void setIDEMPRESA(int IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    /**
     * @return the IDACCION
     */
    public int getIDACCION() {
        return IDACCION;
    }

    /**
     * @param IDACCION the IDACCION to set
     */
    public void setIDACCION(int IDACCION) {
        this.IDACCION = IDACCION;
    }

    /**
     * @return the VISTA
     */
    public String getVISTA() {
        return VISTA;
    }

    /**
     * @param VISTA the VISTA to set
     */
    public void setVISTA(String VISTA) {
        this.VISTA = VISTA;
    }

    /**
     * @return the ORDEN
     */
    public int getORDEN() {
        return ORDEN;
    }

    /**
     * @param ORDEN the ORDEN to set
     */
    public void setORDEN(int ORDEN) {
        this.ORDEN = ORDEN;
    }

    /**
     * @return the FECHACREACION
     */
    public String getFECHACREACION() {
        return FECHACREACION;
    }

    /**
     * @param FECHACREACION the FECHACREACION to set
     */
    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    /**
     * @return the ACCIONES
     */
    public String getACCIONES() {
        return ACCIONES;
    }

    /**
     * @param ACCIONES the ACCIONES to set
     */
    public void setACCIONES(String ACCIONES) {
        this.ACCIONES = ACCIONES;
    }

}
