/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author aburgos
 */
@XStreamAlias("NOTIFICACION")
public class Notificacion {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDNOTIFICACION")
    private int idnotificacion;
    @XStreamAlias("MENSAJE")
    private String mensaje;
    @XStreamAlias("TOQUEN")
    private String toquen;
    @XStreamAlias("FECHACREACION")
    private String fechacreacion;
    @XStreamAlias("PRIORIDAD")
    private int prioridad;
    @XStreamAlias("ESTADO")
    private int estado;
    @XStreamAlias("MODO")
    private String modo;
    
    public Notificacion() {
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdnotificacion() {
        return idnotificacion;
    }

    public void setIdnotificacion(int idnotificacion) {
        this.idnotificacion = idnotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the toquen
     */
    public String getToquen() {
        return toquen;
    }

    /**
     * @param toquen the toquen to set
     */
    public void setToquen(String toquen) {
        this.toquen = toquen;
    }

    /**
     * @return the modo
     */
    public String getModo() {
        return modo;
    }

    /**
     * @param modo the modo to set
     */
    public void setModo(String modo) {
        this.modo = modo;
    }

    
}
