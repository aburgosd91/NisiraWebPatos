/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.util.Date;
import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Antenor
 */

public class MovUbicacionPaleta {
    @SerializedName("idbasedatos")
    private String idbasedatos;

    @SerializedName("idempresa")
    private String idempresa;

    @SerializedName("nropaleta")
    private String nropaleta;

    @SerializedName("tipoubicacion")
    private String tipoubicacion;

    @SerializedName("idubicacion")
    private String idubicacion;

    @SerializedName("idpaleta")
    private String idpaleta;

    @SerializedName("idcliente")
    private String idcliente;

    @SerializedName("idmotivo")
    private String idmotivo;

    @SerializedName("factor")
    private Integer factor;

    @SerializedName("idproducto")
    private String idproducto;

    @SerializedName("cantidad")
    private Double cantidad;

    @SerializedName("idenvase")
    private String idenvase;

    @SerializedName("idproductor")
    private String idproductor;

    @SerializedName("idlotep")
    private String idlotep;

    @SerializedName("observacion")
    private String observacion;

    @SerializedName("idusuario")
    private String idusuario;

    @SerializedName("desc_ubicacion")
    private String descubicacion;

    @SerializedName("desc_cliente")
    private String desccliente;

    @SerializedName("desc_variedad")
    private String descvariedad;

    @SerializedName("desc_envase")
    private String descenvase;

    @SerializedName("desc_categorias")
    private String desccategorias;

    @SerializedName("desc_calibres")
    private String desccalibres;

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDesccalibres() {
        return desccalibres;
    }

    public void setDesccalibres(String desccalibres) {
        this.desccalibres = desccalibres;
    }

    public String getDesccategorias() {
        return desccategorias;
    }

    public void setDesccategorias(String desccategorias) {
        this.desccategorias = desccategorias;
    }

    public String getDesccliente() {
        return desccliente;
    }

    public void setDesccliente(String desccliente) {
        this.desccliente = desccliente;
    }

    public String getDescenvase() {
        return descenvase;
    }

    public void setDescenvase(String descenvase) {
        this.descenvase = descenvase;
    }

    public String getDescubicacion() {
        return descubicacion;
    }

    public void setDescubicacion(String descubicacion) {
        this.descubicacion = descubicacion;
    }

    public String getDescvariedad() {
        return descvariedad;
    }

    public void setDescvariedad(String descvariedad) {
        this.descvariedad = descvariedad;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    public String getIdbasedatos() {
        return idbasedatos;
    }

    public void setIdbasedatos(String idbasedatos) {
        this.idbasedatos = idbasedatos;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdenvase() {
        return idenvase;
    }

    public void setIdenvase(String idenvase) {
        this.idenvase = idenvase;
    }

    public String getIdlotep() {
        return idlotep;
    }

    public void setIdlotep(String idlotep) {
        this.idlotep = idlotep;
    }

    public String getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(String idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getIdpaleta() {
        return idpaleta;
    }

    public void setIdpaleta(String idpaleta) {
        this.idpaleta = idpaleta;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getIdproductor() {
        return idproductor;
    }

    public void setIdproductor(String idproductor) {
        this.idproductor = idproductor;
    }

    public String getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNropaleta() {
        return nropaleta;
    }

    public void setNropaleta(String nropaleta) {
        this.nropaleta = nropaleta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoubicacion() {
        return tipoubicacion;
    }

    public void setTipoubicacion(String tipoubicacion) {
        this.tipoubicacion = tipoubicacion;
    }
        
    
}
