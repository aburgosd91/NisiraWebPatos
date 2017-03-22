/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.sql.Timestamp;

/**
 *
 * @author azamora
 */
@XStreamAlias("PROGRAMACIONTAREA")
public class ProgramacionTarea {

    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDPROGRAMACIONTAREA")
    private String idprogramaciontarea;
    @XStreamAlias("IDPROCESO")
    private int idproceso;
    @XStreamAlias("IDDOCUMENTO")
    private String iddocumento;
    @XStreamAlias("SERIE")
    private String serie;
    @XStreamAlias("NUMERO")
    private String numero;
    @XStreamAlias("TIPOTAREA")
    private int tipotarea;
    @XStreamAlias("GENERACION")
    private int generacion;
    @XStreamAlias("IDMONTACARGA")
    private int IDMONTACARGA;    
    @XStreamAlias("OBSERVACION")
    private String observacion;
    @XStreamAlias("FECHAPROGRAMACION")
    private Timestamp fechaprogramacion;
    @XStreamAlias("FECHAEJECUCION")
    private Timestamp fechaejecucion;
    @XStreamAlias("FECHAFINALIZACION")
    private Timestamp fechafinalizacion;
    @XStreamAlias("ESTADO")
    private int estado;
    @XStreamAlias("USRCREACION")
    private String usrcreacion;

    public ProgramacionTarea() {
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

    public String getIdprogramaciontarea() {
        return idprogramaciontarea;
    }

    public void setIdprogramaciontarea(String idprogramaciontarea) {
        this.idprogramaciontarea = idprogramaciontarea;
    }

    public int getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTipotarea() {
        return tipotarea;
    }

    public void setTipotarea(int tipotarea) {
        this.tipotarea = tipotarea;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getIDMONTACARGA() {
        return IDMONTACARGA;
    }

    public void setIDMONTACARGA(int IDMONTACARGA) {
        this.IDMONTACARGA = IDMONTACARGA;
    }


    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Timestamp getFechaprogramacion() {
        return fechaprogramacion;
    }

    public void setFechaprogramacion(Timestamp fechaprogramacion) {
        this.fechaprogramacion = fechaprogramacion;
    }

    public Timestamp getFechaejecucion() {
        return fechaejecucion;
    }

    public void setFechaejecucion(Timestamp fechaejecucion) {
        this.fechaejecucion = fechaejecucion;
    }

    public Timestamp getFechafinalizacion() {
        return fechafinalizacion;
    }

    public void setFechafinalizacion(Timestamp fechafinalizacion) {
        this.fechafinalizacion = fechafinalizacion;
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

    public boolean isBEstado() {
        return this.getEstado() == 1;
    }

    public void setBEstado(boolean band) {
        this.setEstado((band) ? (int) 1 : (int) 0);
    }
}
