/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.DAlmacenDiagramaDAO;
import com.nisira.core.dao.DAlmacen_ColumnasDao;
import com.nisira.core.dao.DAlmacen_FilasDao;
import com.nisira.core.dao.DAlmacen_PisosDao;
import com.nisira.core.dao.DAlmacen_RacksDao;
import com.nisira.core.dao.DDistribucionUbicacionDao;
import com.nisira.core.dao.DZonaAccesorioDao;
import com.nisira.core.dao.DZonaDiagramaDao;
import com.nisira.core.dao.DZonaDiagramaUbicacionDao;
import com.nisira.core.dao.DZonaGeneralDao;
import com.nisira.core.dao.SucursalDao;
import com.nisira.core.dao.ZonaDao;
import com.nisira.core.dao.ZonaGeneralDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.DAlmacenDiagrama;
import com.nisira.core.entity.DAlmacen_Columnas;
import com.nisira.core.entity.DAlmacen_Filas;
import com.nisira.core.entity.DAlmacen_Pisos;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.core.entity.DDistribucionUbicacion;
import com.nisira.core.entity.DZonaAccesorio;
import com.nisira.core.entity.DZonaAlmacen;
import com.nisira.core.entity.DZonaDiagrama;
import com.nisira.core.entity.DZonaDiagramaUbicacion;
import com.nisira.core.entity.DZonaGeneral;
import com.nisira.core.entity.DiagExcel;
import com.nisira.core.entity.Leyenda;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.entity.TablaAlmacen;
import com.nisira.core.entity.Zona;
import com.nisira.core.entity.ZonaAlmacen;
import com.nisira.core.entity.ZonaGeneral;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.TablaDistribucion;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SlideEndEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "zonaGeneralAction")
@SessionScoped
public class ZonaGeneralAction extends AbstactListAction<ZonaGeneral> implements Serializable {

    private List<Sucursal> listSucursal;
    private UploadedFile upFile;
    private List<Zona> listZona;
    private List<Zona> filterZona;
    private ZonaDao zonaDao;
    private Zona selectZona;
    private String color;
    private int escala;
    private boolean borradzonageneral;
    private boolean addpuerta;
    private List<Leyenda> listLeyenda;
    private Leyenda selectLeyenda;
    private boolean estadoDocumento;
    private ZonaAlmacen slcZonaAlmacen;
    private List<Integer> oblist;
    private List<ZonaAlmacen> listZonaAlmacen;
    private List<DAlmacenDiagrama> listDAlmacenDiagrama;
    private DAlmacenDiagramaDAO daoDAlmacenDiagrama;
    private List<DZonaDiagrama> lstDZonaDiagram;
    private DZonaDiagramaDao dzonaDiagDao;
    private List<DZonaGeneral> slclistDZonaGeneral;
    private List<DZonaGeneral> listDZonaGeneral;
    private List<ArrayList<DZonaGeneral>> listlistDZonaGeneral;
    private DZonaGeneral selectDZonaGeneral;
    private ZonaGeneral selectZonaGeneral;
    private ZonaGeneralDao zonaGeneralDao;
    private DZonaGeneralDao dzonaGeneralDao;
    private String mensaje;
    private UsuarioBean user;
    private List<DZonaDiagramaUbicacion> compList;
    private DZonaDiagramaUbicacionDao compDao;
    private HashMap<String, String> almDist;
    private List<DiagExcel> ListO = new ArrayList<DiagExcel>();

    public ZonaGeneralAction() {

        zonaDao = new ZonaDao();
        oblist = new ArrayList<Integer>();
        listSucursal = new ArrayList<Sucursal>();
        listZona = new ArrayList<Zona>();
        listSucursal = new ArrayList<Sucursal>();
        setDatoEdicion(new ZonaGeneral());
        slclistDZonaGeneral = new ArrayList<DZonaGeneral>();
        listDZonaGeneral = new ArrayList<DZonaGeneral>();
        listlistDZonaGeneral = new ArrayList<ArrayList<DZonaGeneral>>();
        selectDZonaGeneral = new DZonaGeneral();
        listLeyenda = new ArrayList<Leyenda>();
        zonaGeneralDao = new ZonaGeneralDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        getSucursal();
        mensaje = null;
        escala = 50;
        slcZonaAlmacen = new ZonaAlmacen();
        listZonaAlmacen = new ArrayList<ZonaAlmacen>();
        listDAlmacenDiagrama = new ArrayList<DAlmacenDiagrama>();
        daoDAlmacenDiagrama = new DAlmacenDiagramaDAO();
        lstDZonaDiagram = new ArrayList<DZonaDiagrama>();
        dzonaDiagDao = new DZonaDiagramaDao();
        compList = new ArrayList<DZonaDiagramaUbicacion>();
        compDao = new DZonaDiagramaUbicacionDao();
        actualiza_ventana("wMnt_ZonaGeneral");

    }

    public void getSucursal() {
        try {
            listSucursal = (new SucursalDao()).findAll(user.getIDEMPRESA());
            RequestContext.getCurrentInstance().update("datos:cboSucursal");
        } catch (Exception ex) {
            this.setMensaje(ex.getMessage());
            WebUtil.MensajeError(mensaje);
        }
    }

    public void eventSucursal() {
        try {
            setListZona(zonaDao.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL()));
            RequestContext.getCurrentInstance().update("datos:listZona");
            //listSucursal= (new SucursalDao()).findAll(user.getIDEMPRESA());
        } catch (Exception ex) {
            this.setMensaje(ex.getMessage());
            WebUtil.MensajeError(mensaje);
        }
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            setListaDatos(zonaGeneralDao.findAll(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override/*copia del Constructor*/

    public String getIniciar() {
        oblist = new ArrayList<Integer>();
        slclistDZonaGeneral = new ArrayList<DZonaGeneral>();
        listDZonaGeneral = new ArrayList<DZonaGeneral>();
        listlistDZonaGeneral = new ArrayList<ArrayList<DZonaGeneral>>();
        listLeyenda = new ArrayList<Leyenda>();
        selectZonaGeneral = new ZonaGeneral();
        zonaGeneralDao = new ZonaGeneralDao();
        dzonaGeneralDao = new DZonaGeneralDao();
        selectZona = null;
        mensaje = null;
        slcZonaAlmacen = new ZonaAlmacen();
        listZonaAlmacen = new ArrayList<ZonaAlmacen>();
        listDAlmacenDiagrama = new ArrayList<DAlmacenDiagrama>();
        daoDAlmacenDiagrama = new DAlmacenDiagramaDAO();
        lstDZonaDiagram = new ArrayList<DZonaDiagrama>();
        dzonaDiagDao = new DZonaDiagramaDao();
        compList = new ArrayList<DZonaDiagramaUbicacion>();
        compDao = new DZonaDiagramaUbicacionDao();
        actualiza_ventana("wMnt_ZonaGeneral");
        return "";
    }

    @Override
    public void nuevo() {
        inciarMantenedor();
        setDatoEdicion(new ZonaGeneral());
        getDatoEdicion().setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setSUCURSAL(Constantes.IDSUCURSALGENERAL);
        getDatoEdicion().setAREA(0);
        getDatoEdicion().setANCHO(0);
        getDatoEdicion().setLARGO(0);
        getDatoEdicion().setESTADO(1);
        estadoDocumento = false;
    }

    @Override
    public void grabar() {
        try {
            listDZonaGeneral.clear();
            compList = compDao.genListaComparacion(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL());
            for (ArrayList<DZonaGeneral> ldz : listlistDZonaGeneral) {
                for (DZonaGeneral dz : ldz) {
                    if (dz.isSELECCIONADO()) {
                        boolean bl = true;
                        for (DZonaDiagramaUbicacion dzg : compList) {
                            if (dz.getIDEMPRESA() == dzg.getIDEMPRESA() && dz.getIDSUCURSAL() == dzg.getIDSUCURSAL() && dz.getIDZONA() == dzg.getIDZONA() && dz.getDCORDENADAX() == dzg.getCORDENADAX() && dz.getDCORDENADAY() == dzg.getCORDENADAY()) {
                                DZonaGeneral ndz = new DZonaGeneral();
                                ndz.setIDEMPRESA(dz.getIDEMPRESA());
                                ndz.setIDSUCURSAL(dz.getIDSUCURSAL());
                                ndz.setIDZONAGENERAL(getDatoEdicion().getIDZONAGENERAL());
                                ndz.setIDZONA(dz.getIDZONA());
                                ndz.setCORDENADAX(dz.getCORDENADAX());
                                ndz.setCORDENADAY(dz.getCORDENADAY());
                                ndz.setDCORDENADAX(dz.getDCORDENADAX());
                                ndz.setDCORDENADAY(dz.getDCORDENADAY());
                                ndz.setCOLOR(dz.getCOLOR());
                                if (!dz.getCOLOR().equalsIgnoreCase("#000000")) {
                                    ndz.setIDUBICACION(dzg.getIDUBICACION());
                                }
                                ndz.setPUERTA(dz.getPUERTA());
                                listDZonaGeneral.add(ndz);
                                bl = false;
                            }
                        }
                        if (bl) {
                            listDZonaGeneral.add(dz);
                        }
                    } else {
                        listDZonaGeneral.add(dz);
                    }
                }
            }
            if (getDatoEdicion().getIDZONAGENERAL() == 0) {
                int IDZONAGENRAL = Integer.parseInt(zonaGeneralDao.addZonaGeneral(getDatoEdicion()));

                dzonaGeneralDao.addXmlDZonaGeneral(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), IDZONAGENRAL, listDZonaGeneral);
            } else {
                int IDZONAGENRAL = Integer.parseInt(zonaGeneralDao.editZonaGeneral(getDatoEdicion()));
//              Integer idregla = zonaGeneraservice.insertaZonaGenera(2, mensaje, Integer.parseInt(user.getIDEMPRESA()), null);
                dzonaGeneralDao.addXmlDZonaGeneral(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONAGENERAL(), listDZonaGeneral);
//                zonaGeneraservice.insertaDzonaGenera(2, mensaje, Integer.parseInt(user.getIDEMPRESA()), getDatoEdicion().getIdregla());
            }
        } catch (Exception ex) {
            Logger.getLogger(ZonaGeneralAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eventoZona() throws Exception {
        if (selectZona.getIDTIPOZONA() == 1) {
            listZonaAlmacen = daoDAlmacenDiagrama.findZonaAlmacen(selectZona.getIDEMPRESA(), selectZona.getIDSUCURSAL());
            RequestContext.getCurrentInstance().update("datos:dlg_dzonaalm");
            RequestContext.getCurrentInstance().execute("PF('dlg_dzonaalm').show()");
        } else {
            lstDZonaDiagram = dzonaDiagDao.findAll(selectZona.getIDEMPRESA(), selectZona.getIDSUCURSAL(), selectZona.getIDZONA());
        }
//        int pos = listZona.indexOf(selectZona);
//        selectZona.setPICKED(true);
//        getListZona().set(pos, selectZona);
//        RequestContext.getCurrentInstance().update("datos:listZona");
    }

    public void eventoDalmcen() throws Exception {
        listDAlmacenDiagrama = daoDAlmacenDiagrama.findAll(slcZonaAlmacen.getIDEMPRESA(), slcZonaAlmacen.getIDSUCURSAL(), slcZonaAlmacen.getIDALMACEN());
        RequestContext.getCurrentInstance().execute("PF('dlg_dzonaalm').hide()");
    }

    public void eventoDeshabilitar() {
        selectZona = null;
        RequestContext.getCurrentInstance().update("datos:listZona");
//        int pos = listZona.indexOf(selectZona);
//        selectZona.setPICKED(true);
//        getListZona().set(pos, selectZona);
//        RequestContext.getCurrentInstance().update("datos:listZona");
    }

    public void newDZonaCodigo() {
        DZonaGeneral dr = new DZonaGeneral();
        dr.setIDEMPRESA(selectZonaGeneral.getIDEMPRESA());
        dr.setIDSUCURSAL(selectZonaGeneral.getIDSUCURSAL());
        dr.setIDZONAGENERAL(selectZonaGeneral.getIDZONAGENERAL());
        listDZonaGeneral.add(dr);
    }

    public void delDZonaCodigo() {
        listDZonaGeneral.remove(selectDZonaGeneral);
    }

    public void inciarMantenedor() {
        listZona = new ArrayList<Zona>();
        listSucursal = new ArrayList<Sucursal>();
        setDatoEdicion(new ZonaGeneral());
        listDZonaGeneral = new ArrayList<DZonaGeneral>();
        selectDZonaGeneral = new DZonaGeneral();
        listLeyenda = new ArrayList<Leyenda>();
        getSucursal();
    }

    public void dZonaGenera() throws Exception {
        try {
            if (getLadd() == 1) {
                generarDZonageneral();
            } else {
                listDZonaGeneral = dzonaGeneralDao.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONAGENERAL());
                if (listDZonaGeneral.isEmpty()) {
                    generarDZonageneral();
                } else {
                    generarDZonageneralBase();
                    listLeyenda = (new DAlmacenDiagramaDAO()).findLeyenda(2, getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), "", getDatoEdicion().getIDZONAGENERAL());
                    RequestContext.getCurrentInstance().update("datos:leyenda");
                }
            }
            Collections.sort(listLeyenda, (p1, p2) -> p1.getNUM() - p2.getNUM());
            setListZona(zonaDao.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL()));
        } catch (Exception ex) {
            setMensaje(ex.getMessage());
            WebUtil.MensajeError(mensaje);
        }
    }

    public void genArea() {
        getDatoEdicion().setAREA(getDatoEdicion().getANCHO() * getDatoEdicion().getLARGO());
    }

    public void upExcel(FileUploadEvent event) throws ParseException {
        try {
            if (getDatoEdicion().getANCHO() != 0 && getDatoEdicion().getLARGO() != 0) {
                ListO = new ArrayList<DiagExcel>();
                upFile = event.getFile();
                XSSFWorkbook workBook = new XSSFWorkbook(upFile.getInputstream());
                XSSFSheet hssfSheet = workBook.getSheetAt(0);
                Iterator<Row> rowIterator = hssfSheet.rowIterator();
                List<Double> maxX = new ArrayList<Double>();
                List<Double> maxY = new ArrayList<Double>();
                boolean firstLinea = true;
                boolean terminado = false;
                while (rowIterator.hasNext()) {
                    Row hssfRow = rowIterator.next();
                    if (firstLinea) {
                        firstLinea = false;
                    } else {
                        DiagExcel O = new DiagExcel();
                        hssfRow.getCell(0).setCellType(XSSFCell.CELL_TYPE_STRING);//Color
                        hssfRow.getCell(1).setCellType(XSSFCell.CELL_TYPE_STRING);//Layer
                        hssfRow.getCell(2).setCellType(XSSFCell.CELL_TYPE_STRING);//Position X
                        hssfRow.getCell(3).setCellType(XSSFCell.CELL_TYPE_STRING);//Position Y
                        hssfRow.getCell(4).setCellType(XSSFCell.CELL_TYPE_STRING);//Value
                        hssfRow.getCell(5).setCellType(XSSFCell.CELL_TYPE_STRING);//Zona
                        hssfRow.getCell(6).setCellType(XSSFCell.CELL_TYPE_STRING);//Tipo
                        hssfRow.getCell(7).setCellType(XSSFCell.CELL_TYPE_STRING);//Proceso
                        hssfRow.getCell(8).setCellType(XSSFCell.CELL_TYPE_STRING);//nX
                        hssfRow.getCell(9).setCellType(XSSFCell.CELL_TYPE_STRING);//nY
                        hssfRow.getCell(10).setCellType(XSSFCell.CELL_TYPE_STRING);//Punto
                        hssfRow.getCell(11).setCellType(XSSFCell.CELL_TYPE_STRING);//Piso
                        hssfRow.getCell(12).setCellType(XSSFCell.CELL_TYPE_STRING);//TipoZona
                        O.setColor((String) hssfRow.getCell(0).getStringCellValue());
                        O.setLayer((String) hssfRow.getCell(1).getStringCellValue());
                        O.setPositionX(Double.parseDouble(hssfRow.getCell(2).getStringCellValue()));
                        O.setPositionY(Double.parseDouble(hssfRow.getCell(3).getStringCellValue()));
                        O.setValue(Double.parseDouble(hssfRow.getCell(4).getStringCellValue()));
                        O.setZona((String) hssfRow.getCell(5).getStringCellValue());
                        O.setTipo((String) hssfRow.getCell(6).getStringCellValue());
                        O.setProceso((String) hssfRow.getCell(7).getStringCellValue());
                        O.setnX(Double.parseDouble(hssfRow.getCell(8).getStringCellValue()));
                        O.setnY(Double.parseDouble(hssfRow.getCell(9).getStringCellValue()));
                        O.setPunto((String) hssfRow.getCell(10).getStringCellValue());
                        if (!hssfRow.getCell(11).getStringCellValue().equalsIgnoreCase("")) {
                            O.setPisos(Integer.parseInt(hssfRow.getCell(11).getStringCellValue()));
                        }
                        O.setTipoZona(Integer.parseInt(hssfRow.getCell(12).getStringCellValue()));
                        O.setChecked(false);
                        ListO.add(O);
                    }
                }

                NuevoDDistribucionUbicacion();
                generaZonas();
                genDiagZonas();
                graZonaGen();
                System.out.println("list");
            } else {
                WebUtil.MensajeAdvertencia("Largo o Ancho Son Cero");
            }

        } catch (IOException e) {
            System.out.println("Error en el Procesamiento : " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Error en el Procesamiento : " + ex.getMessage());
        }
    }

    public void NuevoDDistribucionUbicacion() {
        try {
            List<Almacen> listAlmacen = (new AlmacenDao()).findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL());
            Constantes.estadoDocumento = 1;
            almDist = new HashMap<String, String>();
            for (Almacen l : listAlmacen) {
                DDistribucionUbicacion newDDistribucionUbicacion = new DDistribucionUbicacion();
                newDDistribucionUbicacion.setIDEMPRESA(String.valueOf(getDatoEdicion().getIDEMPRESA()));
                newDDistribucionUbicacion.setIDSUCURSAL(String.valueOf(getDatoEdicion().getIDSUCURSAL()));
                newDDistribucionUbicacion.setIDALMACEN(l.getIDALMACEN());
                newDDistribucionUbicacion.setESTADO(true);
                newDDistribucionUbicacion.setFECHAINICIO(WebUtil.fechaDMY(new Date(), 1));
                almDist.put(l.getIDALMACEN(), (new DDistribucionUbicacionDao()).addDDistribucionUbicacion(newDDistribucionUbicacion));
            }
            Map<String, List<DiagExcel>> AlmacenList = new HashMap<String, List<DiagExcel>>();
            AlmacenList = ListO.stream().collect(Collectors.groupingBy(DiagExcel::getZona));
            Iterator i = AlmacenList.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry pair = (Map.Entry) i.next();
                String key = (String) pair.getKey();
                ArrayList<DiagExcel> genList = (ArrayList) pair.getValue();
                if (!key.equalsIgnoreCase("0") && genList.get(0).getTipoZona() == 1) {
                    Double fx = 0.00;
                    Double fy = 0.00;
                    for (DiagExcel ip : genList) {
                        if (ip.getPunto().equalsIgnoreCase("pi")) {
                            Double ix = ip.getnX();
                            Double iy = ip.getnY();
                            for (DiagExcel fp : genList) {
                                if (fp.getPunto().equalsIgnoreCase("pf") && !fp.isChecked()) {
                                    fx = fp.getnX();
                                    fy = fp.getnY();
                                    fp.setChecked(true);
                                    break;
                                }
                            }
                            ip.setFilas((fy.intValue() - iy.intValue()) + 1); //MODIFICAR JAR
                            ip.setColumnas((fx.intValue() - ix.intValue()) + 1);
                        }
                    }
                    String iddist = almDist.get(key);
                    Map<String, List<DiagExcel>> rackList = new HashMap<String, List<DiagExcel>>();
                    rackList = genList.stream().collect(Collectors.groupingBy(DiagExcel::getTipo));
                    Iterator r = rackList.entrySet().iterator();
                    int b1 = 1;
                    List<DAlmacen_Racks> listDAlmacen_Racks = new ArrayList<DAlmacen_Racks>();
                    String idalm = "";
                    List<DAlmacen_Pisos> listDAlmacen_Pisos = new ArrayList<DAlmacen_Pisos>();
                    List<DAlmacen_Filas> listDAlmacen_Filas = new ArrayList<DAlmacen_Filas>();
                    List<DAlmacen_Columnas> listDAlmacen_Columnas = new ArrayList<DAlmacen_Columnas>();
                    while (r.hasNext()) {
                        Map.Entry rpair = (Map.Entry) r.next();
                        String rkey = (String) rpair.getKey();
                        ArrayList<DiagExcel> t = (ArrayList) rpair.getValue();
                        for (DiagExcel ini : t) {
                            if (ini.getPunto().equalsIgnoreCase("pi")) {
                                DAlmacen_Racks racks = new DAlmacen_Racks();
                                racks.setIDEMPRESA(String.valueOf(getDatoEdicion().getIDEMPRESA()));
                                racks.setIDSUCURSAL(String.valueOf(getDatoEdicion().getIDSUCURSAL()));
                                racks.setIDALMACEN(ini.getZona());
                                idalm = ini.getZona();
                                racks.setIDDISTRIBUCION(iddist);
                                racks.setIDTIPORACK((rkey.equalsIgnoreCase("Calle") ? 2 : 1));
                                racks.setIDRACK(WebUtil.idGeneradoTres(b1));
                                racks.setIDUBICACION(WebUtil.ubicacionGeneracionRacks(WebUtil.idGeneradoTres(b1), ini.getZona(), String.valueOf(getDatoEdicion().getIDSUCURSAL())));
                                racks.setESTADO(1);
                                racks.setPicked(true);
                                listDAlmacen_Racks.add(racks);
                                for (int p = 1; p <= ini.getPisos(); p++) {
                                    DAlmacen_Pisos pisos = new DAlmacen_Pisos();
                                    pisos.setIDEMPRESA(String.valueOf(getDatoEdicion().getIDEMPRESA()));
                                    pisos.setIDSUCURSAL(String.valueOf(getDatoEdicion().getIDSUCURSAL()));
                                    pisos.setIDALMACEN(ini.getZona());
                                    pisos.setIDDISTRIBUCION(iddist);
                                    pisos.setIDRACK(WebUtil.idGeneradoTres(b1));
                                    pisos.setIDPISO(WebUtil.idGeneradoTres(p));
                                    pisos.setESTADO(1);
                                    pisos.setIDUBICACION(WebUtil.ubicacionGeneracionPisos(WebUtil.idGeneradoTres(p), WebUtil.idGeneradoTres(b1), racks.getIDALMACEN(), String.valueOf(getDatoEdicion().getIDSUCURSAL())));
                                    listDAlmacen_Pisos.add(pisos);
                                    for (int inif = 1; inif <= ini.getFilas(); inif++) {
                                        DAlmacen_Filas filas = new DAlmacen_Filas();
                                        filas.setIDEMPRESA(String.valueOf(getDatoEdicion().getIDEMPRESA()));
                                        filas.setIDSUCURSAL(String.valueOf(getDatoEdicion().getIDSUCURSAL()));
                                        filas.setIDALMACEN(idalm);
                                        filas.setIDDISTRIBUCION(iddist);
                                        filas.setIDRACK(WebUtil.idGeneradoTres(b1));
                                        filas.setIDPISO(WebUtil.idGeneradoTres(p));
                                        filas.setIDFILA(WebUtil.idGeneradoTres(inif));
                                        filas.setESTADO(1);
                                        filas.setIDUBICACION(WebUtil.ubicacionGeneracionFilas(WebUtil.idGeneradoTres(inif), WebUtil.idGeneradoTres(p), WebUtil.idGeneradoTres(b1), racks.getIDALMACEN(), String.valueOf(getDatoEdicion().getIDSUCURSAL())));
                                        listDAlmacen_Filas.add(filas);
                                        for (int inic = 1; inic <= ini.getColumnas(); inic++) {
                                            DAlmacen_Columnas columnas = new DAlmacen_Columnas();
                                            columnas.setIDEMPRESA(String.valueOf(getDatoEdicion().getIDEMPRESA()));
                                            columnas.setIDSUCURSAL(String.valueOf(getDatoEdicion().getIDSUCURSAL()));
                                            columnas.setIDALMACEN(idalm);
                                            columnas.setIDDISTRIBUCION(iddist);
                                            columnas.setIDRACK(WebUtil.idGeneradoTres(b1));
                                            columnas.setIDPISO(WebUtil.idGeneradoTres(p));
                                            columnas.setIDFILA(WebUtil.idGeneradoTres(inif));
                                            columnas.setIDCOLUMNA(WebUtil.idGeneradoTres(inic));
                                            columnas.setESTADO(1);
                                            columnas.setIDUBICACION(WebUtil.ubicacionGeneracionColumnas(WebUtil.idGeneradoTres(inic), WebUtil.idGeneradoTres(inif), WebUtil.idGeneradoTres(p), WebUtil.idGeneradoTres(b1), racks.getIDALMACEN(), String.valueOf(getDatoEdicion().getIDSUCURSAL())));
                                            listDAlmacen_Columnas.add(columnas);
                                        }
                                    }
                                }
                                b1++;
                            }
                        }
                    }
                    (new DAlmacen_RacksDao()).addDRackXML(String.valueOf(getDatoEdicion().getIDEMPRESA()), String.valueOf(getDatoEdicion().getIDSUCURSAL()), idalm, iddist, cadenaRackXml(listDAlmacen_Racks));
                    (new DAlmacen_PisosDao()).addDPisoXML(String.valueOf(getDatoEdicion().getIDEMPRESA()), String.valueOf(getDatoEdicion().getIDSUCURSAL()), idalm, iddist, "", cadenaPisoXml(listDAlmacen_Pisos));
                    (new DAlmacen_FilasDao()).addDFilaXML(String.valueOf(getDatoEdicion().getIDEMPRESA()), String.valueOf(getDatoEdicion().getIDSUCURSAL()), idalm, iddist, "", "", cadenaFilaXml(listDAlmacen_Filas));
                    (new DAlmacen_ColumnasDao()).addXmlDAlmacen_Columnas(String.valueOf(getDatoEdicion().getIDEMPRESA()), String.valueOf(getDatoEdicion().getIDSUCURSAL()), idalm, iddist, "", "", "", cadenaColumnasXml(listDAlmacen_Columnas));
                }
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public void generaZonas() {
        Map<String, List<DiagExcel>> AlmacenList = new HashMap<String, List<DiagExcel>>();
        AlmacenList = ListO.stream().collect(Collectors.groupingBy(DiagExcel::getZona));
        Iterator i = AlmacenList.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry pair = (Map.Entry) i.next();
            String key = (String) pair.getKey();
            ArrayList<DiagExcel> genList = (ArrayList) pair.getValue();
            if (!key.equalsIgnoreCase("0")) {
                try {
                    List<TablaAlmacen> tablaAlmacen = new ArrayList<TablaAlmacen>();
                    List<DZonaAccesorio> listDZonaAccesorio = new ArrayList<DZonaAccesorio>();
                    int ix = genList.get(0).getnX().intValue();
                    int fx = genList.get(genList.size() - 1).getnX().intValue();
                    int iy = genList.get(0).getnY().intValue();
                    int fy = genList.get(genList.size() - 1).getnY().intValue();
                    int Largo = (fx - ix) + 1;
                    int Ancho = (fy - iy) + 1;
                    int Area = Largo * Ancho;
                    Zona zona = new Zona();
                    zona.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                    zona.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                    zona.setDESCRIPCION(genList.get(0).getLayer());
                    zona.setUNIDADMEDIDA("1");
                    zona.setIDZONA(Integer.parseInt(genList.get(0).getZona()));
                    zona.setIDTIPOZONA(genList.get(0).getTipoZona());
                    zona.setIDPROCESO(Integer.valueOf(genList.get(0).getProceso()));
                    zona.setANCHOUNIDADDIAGRAMA(Ancho);
                    zona.setLARGOUNIDADDIAGRAMA(Largo);
                    zona.setAREA(Area);
                    zona.setESTADO(true);
                    zona.setAREAUNIDADDIAGRAMA(Area);
                    TablaAlmacen t = new TablaAlmacen();
                    DZonaAccesorio acc = new DZonaAccesorio();
                    if (genList.get(0).getTipoZona() == 1) {
                        t.setIdempresa(getDatoEdicion().getIDEMPRESA());
                        t.setIdsucursal(getDatoEdicion().getIDSUCURSAL());
                        t.setIdalmacen(genList.get(0).getZona());
                        tablaAlmacen.add(t);
                    } else if (genList.get(0).getTipoZona() == 2) {
                        for (DiagExcel d : genList) {
                            acc = new DZonaAccesorio();
                            acc.setDESCRIPCION(d.getTipo());
                            acc.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                            acc.setIDTIPOACCESORIO(1);
                            acc.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                            acc.setIDZONA(Integer.parseInt(genList.get(0).getZona()));
                            acc.setIDACCESORIO(listDZonaAccesorio.size() + 1);
                            acc.setESTADO(true);
                            listDZonaAccesorio.add(acc);
                        }
                    }

                    (new ZonaDao()).addZonaDetalle(zona, tablaAlmacen, listDZonaAccesorio);

                } catch (Exception ex) {
                    Logger.getLogger(ZonaGeneralAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void genDiagZonas() {
        try {
            Map<String, List<DiagExcel>> AlmacenList = new HashMap<String, List<DiagExcel>>();
            AlmacenList = ListO.stream().collect(Collectors.groupingBy(DiagExcel::getZona));
            Iterator i = AlmacenList.entrySet().iterator();
            while (i.hasNext()) {
                List<DAlmacenDiagrama> listDAlmacenDiagrama = new ArrayList<DAlmacenDiagrama>();//Almacen Zona
                List<DZonaDiagrama> lstDZonaDiagram = new ArrayList<DZonaDiagrama>(); //Zona
                Map.Entry pair = (Map.Entry) i.next();
                String key = (String) pair.getKey();
                ArrayList<DiagExcel> genList = (ArrayList) pair.getValue();
                if (!key.equalsIgnoreCase("0") && !key.equalsIgnoreCase("10")) {

                    int ix = genList.get(0).getnX().intValue();
                    int fx = genList.get(genList.size() - 1).getnX().intValue();
                    int iy = genList.get(0).getnY().intValue();
                    int fy = genList.get(genList.size() - 1).getnY().intValue();
                    int Largo = (fx - ix) + 1;
                    int Ancho = (fy - iy) + 1;
                    List<DAlmacen_Racks> listaRacks = (new DAlmacen_ColumnasDao()).findAllRacksPisosFilasColumnasTotal(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), key, "", "", "");
                    List<DZonaAccesorio> lstDZonaAcc = (new DZonaAccesorioDao()).findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), key);
                    int k = 0;
                    for (int y = 0; y < Ancho; y++) {
                        for (int x = 0; x < Largo; x++) {
                            if (genList.get(0).getTipoZona() == 1) {
                                DAlmacenDiagrama variableDAlmacenDiagrama = new DAlmacenDiagrama();
                                variableDAlmacenDiagrama.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                                variableDAlmacenDiagrama.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                                variableDAlmacenDiagrama.setIDALMACEN(Integer.valueOf(key));
                                variableDAlmacenDiagrama.setIDDISTRIBUCION("");
                                variableDAlmacenDiagrama.setCORDENADAX(x);
                                variableDAlmacenDiagrama.setCORDENADAY(y);
                                variableDAlmacenDiagrama.setIDRACK(null);
                                variableDAlmacenDiagrama.setCOLORHEXADECIMAL("#ffffff");
                                variableDAlmacenDiagrama.setESTADO(1);
                                variableDAlmacenDiagrama.setSINCRONIZA(1);
                                variableDAlmacenDiagrama.setBIGVALUE(genList.get(((Largo * y) + x)).getValue().intValue());
                                listDAlmacenDiagrama.add(variableDAlmacenDiagrama);
                            } else {
                                DZonaDiagrama variableDZonaDiagrama = new DZonaDiagrama();
                                variableDZonaDiagrama.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                                variableDZonaDiagrama.setIDZONA(Integer.parseInt(key));
                                variableDZonaDiagrama.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                                variableDZonaDiagrama.setIDACCESORIO(lstDZonaAcc.get(k).getIDACCESORIO());
                                variableDZonaDiagrama.setCORDENADAX(x);
                                variableDZonaDiagrama.setCORDENADAY(y);
                                variableDZonaDiagrama.setESTADO(1);
                                variableDZonaDiagrama.setCOLOR("#ff0000");
                                lstDZonaDiagram.add(variableDZonaDiagrama);
                                k++;
                            }
                        }
                    }
                    if (genList.get(0).getTipoZona() == 1) {
                        int band = 0;
                        Map<String, List<DiagExcel>> rackList = new HashMap<String, List<DiagExcel>>();
                        rackList = genList.stream().collect(Collectors.groupingBy(DiagExcel::getTipo));
                        int h = 0;
                        Iterator r = rackList.entrySet().iterator();
                        while (r.hasNext()) {
                            Map.Entry rpair = (Map.Entry) r.next();
                            String rkey = (String) rpair.getKey();
                            ArrayList<DiagExcel> t = (ArrayList) rpair.getValue();

                            for (DiagExcel ini : t) {
                                if (ini.getPunto().equalsIgnoreCase("pi")) {
                                    int pos = 0;
                                    for (DAlmacenDiagrama da : listDAlmacenDiagrama) {
                                        if (ini.getValue() == da.getBIGVALUE()) {
                                            pos = listDAlmacenDiagrama.indexOf(da);
                                        }
                                    }
                                    int bandera;
                                    for (int y = 0; y < listaRacks.get(h).getFILAS(); y++) {
                                        for (int x = 0; x < listaRacks.get(h).getCOLUMNAS(); x++) {
                                            bandera = (Largo * y) + x + pos;
                                            listDAlmacenDiagrama.get(bandera).setESTADO(1);
                                            listDAlmacenDiagrama.get(bandera).setCOLORHEXADECIMAL(ini.getTipo().equalsIgnoreCase("Calle") ? "#0000FF" : "#ff0000");
                                            listDAlmacenDiagrama.get(bandera).setIDDISTRIBUCION(listaRacks.get(h).getIDDISTRIBUCION());
                                            listDAlmacenDiagrama.get(bandera).setIDRACK(listaRacks.get(h).getIDRACK());
                                        }
                                    }
                                    h++;
                                }
                            }
                            String Inicio = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
                            XStream xStream_rack = new XStream();
                            xStream_rack = new XStream();
                            xStream_rack.processAnnotations(DAlmacenDiagrama.class);
                            String xmlDet = Inicio.concat(xStream_rack.toXML(listDAlmacenDiagrama));
                            List<DZonaDiagrama> lstDZonaDiagram2 = new ArrayList<DZonaDiagrama>();
                            for (DAlmacenDiagrama da : listDAlmacenDiagrama) {
                                DZonaDiagrama dz = new DZonaDiagrama();
                                dz.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                                dz.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                                dz.setIDZONA(Integer.parseInt(key));
                                dz.setIDALMACEN(da.getIDALMACEN());
                                dz.setIDDISTRIBUCION(da.getIDDISTRIBUCION());
                                dz.setCORDENADAX(da.getCORDENADAX());
                                dz.setCORDENADAY(da.getCORDENADAY());
                                dz.setIDACCESORIO(null);
                                dz.setESTADO(da.getESTADO());
                                dz.setCOLOR(da.getCOLORHEXADECIMAL());
                                lstDZonaDiagram2.add(dz);
                            }
                            xStream_rack = new XStream();
                            xStream_rack.processAnnotations(DZonaDiagrama.class);
                            String xmlDZ = Inicio.concat(xStream_rack.toXML(lstDZonaDiagram2));
                            daoDAlmacenDiagrama.addXmlDZonaDiagrama(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), Integer.parseInt(key), xmlDet);
                            daoDAlmacenDiagrama.generarUbicacion(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), Integer.parseInt(key), Integer.parseInt(key));
                            dzonaDiagDao.addXmlDZonaDiagrama2(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), Integer.parseInt(key), Integer.parseInt(key), xmlDZ);
                            dzonaDiagDao.reflejarDzonageneral(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), Integer.parseInt(key), Integer.parseInt(key));
                        }
                    } else {
                        String td = null;
                        String Inicio = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
                        XStream xStream_rack = new XStream();
                        xStream_rack = new XStream();
                        xStream_rack.processAnnotations(DZonaDiagrama.class);
                        String xmlDet = Inicio.concat(xStream_rack.toXML(lstDZonaDiagram));
                        td = xmlDet;
                        try {
                            dzonaDiagDao.addXmlDZonaDiagrama(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), Integer.parseInt(key), xmlDet);
                            duplicar(Integer.parseInt(key),lstDZonaDiagram);
                        } catch (Exception ex) {
                            System.out.print(ex.toString());
                        }
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void graZonaGen() {
        try {
            listDZonaGeneral = new ArrayList<DZonaGeneral>();
            listlistDZonaGeneral = new ArrayList<ArrayList<DZonaGeneral>>();
            listLeyenda = new ArrayList<Leyenda>();
            DZonaGeneral dzonageneral;
            oblist.clear();
//        listDZonaGeneral.clear();
//        listlistDZonaGeneral.clear();
            for (int i = 0; i < getDatoEdicion().getLARGO(); i++) {
                oblist.add(i);
            }
            for (int j = 0; j < getDatoEdicion().getANCHO(); j++) {
                ArrayList<DZonaGeneral> tdsg = new ArrayList<DZonaGeneral>();
                for (int i = 0; i < getDatoEdicion().getLARGO(); i++) {
                    dzonageneral = new DZonaGeneral();
                    dzonageneral.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                    dzonageneral.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                    dzonageneral.setIDZONAGENERAL(getDatoEdicion().getIDZONAGENERAL());
                    dzonageneral.setSELECCIONADO(false);
                    dzonageneral.setCORDENADAX(i);
                    dzonageneral.setCORDENADAY(j);
                    dzonageneral.setDCORDENADAX(null);
                    dzonageneral.setDCORDENADAY(null);
                    dzonageneral.setPUERTA(0);
                    dzonageneral.setCOLOR("#FFFFFF");
                    tdsg.add(dzonageneral);
                }
                listlistDZonaGeneral.add(tdsg);
            }
            setListZona(zonaDao.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL()));
            Map<String, List<DiagExcel>> AlmacenList = new HashMap<String, List<DiagExcel>>();
            AlmacenList = ListO.stream().collect(Collectors.groupingBy(DiagExcel::getZona));
            for (Zona z : listZona) {
                List<DiagExcel> genList = AlmacenList.get(String.valueOf(z.getIDZONA()));
                DiagExcel pi = genList.get(0);
                int ix = genList.get(0).getnX().intValue();
                int fx = genList.get(genList.size() - 1).getnX().intValue();
                int iy = genList.get(0).getnY().intValue();
                int fy = genList.get(genList.size() - 1).getnY().intValue();
                if (z.getIDZONA() != 10) {
                    if (z.getIDTIPOZONA() == 1) {

                        listZonaAlmacen = daoDAlmacenDiagrama.findZonaAlmacen(z.getIDEMPRESA(), z.getIDSUCURSAL());
                        ZonaAlmacen slc = listZonaAlmacen.stream().filter((za) -> za.getIDZONA() == z.getIDZONA()).findAny().get();
                        listDAlmacenDiagrama = daoDAlmacenDiagrama.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), slc.getIDALMACEN());
                        int it = 0;
                        for (int c = iy; c <= fy; c++) {
                            for (int d = ix; d <= fx; d++) {
                                selectDZonaGeneral = listlistDZonaGeneral.get(c).get(d);
                                selectDZonaGeneral.setIDEMPRESA(listDAlmacenDiagrama.get(it).getIDEMPRESA());
                                selectDZonaGeneral.setIDSUCURSAL(listDAlmacenDiagrama.get(it).getIDSUCURSAL());
                                selectDZonaGeneral.setIDZONA(slc.getIDZONA());
                                selectDZonaGeneral.setCORDENADAX(d);
                                selectDZonaGeneral.setCORDENADAY(c);
                                selectDZonaGeneral.setDCORDENADAX(listDAlmacenDiagrama.get(it).getCORDENADAX());
                                selectDZonaGeneral.setDCORDENADAY(listDAlmacenDiagrama.get(it).getCORDENADAY());
                                if (!listDAlmacenDiagrama.get(it).getIDDISTRIBUCION().trim().equalsIgnoreCase("")) {
                                    selectDZonaGeneral.setSELECCIONADO(true);
                                } else {
                                    selectDZonaGeneral.setSELECCIONADO(false);
                                }
                                selectDZonaGeneral.setCOLOR(listDAlmacenDiagrama.get(it).getCOLORHEXADECIMAL());
                                listlistDZonaGeneral.get(c).set(d, selectDZonaGeneral);
                                it++;
                            }
                        }
                    } else {
                        int it = 0;
                        lstDZonaDiagram = dzonaDiagDao.findAll(z.getIDEMPRESA(), z.getIDSUCURSAL(), z.getIDZONA());
                        for (int c = iy; c <= fy; c++) {
                            for (int d = ix; d <= fx; d++) {
                                selectDZonaGeneral = listlistDZonaGeneral.get(c).get(d);
                                selectDZonaGeneral.setIDEMPRESA(lstDZonaDiagram.get(it).getIDEMPRESA());
                                selectDZonaGeneral.setIDSUCURSAL(lstDZonaDiagram.get(it).getIDSUCURSAL());
                                selectDZonaGeneral.setIDZONA(lstDZonaDiagram.get(it).getIDZONA());
                                selectDZonaGeneral.setCORDENADAX(d);
                                selectDZonaGeneral.setCORDENADAY(c);
                                selectDZonaGeneral.setDCORDENADAX(lstDZonaDiagram.get(it).getCORDENADAX());
                                selectDZonaGeneral.setDCORDENADAY(lstDZonaDiagram.get(it).getCORDENADAY());
                                if (!lstDZonaDiagram.get(it).getCOLOR().trim().equalsIgnoreCase("#FFFFFF")) {
                                    selectDZonaGeneral.setSELECCIONADO(true);
                                } else {
                                    selectDZonaGeneral.setSELECCIONADO(false);
                                }

                                selectDZonaGeneral.setCOLOR(lstDZonaDiagram.get(it).getCOLOR());
                                listlistDZonaGeneral.get(c).set(d, selectDZonaGeneral);
                                it++;
                            }
                        }
                    }
                }
            }
            RequestContext.getCurrentInstance().update("datos:leyenda");
            RequestContext.getCurrentInstance().update("datos:tblDetalle");
            RequestContext.getCurrentInstance().update("datos:listZona");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String cerosIzquierda(Object e1, int cantidad) {
        return WebUtil.cerosIzquierda(e1.toString(), cantidad);
    }

    public  void duplicar(int idzona,List<DZonaDiagrama> lstDZonaDiagram) throws Exception {
        List<DZonaDiagramaUbicacion> lstDzonaDiaUbicacion = new ArrayList<DZonaDiagramaUbicacion>();
        for (DZonaDiagrama dz : lstDZonaDiagram) {
            DZonaDiagramaUbicacion d = new DZonaDiagramaUbicacion();
            d.setIDEMPRESA(dz.getIDEMPRESA());
            d.setIDSUCURSAL(dz.getIDSUCURSAL());
            d.setIDZONA(dz.getIDZONA());
            String acc = "N";
            if (dz.getIDACCESORIO() != null) {
                acc = "A" + cerosIzquierda(dz.getIDACCESORIO(), 3);
                d.setIDACCESORIO(dz.getIDACCESORIO().toString());
            }
            String idu = "S" + cerosIzquierda(dz.getIDSUCURSAL(), 3) + "Z" + cerosIzquierda(dz.getIDZONA(), 3) + acc + "X" + cerosIzquierda(dz.getCORDENADAX(), 3) + "Y" + cerosIzquierda(dz.getCORDENADAY(), 3);
            d.setIDUBICACION(idu);
            if (d.getIDALMACEN() != null) {
                d.setIDALMACEN(dz.getIDALMACEN().toString());
            }
            d.setCORDENADAX(dz.getCORDENADAX());
            d.setCORDENADAY(dz.getCORDENADAY());
            d.setCOLOR(dz.getCOLOR());
            lstDzonaDiaUbicacion.add(d);
        }
        String td = null;
        String Inicio = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_rack = new XStream();
        xStream_rack.processAnnotations(DZonaDiagramaUbicacion.class);
        String xmlUbi = Inicio.concat(xStream_rack.toXML(lstDzonaDiaUbicacion));
        dzonaDiagDao.addxmlDzonaDiagramaUbicacion(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), idzona, xmlUbi);
        dzonaDiagDao.reflejarDzonageneral(xmlUbi);
    }

    public String cadenaRackXml(List<DAlmacen_Racks> listDAlmacen_Racks) {
        System.out.println("RACK XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE RACK
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_rack = new XStream();
        xStream_rack.processAnnotations(DAlmacen_Racks.class);
        return xml + xStream_rack.toXML(listDAlmacen_Racks);
    }
//

    public String cadenaPisoXml(List<DAlmacen_Pisos> listDAlmacen_Pisos) {
        System.out.println("PISO XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE PISO
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_piso = new XStream();
        xStream_piso.processAnnotations(DAlmacen_Pisos.class);
        return xml + xStream_piso.toXML(listDAlmacen_Pisos);
    }
//

    public String cadenaFilaXml(List<DAlmacen_Filas> listDAlmacen_Filas) {
        System.out.println("FILA XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE RACK
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_fila = new XStream();
        xStream_fila.processAnnotations(DAlmacen_Filas.class);
        return xml + xStream_fila.toXML(listDAlmacen_Filas);
    }
//

    public String cadenaColumnasXml(List<DAlmacen_Columnas> listDAlmacen_Columnas) {
        System.out.println("COLUMNAS XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE RACK
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_columnas = new XStream();
        xStream_columnas.processAnnotations(DAlmacen_Columnas.class);
        return xml + xStream_columnas.toXML(listDAlmacen_Columnas);
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
            int IDZONAGENRAL = Integer.parseInt(zonaGeneralDao.addZonaGeneral(getDatoEdicion()));

        } catch (Exception ex) {
            Logger.getLogger(ZonaGeneralAction.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarDZonageneral() {
        DZonaGeneral dzonageneral;
        oblist.clear();
//        listDZonaGeneral.clear();
//        listlistDZonaGeneral.clear();
        for (int i = 0; i < getDatoEdicion().getLARGO(); i++) {
            oblist.add(i);
        }
        for (int j = 0; j < getDatoEdicion().getANCHO(); j++) {
            ArrayList<DZonaGeneral> tdsg = new ArrayList<DZonaGeneral>();
            for (int i = 0; i < getDatoEdicion().getLARGO(); i++) {
                dzonageneral = new DZonaGeneral();
                dzonageneral.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                dzonageneral.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                dzonageneral.setIDZONAGENERAL(getDatoEdicion().getIDZONAGENERAL());
                dzonageneral.setSELECCIONADO(false);
                dzonageneral.setCORDENADAX(i);
                dzonageneral.setCORDENADAY(j);
                dzonageneral.setDCORDENADAX(null);
                dzonageneral.setDCORDENADAY(null);
                dzonageneral.setPUERTA(0);
                dzonageneral.setCOLOR("#FFFFFF");
                tdsg.add(dzonageneral);
            }
            listlistDZonaGeneral.add(tdsg);
        }
//        RequestContext.getCurrentInstance().update("datos");
        RequestContext.getCurrentInstance().update("datos:tblDetalle");
        RequestContext.getCurrentInstance().update("datos:leyenda");
    }

    public void generarDZonageneralBase() {
        DZonaGeneral dzonageneral;
        for (int i = 0; i < getDatoEdicion().getLARGO(); i++) {
            oblist.add(i);
        }
        int k = 0;
        for (int j = 0; j < getDatoEdicion().getANCHO(); j++) {
            ArrayList<DZonaGeneral> tdsg = new ArrayList<DZonaGeneral>();
            for (int i = 0; i < getDatoEdicion().getLARGO(); i++) {
                dzonageneral = new DZonaGeneral();
                dzonageneral.setIDEMPRESA(listDZonaGeneral.get(k).getIDEMPRESA());
                dzonageneral.setIDSUCURSAL(listDZonaGeneral.get(k).getIDSUCURSAL());
                dzonageneral.setIDZONAGENERAL(listDZonaGeneral.get(k).getIDZONAGENERAL());
                dzonageneral.setIDZONA(listDZonaGeneral.get(k).getIDZONA());
                dzonageneral.setCORDENADAX(listDZonaGeneral.get(k).getCORDENADAX());
                dzonageneral.setCORDENADAY(listDZonaGeneral.get(k).getCORDENADAY());
                dzonageneral.setDCORDENADAX(listDZonaGeneral.get(k).getDCORDENADAX());
                dzonageneral.setDCORDENADAY(listDZonaGeneral.get(k).getDCORDENADAY());
                dzonageneral.setCOLOR(listDZonaGeneral.get(k).getCOLOR());
                dzonageneral.setPUERTA(listDZonaGeneral.get(k).getPUERTA());
                dzonageneral.setSINCRONIZA(listDZonaGeneral.get(k).getSINCRONIZA());
                if (dzonageneral.getIDZONA() == 0) {
                    dzonageneral.setSELECCIONADO(false);
                } else {
                    dzonageneral.setSELECCIONADO(true);
                }
                tdsg.add(dzonageneral);
                k++;
            }
            listlistDZonaGeneral.add(tdsg);
        }
//        RequestContext.getCurrentInstance().update("datos");
        RequestContext.getCurrentInstance().update("datos:tblDetalle");
        RequestContext.getCurrentInstance().update("datos:leyenda");
    }

    public void onSlideEnd(SlideEndEvent event) {
        RequestContext.getCurrentInstance().update("datos:listDZonaGeneral");
        RequestContext.getCurrentInstance().update("datos:listDZonaGeneral:boton");
    }

    public void buttonAction() {
        if (selectLeyenda != null) {
            this.color = selectLeyenda.getCOLOR().replace("#", "");
            RequestContext.getCurrentInstance().update("datos:colorPicker");
        }
    }

    public void getReset() {
        listDZonaGeneral = new ArrayList<DZonaGeneral>();
        listlistDZonaGeneral = new ArrayList<ArrayList<DZonaGeneral>>();
        listLeyenda = new ArrayList<Leyenda>();
        generarDZonageneral();
    }

    public void ubicacionSeleccionado(int roxI, int colI) {
        try {

            int pos = listDZonaGeneral.indexOf(selectDZonaGeneral);
            if (selectZona == null) {
                /*ACCIÓN DE SELECCIÓN*/
                if (borradzonageneral) {
                    int temp = listlistDZonaGeneral.get(roxI).get(colI).getIDZONA();
                    for (Leyenda l : listLeyenda) {
                        if (l.getNUM() == temp) {
                            listLeyenda.remove(l);
                            break;
                        }
                    }
                    for (List<DZonaGeneral> d : listlistDZonaGeneral) {
                        for (DZonaGeneral dd : d) {
                            if (dd.getIDZONA() != 0) {
                                if (dd.getIDZONA() == temp) {
                                    dd.setIDZONA(0);
                                    dd.setCOLOR("#FFFFFF");
                                }
                            }
                        }

                    }
                    int cont = 0;
                    for (Zona z : listZona) {
                        if (z.getIDZONA() == temp) {
                            z.setPICKED(false);
                            listZona.set(cont, z);
                            break;
                        }
                        cont++;
                    }
                }
                if (addpuerta) {
                    selectDZonaGeneral = listlistDZonaGeneral.get(roxI).get(colI);
                    selectDZonaGeneral.setIDUBICACION("");
                    selectDZonaGeneral.setSELECCIONADO(false);
                    selectDZonaGeneral.setCOLOR("#000000");
                    selectDZonaGeneral.setPUERTA(1);
                    listlistDZonaGeneral.get(roxI).set(colI, selectDZonaGeneral);
                }
            } else {
                int ina = listZona.indexOf(selectZona);
                listZona.get(ina).setPICKED(true);
                if (selectZona.getIDTIPOZONA() == 1) {
                    int limtA = listDAlmacenDiagrama.get(listDAlmacenDiagrama.size() - 1).getCORDENADAX() + 1;
                    int limtL = listDAlmacenDiagrama.get(listDAlmacenDiagrama.size() - 1).getCORDENADAY() + 1;
                    if (limtA <= getDatoEdicion().getANCHO() && limtL <= getDatoEdicion().getLARGO()) {
                        int it = 0;
                        int limAt = limtA + roxI;
                        int limLt = limtL + colI;
                        if (limAt > getDatoEdicion().getANCHO()) {
                            limAt = getDatoEdicion().getANCHO();
                        }
                        if (limLt > getDatoEdicion().getLARGO()) {
                            limLt = getDatoEdicion().getLARGO();
                        }
                        for (int c = roxI; c < limAt; c++) {
                            for (int d = colI; d < limLt; d++) {
                                selectDZonaGeneral = listlistDZonaGeneral.get(c).get(d);
                                selectDZonaGeneral.setIDEMPRESA(listDAlmacenDiagrama.get(it).getIDEMPRESA());
                                selectDZonaGeneral.setIDSUCURSAL(listDAlmacenDiagrama.get(it).getIDSUCURSAL());
                                selectDZonaGeneral.setIDZONA(selectZona.getIDZONA());
                                selectDZonaGeneral.setCORDENADAX(d);
                                selectDZonaGeneral.setCORDENADAY(c);
                                selectDZonaGeneral.setDCORDENADAX(listDAlmacenDiagrama.get(it).getCORDENADAX());
                                selectDZonaGeneral.setDCORDENADAY(listDAlmacenDiagrama.get(it).getCORDENADAY());
                                if (!listDAlmacenDiagrama.get(it).getIDDISTRIBUCION().trim().equalsIgnoreCase("")) {
                                    selectDZonaGeneral.setSELECCIONADO(true);
                                } else {
                                    selectDZonaGeneral.setSELECCIONADO(false);
                                }
                                selectDZonaGeneral.setCOLOR(listDAlmacenDiagrama.get(it).getCOLORHEXADECIMAL());
                                listlistDZonaGeneral.get(c).set(d, selectDZonaGeneral);
                                it++;
                            }
                        }
                    } else {
                        WebUtil.MensajeAdvertencia("Largo o Ancho Son mas grandes que el total");
                    }
                } else {
                    int limtA = lstDZonaDiagram.get(lstDZonaDiagram.size() - 1).getCORDENADAX() + 1;
                    int limtL = lstDZonaDiagram.get(lstDZonaDiagram.size() - 1).getCORDENADAY() + 1;
                    if (limtA <= getDatoEdicion().getANCHO() && limtL <= getDatoEdicion().getLARGO()) {
                        int it = 0;
                        int limAt = limtA + roxI;
                        int limLt = limtL + colI;
                        if (limAt > getDatoEdicion().getANCHO()) {
                            limAt = getDatoEdicion().getANCHO();
                        }
                        if (limLt > getDatoEdicion().getLARGO()) {
                            limLt = getDatoEdicion().getLARGO();
                        }
                        for (int c = roxI; c < limAt; c++) {
                            for (int d = colI; d < limLt; d++) {
                                selectDZonaGeneral = listlistDZonaGeneral.get(c).get(d);
                                selectDZonaGeneral.setIDEMPRESA(lstDZonaDiagram.get(it).getIDEMPRESA());
                                selectDZonaGeneral.setIDSUCURSAL(lstDZonaDiagram.get(it).getIDSUCURSAL());
                                selectDZonaGeneral.setIDZONA(lstDZonaDiagram.get(it).getIDZONA());
                                selectDZonaGeneral.setCORDENADAX(d);
                                selectDZonaGeneral.setCORDENADAY(c);
                                selectDZonaGeneral.setDCORDENADAX(lstDZonaDiagram.get(it).getCORDENADAX());
                                selectDZonaGeneral.setDCORDENADAY(lstDZonaDiagram.get(it).getCORDENADAY());
                                if (!lstDZonaDiagram.get(it).getCOLOR().trim().equalsIgnoreCase("#FFFFFF")) {
                                    selectDZonaGeneral.setSELECCIONADO(true);
                                } else {
                                    selectDZonaGeneral.setSELECCIONADO(false);
                                }

                                selectDZonaGeneral.setCOLOR(lstDZonaDiagram.get(it).getCOLOR());
                                listlistDZonaGeneral.get(c).set(d, selectDZonaGeneral);
                                it++;
                            }
                        }
                    } else {
                        WebUtil.MensajeAdvertencia("Largo o Ancho Son mas grandes que el total");
                    }
                }

                /**
                 * *********ACTUALIZAR LEYENDA************
                 */
                if (buscarLeyenda(selectZona.getIDZONA())) {
                    Leyenda leyenda = new Leyenda();
                    leyenda.setNUM(Integer.valueOf(selectZona.getIDZONA()));
                    leyenda.setDESCRIPCION(selectZona.getDESCRIPCION());
                    leyenda.setCOLOR("#" + color);
                    listLeyenda.add(leyenda);
                }
                /**
                 * **************************************
                 */
                selectZona = null;
            }
            RequestContext.getCurrentInstance().update("datos:leyenda");
            RequestContext.getCurrentInstance().update("datos:tblDetalle");
            RequestContext.getCurrentInstance().update("datos:listZona");
//            RequestContext.getCurrentInstance().update("datos:listDZonaDiagrama:cuadroRack");
//            RequestContext.getCurrentInstance().update("datos:listaRacks");
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return;
    }

    public boolean buscarLeyenda(int idzona) {
        boolean var = true;
        for (Leyenda l : listLeyenda) {
            if (l.getNUM() == idzona) {
                var = false;
                break;
            }
        }
        return var;
    }

    public List<DZonaGeneral> getListDZonaGeneral() {
        return listDZonaGeneral;
    }

    public void setListDZonaGeneral(List<DZonaGeneral> listDZonaGeneral) {
        this.listDZonaGeneral = listDZonaGeneral;
    }

    public DZonaGeneral getSelectDZonaGeneral() {
        return selectDZonaGeneral;
    }

    public void setSelectDZonaGeneral(DZonaGeneral selectDZonaGeneral) {
        this.selectDZonaGeneral = selectDZonaGeneral;
    }

    public ZonaGeneral getSelectZonaGeneral() {
        return selectZonaGeneral;
    }

    public void setSelectZonaGeneral(ZonaGeneral selectZonaGeneral) {
        this.selectZonaGeneral = selectZonaGeneral;
    }

    public ZonaGeneralDao getZonaGeneralDao() {
        return zonaGeneralDao;
    }

    public void setZonaGeneralDao(ZonaGeneralDao zonaGeneralDao) {
        this.zonaGeneralDao = zonaGeneralDao;
    }

    public DZonaGeneralDao getDzonaGeneralDao() {
        return dzonaGeneralDao;
    }

    public void setDzonaGeneralDao(DZonaGeneralDao dzonaGeneralDao) {
        this.dzonaGeneralDao = dzonaGeneralDao;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public UsuarioBean getUser() {
        return user;
    }

    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    public List<Zona> getListZona() {
        return listZona;
    }

    public void setListZona(List<Zona> listZona) {
        this.listZona = listZona;
    }

    public ZonaDao getZonaDao() {
        return zonaDao;
    }

    public void setZonaDao(ZonaDao zonaDao) {
        this.zonaDao = zonaDao;
    }

    public Zona getSelectZona() {
        return selectZona;
    }

    public void setSelectZona(Zona selectZona) {
        this.selectZona = selectZona;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEscala() {
        return escala;
    }

    public void setEscala(int escala) {
        this.escala = escala;
    }

    public boolean isBorradzonageneral() {
        return borradzonageneral;
    }

    public void setBorradzonageneral(boolean borradzonageneral) {
        this.borradzonageneral = borradzonageneral;
    }

    public boolean isAddpuerta() {
        return addpuerta;
    }

    public void setAddpuerta(boolean addpuerta) {
        this.addpuerta = addpuerta;
    }

    public List<Leyenda> getListLeyenda() {
        return listLeyenda;
    }

    public void setListLeyenda(List<Leyenda> listLeyenda) {
        this.listLeyenda = listLeyenda;
    }

    public boolean getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(boolean estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }

    public List<Zona> getFilterZona() {
        return filterZona;
    }

    public void setFilterZona(List<Zona> filterZona) {
        this.filterZona = filterZona;
    }

    public List<Sucursal> getListSucursal() {
        return listSucursal;
    }

    public void setListSucursal(List<Sucursal> listSucursal) {
        this.listSucursal = listSucursal;
    }

    public Leyenda getSelectLeyenda() {
        return selectLeyenda;
    }

    public void setSelectLeyenda(Leyenda selectLeyenda) {
        this.selectLeyenda = selectLeyenda;
    }

    public ZonaAlmacen getSlcZonaAlmacen() {
        return slcZonaAlmacen;
    }

    public void setSlcZonaAlmacen(ZonaAlmacen slcZonaAlmacen) {
        this.slcZonaAlmacen = slcZonaAlmacen;
    }

    public List<ZonaAlmacen> getListZonaAlmacen() {
        return listZonaAlmacen;
    }

    public void setListZonaAlmacen(List<ZonaAlmacen> listZonaAlmacen) {
        this.listZonaAlmacen = listZonaAlmacen;
    }

    public List<DAlmacenDiagrama> getListDAlmacenDiagrama() {
        return listDAlmacenDiagrama;
    }

    public void setListDAlmacenDiagrama(List<DAlmacenDiagrama> listDAlmacenDiagrama) {
        this.listDAlmacenDiagrama = listDAlmacenDiagrama;
    }

    public List<DZonaDiagrama> getLstDZonaDiagram() {
        return lstDZonaDiagram;
    }

    public void setLstDZonaDiagram(List<DZonaDiagrama> lstDZonaDiagram) {
        this.lstDZonaDiagram = lstDZonaDiagram;
    }

    public List<ArrayList<DZonaGeneral>> getListlistDZonaGeneral() {
        return listlistDZonaGeneral;
    }

    public void setListlistDZonaGeneral(List<ArrayList<DZonaGeneral>> listlistDZonaGeneral) {
        this.listlistDZonaGeneral = listlistDZonaGeneral;
    }

    public List<DZonaGeneral> getSlclistDZonaGeneral() {
        return slclistDZonaGeneral;
    }

    public void setSlclistDZonaGeneral(List<DZonaGeneral> slclistDZonaGeneral) {
        this.slclistDZonaGeneral = slclistDZonaGeneral;
    }

    public List<Integer> getOblist() {
        return oblist;
    }

    public void setOblist(List<Integer> oblist) {
        this.oblist = oblist;
    }

    public UploadedFile getUpFile() {
        return upFile;
    }

    public void setUpFile(UploadedFile upFile) {
        this.upFile = upFile;
    }

}
