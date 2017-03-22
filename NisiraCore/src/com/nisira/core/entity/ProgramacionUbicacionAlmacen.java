/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@XStreamAlias("PROGRAMACIONUBICACIONALMACEN")
public class ProgramacionUbicacionAlmacen {
    @XStreamAlias("cIDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("cIDPROGRAMACIONUBICACIONALMACEN")
    private String IDPROGRAMACIONUBICACIONALMACEN ;
    @XStreamAlias("cIDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("cIDRESPONSABLE")
    private String IDRESPONSABLE;
    @XStreamAlias("cIDDOCUMENTO")
    private String IDDOCUMENTO;
    @XStreamAlias("cSERIE")
    private String SERIE;
    @XStreamAlias("cNUMERO")
    private String NUMERO;
    @XStreamAlias("cIDESTADO")
    private String IDESTADO;
    @XStreamAlias("cOBSERVACION")
    private String OBSERVACION;

    /**
     * @return the IDEMPRESA
     */
    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    /**
     * @param IDEMPRESA the IDEMPRESA to set
     */
    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    /**
     * @return the IDPROGRAMACIONUBICACIONALMACEN
     */
    public String getIDPROGRAMACIONUBICACIONALMACEN() {
        return IDPROGRAMACIONUBICACIONALMACEN;
    }

    /**
     * @param IDPROGRAMACIONUBICACIONALMACEN the IDPROGRAMACIONUBICACIONALMACEN to set
     */
    public void setIDPROGRAMACIONUBICACIONALMACEN(String IDPROGRAMACIONUBICACIONALMACEN) {
        this.IDPROGRAMACIONUBICACIONALMACEN = IDPROGRAMACIONUBICACIONALMACEN;
    }

    /**
     * @return the IDSUCURSAL
     */
    public String getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    /**
     * @param IDSUCURSAL the IDSUCURSAL to set
     */
    public void setIDSUCURSAL(String IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    /**
     * @return the IDRESPONSABLE
     */
    public String getIDRESPONSABLE() {
        return IDRESPONSABLE;
    }

    /**
     * @param IDRESPONSABLE the IDRESPONSABLE to set
     */
    public void setIDRESPONSABLE(String IDRESPONSABLE) {
        this.IDRESPONSABLE = IDRESPONSABLE;
    }

    /**
     * @return the IDDOCUMENTO
     */
    public String getIDDOCUMENTO() {
        return IDDOCUMENTO;
    }

    /**
     * @param IDDOCUMENTO the IDDOCUMENTO to set
     */
    public void setIDDOCUMENTO(String IDDOCUMENTO) {
        this.IDDOCUMENTO = IDDOCUMENTO;
    }

    /**
     * @return the SERIE
     */
    public String getSERIE() {
        return SERIE;
    }

    /**
     * @param SERIE the SERIE to set
     */
    public void setSERIE(String SERIE) {
        this.SERIE = SERIE;
    }

    /**
     * @return the NUMERO
     */
    public String getNUMERO() {
        return NUMERO;
    }

    /**
     * @param NUMERO the NUMERO to set
     */
    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    /**
     * @return the IDESTADO
     */
    public String getIDESTADO() {
        return IDESTADO;
    }

    /**
     * @param IDESTADO the IDESTADO to set
     */
    public void setIDESTADO(String IDESTADO) {
        this.IDESTADO = IDESTADO;
    }

    /**
     * @return the OBSERVACION
     */
    public String getOBSERVACION() {
        return OBSERVACION;
    }

    /**
     * @param OBSERVACION the OBSERVACION to set
     */
    public void setOBSERVACION(String OBSERVACION) {
        this.OBSERVACION = OBSERVACION;
    }
}
