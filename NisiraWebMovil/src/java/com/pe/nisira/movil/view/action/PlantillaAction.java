/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.Plantilla;
import com.nisira.core.service.PlantillaService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "plantillaAction")
@ViewScoped
public class PlantillaAction implements Serializable{
    /* NOTAS:
        0-> Visualizar
        1-> Nuevo
        2-> Modificar
    */
    private String idempresa;
    private String mensaje;
    private List<Plantilla> listPlantilla;
    private List<Plantilla> filtroPlantilla;
    private PlantillaService plantillaService;
    private Plantilla variablePlantilla;
    private Plantilla selectPlantilla;
    private boolean botonEditar;
    private boolean botonEliminar;
    private boolean estadoDoc;
    public PlantillaAction() {
        idempresa=ConstantesBD.IDEMPRESA;
        listPlantilla=new ArrayList<Plantilla>();
        plantillaService=new PlantillaService();
        variablePlantilla=new Plantilla();
        variablePlantilla.setIDEMPRESA(Integer.parseInt(idempresa));
        variablePlantilla.setESTADO(true);
        botonEditar=true;
        botonEliminar=true;
    }
    /****************OPERACIONES MONTACARGA*******************/
    public void getRecordPlantilla(){
        try{
            this.setListPlantilla(getPlantillaService().getRecordPlantilla(getIdempresa()));
            Constantes.estadoDocumento=0;
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void getActionNuevoPlantilla(){
        try{
            Constantes.estadoDocumento=1;
            setVariablePlantilla(new Plantilla());
            getVariablePlantilla().setIDEMPRESA(Integer.parseInt(getIdempresa()));
            getVariablePlantilla().setESTADO(true);
            Constantes.variablePlantilla=getVariablePlantilla();
            RequestContext.getCurrentInstance().update("FormularioGrabarPlantilla");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarPlantilla').show()");
            
//            RequestContext.getCurrentInstance().execute("PF('dlgFormEditarSucursal').show()");
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void getActionEditarPlantilla(){
        try{
            Constantes.estadoDocumento=2;
            if(getSelectPlantilla()!=null){
                Constantes.variablePlantilla=getSelectPlantilla();
                setVariablePlantilla(getSelectPlantilla());
                RequestContext.getCurrentInstance().update("FormularioGrabarPlantilla");
                RequestContext.getCurrentInstance().execute("PF('dlGuardarPlantilla').show()");
            }
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void InhabilitarPlantilla(){
        try{
            if(getSelectPlantilla().getIDPLANTILLA()==0){
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.setMensaje("Falta IDPLANTILLA");
            }
            else{
                setMensaje(getPlantillaService().deletePlantilla(getSelectPlantilla()));
                getRecordPlantilla();
                WebUtil.info(WebUtil.exitoEliminar("Documento Plantilla",getSelectPlantilla().getIDPLANTILLA()));
            }
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void GrabarPlantilla(){
        try{
            if(getVariablePlantilla().getIDEMPRESA()==0){
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.setMensaje("Ingrese Empresa");
            }
            else if(getVariablePlantilla().getDESCRIPCION().equals("")){
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.setMensaje("Ingrese Descripción");
            }else if(getVariablePlantilla().getWIDTH()==0){
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.setMensaje("Ingrese Ancho de Imagen");
            }
            else if(getVariablePlantilla().getHEIGHT()==0){
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.setMensaje("Ingrese Alto de Imagen");
            }
            else{
                if(Constantes.estadoDocumento==1){//Nuevo
                    getPlantillaService().addPlantilla(getVariablePlantilla());
                    setVariablePlantilla(new Plantilla());
                    getVariablePlantilla().setIDEMPRESA(Integer.parseInt(getIdempresa()));
                    getVariablePlantilla().setESTADO(true);
                    RequestContext.getCurrentInstance().update("FormularioGrabarPlantilla");
                }else if(Constantes.estadoDocumento==2){//Modificar
                    getPlantillaService().editPlantilla(getVariablePlantilla());
                }
                setEstadoDoc(true);
                getRecordPlantilla();
                RequestContext.getCurrentInstance().update("datos");
                RequestContext.getCurrentInstance().update("datos:tbl");
                WebUtil.info(WebUtil.exitoRegistrar("Documento Plantilla",getVariablePlantilla().getIDPLANTILLA()));
            }
//            RequestContext.getCurrentInstance().update("dlgFormNuevoSucursal");
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void onRowSelect(SelectEvent event) throws IOException {
        setSelectPlantilla((Plantilla) event.getObject());
        setBotonEditar(false);
        setBotonEliminar(false);
        RequestContext.getCurrentInstance().update("formCabecera:frmPlantilla");
        return;
    }
    public void onRowUnselect(UnselectEvent event) throws IOException {
        setSelectPlantilla((Plantilla) event.getObject());
        setBotonEditar(false);
        setBotonEliminar(false);
        RequestContext.getCurrentInstance().update("formCabecera:frmPlantilla");
        return;
    }

    /**
     * @return the idempresa
     */
    public String getIdempresa() {
        return idempresa;
    }

    /**
     * @param idempresa the idempresa to set
     */
    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the listPlantilla
     */
    public List<Plantilla> getListPlantilla() {
        return listPlantilla;
    }

    /**
     * @param listPlantilla the listPlantilla to set
     */
    public void setListPlantilla(List<Plantilla> listPlantilla) {
        this.listPlantilla = listPlantilla;
    }

    /**
     * @return the filtroPlantilla
     */
    public List<Plantilla> getFiltroPlantilla() {
        return filtroPlantilla;
    }

    /**
     * @param filtroPlantilla the filtroPlantilla to set
     */
    public void setFiltroPlantilla(List<Plantilla> filtroPlantilla) {
        this.filtroPlantilla = filtroPlantilla;
    }

    /**
     * @return the montacargaService
     */
    public PlantillaService getPlantillaService() {
        return plantillaService;
    }

    /**
     * @param montacargaService the montacargaService to set
     */
    public void setPlantillaService(PlantillaService plantillaService) {
        this.plantillaService = plantillaService;
    }

    /**
     * @return the variablePlantilla
     */
    public Plantilla getVariablePlantilla() {
        return variablePlantilla;
    }

    /**
     * @param variablePlantilla the variablePlantilla to set
     */
    public void setVariablePlantilla(Plantilla variablePlantilla) {
        this.variablePlantilla = variablePlantilla;
    }

    /**
     * @return the selectPlantilla
     */
    public Plantilla getSelectPlantilla() {
        return selectPlantilla;
    }

    /**
     * @param selectPlantilla the selectPlantilla to set
     */
    public void setSelectPlantilla(Plantilla selectPlantilla) {
        this.selectPlantilla = selectPlantilla;
    }

    /**
     * @return the botonEditar
     */
    public boolean isBotonEditar() {
        return botonEditar;
    }

    /**
     * @param botonEditar the botonEditar to set
     */
    public void setBotonEditar(boolean botonEditar) {
        this.botonEditar = botonEditar;
    }

    /**
     * @return the botonEliminar
     */
    public boolean isBotonEliminar() {
        return botonEliminar;
    }

    /**
     * @param botonEliminar the botonEliminar to set
     */
    public void setBotonEliminar(boolean botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    /**
     * @return the estadoDoc
     */
    public boolean isEstadoDoc() {
        return estadoDoc;
    }

    /**
     * @param estadoDoc the estadoDoc to set
     */
    public void setEstadoDoc(boolean estadoDoc) {
        this.estadoDoc = estadoDoc;
    }
}
