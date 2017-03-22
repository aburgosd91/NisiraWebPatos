/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.DALMACEN_DISTRIBUCIONUBICACIONDAO;
import com.nisira.core.dao.DAlmacen_ColumnasDao;
import com.nisira.core.dao.DAlmacen_FilasDao;
import com.nisira.core.dao.DAlmacen_PisosDao;
import com.nisira.core.dao.DAlmacen_RacksDao;
import com.nisira.core.dao.GeneracionCodigoDao;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.ProcesosDao;
import com.nisira.core.dao.ProgramacionLlenadoDao;
import com.nisira.core.dao.ReglaLlenadoDao;
import com.nisira.core.dao.TablaPrioridadesDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.DALMACEN_DISTRIBUCIONUBICACION;
import com.nisira.core.entity.DAlmacen_Columnas;
import com.nisira.core.entity.DAlmacen_Filas;
import com.nisira.core.entity.DAlmacen_Pisos;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.core.entity.GeneracionCodigo;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Procesos;
import com.nisira.core.entity.ProgramacionLlenado;
import com.nisira.core.entity.ReglaLlenado;
import com.nisira.core.entity.TablaPrioridades;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.sun.jmx.remote.internal.ArrayQueue;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "programacioLlenadoActionOld")
@SessionScoped
public class ProgramacioLlenadoActionOld extends AbstactListAction<ProgramacionLlenado> {

    private String mensaje;
    private UsuarioBean user;
    private List<TablaPrioridades> lsttablaprio;
    private List<TablaPrioridades> slctablaprio;
    private List<Almacen> lstalmacen;
    private Almacen slcalmacen;
    private DALMACEN_DISTRIBUCIONUBICACION slcdalmdist;
    private List<DAlmacen_Racks> lstdalmracks;
    private DAlmacen_Racks slcdalmracks;
    private List<DAlmacen_Pisos> lstdalmpisos;
    private DAlmacen_Pisos slcdalmpisos;
    private List<DAlmacen_Columnas> lstdalmcolum;
    private DAlmacen_Columnas slcdalmcolum;
    private ProgramacionLlenadoDao prllDao;
    private TablaPrioridadesDao tblDao;
    private AlmacenDao almDao;
    private DALMACEN_DISTRIBUCIONUBICACIONDAO dalmdistDao;
    private DAlmacen_RacksDao dalmrackDao;
    private DAlmacen_PisosDao dalmpisoDao;
    private DAlmacen_ColumnasDao dalmcolumDao;
    private List<Procesos> lstPro;
    private ProcesosDao ProDao;
    private List<Multitabla> lstForma;
    private MultitablaDao FormaDao;
    private List<GeneracionCodigo> lstGencod;
    private GeneracionCodigo slcgencod;
    private GeneracionCodigoDao genDao;
    private List<ReglaLlenado> lstRegall;
    private ReglaLlenado slcRegall;
    private ReglaLlenadoDao regallDao;
    private Date finicio;
    private Date ffin;
    private List<Integer> arregloTemp;
    
    
    
    private int FILAS;
    private int COLUMNAS;
    private boolean temp;
    private boolean almAC;
    private boolean rackAC;
    private boolean pisoAC;
    private String slaml;
    private String slrack;
    private String slpiso;
    /*AGREGADO POR ALEX*/
    public int numcolumnasrack;

    public ProgramacioLlenadoActionOld() {
        mensaje = "";
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        lsttablaprio = new ArrayList<TablaPrioridades>();
        slctablaprio = new ArrayList<TablaPrioridades>();
        lstalmacen = new ArrayList<Almacen>();
        slcalmacen = new Almacen();
        lstdalmracks = new ArrayList<DAlmacen_Racks>();
        slcdalmracks = new DAlmacen_Racks();
        lstdalmpisos = new ArrayList<DAlmacen_Pisos>();
        slcdalmpisos = new DAlmacen_Pisos();
        lstdalmcolum = new ArrayList<DAlmacen_Columnas>();
        slcdalmcolum = new DAlmacen_Columnas();
        prllDao = new ProgramacionLlenadoDao();
        tblDao = new TablaPrioridadesDao();
        almDao = new AlmacenDao();
        dalmdistDao = new DALMACEN_DISTRIBUCIONUBICACIONDAO();
        dalmrackDao = new DAlmacen_RacksDao();
        dalmpisoDao = new DAlmacen_PisosDao();
        dalmcolumDao = new DAlmacen_ColumnasDao();
        lstPro = new ArrayList<Procesos>();
        ProDao = new ProcesosDao();
        lstForma = new ArrayList<Multitabla>();
        FormaDao = new MultitablaDao();
        lstGencod = new ArrayList<GeneracionCodigo>();
        slcgencod = new GeneracionCodigo();
        genDao = new GeneracionCodigoDao();
        lstRegall = new ArrayList<ReglaLlenado>();
        slcRegall = new ReglaLlenado();
        regallDao = new ReglaLlenadoDao();
        finicio = new Date();
        ffin = null;
        arregloTemp = new ArrayList<Integer>();
        FILAS = 0;
        COLUMNAS = 0;
        temp = true;
        almAC = false;
        rackAC = false;
        pisoAC = false;
        slaml = "";
        slrack = "";
        slpiso = "";
        actualiza_ventana("wMnt_ProgramaLlenado");
        numcolumnasrack = 2;
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_ProgramaLlenado");
            setListaDatos(prllDao.findAll(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(ProgramacioLlenadoActionOld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        lsttablaprio = new ArrayList<TablaPrioridades>();
        slctablaprio = new ArrayList<TablaPrioridades>();
        lstalmacen = new ArrayList<Almacen>();
        slcalmacen = new Almacen();
        lstdalmracks = new ArrayList<DAlmacen_Racks>();
        slcdalmracks = new DAlmacen_Racks();
        lstdalmpisos = new ArrayList<DAlmacen_Pisos>();
        slcdalmpisos = new DAlmacen_Pisos();
        slcdalmcolum = new DAlmacen_Columnas();
        lstdalmcolum = new ArrayList<DAlmacen_Columnas>();
        prllDao = new ProgramacionLlenadoDao();
        tblDao = new TablaPrioridadesDao();
        almDao = new AlmacenDao();
        dalmdistDao = new DALMACEN_DISTRIBUCIONUBICACIONDAO();
        dalmrackDao = new DAlmacen_RacksDao();
        dalmpisoDao = new DAlmacen_PisosDao();
        dalmcolumDao = new DAlmacen_ColumnasDao();
        lstPro = new ArrayList<Procesos>();
        ProDao = new ProcesosDao();
        lstForma = new ArrayList<Multitabla>();
        FormaDao = new MultitablaDao();
        lstGencod = new ArrayList<GeneracionCodigo>();
        slcgencod = new GeneracionCodigo();
        genDao = new GeneracionCodigoDao();
        lstRegall = new ArrayList<ReglaLlenado>();
        slcRegall = new ReglaLlenado();
        regallDao = new ReglaLlenadoDao();
        finicio = new Date();
        ffin = null;
        arregloTemp = new ArrayList<Integer>();
        FILAS = 0;
        COLUMNAS = 0;
        temp = true;
        almAC = false;
        rackAC = false;
        pisoAC = false;
        slaml = "";
        slrack = "";
        slpiso = "";
        actualiza_ventana("wMnt_ProgramaLlenado");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new ProgramacionLlenado());
        getDatoEdicion().setEstado(1);
        getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setIdsucursal(Integer.parseInt(Constantes.getIDSUCURSALGENERAL()));
        getDatoEdicion().setUsrcreacion(user.getIDUSUARIO());
    }

    public void findDetatlle() throws Exception {
        lsttablaprio = tblDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdprogramacionllenado());
        lstPro = ProDao.findAll(getDatoEdicion().getIdempresa());
        lstForma = FormaDao.findDetalleTabla(user.getIDEMPRESA(), "16");
        lstalmacen = almDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal());
        if (getDatoEdicion().getIdproceso() != 0) {
            finicio = new Date(getDatoEdicion().getFinicio().getTime());
            Map<Integer, List<TablaPrioridades>> gt = new HashMap<Integer, List<TablaPrioridades>>();
            gt = lsttablaprio.stream().collect(Collectors.groupingBy(TablaPrioridades::getIdalmacen));
            for (Almacen a : lstalmacen) {
                List<TablaPrioridades> ta = gt.get(Integer.parseInt(a.getIDALMACEN()));
                if (ta != null) {
                    a.setPRIORIDAD(ta.get(0).getPidalmacen());
                    arregloTemp.add(ta.get(0).getPidalmacen());
                    a.setSELECCIONADO(true);
                    slcdalmdist = dalmdistDao.findOne(a.getIDEMPRESA(), a.getIDSUCURSAL(), a.getIDALMACEN());
                    a.setLracks(dalmrackDao.findAll(slcdalmdist.getIDEMPRESA(), slcdalmdist.getIDSUCURSAL(), slcdalmdist.getIDALMACEN(), slcdalmdist.getIDDISTRIBUCION()));
                    Map<Integer, List<TablaPrioridades>> gtt = ta.stream().collect(Collectors.groupingBy(TablaPrioridades::getIdrack));
                    a.setArregloTempR(new ArrayList<Integer>());
                    for (DAlmacen_Racks da : a.getLracks()) {
                        List<TablaPrioridades> tdar = gtt.get(Integer.parseInt(da.getIDRACK()));
                        if (tdar != null) {
                            da.setPRIORIDAD(tdar.get(0).getPidrack());
                            a.getArregloTempR().add(tdar.get(0).getPidrack());
                            da.setSELECCIONADO(true);
                            da.setLpisos(dalmpisoDao.findAll(da.getIDEMPRESA(), da.getIDSUCURSAL(), da.getIDALMACEN(), da.getIDDISTRIBUCION(), da.getIDRACK()));
                            Map<String, List<TablaPrioridades>> gttt = tdar.stream().collect(Collectors.groupingBy(TablaPrioridades::getIdpiso));
                            da.setArregloTempP(new ArrayList<Integer>());
                            for (DAlmacen_Pisos dp : da.getLpisos()) {
                                List<TablaPrioridades> tdap = gttt.get(dp.getIDPISO());
                                if (tdap != null) {
                                    dp.setPRIORIDAD(tdap.get(0).getPidpiso());
                                    da.getArregloTempP().add(tdap.get(0).getPidpiso());
                                    dp.setSELECCIONADO(true);
                                    dp.setLcolumnas(dalmcolumDao.findAll(dp.getIDEMPRESA(), dp.getIDSUCURSAL(), dp.getIDALMACEN(), dp.getIDDISTRIBUCION(), dp.getIDRACK(), dp.getIDPISO()));
                                    FILAS = Integer.parseInt(dp.getLcolumnas().get(dp.getLcolumnas().size() - 1).getIDFILA().trim());
                                    COLUMNAS = Integer.parseInt(dp.getLcolumnas().get(dp.getLcolumnas().size() - 1).getIDCOLUMNA().trim());
                                    dp.setArregloTempFC(new ArrayList<Integer>());
                                    for (DAlmacen_Columnas dc : dp.getLcolumnas()) {
                                        for (TablaPrioridades tpc : tdap) {
                                            if (tpc.getIdalmacen() == Integer.parseInt(dc.getIDALMACEN()) && tpc.getIddistribucion().equalsIgnoreCase(dc.getIDDISTRIBUCION()) && tpc.getIdrack() == Integer.parseInt(dc.getIDRACK().trim()) && tpc.getIdpiso().equalsIgnoreCase(dc.getIDPISO().trim()) && tpc.getIdfila().equalsIgnoreCase(dc.getIDFILA().trim()) && tpc.getIdcolumna().equalsIgnoreCase(dc.getIDCOLUMNA().trim())) {
                                                dc.setPRIORIDAD(tpc.getPidfila());
                                                dp.getArregloTempFC().add(tpc.getPidfila());
                                                dc.setSELECCIONADO(true);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            lstGencod = genDao.findByIdProceso(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdproceso());
            lstRegall = regallDao.findAllProceso(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdproceso());
            slcRegall = regallDao.fineOne(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdreglas());
            slcgencod = genDao.fineOne(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdgeneracion());
        }

    }

    @Override
    public void grabar() {
        try {
            if (isVistaValida()) {
                getDatoEdicion().setFinicio(new Timestamp(finicio.getTime()));
                if (ffin != null) {
                    getDatoEdicion().setFfin(new Timestamp(ffin.getTime()));
                }
                getDatoEdicion().setIdgeneracion(slcgencod.getIDGENERACION());
                getDatoEdicion().setIdreglas(slcRegall.getIdreglas());
                getDatoEdicion().setIdprogramacionllenado(prllDao.grabar(getDatoEdicion()));

                tblDao.grabar(getDatoEdicion(), lsttablaprio);
                RequestContext.getCurrentInstance().update("datos");

            }
        } catch (Exception ex) {
            Logger.getLogger(ProgramacioLlenadoActionOld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validarGen() {
        if (getDatoEdicion().getIdproceso() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Codigo de Proceso");
            return false;
        }
        if (slcRegall == null) {
            WebUtil.MensajeAdvertencia("Ingrese Reglas");
            return false;
        }
        if (slcgencod == null) {
            WebUtil.MensajeAdvertencia("Ingrese Codigo Generacion");
            return false;
        }
        return true;
    }

    public boolean isVistaValida() {
        if (slcRegall == null) {
            WebUtil.MensajeAdvertencia("Ingrese Reglas");
            return false;
        }
        if (slcgencod == null) {
            WebUtil.MensajeAdvertencia("Ingrese Codigo Generacion");
            return false;
        }
        if (getDatoEdicion().getDescripcion() == null) {
            WebUtil.MensajeAdvertencia("Ingrese Descripcion");
            return false;
        }
        if (getDatoEdicion().getIdproceso() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Proceso");
            return false;
        }
        return true;
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
            String i = prllDao.grabar(getDatoEdicion());
        } catch (Exception ex) {
            Logger.getLogger(ProgramacioLlenadoActionOld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void genlistGeneracion() throws Exception {
        lstGencod = genDao.findByIdProceso(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdproceso());
        RequestContext.getCurrentInstance().update("datos:tblG");
        RequestContext.getCurrentInstance().execute("PF('dialogGen').show()");
    }

    public void genlistRegall() throws Exception {
        lstRegall = regallDao.findAllProceso(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdproceso());
        RequestContext.getCurrentInstance().update("datos:tblR");
        RequestContext.getCurrentInstance().execute("PF('dialogRel').show()");
    }

    public void generar() {
        if (validarGen()) {
            String almacen = "";
            String rack = "";
            String piso = "";
            String columna = "";
            String fila = "";
            lsttablaprio = new ArrayList<TablaPrioridades>();
            for (Almacen a : lstalmacen) {
                if (a.getLracks() != null && a.getPRIORIDAD() != 0) {
                    almacen = a.getIDALMACEN();
                    for (DAlmacen_Racks da : a.getLracks()) {
                        if (da.getPRIORIDAD() != 0 && da.getLpisos() != null) {
                            rack = da.getIDRACK();
                            for (DAlmacen_Pisos dp : da.getLpisos()) {
                                if (dp.getPRIORIDAD() != 0 && dp.getLcolumnas() != null) {
                                    piso = dp.getIDPISO();
                                    for (DAlmacen_Columnas dc : dp.getLcolumnas()) {
                                        if (dc.getPRIORIDAD() != 0) {
                                            TablaPrioridades tbl = new TablaPrioridades();
                                            tbl.setIdempresa(Integer.parseInt(a.getIDEMPRESA()));
                                            tbl.setIdsucursal(Integer.parseInt(a.getIDSUCURSAL()));
                                            tbl.setIdalmacen(Integer.parseInt(a.getIDALMACEN().trim()));
                                            tbl.setPidalmacen(a.getPRIORIDAD());
                                            tbl.setIddistribucion(dp.getIDDISTRIBUCION());
                                            tbl.setIdrack(Integer.parseInt(da.getIDRACK().trim()));
                                            tbl.setPidrack(da.getPRIORIDAD());
                                            tbl.setIdpiso(dp.getIDPISO());
                                            tbl.setPidpiso(dp.getPRIORIDAD());
                                            tbl.setIdfila(dc.getIDFILA());
                                            tbl.setPidfila(dc.getPRIORIDAD());
                                            tbl.setIdcolumna(dc.getIDCOLUMNA());
                                            tbl.setPidcolumna(dc.getPRIORIDAD());
                                            fila = dc.getIDCOLUMNA().trim();
                                            columna = dc.getIDCOLUMNA().trim();
                                            lsttablaprio.add(tbl);
                                        } else {
                                            WebUtil.MensajeAdvertencia("Solo se generara hasta el Alamacen " + almacen + " Rack " + rack + " Piso " + piso + " Fila-Columna " + fila + "-" + columna);
                                            return;
                                        }
                                    }
                                } else {
                                    WebUtil.MensajeAdvertencia("Solo se generara hasta el Alamacen " + almacen + " Rack " + rack + " Piso " + piso);
                                    return;
                                }
                            }
                        } else {
                            WebUtil.MensajeAdvertencia("Solo se generara hasta el Alamacen " + almacen + " Rack " + rack);
                            return;
                        }
                    }
                } else {
                    WebUtil.MensajeAdvertencia("Solo se generara hasta el Almacen " + almacen);
                    return;
                }
            }
        }
    }

    public void filaColumnaSeleccionado() {
        try {
            if (temp) {

                int pos = lstalmacen.indexOf(slcalmacen);
                int posicion = 0;
                int temp = 0;

                /*ACCION DE SELECCION*/
                if (slcalmacen.isSELECCIONADO()) {
                    slcalmacen.setSELECCIONADO(false);
                    if (lstalmacen.get(pos).getPRIORIDAD() != 0) {
                        arregloTemp.remove(arregloTemp.indexOf(lstalmacen.get(pos).getPRIORIDAD()));
                        slcalmacen.setPRIORIDAD(0);
                    }
                } else {
                    slcalmacen.setSELECCIONADO(true);
                    /*VERIFICAR SI HAY ELEMENTOS EN EL ARREGLO*/
                    if (arregloTemp.size() > 0) {
                        /*ORDENAR ARREGLO ASCENDENTE*/
                        for (int i = 0; i < arregloTemp.size() - 1; i++) {
                            for (int j = i + 1; j < arregloTemp.size(); j++) {
                                if (arregloTemp.get(i) > arregloTemp.get(j)) {
                                    temp = arregloTemp.get(i);
                                    arregloTemp.set(i, arregloTemp.get(j));
                                    arregloTemp.set(j, temp);
                                }
                            }
                        }
                        posicion = obtenerPosicion(arregloTemp);
                    } else {
                        posicion++;
                    }
                    arregloTemp.add(posicion);
                    slcalmacen.setPRIORIDAD(posicion);
                }
                lstalmacen.set(pos, slcalmacen);
                RequestContext.getCurrentInstance().update("datos:listAlm");
                RequestContext.getCurrentInstance().update("datos:listAlm:cuadroNivel");
                RequestContext.getCurrentInstance().update("datos:listAlm:cuadroNivel:numerador");
            }
            temp = true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return;
    }

    public void genRack(int i) {
        try {
            slcalmacen = lstalmacen.get(i);
            if (slcalmacen.getLracks() == null) {
                slcdalmdist = dalmdistDao.findOne(slcalmacen.getIDEMPRESA(), slcalmacen.getIDSUCURSAL(), slcalmacen.getIDALMACEN());
                lstdalmracks = dalmrackDao.findAll(slcdalmdist.getIDEMPRESA(), slcdalmdist.getIDSUCURSAL(), slcdalmdist.getIDALMACEN(), slcdalmdist.getIDDISTRIBUCION());
                lstalmacen.get(i).setLracks(lstdalmracks);
                slcalmacen.setArregloTempR(new ArrayList<Integer>());
            } else {
                lstdalmracks = slcalmacen.getLracks();
            }
            temp = false;
            slaml = "Almacen " + slcalmacen.getIDALMACEN();
            RequestContext.getCurrentInstance().update("datos:slal");
            RequestContext.getCurrentInstance().update("datos:listRack");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void actualizarDistribucionRack() {
        try {
            RequestContext.getCurrentInstance().update("datos:listRack");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void rackSeleccionado() {
        try {
            if (temp) {
                int pos = lstdalmracks.indexOf(slcdalmracks);
                int posicion = 0;
                int tempp = 0;
                List<Integer> arregloTempR = new ArrayList<Integer>();
                arregloTempR = slcalmacen.getArregloTempR();
                /*ACCION DE SELECCION*/
                if (slcdalmracks.isSELECCIONADO()) {
                    slcdalmracks.setSELECCIONADO(false);
                    if (lstdalmracks.get(pos).getPRIORIDAD() != 0) {
                        arregloTempR.remove(arregloTempR.indexOf(lstdalmracks.get(pos).getPRIORIDAD()));
                        slcdalmracks.setPRIORIDAD(0);
                    }
                } else {
                    slcdalmracks.setSELECCIONADO(true);
                    /*VERIFICAR SI HAY ELEMENTOS EN EL ARREGLO*/
                    if (arregloTempR.size() > 0) {
                        /*ORDENAR ARREGLO ASCENDENTE*/
                        for (int i = 0; i < arregloTempR.size() - 1; i++) {
                            for (int j = i + 1; j < arregloTempR.size(); j++) {
                                if (arregloTempR.get(i) > arregloTempR.get(j)) {
                                    tempp = arregloTempR.get(i);
                                    arregloTempR.set(i, arregloTempR.get(j));
                                    arregloTempR.set(j, tempp);
                                }
                            }
                        }
                        posicion = obtenerPosicion(arregloTempR);
                    } else {
                        posicion++;
                    }
                    arregloTempR.add(posicion);
                    slcdalmracks.setPRIORIDAD(posicion);
                }
                lstdalmracks.set(pos, slcdalmracks);
                RequestContext.getCurrentInstance().update("datos:listRack");
                RequestContext.getCurrentInstance().update("datos:listAlm:cuadroNivelR");
                RequestContext.getCurrentInstance().update("datos:listAlm:cuadroNivel:numeradorR");
            }
            temp = true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return;
    }

    public void genPiso(int i) {
        try {
            slcdalmracks = lstdalmracks.get(i);
            if (slcdalmracks.getLpisos() == null) {
                lstdalmpisos = dalmpisoDao.findAll(slcdalmracks.getIDEMPRESA(), slcdalmracks.getIDSUCURSAL(), slcdalmracks.getIDALMACEN(), slcdalmracks.getIDDISTRIBUCION(), slcdalmracks.getIDRACK());
                lstalmacen.get(lstalmacen.indexOf(slcalmacen)).getLracks().get(i).setLpisos(lstdalmpisos);
                slcdalmracks.setArregloTempP(new ArrayList<Integer>());

            } else {
                lstdalmpisos = slcdalmracks.getLpisos();
            }
            temp = false;
            slrack = "Rack " + slcdalmracks.getIDRACK();
            RequestContext.getCurrentInstance().update("datos:slra");
            RequestContext.getCurrentInstance().update("datos:listPiso");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void pisosSeleccionado() {
        try {
            if (temp) {
                int pos = lstdalmpisos.indexOf(slcdalmpisos);
                int posicion = 0;
                int temp = 0;
                List<Integer> arregloTempP = new ArrayList<Integer>();
                arregloTempP = slcdalmracks.getArregloTempP();
                /*ACCION DE SELECCION*/
                if (slcdalmpisos.isSELECCIONADO()) {
                    slcdalmpisos.setSELECCIONADO(false);
                    if (lstdalmpisos.get(pos).getPRIORIDAD() != 0) {
                        arregloTempP.remove(arregloTempP.indexOf(lstdalmpisos.get(pos).getPRIORIDAD()));
                        slcdalmpisos.setPRIORIDAD(0);
                    }
                } else {
                    slcdalmpisos.setSELECCIONADO(true);
                    /*VERIFICAR SI HAY ELEMENTOS EN EL ARREGLO*/
                    if (arregloTempP.size() > 0) {
                        /*ORDENAR ARREGLO ASCENDENTE*/
                        for (int i = 0; i < arregloTempP.size() - 1; i++) {
                            for (int j = i + 1; j < arregloTempP.size(); j++) {
                                if (arregloTempP.get(i) > arregloTempP.get(j)) {
                                    temp = arregloTempP.get(i);
                                    arregloTempP.set(i, arregloTempP.get(j));
                                    arregloTempP.set(j, temp);
                                }
                            }
                        }
                        posicion = obtenerPosicion(arregloTempP);
                    } else {
                        posicion++;
                    }
                    arregloTempP.add(posicion);
                    slcdalmpisos.setPRIORIDAD(posicion);
                }
                lstdalmpisos.set(pos, slcdalmpisos);
                RequestContext.getCurrentInstance().update("datos:listPiso");
                RequestContext.getCurrentInstance().update("datos:listAlm:cuadroNivelP");
                RequestContext.getCurrentInstance().update("datos:listAlm:cuadroNivel:numeradorP");
            }
            temp = true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return;
    }

    public void genFC(int i) {
        try {
            slcdalmpisos = lstdalmpisos.get(i);
            if (slcdalmpisos.getLcolumnas() == null) {
                lstdalmcolum = dalmcolumDao.findAll(slcdalmpisos.getIDEMPRESA(), slcdalmpisos.getIDSUCURSAL(), slcdalmpisos.getIDALMACEN(), slcdalmpisos.getIDDISTRIBUCION(), slcdalmpisos.getIDRACK(), slcdalmpisos.getIDPISO());
                FILAS = Integer.parseInt(lstdalmcolum.get(lstdalmcolum.size() - 1).getIDFILA().trim());
                COLUMNAS = Integer.parseInt(lstdalmcolum.get(lstdalmcolum.size() - 1).getIDCOLUMNA().trim());
                lstalmacen.get(lstalmacen.indexOf(slcalmacen)).getLracks().get(lstdalmracks.indexOf(slcdalmracks)).getLpisos().get(i).setLcolumnas(lstdalmcolum);
                slcdalmpisos.setArregloTempFC(new ArrayList<Integer>());
            } else {
                lstdalmcolum = slcdalmpisos.getLcolumnas();
            }
            temp = false;
            slpiso = "Piso " + slcdalmpisos.getIDPISO();
            RequestContext.getCurrentInstance().update("datos:slpis");
            RequestContext.getCurrentInstance().update("datos:listFC");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void fcSeleccionado() {
        try {
            int pos = lstdalmcolum.indexOf(slcdalmcolum);
            int posicion = 0;
            int temp = 0;
            List<Integer> arregloTempFC = new ArrayList<Integer>();
            arregloTempFC = slcdalmpisos.getArregloTempFC();
            /*ACCION DE SELECCION*/
            if (slcdalmcolum.isSELECCIONADO()) {
                slcdalmcolum.setSELECCIONADO(false);
                if (lstdalmcolum.get(pos).getPRIORIDAD() != 0) {
                    arregloTempFC.remove(arregloTempFC.indexOf(lstdalmcolum.get(pos).getPRIORIDAD()));
                    slcdalmcolum.setPRIORIDAD(0);
                }
            } else {
                slcdalmcolum.setSELECCIONADO(true);
                /*VERIFICAR SI HAY ELEMENTOS EN EL ARREGLO*/
                if (arregloTempFC.size() > 0) {
                    /*ORDENAR ARREGLO ASCENDENTE*/
                    for (int i = 0; i < arregloTempFC.size() - 1; i++) {
                        for (int j = i + 1; j < arregloTempFC.size(); j++) {
                            if (arregloTempFC.get(i) > arregloTempFC.get(j)) {
                                temp = arregloTempFC.get(i);
                                arregloTempFC.set(i, arregloTempFC.get(j));
                                arregloTempFC.set(j, temp);
                            }
                        }
                    }
                    posicion = obtenerPosicion(arregloTempFC);
                } else {
                    posicion++;
                }
                arregloTempFC.add(posicion);
                slcdalmcolum.setPRIORIDAD(posicion);
            }
            lstdalmcolum.set(pos, slcdalmcolum);
            lstalmacen.get(lstalmacen.indexOf(slcalmacen)).getLracks().get(lstdalmracks.indexOf(slcdalmracks)).getLpisos().get(lstdalmpisos.indexOf(slcdalmpisos)).setLcolumnas(lstdalmcolum);
            RequestContext.getCurrentInstance().update("datos:listFC");
            RequestContext.getCurrentInstance().update("datos:listAlm:cuadroNivelFC");
            RequestContext.getCurrentInstance().update("datos:listAlm:cuadroNivel:numeradorFC");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return;
    }

    public int obtenerPosicion(List<Integer> arreglo) {
        int pos = 0;
        boolean t = true;
        for (int i = 0; i < arreglo.size() & t; i++) {
            if (i > 0) {
                if (arreglo.get(i) - arreglo.get(i - 1) > 1) {
                    t = false;
                    pos = arreglo.get(i - 1) + 1;
                }
            } else {
                if (arreglo.get(i) != 1) {
                    t = false;
                    pos = 1;
                }
            }
        }
        if (pos == 0) {
            pos = arreglo.get(arreglo.size() - 1) + 1;
        }
        return pos;
    }

    public List<TablaPrioridades> getLsttablaprio() {
        return lsttablaprio;
    }

    public void setLsttablaprio(List<TablaPrioridades> lsttablaprio) {
        this.lsttablaprio = lsttablaprio;
    }

    public List<TablaPrioridades> getSlctablaprio() {
        return slctablaprio;
    }

    public void setSlctablaprio(List<TablaPrioridades> slctablaprio) {
        this.slctablaprio = slctablaprio;
    }

    public List<Almacen> getLstalmacen() {
        return lstalmacen;
    }

    public void setLstalmacen(List<Almacen> lstalmacen) {
        this.lstalmacen = lstalmacen;
    }

    public Almacen getSlcalmacen() {
        return slcalmacen;
    }

    public void setSlcalmacen(Almacen slcalmacen) {
        this.slcalmacen = slcalmacen;
    }

    public DALMACEN_DISTRIBUCIONUBICACION getSlcdalmdist() {
        return slcdalmdist;
    }

    public void setSlcdalmdist(DALMACEN_DISTRIBUCIONUBICACION slcdalmdist) {
        this.slcdalmdist = slcdalmdist;
    }

    public List<DAlmacen_Racks> getLstdalmracks() {
        return lstdalmracks;
    }

    public void setLstdalmracks(List<DAlmacen_Racks> lstdalmracks) {
        this.lstdalmracks = lstdalmracks;
    }

    public DAlmacen_Racks getSlcdalmracks() {
        return slcdalmracks;
    }

    public void setSlcdalmracks(DAlmacen_Racks slcdalmracks) {
        this.slcdalmracks = slcdalmracks;
    }

    public List<DAlmacen_Pisos> getLstdalmpisos() {
        return lstdalmpisos;
    }

    public void setLstdalmpisos(List<DAlmacen_Pisos> lstdalmpisos) {
        this.lstdalmpisos = lstdalmpisos;
    }

    public DAlmacen_Pisos getSlcdalmpisos() {
        return slcdalmpisos;
    }

    public void setSlcdalmpisos(DAlmacen_Pisos slcdalmpisos) {
        this.slcdalmpisos = slcdalmpisos;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Procesos> getLstPro() {
        return lstPro;
    }

    public void setLstPro(List<Procesos> lstPro) {
        this.lstPro = lstPro;
    }

    public List<Multitabla> getLstForma() {
        return lstForma;
    }

    public void setLstForma(List<Multitabla> lstForma) {
        this.lstForma = lstForma;
    }

    public List<GeneracionCodigo> getLstGencod() {
        return lstGencod;
    }

    public void setLstGencod(List<GeneracionCodigo> lstGencod) {
        this.lstGencod = lstGencod;
    }

    public List<ReglaLlenado> getLstRegall() {
        return lstRegall;
    }

    public void setLstRegall(List<ReglaLlenado> lstRegall) {
        this.lstRegall = lstRegall;
    }

    public GeneracionCodigo getSlcgencod() {
        return slcgencod;
    }

    public void setSlcgencod(GeneracionCodigo slcgencod) {
        this.slcgencod = slcgencod;
    }

    public ReglaLlenado getSlcRegall() {
        return slcRegall;
    }

    public void setSlcRegall(ReglaLlenado slcRegall) {
        this.slcRegall = slcRegall;
    }

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFfin() {
        return ffin;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public List<Integer> getArregloTemp() {
        return arregloTemp;
    }

    public void setArregloTemp(List<Integer> arregloTemp) {
        this.arregloTemp = arregloTemp;
    }

    public int getFILAS() {
        return FILAS;
    }

    public void setFILAS(int FILAS) {
        this.FILAS = FILAS;
    }

    public int getCOLUMNAS() {
        return COLUMNAS;
    }

    public void setCOLUMNAS(int COLUMNAS) {
        this.COLUMNAS = COLUMNAS;
    }

    public List<DAlmacen_Columnas> getLstdalmcolum() {
        return lstdalmcolum;
    }

    public void setLstdalmcolum(List<DAlmacen_Columnas> lstdalmcolum) {
        this.lstdalmcolum = lstdalmcolum;
    }

    public DAlmacen_Columnas getSlcdalmcolum() {
        return slcdalmcolum;
    }

    public void setSlcdalmcolum(DAlmacen_Columnas slcdalmcolum) {
        this.slcdalmcolum = slcdalmcolum;
    }

    public boolean isTemp() {
        return temp;
    }

    public void setTemp(boolean temp) {
        this.temp = temp;
    }

    public boolean isAlmAC() {
        return almAC;
    }

    public void setAlmAC(boolean almAC) {
        this.almAC = almAC;
    }

    public boolean isRackAC() {
        return rackAC;
    }

    public void setRackAC(boolean rackAC) {
        this.rackAC = rackAC;
    }

    public boolean isPisoAC() {
        return pisoAC;
    }

    public void setPisoAC(boolean pisoAC) {
        this.pisoAC = pisoAC;
    }

    public String getSlaml() {
        return slaml;
    }

    public void setSlaml(String slaml) {
        this.slaml = slaml;
    }

    public String getSlrack() {
        return slrack;
    }

    public void setSlrack(String slrack) {
        this.slrack = slrack;
    }

    public String getSlpiso() {
        return slpiso;
    }

    public void setSlpiso(String slpiso) {
        this.slpiso = slpiso;
    }

    /**
     * @return the numcolumnasrack
     */
    public int getNumcolumnasrack() {
        return numcolumnasrack;
    }

    /**
     * @param numcolumnasrack the numcolumnasrack to set
     */
    public void setNumcolumnasrack(int numcolumnasrack) {
        this.numcolumnasrack = numcolumnasrack;
    }

}
