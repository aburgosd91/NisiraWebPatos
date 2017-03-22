/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.Almacen;;
import com.nisira.core.service.AlmacenService;
import com.nisira.core.service.SucursalService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;import com.nisira.core.service.AlmacenService;
import com.nisira.core.service.SucursalService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;import com.nisira.core.service.AlmacenService;
import com.nisira.core.service.SucursalService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;import com.nisira.core.service.AlmacenService;
import com.nisira.core.service.SucursalService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean
@ViewScoped
public class DistribucionUbicacionAlmacenAction {
    /* 
        0-> Visualizar
        1-> Nuevo
        2-> Modificar
    */
    
    /*+++++++++++++++++++++++++++++++++++++++ALMACEN++++++++++++++++++++++++++++++++++++++++*/
    private AlmacenService almacenService;
    private List<Almacen> listAlmacen;
    private List<Almacen> filterAlmacen;
    private Almacen selectAlmacen;
    private ServletContext servletContext;
    private String empresa;
    private String mensaje;
    private Almacen newAlmacen;
    private boolean botonEditarDis;
    private boolean botonEliminarDis;
    public DistribucionUbicacionAlmacenAction() {
        servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        empresa=ConstantesBD.IDEMPRESA;
        botonEditarDis=true;
        botonEliminarDis=true;
        /*+++++++++++++++++++++++ALMACEN++++++++++++++++++++++++++*/
        newAlmacen=new Almacen();
        newAlmacen.setIDEMPRESA(empresa);
        almacenService=new AlmacenService();
        listAlmacen=new ArrayList<Almacen>();
    }
    /********************************OPERACIONES******************************************/
   
    public void getAllAlmacenByEmpresa(){
        try{
            List<Almacen> lista_almacenes = getAlmacenService().getAllByEmpresa(getEmpresa()); 
            setListAlmacen(lista_almacenes);
            RequestContext.getCurrentInstance().update("datos:principal:panel1:tbl");
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void getActionEditarAlmacenEmpresa(){
        try{
            RequestContext.getCurrentInstance().update("FormNuevo");
            RequestContext.getCurrentInstance().execute("PF('dlgFormEditarAlmacen').show()");
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void EditarAlmacenEmpresa(){
        try{
            if(selectAlmacen.getDESCRIPCION().equals("")){
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.mensaje = "Ingrese Descripción";
            }
            else if(selectAlmacen.getDIRECCION().equals("")){
////                WebUtil.MensajeAlerta("Ingrese Dirección");
                this.mensaje = "Ingrese Dirección";
            }
            else{
                setMensaje(almacenService.editAlmacen(selectAlmacen));
                // getRecordAlmacenEmpresa();
                RequestContext.getCurrentInstance().update("datos:tbl");
                WebUtil.info(WebUtil.exitoActualizar("Documento Sucursal",selectAlmacen.getIDALMACEN()));
                RequestContext.getCurrentInstance().execute("PF('dlgFormEditarAlmacen').hide()");
            }
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void NuevoAlmacenEmpresa(){
        try{
            if(newAlmacen.getDESCRIPCION().equals("")){
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.mensaje = "Ingrese Descripción";
            }
            else if(newAlmacen.getDIRECCION().equals("")){
//                WebUtil.MensajeAlerta("Ingrese Dirección");
                this.mensaje = "Ingrese Dirección";
            }
            else{
                newAlmacen.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                setMensaje(almacenService.addAlmacen(newAlmacen));
                // getRecordAlmacenEmpresa();
                RequestContext.getCurrentInstance().update("datos:tbl");
                WebUtil.info(WebUtil.exitoRegistrar("Documento Almacen",newAlmacen.getDESCRIPCION()));
//                RequestContext.getCurrentInstance().execute("PF('dlgFormNuevoSucursal').hide()");
                newAlmacen=new Almacen();
                newAlmacen.setIDEMPRESA(empresa);
//                newAlmacen.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                newAlmacen.setESTADO(1);
            }
//            RequestContext.getCurrentInstance().update("dlgFormNuevoSucursal");
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void InhabilitarAlmacenEmpresa(){
        try{
            if(selectAlmacen.getDESCRIPCION().equals("")){
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.mensaje = "Ingrese Descripción";
            }
            else if(selectAlmacen.getDIRECCION().equals("")){
////                WebUtil.MensajeAlerta("Ingrese Dirección");
                this.mensaje = "Ingrese Dirección";
            }
            else{
                /*
                setMensaje(sucursalService.deleteSucursal(selectAlmacen));
                getRecordAlmacenEmpresa();
                */
                RequestContext.getCurrentInstance().update("datos:tbl");
                WebUtil.info(WebUtil.exitoEliminar("Documento Almacen",selectAlmacen.getIDALMACEN()));
            }
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    /*************************************************************************************/
    public void onRowSelect(SelectEvent event) throws IOException {
        selectAlmacen=((Almacen) event.getObject());
        newAlmacen.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
        newAlmacen.setIDALMACEN(selectAlmacen.getIDALMACEN());
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/faces/sistema/wEdt_distribucionubicacionalmacen.xhtml");
//        RequestContext.getCurrentInstance().execute("javascript:window.location =wregalmacen_principal.xhtml;");
//        }
//        RequestContext.getCurrentInstance().execute("PF(almacenRedirect())");
        RequestContext.getCurrentInstance().update("FormularioNuevoSucursal");
        RequestContext.getCurrentInstance().update("FormularioNuevoSucursal");
    }
    public void onRowUnselect(UnselectEvent event) throws IOException {
        selectAlmacen=((Almacen) event.getObject());
        newAlmacen.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/faces/sistema/wregalmacen_principal.xhtml");
        RequestContext.getCurrentInstance().update("FormularioNuevoSucursal");
        RequestContext.getCurrentInstance().update("FormularioNuevoSucursal");
//        RequestContext.getCurrentInstance().execute("javascript:window.location ="+(String) servletContext.getRealPath("sistema/wregalmacen_principal.xhtml")+";");
    }
    public void onRowSelectAlmacen(SelectEvent event) throws IOException {
        selectAlmacen=((Almacen) event.getObject());
        RequestContext.getCurrentInstance().update("dlgFormEditarAlmacen");
        botonEditarDis=false;
        botonEliminarDis=false;
//        RequestContext.getCurrentInstance().execute("javascript:window.location =wregalmacen_principal.xhtml;");
//        }
//        RequestContext.getCurrentInstance().execute("PF(almacenRedirect())");
//        RequestContext.getCurrentInstance().update("dlgFormEditarSucursal");
    }
    public void onRowUnselectAlmacen(UnselectEvent event) throws IOException {
        selectAlmacen=((Almacen) event.getObject());
        RequestContext.getCurrentInstance().update("dlgFormEditarAlmacen");
        botonEditarDis=false;
        botonEliminarDis=false;
//        RequestContext.getCurrentInstance().execute("javascript:window.location ="+(String) servletContext.getRealPath("sistema/wregalmacen_principal.xhtml")+";");
    }
   
    /**
     * @return the listSucursal
     */
   

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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
     * @return the almacenService
     */
    public AlmacenService getAlmacenService() {
        return almacenService;
    }

    /**
     * @param almacenService the almacenService to set
     */
    public void setAlmacenService(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    /**
     * @return the listAlmacen
     */
    public List<Almacen> getListAlmacen() {
        return listAlmacen;
    }

    /**
     * @param listAlmacen the listAlmacen to set
     */
    public void setListAlmacen(List<Almacen> listAlmacen) {
        this.listAlmacen = listAlmacen;
    }

    /**
     * @return the filterAlmacen
     */
    public List<Almacen> getFilterAlmacen() {
        return filterAlmacen;
    }

    /**
     * @param filterAlmacen the filterAlmacen to set
     */
    public void setFilterAlmacen(List<Almacen> filterAlmacen) {
        this.filterAlmacen = filterAlmacen;
    }

    /**
     * @return the selectAlmacen
     */
    public Almacen getSelectAlmacen() {
        return selectAlmacen;
    }

    /**
     * @param selectAlmacen the selectAlmacen to set
     */
    public void setSelectAlmacen(Almacen selectAlmacen) {
        this.selectAlmacen = selectAlmacen;
    }

    /**
     * @return the servletContext
     */
    public ServletContext getServletContext() {
        return servletContext;
    }

    /**
     * @param servletContext the servletContext to set
     */
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * @return the newAlmacen
     */
    public Almacen getNewAlmacen() {
        return newAlmacen;
    }

    /**
     * @param newAlmacen the newAlmacen to set
     */
    public void setNewAlmacen(Almacen newAlmacen) {
        this.newAlmacen = newAlmacen;
    }

    /**
     * @return the botonEditarDis
     */
    public boolean isBotonEditarDis() {
        return botonEditarDis;
    }

    /**
     * @param botonEditarDis the botonEditarDis to set
     */
    public void setBotonEditarDis(boolean botonEditarDis) {
        this.botonEditarDis = botonEditarDis;
    }

    /**
     * @return the botonEliminarDis
     */
    public boolean isBotonEliminarDis() {
        return botonEliminarDis;
    }

    /**
     * @param botonEliminarDis the botonEliminarDis to set
     */
    public void setBotonEliminarDis(boolean botonEliminarDis) {
        this.botonEliminarDis = botonEliminarDis;
    }
}
