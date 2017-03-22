/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ProcesosDao;
import com.nisira.core.entity.NumEmisor;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Documento;
import com.nisira.core.entity.Procesos;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.service.NumEmisorService;
import com.nisira.core.service.MultitablaService;
import com.nisira.core.service.DocumentoService;
import com.nisira.core.service.SucursalService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Victor Zavala Llanos <vzavala@nisira.com.pe>
 */
@ManagedBean(name = "documentoAction")
@SessionScoped
public class DocumentoAction extends AbstactListAction<Documento> implements Serializable {

    private DocumentoService documentoService;
    private SucursalService sucursalService;
    private List<Sucursal> listbusquedaSucursal;

    private String mensaje;
    private String filtrobusquedaSucursal;
    private boolean botonNumEmisorEditarDis;
    private boolean botonNumEmisorEliminarDis;

    private boolean botonAgregarDetalle;
    private boolean botonEditarDetalle;

    /*+++++++++++++++++++++++++++++++++++++++ALMACEN++++++++++++++++++++++++++++++++++++++++*/
    private MultitablaService multitablaService;
    private List<Multitabla> listMultitabla;
    private NumEmisorService numemisorService;
    private List<NumEmisor> listNumEmisor;
    private List<NumEmisor> fillNumEmisor;
    private NumEmisor selectNumEmisor;
    private Sucursal selectbusquedaSucursal;
    private NumEmisor newNumEmisor;
    private UsuarioBean user;
    private List<Procesos> lstproc;

    public DocumentoAction() {
        documentoService = new DocumentoService();
        sucursalService = new SucursalService();
        listbusquedaSucursal = new ArrayList<Sucursal>();
        mensaje = "";
        botonAgregarDetalle = false;
        botonEditarDetalle = false;
        botonNumEmisorEditarDis = true;
        botonNumEmisorEliminarDis = true;
        multitablaService = new MultitablaService();
        listMultitabla = new ArrayList<Multitabla>();
        numemisorService = new NumEmisorService();
        listNumEmisor = new ArrayList<NumEmisor>();
        selectNumEmisor = new NumEmisor();
        selectbusquedaSucursal = new Sucursal();
        newNumEmisor = new NumEmisor();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        lstproc = new ArrayList<Procesos>();
        actualiza_ventana("wMnt_documento");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_documento");
            setListaDatos(documentoService.getRecordDocumentoEmpresa(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(DocumentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        documentoService = new DocumentoService();
        sucursalService = new SucursalService();
        listbusquedaSucursal = new ArrayList<Sucursal>();
        mensaje = "";
        botonAgregarDetalle = false;
        botonEditarDetalle = false;
        botonNumEmisorEditarDis = true;
        botonNumEmisorEliminarDis = true;
        multitablaService = new MultitablaService();
        listMultitabla = new ArrayList<Multitabla>();
        numemisorService = new NumEmisorService();
        listNumEmisor = new ArrayList<NumEmisor>();
        selectNumEmisor = new NumEmisor();
        selectbusquedaSucursal = new Sucursal();
        newNumEmisor = new NumEmisor();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        lstproc = new ArrayList<Procesos>();
        actualiza_ventana("wMnt_documento");
        return "";
    }

    public void findDetalle() throws Exception {
        lstproc = (new ProcesosDao()).findAll(user.getIDEMPRESA());
        buscarSucursal();
        if (getDatoEdicion().getIDDOCUMENTO() != null) {
            listNumEmisor = numemisorService.findByDocumento(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDDOCUMENTO());
            fillNumEmisor = listNumEmisor;
        }
    }

    public String itemMaximoDetalle() {
        NumEmisor maxnumemisor = null;
        if (!(listNumEmisor == null)) {
            if (listNumEmisor.size() > 0) {
                maxnumemisor = Collections.max(listNumEmisor, new Comparator<NumEmisor>() {
                    @Override
                    public int compare(NumEmisor first, NumEmisor second) {
                        if (first.getITEM().compareTo(second.getITEM()) > 0) {
                            return 1;
                        } else if (first.getITEM().compareTo(second.getITEM()) < 0) {
                            return -1;
                        }
                        return 0;
                    }
                });
            }
        }
        Integer itemmax = 0;
        if (maxnumemisor != null) {
            itemmax = Integer.parseInt(maxnumemisor.getITEM().trim());
        }
        itemmax = itemmax + 1;

        String item = ("000" + itemmax.toString().trim());
        item = item.substring(item.length() - 3);
        return item;
    }

    public void valoresSucursal() {
        newNumEmisor.setSUCURSAL(selectbusquedaSucursal);
        newNumEmisor.setIDSUCURSAL(selectbusquedaSucursal.getIDSUCURSAL());
        RequestContext.getCurrentInstance().update("datos:contenedorsucursal");
        RequestContext.getCurrentInstance().execute("PF('dlg_sucursal').hide()");

    }

    public void getActionAgregarDetalle() {
        try {
            botonAgregarDetalle = true;
            newNumEmisor.setIDEMPRESA(user.getIDEMPRESA());
            newNumEmisor.setESTADO(1);
            String item = itemMaximoDetalle();
            newNumEmisor.setITEM(item);
            RequestContext.getCurrentInstance().update("datos:dlg_detalle");
            RequestContext.getCurrentInstance().execute("PF('dlg_detalle').show()");
            return;
        } catch (Exception ex) {
            mensaje = ex.toString();
            WebUtil.MensajeErrorNuevo("mensajeDocumento", "Error agrega detalle: " + this.mensaje);
            return;
        }
    }

    public void getActionEditarDetalle() {
        try {
            botonEditarDetalle = true;
            newNumEmisor = selectNumEmisor;
            RequestContext.getCurrentInstance().update("datos:dlg_detalle");
            RequestContext.getCurrentInstance().execute("PF('dlg_detalle').show()");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getActionEliminarDetalle() {
        try {
            listNumEmisor.remove(selectNumEmisor);
            selectNumEmisor = new NumEmisor();
            RequestContext.getCurrentInstance().update("datos:tbl");
            RequestContext.getCurrentInstance().update("dlg_detalle");

            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());

            return;
        }
    }

    public void onRowSelectNumEmisor(SelectEvent event) throws IOException {
        setBotonNumEmisorEditarDis(false);
        setBotonNumEmisorEliminarDis(false);
        RequestContext.getCurrentInstance().update("datos:detbar");
    }

    public void onRowUnselectNumEmisor(UnselectEvent event) throws IOException {
        setBotonNumEmisorEditarDis(true);
        setBotonNumEmisorEliminarDis(true);
        RequestContext.getCurrentInstance().update("datos:detbar");
    }

    public void buscarSucursal() {
        try {
            listbusquedaSucursal = sucursalService.findByFiltro(user.getIDEMPRESA(), filtrobusquedaSucursal);

        } catch (Exception ex) {
            WebUtil.MensajeErrorNuevo("mensajeBusquedaSucursal", ex.toString());
        }
    }

    public void AgregarEditarDetalle() {
        try {

            if (newNumEmisor.getIDSUCURSAL().equals("")) {
                this.mensaje = "Seleccione una Sucursal";
                WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioNumEmisor:idsucursal');");
                return;
            }
            if (newNumEmisor.getSERIE().equals("") || newNumEmisor.getSERIE().equals("0000")) {
                this.mensaje = "Ingrese Serie";
                WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioNumEmisor:serie');");
                return;
            }
            if (newNumEmisor.getNUMERO().equals("") || newNumEmisor.getNUMERO().equals("0000000")) {
                this.mensaje = "Ingrese Numero";
                WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('datos:numero');");
                return;
            }

            if (botonAgregarDetalle) {
                for (NumEmisor detalle : listNumEmisor) {
                    if (detalle.getIDSUCURSAL().trim().equals(newNumEmisor.getIDSUCURSAL().trim())
                            && detalle.getSERIE().trim().equals(newNumEmisor.getSERIE().trim())) {
                        this.mensaje = "La sucursal y serie ingresada ya estan registradas en el item" + detalle.getITEM();
                        WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                        //RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioNumEmisor:numero');");
                        return;
                    }
                }
                listNumEmisor.add(newNumEmisor);
            }
            if (botonEditarDetalle) {
                for (NumEmisor detalle : listNumEmisor) {
                    if (detalle.getIDSUCURSAL().trim().equals(newNumEmisor.getIDSUCURSAL().trim())
                            && detalle.getSERIE().trim().equals(newNumEmisor.getSERIE().trim())
                            && detalle.getITEM().trim().compareTo(newNumEmisor.getITEM()) != 0) {
                        this.mensaje = "La sucursal y serie ingresada ya estan registradas en el item" + detalle.getITEM();
                        WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                        //RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioNumEmisor:numero');");
                        return;
                    }
                }
                for (NumEmisor detalle : listNumEmisor) {
                    if (detalle.getITEM().trim().equals(newNumEmisor.getITEM().trim())) {
                        detalle = newNumEmisor;
                    }
                }
            }
            botonAgregarDetalle = false;
            botonEditarDetalle = false;

            RequestContext.getCurrentInstance().execute("PF('dlg_detalle').hide()");
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);

            return;
        }
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new Documento());
        getDatoEdicion().setIDEMPRESA(user.getIDEMPRESA());
    }

    public boolean validarCabecera() {
        try {
            if (getDatoEdicion().getIDDOCUMENTO() == null) {
                this.mensaje = "Ingrese Codigo del Documento, debe tener 3 caracteres";
                WebUtil.MensajeErrorNuevo("mensajeDocumento", this.mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioDocumento:codigo');");
                return false;
            }
            if (getDatoEdicion().getIDDOCUMENTO().trim().length() < 3) {
                this.mensaje = "Ingrese Codigo del Documento, debe tener 3 caracteres";
                WebUtil.MensajeErrorNuevo("mensajeDocumento", this.mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioDocumento:codigo');");
                return false;
            }
            if (getDatoEdicion().getDESCRIPCION() == null) {
                this.mensaje = "Ingrese Descripción";
                WebUtil.MensajeErrorNuevo("mensajeDocumento", this.mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioDocumento:descripcion');");
                return false;
            }
            if (getDatoEdicion().getDESCRIPCION().trim().length() == 0) {
                this.mensaje = "Ingrese Descripción";
                WebUtil.MensajeErrorNuevo("mensajeDocumento", this.mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioDocumento:descripcion');");
                return false;
            }
        } catch (Exception ex) {
            this.mensaje = ex.toString();
            WebUtil.MensajeErrorNuevo("mensajeDocumento", "Error validar Cabecera: " + this.mensaje);
            RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioDocumento:codigo');");
            return false;
        }
        return true;
    }

    @Override
    public void grabar() {
        try {
            if (validarCabecera()) {
                for (NumEmisor l : listNumEmisor) {
                    l.setIDDOCUMENTO(getDatoEdicion().getIDDOCUMENTO());
                    l.setESTADO(getDatoEdicion().getESTADO());
                }
                if (listNumEmisor != null) {
                    if (listNumEmisor.size() > 0) {
                        getDatoEdicion().setListanumemisor(listNumEmisor);
                    }
                }
                mensaje = documentoService.saveDocumento(getDatoEdicion());
            }
        } catch (Exception ex) {
            Logger.getLogger(DocumentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setESTADO(0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setESTADO(2);
            }
             listNumEmisor = numemisorService.findByDocumento(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDDOCUMENTO());
             for (NumEmisor l : listNumEmisor) {
                    l.setESTADO(getDatoEdicion().getESTADO());
                }
            getDatoEdicion().setListanumemisor(listNumEmisor);
            mensaje = documentoService.saveDocumento(getDatoEdicion());
            listNumEmisor = new ArrayList<NumEmisor>();
        } catch (Exception ex) {
            Logger.getLogger(DocumentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Sucursal> getListbusquedaSucursal() {
        return listbusquedaSucursal;
    }

    public void setListbusquedaSucursal(List<Sucursal> listbusquedaSucursal) {
        this.listbusquedaSucursal = listbusquedaSucursal;
    }

    public boolean isBotonNumEmisorEditarDis() {
        return botonNumEmisorEditarDis;
    }

    public void setBotonNumEmisorEditarDis(boolean botonNumEmisorEditarDis) {
        this.botonNumEmisorEditarDis = botonNumEmisorEditarDis;
    }

    public boolean isBotonNumEmisorEliminarDis() {
        return botonNumEmisorEliminarDis;
    }

    public void setBotonNumEmisorEliminarDis(boolean botonNumEmisorEliminarDis) {
        this.botonNumEmisorEliminarDis = botonNumEmisorEliminarDis;
    }

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
    }

    public List<NumEmisor> getListNumEmisor() {
        return listNumEmisor;
    }

    public void setListNumEmisor(List<NumEmisor> listNumEmisor) {
        this.listNumEmisor = listNumEmisor;
    }

    public NumEmisor getSelectNumEmisor() {
        return selectNumEmisor;
    }

    public void setSelectNumEmisor(NumEmisor selectNumEmisor) {
        this.selectNumEmisor = selectNumEmisor;
    }

    public Sucursal getSelectbusquedaSucursal() {
        return selectbusquedaSucursal;
    }

    public void setSelectbusquedaSucursal(Sucursal selectbusquedaSucursal) {
        this.selectbusquedaSucursal = selectbusquedaSucursal;
    }

    public List<Procesos> getLstproc() {
        return lstproc;
    }

    public void setLstproc(List<Procesos> lstproc) {
        this.lstproc = lstproc;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public NumEmisor getNewNumEmisor() {
        return newNumEmisor;
    }

    public void setNewNumEmisor(NumEmisor newNumEmisor) {
        this.newNumEmisor = newNumEmisor;
    }

    public String getFiltrobusquedaSucursal() {
        return filtrobusquedaSucursal;
    }

    public void setFiltrobusquedaSucursal(String filtrobusquedaSucursal) {
        this.filtrobusquedaSucursal = filtrobusquedaSucursal;
    }

    public List<NumEmisor> getFillNumEmisor() {
        return fillNumEmisor;
    }

    public void setFillNumEmisor(List<NumEmisor> fillNumEmisor) {
        this.fillNumEmisor = fillNumEmisor;
    }

}
