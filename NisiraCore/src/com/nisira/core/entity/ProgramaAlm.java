/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author azamora
 */
@XStreamAlias("PROGRAMAALM")
public class ProgramaAlm {
    @XStreamAlias("idempresa")
    private int idempresa;
    @XStreamAlias("idprogramaalm")
    private int idprogramaalm;
    @XStreamAlias("idsucursal")
    private int idsucursal;
    @XStreamAlias("idtipoalmacen")
    private int idtipoalmacen;
    @XStreamAlias("iddocumento")
    private String iddocumento;
    @XStreamAlias("serie")
    private String serie;
    @XStreamAlias("numero")
    private String numero;
    @XStreamAlias("idestado")
    private String idestado;
    @XStreamAlias("idresponsable")
    private int idresponsable;
    @XStreamAlias("fechaprogramacion")
    private Timestamp fechaprogramacion;
    @XStreamAlias("fechaejecucion")
    private Timestamp fechaejecucion;
    @XStreamAlias("fechafinalizacion")
    private Timestamp fechafinalizacion;
    @XStreamAlias("ventana")
    private String ventana;
    @XStreamAlias("fechacreacion")
    private String fechacreacion;
    public ProgramaAlm() {
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdprogramaalm() {
        return idprogramaalm;
    }

    public void setIdprogramaalm(int idprogramaalm) {
        this.idprogramaalm = idprogramaalm;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public int getIdtipoalmacen() {
        return idtipoalmacen;
    }

    public void setIdtipoalmacen(int idtipoalmacen) {
        this.idtipoalmacen = idtipoalmacen;
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

    public String getIdestado() {
        return idestado;
    }

    public void setIdestado(String idestado) {
        this.idestado = idestado;
    }

    public int getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(int idresponsable) {
        this.idresponsable = idresponsable;
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

    public String getVentana() {
        return ventana;
    }

    public void setVentana(String ventana) {
        this.ventana = ventana;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
    
}
