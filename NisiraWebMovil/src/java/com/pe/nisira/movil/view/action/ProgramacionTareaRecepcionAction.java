/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.DZonaAccesorioDao;
import com.nisira.core.dao.DocumentoDao;
import com.nisira.core.dao.DprogramacionTareaLlegadaDao;
import com.nisira.core.dao.DprogramacionTareaPartidaDao;
import com.nisira.core.dao.MontacargaDao;
import com.nisira.core.dao.MovUbicacionDAO;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.NotificacionDao;
import com.nisira.core.dao.NumEmisorDao;
import com.nisira.core.dao.OperarioDao;
import com.nisira.core.dao.ProcesosDao;
import com.nisira.core.dao.ProgramacionLlenadoDao;
import com.nisira.core.dao.ProgramacionTareaDao;
import com.nisira.core.dao.QuickNotesDao;
import com.nisira.core.dao.TablaPrioridadesDao;
import com.nisira.core.dao.ZonaDao;
import com.nisira.core.entity.DZonaAccesorio;
import com.nisira.core.entity.Documento;
import com.nisira.core.entity.DprogAlmMontacarga;
import com.nisira.core.entity.DprogramacionTareaLlegada;
import com.nisira.core.entity.DprogramacionTareaPartida;
import com.nisira.core.entity.EnvioNotificacion;
import com.nisira.core.entity.Montacarga;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Notificacion;
import com.nisira.core.entity.NumEmisor;
import com.nisira.core.entity.Operario;
import com.nisira.core.entity.Procesos;
import com.nisira.core.entity.ProgramacionLlenado;
import com.nisira.core.entity.ProgramacionTarea;
import com.nisira.core.entity.QuickNotes;
import com.nisira.core.entity.TablaPrioridades;
import com.nisira.core.entity.Zona;
import com.nisira.core.util.ConstantesBD;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
@ManagedBean(name = "ProgramacionTareaRecepcionAction")
@SessionScoped
public class ProgramacionTareaRecepcionAction extends AbstactListAction<ProgramacionTarea> {

    private ProgramacionTareaDao ptareaDao;
    private Montacarga mo;
    private List<Procesos> lstproceso;
    private List<Documento> lstdocs;
    private DocumentoDao docDao;
    private List<NumEmisor> lstnume;
    private NumEmisorDao numemiDao;
    private UsuarioBean user;
    private String numero;
    private String mensaje;
    private NumEmisor nuevaSerie;
    private Date fechaprogramaciont;
    private Date fechaejecuciont;
    private Date fechafinalizaciont;
    private List<Zona> lstzonas;
    private Zona slcZona;
    private ZonaDao zonadao;
    private List<DZonaAccesorio> lstzonaAcc;
    private DZonaAccesorio slczonaAcc;
    private DZonaAccesorioDao zonaccDao;
    private List<DprogramacionTareaPartida> lstdprogtpart;
    private DprogramacionTareaPartida slcdprogtpart;
    private DprogramacionTareaPartidaDao dprogtpartDao;
    private List<DprogramacionTareaLlegada> lstdprogtlleg;
    private List<DprogramacionTareaLlegada> slcdprogtlleg;
    private DprogramacionTareaLlegadaDao dprogtllegDao;
    private List<ProgramacionLlenado> lstprogll;
    private ProgramacionLlenadoDao progllDao;
    private int idzona;
    private List<Multitabla> listMultitabla;
    private List<QuickNotes> notasRapidas;

    public ProgramacionTareaRecepcionAction() {
        ptareaDao = new ProgramacionTareaDao();
        mo = new Montacarga();
        lstproceso = new ArrayList<Procesos>();
        lstdocs = new ArrayList<Documento>();
        docDao = new DocumentoDao();
        lstnume = new ArrayList<NumEmisor>();
        numemiDao = new NumEmisorDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        numero = "";
        mensaje = "";
        nuevaSerie = new NumEmisor();
        fechaprogramaciont = new Date();
        fechaejecuciont = null;
        fechafinalizaciont = null;
        lstzonas = new ArrayList<Zona>();
        slcZona = new Zona();
        zonadao = new ZonaDao();
        idzona = 0;
        lstzonaAcc = new ArrayList<DZonaAccesorio>();
        slczonaAcc = new DZonaAccesorio();
        zonaccDao = new DZonaAccesorioDao();
        lstdprogtpart = new ArrayList<DprogramacionTareaPartida>();
        slcdprogtpart = new DprogramacionTareaPartida();
        dprogtpartDao = new DprogramacionTareaPartidaDao();
        lstdprogtlleg = new ArrayList<DprogramacionTareaLlegada>();
        slcdprogtlleg = new ArrayList<DprogramacionTareaLlegada>();
        dprogtllegDao = new DprogramacionTareaLlegadaDao();
        lstprogll = new ArrayList<ProgramacionLlenado>();
        progllDao = new ProgramacionLlenadoDao();
        listMultitabla = new ArrayList<Multitabla>();
        notasRapidas = new ArrayList<>();
        actualiza_ventana("wMnt_ProgramacionTarea");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            setListaDatos(ptareaDao.findAll(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL(), 0));
        } catch (Exception ex) {
            Logger.getLogger(ProgramacionTareaRecepcionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        ptareaDao = new ProgramacionTareaDao();
        mo = new Montacarga();
        lstproceso = new ArrayList<Procesos>();
        lstdocs = new ArrayList<Documento>();
        docDao = new DocumentoDao();
        lstnume = new ArrayList<NumEmisor>();
        numemiDao = new NumEmisorDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        numero = "";
        mensaje = "";
        idzona = 0;
        nuevaSerie = new NumEmisor();
        fechaprogramaciont = new Date();
        fechaejecuciont = null;
        fechafinalizaciont = null;
        lstzonas = new ArrayList<Zona>();
        slcZona = new Zona();
        zonadao = new ZonaDao();
        lstzonaAcc = new ArrayList<DZonaAccesorio>();
        slczonaAcc = new DZonaAccesorio();
        zonaccDao = new DZonaAccesorioDao();
        lstdprogtpart = new ArrayList<DprogramacionTareaPartida>();
        slcdprogtpart = new DprogramacionTareaPartida();
        dprogtpartDao = new DprogramacionTareaPartidaDao();
        lstdprogtlleg = new ArrayList<DprogramacionTareaLlegada>();
        slcdprogtlleg = new ArrayList<DprogramacionTareaLlegada>();
        dprogtllegDao = new DprogramacionTareaLlegadaDao();
        lstprogll = new ArrayList<ProgramacionLlenado>();
        progllDao = new ProgramacionLlenadoDao();
        listMultitabla = new ArrayList<Multitabla>();
        actualiza_ventana("wMnt_ProgramacionTarea");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new ProgramacionTarea());
        getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setIdsucursal(Integer.parseInt(Constantes.getIDSUCURSALGENERAL()));
        getDatoEdicion().setEstado(1);
        getDatoEdicion().setTipotarea(0);
        getDatoEdicion().setUsrcreacion(user.getIDUSUARIO());

    }

    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                getDatoEdicion().setFechaprogramacion(new Timestamp(fechaprogramaciont.getTime()));
                getDatoEdicion().setFechaejecucion(new Timestamp(fechaejecuciont.getTime()));
                if (fechafinalizaciont != null) {
                    getDatoEdicion().setFechafinalizacion(new Timestamp(fechafinalizaciont.getTime()));
                }
                getDatoEdicion().setNumero(numero);
                getDatoEdicion().setIDMONTACARGA(Integer.valueOf(mo.getIDMONTACARGA()));

                /*REESTRUCTURACION*/
                String i = "";
//                String i = ptareaDao.grabar(getDatoEdicion());/*CABECERA*/
                int in = 1;
                lstdprogtpart.clear();
                for (DZonaAccesorio dz : lstzonaAcc) {
                    DprogramacionTareaPartida dp = new DprogramacionTareaPartida();
                    if (dz.isAsignado()) {
                        dp.setIdempresa(dz.getIDEMPRESA());
                        dp.setIdsucursal(dz.getIDSUCURSAL());
                        dp.setIdprogramaciontarea(i);
                        dp.setItem(in);
                        dp.setIdproceso(getDatoEdicion().getIdproceso());
                        dp.setIdzona(dz.getIDZONA());
                        dp.setIdalmacen(null);
                        dp.setIdaccesorio(dz.getIDACCESORIO());
                        dp.setIdpaleta(null);
                        dp.setIdubicacion(dz.getIDUBICACION());
                        lstdprogtpart.add(dp);
                        in++;
                    }
                }
                if (lstdprogtpart.isEmpty()) {
                    WebUtil.MensajeAdvertencia("Seleccione Programaciones de llenado");
                } else {
                    /*NUEVO GUARDAR TOTAL*/
                    getDatoEdicion().setGeneracion(slcdprogtlleg.get(0).getIdgeneracion());
                    i = ptareaDao.grabar(getDatoEdicion(), lstdprogtpart, slcdprogtlleg);
                    getDatoEdicion().setIdprogramaciontarea(i);
                    setMensaje(WebUtil.exitoRegistrar("Programación Tarea Recepeción Materia Prima ", i));
                    WebUtil.info(getMensaje());
                    notificacionEnvio(i, String.valueOf(getDatoEdicion().getIDMONTACARGA()));
                    for (DprogramacionTareaLlegada dtp : slcdprogtlleg) {
                        (new MovUbicacionDAO()).execGeneracion(dtp.getIdempresa(), dtp.getIdsucursal(), dtp.getIdprogramacionllenado(), 0);
                    }
                }
//                if (!slcdprogtlleg.isEmpty()) {
//                    dprogtllegDao.grabar(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), i, slcdprogtlleg);
//                }
//                dprogtpartDao.grabar(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), i, lstdprogtpart);
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(ProgramacionTareaRecepcionAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
    }
    /*ENVIO DE NOTIFICACION*/

    public void notificacionEnvio(String idprogramaciontarea, String idmontacarga) {
        try {
            Notificacion not = new Notificacion();
            not.setIdempresa(Integer.parseInt(Constantes.IDEMPRESAGENERAL));
            not.setToquen(idprogramaciontarea);
            if (notasRapidas.size() > 0) {
                not.setMensaje(notasRapidas.get(0).getMensaje());
            } else {
                not.setMensaje("RECEPCIONARÁS MATERIA PRIMA");
            }

            if (not != null) {
                EnvioNotificacion detanotificacion = new EnvioNotificacion();
                detanotificacion.setIdempresa(Integer.parseInt(Constantes.IDEMPRESAGENERAL));
                detanotificacion.setIdmontacarga(idmontacarga);
                setMensaje((new NotificacionDao()).grabarXTareas(not, detanotificacion));
            }

        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(ProgramacionTareaRecepcionAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
    }

    public void QuickNotesLista(String idprogramaciontarea, String idoperario) {
        try {
            notasRapidas = (new QuickNotesDao()).findAll(Constantes.IDEMPRESAGENERAL);
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(ProgramacionTareaRecepcionAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setEstado(0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setEstado(2);
            }
            /*Cambiado - 23-08-2016*/
            String i = ptareaDao.grabar(getDatoEdicion(), lstdprogtpart, slcdprogtlleg);
        } catch (Exception ex) {
            Logger.getLogger(ProgramacionTareaRecepcionAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean esVistaValida() {
        if (slcdprogtlleg.isEmpty()) {
            WebUtil.MensajeAdvertencia("Seleccione Programaciones de llenado");
            return false;
        }
        if (mo == null) {
            WebUtil.MensajeAdvertencia("Seleccione un Montacarga");
            return false;
        }
        if (fechaejecuciont == null) {
            WebUtil.MensajeAdvertencia("Ingrese Fecha de Ejecuccion.");
            return false;
        }
        if (fechaprogramaciont == null) {
            WebUtil.MensajeAdvertencia("Ingrese Fecha de Programacion.");
            return false;
        }
        if (getDatoEdicion().getObservacion() == null) {
            WebUtil.MensajeAdvertencia("Ingrese Observacion");
            return false;
        }
        return true;
    }

    public void onProcesoSelect() throws Exception {
        lstdprogtlleg = new ArrayList<DprogramacionTareaLlegada>();
        lstprogll = progllDao.genDProgLlen(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdproceso());
        int i = 1;
        for (ProgramacionLlenado pr : lstprogll) {
            DprogramacionTareaLlegada dpll = new DprogramacionTareaLlegada();
            dpll.setIdempresa(pr.getIdempresa());
            dpll.setIdsucursal(pr.getIdsucursal());
            dpll.setItem(i);
            dpll.setIdprogramacionllenado(pr.getIdprogramacionllenado());
            dpll.setIdproceso(pr.getIdproceso());
            dpll.setIdforma(pr.getIdforma());
            dpll.setIdgeneracion(pr.getIdgeneracion());
            dpll.setIdreglas(pr.getIdreglas());
            dpll.setDescripcion(pr.getDescripcion());
            dpll.setProceso(pr.getPROCESO());
            dpll.setRegla(pr.getREGLA());
            dpll.setCodigoBarra(pr.getCODIGOBARRA());
            lstdprogtlleg.add(dpll);
            i++;
        }
        lstzonas = zonadao.findAllAcc(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL(), getDatoEdicion().getIdproceso());
    }

    public void onZonaSelec() throws Exception {
        slcZona = lstzonas.stream().filter((zona) -> zona.getIDZONA() == idzona).findAny().get();
        lstzonaAcc = zonaccDao.findAllTipoContainer(slcZona.getIDEMPRESA(), slcZona.getIDSUCURSAL(), slcZona.getIDZONA());
    }

    public void asignaTareaAcc(int ind) {
        if (slczonaAcc.isAsignado()) {
            slczonaAcc.setAsignado(false);
        } else {
            slczonaAcc.setAsignado(true);
        }
        RequestContext.getCurrentInstance().update("datos:tab:lstDzAcci");
        RequestContext.getCurrentInstance().update("datos:tab:lstDzAcci:cuadro");
        RequestContext.getCurrentInstance().update("datos:tab:lstDzAcci:cuadro:numerador");
    }

    public void oncDocChange() throws Exception {
        lstnume = numemiDao.findByDocumento(user.getIDEMPRESA(), getDatoEdicion().getIddocumento());
        numero = null;
        if (!lstnume.isEmpty()) {
            int i = 0;
            for (NumEmisor n : lstnume) {
                if (n.getIDDOCUMENTO().equalsIgnoreCase(getDatoEdicion().getIddocumento())) {
                    i = Integer.parseInt(n.getNUMERO());
                }
            }
            numero = WebUtil.cerosIzquierda(i, 7);
        }

    }

    public void findetalle() throws Exception {
        lstproceso = (new ProcesosDao()).findAll(user.getIDEMPRESA());
        lstdocs = docDao.findAll(user.getIDEMPRESA());
        lstnume = numemiDao.findByDocumento(user.getIDEMPRESA(), lstdocs.get(0).getIDDOCUMENTO());
        listMultitabla = (new MultitablaDao()).findDetalleTabla(user.getIDEMPRESA(), "17");
        mo = (new MontacargaDao()).findById(String.valueOf(getDatoEdicion().getIdempresa()), String.valueOf(getDatoEdicion().getIDMONTACARGA()));
        onProcesoSelect();
        if (getDatoEdicion().getIdprogramaciontarea() != null) {
            if (getDatoEdicion().getFechaejecucion() != null) {
                fechaejecuciont = new Date(getDatoEdicion().getFechaejecucion().getTime());
            }
            if (getDatoEdicion().getFechaprogramacion() != null) {
                fechaprogramaciont = new Date(getDatoEdicion().getFechaprogramacion().getTime());
            }
            if (getDatoEdicion().getFechafinalizacion() != null) {
                fechafinalizaciont = new Date(getDatoEdicion().getFechafinalizacion().getTime());
            }
            numero = getDatoEdicion().getNumero();
            slcdprogtlleg = dprogtllegDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdprogramaciontarea());
            lstdprogtpart = dprogtpartDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdprogramaciontarea());
            idzona = lstdprogtpart.get(0).getIdzona();
            slcZona = lstzonas.stream().filter((zona) -> zona.getIDZONA() == idzona).findAny().get();
            lstzonaAcc = zonaccDao.findAllTipoContainer(slcZona.getIDEMPRESA(), slcZona.getIDSUCURSAL(), slcZona.getIDZONA());
            for (DZonaAccesorio dz : lstzonaAcc) {
                for (DprogramacionTareaPartida dp : lstdprogtpart) {
                    if (dz.getIDACCESORIO() == dp.getIdaccesorio()) {
                        dz.setAsignado(true);
                    }
                }
            }

        } else {
            numero = lstnume.get(0).getNUMERO();
        }

    }

    public void verCntMontacarga() {
        RequestContext.getCurrentInstance().openDialog("cntMontacarga", modalOptions, null);
    }

    public void valorMontaarga(SelectEvent event) {
        this.mo = (Montacarga) event.getObject();

    }

    public Montacarga getMo() {
        return mo;
    }

    public void setMo(Montacarga mo) {
        this.mo = mo;
    }

    public List<Procesos> getLstproceso() {
        return lstproceso;
    }

    public void setLstproceso(List<Procesos> lstproceso) {
        this.lstproceso = lstproceso;
    }

    public List<Documento> getLstdocs() {
        return lstdocs;
    }

    public void setLstdocs(List<Documento> lstdocs) {
        this.lstdocs = lstdocs;
    }

    public List<NumEmisor> getLstnume() {
        return lstnume;
    }

    public void setLstnume(List<NumEmisor> lstnume) {
        this.lstnume = lstnume;
    }

    public UsuarioBean getUser() {
        return user;
    }

    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public NumEmisor getNuevaSerie() {
        return nuevaSerie;
    }

    public void setNuevaSerie(NumEmisor nuevaSerie) {
        this.nuevaSerie = nuevaSerie;
    }

    public Date getFechaprogramaciont() {
        return fechaprogramaciont;
    }

    public void setFechaprogramaciont(Date fechaprogramaciont) {
        this.fechaprogramaciont = fechaprogramaciont;
    }

    public Date getFechaejecuciont() {
        return fechaejecuciont;
    }

    public void setFechaejecuciont(Date fechaejecuciont) {
        this.fechaejecuciont = fechaejecuciont;
    }

    public Date getFechafinalizaciont() {
        return fechafinalizaciont;
    }

    public void setFechafinalizaciont(Date fechafinalizaciont) {
        this.fechafinalizaciont = fechafinalizaciont;
    }

    public List<Zona> getLstzonas() {
        return lstzonas;
    }

    public void setLstzonas(List<Zona> lstzonas) {
        this.lstzonas = lstzonas;
    }

    public List<DZonaAccesorio> getLstzonaAcc() {
        return lstzonaAcc;
    }

    public void setLstzonaAcc(List<DZonaAccesorio> lstzonaAcc) {
        this.lstzonaAcc = lstzonaAcc;
    }

    public DZonaAccesorio getSlczonaAcc() {
        return slczonaAcc;
    }

    public void setSlczonaAcc(DZonaAccesorio slczonaAcc) {
        this.slczonaAcc = slczonaAcc;
    }

    public List<DprogramacionTareaPartida> getLstdprogtpart() {
        return lstdprogtpart;
    }

    public void setLstdprogtpart(List<DprogramacionTareaPartida> lstdprogtpart) {
        this.lstdprogtpart = lstdprogtpart;
    }

    public DprogramacionTareaPartida getSlcdprogtpart() {
        return slcdprogtpart;
    }

    public void setSlcdprogtpart(DprogramacionTareaPartida slcdprogtpart) {
        this.slcdprogtpart = slcdprogtpart;
    }

    public List<DprogramacionTareaLlegada> getLstdprogtlleg() {
        return lstdprogtlleg;
    }

    public void setLstdprogtlleg(List<DprogramacionTareaLlegada> lstdprogtlleg) {
        this.lstdprogtlleg = lstdprogtlleg;
    }

    public List<DprogramacionTareaLlegada> getSlcdprogtlleg() {
        return slcdprogtlleg;
    }

    public void setSlcdprogtlleg(List<DprogramacionTareaLlegada> slcdprogtlleg) {
        this.slcdprogtlleg = slcdprogtlleg;
    }

    public List<ProgramacionLlenado> getLstprogll() {
        return lstprogll;
    }

    public void setLstprogll(List<ProgramacionLlenado> lstprogll) {
        this.lstprogll = lstprogll;
    }

    public Zona getSlcZona() {
        return slcZona;
    }

    public void setSlcZona(Zona slcZona) {
        this.slcZona = slcZona;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
    }

}
