/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;

/**
 *
 * @author Antenor
 */
public class DordenpagoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idempresa;
    private String idordenpago;
    private String item;
    private String idproducto;
    private String descripcion;
    private String idmedida;
    private String idestadoproducto;
    private double cantidad;
    private String idconsumidor;
    private double precio;
    private String idpartidapstal;
    private String glosa;
    private double importe;
    private double impuesto;
    private double total;
    private String idactividad;
    private String idcampana;
    private String idloteproduccion;
    private String idordenproduccion;
    private String idsiembra;
    private String observacion;

    public DordenpagoBean() {
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdordenpago() {
        return idordenpago;
    }

    public void setIdordenpago(String idordenpago) {
        this.idordenpago = idordenpago;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(String idmedida) {
        this.idmedida = idmedida;
    }

    public String getIdestadoproducto() {
        return idestadoproducto;
    }

    public void setIdestadoproducto(String idestadoproducto) {
        this.idestadoproducto = idestadoproducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdconsumidor() {
        return idconsumidor;
    }

    public void setIdconsumidor(String idconsumidor) {
        this.idconsumidor = idconsumidor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIdpartidapstal() {
        return idpartidapstal;
    }

    public void setIdpartidapstal(String idpartidapstal) {
        this.idpartidapstal = idpartidapstal;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(String idactividad) {
        this.idactividad = idactividad;
    }

    public String getIdcampana() {
        return idcampana;
    }

    public void setIdcampana(String idcampana) {
        this.idcampana = idcampana;
    }

    public String getIdloteproduccion() {
        return idloteproduccion;
    }

    public void setIdloteproduccion(String idloteproduccion) {
        this.idloteproduccion = idloteproduccion;
    }

    public String getIdordenproduccion() {
        return idordenproduccion;
    }

    public void setIdordenproduccion(String idordenproduccion) {
        this.idordenproduccion = idordenproduccion;
    }

    public String getIdsiembra() {
        return idsiembra;
    }

    public void setIdsiembra(String idsiembra) {
        this.idsiembra = idsiembra;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
