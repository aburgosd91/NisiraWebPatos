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
@XStreamAlias("PUERTOCOM")
public class Puertocom {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDPUERTOCOM")
    private int idpuertocom;
    @XStreamAlias("DESCRIPCION")
    private String descripcion;
    @XStreamAlias("FECHACREACION")
    private Timestamp fechacreacion;
    @XStreamAlias("ESTADO")
    private int estado;

    public Puertocom() {
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdpuertocom() {
        return idpuertocom;
    }

    public void setIdpuertocom(int idpuertocom) {
        this.idpuertocom = idpuertocom;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
