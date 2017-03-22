/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.sql.Timestamp;

/**
 *
 * @author azamora
 */
@XStreamAlias("DPUERTOCOM")
public class Dpuertocom {

    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDEQUIPOREADER")
    private int idequiporeader;
    @XStreamAlias("IDPUERTOCOM")
    private int idpuertocom;
    @XStreamAlias("ORDEN")
    private int orden;
    @XStreamAlias("ACTIVO")
    private int activo;
    @XStreamAlias("FECHACREACION")
    private Timestamp fechacreacion;
    @XStreamOmitField
    private String descripcion;
    @XStreamAlias("IDCPUMOVIL")
    private int idcpumovil;

    public Dpuertocom() {
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

    public int getIdpuertocom() {
        return idpuertocom;
    }

    public void setIdpuertocom(int idpuertocom) {
        this.idpuertocom = idpuertocom;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Timestamp getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
