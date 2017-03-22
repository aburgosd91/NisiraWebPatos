/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AccionesDao;
import com.nisira.core.dao.ActividadesDao;
import com.nisira.core.dao.DAccionesDao;
import com.nisira.core.entity.Acciones;
import com.nisira.core.entity.Actividades;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Combos;
import com.nisira.core.entity.DAcciones;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.util.WebUtil;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean(name = "daccionAction")
@ViewScoped 
public class DAccionAction {
    /* 
        0-> Visualizar
        1-> Nuevo
        2-> Modificar
    */
    private List<Acciones> listAcciones;
    private AccionesDao accionesDao;
    private Acciones selectAcciones;
    private List<Actividades> listActividades;
    private List<Actividades> selectListActividades;
    private ActividadesDao actividadesDao;
    private List<DAcciones> listDAcciones;
    private DAccionesDao daccionesDao;
    private DAcciones selectDAcciones;
    private DAcciones objDAcciones;
    private boolean activarBotones;
    /******************************************************/
    private String empresa;
    private String mensaje;
   
    public DAccionAction() {
        empresa=ConstantesBD.IDEMPRESA;
        listAcciones = new ArrayList<Acciones>();
        listActividades = new ArrayList<Actividades>();
        accionesDao = new AccionesDao();
        actividadesDao = new ActividadesDao();
        listDAcciones = new ArrayList<DAcciones>();
        daccionesDao = new DAccionesDao();
//        selectAcciones = new Acciones();
        selectListActividades = new ArrayList<Actividades>();
        activarBotones = true;
    }
    public void getRecordAcciones() throws Exception{
        setListAcciones(accionesDao.findAll(empresa));
        RequestContext.getCurrentInstance().update("datos:listActividades");
        return;
    }
    public void getRecordActividades() throws Exception{
        setListActividades(actividadesDao.findAll(empresa));
        RequestContext.getCurrentInstance().update("datos2:listActividades");
        return;
    }
    public void getRecordDAcciones() throws Exception{
        setListDAcciones(daccionesDao.findAll(new DAcciones(Integer.parseInt(empresa),getSelectAcciones().getIdaccion(),0)));
        RequestContext.getCurrentInstance().update("datos3:informacion:listDAcciones");
        return;
    }
    public void onCheck(){
        try{
            System.out.println("---onCheck---");
            System.out.println("("+selectAcciones.getIdaccion()+")->"+selectAcciones.getDescripcion() );
            getRecordDAcciones();
            /*LIMPIAR*/
            activarBotones=true;
            setSelectDAcciones(new DAcciones());
            setSelectListActividades(new ArrayList<Actividades>());
            llenarSelectDAccionesActividades();
            RequestContext.getCurrentInstance().update("datos2:informacion");
            RequestContext.getCurrentInstance().update("datos2:informacion:listActividades");
            RequestContext.getCurrentInstance().update("datos3:informacion");
            RequestContext.getCurrentInstance().update("datos3:informacion:listDAcciones");
//            RequestContext.getCurrentInstance().update("datos3:informacion:listDAcciones");
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    public void onCheck_(){
        try{
          System.out.println("selectListActividades size : "+selectListActividades.size());
//        RequestContext.getCurrentInstance().update("datos3:informacion:listDAcciones");
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    public void onRowEdit(){
        
    }
    public void onRowCancel(){
        
    }
    public void onSelectDAcciones(){
        try{
            System.out.println("--onSelectDAcciones-- " + selectDAcciones.getAccion());
            activarBotones=false;
//            RequestContext.getCurrentInstance().update("datos3:informacion");
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    public void agregarDetalle(){
        List<DAcciones> lista = getElementosAgregar();
        if(lista!=null){
            if(lista.size()>0){
                listDAcciones=lista;
                refreshOrdenamiento();
            }
            else{
                listDAcciones=new ArrayList<DAcciones>();
            }
            RequestContext.getCurrentInstance().update("datos3");
            RequestContext.getCurrentInstance().update("datos3:informacion");
            RequestContext.getCurrentInstance().update("datos3:informacion:listDAcciones");
        }
//        RequestContext.getCurrentInstance().execute("PF('dlGuardarDAcciones').show()");
    }
    public void subirDetalle(){
        try{
            int pos = listDAcciones.indexOf(selectDAcciones);
            int torden=0;
            if(pos>0 & pos<listDAcciones.size()){
                DAcciones temp = listDAcciones.get(pos-1);
                DAcciones objremp = listDAcciones.get(pos);
                torden=objremp.getOrden();
                objremp.setOrden(temp.getOrden());
                temp.setOrden(torden);
                listDAcciones.set(pos, temp);
                listDAcciones.set(pos-1, objremp);
                selectDAcciones=new DAcciones();
                RequestContext.getCurrentInstance().update("datos3");
                RequestContext.getCurrentInstance().update("datos3:informacion");
                RequestContext.getCurrentInstance().update("datos3:informacion:listDAcciones");
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    public void bajarDetalle(){
        try{
            int pos = listDAcciones.indexOf(selectDAcciones);
            int torden=0;
            if(pos>=0 & pos<listDAcciones.size()){
                DAcciones temp = listDAcciones.get(pos+1);
                DAcciones objremp = listDAcciones.get(pos);
                torden=objremp.getOrden();
                objremp.setOrden(temp.getOrden());
                temp.setOrden(torden);
                listDAcciones.set(pos, temp);
                listDAcciones.set(pos+1, objremp);
                selectDAcciones=new DAcciones();
                RequestContext.getCurrentInstance().update("datos3");
                RequestContext.getCurrentInstance().update("datos3:informacion");
                RequestContext.getCurrentInstance().update("datos3:informacion:listDAcciones");
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    
    public void guardarDetalle(){
        try{
            mensaje=daccionesDao.grabar(listDAcciones);
            if (!mensaje.equals("")) {
                WebUtil.info("DAcciones " + selectAcciones.getIdaccion() + " actualizado con éxito.");
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            WebUtil.MensajeError(mensaje);
        }
    }

    public List<DAcciones> getElementosAgregar(){
        List<DAcciones> listDAccionesObj = new ArrayList<DAcciones>();
        /* selectAcciones vs listDAcciones*/
        //Filtro
        List<Actividades> tempSeleccionActividades = selectListActividades;
//        for(DAcciones acc:listDAcciones){
//            for(int i=0;i<tempSeleccionActividades.size();i++){
//                Actividades act = tempSeleccionActividades.get(i);
//                if((acc.getIdempresa()== act.getIdempresa()) && 
//                        (act.getIdactividades()== acc.getIdactividades()) && 
//                            (acc.getIdaccion()== selectAcciones.getIdaccion()) ){
//                    tempSeleccionActividades.remove(act);
//                    break;
//                }
//            }   
//        }
        /*Crear Objetos DAcciones*/
        for(Actividades objAct : tempSeleccionActividades){
            DAcciones obj = new DAcciones();
            obj.setIdempresa(Integer.parseInt(empresa));
            obj.setIdaccion(selectAcciones.getIdaccion());
            obj.setAccion(selectAcciones.getDescripcion());
            obj.setIdactividades(objAct.getIdactividades());
            obj.setActividades(objAct.getDescripcion());
            obj.setDatos(0);
            obj.setOrden(0);
            listDAccionesObj.add(obj);
        }
        return listDAccionesObj;
    }
    public void llenarSelectDAccionesActividades(){
        for(DAcciones obj :getListDAcciones()){
            Actividades exp =buscarActividades(obj.getIdempresa(),obj.getIdactividades());
            if(exp!=null){
                getSelectListActividades().add(exp);
            }
        }
    }
    public Actividades buscarActividades(int idempresa, int idactividades){
        Actividades obj = null;
        if(getListActividades().size()>0){
            for(Actividades exp : getListActividades()){
                if(exp.getIdempresa()==idempresa & exp.getIdactividades()==idactividades){
                    obj=exp;
                    break;
                }
            }
        }
        return obj;
    }
    
    /**
     * @return the listAcciones
     */
    
    public void refreshOrdenamiento(){
        int i=1;
        int j=0;
        for(DAcciones obj:listDAcciones){
            obj.setOrden(i++);
            listDAcciones.set(j++, obj);
        }
    }
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
     * @return the listActividades
     */
    public List<Actividades> getListActividades() {
        return listActividades;
    }

    /**
     * @param listActividades the listActividades to set
     */
    public void setListActividades(List<Actividades> listActividades) {
        this.listActividades = listActividades;
    }

    /**
     * @return the listDAcciones
     */
    public List<DAcciones> getListDAcciones() {
        return listDAcciones;
    }

    /**
     * @param listDAcciones the listDAcciones to set
     */
    public void setListDAcciones(List<DAcciones> listDAcciones) {
        this.listDAcciones = listDAcciones;
    }

    /**
     * @return the daccionesDao
     */
    public DAccionesDao getDaccionesDao() {
        return daccionesDao;
    }

    /**
     * @param daccionesDao the daccionesDao to set
     */
    public void setDaccionesDao(DAccionesDao daccionesDao) {
        this.daccionesDao = daccionesDao;
    }

    /**
     * @return the selectAcciones
     */
    public Acciones getSelectAcciones() {
        return selectAcciones;
    }

    /**
     * @param selectAcciones the selectAcciones to set
     */
    public void setSelectAcciones(Acciones selectAcciones) {
        this.selectAcciones = selectAcciones;
    }

    /**
     * @return the selectListActividades
     */
    public List<Actividades> getSelectListActividades() {
        return selectListActividades;
    }

    /**
     * @param selectListActividades the selectListActividades to set
     */
    public void setSelectListActividades(List<Actividades> selectListActividades) {
        this.selectListActividades = selectListActividades;
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
     * @return the selectDAcciones
     */
    public DAcciones getSelectDAcciones() {
        return selectDAcciones;
    }

    /**
     * @param selectDAcciones the selectDAcciones to set
     */
    public void setSelectDAcciones(DAcciones selectDAcciones) {
        this.selectDAcciones = selectDAcciones;
    }

    /**
     * @return the objDAcciones
     */
    public DAcciones getObjDAcciones() {
        return objDAcciones;
    }

    /**
     * @param objDAcciones the objDAcciones to set
     */
    public void setObjDAcciones(DAcciones objDAcciones) {
        this.objDAcciones = objDAcciones;
    }

    /**
     * @return the activarBotones
     */
    public boolean isActivarBotones() {
        return activarBotones;
    }

    /**
     * @param activarBotones the activarBotones to set
     */
    public void setActivarBotones(boolean activarBotones) {
        this.activarBotones = activarBotones;
    }
}
