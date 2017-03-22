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
@XStreamAlias("DPaleta")
public class Dpaleta {
    @XStreamAlias("cidempresa")
    private int idempresa;
    @XStreamAlias("cidregistropaleta")
    private String idregistropaleta;
    @XStreamAlias("citem")
    private String item;
    @XStreamAlias("cidclieprov")
    private String idclieprov;
    @XStreamAlias("cidlote")
    private String idlote;
    @XStreamAlias("cidcondicion")
    private String idcondicion;
    @XStreamAlias("cidtalla")
    private String idtalla;
    @XStreamAlias("cidcolor")
    private String idcolor;
    @XStreamAlias("ccantidad")
    private double cantidad;
    @XStreamAlias("cidembalaje")
    private String idembalaje;
    @XStreamAlias("cidproducto")
    private String idproducto;
    @XStreamAlias("cidlotep")
    private String idlotep;
    @XStreamAlias("cidconsumidor")
    private String idconsumidor;
    @XStreamAlias("cidlotecampo")
    private String idlotecampo;
    @XStreamAlias("cidpresentacion")
    private String idpresentacion;

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdregistropaleta() {
        return idregistropaleta;
    }

    public void setIdregistropaleta(String idregistropaleta) {
        this.idregistropaleta = idregistropaleta;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getIdclieprov() {
        return idclieprov;
    }

    public void setIdclieprov(String idclieprov) {
        this.idclieprov = idclieprov;
    }

    public String getIdlote() {
        return idlote;
    }

    public void setIdlote(String idlote) {
        this.idlote = idlote;
    }

    public String getIdcondicion() {
        return idcondicion;
    }

    public void setIdcondicion(String idcondicion) {
        this.idcondicion = idcondicion;
    }

    public String getIdtalla() {
        return idtalla;
    }

    public void setIdtalla(String idtalla) {
        this.idtalla = idtalla;
    }

    public String getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(String idcolor) {
        this.idcolor = idcolor;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdembalaje() {
        return idembalaje;
    }

    public void setIdembalaje(String idembalaje) {
        this.idembalaje = idembalaje;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getIdlotep() {
        return idlotep;
    }

    public void setIdlotep(String idlotep) {
        this.idlotep = idlotep;
    }

    public String getIdconsumidor() {
        return idconsumidor;
    }

    public void setIdconsumidor(String idconsumidor) {
        this.idconsumidor = idconsumidor;
    }

    public String getIdlotecampo() {
        return idlotecampo;
    }

    public void setIdlotecampo(String idlotecampo) {
        this.idlotecampo = idlotecampo;
    }

    public String getIdpresentacion() {
        return idpresentacion;
    }

    public void setIdpresentacion(String idpresentacion) {
        this.idpresentacion = idpresentacion;
    }
    
}
