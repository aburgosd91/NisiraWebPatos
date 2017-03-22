/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Antenor
 */
public class PrecioshistoricosBean implements Serializable{
    private static final long serialVersionUID=1L;
    private String idempresa;
    private String idproducto;
    private String idclieprov;
    private String idcompra;
    private String item;
    private Date fecha;
    private String idmoneda;
    private String formapago;
    private double precio;
    private double porcentajedscto1;
    private double porcentajedscto2;
    private double porcentajedscto3;
    private String iddocumento;
    private String tabla;
    private String fechacreacion;
    private String sincroniza;

    public PrecioshistoricosBean() {
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getIdclieprov() {
        return idclieprov;
    }

    public void setIdclieprov(String idclieprov) {
        this.idclieprov = idclieprov;
    }

    public String getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(String idcompra) {
        this.idcompra = idcompra;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(String idmoneda) {
        this.idmoneda = idmoneda;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPorcentajedscto1() {
        return porcentajedscto1;
    }

    public void setPorcentajedscto1(double porcentajedscto1) {
        this.porcentajedscto1 = porcentajedscto1;
    }

    public double getPorcentajedscto2() {
        return porcentajedscto2;
    }

    public void setPorcentajedscto2(double porcentajedscto2) {
        this.porcentajedscto2 = porcentajedscto2;
    }

    public double getPorcentajedscto3() {
        return porcentajedscto3;
    }

    public void setPorcentajedscto3(double porcentajedscto3) {
        this.porcentajedscto3 = porcentajedscto3;
    }

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getSincroniza() {
        return sincroniza;
    }

    public void setSincroniza(String sincroniza) {
        this.sincroniza = sincroniza;
    }
    
    
}
