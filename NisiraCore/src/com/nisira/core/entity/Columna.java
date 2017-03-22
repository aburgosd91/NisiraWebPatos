/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class Columna implements Serializable{
    private String idempresa;
    private String idcamara;
    private String idcoluma;
    private String descripcion;
    private int nrofilas;
    private int nrocolumnas;
    private String flagubicacion;
    private String idrack;
    private String idpiso;
    private String idfila;
    
    private String nropaleta;
    private String tipoubicacion;
    private String idubicacion;
    private String idpaleta;
    private String idcliente;
    private String idmotivo;
    private Integer factor;
    private String idproducto;
    private Double cantidad;
    private String idenvase;
    private String idproductor;
    private String idlotep;
    private String observacion;
    private String idusuario;   
    private String descubicacion;
    private String desccliente;
    private String descvariedad;
    private String descenvase;
    private String desccategorias;    
    private String desccalibres;
    private String desccamara;
    private Timestamp fechaingreso;
    private String descfechaingreso;
    private String color;
    
    private String codigocliente;
    private Boolean visible;

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdcoluma() {
        return idcoluma;
    }

    public void setIdcoluma(String idcoluma) {
        this.idcoluma = idcoluma;
    }

    public String getIdcamara() {
        return idcamara;
    }

    public void setIdcamara(String idcamara) {
        this.idcamara = idcamara;
    }

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

    public String getIdfila() {
        return idfila;
    }

    public void setIdfila(String idfila) {
        this.idfila = idfila;
    }

    public String getIdpiso() {
        return idpiso;
    }

    public void setIdpiso(String idpiso) {
        this.idpiso = idpiso;
    }

    public String getIdrack() {
        return idrack;
    }

    public void setIdrack(String idrack) {
        this.idrack = idrack;
    }

    public int getNrofilas() {
        return nrofilas;
    }

    public void setNrofilas(int nrofilas) {
        this.nrofilas = nrofilas;
    }

    public String getFlagubicacion() {
        return flagubicacion;
    }

    public void setFlagubicacion(String flagubicacion) {
        this.flagubicacion = flagubicacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(String codigocliente) {
        this.codigocliente = codigocliente;
    }

    public int getNrocolumnas() {
        return nrocolumnas;
    }

    public void setNrocolumnas(int nrocolumnas) {
        this.nrocolumnas = nrocolumnas;
    }

    public String getDesccamara() {
        return desccamara;
    }

    public void setDesccamara(String desccamara) {
        this.desccamara = desccamara;
    }

    public Timestamp getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Timestamp fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    
    public String getDescfechaingreso() {
        return this.descfechaingreso;
    }

    public void setDescfechaingreso(String descfechaingreso) {
        this.descfechaingreso = descfechaingreso;
    }

     
}

