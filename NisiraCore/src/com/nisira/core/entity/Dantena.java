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
@XStreamAlias("DANTENA")
public class Dantena {

    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDEQUIPOREADER")
    private int idequiporeader;
    @XStreamAlias("IDEQUIPOANTENA")
    private int idequipoantena;
    @XStreamAlias("ORDEN")
    private int orden;
    @XStreamAlias("ACTIVO")
    private int activo;
    @XStreamAlias("FECHACREACION")
    private Timestamp fechacreacion;
    @XStreamOmitField
    private String descripcion;

    public Dantena() {
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

    public int getIdequipoantena() {
        return idequipoantena;
    }

    public void setIdequipoantena(int idequipoantena) {
        this.idequipoantena = idequipoantena;
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

}
