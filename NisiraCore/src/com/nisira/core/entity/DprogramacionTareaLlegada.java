/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.math.BigInteger;

/**
 *
 * @author azamora
 */
@XStreamAlias("DPROGRAMACIONTAREALLEGADA")
public class DprogramacionTareaLlegada {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDPROGRAMACIONTAREA")
    private String idprogramaciontarea;
    @XStreamAlias("ITEM")
    private int item;
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
    @XStreamOmitField
    private String Descripcion;
    @XStreamOmitField
    private String Proceso;
    @XStreamOmitField
    private String Regla;
    @XStreamOmitField
    private String CodigoBarra;
    public DprogramacionTareaLlegada() {
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

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getProceso() {
        return Proceso;
    }

    public void setProceso(String Proceso) {
        this.Proceso = Proceso;
    }

    public String getRegla() {
        return Regla;
    }

    public void setRegla(String Regla) {
        this.Regla = Regla;
    }

    public String getCodigoBarra() {
        return CodigoBarra;
    }

    public void setCodigoBarra(String CodigoBarra) {
        this.CodigoBarra = CodigoBarra;
    }
    
}
