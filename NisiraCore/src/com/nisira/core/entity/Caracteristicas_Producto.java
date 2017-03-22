/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 *
 * @author azamora
 */
@XStreamAlias("CARACTERISTICAS_PRODUCTO")
public class Caracteristicas_Producto {

    @XStreamAlias("IDCARACTERISTICAS")
    private int idcaracteristicas;
    @XStreamAlias("VALOR")
    private int valor;
    @XStreamAlias("DEP_ID")
    private int dep_id;
    @XStreamAlias("DESCRIPCION")
    private String descripcion;
    @XStreamAlias("ABREV")
    private String abrev;
    @XStreamAlias("ESTADO")
    private int estado;
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    public Caracteristicas_Producto() {
    }

    public int getIdcaracteristicas() {
        return idcaracteristicas;
    }

    public void setIdcaracteristicas(int idcaracteristicas) {
        this.idcaracteristicas = idcaracteristicas;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public boolean isBEstado() {
        return this.getEstado() == 1;
    }

    public void setBEstado(boolean band) {
        this.setEstado((band) ? (int) 1 : (int) 0);
    }
}
