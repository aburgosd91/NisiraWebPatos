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
@XStreamAlias("ZONAGENERAL")
public class ZonaGeneral {
    private int IDEMPRESA;
    private int IDSUCURSAL;
    private int IDZONAGENERAL;
    private int AREA;
    private int LARGO;
    private int ANCHO;
    private String FECHACREACION;
    private String CODIGOEQUIVALENTE;
    private Integer ESTADO;
    private int SINCRONIZA;
    private String SUCURSAL;
    
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

    public int getIDZONAGENERAL() {
        return IDZONAGENERAL;
    }

    public void setIDZONAGENERAL(int IDZONAGENERAL) {
        this.IDZONAGENERAL = IDZONAGENERAL;
    }

    public int getAREA() {
        return AREA;
    }

    public void setAREA(int AREA) {
        this.AREA = AREA;
    }

    public int getLARGO() {
        return LARGO;
    }

    public void setLARGO(int LARGO) {
        this.LARGO = LARGO;
    }

    public int getANCHO() {
        return ANCHO;
    }

    public void setANCHO(int ANCHO) {
        this.ANCHO = ANCHO;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public String getCODIGOEQUIVALENTE() {
        return CODIGOEQUIVALENTE;
    }

    public void setCODIGOEQUIVALENTE(String CODIGOEQUIVALENTE) {
        this.CODIGOEQUIVALENTE = CODIGOEQUIVALENTE;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public int getSINCRONIZA() {
        return SINCRONIZA;
    }

    public void setSINCRONIZA(int SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
    }

    public String getSUCURSAL() {
        return SUCURSAL;
    }

    public void setSUCURSAL(String SUCURSAL) {
        this.SUCURSAL = SUCURSAL;
    }    
}
