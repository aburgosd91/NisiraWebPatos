/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.awt.Image;
/**
 *
 * @author aburgos
 */
@XStreamAlias("DESIGNPLANT")
public class DesignPlant {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDDESIGNPLANT")
    private int iddesignplant;
    @XStreamAlias("TYPE")
    private String type;
    @XStreamAlias("IMGPLANT")
    private Image imgplant;
    @XStreamAlias("ESTADO")
    private int estado;
    @XStreamAlias("FECHACREACION")
    private String fechacreacion;
    @XStreamAlias("NAMEIMG")
    private String nameimg;
    @XStreamOmitField
    private String typename;
    @XStreamOmitField
    private String sucursal;
    @XStreamOmitField
    private int height;
    @XStreamOmitField
    private int width;

    /**
     * @return the idempresa
     */
    public int getIdempresa() {
        return idempresa;
    }

    /**
     * @param idempresa the idempresa to set
     */
    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    /**
     * @return the idsucursal
     */
    public int getIdsucursal() {
        return idsucursal;
    }

    /**
     * @param idsucursal the idsucursal to set
     */
    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    /**
     * @return the iddesignplant
     */
    public int getIddesignplant() {
        return iddesignplant;
    }

    /**
     * @param iddesignplant the iddesignplant to set
     */
    public void setIddesignplant(int iddesignplant) {
        this.iddesignplant = iddesignplant;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the imgplant
     */
    public Image getImgplant() {
        return imgplant;
    }

    /**
     * @param imgplant the imgplant to set
     */
    public void setImgplant(Image imgplant) {
        this.imgplant = imgplant;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
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
     * @return the typename
     */
    public String getTypename() {
        return typename;
    }

    /**
     * @param typename the typename to set
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * @return the sucursal
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the nameimg
     */
    public String getNameimg() {
        return nameimg;
    }

    /**
     * @param nameimg the nameimg to set
     */
    public void setNameimg(String nameimg) {
        this.nameimg = nameimg;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

}
