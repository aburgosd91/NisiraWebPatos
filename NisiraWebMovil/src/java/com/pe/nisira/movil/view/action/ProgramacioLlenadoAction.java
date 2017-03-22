/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.DALMACEN_DISTRIBUCIONUBICACIONDAO;
import com.nisira.core.dao.DAlmacen_ColumnasDao;
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
import com.nisira.core.entity.DAlmacen_Pisos;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.core.entity.GeneracionCodigo;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Procesos;
import com.nisira.core.entity.ProgramacionLlenado;
import com.nisira.core.entity.ReglaLlenado;
import com.nisira.core.entity.TablaPrioridades;
import com.nisira.core.entity.TreeAlmacenes;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
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
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "programacioLlenadoAction")
@SessionScoped
public class ProgramacioLlenadoAction extends AbstactListAction<ProgramacionLlenado> {

    private String mensaje;
    private UsuarioBean user;
    private List<TablaPrioridades> lsttablaprio;
    private List<TablaPrioridades> slctablaprio;
    private ProgramacionLlenadoDao prllDao;
    private TablaPrioridadesDao tblDao;
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
    private int FILAS;
    private int COLUMNAS;
    private boolean temp;
    private boolean almAC;
    private boolean rackAC;
    private boolean pisoAC;
    private String slaml;
    private String slrack;
    private String slpiso;
    private TreeNode root1;
    /*AGREGADO POR ALEX*/
    public int numcolumnasrack;
    private TreeNode selectedNode;
    private List<DAlmacen_Columnas> lstcolm;
    private DAlmacen_Columnas slcdalmcolum;
    private List<Integer> arregloTempFC;

    public ProgramacioLlenadoAction() {
        mensaje = "";
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        lsttablaprio = new ArrayList<TablaPrioridades>();
        slctablaprio = new ArrayList<TablaPrioridades>();
        prllDao = new ProgramacionLlenadoDao();
        tblDao = new TablaPrioridadesDao();
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
        FILAS = 0;
        COLUMNAS = 0;
        temp = true;
        almAC = false;
        rackAC = false;
        pisoAC = false;
        slaml = "";
        slrack = "";
        slpiso = "";
        root1 = new DefaultTreeNode();
        lstcolm = new ArrayList<DAlmacen_Columnas>();
        slcdalmcolum = new DAlmacen_Columnas();
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
        prllDao = new ProgramacionLlenadoDao();
        tblDao = new TablaPrioridadesDao();
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
        FILAS = 0;
        COLUMNAS = 0;
        temp = true;
        almAC = false;
        rackAC = false;
        pisoAC = false;
        slaml = "";
        slrack = "";
        slpiso = "";
        root1 = new DefaultTreeNode();
        lstcolm = new ArrayList<DAlmacen_Columnas>();
        slcdalmcolum = new DAlmacen_Columnas();
        actualiza_ventana("wMnt_ProgramaLlenado");
        numcolumnasrack = 2;
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
        TreeAlmacenes raiz = new TreeAlmacenes();
        TreeNode treeAlmacen = null;
        TreeNode treeRack = null;
        TreeNode treePiso = null;
        raiz.setDescripcion("Raiz");
        raiz.setArregloTemp(new ArrayList<Integer>());
        root1 = new DefaultTreeNode(raiz, null);
        List<Almacen> lstal = (new AlmacenDao()).findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal());
        for (Almacen al : lstal) {
            DALMACEN_DISTRIBUCIONUBICACION slcdalmdist = (new DALMACEN_DISTRIBUCIONUBICACIONDAO()).findOne(al.getIDEMPRESA(), al.getIDSUCURSAL(), al.getIDALMACEN());
            List<DAlmacen_Racks> lstdalmracks = (new DAlmacen_RacksDao()).findAll(slcdalmdist.getIDEMPRESA(), slcdalmdist.getIDSUCURSAL(), slcdalmdist.getIDALMACEN(), slcdalmdist.getIDDISTRIBUCION());
            TreeAlmacenes alm = new TreeAlmacenes();
            alm.setId(String.valueOf(al.getIDALMACEN()));
            alm.setTipo("Almacen");
            alm.setDescripcion("Alamcen - " + al.getDESCRIPCION());
            alm.setArregloTemp(new ArrayList<Integer>());
            alm.setIddist(slcdalmdist.getIDDISTRIBUCION());
            treeAlmacen = new DefaultTreeNode("Almacen", alm, root1);
            for (DAlmacen_Racks ra : lstdalmracks) {
                List<DAlmacen_Pisos> lstdalmpisos = (new DAlmacen_PisosDao()).findAll(ra.getIDEMPRESA(), ra.getIDSUCURSAL(), ra.getIDALMACEN(), ra.getIDDISTRIBUCION(), ra.getIDRACK());
                TreeAlmacenes rk = new TreeAlmacenes();
                rk.setId(String.valueOf(ra.getIDRACK()));
                rk.setTipo("Rack");
                rk.setDescripcion("Rack - " + ra.getIDRACK());
                rk.setArregloTemp(new ArrayList<Integer>());
                treeRack = new DefaultTreeNode("Rack", rk, treeAlmacen);
                for (DAlmacen_Pisos p : lstdalmpisos) {
                    List<DAlmacen_Columnas> lstdalmcolum = (new DAlmacen_ColumnasDao()).findAll(p.getIDEMPRESA(), p.getIDSUCURSAL(), p.getIDALMACEN(), p.getIDDISTRIBUCION(), p.getIDRACK(), p.getIDPISO());
                    TreeAlmacenes ps = new TreeAlmacenes();
                    ps.setId(String.valueOf(p.getIDPISO()));
                    ps.setTipo("Piso");
                    ps.setDescripcion("Piso - " + p.getIDPISO());
                    ps.setArregloTemp(new ArrayList<Integer>());
                    ps.setLstcol(lstdalmcolum);
                    treePiso = new DefaultTreeNode("Piso", ps, treeRack);
                }
            }
        }
        if (getDatoEdicion().getIdproceso() != 0) {
            finicio = new Date(getDatoEdicion().getFinicio().getTime());
            lstGencod = genDao.findByIdProceso(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdproceso());
            lstRegall = regallDao.findAllProceso(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdproceso());
            slcRegall = regallDao.fineOne(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdreglas());
            slcgencod = genDao.fineOne(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdgeneracion());
            Map<Integer, List<TablaPrioridades>> gt = new HashMap<Integer, List<TablaPrioridades>>();
            gt = lsttablaprio.stream().collect(Collectors.groupingBy(TablaPrioridades::getIdalmacen));
            for (TreeNode ta : root1.getChildren()) {
                List<TablaPrioridades> alt = gt.get(Integer.parseInt(((TreeAlmacenes) ta.getData()).getId()));
                if (alt != null) {
                    ((TreeAlmacenes) ta.getData()).setPrioridad(alt.get(0).getPidalmacen());
                    ((TreeAlmacenes) ta.getData()).setSeleccionado(true);
                    ((TreeAlmacenes) ta.getData()).getArregloTemp().add(alt.get(0).getPidalmacen());
                    Map<Integer, List<TablaPrioridades>> gtt = alt.stream().collect(Collectors.groupingBy(TablaPrioridades::getIdrack));
                    for (TreeNode tra : ta.getChildren()) {
                        List<TablaPrioridades> ralt = gtt.get(Integer.parseInt(((TreeAlmacenes) tra.getData()).getId()));
                        if (ralt != null) {
                            ((TreeAlmacenes) tra.getData()).setPrioridad(ralt.get(0).getPidrack());
                            ((TreeAlmacenes) tra.getData()).setSeleccionado(true);
                            ((TreeAlmacenes) tra.getData()).getArregloTemp().add(ralt.get(0).getPidrack());

                            Map<String, List<TablaPrioridades>> gttt = ralt.stream().collect(Collectors.groupingBy(TablaPrioridades::getIdpiso));
                            for (TreeNode tpi : tra.getChildren()) {
                                List<TablaPrioridades> pist = gttt.get(((TreeAlmacenes) tpi.getData()).getId());
                                if (pist != null) {
                                    ((TreeAlmacenes) tpi.getData()).setPrioridad(pist.get(0).getPidpiso());
                                    ((TreeAlmacenes) tpi.getData()).setSeleccionado(true);
                                     ((TreeAlmacenes) tpi.getData()).getArregloTemp().add(pist.get(0).getPidpiso());
                                    for (DAlmacen_Columnas dc : ((TreeAlmacenes) tpi.getData()).getLstcol()) {
                                        for (TablaPrioridades tpc : pist) {
                                            if (tpc.getIdalmacen() == Integer.parseInt(dc.getIDALMACEN()) && tpc.getIddistribucion().equalsIgnoreCase(dc.getIDDISTRIBUCION()) && tpc.getIdrack() == Integer.parseInt(dc.getIDRACK().trim()) && tpc.getIdpiso().equalsIgnoreCase(dc.getIDPISO().trim()) && tpc.getIdfila().equalsIgnoreCase(dc.getIDFILA().trim()) && tpc.getIdcolumna().equalsIgnoreCase(dc.getIDCOLUMNA().trim())) {
                                                dc.setPRIORIDAD(tpc.getPidfila());                                               
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
        }
    }

    public void asignaPrioridad() {
        if (!selectedNode.getType().equalsIgnoreCase("default")) {
            TreeNode par = (TreeNode) selectedNode.getParent();
            TreeAlmacenes ch = (TreeAlmacenes) selectedNode.getData();
            List<Integer> arregloTemp = ((TreeAlmacenes) par.getData()).getArregloTemp();
            int posicion = 0;
            int temp = 0;
            /*ACCION DE SELECCION*/
            if (ch.isSeleccionado()) {
                ch.setSeleccionado(false);
                if (ch.getPrioridad() != 0) {
                    arregloTemp.remove(arregloTemp.indexOf(ch.getPrioridad()));
                    ch.setPrioridad(0);
                }
            } else {
                ch.setSeleccionado(true);
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
                ch.setPrioridad(posicion);
            }
            par.setExpanded(true);
            RequestContext.getCurrentInstance().update("datos:treeDist");
        }
    }

    public void verFilaColumna() {
        if (selectedNode.getType().equalsIgnoreCase("Piso")) {
            TreeAlmacenes ch = (TreeAlmacenes) selectedNode.getData();
            lstcolm = ch.getLstcol();
            arregloTempFC = ch.getArregloTemp();
            FILAS = Integer.parseInt(lstcolm.get(lstcolm.size() - 1).getIDFILA().trim());
            COLUMNAS = Integer.parseInt(lstcolm.get(lstcolm.size() - 1).getIDCOLUMNA().trim());
            RequestContext.getCurrentInstance().execute("PF('dialogFC').show()");
            RequestContext.getCurrentInstance().update("datos:dialogFC");

        }
    }

    public void fcSeleccionado() {
        try {
            int pos = lstcolm.indexOf(slcdalmcolum);
            int posicion = 0;
            int temp = 0;

            /*ACCION DE SELECCION*/
            if (slcdalmcolum.isSELECCIONADO()) {
                slcdalmcolum.setSELECCIONADO(false);
                if (lstcolm.get(pos).getPRIORIDAD() != 0) {
                    arregloTempFC.remove(arregloTempFC.indexOf(lstcolm.get(pos).getPRIORIDAD()));
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
            ((TreeAlmacenes) selectedNode.getData()).setLstcol(lstcolm);
            ((TreeAlmacenes) selectedNode.getData()).setArregloTemp(arregloTempFC);
            RequestContext.getCurrentInstance().update("datos:listFC");
            RequestContext.getCurrentInstance().update("datos:listFC:cuadroNivelFC");
            RequestContext.getCurrentInstance().update("datos:listFC:cuadroNivel:numeradorFC");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return;
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
            Logger.getLogger(ProgramacioLlenadoActionOld.class
                    .getName()).log(Level.SEVERE, null, ex);
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

    public void generar() {
        if (validarGen()) {
            String almacen = "";
            String rack = "";
            String piso = "";
            String columna = "";
            String fila = "";
            lsttablaprio = new ArrayList<TablaPrioridades>();
            for (TreeNode ta : root1.getChildren()) { //almacen
                if (((TreeAlmacenes) ta.getData()).getPrioridad() != 0) {
                    almacen = ((TreeAlmacenes) ta.getData()).getId();
                    for (TreeNode tra : ta.getChildren()) {//rack
                        if (((TreeAlmacenes) tra.getData()).getPrioridad() != 0) {
                            rack = ((TreeAlmacenes) tra.getData()).getId();
                            for (TreeNode tpi : tra.getChildren()) {//piso
                                if (((TreeAlmacenes) tra.getData()).getPrioridad() != 0) {
                                    piso = ((TreeAlmacenes) tra.getData()).getId();
                                    for (DAlmacen_Columnas dc : ((TreeAlmacenes) tpi.getData()).getLstcol()) {//Fila y Columna
                                        if (dc.getPRIORIDAD() != 0) {
                                            TablaPrioridades tbl = new TablaPrioridades();
                                            tbl.setIdempresa(getDatoEdicion().getIdempresa());
                                            tbl.setIdsucursal(getDatoEdicion().getIdsucursal());
                                            tbl.setIdalmacen(Integer.parseInt(((TreeAlmacenes) ta.getData()).getId()));
                                            tbl.setPidalmacen(((TreeAlmacenes) ta.getData()).getPrioridad());
                                            tbl.setIddistribucion(((TreeAlmacenes) ta.getData()).getIddist());
                                            tbl.setIdrack(Integer.parseInt(((TreeAlmacenes) tra.getData()).getId()));
                                            tbl.setPidrack(((TreeAlmacenes) tra.getData()).getPrioridad());
                                            tbl.setIdpiso(((TreeAlmacenes) tpi.getData()).getId());
                                            tbl.setPidpiso(((TreeAlmacenes) tpi.getData()).getPrioridad());
                                            tbl.setIdfila(dc.getIDFILA());
                                            tbl.setPidfila(dc.getPRIORIDAD());
                                            tbl.setIdcolumna(dc.getIDCOLUMNA());
                                            tbl.setPidcolumna(dc.getPRIORIDAD());
                                            fila = dc.getIDCOLUMNA().trim();
                                            columna = dc.getIDCOLUMNA().trim();
                                            lsttablaprio.add(tbl);
                                        } else {
                                            WebUtil.MensajeAdvertencia("Solo se generara hasta el Alamacen " + almacen + " Rack " + rack + " Piso " + piso + " Fila-Columna " + fila + "-" + columna);
                                            continue;
                                        }
                                    }
                                } else {
                                    WebUtil.MensajeAdvertencia("Solo se generara hasta el Alamacen " + almacen + " Rack " + rack + " Piso " + piso);
                                    continue;
                                }
                            }
                        } else {
                            WebUtil.MensajeAdvertencia("Solo se generara hasta el Alamacen " + almacen + " Rack " + rack);
                            continue;
                        }
                    }
                } else {
                    WebUtil.MensajeAdvertencia("Solo se generara hasta el Almacen " + almacen);
                    continue;
                }
            }
        }
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
            Logger.getLogger(ProgramacioLlenadoActionOld.class
                    .getName()).log(Level.SEVERE, null, ex);
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

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public TreeNode getRoot1() {
        return root1;
    }

    public void setRoot1(TreeNode root1) {
        this.root1 = root1;
    }

    public List<DAlmacen_Columnas> getLstcolm() {
        return lstcolm;
    }

    public void setLstcolm(List<DAlmacen_Columnas> lstcolm) {
        this.lstcolm = lstcolm;
    }

    public DAlmacen_Columnas getSlcdalmcolum() {
        return slcdalmcolum;
    }

    public void setSlcdalmcolum(DAlmacen_Columnas slcdalmcolum) {
        this.slcdalmcolum = slcdalmcolum;
    }

}
