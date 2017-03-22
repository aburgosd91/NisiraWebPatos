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
@XStreamAlias("SINCRONIZA")
public class SINCRONIZA {

    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private int IDSUCURSAL;
    @XStreamAlias("IDSINCRONIZA")
    private int IDSINCRONIZA;
    @XStreamAlias("IDUSUARIO")
    private String IDUSUARIO;
    @XStreamAlias("LOGSEGUIMIENTO")
    private String LOGSEGUIMIENTO;
    @XStreamAlias("TIPO")
    private int TIPO;    
    @XStreamAlias("FECHAINICIO")
    private String FECHAINICIO;
    @XStreamAlias("FECHAFIN")
    private String FECHAFIN;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;

    public SINCRONIZA() {
    }

    public int getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(int IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public int getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    public void setIDSUCURSAL(int IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    public int getIDSINCRONIZA() {
        return IDSINCRONIZA;
    }

    public void setIDSINCRONIZA(int IDSINCRONIZA) {
        this.IDSINCRONIZA = IDSINCRONIZA;
    }

    public String getIDUSUARIO() {
        return IDUSUARIO;
    }

    public void setIDUSUARIO(String IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    public String getLOGSEGUIMIENTO() {
        return LOGSEGUIMIENTO;
    }

    public void setLOGSEGUIMIENTO(String LOGSEGUIMIENTO) {
        this.LOGSEGUIMIENTO = LOGSEGUIMIENTO;
    }

    public int getTIPO() {
        return TIPO;
    }

    public void setTIPO(int TIPO) {
        this.TIPO = TIPO;
    }

    public String getFECHAINICIO() {
        return FECHAINICIO;
    }

    public void setFECHAINICIO(String FECHAINICIO) {
        this.FECHAINICIO = FECHAINICIO;
    }

    public String getFECHAFIN() {
        return FECHAFIN;
    }

    public void setFECHAFIN(String FECHAFIN) {
        this.FECHAFIN = FECHAFIN;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }  
}
