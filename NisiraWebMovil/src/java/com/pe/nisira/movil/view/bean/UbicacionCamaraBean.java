/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class UbicacionCamaraBean implements Serializable{
    private String idbasedatos;
    private String idempresa;
    private String idcamara;
    private String desccamara;
    private String nombrecortocamara;
    private String tipocamara;
    private String idubicacion;
    private String tipoubicacion;

    public String getIdbasedatos() {
        return idbasedatos;
    }

    public void setIdbasedatos(String idbasedatos) {
        this.idbasedatos = idbasedatos;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdcamara() {
        return idcamara;
    }

    public void setIdcamara(String idcamara) {
        this.idcamara = idcamara;
    }

    public String getDesccamara() {
        return desccamara;
    }

    public void setDesccamara(String desccamara) {
        this.desccamara = desccamara;
    }

    public String getNombrecortocamara() {
        return nombrecortocamara;
    }

    public void setNombrecortocamara(String nombrecortocamara) {
        this.nombrecortocamara = nombrecortocamara;
    }

    public String getTipocamara() {
        return tipocamara;
    }

    public void setTipocamara(String tipocamara) {
        this.tipocamara = tipocamara;
    }

    public String getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }

    public String getTipoubicacion() {
        return tipoubicacion;
    }

    public void setTipoubicacion(String tipoubicacion) {
        this.tipoubicacion = tipoubicacion;
    }

}
