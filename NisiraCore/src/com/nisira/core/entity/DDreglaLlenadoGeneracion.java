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
@XStreamAlias("DDREGLALLENADOGENERACION")
public class DDreglaLlenadoGeneracion {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDREGLAS")
    private String idreglas;
    @XStreamAlias("IDGENERACION")
    private int idgeneracion;
    @XStreamAlias("IDREGISTROCODIGO")
    private int idregistrocodigo;
    @XStreamAlias("ITEM")
    private int item;
    @XStreamAlias("VALOR")
    private String valor;

    public DDreglaLlenadoGeneracion() {
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

    public String getIdreglas() {
        return idreglas;
    }

    public void setIdreglas(String idreglas) {
        this.idreglas = idreglas;
    }

    public int getIdgeneracion() {
        return idgeneracion;
    }

    public void setIdgeneracion(int idgeneracion) {
        this.idgeneracion = idgeneracion;
    }

    public int getIdregistrocodigo() {
        return idregistrocodigo;
    }

    public void setIdregistrocodigo(int idregistrocodigo) {
        this.idregistrocodigo = idregistrocodigo;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
