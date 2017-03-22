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
@XStreamAlias("PROCESOS")
public class Procesos {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDPROCESO")
    private int idproceso;
    @XStreamAlias("DESCRIPCION")
    private String descripcion;
    @XStreamAlias("FECHAINICIO")
    private Timestamp fechainicio;
    @XStreamAlias("FECHAFIN")
    private Timestamp fechafin;
    @XStreamAlias("FECHACREACION")
    private Timestamp fechacreacion;
    @XStreamAlias("ESTADO")
    private int estado;

    public Procesos() {
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Timestamp fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Timestamp getFechafin() {
        return fechafin;
    }

    public void setFechafin(Timestamp fechafin) {
        this.fechafin = fechafin;
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
