/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antenor Edit Alex
 */
@XStreamAlias("Paleta")
public class Paleta {

    @XStreamAlias("cidbasedatos")
    private String idbasedatos;
    @XStreamAlias("cidempresa")
    private String idempresa;
    @XStreamAlias("cidregistropaleta")
    private String idregistropaleta;
    @XStreamAlias("cidemisor")
    private String idemisor;
    @XStreamAlias("cidoperacion")
    private String idoperacion;
    @XStreamAlias("cnumoperacion")
    private String numoperacion;
    @XStreamAlias("cidmotivopaleta")
    private String idmotivopaleta;
    @XStreamAlias("ciddocumento")
    private String iddocumento;
    @XStreamAlias("cserie")
    private String serie;
    @XStreamAlias("cnumero")
    private String numero;
    @XStreamAlias("cfecha")
    private String fecha;
    @XStreamAlias("cperiodo")
    private String periodo;
    @XStreamAlias("cidestado")
    private String idestado;
    @XStreamAlias("cidclieprov")
    private String idclieprov;
    @XStreamAlias("cnropaleta")
    private String nropaleta;
    @XStreamAlias("cidenvase")
    private String idenvase;
    @XStreamAlias("cidsucursal")
    private String idsucursal;
    @XStreamAlias("cidalmacen")
    private String idalmacen;
    @XStreamAlias("cidparihuela")
    private String idparihuela;
    @XStreamAlias("cidembalaje")
    private String idembalaje;
    @XStreamAlias("cidcultivo")
    private String idcultivo;
    @XStreamAlias("cidvariedad")
    private String idvariedad;
    @XStreamAlias("cdes_variedad")
    private String des_variedad;
    @XStreamAlias("cidclieprov_origen")
    private String idclieprov_origen;
    @XStreamAlias("cnropaleta_origen")
    private String nropaleta_origen;
    @XStreamAlias("cidsalida")
    private String idsalida;
    @XStreamAlias("cidmotivo_ing")
    private String idmotivo_ing;
    @XStreamAlias("cidingreso")
    private String idingreso;
    @XStreamAlias("cidmotivo_sal")
    private String idmotivo_sal;
    @XStreamAlias("cobservaciones")
    private String observaciones;
    @XStreamAlias("cventana")
    private String ventana;
    @XStreamAlias("ccantidad")
    private String cantidad;
    @XStreamAlias("ccerrado")
    private String cerrado;
    @XStreamAlias("cidbasedatos")
    private String sincroniza;
    @XStreamAlias("cfechacreacion")
    private String fechacreacion;
    @XStreamAlias("cnromanual")
    private String nromanual;
    @XStreamAlias("cdesc_adicional")
    private String desc_adicional;
    @XStreamAlias("cidclieprov_destino")
    private String idclieprov_destino;
    @XStreamAlias("ctipo")
    private String tipo;
    @XStreamAlias("cidturno")
    private String idturno;
    @XStreamAlias("cidreqinterno")
    private String idreqinterno;

    /**
     * *******************************************************************************
     */
    @XStreamAlias("cidproducto")
    private String idproducto;
    @XStreamAlias("cdescproducto")
    private String descproducto;
    @XStreamAlias("cidmedida")
    private String idmedida;
    @XStreamAlias("cpeso")
    private Double peso;
    @XStreamAlias("cidlotep")
    private String idlotep;
    @XStreamAlias("cidcliente")
    private String idcliente;
    @XStreamAlias("cdescenvase")
    private String descenvase;
    /**************AGREGADO*******************/
    @XStreamAlias("cidreferencia")
    private String idreferencia;
    @XStreamAlias("cidcaja")
    private String idcaja;
    @XStreamAlias("citem")
    private String item;
    @XStreamAlias("cdescripcion")
    private String descripcion;
    @XStreamAlias("cidclieprov_cli")
    private String idclieprov_cli;
    @XStreamAlias("cidclieprov_pro")
    private String idclieprov_pro;
    @XStreamAlias("cfechaorigen")
    private String fechaorigen;
    @XStreamAlias("cfechaproc")
    private String fechaproc;
    @XStreamAlias("cdesc_envase")
    private String desc_envase; 
    
    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescproducto() {
        return descproducto;
    }

    public void setDescproducto(String descproducto) {
        this.descproducto = descproducto;
    }

    public String getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(String idmedida) {
        this.idmedida = idmedida;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getNropaleta() {
        return nropaleta;
    }

    public void setNropaleta(String nropaleta) {
        this.nropaleta = nropaleta;
    }

    public String getIdlotep() {
        return idlotep;
    }

    public void setIdlotep(String idlotep) {
        this.idlotep = idlotep;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getIdclieprov() {
        return idclieprov;
    }

    public void setIdclieprov(String idclieprov) {
        this.idclieprov = idclieprov;
    }

    public String getIdenvase() {
        return idenvase;
    }

    public void setIdenvase(String idenvase) {
        this.idenvase = idenvase;
    }

    public String getDescenvase() {
        return descenvase;
    }

    public void setDescenvase(String descenvase) {
        this.descenvase = descenvase;
    }

    public String getCerrado() {
        return cerrado;
    }

    public void setCerrado(String cerrado) {
        this.cerrado = cerrado;
    }

    public String getNromanual() {
        return nromanual;
    }

    public void setNromanual(String nromanual) {
        this.nromanual = nromanual;
    }

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

    public String getIdregistropaleta() {
        return idregistropaleta;
    }

    public void setIdregistropaleta(String idregistropaleta) {
        this.idregistropaleta = idregistropaleta;
    }

    public String getIdproductor() {
        return idproducto;
    }

    public void setIdproductor(String idproductor) {
        this.idproducto = idproductor;
    }

    /**
     * @return the idemisor
     */
    public String getIdemisor() {
        return idemisor;
    }

    /**
     * @param idemisor the idemisor to set
     */
    public void setIdemisor(String idemisor) {
        this.idemisor = idemisor;
    }

    /**
     * @return the idoperacion
     */
    public String getIdoperacion() {
        return idoperacion;
    }

    /**
     * @param idoperacion the idoperacion to set
     */
    public void setIdoperacion(String idoperacion) {
        this.idoperacion = idoperacion;
    }

    /**
     * @return the numoperacion
     */
    public String getNumoperacion() {
        return numoperacion;
    }

    /**
     * @param numoperacion the numoperacion to set
     */
    public void setNumoperacion(String numoperacion) {
        this.numoperacion = numoperacion;
    }

    /**
     * @return the idmotivopaleta
     */
    public String getIdmotivopaleta() {
        return idmotivopaleta;
    }

    /**
     * @param idmotivopaleta the idmotivopaleta to set
     */
    public void setIdmotivopaleta(String idmotivopaleta) {
        this.idmotivopaleta = idmotivopaleta;
    }

    /**
     * @return the iddocumento
     */
    public String getIddocumento() {
        return iddocumento;
    }

    /**
     * @param iddocumento the iddocumento to set
     */
    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the idestado
     */
    public String getIdestado() {
        return idestado;
    }

    /**
     * @param idestado the idestado to set
     */
    public void setIdestado(String idestado) {
        this.idestado = idestado;
    }

    /**
     * @return the idsucursal
     */
    public String getIdsucursal() {
        return idsucursal;
    }

    /**
     * @param idsucursal the idsucursal to set
     */
    public void setIdsucursal(String idsucursal) {
        this.idsucursal = idsucursal;
    }

    /**
     * @return the idalmacen
     */
    public String getIdalmacen() {
        return idalmacen;
    }

    /**
     * @param idalmacen the idalmacen to set
     */
    public void setIdalmacen(String idalmacen) {
        this.idalmacen = idalmacen;
    }

    /**
     * @return the idparihuela
     */
    public String getIdparihuela() {
        return idparihuela;
    }

    /**
     * @param idparihuela the idparihuela to set
     */
    public void setIdparihuela(String idparihuela) {
        this.idparihuela = idparihuela;
    }

    /**
     * @return the idembalaje
     */
    public String getIdembalaje() {
        return idembalaje;
    }

    /**
     * @param idembalaje the idembalaje to set
     */
    public void setIdembalaje(String idembalaje) {
        this.idembalaje = idembalaje;
    }

    /**
     * @return the idcultivo
     */
    public String getIdcultivo() {
        return idcultivo;
    }

    /**
     * @param idcultivo the idcultivo to set
     */
    public void setIdcultivo(String idcultivo) {
        this.idcultivo = idcultivo;
    }

    /**
     * @return the idvariedad
     */
    public String getIdvariedad() {
        return idvariedad;
    }

    /**
     * @param idvariedad the idvariedad to set
     */
    public void setIdvariedad(String idvariedad) {
        this.idvariedad = idvariedad;
    }

    /**
     * @return the des_variedad
     */
    public String getDes_variedad() {
        return des_variedad;
    }

    /**
     * @param des_variedad the des_variedad to set
     */
    public void setDes_variedad(String des_variedad) {
        this.des_variedad = des_variedad;
    }

    /**
     * @return the idclieprov_origen
     */
    public String getIdclieprov_origen() {
        return idclieprov_origen;
    }

    /**
     * @param idclieprov_origen the idclieprov_origen to set
     */
    public void setIdclieprov_origen(String idclieprov_origen) {
        this.idclieprov_origen = idclieprov_origen;
    }

    /**
     * @return the nropaleta_origen
     */
    public String getNropaleta_origen() {
        return nropaleta_origen;
    }

    /**
     * @param nropaleta_origen the nropaleta_origen to set
     */
    public void setNropaleta_origen(String nropaleta_origen) {
        this.nropaleta_origen = nropaleta_origen;
    }

    /**
     * @return the idsalida
     */
    public String getIdsalida() {
        return idsalida;
    }

    /**
     * @param idsalida the idsalida to set
     */
    public void setIdsalida(String idsalida) {
        this.idsalida = idsalida;
    }

    /**
     * @return the idmotivo_ing
     */
    public String getIdmotivo_ing() {
        return idmotivo_ing;
    }

    /**
     * @param idmotivo_ing the idmotivo_ing to set
     */
    public void setIdmotivo_ing(String idmotivo_ing) {
        this.idmotivo_ing = idmotivo_ing;
    }

    /**
     * @return the idingreso
     */
    public String getIdingreso() {
        return idingreso;
    }

    /**
     * @param idingreso the idingreso to set
     */
    public void setIdingreso(String idingreso) {
        this.idingreso = idingreso;
    }

    /**
     * @return the idmotivo_sal
     */
    public String getIdmotivo_sal() {
        return idmotivo_sal;
    }

    /**
     * @param idmotivo_sal the idmotivo_sal to set
     */
    public void setIdmotivo_sal(String idmotivo_sal) {
        this.idmotivo_sal = idmotivo_sal;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the ventana
     */
    public String getVentana() {
        return ventana;
    }

    /**
     * @param ventana the ventana to set
     */
    public void setVentana(String ventana) {
        this.ventana = ventana;
    }

    /**
     * @return the sincroniza
     */
    public String getSincroniza() {
        return sincroniza;
    }

    /**
     * @param sincroniza the sincroniza to set
     */
    public void setSincroniza(String sincroniza) {
        this.sincroniza = sincroniza;
    }

    /**
     * @return the fechacreacion
     */
    public String getFechacreacion() {
        return fechacreacion;
    }

    /**
     * @param fechacreacion the fechacreacion to set
     */
    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    /**
     * @return the desc_adicional
     */
    public String getDesc_adicional() {
        return desc_adicional;
    }

    /**
     * @param desc_adicional the desc_adicional to set
     */
    public void setDesc_adicional(String desc_adicional) {
        this.desc_adicional = desc_adicional;
    }

    /**
     * @return the idclieprov_destino
     */
    public String getIdclieprov_destino() {
        return idclieprov_destino;
    }

    /**
     * @param idclieprov_destino the idclieprov_destino to set
     */
    public void setIdclieprov_destino(String idclieprov_destino) {
        this.idclieprov_destino = idclieprov_destino;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the idturno
     */
    public String getIdturno() {
        return idturno;
    }

    /**
     * @param idturno the idturno to set
     */
    public void setIdturno(String idturno) {
        this.idturno = idturno;
    }

    /**
     * @return the idreqinterno
     */
    public String getIdreqinterno() {
        return idreqinterno;
    }

    /**
     * @param idreqinterno the idreqinterno to set
     */
    public void setIdreqinterno(String idreqinterno) {
        this.idreqinterno = idreqinterno;
    }

    /**
     * @return the idreferencia
     */
    public String getIdreferencia() {
        return idreferencia;
    }

    /**
     * @param idreferencia the idreferencia to set
     */
    public void setIdreferencia(String idreferencia) {
        this.idreferencia = idreferencia;
    }

    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the idclieprov_cli
     */
    public String getIdclieprov_cli() {
        return idclieprov_cli;
    }

    /**
     * @param idclieprov_cli the idclieprov_cli to set
     */
    public void setIdclieprov_cli(String idclieprov_cli) {
        this.idclieprov_cli = idclieprov_cli;
    }

    /**
     * @return the idclieprov_pro
     */
    public String getIdclieprov_pro() {
        return idclieprov_pro;
    }

    /**
     * @param idclieprov_pro the idclieprov_pro to set
     */
    public void setIdclieprov_pro(String idclieprov_pro) {
        this.idclieprov_pro = idclieprov_pro;
    }

    /**
     * @return the fechaorigen
     */
    public String getFechaorigen() {
        return fechaorigen;
    }

    /**
     * @param fechaorigen the fechaorigen to set
     */
    public void setFechaorigen(String fechaorigen) {
        this.fechaorigen = fechaorigen;
    }

    /**
     * @return the fechaproc
     */
    public String getFechaproc() {
        return fechaproc;
    }

    /**
     * @param fechaproc the fechaproc to set
     */
    public void setFechaproc(String fechaproc) {
        this.fechaproc = fechaproc;
    }

    /**
     * @return the desc_envase
     */
    public String getDesc_envase() {
        return desc_envase;
    }

    /**
     * @param desc_envase the desc_envase to set
     */
    public void setDesc_envase(String desc_envase) {
        this.desc_envase = desc_envase;
    }

    /**
     * @return the idcaja
     */
    public String getIdcaja() {
        return idcaja;
    }

    /**
     * @param idcaja the idcaja to set
     */
    public void setIdcaja(String idcaja) {
        this.idcaja = idcaja;
    }

}
