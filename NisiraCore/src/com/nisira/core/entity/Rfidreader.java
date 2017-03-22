/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.sql.Timestamp;

/**
 *
 * @author azamora
 */
@XStreamAlias("RFIDREADER")
public class Rfidreader {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDEQUIPOREADER")
    private int idequiporeader;
    @XStreamAlias("IDCPUMOVIL")
    private int idcpumovil;
    @XStreamAlias("NROSERIE")
    private String nroserie;
    @XStreamAlias("OBSERVACION")
    private String observacion;
    @XStreamAlias("ESTADO")
    private int estado;
    @XStreamAlias("FECHACREACION")
    private Timestamp fechacreacion;
    @XStreamAlias("ATENUACION")
    private Double atenuacion;
    public Rfidreader() {
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdequiporeader() {
        return idequiporeader;
    }

    public void setIdequiporeader(int idequiporeader) {
        this.idequiporeader = idequiporeader;
    }

    public String getNroserie() {
        return nroserie;
    }

    public void setNroserie(String nroserie) {
        this.nroserie = nroserie;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Timestamp getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Double getAtenuacion() {
        return atenuacion;
    }

    public void setAtenuacion(Double atenuacion) {
        this.atenuacion = atenuacion;
    }
    
    public boolean isBEstado() {
        return this.getEstado()== 1;
    }
    public void setBEstado(boolean band) {
        this.setEstado((band) ? (int) 1 : (int) 0);
    }

    /**
     * @return the idcpumovil
     */
    public int getIdcpumovil() {
        return idcpumovil;
    }

    /**
     * @param idcpumovil the idcpumovil to set
     */
    public void setIdcpumovil(int idcpumovil) {
        this.idcpumovil = idcpumovil;
    }
}
