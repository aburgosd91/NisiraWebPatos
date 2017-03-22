/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.OperarioDao;
import com.nisira.core.entity.Operario;
import com.nisira.core.service.OperarioService;
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
@ManagedBean(name = "operarioAction")
@SessionScoped
public class OperarioAction extends AbstactListAction<Operario> implements Serializable {
    /* NOTAS:
     0-> Visualizar
     1-> Nuevo
     2-> Modificar
     */
    private String mensaje;
    private OperarioService operarioService;
    private UsuarioBean user;
    private int nuevod;

    public OperarioAction() {
        mensaje = "";
        operarioService = new OperarioService();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_operario");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_operario");
            setListaDatos(operarioService.getRecordOperario(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        operarioService = new OperarioService();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_operario");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Operario());
            getDatoEdicion().setIDEMPRESA(user.getIDEMPRESA());
            getDatoEdicion().setESTADO(true);
            nuevod = 1;
            RequestContext.getCurrentInstance().update("datos:dlGuardarOperario");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarOperario').show()");

        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }
    @Override
    public void doNuevo() throws IOException {
        setLadd(1);
        nuevo();        
    }
    @Override
    public void grabar() {
        try {
            if (getDatoEdicion().getIDOPERARIO().equals("")) {
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.setMensaje("Ingrese Documento Identidad");
            } else if (getDatoEdicion().getIDOPERARIO().length() != 8) {
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                WebUtil.MensajeAlerta("Id deberá tener 8 digitos");
                this.setMensaje("Id deberá tener 8 digitos");
            } else {
                if (nuevod == 1) {//Nuevo
                    mensaje = getOperarioService().addOperario(getDatoEdicion());
                    if (!mensaje.equals("")) {
                        WebUtil.info("Operario " + getDatoEdicion().getAP_PATERNO() + " " + getDatoEdicion().getAP_MATERNO() + ", " + getDatoEdicion().getNOMBRES() + " registrado con éxito.");
                    }
                    setDatoEdicion(new Operario());
                    getDatoEdicion().setIDEMPRESA(user.getIDEMPRESA());
                    getDatoEdicion().setESTADO(true);
                    RequestContext.getCurrentInstance().update("FormularioGrabarOperario");
                } else if (nuevod == 2) {//Modificar
                    mensaje = getOperarioService().editOperario(getDatoEdicion());
                    if (!mensaje.equals("")) {
                        WebUtil.info("Operario " + getDatoEdicion().getAP_PATERNO() + " " + getDatoEdicion().getAP_MATERNO() + ", " + getDatoEdicion().getNOMBRES() + " actualizado con éxito.");
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
                getDatoEdicion().setESTADO(false);
                mensaje = getOperarioService().editOperario(getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                (new OperarioDao()).anular(getDatoEdicion());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(OperarioAction.class.getName()).log(Level.SEVERE, null, ex);
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
            RequestContext.getCurrentInstance().update("datos:dlGuardarOperario");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarOperario').show()");
            setDatoEdicion(getDatoSeleccionado());

        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public OperarioService getOperarioService() {
        return operarioService;
    }

    public void setOperarioService(OperarioService operarioService) {
        this.operarioService = operarioService;
    }

    public int getNuevod() {
        return nuevod;
    }

    public void setNuevod(int nuevod) {
        this.nuevod = nuevod;
    }

}
