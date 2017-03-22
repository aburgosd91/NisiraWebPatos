/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.io.Serializable;


/**
 *
 * @author JLuisCQ
 */
public class Correos implements Serializable {
    private String cUsuario;
    private String cNombre;
    private String cCorreo;
    private String cEmpresa;
    private boolean bSelec;
    private Integer iHabilitado;

    public Correos() {
    }

    public Integer getIHabilitado() {
        return iHabilitado;
    }

    public void setIHabilitado(Integer iHabilitado) {
        this.iHabilitado = iHabilitado;
    }

    public boolean isBSelec() {
        return bSelec;
    }

    public void setBSelec(boolean bSelec) {
        this.bSelec = bSelec;
    }

    public String getCCorreo() {
        return cCorreo;
    }

    public void setCCorreo(String cCorreo) {
        this.cCorreo = cCorreo;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getCUsuario() {
        return cUsuario;
    }

    public void setCUsuario(String cUsuario) {
        this.cUsuario = cUsuario;
    }

    public String getCEmpresa() {
        return cEmpresa;
    }

    public void setCEmpresa(String cEmpresa) {
        this.cEmpresa = cEmpresa;
    }

    
}
