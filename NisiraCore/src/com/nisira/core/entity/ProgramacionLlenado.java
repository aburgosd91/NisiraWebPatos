/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.sql.Timestamp;

/**
 *
 * @author azamora
 */
@XStreamAlias("PROGRAMACIONLLENADO")
public class ProgramacionLlenado {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDPROGRAMACIONLLENADO")
    private String idprogramacionllenado;
    @XStreamAlias("IDPROCESO")
    private int idproceso;
    @XStreamAlias("IDFORMA")
    private int idforma;
    @XStreamAlias("IDGENERACION")
    private int idgeneracion;
    @XStreamAlias("IDREGLAS")
    private String idreglas;
    @XStreamAlias("FINICIO")
    private Timestamp finicio;
    @XStreamAlias("FFIN")
    private Timestamp ffin;
    @XStreamAlias("ESTADO")
    private int estado;
    @XStreamAlias("USRCREACION")
    private String usrcreacion;
    @XStreamAlias("FECHACREACION")
    private Timestamp fechacreacion;
    @XStreamAlias("DESCRIPCION")
    private String descripcion;
    @XStreamOmitField
    private String PROCESO;
    @XStreamOmitField
    private String REGLA;
    @XStreamOmitField
    private String CODIGOBARRA;
    public ProgramacionLlenado() {
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

    public String getIdprogramacionllenado() {
        return idprogramacionllenado;
    }

    public void setIdprogramacionllenado(String idprogramacionllenado) {
        this.idprogramacionllenado = idprogramacionllenado;
    }

    public int getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }

    public int getIdforma() {
        return idforma;
    }

    public void setIdforma(int idforma) {
        this.idforma = idforma;
    }

    public int getIdgeneracion() {
        return idgeneracion;
    }

    public void setIdgeneracion(int idgeneracion) {
        this.idgeneracion = idgeneracion;
    }

    public String getIdreglas() {
        return idreglas;
    }

    public void setIdreglas(String idreglas) {
        this.idreglas = idreglas;
    }

    public Timestamp getFinicio() {
        return finicio;
    }

    public void setFinicio(Timestamp finicio) {
        this.finicio = finicio;
    }

    public Timestamp getFfin() {
        return ffin;
    }

    public void setFfin(Timestamp ffin) {
        this.ffin = ffin;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUsrcreacion() {
        return usrcreacion;
    }

    public void setUsrcreacion(String usrcreacion) {
        this.usrcreacion = usrcreacion;
    }

    public Timestamp getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPROCESO() {
        return PROCESO;
    }

    public void setPROCESO(String PROCESO) {
        this.PROCESO = PROCESO;
    }

    public String getREGLA() {
        return REGLA;
    }

    public void setREGLA(String REGLA) {
        this.REGLA = REGLA;
    }
    
    public boolean isBEstado() {
        return this.getEstado()== 1;
    }

    public String getCODIGOBARRA() {
        return CODIGOBARRA;
    }

    public void setCODIGOBARRA(String CODIGOBARRA) {
        this.CODIGOBARRA = CODIGOBARRA;
    }

    public void setBEstado(boolean band) {
        this.setEstado((band) ? (int) 1 : (int) 0);
    }
}
