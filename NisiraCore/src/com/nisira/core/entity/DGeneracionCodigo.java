/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@XStreamAlias("DGENERACIONCODIGOS")
public class DGeneracionCodigo {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDGENERACION")
    private String IDGENERACION;
    @XStreamAlias("IDREGISTROCODIGO")
    private String IDREGISTROCODIGO;
    @XStreamAlias("NUMDIGITO")
    private int NUMDIGITO;
    @XStreamAlias("SINCRONIZADO")
    private int SINCRONIZADO;
    @XStreamAlias("GENERACIONCODIGO")
    private String GENERACIONCODIGO;
    @XStreamAlias("PARAMETRO")
    private String PARAMETRO;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("TIPOVALOR")
    private int TIPOVALOR;
    @XStreamOmitField
    private int seleccionado;
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
     * @return the IDGENERACION
     */
    public String getIDGENERACION() {
        return IDGENERACION;
    }

    /**
     * @param IDGENERACION the IDGENERACION to set
     */
    public void setIDGENERACION(String IDGENERACION) {
        this.IDGENERACION = IDGENERACION;
    }

    /**
     * @return the IDREGISTROCODIGO
     */
    public String getIDREGISTROCODIGO() {
        return IDREGISTROCODIGO;
    }

    /**
     * @param IDREGISTROCODIGO the IDREGISTROCODIGO to set
     */
    public void setIDREGISTROCODIGO(String IDREGISTROCODIGO) {
        this.IDREGISTROCODIGO = IDREGISTROCODIGO;
    }

    /**
     * @return the NUMDIGITO
     */
    public int getNUMDIGITO() {
        return NUMDIGITO;
    }

    /**
     * @param NUMDIGITO the NUMDIGITO to set
     */
    public void setNUMDIGITO(int NUMDIGITO) {
        this.NUMDIGITO = NUMDIGITO;
    }

    /**
     * @return the GENERACIONCODIGO
     */
    public String getGENERACIONCODIGO() {
        return GENERACIONCODIGO;
    }

    /**
     * @param GENERACIONCODIGO the GENERACIONCODIGO to set
     */
    public void setGENERACIONCODIGO(String GENERACIONCODIGO) {
        this.GENERACIONCODIGO = GENERACIONCODIGO;
    }

    /**
     * @return the PARAMETRO
     */
    public String getPARAMETRO() {
        return PARAMETRO;
    }

    /**
     * @param PARAMETRO the PARAMETRO to set
     */
    public void setPARAMETRO(String PARAMETRO) {
        this.PARAMETRO = PARAMETRO;
    }

    public int getSINCRONIZADO() {
        return SINCRONIZADO;
    }

    public void setSINCRONIZADO(int SINCRONIZADO) {
        this.SINCRONIZADO = SINCRONIZADO;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public int getTIPOVALOR() {
        return TIPOVALOR;
    }

    public void setTIPOVALOR(int TIPOVALOR) {
        this.TIPOVALOR = TIPOVALOR;
    }

    public int getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(int seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
