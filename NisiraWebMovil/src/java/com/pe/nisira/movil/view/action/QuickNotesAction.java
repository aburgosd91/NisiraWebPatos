/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.QuickNotesDao;
import com.nisira.core.entity.QuickNotes;
import com.nisira.core.entity.QuickNotes;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean(name = "quicknotesAction")
@SessionScoped
public class QuickNotesAction extends AbstactListAction<QuickNotes> implements Serializable {
    /* NOTAS:
        0-> Visualizar
        1-> Nuevo
        2-> Modificar
     */
    private String mensaje;
    private QuickNotesDao quicknotesesDao;
    private UsuarioBean user;
    private int nuevod;
    private boolean estado;
    public QuickNotesAction() {
        mensaje = "";
        quicknotesesDao = new QuickNotesDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_quicknotes");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_quicknotes");
            setListaDatos(getQuickNotesDao().findAll(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        setQuickNotesDao(new QuickNotesDao());
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_quicknotes");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new QuickNotes());
            getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
            getDatoEdicion().setEstado(1);
            estado=true;
            nuevod = 1;
            RequestContext.getCurrentInstance().update("datos:dlGuardarQuickNotes");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarQuickNotes').show()");

        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }
    @Override
    public void doNuevo() throws IOException {
        estado=true;
        setLadd(1);
        nuevo();        
    }
    @Override
    public void grabar() {
        try {
            if (getDatoEdicion().getMensaje().equals("")) {
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.setMensaje("Ingrese Mensaje");
            }else {
                if (nuevod == 1) {//Nuevo
                    mensaje = getQuickNotesDao().grabar(getDatoEdicion());
                    if (!mensaje.equals("")) {
                        WebUtil.info("QuickNotes " + getDatoEdicion().getIdnotes()+ " registrado con éxito.");
                    }
                    setDatoEdicion(new QuickNotes());
                    getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
                    getDatoEdicion().setEstado(1);
                    RequestContext.getCurrentInstance().update("FormularioGrabarQuickNotes");
                } else if (nuevod == 2) {//Modificar
                    getDatoEdicion().setEstado(estado?1:0);
                    mensaje = getQuickNotesDao().actualizar(getDatoEdicion());
                    if (!mensaje.equals("")) {
                        WebUtil.info("QuickNotes " + getDatoEdicion().getIdnotes()+ " actualizado con éxito.");
                    }
                }
                buscarTodo();
                RequestContext.getCurrentInstance().update("datos");
                RequestContext.getCurrentInstance().update("datos:tbl");
            }
//            RequestContext.getCurrentInstance().update("dlgFormNuevoSucursal");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeError(mensaje);

            return;
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setEstado(0);
                mensaje = getQuickNotesDao().anular(getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                (new QuickNotesDao()).eliminar(getDatoEdicion());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(QuickNotesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void doEditar_lista() throws IOException {
        if (getDatoSeleccionado() == null) {
            WebUtil.MensajeAdvertencia("Debe seleccionar registro a editar.");
        } else {
            setLadd(2);
            nuevod = 2;
            setDatoEdicion(getDatoSeleccionado());
            estado = getDatoSeleccionado().getEstado()== 1?true:false;
            RequestContext.getCurrentInstance().update("datos:dlGuardarQuickNotes");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarQuickNotes').show()");
            setDatoEdicion(getDatoSeleccionado());

        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getNuevod() {
        return nuevod;
    }

    public void setNuevod(int nuevod) {
        this.nuevod = nuevod;
    }

    /**
     * @return the quicknotesesDao
     */
    public QuickNotesDao getQuickNotesDao() {
        return quicknotesesDao;
    }

    /**
     * @param quicknotesesDao the quicknotesesDao to set
     */
    public void setQuickNotesDao(QuickNotesDao quicknotesesDao) {
        this.quicknotesesDao = quicknotesesDao;
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
