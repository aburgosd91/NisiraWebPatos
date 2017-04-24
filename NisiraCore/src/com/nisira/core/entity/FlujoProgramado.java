/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author gcalderon
 */
@XStreamAlias("ACCIONES")
public class FlujoProgramado {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDACCION")
    private int idaccion;
    @XStreamAlias("DESCRIPCION")
    private String descripcion;
    @XStreamAlias("IDPROCESO")
    private int idproceso;
    @XStreamAlias("ORDEN")
    private int orden;
    @XStreamAlias("FECHA")
    private String fecha;
    @XStreamAlias("ESTADO")
    private int estado;

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
     * @return the idaccion
     */
    public int getIdaccion() {
        return idaccion;
    }

    /**
     * @param idaccion the idaccion to set
     */
    public void setIdaccion(int idaccion) {
        this.idaccion = idaccion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the idproceso
     */
    public int getIdproceso() {
        return idproceso;
    }

    /**
     * @param idproceso the idproceso to set
     */
    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }
}
