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
@XStreamAlias("DMONTACARGA_OPERARIO")
public class DMontacarga_Operario {
    @XStreamAlias("cIDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("cIDOPERARIO")
    private String IDOPERARIO;
    @XStreamAlias("cIDMONTACARGA")
    private String IDMONTACARGA;
    @XStreamAlias("cIDREGISTRO")
    private String IDREGISTRO;
    @XStreamAlias("cFECHA")
    private String FECHA;

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
     * @return the IDMONTACARGA
     */
    public String getIDMONTACARGA() {
        return IDMONTACARGA;
    }

    /**
     * @param IDMONTACARGA the IDMONTACARGA to set
     */
    public void setIDMONTACARGA(String IDMONTACARGA) {
        this.IDMONTACARGA = IDMONTACARGA;
    }

    /**
     * @return the IDREGISTRO
     */
    public String getIDREGISTRO() {
        return IDREGISTRO;
    }

    /**
     * @param IDREGISTRO the IDREGISTRO to set
     */
    public void setIDREGISTRO(String IDREGISTRO) {
        this.IDREGISTRO = IDREGISTRO;
    }

    /**
     * @return the FECHA
     */
    public String getFECHA() {
        return FECHA;
    }

    /**
     * @param FECHA the FECHA to set
     */
    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }
    
    
}
