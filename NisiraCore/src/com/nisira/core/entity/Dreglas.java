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
@XStreamAlias("DREGLA")
public class Dreglas {
    @XStreamAlias("idempresa")
    private int idempresa;
    @XStreamAlias("idregla")
    private int idregla;
    @XStreamAlias("idparametro")
    private int idparamentro;
    @XStreamAlias("descripcion")
    private String descripcion;
    @XStreamAlias("prioridad")
    private int prioridad;
    @XStreamAlias("tipo")
    private String tipo;
    @XStreamAlias("valor")
    private String valor;
    @XStreamAlias("condicion")
    private String condicion;
    @XStreamAlias("estado")
    private int estado;
    @XStreamAlias("fechacreacion")
    private String fechacreacion;

    public Dreglas() {
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

    public int getIdparamentro() {
        return idparamentro;
    }

    public void setIdparamentro(int idparamentro) {
        this.idparamentro = idparamentro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
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
