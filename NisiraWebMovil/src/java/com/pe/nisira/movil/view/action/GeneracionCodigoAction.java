/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ParametrosDao;
import com.nisira.core.dao.ProcesosDao;
import com.nisira.core.entity.DGeneracionCodigo;
import com.nisira.core.entity.GeneracionCodigo;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Parametros;
import com.nisira.core.entity.Procesos;
import com.nisira.core.service.DGeneracionCodigoService;
import com.nisira.core.service.GeneracionCodigoService;
import com.nisira.core.service.MultitablaService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name = "generacionCodigoAction")
@SessionScoped
public class GeneracionCodigoAction extends AbstactListAction<GeneracionCodigo> implements Serializable {
    /* NOTAS:
     0-> Visualizar
     1-> Nuevo
     2-> Modificar
     */

    private String mensaje;
    private MultitablaService multitablaService;
    private List<Multitabla> listMultitabla;
    private List<Multitabla> listMultitabla_codigo;
    private List<Multitabla> listMultitabla_valor;
    private int digitosDisponibles;
    /*GENERACION DE CODIGO BARRAS*/
    private GeneracionCodigoService generacioncodigoService;
    private boolean botonEditarGeneracionCodigo;
    private boolean botonCodigoEliminarGeneracion;
    /*DGENERACION DE CODIGO BARRAS*/
    private DGeneracionCodigo selectDGeneracionCodigo;
    private DGeneracionCodigo NuDGeneracionCodigo;
    private DGeneracionCodigoService dgeneracioncodigoService;
    private List<DGeneracionCodigo> listDGeneracionCodigo;
    private List<DGeneracionCodigo> fillDGeneracionCodigo;
    private boolean botonGuardarDGeneracionCodigo;
    private boolean botonEditarDGeneracionCodigo;
    private boolean botonCodigoEliminarDGeneracion;
    private List<Procesos> listProces;
    private ProcesosDao proDao;
    private UsuarioBean user;
    private int doctEst;
    public GeneracionCodigoAction() {
        mensaje = "";
        multitablaService = new MultitablaService();
        listMultitabla = new ArrayList<Multitabla>();
        listMultitabla_codigo = new ArrayList<Multitabla>();
        listMultitabla_valor = new ArrayList<Multitabla>();
        listProces = new ArrayList<Procesos>();
        digitosDisponibles = 0;
        generacioncodigoService = new GeneracionCodigoService();
        botonEditarGeneracionCodigo = true;
        botonCodigoEliminarGeneracion = true;
        selectDGeneracionCodigo = new DGeneracionCodigo();
        dgeneracioncodigoService = new DGeneracionCodigoService();
        NuDGeneracionCodigo = new DGeneracionCodigo();
        listDGeneracionCodigo = new ArrayList<DGeneracionCodigo>();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        proDao = new ProcesosDao();
        actualiza_ventana("wMnt_generacioncodigo");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_generacioncodigo");
            setListaDatos(generacioncodigoService.getRecordGeneracionCodigo(user.getIDEMPRESA()));
            Constantes.estadoDocumento = 0;
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void findDetalles() throws Exception {
        try {
            listDGeneracionCodigo = dgeneracioncodigoService.getRecordGeneracionCodigo(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDGENERACION());
            fillDGeneracionCodigo = listDGeneracionCodigo;
            calcularDigitosDisponibles();
            setBotonEditarDGeneracionCodigo(true);
            setBotonCodigoEliminarDGeneracion(true);
            listMultitabla = multitablaService.getRecordParametroGeneracionCodigo(user.getIDEMPRESA());
            listMultitabla_codigo = multitablaService.getRecordTipoEtiqueta(user.getIDEMPRESA());
            listMultitabla_valor = multitablaService.getRecordTablaDetalle(user.getIDEMPRESA(), "15");
            listProces = proDao.findAll(user.getIDEMPRESA());
            if(!listDGeneracionCodigo.isEmpty()){
                doctEst = 2;
            }
            botonGuardarDGeneracionCodigo = true;
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public void calcularDigitosDisponibles() {
        try {
            int cont = 0;
            for (int i = 0; i < listDGeneracionCodigo.size(); i++) {
                cont += listDGeneracionCodigo.get(i).getNUMDIGITO();
                depurarListaMultitabla(listDGeneracionCodigo.get(i).getIDPARAMETRO());
            }
            digitosDisponibles = getDatoEdicion().getNUMDIGITOTOTAL() - cont;
            RequestContext.getCurrentInstance().update("datos:cboparametro");
            RequestContext.getCurrentInstance().update("datos:digdisp");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void depurarListaMultitabla(int idparametro) {
        int i;
        for (i = 0; i < listMultitabla.size(); i++) {
            if (idparametro == Integer.parseInt(listMultitabla.get(i).getVALOR())) {
                listMultitabla.remove(i);
                break;
            }
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        multitablaService = new MultitablaService();
        listMultitabla = new ArrayList<Multitabla>();
        listMultitabla_codigo = new ArrayList<Multitabla>();
        listMultitabla_valor = new ArrayList<Multitabla>();
        digitosDisponibles = 0;
        generacioncodigoService = new GeneracionCodigoService();
        botonEditarGeneracionCodigo = true;
        NuDGeneracionCodigo = new DGeneracionCodigo();
        botonCodigoEliminarGeneracion = true;
        selectDGeneracionCodigo = new DGeneracionCodigo();
        dgeneracioncodigoService = new DGeneracionCodigoService();
        listDGeneracionCodigo = new ArrayList<DGeneracionCodigo>();
        listProces = new ArrayList<Procesos>();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        proDao = new ProcesosDao();
        actualiza_ventana("wMnt_generacioncodigo");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new GeneracionCodigo());
        getDatoEdicion().setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setESTADO(1);
        getDatoEdicion().setNUMDIGITOTOTAL(0);
        getDatoEdicion().setSINCRONIZADO(1);
        doctEst = 1;
        botonGuardarDGeneracionCodigo = true;
    }

    public void agregarDGeneracionCodigo() {
        try {
            if (digitosDisponibles >= NuDGeneracionCodigo.getNUMDIGITO()) {
                NuDGeneracionCodigo.setIDREGISTROCODIGO(WebUtil.idGeneradoTres(listDGeneracionCodigo.size()));
                NuDGeneracionCodigo.setIDGENERACION(String.valueOf(getDatoEdicion().getIDGENERACION()));
                NuDGeneracionCodigo.setIDEMPRESA(String.valueOf(getDatoEdicion().getIDEMPRESA()));
                NuDGeneracionCodigo.setPARAMETRO(listMultitabla.get(buscarDescripcionParametro(NuDGeneracionCodigo.getIDPARAMETRO())).getDESCRIPCION());
                NuDGeneracionCodigo.setNUMDIGITOTOTAL(getDatoEdicion().getNUMDIGITOTOTAL());
                NuDGeneracionCodigo.setSINCRONIZADO(1);
                listDGeneracionCodigo.add(NuDGeneracionCodigo);
                NuDGeneracionCodigo = new DGeneracionCodigo();
                calcularDigitosDisponibles();
                RequestContext.getCurrentInstance().update("datos:tbl");
                return;
            } else {
                WebUtil.MensajeError("Sobrepasa la cantidad disponible");
                return;
            }
        } catch (Exception ex) {
            return;
        }
    }

    public int buscarDescripcionParametro(int valor) {
        int pos = 0;
        for (int i = 0; i < listMultitabla.size(); i++) {
            if (valor == Integer.parseInt(listMultitabla.get(i).getVALOR())) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public void InhabilitarDGeneracionCodigo() {
        try {
            int pos = listDGeneracionCodigo.indexOf(selectDGeneracionCodigo);
            listDGeneracionCodigo.remove(pos);
            fillDGeneracionCodigo = listDGeneracionCodigo;
            listMultitabla = multitablaService.getRecordParametroGeneracionCodigo(user.getIDEMPRESA());
            calcularDigitosDisponibles();
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void onRowSelectDGeneracionCodigo(SelectEvent event) throws IOException {
        botonCodigoEliminarDGeneracion = false;
        RequestContext.getCurrentInstance().update("datos:tbl");
    }

    public void onRowUnselectDGeneracionCodigo(UnselectEvent event) throws IOException {
        botonCodigoEliminarDGeneracion = false;
        RequestContext.getCurrentInstance().update("datos:tbl");
    }

    @Override
    public void grabar() {
        int tempIDGENERACION = 0;
        try {
            if (getDatoEdicion().getDESCRIPCION().equals("")) {
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.mensaje = "Ingrese Descripción";
            } else if (getDatoEdicion().getTIPO() == 0) {
                this.mensaje = "Ingrese Numero de Digito Mayor a 0";
                WebUtil.MensajeAlerta(this.mensaje);
            } else {
                generarIdRegistroConsecutivo();
                if (doctEst == 1) {//Nuevo
                    tempIDGENERACION = generacioncodigoService.addXmlGeneracionCodigo(1, getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDGENERACION(), cadenaGeneracionCodigoXml());
                    botonGuardarDGeneracionCodigo = false;
                    RequestContext.getCurrentInstance().update("datos:tbl");
                    dgeneracioncodigoService.addXmlGeneracionCodigo(String.valueOf(getDatoEdicion().getIDEMPRESA()), tempIDGENERACION, cadenaDGeneracionCodigoXml());
                    Constantes.estadoDocumento = 2;
                } else if (doctEst == 2) {//Modificar
                    generacioncodigoService.addXmlGeneracionCodigo(2, getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDGENERACION(), cadenaGeneracionCodigoXml());
                    dgeneracioncodigoService.addXmlGeneracionCodigo( String.valueOf(getDatoEdicion().getIDEMPRESA()),getDatoEdicion().getIDGENERACION(), cadenaDGeneracionCodigoXml());
                }                
                findDetalles();
                WebUtil.info(WebUtil.exitoRegistrar("Documento Generación de Código", getDatoEdicion().getDESCRIPCION()));
            }
//            RequestContext.getCurrentInstance().update("dlgFormNuevoSucursal");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void generarIdRegistroConsecutivo() {
        for (int i = 0; i < listDGeneracionCodigo.size(); i++) {
            listDGeneracionCodigo.get(i).setIDREGISTROCODIGO(WebUtil.idGeneradoTres(i + 1));
        }
    }
    public String cadenaDGeneracionCodigoXml() {
        System.out.println("DGeneracionCodigo XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE RACK
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_DGeneracionCodigo = new XStream();
        xStream_DGeneracionCodigo.processAnnotations(DGeneracionCodigo.class);
        return xml + xStream_DGeneracionCodigo.toXML(listDGeneracionCodigo);
    }
    public String cadenaGeneracionCodigoXml() {
        System.out.println("DGeneracionCodigo XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE RACK
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_DGeneracionCodigo = new XStream();
        xStream_DGeneracionCodigo.processAnnotations(GeneracionCodigo.class);
        List<GeneracionCodigo> l = new ArrayList<GeneracionCodigo>();
        l.add(getDatoEdicion());
        return xml + xStream_DGeneracionCodigo.toXML(l);
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
            generacioncodigoService.addXmlGeneracionCodigo(2, getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDGENERACION(), cadenaGeneracionCodigoXml());
        } catch (Exception ex) {
            Logger.getLogger(GeneracionCodigoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
    }

    public List<Multitabla> getListMultitabla_codigo() {
        return listMultitabla_codigo;
    }

    public void setListMultitabla_codigo(List<Multitabla> listMultitabla_codigo) {
        this.listMultitabla_codigo = listMultitabla_codigo;
    }
    
    public int getDigitosDisponibles() {
        return digitosDisponibles;
    }

    public void setDigitosDisponibles(int digitosDisponibles) {
        this.digitosDisponibles = digitosDisponibles;
    }

    public boolean isBotonEditarGeneracionCodigo() {
        return botonEditarGeneracionCodigo;
    }

    public void setBotonEditarGeneracionCodigo(boolean botonEditarGeneracionCodigo) {
        this.botonEditarGeneracionCodigo = botonEditarGeneracionCodigo;
    }

    public boolean isBotonCodigoEliminarGeneracion() {
        return botonCodigoEliminarGeneracion;
    }

    public void setBotonCodigoEliminarGeneracion(boolean botonCodigoEliminarGeneracion) {
        this.botonCodigoEliminarGeneracion = botonCodigoEliminarGeneracion;
    }

    public DGeneracionCodigo getSelectDGeneracionCodigo() {
        return selectDGeneracionCodigo;
    }

    public void setSelectDGeneracionCodigo(DGeneracionCodigo selectDGeneracionCodigo) {
        this.selectDGeneracionCodigo = selectDGeneracionCodigo;
    }

    public List<DGeneracionCodigo> getListDGeneracionCodigo() {
        return listDGeneracionCodigo;
    }

    public void setListDGeneracionCodigo(List<DGeneracionCodigo> listDGeneracionCodigo) {
        this.listDGeneracionCodigo = listDGeneracionCodigo;
    }

    public boolean isBotonGuardarDGeneracionCodigo() {
        return botonGuardarDGeneracionCodigo;
    }

    public void setBotonGuardarDGeneracionCodigo(boolean botonGuardarDGeneracionCodigo) {
        this.botonGuardarDGeneracionCodigo = botonGuardarDGeneracionCodigo;
    }

    public boolean isBotonEditarDGeneracionCodigo() {
        return botonEditarDGeneracionCodigo;
    }

    public void setBotonEditarDGeneracionCodigo(boolean botonEditarDGeneracionCodigo) {
        this.botonEditarDGeneracionCodigo = botonEditarDGeneracionCodigo;
    }

    public boolean isBotonCodigoEliminarDGeneracion() {
        return botonCodigoEliminarDGeneracion;
    }

    public void setBotonCodigoEliminarDGeneracion(boolean botonCodigoEliminarDGeneracion) {
        this.botonCodigoEliminarDGeneracion = botonCodigoEliminarDGeneracion;
    }

    public DGeneracionCodigo getNuDGeneracionCodigo() {
        return NuDGeneracionCodigo;
    }

    public void setNuDGeneracionCodigo(DGeneracionCodigo NuDGeneracionCodigo) {
        this.NuDGeneracionCodigo = NuDGeneracionCodigo;
    }

    public List<Multitabla> getListMultitabla_proceso() {
        return listMultitabla_valor;
    }

    public void setListMultitabla_proceso(List<Multitabla> listMultitabla_proceso) {
        this.listMultitabla_valor = listMultitabla_proceso;
    }

    public List<Procesos> getListProces() {
        return listProces;
    }

    public void setListProces(List<Procesos> listProces) {
        this.listProces = listProces;
    }

    public List<DGeneracionCodigo> getFillDGeneracionCodigo() {
        return fillDGeneracionCodigo;
    }

    public void setFillDGeneracionCodigo(List<DGeneracionCodigo> fillDGeneracionCodigo) {
        this.fillDGeneracionCodigo = fillDGeneracionCodigo;
    }

}
