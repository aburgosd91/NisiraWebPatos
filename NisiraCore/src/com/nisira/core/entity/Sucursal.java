/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@XStreamAlias("Sucursal")
public class Sucursal {
    @XStreamAlias("cIDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("cIDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("cDISTRIBUIR")
    private String DISTRIBUIR;
    @XStreamAlias("cE_MAIL")
    private String E_MAIL;
    @XStreamAlias("cDIRECCION")
    private String DIRECCION;
    @XStreamAlias("cDESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("cESTADO")
    private Boolean ESTADO;
    @XStreamAlias("cSINCRONIZA")
    private String SINCRONIZA;
    @XStreamAlias("cFECHACREACION")
    private String FECHACREACION;

    /**
     * @return the IDEMPRESA
     */
    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    /**
     * @param IDEMPRESA the IDEMPRESA to set
     */
    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    /**
     * @return the IDSUCURSAL
     */
    public String getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    /**
     * @param IDSUCURSAL the IDSUCURSAL to set
     */
    public void setIDSUCURSAL(String IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    /**
     * @return the DISTRIBUIR
     */
    public String getDISTRIBUIR() {
        return DISTRIBUIR;
    }

    /**
     * @param DISTRIBUIR the DISTRIBUIR to set
     */
    public void setDISTRIBUIR(String DISTRIBUIR) {
        this.DISTRIBUIR = DISTRIBUIR;
    }

    /**
     * @return the E_MAIL
     */
    public String getE_MAIL() {
        return E_MAIL;
    }

    /**
     * @param E_MAIL the E_MAIL to set
     */
    public void setE_MAIL(String E_MAIL) {
        this.E_MAIL = E_MAIL;
    }

    /**
     * @return the DIRECCION
     */
    public String getDIRECCION() {
        return DIRECCION;
    }

    /**
     * @param DIRECCION the DIRECCION to set
     */
    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
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

    /**
     * @return the ESTADO
     */

    /**
     * @return the SINCRONIZA
     */
    public String getSINCRONIZA() {
        return SINCRONIZA;
    }

    /**
     * @param SINCRONIZA the SINCRONIZA to set
     */
    public void setSINCRONIZA(String SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
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
     * @return the ESTADO
     */
    public boolean isESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }
}
