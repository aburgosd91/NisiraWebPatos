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
public class DordencompraBean implements Serializable{
    private static final long serialVersionUID=1L;
    private String idempresa;
    private String idcompra;
    private String item;
    private String idproducto;
    private String idestadoproducto;
    private String descripcion;
    private String idmedida;
    private double es_afecto;
    private double cantidad;
    private double porcentajedscto1;
    private double porcentajedscto2;
    private double porcentajedscto3;
    private double importedscto1;
    private double importedscto2;
    private double importedscto3;
    private double precio_unitario;
    private double subtotalsindscto;
    private double descuento_total;
    private double subtotalcondscto;
    private double total;
    private String oc_cliente;
    private Date fecha_occliente;
    private String destino;
    private String depedido;
    private String decotizacion;
    private String observaciones;
    private Date fechacreacion;
    private String sincroniza;
    private String idestado;
    private String idestadoold;
    private double impuesto_i;
    private double impuesto;
    private double precio_unitariodscto;
    private String idpartidapstal;
    private String idubicacion;
    private String codproveedor;
    private String descriprove;
    private String idcolor;
    private String idserie;
    private Date fechafac;
    private double embarcado;
    private double cant_embarque;
    private String nromotor;
    private String nrochasis;
    private String vin;
    private String anniofabricacion;
    private String situacion;

    public DordencompraBean() {
    }
    
    

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
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

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getIdestadoproducto() {
        return idestadoproducto;
    }

    public void setIdestadoproducto(String idestadoproducto) {
        this.idestadoproducto = idestadoproducto;
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

    public double getEs_afecto() {
        return es_afecto;
    }

    public void setEs_afecto(double es_afecto) {
        this.es_afecto = es_afecto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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

    public double getImportedscto1() {
        return importedscto1;
    }

    public void setImportedscto1(double importedscto1) {
        this.importedscto1 = importedscto1;
    }

    public double getImportedscto2() {
        return importedscto2;
    }

    public void setImportedscto2(double importedscto2) {
        this.importedscto2 = importedscto2;
    }

    public double getImportedscto3() {
        return importedscto3;
    }

    public void setImportedscto3(double importedscto3) {
        this.importedscto3 = importedscto3;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getSubtotalsindscto() {
        return subtotalsindscto;
    }

    public void setSubtotalsindscto(double subtotalsindscto) {
        this.subtotalsindscto = subtotalsindscto;
    }

    public double getDescuento_total() {
        return descuento_total;
    }

    public void setDescuento_total(double descuento_total) {
        this.descuento_total = descuento_total;
    }

    public double getSubtotalcondscto() {
        return subtotalcondscto;
    }

    public void setSubtotalcondscto(double subtotalcondscto) {
        this.subtotalcondscto = subtotalcondscto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getOc_cliente() {
        return oc_cliente;
    }

    public void setOc_cliente(String oc_cliente) {
        this.oc_cliente = oc_cliente;
    }

    public Date getFecha_occliente() {
        return fecha_occliente;
    }

    public void setFecha_occliente(Date fecha_occliente) {
        this.fecha_occliente = fecha_occliente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDepedido() {
        return depedido;
    }

    public void setDepedido(String depedido) {
        this.depedido = depedido;
    }

    public String getDecotizacion() {
        return decotizacion;
    }

    public void setDecotizacion(String decotizacion) {
        this.decotizacion = decotizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getSincroniza() {
        return sincroniza;
    }

    public void setSincroniza(String sincroniza) {
        this.sincroniza = sincroniza;
    }

    public String getIdestado() {
        return idestado;
    }

    public void setIdestado(String idestado) {
        this.idestado = idestado;
    }

    public String getIdestadoold() {
        return idestadoold;
    }

    public void setIdestadoold(String idestadoold) {
        this.idestadoold = idestadoold;
    }

    public double getImpuesto_i() {
        return impuesto_i;
    }

    public void setImpuesto_i(double impuesto_i) {
        this.impuesto_i = impuesto_i;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getPrecio_unitariodscto() {
        return precio_unitariodscto;
    }

    public void setPrecio_unitariodscto(double precio_unitariodscto) {
        this.precio_unitariodscto = precio_unitariodscto;
    }

    public String getIdpartidapstal() {
        return idpartidapstal;
    }

    public void setIdpartidapstal(String idpartidapstal) {
        this.idpartidapstal = idpartidapstal;
    }

    public String getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }

    public String getCodproveedor() {
        return codproveedor;
    }

    public void setCodproveedor(String codproveedor) {
        this.codproveedor = codproveedor;
    }

    public String getDescriprove() {
        return descriprove;
    }

    public void setDescriprove(String descriprove) {
        this.descriprove = descriprove;
    }

    public String getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(String idcolor) {
        this.idcolor = idcolor;
    }

    public String getIdserie() {
        return idserie;
    }

    public void setIdserie(String idserie) {
        this.idserie = idserie;
    }

    public Date getFechafac() {
        return fechafac;
    }

    public void setFechafac(Date fechafac) {
        this.fechafac = fechafac;
    }

    public double getEmbarcado() {
        return embarcado;
    }

    public void setEmbarcado(double embarcado) {
        this.embarcado = embarcado;
    }

    public double getCant_embarque() {
        return cant_embarque;
    }

    public void setCant_embarque(double cant_embarque) {
        this.cant_embarque = cant_embarque;
    }

    public String getNromotor() {
        return nromotor;
    }

    public void setNromotor(String nromotor) {
        this.nromotor = nromotor;
    }

    public String getNrochasis() {
        return nrochasis;
    }

    public void setNrochasis(String nrochasis) {
        this.nrochasis = nrochasis;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getAnniofabricacion() {
        return anniofabricacion;
    }

    public void setAnniofabricacion(String anniofabricacion) {
        this.anniofabricacion = anniofabricacion;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }
    
    
}
