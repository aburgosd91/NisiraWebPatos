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
@XStreamAlias("DASIGNACIONCHIPS")
public class DAsignacionChips {

    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDASIGNACIONCHIPS")
    private String idasignacionchips;
    @XStreamAlias("IDZONA")
    private int idzona;
    @XStreamAlias("CORDENADAX")
    private int cordenadax;
    @XStreamAlias("CORDENADAY")
    private int cordenaday;
    @XStreamAlias("IDUBICACION")
    private String idubicacion;
    @XStreamAlias("CORDENADAXT")
    private int cordenadaxt;
    @XStreamAlias("CORDENADAYT")
    private int cordenadayt;
    @XStreamAlias("ESTADOASIGNACION")
    private Integer estadoasignacion;
    @XStreamAlias("SERIECHIP")
    private String seriechip;
    @XStreamAlias("POSICION")
    private String posicion;
    @XStreamOmitField
    private String color;
   @XStreamAlias("DESCRIPCION")
    private String desc;
    @XStreamOmitField
    private int tiporack;
    @XStreamOmitField
    private List<DAsignacionChipsDet> lisdet;
    @XStreamOmitField
    private boolean proc;
    public DAsignacionChips() {
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

    public String getIdasignacionchips() {
        return idasignacionchips;
    }

    public void setIdasignacionchips(String idasignacionchips) {
        this.idasignacionchips = idasignacionchips;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    public int getCordenadax() {
        return cordenadax;
    }

    public void setCordenadax(int cordenadax) {
        this.cordenadax = cordenadax;
    }

    public int getCordenaday() {
        return cordenaday;
    }

    public void setCordenaday(int cordenaday) {
        this.cordenaday = cordenaday;
    }

    public String getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }

    public int getCordenadaxt() {
        return cordenadaxt;
    }

    public void setCordenadaxt(int cordenadaxt) {
        this.cordenadaxt = cordenadaxt;
    }

    public int getCordenadayt() {
        return cordenadayt;
    }

    public void setCordenadayt(int cordenadayt) {
        this.cordenadayt = cordenadayt;
    }

    public Integer getEstadoasignacion() {
        return estadoasignacion;
    }

    public void setEstadoasignacion(Integer estadoasignacion) {
        this.estadoasignacion = estadoasignacion;
    }

    public String getSeriechip() {
        return seriechip;
    }

    public void setSeriechip(String seriechip) {
        this.seriechip = seriechip;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getTiporack() {
        return tiporack;
    }

    public void setTiporack(int tiporack) {
        this.tiporack = tiporack;
    }

    public List<DAsignacionChipsDet> getLisdet() {
        return lisdet;
    }

    public void setLisdet(List<DAsignacionChipsDet> lisdet) {
        this.lisdet = lisdet;
    }

    public boolean isProc() {
        return proc;
    }

    public void setProc(boolean proc) {
        this.proc = proc;
    }

}
