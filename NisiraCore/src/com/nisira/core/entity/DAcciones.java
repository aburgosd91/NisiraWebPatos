/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 *
 * @author aburgos
 */
@XStreamAlias("DACCION")
public class DAcciones {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDACCION")
    private int idaccion;
    @XStreamAlias("IDACTIVIDADES")
    private int idactividades;
    @XStreamAlias("DATOS")
    private int datos;
    @XStreamAlias("ORDEN")
    private int orden;
    @XStreamAlias("METHODAUT")
    private String METHODAUT;
    @XStreamAlias("METHODMAN")
    private String METHODMAN;
    @XStreamOmitField
    private String accion;
    @XStreamOmitField
    private String actividades;
    @XStreamOmitField
    private String xmldactividades;
    /**
     * @return the idempresa
     */
    public DAcciones(int idempresa, int idaccion, int idactividades){
        this.idempresa=idempresa;
        this.idaccion=idaccion;
        this.idactividades=idactividades;
    }

    public DAcciones() {
        
    }
    public int getIdempresa() {
        return idempresa;
    }

    /**
     * @param idempresa the idempresa to set
     */
    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    /**
     * @return the idactividades
     */
    public int getIdactividades() {
        return idactividades;
    }

    /**
     * @param idactividades the idactividades to set
     */
    public void setIdactividades(int idactividades) {
        this.idactividades = idactividades;
    }

    /**
     * @return the idaccion
     */
    public int getIdaccion() {
        return idaccion;
    }

    /**
     * @param idaccion the idaccion to set
     */
    public void setIdaccion(int idaccion) {
        this.idaccion = idaccion;
    }

    /**
     * @return the datos
     */
    public int getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(int datos) {
        this.datos = datos;
    }

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the actividades
     */
    public String getActividades() {
        return actividades;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    /**
     * @return the xmldactividades
     */
    public String getXmldactividades() {
        return xmldactividades;
    }

    /**
     * @param xmldactividades the xmldactividades to set
     */
    public void setXmldactividades(String xmldactividades) {
        this.xmldactividades = xmldactividades;
    }

    /**
     * @return the METHOD
     */
    public String getMETHODAUT() {
        return METHODAUT;
    }

    /**
     * @param METHOD the METHOD to set
     */
    public void setMETHODAUT(String METHODAUT) {
        this.METHODAUT = METHODAUT;
    }

    /**
     * @return the METHODMAN
     */
    public String getMETHODMAN() {
        return METHODMAN;
    }

    /**
     * @param METHODMAN the METHODMAN to set
     */
    public void setMETHODMAN(String METHODMAN) {
        this.METHODMAN = METHODMAN;
    }
}
