/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author azamora
 */
@XStreamAlias("DPROGRAMACIONTAREAPARTIDA")
public class DprogramacionTareaPartida {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDPROGRAMACIONTAREA")
    private String idprogramaciontarea;
    @XStreamAlias("ITEM")
    private int item;
    @XStreamAlias("IDPROCESO")
    private int idproceso;
    @XStreamAlias("IDZONA")
    private int idzona;
    @XStreamAlias("IDALMACEN")
    private Integer idalmacen;
    @XStreamAlias("IDACCESORIO")
    private int idaccesorio;
    @XStreamAlias("IDPALETA")
    private String idpaleta;
    @XStreamAlias("IDUBICACION")
    private String idubicacion;
    @XStreamOmitField
    private HashMap<String,Object> lista;
    @XStreamOmitField
    private String NROPALETA;
    public DprogramacionTareaPartida() {
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

    public int getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    public Integer getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(Integer idalmacen) {
        this.idalmacen = idalmacen;
    }

    public int getIdaccesorio() {
        return idaccesorio;
    }

    public void setIdaccesorio(int idaccesorio) {
        this.idaccesorio = idaccesorio;
    }

    public String getIdpaleta() {
        return idpaleta;
    }

    public void setIdpaleta(String idpaleta) {
        this.idpaleta = idpaleta;
    }

    public String getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }

    public HashMap<String, Object> getLista() {
        return lista;
    }

    public void setLista(HashMap<String, Object> lista) {
        this.lista = lista;
    }
    public Object getValor(String key){
        return lista.get(key);
    }

    public String getNROPALETA() {
        return NROPALETA;
    }

    public void setNROPALETA(String NROPALETA) {
        this.NROPALETA = NROPALETA;
    }
    
}
