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
@XStreamAlias("DPROGRAMAALMMONTACARGA")
public class DprogAlmMontacarga {
    @XStreamAlias("idempresa")
    private int idempresa;
    @XStreamAlias("idprogramaalm")
    private int idprogramaalm;
    @XStreamAlias("idmontacarga")
    private String idmontacarga;
    @XStreamAlias("fechacreacion")
    private Timestamp fechacreacion;
    @XStreamAlias("notificado")
    private int notificado;
    @XStreamAlias("estado")
    private int estado;
    @XStreamAlias("sincroniza")
    private int sincroniza;
    private Notificacion nota;
    //private transient Montacarga mont;
    public DprogAlmMontacarga() {
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

    public String getIdmontacarga() {
        return idmontacarga;
    }

    public void setIdmontacarga(String idmontacarga) {
        this.idmontacarga = idmontacarga;
    }

    public Timestamp getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public int getNotificado() {
        return notificado;
    }

    public void setNotificado(int notificado) {
        this.notificado = notificado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getSincroniza() {
        return sincroniza;
    }

    public void setSincroniza(int sincroniza) {
        this.sincroniza = sincroniza;
    }
/*
    public Montacarga getMont() {
        return null;
    }

    public void setMont(Montacarga mont) {
        this.mont = mont;
    }
    */

    public Notificacion getNota() {
        return nota;
    }

    public void setNota(Notificacion nota) {
        this.nota = nota;
    }
    
}
