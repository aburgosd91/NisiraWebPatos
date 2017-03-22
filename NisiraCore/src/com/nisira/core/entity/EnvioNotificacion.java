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
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
@XStreamAlias("ENVIONOTIFICACION")
public class EnvioNotificacion {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDENVIONOTIFICACION")
    private int idenvionotificacion;
    @XStreamAlias("IDNOTIFIACION")
    private int idnotifiacion;
    @XStreamAlias("IDMONTACARGA")
    private String idmontacarga;
    @XStreamAlias("FECHAENVIO")
    private String fechaenvio;
    @XStreamAlias("FECHARECEPCION")
    private String fecharecepcion;
    @XStreamOmitField
    private String montacarga;
    /**
     * @return the idempresa
     */
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
     * @return the idnotifiacion
     */
    public int getIdnotifiacion() {
        return idnotifiacion;
    }

    /**
     * @param idnotifiacion the idnotifiacion to set
     */
    public void setIdnotifiacion(int idnotifiacion) {
        this.idnotifiacion = idnotifiacion;
    }

    /**
     * @return the fechaenvio
     */
    public String getFechaenvio() {
        return fechaenvio;
    }

    /**
     * @param fechaenvio the fechaenvio to set
     */
    public void setFechaenvio(String fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    /**
     * @return the fecharecepcion
     */
    public String getFecharecepcion() {
        return fecharecepcion;
    }

    /**
     * @param fecharecepcion the fecharecepcion to set
     */
    public void setFecharecepcion(String fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }

    /**
     * @return the idenvionotificacion
     */
    public int getIdenvionotificacion() {
        return idenvionotificacion;
    }

    /**
     * @param idenvionotificacion the idenvionotificacion to set
     */
    public void setIdenvionotificacion(int idenvionotificacion) {
        this.idenvionotificacion = idenvionotificacion;
    }

    /**
     * @return the idmontacarga
     */
    public String getIdmontacarga() {
        return idmontacarga;
    }

    /**
     * @param idmontacarga the idmontacarga to set
     */
    public void setIdmontacarga(String idmontacarga) {
        this.idmontacarga = idmontacarga;
    }

    /**
     * @return the montacarga
     */
    public String getMontacarga() {
        return montacarga;
    }

    /**
     * @param montacarga the montacarga to set
     */
    public void setMontacarga(String montacarga) {
        this.montacarga = montacarga;
    }

}
