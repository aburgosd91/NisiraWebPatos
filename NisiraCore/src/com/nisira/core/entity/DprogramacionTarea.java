/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author azamora
 */
@XStreamAlias("DPROGRAMACIONTAREA")
public class DprogramacionTarea {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDPROGRAMACIONTAREA")
    private String idprogramaciontarea;
    @XStreamAlias("ITEM")
    private Long item;
    @XStreamAlias("IDALMACEN")
    private int idalmacen;
    @XStreamAlias("IDPALETA")
    private String idpaleta;
    @XStreamAlias("NROPALETA")
    private String nropaleta;

    public DprogramacionTarea() {
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

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public String getIdpaleta() {
        return idpaleta;
    }

    public void setIdpaleta(String idpaleta) {
        this.idpaleta = idpaleta;
    }

    public String getNropaleta() {
        return nropaleta;
    }

    public void setNropaleta(String nropaleta) {
        this.nropaleta = nropaleta;
    }

}
