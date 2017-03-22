/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.NotificacionDao;
import com.nisira.core.dao.MontacargaDao;
import com.nisira.core.dao.ParametrosDao;
import com.nisira.core.dao.ProcesosDao;
import com.nisira.core.dao.QuickNotesDao;
import com.nisira.core.entity.EnvioNotificacion;
import com.nisira.core.entity.Notificacion;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Montacarga;
import com.nisira.core.entity.Parametros;
import com.nisira.core.entity.Procesos;
import com.nisira.core.entity.QuickNotes;
import com.nisira.core.service.MultitablaService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean(name = "notificacionAction")
@SessionScoped
public class NotificacionAction extends AbstactListAction<Notificacion> implements Serializable{
    /* NOTAS:
     0-> Visualizar
     1-> Nuevo
     2-> Modificar
     */
    private String mensaje;
    /*OPERARIO*/
    private List<Montacarga> listMontacarga;
    private List<Montacarga> selectListMontacarga;
    private MontacargaDao montacargaDao;
    /*NOTIFICACION*/
    private List<Notificacion> listNotificacion;
    private NotificacionDao notificacionDao;
    private Notificacion selectNotificacion;
    private boolean botonEditarNotificacion;
    private boolean botonEliminarNotificacion;
    private boolean estado;
    /*ENVIONOTIFICACIONES*/
    private EnvioNotificacion selectEnvioNotificacion;
    private List<EnvioNotificacion> listEnvioNotificacion;
    private boolean botonGuardarEnvioNotificacion;
    private boolean botonEditarEnvioNotificacion;
    private boolean botonEliminarEnvioNotificacion;
    /******NOTAS RÁPIDAS******/
    private List<QuickNotes> listQuickNotes;
    private QuickNotesDao quicknotesDao;
    private QuickNotes  selectQuickNotes;
    /**/
    private UsuarioBean user;
    
    public NotificacionAction() {
        mensaje = "";
        botonEditarNotificacion = true;
        botonEliminarNotificacion = true;
        listNotificacion = new ArrayList<Notificacion>();
        notificacionDao = new NotificacionDao();
        montacargaDao = new MontacargaDao();
        listMontacarga = new ArrayList<Montacarga>();
        listEnvioNotificacion = new ArrayList<EnvioNotificacion>();
        quicknotesDao = new QuickNotesDao();
        listQuickNotes = new ArrayList<QuickNotes>();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        estado =true;
        actualiza_ventana("wMnt_notificacion");
    }
    
    public void InhabilitarEnvioNotificacion() {
        try {
            int pos = listEnvioNotificacion.indexOf(selectEnvioNotificacion);
            listEnvioNotificacion.remove(pos);
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    
    public void openDialogMontacarga(){
        setSelectListMontacarga(new ArrayList<Montacarga>());
        buscarTodoMontacarga();
        RequestContext.getCurrentInstance().update("datos:dlgnew_montacarga");
        RequestContext.getCurrentInstance().update("datos:dlgnew_montacarga:listMontacarga");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_montacarga').show()");
    }
    
    public void openDialogQuickNote(){
        try {
            setListQuickNotes(quicknotesDao.findAll(getUser().getIDEMPRESA()));
            selectQuickNotes = new QuickNotes();
            RequestContext.getCurrentInstance().update("datos:dlgnew_quicknotes");
            RequestContext.getCurrentInstance().update("datos:dlgnew_quicknotes:listQuickNotes");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_quicknotes').show()");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.error(getMensaje());
        }
    }
    
    public void buscarTodoMontacarga() {
        try {
            setListMontacarga(getMontacargaDao().findAll(getUser().getIDEMPRESA()));
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    
    public void onCheck_(){
        try{
          System.out.println("selectListMontacarga size : "+selectListMontacarga.size());
//        RequestContext.getCurrentInstance().update("datos3:informacion:listDAcciones");
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    
    public void onCheck(){
        try{
            getDatoEdicion().setMensaje(selectQuickNotes.getMensaje());
            RequestContext.getCurrentInstance().update("datos:mensaje");
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_notificacion");
            setListaDatos(getNotificacionDao().findAll(getUser().getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void findDetalles(){
        try {
            estado=getDatoEdicion().getEstado()==1?true:false;
            setListEnvioNotificacion(getNotificacionDao().findAllDetalle(getDatoEdicion()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        setMensaje("");
        botonEditarNotificacion = true;
        botonEliminarNotificacion = true;
        listNotificacion = new ArrayList<Notificacion>();
        notificacionDao = new NotificacionDao();
        montacargaDao = new MontacargaDao();
        listMontacarga = new ArrayList<Montacarga>();
        listEnvioNotificacion = new ArrayList<EnvioNotificacion>();
        quicknotesDao = new QuickNotesDao();
        listQuickNotes = new ArrayList<QuickNotes>();
        /*Botones*/
        botonEliminarEnvioNotificacion=false;
        actualiza_ventana("wMnt_notificacion");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Notificacion());
        getDatoEdicion().setIdempresa(Integer.parseInt(getUser().getIDEMPRESA()));
        getDatoEdicion().setEstado(1);
        estado=true;
        getDatoEdicion().setPrioridad(1);
    }

    @Override
    public void grabar() {
        try {
            if (getDatoEdicion().getMensaje().equals("")) {
                this.setMensaje("Ingrese Mensaje");
            } else if (getDatoEdicion().getPrioridad()<= 0) {
                this.setMensaje("Ingrese Prioridad Mayor a 0");
            }else {
                if (getLadd()== 1) {//Nuevo
                    this.setMensaje(notificacionDao.grabar(getDatoEdicion(), getListEnvioNotificacion()));
                    RequestContext.getCurrentInstance().update("datos:tbl");
                } else if (getLadd() == 2) {//Modificar
                    getDatoEdicion().setEstado(estado?1:0);
                    this.setMensaje(notificacionDao.actualizar(getDatoEdicion(), getListEnvioNotificacion()));
                    RequestContext.getCurrentInstance().update("datos:tbl");
                }
            }
            WebUtil.MensajeAlerta(getMensaje());
//            RequestContext.getCurrentInstance().update("dlgFormNuevoSucursal");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.error(getMensaje());
            return;
        }
    }

    @Override
    public void eliminar() {
        try {
            
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setEstado(0);
                this.setMensaje(notificacionDao.anular(getDatoEdicion()));
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setEstado(2);
                this.setMensaje(notificacionDao.eliminar(getDatoEdicion()));
            }
            WebUtil.MensajeAlerta(getMensaje());
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(NotificacionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EnviarNotificacion(){
        try{
            if(selectListMontacarga.size()>0){
                EnvioNotificacion detaenvio;
                for(Montacarga mt :selectListMontacarga){
                    detaenvio=new EnvioNotificacion();
                    detaenvio.setIdempresa(Integer.parseInt(getUser().getIDEMPRESA()));
                    detaenvio.setIdenvionotificacion(maxNumerador()+1);
                    detaenvio.setIdnotifiacion(0);
                    detaenvio.setIdmontacarga(mt.getIDMONTACARGA());
                    detaenvio.setMontacarga(mt.getDESCRIPCION());
                    
                    detaenvio.setFechaenvio(WebUtil.fechaDMY(new Date(), 4));
                    listEnvioNotificacion.add(detaenvio);
                }
                setMensaje("Se Cargó Correctamente");
                RequestContext.getCurrentInstance().execute("PF('dlgnew_montacarga').hide()");
                RequestContext.getCurrentInstance().update("datos:tbl");
            }else{
                setMensaje("Deberá seleccionar montacargas");
            }
            WebUtil.MensajeAlerta(getMensaje());
        }catch(Exception ex){
            setMensaje(ex.getMessage());
            WebUtil.error(getMensaje());
        }
    }
    
    public int maxNumerador(){
        int num=0;
        int max =0;
        if(listEnvioNotificacion.size()>0){
            for(EnvioNotificacion obj:listEnvioNotificacion){
                if(obj.getIdenvionotificacion()>max)
                    max=obj.getIdenvionotificacion();
            }
            num=max;
        }
        return num;
    }
    
    public void onRowSelectEnvioNotificacion(){
        botonEliminarEnvioNotificacion=true;
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
     * @return the listNotificacion
     */
    public List<Notificacion> getListNotificacion() {
        return listNotificacion;
    }

    /**
     * @param listNotificacion the listNotificacion to set
     */
    public void setListNotificacion(List<Notificacion> listNotificacion) {
        this.listNotificacion = listNotificacion;
    }

    /**
     * @return the notificacionDao
     */
    public NotificacionDao getNotificacionDao() {
        return notificacionDao;
    }

    /**
     * @param notificacionDao the notificacionDao to set
     */
    public void setNotificacionDao(NotificacionDao notificacionDao) {
        this.notificacionDao = notificacionDao;
    }

    /**
     * @return the selectNotificacion
     */
    public Notificacion getSelectNotificacion() {
        return selectNotificacion;
    }

    /**
     * @param selectNotificacion the selectNotificacion to set
     */
    public void setSelectNotificacion(Notificacion selectNotificacion) {
        this.selectNotificacion = selectNotificacion;
    }

    /**
     * @return the botonEditarNotificacion
     */
    public boolean isBotonEditarNotificacion() {
        return botonEditarNotificacion;
    }

    /**
     * @param botonEditarNotificacion the botonEditarNotificacion to set
     */
    public void setBotonEditarNotificacion(boolean botonEditarNotificacion) {
        this.botonEditarNotificacion = botonEditarNotificacion;
    }

    /**
     * @return the botonEliminarNotificacion
     */
    public boolean isBotonEliminarNotificacion() {
        return botonEliminarNotificacion;
    }

    /**
     * @param botonEliminarNotificacion the botonEliminarNotificacion to set
     */
    public void setBotonEliminarNotificacion(boolean botonEliminarNotificacion) {
        this.botonEliminarNotificacion = botonEliminarNotificacion;
    }

    /**
     * @return the onRowSelectEnvioNotificacion
     */
    public EnvioNotificacion getSelectEnvioNotificacion() {
        return selectEnvioNotificacion;
    }

    /**
     * @param onRowSelectEnvioNotificacion the onRowSelectEnvioNotificacion to set
     */
    public void setSelectEnvioNotificacion(EnvioNotificacion selectEnvioNotificacion) {
        this.selectEnvioNotificacion = selectEnvioNotificacion;
    }

    /**
     * @return the listEnvioNotificacion
     */
    public List<EnvioNotificacion> getListEnvioNotificacion() {
        return listEnvioNotificacion;
    }

    /**
     * @param listEnvioNotificacion the listEnvioNotificacion to set
     */
    public void setListEnvioNotificacion(List<EnvioNotificacion> listEnvioNotificacion) {
        this.listEnvioNotificacion = listEnvioNotificacion;
    }

    /**
     * @return the botonGuardarEnvioNotificacion
     */
    public boolean isBotonGuardarEnvioNotificacion() {
        return botonGuardarEnvioNotificacion;
    }

    /**
     * @param botonGuardarEnvioNotificacion the botonGuardarEnvioNotificacion to set
     */
    public void setBotonGuardarEnvioNotificacion(boolean botonGuardarEnvioNotificacion) {
        this.botonGuardarEnvioNotificacion = botonGuardarEnvioNotificacion;
    }

    /**
     * @return the botonEditarEnvioNotificacion
     */
    public boolean isBotonEditarEnvioNotificacion() {
        return botonEditarEnvioNotificacion;
    }

    /**
     * @param botonEditarEnvioNotificacion the botonEditarEnvioNotificacion to set
     */
    public void setBotonEditarEnvioNotificacion(boolean botonEditarEnvioNotificacion) {
        this.botonEditarEnvioNotificacion = botonEditarEnvioNotificacion;
    }

    /**
     * @return the botonEliminarEnvioNotificacion
     */
    public boolean isBotonEliminarEnvioNotificacion() {
        return botonEliminarEnvioNotificacion;
    }

    /**
     * @param botonEliminarEnvioNotificacion the botonEliminarEnvioNotificacion to set
     */
    public void setBotonEliminarEnvioNotificacion(boolean botonEliminarEnvioNotificacion) {
        this.botonEliminarEnvioNotificacion = botonEliminarEnvioNotificacion;
    }

    /**
     * @return the user
     */
    public UsuarioBean getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    /**
     * @return the listMontacarga
     */
    public List<Montacarga> getListMontacarga() {
        return listMontacarga;
    }

    /**
     * @param listMontacarga the listMontacarga to set
     */
    public void setListMontacarga(List<Montacarga> listMontacarga) {
        this.listMontacarga = listMontacarga;
    }

    /**
     * @return the selectListMontacarga
     */
    public List<Montacarga> getSelectListMontacarga() {
        return selectListMontacarga;
    }

    /**
     * @param selectListMontacarga the selectListMontacarga to set
     */
    public void setSelectListMontacarga(List<Montacarga> selectListMontacarga) {
        this.selectListMontacarga = selectListMontacarga;
    }

    /**
     * @return the montacargaDao
     */
    public MontacargaDao getMontacargaDao() {
        return montacargaDao;
    }

    /**
     * @param montacargaDao the montacargaDao to set
     */
    public void setMontacargaDao(MontacargaDao montacargaDao) {
        this.montacargaDao = montacargaDao;
    }

    /**
     * @return the listQuickNotes
     */
    public List<QuickNotes> getListQuickNotes() {
        return listQuickNotes;
    }

    /**
     * @param listQuickNotes the listQuickNotes to set
     */
    public void setListQuickNotes(List<QuickNotes> listQuickNotes) {
        this.listQuickNotes = listQuickNotes;
    }

    /**
     * @return the notesDao
     */
    public QuickNotesDao getQuickNotesDao() {
        return quicknotesDao;
    }

    /**
     * @param notesDao the notesDao to set
     */
    public void setQuickNotesDao(QuickNotesDao notesDao) {
        this.quicknotesDao = notesDao;
    }

    /**
     * @return the selectQuickNotes
     */
    public QuickNotes getSelectQuickNotes() {
        return selectQuickNotes;
    }

    /**
     * @param selectQuickNotes the selectQuickNotes to set
     */
    public void setSelectQuickNotes(QuickNotes selectQuickNotes) {
        this.selectQuickNotes = selectQuickNotes;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
