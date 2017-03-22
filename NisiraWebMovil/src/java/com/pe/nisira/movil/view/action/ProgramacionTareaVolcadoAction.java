/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.Caracteristicas_ProductoDao;
import com.nisira.core.dao.DGeneracionCodigoDao;
import com.nisira.core.dao.DocumentoDao;
import com.nisira.core.dao.DprogramacionTareaLlegadaDao;
import com.nisira.core.dao.DprogramacionTareaPartidaDao;
import com.nisira.core.dao.DreglaLlenadoGeneracionDao;
import com.nisira.core.dao.MontacargaDao;
import com.nisira.core.dao.MovUbicacionDAO;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.NotificacionDao;
import com.nisira.core.dao.NumEmisorDao;
import com.nisira.core.dao.ProcesosDao;
import com.nisira.core.dao.ProgramacionLlenadoDao;
import com.nisira.core.dao.ProgramacionTareaDao;
import com.nisira.core.dao.QuickNotesDao;
import com.nisira.core.dao.ZonaDao;
import com.nisira.core.entity.Caracteristicas_Producto;
import com.nisira.core.entity.CustomCeckBox;
import com.nisira.core.entity.DGeneracionCodigo;
import com.nisira.core.entity.DZonaAccesorio;
import com.nisira.core.entity.Documento;
import com.nisira.core.entity.DprogramacionTareaLlegada;
import com.nisira.core.entity.DprogramacionTareaPartida;
import com.nisira.core.entity.DreglaLlenadoGeneracion;
import com.nisira.core.entity.EnvioNotificacion;
import com.nisira.core.entity.Montacarga;
import com.nisira.core.entity.MovUbicacion;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Notificacion;
import com.nisira.core.entity.NumEmisor;
import com.nisira.core.entity.Procesos;
import com.nisira.core.entity.ProgramacionLlenado;
import com.nisira.core.entity.ProgramacionTarea;
import com.nisira.core.entity.QuickNotes;
import com.nisira.core.entity.Zona;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.DataTableColumn;
import com.pe.nisira.movil.view.util.WebUtil;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
@ManagedBean(name = "ProgramacionTareaVolcadoAction")
@SessionScoped
public class ProgramacionTareaVolcadoAction extends AbstactListAction<ProgramacionTarea> {

    private ProgramacionTareaDao ptdao;
    private List<DprogramacionTareaPartida> lstdprogtpartB;
    private List<DprogramacionTareaPartida> lstdprogtpart;
    private DprogramacionTareaPartida slcdprogtpart;
    private DprogramacionTareaPartidaDao dprogtpartDao;
    private List<DprogramacionTareaLlegada> lstdprogtlleg;
    private List<DprogramacionTareaLlegada> slcdprogtlleg;
    private DprogramacionTareaLlegadaDao dprogtllegDao;
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
    private List<DGeneracionCodigo> lstdgen;
    private DGeneracionCodigoDao dgendao;
    private List<DreglaLlenadoGeneracion> lstdreglle;
    private DreglaLlenadoGeneracionDao dregllDao;
    private List<MovUbicacion> lstmovubi;
    private MovUbicacionDAO movubiDAO;
    private List<Multitabla> listMultitabla;
    private List<Caracteristicas_Producto> lstcarap;
    private Caracteristicas_ProductoDao carapDAO;
    private int idzona;
    private List<Zona> lstzonas;
    private Zona slcZona;
    private List<DataTableColumn> dataTableColumns;
    private List<String> slcfiltro;
    private List<Caracteristicas_Producto> filtro;
    private List<CustomCeckBox> detfil;
    private List<QuickNotes> notasRapidas;
    public ProgramacionTareaVolcadoAction() {
        ptdao = new ProgramacionTareaDao();
        lstdprogtpartB = new ArrayList<DprogramacionTareaPartida>();
        lstdprogtpart = new ArrayList<DprogramacionTareaPartida>();
        slcdprogtpart = new DprogramacionTareaPartida();
        dprogtpartDao = new DprogramacionTareaPartidaDao();
        lstdprogtlleg = new ArrayList<DprogramacionTareaLlegada>();
        slcdprogtlleg = new ArrayList<DprogramacionTareaLlegada>();
        dprogtllegDao = new DprogramacionTareaLlegadaDao();
        mo = new Montacarga();
        lstproceso = new ArrayList<Procesos>();
        lstdocs = new ArrayList<Documento>();
        docDao = new DocumentoDao();
        lstnume = new ArrayList<NumEmisor>();
        numemiDao = new NumEmisorDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);;
        numero = "";
        mensaje = "";
        nuevaSerie = new NumEmisor();
        fechaprogramaciont = new Date();
        fechaejecuciont = null;
        fechafinalizaciont = null;
        lstdgen = new ArrayList<DGeneracionCodigo>();
        dgendao = new DGeneracionCodigoDao();
        lstdreglle = new ArrayList<DreglaLlenadoGeneracion>();
        dregllDao = new DreglaLlenadoGeneracionDao();
        lstmovubi = new ArrayList<MovUbicacion>();
        movubiDAO = new MovUbicacionDAO();
        listMultitabla = new ArrayList<Multitabla>();
        lstcarap = new ArrayList<Caracteristicas_Producto>();
        carapDAO = new Caracteristicas_ProductoDao();
        idzona = 0;
        lstzonas = new ArrayList<Zona>();
        slcZona = new Zona();
        this.dataTableColumns = new ArrayList<DataTableColumn>();
        this.filtro = new ArrayList<Caracteristicas_Producto>();
        slcfiltro = new ArrayList<String>();
        detfil = new ArrayList<CustomCeckBox>();
        notasRapidas = new ArrayList<>();
        actualiza_ventana("wMnt_ProgramacionTareaVol");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            setListaDatos(ptdao.findAll(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL(), 1));
        } catch (Exception ex) {
            Logger.getLogger(ProgramacionTareaRecepcionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onZonaSelec() throws Exception {
        slcZona = lstzonas.stream().filter((zona) -> zona.getIDZONA() == idzona).findAny().get();
        lstdprogtpartB = dprogtpartDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdprogramaciontarea());
        lstmovubi = movubiDAO.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), slcZona.getIDZONA());
        lstdprogtpartB = pen();
        lstdprogtpart = lstdprogtpartB;
    }

    public void findetalle() throws Exception {
        lstproceso = (new ProcesosDao()).findAll(user.getIDEMPRESA());
        lstdocs = docDao.findAll(user.getIDEMPRESA());
        lstnume = numemiDao.findByDocumento(user.getIDEMPRESA(), lstdocs.get(0).getIDDOCUMENTO());
        listMultitabla = (new MultitablaDao()).findDetalleTabla(user.getIDEMPRESA(), "17");
        mo = (new MontacargaDao()).findById(String.valueOf(getDatoEdicion().getIdempresa()), String.valueOf(getDatoEdicion().getIDMONTACARGA()));
        onProcesoSelect();
        List<Integer> iList = ptdao.recepProcesos(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal());
        for (Integer k : iList) {
            lstzonas.addAll((new ZonaDao()).findAllAcc(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL(), k));
        }
        filtro = (new Caracteristicas_ProductoDao()).findAll(getDatoEdicion().getIdempresa());
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
            lstmovubi = movubiDAO.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(),idzona);
            lstdprogtpartB = pen();
        } else {
            numero = lstnume.get(0).getNUMERO();
        }
    }

    public void listFiltros() throws Exception {
        for (String c : slcfiltro) {
            CustomCeckBox ccb = new CustomCeckBox();
            List<Caracteristicas_Producto> det = new ArrayList<Caracteristicas_Producto>();
            String[] p = c.split(",");
            det = (new Caracteristicas_ProductoDao()).findDet(p[1]);
            ccb.setHeader(p[0]);
            ccb.setSeleccion(new ArrayList<String>());
            ccb.setBoxes(det);
            detfil.add(ccb);
        }
        RequestContext.getCurrentInstance().update("datos:dfilt");
        RequestContext.getCurrentInstance().execute("PF('filt').hide()");
        RequestContext.getCurrentInstance().execute("PF('dfilt').show()");
    }

    public void ejecFiltros() {
        lstdprogtpart = new ArrayList<DprogramacionTareaPartida>();
        List<DprogramacionTareaPartida> temp = lstdprogtpartB;
        for (String f : slcfiltro) {
            String[] p = f.split(",");
            CustomCeckBox secl = new CustomCeckBox();
            for (CustomCeckBox c : detfil) {
                if (p[0].equalsIgnoreCase(c.getHeader())) {
                    secl = c;
                }
            }
            List<DprogramacionTareaPartida> temp2 = new ArrayList<DprogramacionTareaPartida>();
            Iterator<DprogramacionTareaPartida> it = temp.iterator();
            int item = 1;
            while (it.hasNext()) {
                DprogramacionTareaPartida i = it.next();
                if (i.getLista().get(p[0]) != null) {
                    for (String sl : secl.getSeleccion()) {
                        if (String.valueOf(i.getLista().get(p[0])).equalsIgnoreCase(sl)) {
                            i.setItem(item);
                            temp2.add(i);
                            item++;
                        }
                    }
                }
            }
            temp = temp2;
        }
        lstdprogtpart = temp;
        RequestContext.getCurrentInstance().update("datos:tab:tblpart");
        RequestContext.getCurrentInstance().execute("PF('dfilt').hide()");
    }

    public List<DprogramacionTareaPartida> pen() throws Exception {
        List<DprogramacionTareaPartida> re = new ArrayList<DprogramacionTareaPartida>();
        int in = 1;
        String idprog = lstmovubi.get(0).getIDPROGRAMACIONTAREA();
        List<DprogramacionTareaLlegada> temdpll = dprogtllegDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), idprog);
        int k = 0;
        dataTableColumns = new ArrayList<DataTableColumn>();
        for (DprogramacionTareaLlegada tdpll : temdpll) {
            List<DreglaLlenadoGeneracion> ld = (new DreglaLlenadoGeneracionDao()).findAllDesc(tdpll.getIdempresa(), tdpll.getIdsucursal(), tdpll.getIdgeneracion(), tdpll.getIdreglas());
            for (DreglaLlenadoGeneracion l : ld) {
                dataTableColumns.add(new DataTableColumn(l.getParametro(), String.valueOf(k)));
                k++;
            }
        }
        for (MovUbicacion l : lstmovubi) {
            DprogramacionTareaPartida dp = new DprogramacionTareaPartida();
            dp.setIdempresa(l.getIDEMPRESA());
            dp.setIdsucursal(l.getIDSUCURSAL());
            dp.setIdprogramaciontarea("");
            dp.setItem(in);
            dp.setIdproceso(getDatoEdicion().getIdproceso());
            dp.setIdzona(l.getIDZONA());
            dp.setIdalmacen(l.getIDALMACEN());
            dp.setIdaccesorio(l.getIDACCESORIO());
            dp.setIdpaleta(l.getIDPALETA());
            dp.setIdubicacion(l.getIDUBICACION());
            dp.setNROPALETA(l.getNROPALETA());
            HashMap<String, Object> hm = new HashMap<String, Object>();
            for (DprogramacionTareaLlegada tdpll : temdpll) {
                List<DreglaLlenadoGeneracion> ld = (new DreglaLlenadoGeneracionDao()).findAllDesc(tdpll.getIdempresa(), tdpll.getIdsucursal(), tdpll.getIdgeneracion(), tdpll.getIdreglas());
                for (DreglaLlenadoGeneracion ll : ld) {
                    String v = (String) l.getNROPALETA().subSequence(ll.getDinicio() - 1, ll.getDfin());
                    List<Caracteristicas_Producto> cap = (new Caracteristicas_ProductoDao()).findFilter(ll.getParametro(), tdpll.getIdempresa());
                    for (Caracteristicas_Producto c : cap) {
                        if (c.getAbrev().equalsIgnoreCase(v)) {
                            hm.put(ll.getParametro(), c.getAbrev());
                            dp.setLista(hm);
                        }
                    }

                }
            }
            re.add(dp);
            in++;
        }
        return re;
    }

    public void onProcesoSelect() throws Exception {
        lstdprogtlleg = new ArrayList<DprogramacionTareaLlegada>();
        List<ProgramacionLlenado> lstprogll = (new ProgramacionLlenadoDao()).genDProgLlen(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdproceso());
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

    @Override
    public String getIniciar() {
        ptdao = new ProgramacionTareaDao();
        lstdprogtpartB = new ArrayList<DprogramacionTareaPartida>();
        lstdprogtpart = new ArrayList<DprogramacionTareaPartida>();
        slcdprogtpart = new DprogramacionTareaPartida();
        dprogtpartDao = new DprogramacionTareaPartidaDao();
        lstdprogtlleg = new ArrayList<DprogramacionTareaLlegada>();
        slcdprogtlleg = new ArrayList<DprogramacionTareaLlegada>();
        dprogtllegDao = new DprogramacionTareaLlegadaDao();
        mo = new Montacarga();
        lstproceso = new ArrayList<Procesos>();
        lstdocs = new ArrayList<Documento>();
        docDao = new DocumentoDao();
        lstnume = new ArrayList<NumEmisor>();
        numemiDao = new NumEmisorDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);;
        numero = "";
        mensaje = "";
        nuevaSerie = new NumEmisor();
        fechaprogramaciont = new Date();
        fechaejecuciont = null;
        fechafinalizaciont = null;
        lstdgen = new ArrayList<DGeneracionCodigo>();
        dgendao = new DGeneracionCodigoDao();
        lstdreglle = new ArrayList<DreglaLlenadoGeneracion>();
        dregllDao = new DreglaLlenadoGeneracionDao();
        lstmovubi = new ArrayList<MovUbicacion>();
        movubiDAO = new MovUbicacionDAO();
        listMultitabla = new ArrayList<Multitabla>();
        lstcarap = new ArrayList<Caracteristicas_Producto>();
        carapDAO = new Caracteristicas_ProductoDao();
        idzona = 0;
        lstzonas = new ArrayList<Zona>();
        slcZona = new Zona();
        this.dataTableColumns = new ArrayList<DataTableColumn>();
        this.filtro = new ArrayList<Caracteristicas_Producto>();
        slcfiltro = new ArrayList<String>();
        detfil = new ArrayList<CustomCeckBox>();
        notasRapidas = new ArrayList<>();
        actualiza_ventana("wMnt_ProgramacionTareaVol");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new ProgramacionTarea());
        getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setIdsucursal(Integer.parseInt(Constantes.getIDSUCURSALGENERAL()));
        getDatoEdicion().setEstado(1);
        getDatoEdicion().setTipotarea(1);
        getDatoEdicion().setUsrcreacion(user.getIDUSUARIO());
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
                if (lstdprogtpart.isEmpty()) {
                    WebUtil.MensajeAdvertencia("Seleccione Programaciones de llenado");
                } else {
                    /*NUEVO GUARDAR TOTAL*/
                    i = ptdao.grabar(getDatoEdicion(), lstdprogtpart, slcdprogtlleg);
                    getDatoEdicion().setIdprogramaciontarea(i);
                    setMensaje(WebUtil.exitoRegistrar("Programación Tarea Recepeción Materia Prima ", i));
                    WebUtil.info(getMensaje());
                    notificacionEnvio(i, String.valueOf(getDatoEdicion().getIDMONTACARGA()));
                }
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(ProgramacionTareaRecepcionAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
    }

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void verCntMontacarga() {
        RequestContext.getCurrentInstance().openDialog("cntMontacarga", modalOptions, null);
    }

    public void valorMontaarga(SelectEvent event) {
        this.mo = (Montacarga) event.getObject();

    }

    public List<DprogramacionTareaPartida> getLstdprogtpartB() {
        return lstdprogtpartB;
    }

    public void setLstdprogtpartB(List<DprogramacionTareaPartida> lstdprogtpartB) {
        this.lstdprogtpartB = lstdprogtpartB;
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

    public List<DGeneracionCodigo> getLstdgen() {
        return lstdgen;
    }

    public void setLstdgen(List<DGeneracionCodigo> lstdgen) {
        this.lstdgen = lstdgen;
    }

    public List<DreglaLlenadoGeneracion> getLstdreglle() {
        return lstdreglle;
    }

    public void setLstdreglle(List<DreglaLlenadoGeneracion> lstdreglle) {
        this.lstdreglle = lstdreglle;
    }

    public List<MovUbicacion> getLstmovubi() {
        return lstmovubi;
    }

    public void setLstmovubi(List<MovUbicacion> lstmovubi) {
        this.lstmovubi = lstmovubi;
    }

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
    }

    public List<Caracteristicas_Producto> getLstcarap() {
        return lstcarap;
    }

    public void setLstcarap(List<Caracteristicas_Producto> lstcarap) {
        this.lstcarap = lstcarap;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    public List<Zona> getLstzonas() {
        return lstzonas;
    }

    public void setLstzonas(List<Zona> lstzonas) {
        this.lstzonas = lstzonas;
    }

    public Zona getSlcZona() {
        return slcZona;
    }

    public void setSlcZona(Zona slcZona) {
        this.slcZona = slcZona;
    }

    public List<DataTableColumn> getDataTableColumns() {
        return dataTableColumns;
    }

    public void setDataTableColumns(List<DataTableColumn> dataTableColumns) {
        this.dataTableColumns = dataTableColumns;
    }

    public List<String> getSlcfiltro() {
        return slcfiltro;
    }

    public void setSlcfiltro(List<String> slcfiltro) {
        this.slcfiltro = slcfiltro;
    }

    public List<Caracteristicas_Producto> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<Caracteristicas_Producto> filtro) {
        this.filtro = filtro;
    }

    public List<CustomCeckBox> getDetfil() {
        return detfil;
    }

    public void setDetfil(List<CustomCeckBox> detfil) {
        this.detfil = detfil;
    }

}
