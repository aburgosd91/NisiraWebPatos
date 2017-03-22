/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.DAlmacen_RacksDao;
import com.nisira.core.dao.DDNFormaUbicacionDao;
import com.nisira.core.dao.DDProgramacionalmprioridadDao;
import com.nisira.core.dao.DDistribucionUbicacionDao;
import com.nisira.core.dao.DNForma_UbicacionDao;
import com.nisira.core.dao.DPROGRAMAALMMONTACARGANOTIFICACIONDao;
import com.nisira.core.dao.DProgAlmMontacargaDao;
import com.nisira.core.dao.DocumentoDao;
import com.nisira.core.dao.DprogAlmPrioridadDao;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.NumEmisorDao;
import com.nisira.core.dao.ProgramaAlmDao;
import com.nisira.core.dao.ResponsableDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.core.entity.DDNFormaUbicacion;
import com.nisira.core.entity.DDProgramacionalmprioridad;
import com.nisira.core.entity.DDistribucionUbicacion;
import com.nisira.core.entity.DNFormaUbicacion;
import com.nisira.core.entity.DPROGRAMAALMMONTACARGANOTIFICACION;
import com.nisira.core.entity.Documento;
import com.nisira.core.entity.DprogAlmMontacarga;
import com.nisira.core.entity.DprogAlmPrioridad;
import com.nisira.core.entity.Montacarga;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Notificacion;
import com.nisira.core.entity.NumEmisor;
import com.nisira.core.entity.ProgramaAlm;
import com.nisira.core.entity.Reglas;
import com.nisira.core.entity.Responsable;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.pe.nisira.movil.view.util.menuDao;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.sourceforge.jtds.jdbc.DateTime;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "programaAlmAction")
@SessionScoped
public class ProgramaAlmAction extends AbstactListAction<ProgramaAlm> {

    private Responsable op;
    private Montacarga mo;
    private Reglas re;
    private List<String[]> lista_sucursales;
    private ProgramaAlmDao progDao;
    private DProgAlmMontacargaDao dprogalmontDAO;
    private DprogAlmPrioridadDao dprogprioDAO;
    private List<DprogAlmMontacarga> listadprogalmont;
    private DprogAlmMontacarga selectdprogalmont;
    private List<DprogAlmPrioridad> listdprogprio;
    private DprogAlmPrioridad selectdprogprio;
    private UsuarioBean user;
    private String mensaje;
    private int idnuevo;
    private Integer selectTab;
    private boolean botonAgregarDetalle;
    private boolean botonEditarDetalle;
    private List<Almacen> lstalm;
    private List<DDistribucionUbicacion> lstDist;
    private List<DAlmacen_Racks> lstracks;
    private AlmacenDao almDao;
    private DDistribucionUbicacionDao ddistDao;
    private DAlmacen_RacksDao rackDao;
    private String idAlmacen;
    private String idDistribucion;
    private Integer iddistribucionpiso;
    private List<DAlmacen_Racks> sltracks;
    private ResponsableDao respdao;
    private Date fechaprogramaciont;
    private Date fechaejecuciont;
    private Date fechafinalizaciont;
    private List<Multitabla> listMultitabla;
    private List<Multitabla> listMultitabla2;
    private MultitablaDao multidao;
    private List<Documento> lstdocs;
    private DocumentoDao docDao;
    private List<NumEmisor> lstnume;
    private NumEmisorDao numemiDao;
    private String numero;
    private NumEmisor nuevaSerie;
    private boolean nuevoD;
    private List<DNFormaUbicacion> lisdnforma;
    private DNFormaUbicacion dnforma;
    private DNForma_UbicacionDao dnfDao;
    private DDProgramacionalmprioridadDao ddprogdao;
    private List<DDNFormaUbicacion> listDDNFormaUbicacion;
    private int indexrow;
    public ProgramaAlmAction() {
        selectTab = 0;
        op = new Responsable();
        mo = new Montacarga();
        re = new Reglas();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        progDao = new ProgramaAlmDao();
        mensaje = null;
        idnuevo = 1;
        dprogalmontDAO = new DProgAlmMontacargaDao();
        dprogprioDAO = new DprogAlmPrioridadDao();
        listadprogalmont = new ArrayList<DprogAlmMontacarga>();
        selectdprogalmont = new DprogAlmMontacarga();
        listdprogprio = new ArrayList<DprogAlmPrioridad>();
        selectdprogprio = new DprogAlmPrioridad();
        lstalm = new ArrayList<Almacen>();
        lstDist = new ArrayList<DDistribucionUbicacion>();
        lstracks = new ArrayList<DAlmacen_Racks>();
        sltracks = new ArrayList<DAlmacen_Racks>();
        almDao = new AlmacenDao();
        ddistDao = new DDistribucionUbicacionDao();
        rackDao = new DAlmacen_RacksDao();
        idAlmacen = null;
        idDistribucion = null;
        iddistribucionpiso = null;
        respdao = new ResponsableDao();
        fechaprogramaciont = null;
        fechaejecuciont = null;
        fechafinalizaciont = null;
        listMultitabla = new ArrayList<Multitabla>();
        listMultitabla2 = new ArrayList<Multitabla>();
        multidao = new MultitablaDao();
        lstdocs = new ArrayList<Documento>();
        docDao = new DocumentoDao();
        lstnume = new ArrayList<NumEmisor>();
        numemiDao = new NumEmisorDao();
        numero = "";
        nuevaSerie = new NumEmisor();
        nuevoD = false;
        lisdnforma = new ArrayList<DNFormaUbicacion>();
        dnforma = new DNFormaUbicacion();
        dnfDao = new DNForma_UbicacionDao();
        ddprogdao = new DDProgramacionalmprioridadDao();
        listDDNFormaUbicacion = new ArrayList<DDNFormaUbicacion>();
        indexrow = 0;
        actualiza_ventana("wMnt_programaalm");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            listMultitabla = multidao.findDetalleTabla(user.getIDEMPRESA(), "1");
            actualiza_ventana("wMnt_programaalm");
            setListaDatos(progDao.findAllEmpSuc(Integer.parseInt(user.getIDEMPRESA())));
            if (!getListaDatos().isEmpty()) {
                idnuevo = getListaDatos().get(getListaDatos().size() - 1).getIdprogramaalm() + 1;
            }
            RequestContext.getCurrentInstance().update("datos:tab:tabForm:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        selectTab = 0;
        op = new Responsable();
        mo = new Montacarga();
        re = new Reglas();
        respdao = new ResponsableDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        progDao = new ProgramaAlmDao();
        mensaje = null;
        idnuevo = 1;
        dprogalmontDAO = new DProgAlmMontacargaDao();
        dprogprioDAO = new DprogAlmPrioridadDao();
        listadprogalmont = new ArrayList<DprogAlmMontacarga>();
        selectdprogalmont = new DprogAlmMontacarga();;
        listdprogprio = new ArrayList<DprogAlmPrioridad>();
        selectdprogprio = new DprogAlmPrioridad();
        lstalm = new ArrayList<Almacen>();
        lstDist = new ArrayList<DDistribucionUbicacion>();
        lstracks = new ArrayList<DAlmacen_Racks>();
        sltracks = new ArrayList<DAlmacen_Racks>();
        almDao = new AlmacenDao();
        ddistDao = new DDistribucionUbicacionDao();
        rackDao = new DAlmacen_RacksDao();
        idAlmacen = null;
        idDistribucion = null;
        iddistribucionpiso = null;
        respdao = new ResponsableDao();
        fechaprogramaciont = null;
        fechaejecuciont = null;
        fechafinalizaciont = null;
        listMultitabla = new ArrayList<Multitabla>();
        listMultitabla2 = new ArrayList<Multitabla>();
        multidao = new MultitablaDao();
        lstdocs = new ArrayList<Documento>();
        docDao = new DocumentoDao();
        lstnume = new ArrayList<NumEmisor>();
        numemiDao = new NumEmisorDao();
        numero = "";
        nuevaSerie = new NumEmisor();
        nuevoD = false;
        lisdnforma = new ArrayList<DNFormaUbicacion>();
        dnforma = new DNFormaUbicacion();
        dnfDao = new DNForma_UbicacionDao();
        ddprogdao = new DDProgramacionalmprioridadDao();
        listDDNFormaUbicacion = new ArrayList<DDNFormaUbicacion>();
        indexrow = 0;
        actualiza_ventana("wMnt_programaalm");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            this.lista_sucursales = new ArrayList<String[]>();
            lista_sucursales = new menuDao().buscar_sucursal(user.getIDUSUARIO());
            setDatoEdicion(new ProgramaAlm());
            getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
            getDatoEdicion().setIdsucursal(Integer.parseInt(Constantes.getIDSUCURSALGENERAL()));
            getDatoEdicion().setIdprogramaalm(idnuevo);
            nuevoD = true;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                getDatoEdicion().setIdresponsable(op.getIdresponsable());
                getDatoEdicion().setFechaprogramacion(new Timestamp(fechaprogramaciont.getTime()));
                getDatoEdicion().setFechaejecucion(new Timestamp(fechaejecuciont.getTime()));
                if (fechafinalizaciont != null) {
                    getDatoEdicion().setFechafinalizacion(new Timestamp(fechafinalizaciont.getTime()));
                }
                getDatoEdicion().setVentana("wMnt_programaalm");
                getDatoEdicion().setNumero(numero);
                List<DDProgramacionalmprioridad> lddp = new ArrayList<DDProgramacionalmprioridad>();
                for (DprogAlmPrioridad d : listdprogprio) {
                    d.getFubicacion().setPrioridadalmacen(d.getPrioridadalmacen());
                    d.getFubicacion().setPrioridadrack(d.getPrioridadrack());
                    lddp.add(d.getFubicacion());
                }
                if (nuevoD) {
                    String Inicio = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
                    XStream xStream_rack = new XStream();
                    xStream_rack = new XStream();
                    xStream_rack.processAnnotations(NumEmisor.class);
                    List<NumEmisor> nn = new ArrayList<NumEmisor>();
                    for (NumEmisor nw : lstnume) {
                        if (nw.getIDDOCUMENTO().equalsIgnoreCase(getDatoEdicion().getIddocumento()) && nw.getSERIE().equalsIgnoreCase(getDatoEdicion().getSerie())) {
                            nuevaSerie = nw;
                            nuevaSerie.setNUMERO(numero);
                            nn.add(nw);
                        }
                    }
                    String xmlDet = Inicio.concat(xStream_rack.toXML(nn));
                    numemiDao.insertFromProg(xmlDet);
                }
                progDao.insertaProgamaAlmacen(getDatoEdicion(), listadprogalmont, listdprogprio);
                ddprogdao.insertDDprog(lddp);
                List<DPROGRAMAALMMONTACARGANOTIFICACION> ldm = new ArrayList<DPROGRAMAALMMONTACARGANOTIFICACION>();
                for (DprogAlmMontacarga d : listadprogalmont) {
                    DPROGRAMAALMMONTACARGANOTIFICACION dprognot = new DPROGRAMAALMMONTACARGANOTIFICACION();
                    d.getNota().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
                    d.getNota().setEstado(1);
                    int idn = dprogalmontDAO.insertaNotificaciones(d.getNota(), d.getIdempresa(), d.getNota().getIdnotificacion());
                    dprognot.setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
                    dprognot.setIDMONTACARGA(Integer.parseInt(d.getIdmontacarga()));
                    dprognot.setIDPROGRAMAALM(d.getIdprogramaalm());
                    dprognot.setIDNOTIFICACION(idn);
                    dprognot.setESTADO(1);
                    dprognot.setSINCRONIZA(1);
                    ldm.add(dprognot);
                }
                (new DPROGRAMAALMMONTACARGANOTIFICACIONDao()).insertaDPROGRAMALM(ldm);
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void oncDocChange() throws Exception {
        lstnume = numemiDao.findByDocumento(user.getIDEMPRESA(), getDatoEdicion().getIddocumento());
        numero = null;
        if (!lstnume.isEmpty()) {
            int i = 0;
            for (NumEmisor n : lstnume) {
                if (n.getIDDOCUMENTO().equalsIgnoreCase(getDatoEdicion().getIddocumento())) {
                    if(Integer.parseInt(n.getNUMERO())>=1){
                       i = Integer.parseInt(n.getNUMERO()) + 1; 
                    }else{
                        i = Integer.parseInt(n.getNUMERO());
                    }
                    
                }
            }
            numero = WebUtil.cerosIzquierda(i, 7);
        }

    }

    public void findDetalles() throws Exception {
        selectdprogprio = new DprogAlmPrioridad();
        selectdprogalmont = new DprogAlmMontacarga();
        lstracks = new ArrayList<DAlmacen_Racks>();
        sltracks = new ArrayList<DAlmacen_Racks>();
        idAlmacen = null;
        idDistribucion = null;
        iddistribucionpiso = null;
        lstdocs = docDao.findAll(user.getIDEMPRESA());
        lstnume = numemiDao.findByDocumento(user.getIDEMPRESA(), lstdocs.get(0).getIDDOCUMENTO());
        if (nuevoD) {
            if (!lstnume.get(0).getNUMERO().equalsIgnoreCase("0000001")) {
                numero = WebUtil.cerosIzquierda(Integer.parseInt(lstnume.get(0).getNUMERO()) + 1, 7);
            } else {
                numero = lstnume.get(0).getNUMERO();
            }
        } else {
            numero = getDatoEdicion().getNumero();
        }

        if (getLadd() == 1) {
            listadprogalmont = new ArrayList<DprogAlmMontacarga>();
            listdprogprio = new ArrayList<DprogAlmPrioridad>();
        } else {
            this.lista_sucursales = new ArrayList<String[]>();
            lista_sucursales = new menuDao().buscar_sucursal(user.getIDUSUARIO());
            op = respdao.findRespon(Integer.parseInt(user.getIDEMPRESA()), getDatoEdicion().getIdresponsable());
            listadprogalmont = dprogalmontDAO.findallDprogM(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdprogramaalm());
            for (DprogAlmMontacarga dal : listadprogalmont) {
                dal.setNota(new Notificacion());
                Notificacion temp =dprogalmontDAO.verNotif(dal.getIdempresa(), dal.getIdprogramaalm(), dal.getIdmontacarga());
                dal.getNota().setIdempresa(temp.getIdempresa());
                dal.getNota().setMensaje(temp.getMensaje());
                dal.getNota().setIdnotificacion(temp.getIdnotificacion());
                dal.getNota().setFechacreacion(temp.getFechacreacion());
//                dal.getNota().setFechaenvio(temp.getFechaenvio());
                dal.getNota().setPrioridad(temp.getPrioridad());
                dal.getNota().setEstado(temp.getEstado());
            }
            listdprogprio = dprogprioDAO.findDProgPrio(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdprogramaalm(), getDatoEdicion().getIdsucursal());
            fechaprogramaciont = new Date(getDatoEdicion().getFechaprogramacion().getTime());
            fechaejecuciont = new Date(getDatoEdicion().getFechaejecucion().getTime());
            if (getDatoEdicion().getFechafinalizacion() != null) {
                fechafinalizaciont = new Date(getDatoEdicion().getFechafinalizacion().getTime());
            }
        }
    }

    public Boolean esVistaValida() {
        if (getDatoEdicion().getIdtipoalmacen() == 0) {
            WebUtil.MensajeAdvertencia("Seleccione el tipo de almacen");
            return false;
        }
        if (op.getIdoperario() == null) {
            WebUtil.MensajeAdvertencia("Selecciones un Responsable");
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
        if (numero == null) {
            WebUtil.MensajeAdvertencia("Coloque Numero de documento");
        }
        if (listdprogprio == null || listdprogprio.isEmpty()) {
            WebUtil.MensajeAdvertencia("El detalle de Prioridad se encunotdprogntra Vacio");
        }
        if (listadprogalmont == null || listadprogalmont.isEmpty()) {
            WebUtil.MensajeAdvertencia("El detalle de Montacarga se encuentra Vacio");
        }
        return true;
    }

    public void verCntResponsable() {
        RequestContext.getCurrentInstance().openDialog("cntResponsable", modalOptions, null);
    }

    public void llenarResponsable(SelectEvent event) {
        this.op = (Responsable) event.getObject();
    }

    public void verCntMontacarga() {
        selectdprogalmont = new DprogAlmMontacarga();
        RequestContext.getCurrentInstance().openDialog("cntMontacarga", modalOptions, null);
    }

    public void verCntRegla() {
        RequestContext.getCurrentInstance().openDialog("cntReglas", modalOptions, null);
    }

    public void llenarRegla(SelectEvent event) {
        this.re = (Reglas) event.getObject();
    }

    public void onTabChange(TabChangeEvent event) {
        TabView tabView = (TabView) event.getComponent();
        selectTab = tabView.getChildren().indexOf(event.getTab());
    }

    public void showdialog1(int roIndex) {
            selectdprogalmont= listadprogalmont.get(roIndex);
            RequestContext.getCurrentInstance().update("dform:msgDetGrid");
            RequestContext.getCurrentInstance().execute("PF('msgDet').show()");
        
    }
    public void showdialog2(){
        RequestContext.getCurrentInstance().update("datos:almprioDetalle");
            RequestContext.getCurrentInstance().execute("PF('almPrioEdt').show()");
    }
    public void agregaNota(){
        RequestContext.getCurrentInstance().execute("PF('msgDet').hide()");
    }
    public void getActionAgregarDetalle() throws Exception {
        botonAgregarDetalle = true;
        if (selectTab == 0) {
            mo = new Montacarga();
            RequestContext.getCurrentInstance().update("datos:dlg_detallemontacarga");
            RequestContext.getCurrentInstance().execute("PF('dlg_detallemontacarga').show()");
        }
        if (selectTab == 1) {
            if (getDatoEdicion().getIdtipoalmacen() == 0) {
                WebUtil.MensajeError("Seleccione tipo de almacen");
            } else {
                sltracks = new ArrayList<DAlmacen_Racks>();
                if (lstracks.isEmpty() || lstracks == null) {
                    lstracks = new ArrayList<DAlmacen_Racks>();
                    re = new Reglas();
                    lstalm = almDao.findPorTipo(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdtipoalmacen());
                }
                RequestContext.getCurrentInstance().update("datos:dlg_detalleprio");
                RequestContext.getCurrentInstance().execute("PF('dlg_detalleprio').show()");
            }

        }
    }

    public void onChangeDrop() throws Exception {
        if (idAlmacen != null && !idAlmacen.equalsIgnoreCase("")) {
            lstDist = ddistDao.findDistActivos(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), idAlmacen);
        } else {
            lstDist = new ArrayList<DDistribucionUbicacion>();
        }
    }

    public void findDRacks() throws Exception {
        if (idDistribucion != null && !idDistribucion.equalsIgnoreCase("")) {
            if (lstracks.isEmpty() || lstracks == null) {
                lstracks = rackDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), idAlmacen, idDistribucion);
            }
            lisdnforma = new ArrayList<DNFormaUbicacion>();

            lisdnforma = dnfDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), idAlmacen, idDistribucion);
            listMultitabla2 = multidao.findDetalleTabla(user.getIDEMPRESA(), "13");
            dnforma = new DNFormaUbicacion();
        } else {
            lstracks = new ArrayList<DAlmacen_Racks>();
        }
    }

    public void getActionEditarDetalle() {
        try {
            //
            if (selectTab == 0) {
                botonEditarDetalle = true;
                RequestContext.getCurrentInstance().update("dlg_detallemontacarga");
                RequestContext.getCurrentInstance().execute("PF('dlg_detallemontacarga').show()");
            }
            if (selectTab == 1) {

            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public void getActionEliminarDetalle() {
        try {
            if (selectTab == 0) {
                listadprogalmont.remove(selectdprogalmont);
                selectdprogalmont = null;
                RequestContext.getCurrentInstance().update("datos:tab:tabForm:tbl");
                RequestContext.getCurrentInstance().update("dlg_detallemontacarga");
            }
            if (selectTab == 1) {
                listdprogprio.remove(selectdprogprio);
                selectdprogprio = null;
                RequestContext.getCurrentInstance().update("datos:tab:tbl2");
                RequestContext.getCurrentInstance().update("dlg_detalleprio");
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public void AgregarEditarDetalle() {
        if (selectTab == 0) {
            selectdprogalmont = new DprogAlmMontacarga();
            selectdprogalmont.setIdmontacarga(mo.getIDMONTACARGA());
            selectdprogalmont.setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
            Date now = new Date();
            selectdprogalmont.setFechacreacion(new Timestamp(now.getTime()));
            selectdprogalmont.setIdprogramaalm(getDatoEdicion().getIdprogramaalm());
            selectdprogalmont.setNota(new Notificacion());
            String idm = selectdprogalmont.getIdmontacarga();
            if (idm.equals("") || idm == null) {
                this.mensaje = "Seleccione una Operario";
                WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                return;
            }
            if (botonAgregarDetalle) {
                for (DprogAlmMontacarga dp : listadprogalmont) {
                    if (dp.getIdmontacarga().trim().equalsIgnoreCase(selectdprogalmont.getIdmontacarga().trim())) {
                        this.mensaje = "El operario ya estan registrado ";
                        WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                        //RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioDMontacargaOperario:numero');");
                        RequestContext.getCurrentInstance().execute("PF('dlg_detallemontacarga').hide()");
                        return;
                    }
                }
                listadprogalmont.add(selectdprogalmont);
            }
            if (botonEditarDetalle) {
                for (DprogAlmMontacarga detalle : listadprogalmont) {
                    if (detalle.getIdmontacarga().trim().equalsIgnoreCase(selectdprogalmont.getIdmontacarga().trim())) {
                        this.mensaje = "El operario ya estan registrado ";
                        WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                        //RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioDMontacargaOperario:numero');");
                        return;
                    }
                }
                for (DprogAlmMontacarga detalle : listadprogalmont) {
                    if (detalle.getIdmontacarga().trim().equalsIgnoreCase(selectdprogalmont.getIdmontacarga().trim())) {
                        detalle = selectdprogalmont;
                    }
                }
            }
            botonAgregarDetalle = false;
            botonEditarDetalle = false;
            selectdprogalmont = null;
            RequestContext.getCurrentInstance().execute("PF('dlg_detallemontacarga').hide()");
            RequestContext.getCurrentInstance().update("datos:tab:tabForm:tbl");
        }
        if (selectTab == 1) {
            selectdprogprio = null;
            int idr = re.getIdregla();
            if (!listdprogprio.isEmpty()) {
                for (DAlmacen_Racks dr : sltracks) {
                    for (DprogAlmPrioridad dpr : listdprogprio) {
                        if (dr.getIDRACK().trim().equalsIgnoreCase(String.valueOf(dpr.getIdrack())) && dr.getIDALMACEN().trim().equalsIgnoreCase(String.valueOf(dpr.getIdalmacen()))) {
                            this.mensaje = "El operario ya estan registrado ";
                            WebUtil.MensajeErrorNuevo("mensajeDialogDetalle", mensaje);
                            //RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioDMontacargaOperario:numero');");
                            return;
                        }
                    }
                }
                List<DprogAlmPrioridad> ltemp = new ArrayList<DprogAlmPrioridad>();
                for (DprogAlmPrioridad dp : listdprogprio) {
                    if (dp.getIdalmacen() == Integer.parseInt(sltracks.get(0).getIDALMACEN())) {
                        ltemp.add(dp);
                    }
                }
                int i = 1;
                int k = 0;
                DprogAlmPrioridad temp = new DprogAlmPrioridad();
                if (!ltemp.isEmpty()) {
                    temp = ltemp.get(ltemp.size() - 1);
                    k = temp.getPrioridadrack() + 1;
                } else {
                    temp = listdprogprio.get(listdprogprio.size() - 1);
                }
                for (DAlmacen_Racks dr : sltracks) {
                    DprogAlmPrioridad dprio = new DprogAlmPrioridad();
                    dprio.setIdprogramaalm(getDatoEdicion().getIdprogramaalm());
                    dprio.setIdsucursal(Integer.parseInt(dr.getIDSUCURSAL()));
                    dprio.setIdalmacen(Integer.parseInt(dr.getIDALMACEN()));
                    dprio.setIdrack(Integer.parseInt(dr.getIDRACK()));
                    dprio.setIdempresa(Integer.parseInt(dr.getIDEMPRESA()));
                    dprio.setIdregla(re.getIdregla());
                    dprio.setEstado(1);
                    if (!ltemp.isEmpty()) {
                        dprio.setPrioridadalmacen(temp.getPrioridadalmacen());
                        dprio.setPrioridadrack(k);
                        k++;
                    } else {
                        dprio.setPrioridadalmacen(temp.getPrioridadalmacen() + 1);
                        dprio.setPrioridadrack(i);
                        i++;
                    }
                    dprio.setSincroniza(1);
                    dprio.setFubicacion(dr.getFubicacion());
                    listdprogprio.add(dprio);
                }
            } else {
                int i = 1;
                for (DAlmacen_Racks dr : sltracks) {
                    DprogAlmPrioridad dprio = new DprogAlmPrioridad();
                    dprio.setIdprogramaalm(getDatoEdicion().getIdprogramaalm());
                    dprio.setIdsucursal(Integer.parseInt(dr.getIDSUCURSAL()));
                    dprio.setIdalmacen(Integer.parseInt(dr.getIDALMACEN()));
                    dprio.setIdrack(Integer.parseInt(dr.getIDRACK()));
                    dprio.setIdempresa(Integer.parseInt(dr.getIDEMPRESA()));
                    dprio.setIdregla(re.getIdregla());
                    dprio.setEstado(1);
                    dprio.setPrioridadalmacen(1);
                    dprio.setPrioridadrack(i);

                    dprio.setSincroniza(1);
                    dprio.setFubicacion(dr.getFubicacion());
                    listdprogprio.add(dprio);
                    i++;
                }
            }
            RequestContext.getCurrentInstance().execute("PF('dlg_detalleprio').hide()");
            RequestContext.getCurrentInstance().update("datos:tab:tbl2");
        }

    }

    public void valorMontaarga(SelectEvent event) {
        this.mo = (Montacarga) event.getObject();

    }

    public void genrarDistribucion(SelectEvent event) throws Exception {
        listDDNFormaUbicacion = (new DDNFormaUbicacionDao()).findAll(dnforma.getIDEMPRESA(), dnforma.getIDSUCURSAL(), dnforma.getIDALMACEN(), dnforma.getIDNFORMACIONUBICACION() == null ? "" : dnforma.getIDNFORMACIONUBICACION());
        RequestContext.getCurrentInstance().update("datos:listDDNFormaUbicacion");
    }

    public void llenarPrioridad() {

    }

    public void validarFnUbicacion() {
        if (sltracks == null || sltracks.isEmpty()) {
            WebUtil.MensajeError("SELECCIONES RACKS PARA ASIGNAR FORMA DE UBICACION");
        } else {
            if (dnforma != null && iddistribucionpiso != null) {
                for (DAlmacen_Racks dr : sltracks) {
                    if (dr.getFubicacion() == null) {
                        DDProgramacionalmprioridad ddprog = new DDProgramacionalmprioridad();
                        ddprog.setIdempresa(Integer.parseInt(dnforma.getIDEMPRESA()));
                        ddprog.setIdsucursal(Integer.parseInt(dnforma.getIDSUCURSAL()));
                        ddprog.setIdprogramaalm(getDatoEdicion().getIdprogramaalm());
                        ddprog.setIdalmacen(Integer.parseInt(dnforma.getIDALMACEN()));
                        ddprog.setIdrack(Integer.parseInt(dr.getIDRACK()));
                        ddprog.setIdnformacionubicacion(dnforma.getIDNFORMACIONUBICACION());
                        ddprog.setIdregla(re.getIdregla());
                        ddprog.setIddistribucionpiso(iddistribucionpiso);
                        dr.setFubicacion(ddprog);
                    }
                }
                RequestContext.getCurrentInstance().update("datos:tbl3");
                RequestContext.getCurrentInstance().execute("PF('dlg_Ubicacion').hide()");
                dnforma = null;
            } else {
                RequestContext.getCurrentInstance().execute("PF('dlg_Ubicacion').hide()");
                WebUtil.MensajeError("Seleciones Ubicacion o Seleccione Codigo de distribucion piso");
            }
        }
    }

    public Responsable getOp() {
        return op;
    }

    public void setOp(Responsable op) {
        this.op = op;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String[]> getLista_sucursales() {
        return lista_sucursales;
    }

    public void setLista_sucursales(List<String[]> lista_sucursales) {
        this.lista_sucursales = lista_sucursales;
    }

    public List<DprogAlmMontacarga> getListadprogalmont() {
        return listadprogalmont;
    }

    public void setListadprogalmont(List<DprogAlmMontacarga> listadprogalmont) {
        this.listadprogalmont = listadprogalmont;
    }

    public DprogAlmMontacarga getSelectdprogalmont() {
        return selectdprogalmont;
    }

    public void setSelectdprogalmont(DprogAlmMontacarga selectdprogalmont) {
        this.selectdprogalmont = selectdprogalmont;
    }

    public List<DprogAlmPrioridad> getListdprogprio() {
        return listdprogprio;
    }

    public void setListdprogprio(List<DprogAlmPrioridad> listdprogprio) {
        this.listdprogprio = listdprogprio;
    }

    public DprogAlmPrioridad getSelectdprogprio() {
        return selectdprogprio;
    }

    public void setSelectdprogprio(DprogAlmPrioridad selectdprogprio) {
        this.selectdprogprio = selectdprogprio;
    }

    public Montacarga getMo() {
        return mo;
    }

    public void setMo(Montacarga mo) {
        this.mo = mo;
    }

    public List<Almacen> getLstalm() {
        return lstalm;
    }

    public void setLstalm(List<Almacen> lstalm) {
        this.lstalm = lstalm;
    }

    public List<DDistribucionUbicacion> getLstDist() {
        return lstDist;
    }

    public void setLstDist(List<DDistribucionUbicacion> lstDist) {
        this.lstDist = lstDist;
    }

    public List<DAlmacen_Racks> getLstracks() {
        return lstracks;
    }

    public void setLstracks(List<DAlmacen_Racks> lstracks) {
        this.lstracks = lstracks;
    }

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getIdDistribucion() {
        return idDistribucion;
    }

    public void setIdDistribucion(String idDistribucion) {
        this.idDistribucion = idDistribucion;
    }

    public List<DAlmacen_Racks> getSltracks() {
        return sltracks;
    }

    public void setSltracks(List<DAlmacen_Racks> sltracks) {
        this.sltracks = sltracks;
    }

    public Reglas getRe() {
        return re;
    }

    public void setRe(Reglas re) {
        this.re = re;
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

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public NumEmisor getNuevaSerie() {
        return nuevaSerie;
    }

    public void setNuevaSerie(NumEmisor nuevaSerie) {
        this.nuevaSerie = nuevaSerie;
    }

    public boolean isNuevoD() {
        return nuevoD;
    }

    public void setNuevoD(boolean nuevoD) {
        this.nuevoD = nuevoD;
    }

    public List<DNFormaUbicacion> getLisdnforma() {
        return lisdnforma;
    }

    public void setLisdnforma(List<DNFormaUbicacion> lisdnforma) {
        this.lisdnforma = lisdnforma;
    }

    public DNFormaUbicacion getDnforma() {
        return dnforma;
    }

    public void setDnforma(DNFormaUbicacion dnforma) {
        this.dnforma = dnforma;
    }

    public DNForma_UbicacionDao getDnfDao() {
        return dnfDao;
    }

    public void setDnfDao(DNForma_UbicacionDao dnfDao) {
        this.dnfDao = dnfDao;
    }

    public List<Multitabla> getListMultitabla2() {
        return listMultitabla2;
    }

    public void setListMultitabla2(List<Multitabla> listMultitabla2) {
        this.listMultitabla2 = listMultitabla2;
    }

    public Integer getIddistribucionpiso() {
        return iddistribucionpiso;
    }

    public void setIddistribucionpiso(Integer iddistribucionpiso) {
        this.iddistribucionpiso = iddistribucionpiso;
    }

    public List<DDNFormaUbicacion> getListDDNFormaUbicacion() {
        return listDDNFormaUbicacion;
    }

    public void setListDDNFormaUbicacion(List<DDNFormaUbicacion> listDDNFormaUbicacion) {
        this.listDDNFormaUbicacion = listDDNFormaUbicacion;
    }

    public int getIndexrow() {
        return indexrow;
    }

    public void setIndexrow(int indexrow) {
        this.indexrow = indexrow;
    }

}
