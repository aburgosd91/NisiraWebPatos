/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;
import com.nisira.core.dao.CpuMovilDao;
import com.nisira.core.dao.DMontacargaCpuMovilDao;
import com.nisira.core.entity.CpuMovil;
import com.nisira.core.entity.DMontacargaCpuMovil;
import com.nisira.core.entity.Montacarga;
import com.nisira.core.service.MontacargaService;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Victor Zavala Llanos <vzavala@nisira.com.pe>
 */
@ManagedBean(name = "montacargaAction")
@SessionScoped
public class MontacargaAction extends AbstactListAction<Montacarga> {

    private MontacargaService montacargaService;

    private List<CpuMovil> listbusquedaCpuMovil;
    private String mensaje;

    private List<DMontacargaCpuMovil> listDMontacargaCpuMovil;
    private DMontacargaCpuMovil selectDMontacargaCpuMovil;

    private CpuMovil selectbusquedaCpuMovil;
    private UsuarioBean user;
    private boolean botonAgregarDetalle;
    private boolean botonEditarDetalle;

    public MontacargaAction() {
        montacargaService = new MontacargaService();
        listbusquedaCpuMovil = new ArrayList<CpuMovil>();
        mensaje = "";
        listDMontacargaCpuMovil = new ArrayList<DMontacargaCpuMovil>();
//        selectDMontacargaCpuMovil = new DMontacargaCpuMovil();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        selectbusquedaCpuMovil = new CpuMovil();
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_montacarga");
            setListaDatos(montacargaService.getRecordMontacarga(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:principal:panel1:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }
    public void findCpuMovil(){
        try{
            listbusquedaCpuMovil = (new CpuMovilDao()).findAll(user.getIDEMPRESA());
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    public void findDetalles() throws Exception {
        selectbusquedaCpuMovil = new CpuMovil();
        botonAgregarDetalle = false;
        botonEditarDetalle = false;
        selectbusquedaCpuMovil = new CpuMovil();
//        selectDMontacargaCpuMovil = new DMontacargaCpuMovil();
        listDMontacargaCpuMovil = (new DMontacargaCpuMovilDao()).findByMontacarga(user.getIDEMPRESA(), getDatoEdicion().getIDMONTACARGA());
    }

    @Override
    public String getIniciar() {
        listbusquedaCpuMovil = new ArrayList<CpuMovil>();
        mensaje = "";
        listDMontacargaCpuMovil = new ArrayList<DMontacargaCpuMovil>();
//        selectDMontacargaCpuMovil = new DMontacargaCpuMovil();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        selectbusquedaCpuMovil = new CpuMovil();
        actualiza_ventana("wMnt_montacarga");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new Montacarga());
        getDatoEdicion().setESTADO(1);
        getDatoEdicion().setIDEMPRESA(user.getIDEMPRESA());
    }

    @Override
    public void grabar() {
        try {
            if (!validarCabecera()) {
                return;
            }
            getDatoEdicion().setListaCpuMovil(listDMontacargaCpuMovil);
            if(getLadd()==1){
                mensaje = montacargaService.saveMontacarga(getDatoEdicion(),1);
            }else if(getLadd()==2){
                mensaje = montacargaService.saveMontacarga(getDatoEdicion(),2);
            }
            if (mensaje.trim().compareTo("OK") == 0) {
                findDetalles();
                RequestContext.getCurrentInstance().update("datos");
                String mensaje = "El montacarga se guardo correctamente.";
                WebUtil.MensajeInformativoNuevo("mensajeMontacarga", mensaje);
            } else {
                WebUtil.MensajeErrorNuevo("mensajeMontacarga", this.mensaje);
            }
            return;
        } catch (Exception ex) {
            mensaje = ex.toString();
            WebUtil.MensajeErrorNuevo("mensajeMontacarga", "Error al grabar: " + this.mensaje);
            return;
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
            mensaje = montacargaService.saveMontacarga(getDatoEdicion(),2);
        } catch (Exception ex) {
            Logger.getLogger(MontacargaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getActionAgregarDetalle() {
        botonAgregarDetalle = true;
        try {
            if (!validarCabecera()) {
                return;
            }
            RequestContext.getCurrentInstance().update("dlg_detalleequipo");
            RequestContext.getCurrentInstance().execute("PF('dlg_detalleequipo').show()");
            return;
        } catch (Exception ex) {
            mensaje = ex.toString();
            WebUtil.MensajeErrorNuevo("mensajeMontacarga", "Error agrega detalle: " + this.mensaje);
            return;
        }
    }

    public void getActionEditarDetalle() {
        try {
            botonEditarDetalle = true;
            RequestContext.getCurrentInstance().update("dlg_detalleequipo");
            RequestContext.getCurrentInstance().execute("PF('dlg_detalleequipo').show()");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getActionEliminarDetalle() {
        try {
            System.out.println("getActionEliminarDetalle");
            listDMontacargaCpuMovil.remove(selectDMontacargaCpuMovil);
            selectDMontacargaCpuMovil = new DMontacargaCpuMovil();
            RequestContext.getCurrentInstance().update("datos:tab:tbl2");
            RequestContext.getCurrentInstance().update("dlg_detalleequipo");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());

            return;
        }
    }

    public void AgregarEditarDetalle() {
        try {
            selectDMontacargaCpuMovil = new DMontacargaCpuMovil();
            selectDMontacargaCpuMovil.setIDCPUMOVIL(String.valueOf(selectbusquedaCpuMovil.getIdcpumovil()));
            selectDMontacargaCpuMovil.setCPUMOVIL(selectbusquedaCpuMovil);
            selectDMontacargaCpuMovil.setCPUMOVILDESCRIPCION(selectbusquedaCpuMovil.getDescripcion());
            //EQUIPOS
            if (botonAgregarDetalle) {
                for (DMontacargaCpuMovil detalle : listDMontacargaCpuMovil) {
                    if (detalle.getIDCPUMOVIL().trim().equals(selectDMontacargaCpuMovil.getIDCPUMOVIL().trim())) {
                        this.mensaje = " El Cpu ya estan registrado ";
                        WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                        //RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioDMontacargaCpuMovil:numero');");
                        return;
                    }
                }
                if(selectDMontacargaCpuMovil!=null){
                    selectDMontacargaCpuMovil.setIDEMPRESA(user.getIDEMPRESA());
                    listDMontacargaCpuMovil.add(selectDMontacargaCpuMovil);
                    selectDMontacargaCpuMovil= new DMontacargaCpuMovil();
                }
            }
            if (botonEditarDetalle) {
                for (DMontacargaCpuMovil detalle : listDMontacargaCpuMovil) {
                    if (detalle.getIDCPUMOVIL().trim().equals(selectDMontacargaCpuMovil.getIDCPUMOVIL().trim())) {
                        this.mensaje = " El Cpu ya estan registrado ";
                        WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                        //RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioDMontacargaCpuMovil:numero');");
                        selectDMontacargaCpuMovil= new DMontacargaCpuMovil();
                        return;
                    }
                }
                for (DMontacargaCpuMovil detalle : listDMontacargaCpuMovil) {
                    if (detalle.getIDCPUMOVIL().trim().equals(selectDMontacargaCpuMovil.getIDCPUMOVIL().trim())) {
                        detalle = selectDMontacargaCpuMovil;
                    }
                }
            }
            botonAgregarDetalle = false;
            botonEditarDetalle = false;
            RequestContext.getCurrentInstance().update("datos:dlg_detalleequipo");
            RequestContext.getCurrentInstance().execute("PF('dlg_detalleequipo').hide()");
            RequestContext.getCurrentInstance().update("datos:tab:tbl2");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
        }
    }

    public void llenarEQ() {
        selectDMontacargaCpuMovil = new DMontacargaCpuMovil();
        selectDMontacargaCpuMovil.setIDCPUMOVIL(String.valueOf(selectbusquedaCpuMovil.getIdcpumovil()));
        selectDMontacargaCpuMovil.setCPUMOVIL(selectbusquedaCpuMovil);
        RequestContext.getCurrentInstance().update("datos:contenedorequipo");
        RequestContext.getCurrentInstance().execute("PF('dlg_equipo').hide()");
    }

    public boolean validarCabecera() {
        try {

            if (getDatoEdicion().getDESCRIPCION() == null) {
                this.mensaje = "Ingrese Descripción";
                WebUtil.MensajeErrorNuevo("mensajeMontacarga", this.mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('datos:descripcion');");
                return false;
            }
            if (getDatoEdicion().getDESCRIPCION().trim().length() == 0) {
                this.mensaje = "Ingrese Descripción";
                WebUtil.MensajeErrorNuevo("mensajeMontacarga", this.mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('datos:descripcion');");
                return false;
            }
        } catch (Exception ex) {
            this.mensaje = ex.toString();
            WebUtil.MensajeErrorNuevo("mensajeMontacarga", "Error validar Cabecera: " + this.mensaje);
            RequestContext.getCurrentInstance().execute("PrimeFaces.focus('datos:codigo');");
            return false;
        }
        return true;
    }

    public boolean validarCodigo() {
        if (getDatoEdicion().getESTADO() == 1) {
            try {
                Montacarga montacarga = montacargaService.findById(user.getIDEMPRESA(), getDatoEdicion().getIDMONTACARGA());
                if (!(montacarga == null)) {
                    this.mensaje = "El codigo ya existe, ingrese otro codigo";
                    WebUtil.MensajeErrorNuevo("mensajeMontacarga", this.mensaje);
                    RequestContext.getCurrentInstance().execute("PrimeFaces.focus('datos:codigo');");
                    return false;
                }
            } catch (Exception ex) {
                WebUtil.MensajeErrorNuevo("mensajeMontacarga", "Error validar codigo: " + ex.toString());
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('datos:codigo');");
                return false;
            }
        }
        return true;
    }

    public List<CpuMovil> getListbusquedaCpuMovil() {
        return listbusquedaCpuMovil;
    }

    public void setListbusquedaCpuMovil(List<CpuMovil> listbusquedaCpuMovil) {
        this.listbusquedaCpuMovil = listbusquedaCpuMovil;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<DMontacargaCpuMovil> getListDMontacargaCpuMovil() {
        return listDMontacargaCpuMovil;
    }

    public void setListDMontacargaCpuMovil(List<DMontacargaCpuMovil> listDMontacargaCpuMovil) {
        this.listDMontacargaCpuMovil = listDMontacargaCpuMovil;
    }

    public DMontacargaCpuMovil getSelectDMontacargaCpuMovil() {
        return selectDMontacargaCpuMovil;
    }

    public void setSelectDMontacargaCpuMovil(DMontacargaCpuMovil selectDMontacargaCpuMovil) {
        this.selectDMontacargaCpuMovil = selectDMontacargaCpuMovil;
    }

    public CpuMovil getSelectbusquedaCpuMovil() {
        return selectbusquedaCpuMovil;
    }

    public void setSelectbusquedaCpuMovil(CpuMovil selectbusquedaCpuMovil) {
        this.selectbusquedaCpuMovil = selectbusquedaCpuMovil;
    }

}
