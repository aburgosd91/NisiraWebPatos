/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.List;

/**
 *
 * @author azamora
 */
@XStreamAlias("DREGLALLENADOGENERACION")
public class DreglaLlenadoGeneracion {
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
    @XStreamAlias("DINICIO")
    private int dinicio;
    @XStreamAlias("DFIN")
    private int dfin;
    @XStreamOmitField
    private String parametro;
    private List<DDreglaLlenadoGeneracion> lstddreglallenado;
    
    public DreglaLlenadoGeneracion() {
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

    public int getDinicio() {
        return dinicio;
    }

    public void setDinicio(int dinicio) {
        this.dinicio = dinicio;
    }

    public int getDfin() {
        return dfin;
    }

    public void setDfin(int dfin) {
        this.dfin = dfin;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public List<DDreglaLlenadoGeneracion> getLstddreglallenado() {
        return lstddreglallenado;
    }

    public void setLstddreglallenado(List<DDreglaLlenadoGeneracion> lstddreglallenado) {
        this.lstddreglallenado = lstddreglallenado;
    }

    
    
}
