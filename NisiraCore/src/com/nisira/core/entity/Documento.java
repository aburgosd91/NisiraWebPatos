/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.List;

/**
 *
 * @author Victor Zavala Llanos
 */
@XStreamAlias("Documento")
public class Documento {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDDOCUMENTO")
    private String IDDOCUMENTO;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("VENTANA")
    private String VENTANA;
    @XStreamAlias("IDPROCESO")
    private int IDPROCESO;
    
    private transient List<NumEmisor> listanumemisor;

    public List<NumEmisor> getListanumemisor() {
        return listanumemisor;
    }

    public void setListanumemisor(List<NumEmisor> listanumemisor) {
        this.listanumemisor = listanumemisor;
    }  

    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public String getIDDOCUMENTO() {
        return IDDOCUMENTO;
    }

    public void setIDDOCUMENTO(String IDDOCUMENTO) {
        this.IDDOCUMENTO = IDDOCUMENTO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getVENTANA() {
        return VENTANA;
    }

    public void setVENTANA(String VENTANA) {
        this.VENTANA = VENTANA;
    }

    public int getIDPROCESO() {
        return IDPROCESO;
    }

    public void setIDPROCESO(int IDPROCESO) {
        this.IDPROCESO = IDPROCESO;
    }
    public boolean isBEstado() {
        return this.getESTADO()== 1;
    }

    public void setBEstado(boolean band) {
        this.setESTADO((band) ? (int) 1 : (int) 0);
    }
}
