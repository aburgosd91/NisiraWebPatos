/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author azamora
 */
@XStreamAlias("REGLA")
public class Reglas {
    @XStreamAlias("idempresa")
    private int idempresa;
    @XStreamAlias("idregla")
    private int idregla;
    @XStreamAlias("descripcion")
    private String descripcion;
    @XStreamAlias("cantidadparametros")
    private int cantidadparametros;
    @XStreamAlias("estado")
    private int estado;
    @XStreamAlias("fechacreacion")
    private String fechacreacion;
    public Reglas() {
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdregla() {
        return idregla;
    }

    public void setIdregla(int idregla) {
        this.idregla = idregla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadparametros() {
        return cantidadparametros;
    }

    public void setCantidadparametros(int cantidadparametros) {
        this.cantidadparametros = cantidadparametros;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
    
}
