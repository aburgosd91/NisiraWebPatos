/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AccionesDao;
import com.nisira.core.dao.DAccionesVistaDao;
import com.nisira.core.entity.Acciones;
import com.nisira.core.entity.DAccionesVista;
import com.nisira.core.entity.mSysFormulario;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "dAccionesVistasAction")
@SessionScoped
public class DAccionesVistasAction extends AbstactListAction<DAccionesVista>  implements Serializable {

    private DAccionesVistaDao dAccionesVistaDao;
    private List<DAccionesVista> listDAccionesVistas;
    private DAccionesVista selectDAccionesVistas;
    private List<Acciones> listAcciones;
    private AccionesDao accionesDao;
    private Acciones Acciones;
    private String Method;
    private List<String> vistas;
    private String mensaje;
    private boolean botonEliminar;
    private String Vista;
    private int doctEst;
    public DAccionesVistasAction() {
        mensaje = "";
        Vista = "";
        accionesDao = new AccionesDao();
        listAcciones = new ArrayList<>();
        listDAccionesVistas = new ArrayList<>();
        botonEliminar = true;
        dAccionesVistaDao = new DAccionesVistaDao();
        actualiza_ventana("wMnt_daccionesvista");
    }
   
    @Override
    /*listar acciones*/
    public void buscarTodo() {
        try {
            getIniciar();
            setListaDatos(getdAccionesVistaDao().findAll(Constantes.IDEMPRESAGENERAL));
            RequestContext.getCurrentInstance().update("datos:principal:tbl");
//          setListaDatos(ptareaDao.findAll(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL(), 0));
        } catch (Exception ex) {
            Logger.getLogger(DAccionesVistasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listarAcciones(){
        try{
            setListAcciones(getAccionesDao().findAll(Constantes.IDEMPRESAGENERAL));
        }catch(Exception ex){
            Logger.getLogger(DAccionesVistasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listarDetalle(){
        try {
            listDAccionesVistas= dAccionesVistaDao.findAll(Integer.parseInt(Constantes.IDEMPRESAGENERAL),getDatoEdicion().getVISTA());
            RequestContext.getCurrentInstance().update("datos:informacion");
            RequestContext.getCurrentInstance().update("datos:informacion:listDAccionesVistas");
        } catch (Exception ex) {
            Logger.getLogger(DAccionesVistasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getIniciar() {
        setdAccionesVistaDao(new DAccionesVistaDao());
        setVistas(new ArrayList<>());
        listDAccionesVistas = new ArrayList<>();
        dAccionesVistaDao = new DAccionesVistaDao();
        actualiza_ventana("wMnt_daccionesvista");
        return "";
    }

//    @Override
    public void nuevo() {
        getIniciar();
        /*OPCION NO HABILITADA*/
        setDatoEdicion(new DAccionesVista());
        getDatoEdicion().setIDEMPRESA(Integer.parseInt(Constantes.IDEMPRESAGENERAL));
        doctEst = 1;
    }

    @Override
    public void grabar() {
        try {
            if (getListDAccionesVistas()!=null & getListDAccionesVistas().size()>0) {
                    getdAccionesVistaDao().grabar(getListDAccionesVistas());
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(DAccionesVistasAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(getMensaje());
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
//                getDatoEdicion().setEstado(0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getdAccionesVistaDao().delete(Constantes.IDEMPRESAGENERAL, getDatoEdicion().getVISTA());
            }
        } catch (Exception ex) {
            Logger.getLogger(DAccionesVistasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onSelectDAccionesVistas(){
        try{
            setBotonEliminar(false);
            System.out.println("--onSelectDAcciones-- " + selectDAccionesVistas.getACCIONES()+" <-> "+selectDAccionesVistas.getVISTA());
            RequestContext.getCurrentInstance().update("datos:informacion");
            RequestContext.getCurrentInstance().update("datos:informacion:listDAccionesVistas");
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    public void onRowEdit(){}
    public void onRowCancel(){}
    public void agregarDetalle(){
        DAccionesVista datos = new DAccionesVista();
        datos.setIDEMPRESA(Integer.parseInt(Constantes.IDEMPRESAGENERAL));
        datos.setIDACCION(getAcciones().getIdaccion());
        datos.setACCIONES(getAcciones().getDescripcion());
        datos.setVISTA(getDatoEdicion().getVISTA());
        if(this.getAcciones()==null){
            WebUtil.MensajeAdvertencia("Deberá asignar vista");
        }else{
            if(verificarDetalle(datos)){
                listDAccionesVistas.add(datos);
                refreshOrdenamiento();
                RequestContext.getCurrentInstance().update("datos:informacion");
                RequestContext.getCurrentInstance().update("datos:informacion:listDAccionesVistas");
            }
//            else{
//                WebUtil.MensajeAdvertencia("Vista: "+this.Vista+", se encuetra asignada");
//            }
        }
        //RequestContext.getCurrentInstance().execute("PF('dlGuardarDAcciones').show()");
    }
    public void eliminarDetalle(){
        if(selectDAccionesVistas!=null){
            listDAccionesVistas.remove(selectDAccionesVistas);
        }else{
            WebUtil.MensajeAdvertencia("Deberá seleccionar registro");
        }
        refreshOrdenamiento();
        RequestContext.getCurrentInstance().update("datos:informacion");
        RequestContext.getCurrentInstance().update("datos:informacion:listDAccionesVistas");
//        RequestContext.getCurrentInstance().execute("PF('dlGuardarDAcciones').show()");
    }
    public boolean verificarDetalle(DAccionesVista obj){
        boolean result=true;
        salir:for(DAccionesVista o : listDAccionesVistas){
            if(o.getVISTA().equalsIgnoreCase(obj.getVISTA())){
                result=false;
                break salir;
            }
        }
        return result;
    }
    public void refreshOrdenamiento(){
        int i=1;
        int j=0;
        for(DAccionesVista obj:listDAccionesVistas){
            obj.setORDEN(i++);
            listDAccionesVistas.set(j++, obj);
        }
    }
    public void subirDetalle(){
        try{
            int pos = listDAccionesVistas.indexOf(selectDAccionesVistas);
            int torden=0;
            if(pos>0 & pos<listDAccionesVistas.size()){
                DAccionesVista temp = listDAccionesVistas.get(pos-1);
                DAccionesVista objremp = listDAccionesVistas.get(pos);
                torden=objremp.getORDEN();
                objremp.setORDEN(temp.getORDEN());
                temp.setORDEN(torden);
                listDAccionesVistas.set(pos, temp);
                listDAccionesVistas.set(pos-1, objremp);
                selectDAccionesVistas=new DAccionesVista();
                RequestContext.getCurrentInstance().update("datos:informacion");
                RequestContext.getCurrentInstance().update("datos:informacion:listDAccionesVistas");
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    public void bajarDetalle(){
        try{
            int pos = listDAccionesVistas.indexOf(selectDAccionesVistas);
            int torden=0;
            if(pos>=0 & pos<listDAccionesVistas.size()){
                DAccionesVista temp = listDAccionesVistas.get(pos+1);
                DAccionesVista objremp = listDAccionesVistas.get(pos);
                torden=objremp.getORDEN();
                objremp.setORDEN(temp.getORDEN());
                temp.setORDEN(torden);
                listDAccionesVistas.set(pos, temp);
                listDAccionesVistas.set(pos+1, objremp);
                selectDAccionesVistas=new DAccionesVista();
                RequestContext.getCurrentInstance().update("datos:informacion");
                RequestContext.getCurrentInstance().update("datos:informacion:listDAccionesVistas");
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    
    public void verCntAcciones() {
        RequestContext.getCurrentInstance().openDialog("cntAcciones", modalOptions, null);
    }
    public void llenarAccion(SelectEvent event) {
        this.setAcciones((Acciones) event.getObject());
    }
    public void verCntSysFormularios() {
        RequestContext.getCurrentInstance().openDialog("cntSysFormularios", modalOptions, null);
    }
    public void llenarVista(SelectEvent event) {
        this.setVista(((mSysFormulario) event.getObject()).getClase());
        getDatoEdicion().setVISTA(Vista);
    }
    /**
     * @return the dAccionesVistaDao
     */
    public DAccionesVistaDao getdAccionesVistaDao() {
        return dAccionesVistaDao;
    }

    /**
     * @param dAccionesVistaDao the dAccionesVistaDao to set
     */
    public void setdAccionesVistaDao(DAccionesVistaDao dAccionesVistaDao) {
        this.dAccionesVistaDao = dAccionesVistaDao;
    }

    /**
     * @return the listDAccionesVistas
     */
    public List<DAccionesVista> getListDAccionesVistas() {
        return listDAccionesVistas;
    }

    /**
     * @param listDAccionesVistas the listDAccionesVistas to set
     */
    public void setListDAccionesVistas(List<DAccionesVista> listDAccionesVistas) {
        this.listDAccionesVistas = listDAccionesVistas;
    }

    /**
     * @return the listAcciones
     */
    public List<Acciones> getListAcciones() {
        return listAcciones;
    }

    /**
     * @param listAcciones the listAcciones to set
     */
    public void setListAcciones(List<Acciones> listAcciones) {
        this.listAcciones = listAcciones;
    }

    /**
     * @return the selectAccionesVista
     */
    /**
     * @param selectAccionesVista the selectAccionesVista to set
     */
    public void setSelectAcciones(DAccionesVista selectAccionesVista) {
        this.selectDAccionesVistas = selectAccionesVista;
    }

    /**
     * @return the accionesDao
     */
    public AccionesDao getAccionesDao() {
        return accionesDao;
    }

    /**
     * @param accionesDao the accionesDao to set
     */
    public void setAccionesDao(AccionesDao accionesDao) {
        this.accionesDao = accionesDao;
    }

    /**
     * @return the vistas
     */
    public List<String> getVistas() {
        return vistas;
    }

    /**
     * @param vistas the vistas to set
     */
    public void setVistas(List<String> vistas) {
        this.vistas = vistas;
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
     * @return the selectDAccionesVistas
     */
    public DAccionesVista getSelectDAccionesVistas() {
        return selectDAccionesVistas;
    }

    /**
     * @param selectDAccionesVistas the selectDAccionesVistas to set
     */
    public void setSelectDAccionesVistas(DAccionesVista selectDAccionesVistas) {
        this.selectDAccionesVistas = selectDAccionesVistas;
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
     * @return the Method
     */
    public String getMethod() {
        return Method;
    }

    /**
     * @param Method the Method to set
     */
    public void setMethod(String Method) {
        this.Method = Method;
    }

    /**
     * @return the Acciones
     */
    public Acciones getAcciones() {
        return Acciones;
    }

    /**
     * @param Acciones the Acciones to set
     */
    public void setAcciones(Acciones Acciones) {
        this.Acciones = Acciones;
    }

    /**
     * @return the Vista
     */
    public String getVista() {
        return Vista;
    }

    /**
     * @param Vista the Vista to set
     */
    public void setVista(String Vista) {
        this.Vista = Vista;
    }
}