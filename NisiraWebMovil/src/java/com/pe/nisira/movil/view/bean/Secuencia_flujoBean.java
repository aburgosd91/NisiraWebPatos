/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Antenor
 */

public class Secuencia_flujoBean implements Serializable{
    private String idempresa;
    private String formulario_origen;
    private String secuencia;
    private String idestado;
    private String iddocumento;
    private double aplicapresu;
    private String formulario_destino;
    private String docum_destino;

    public Secuencia_flujoBean() {
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getFormulario_origen() {
        return formulario_origen;
    }

    public void setFormulario_origen(String formulario_origen) {
        this.formulario_origen = formulario_origen;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getIdestado() {
        return idestado;
    }

    public void setIdestado(String idestado) {
        this.idestado = idestado;
    }

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    public double getAplicapresu() {
        return aplicapresu;
    }

    public void setAplicapresu(double aplicapresu) {
        this.aplicapresu = aplicapresu;
    }

    public String getFormulario_destino() {
        return formulario_destino;
    }

    public void setFormulario_destino(String formulario_destino) {
        this.formulario_destino = formulario_destino;
    }

    public String getDocum_destino() {
        return docum_destino;
    }

    public void setDocum_destino(String docum_destino) {
        this.docum_destino = docum_destino;
    }
    
    
}
