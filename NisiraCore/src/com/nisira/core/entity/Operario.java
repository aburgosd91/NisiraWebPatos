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
@XStreamAlias("OPERARIO")
public class Operario {
    @XStreamAlias("cIDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("cIDOPERARIO")
    private String IDOPERARIO;
    @XStreamAlias("cAP_PATERNO")
    private String AP_PATERNO;
    @XStreamAlias("cAP_MATERNO")
    private String AP_MATERNO;
    @XStreamAlias("cNOMBRES")
    private String NOMBRES;
    @XStreamAlias("cBREVETE")
    private String BREVETE;
    @XStreamAlias("cESTADO")
    private boolean ESTADO;

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
     * @return the IDOPERARIO
     */
    public String getIDOPERARIO() {
        return IDOPERARIO;
    }

    /**
     * @param IDOPERARIO the IDOPERARIO to set
     */
    public void setIDOPERARIO(String IDOPERARIO) {
        this.IDOPERARIO = IDOPERARIO;
    }

    /**
     * @return the AP_PATERNO
     */
    public String getAP_PATERNO() {
        return AP_PATERNO;
    }

    /**
     * @param AP_PATERNO the AP_PATERNO to set
     */
    public void setAP_PATERNO(String AP_PATERNO) {
        this.AP_PATERNO = AP_PATERNO;
    }

    /**
     * @return the AP_MATERNO
     */
    public String getAP_MATERNO() {
        return AP_MATERNO;
    }

    /**
     * @param AP_MATERNO the AP_MATERNO to set
     */
    public void setAP_MATERNO(String AP_MATERNO) {
        this.AP_MATERNO = AP_MATERNO;
    }

    /**
     * @return the NOMBRES
     */
    public String getNOMBRES() {
        return NOMBRES;
    }

    /**
     * @param NOMBRES the NOMBRES to set
     */
    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    /**
     * @return the BREVETE
     */
    public String getBREVETE() {
        return BREVETE;
    }

    /**
     * @param BREVETE the BREVETE to set
     */
    public void setBREVETE(String BREVETE) {
        this.BREVETE = BREVETE;
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
