/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AntenaDao;
import com.nisira.core.entity.Antena;
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
@ManagedBean(name = "antenaAction")
@SessionScoped
public class AntenaAction extends AbstactListAction<Antena> implements Serializable {
    /* NOTAS:
        0-> Visualizar
        1-> Nuevo
        2-> Modificar
     */
    private String mensaje;
    private AntenaDao antenaesDao;
    private UsuarioBean user;
    private int nuevod;
    private boolean estado;
    public AntenaAction() {
        mensaje = "";
        antenaesDao = new AntenaDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_antena");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_antena");
            setListaDatos(getAntenaDao().findAll(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        setAntenaDao(new AntenaDao());
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_antena");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Antena());
            getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
            getDatoEdicion().setEstado(1);
            estado=true;
            nuevod = 1;
            RequestContext.getCurrentInstance().update("datos:dlGuardarAntena");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarAntena').show()");

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
            if (getDatoEdicion().getDescripcion().equals("")) {
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.setMensaje("Ingrese Descripción");
            }else {
                if (nuevod == 1) {//Nuevo
                    mensaje = getAntenaDao().grabar(getDatoEdicion());
                    if (!mensaje.equals("")) {
                        WebUtil.info("Antena " + getDatoEdicion().getIdantena()+ " registrado con éxito.");
                    }
                    setDatoEdicion(new Antena());
                    getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
                    getDatoEdicion().setEstado(1);
                    RequestContext.getCurrentInstance().update("FormularioGrabarAntena");
                } else if (nuevod == 2) {//Modificar
                    getDatoEdicion().setEstado(estado?1:0);
                    mensaje = getAntenaDao().actualizar(getDatoEdicion());
                    if (!mensaje.equals("")) {
                        WebUtil.info("Antena " + getDatoEdicion().getIdantena() + " actualizado con éxito.");
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
                mensaje = getAntenaDao().anular(getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                (new AntenaDao()).eliminar(getDatoEdicion());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AntenaAction.class.getName()).log(Level.SEVERE, null, ex);
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
            RequestContext.getCurrentInstance().update("datos:dlGuardarAntena");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarAntena').show()");
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
     * @return the antenaesDao
     */
    public AntenaDao getAntenaDao() {
        return antenaesDao;
    }

    /**
     * @param antenaesDao the antenaesDao to set
     */
    public void setAntenaDao(AntenaDao antenaesDao) {
        this.antenaesDao = antenaesDao;
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
