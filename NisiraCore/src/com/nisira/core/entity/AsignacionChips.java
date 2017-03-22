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
@XStreamAlias("ASIGNACIONCHIPS")
public class AsignacionChips {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDASIGNACIONCHIPS")
    private String idasignacionchips;
    @XStreamAlias("IDZONA")
    private int idzona;
    @XStreamAlias("GINICIO")
    private String ginicio;
    @XStreamAlias("GFIN")
    private String gfin;
    @XStreamAlias("NUMTAG")
    private int numtag;
    @XStreamAlias("OBSERVACION")
    private String observacion;
    @XStreamAlias("ESTADO")
    private int estado;
    @XStreamAlias("FECHACREACION")
    private Timestamp fechacreacion;
    @XStreamAlias("USRCREACION")
    private String usrcreacion;

    public AsignacionChips() {
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getIdasignacionchips() {
        return idasignacionchips;
    }

    public void setIdasignacionchips(String idasignacionchips) {
        this.idasignacionchips = idasignacionchips;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    public String getGinicio() {
        return ginicio;
    }

    public void setGinicio(String ginicio) {
        this.ginicio = ginicio;
    }

    public String getGfin() {
        return gfin;
    }

    public void setGfin(String gfin) {
        this.gfin = gfin;
    }

    public int getNumtag() {
        return numtag;
    }

    public void setNumtag(int numtag) {
        this.numtag = numtag;
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

    public String getUsrcreacion() {
        return usrcreacion;
    }

    public void setUsrcreacion(String usrcreacion) {
        this.usrcreacion = usrcreacion;
    }
    
    
}
