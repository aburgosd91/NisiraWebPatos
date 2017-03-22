/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.DAlmacenDiagramaDAO;
import com.nisira.core.dao.DAlmacen_ColumnasDao;
import com.nisira.core.dao.DAlmacen_PisosDao;
import com.nisira.core.dao.DZonaDiagramaDao;
import com.nisira.core.entity.DAlmacenDiagrama;
import com.nisira.core.entity.DAlmacenDiagramaUbicacion;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.core.entity.DZonaDiagrama;
import com.nisira.core.entity.Leyenda;
import com.nisira.core.entity.ZonaAlmacen;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SlideEndEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "esquemaAlmacenAction")
@SessionScoped
public class EsquemaAlmacenAction extends AbstactListAction<ZonaAlmacen> implements Serializable {

    private Leyenda selectedLeyenda;
    private DAlmacenDiagrama selectDAlmacenDiagrama;
    private DAlmacenDiagramaDAO daoDAlmacenDiagrama;
    private List<DAlmacenDiagrama> listDAlmacenDiagrama;
    private List<Leyenda> listLeyenda;
    private DAlmacen_ColumnasDao daoDAlmacen_Columnas;
    private List<DAlmacen_Racks> listaRacks;
    private DAlmacen_Racks selctRack;
    private UsuarioBean usuarioLogueadoBean;
    private int idempresa;
    private int idsucursal;
    private String mensaje;
    private String color;
    private int escala;
    private boolean borraesg;
    private int largo;
    private int ancho;
    private List<DZonaDiagrama> lstDZonaDiagram;
    private DZonaDiagramaDao dzonaDiagDao;
    private List<DAlmacenDiagramaUbicacion> lstDAlmDiaUbicacion;
    private DAlmacen_PisosDao daopisosAlm;
    private boolean preform;

    public EsquemaAlmacenAction() {
        selectDAlmacenDiagrama = new DAlmacenDiagrama();
        daoDAlmacenDiagrama = new DAlmacenDiagramaDAO();
        listDAlmacenDiagrama = new ArrayList<DAlmacenDiagrama>();
        listLeyenda = new ArrayList<Leyenda>();
        daoDAlmacen_Columnas = new DAlmacen_ColumnasDao();
        listaRacks = new ArrayList<DAlmacen_Racks>();
        selctRack = new DAlmacen_Racks();
        usuarioLogueadoBean = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        idempresa = Integer.valueOf(usuarioLogueadoBean.getIDEMPRESA());
        idsucursal = Integer.valueOf(Constantes.getIDSUCURSALGENERAL());
        color = null;
        lstDZonaDiagram = new ArrayList<DZonaDiagrama>();
        dzonaDiagDao = new DZonaDiagramaDao();
        preform = false;
        largo = 0;
        ancho = 0;
        actualiza_ventana("wMnt_EsquemaAlmacen");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_EsquemaAlmacen");
            setListaDatos(daoDAlmacenDiagrama.findZonaAlmacen(idempresa, idsucursal));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    @Override
    public String getIniciar() {
        selectDAlmacenDiagrama = new DAlmacenDiagrama();
        daoDAlmacenDiagrama = new DAlmacenDiagramaDAO();
        listDAlmacenDiagrama = new ArrayList<DAlmacenDiagrama>();
        listLeyenda = new ArrayList<Leyenda>();
        daoDAlmacen_Columnas = new DAlmacen_ColumnasDao();
        listaRacks = new ArrayList<DAlmacen_Racks>();
        usuarioLogueadoBean = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        idempresa = Integer.valueOf(usuarioLogueadoBean.getIDEMPRESA());
        idsucursal = Integer.valueOf(Constantes.getIDSUCURSALGENERAL());
        color = null;
        lstDZonaDiagram = new ArrayList<DZonaDiagrama>();
        dzonaDiagDao = new DZonaDiagramaDao();
        preform = false;
        largo = 0;
        ancho = 0;
        actualiza_ventana("wMnt_EsquemaAlmacen");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new ZonaAlmacen());
    }

    @Override
    public void grabar() {
        try {
            String td = null;
            String Inicio = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream_rack = new XStream();
            xStream_rack = new XStream();
            xStream_rack.processAnnotations(DAlmacenDiagrama.class);
            String xmlDet = Inicio.concat(xStream_rack.toXML(listDAlmacenDiagrama));
            td = xmlDet;
            lstDZonaDiagram = new ArrayList<DZonaDiagrama>();
            for (DAlmacenDiagrama da : listDAlmacenDiagrama) {
                DZonaDiagrama dz = new DZonaDiagrama();
                dz.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                dz.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                dz.setIDZONA(getDatoEdicion().getIDZONA());
                dz.setIDALMACEN(da.getIDALMACEN());
                dz.setIDDISTRIBUCION(da.getIDDISTRIBUCION());
                dz.setCORDENADAX(da.getCORDENADAX());
                dz.setCORDENADAY(da.getCORDENADAY());
                dz.setIDACCESORIO(null);
                dz.setESTADO(da.getESTADO());
                dz.setCOLOR(da.getCOLORHEXADECIMAL());
                lstDZonaDiagram.add(dz);
            }
            xStream_rack = new XStream();
            xStream_rack.processAnnotations(DZonaDiagrama.class);
            String xmlDZ = Inicio.concat(xStream_rack.toXML(lstDZonaDiagram));
            daoDAlmacenDiagrama.addXmlDZonaDiagrama(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDALMACEN(), xmlDet);
            daoDAlmacenDiagrama.generarUbicacion(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDALMACEN(), getDatoEdicion().getIDZONA());
            dzonaDiagDao.addXmlDZonaDiagrama2(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), getDatoEdicion().getIDALMACEN(), xmlDZ);
            dzonaDiagDao.reflejarDzonageneral(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDALMACEN(), getDatoEdicion().getIDZONA());
        } catch (Exception ex) {
            Logger.getLogger(EsquemaAlmacenAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UbicarAlmacenDiagrama() {

    }

    @Override
    public void eliminar() {
        try {
            if (listDAlmacenDiagrama.isEmpty()) {
                listDAlmacenDiagrama = daoDAlmacenDiagrama.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDALMACEN());
            }
            lstDZonaDiagram = new ArrayList<DZonaDiagrama>();
            for (DAlmacenDiagrama da : listDAlmacenDiagrama) {
                DZonaDiagrama dz = new DZonaDiagrama();
                dz.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                dz.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                dz.setIDZONA(getDatoEdicion().getIDZONA());
                dz.setIDALMACEN(da.getIDALMACEN());
                dz.setIDDISTRIBUCION(da.getIDDISTRIBUCION());
                dz.setCORDENADAX(da.getCORDENADAX());
                dz.setCORDENADAY(da.getCORDENADAY());
                dz.setIDACCESORIO(null);
                if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                    da.setESTADO(0);
                }
                if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                    da.setESTADO(2);
                }
                dz.setESTADO(da.getESTADO());
                dz.setCOLOR(da.getCOLORHEXADECIMAL());
                lstDZonaDiagram.add(dz);
            }
            String td = null;
            String Inicio = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream_rack = new XStream();
            xStream_rack = new XStream();
            xStream_rack.processAnnotations(DAlmacenDiagrama.class);
            String xmlDet = Inicio.concat(xStream_rack.toXML(listDAlmacenDiagrama));
            td = xmlDet;
            xStream_rack = new XStream();
            xStream_rack.processAnnotations(DZonaDiagrama.class);
            String xmlDZ = Inicio.concat(xStream_rack.toXML(lstDZonaDiagram));
            daoDAlmacenDiagrama.addXmlDZonaDiagrama(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDALMACEN(), xmlDet);
            dzonaDiagDao.addXmlDZonaDiagrama2(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), getDatoEdicion().getIDALMACEN(), xmlDZ);
            listDAlmacenDiagrama = new ArrayList<DAlmacenDiagrama>();
            lstDZonaDiagram = new ArrayList<DZonaDiagrama>();
        } catch (Exception ex) {
            Logger.getLogger(EsquemaAlmacenAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buttonAction() {
        if (selectedLeyenda != null) {
            this.color = selectedLeyenda.getCOLOR().replace("#", "");
            RequestContext.getCurrentInstance().update("FormularioEsquemaZona:colorPicker");
        }
    }

    public void iniciarMantenedorEsquemaZona() throws Exception {
        selctRack = null;
        listLeyenda = new ArrayList<Leyenda>();
        color = null;
        borraesg = false;
        escala = 50;
        listaRacks = daoDAlmacen_Columnas.findAllRacksPisosFilasColumnasTotal(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDALMACEN(), "", "", "");
        listDAlmacenDiagrama = daoDAlmacenDiagrama.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDALMACEN());
        if (listDAlmacenDiagrama == null || listDAlmacenDiagrama.isEmpty()) {
            for (int  y= 0; y < getDatoEdicion().getANCHOUNIDADDIAGRAMA(); y++) {
                for (int x = 0; x < getDatoEdicion().getLARGOUNIDADDIAGRAMA(); x++) {
                    DAlmacenDiagrama variableDAlmacenDiagrama = new DAlmacenDiagrama();
                    variableDAlmacenDiagrama.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                    variableDAlmacenDiagrama.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                    variableDAlmacenDiagrama.setIDALMACEN(getDatoEdicion().getIDALMACEN());
                    variableDAlmacenDiagrama.setIDDISTRIBUCION("");
                    variableDAlmacenDiagrama.setCORDENADAX(x);
                    variableDAlmacenDiagrama.setCORDENADAY(y);
                    variableDAlmacenDiagrama.setIDRACK(null);
                    variableDAlmacenDiagrama.setCOLORHEXADECIMAL("#FFFFFF");
                    listDAlmacenDiagrama.add(variableDAlmacenDiagrama);
                }
            }
        } else {
            listLeyenda = daoDAlmacenDiagrama.findLeyenda(1, getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDALMACEN(), "");
            for (Leyenda l : listLeyenda) {
                for (DAlmacen_Racks lr : listaRacks) {
                    if (l.getNUM() == Integer.valueOf(lr.getIDRACK())) {
                        lr.setPicked(true);
                    }
                }
            }
            Map<String, List<Leyenda>> personByCity = new HashMap<>();
            personByCity = listLeyenda.stream().collect(Collectors.groupingBy(Leyenda::getCOLOR));
            listLeyenda = new ArrayList<Leyenda>();
            Iterator i = personByCity.entrySet().iterator();
            int n = 1;
            while (i.hasNext()) {
                Leyenda l = new Leyenda();
                Map.Entry pair = (Map.Entry) i.next();
                l.setCOLOR(pair.getKey().toString());
                ArrayList<Leyenda> list = (ArrayList) pair.getValue();
                l.setDESCRIPCION(list.get(0).getDESCRIPCION());
                l.setNUM(n);
                listLeyenda.add(l);
                n++;
            }

        }
        RequestContext.getCurrentInstance().update("datos:cboalmacen");
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona");
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama");
    }

    public String cerosIzquierda(Object e1, int cantidad) {
        return WebUtil.cerosIzquierda(e1.toString(), cantidad);
    }

    public void ubicacionSeleccionado() {
        try {
            int pos = listDAlmacenDiagrama.indexOf(selectDAlmacenDiagrama);
            if (selctRack == null) {
                /*ACCIÓN DE SELECCIÓN*/
                if (borraesg) {
                    String temp = selectDAlmacenDiagrama.getIDRACK();
                    for (Leyenda l : listLeyenda) {
                        if (l.getNUM() == Integer.parseInt(temp)) {
                            listLeyenda.remove(l);
                            break;
                        }
                    }
                    for (DAlmacenDiagrama d : listDAlmacenDiagrama) {
                        if (d.getIDRACK() != null) {
                            if (d.getIDRACK().equalsIgnoreCase(temp)) {
                                d.setESTADO(0);
                                d.setIDDISTRIBUCION("");
                                d.setIDRACK(null);
                                d.setCOLORHEXADECIMAL("#FFFFFF");
                            }
                        }
                    }
                    int cont = 0;
                    for (DAlmacen_Racks r : listaRacks) {
                        if (r.getIDRACK().equalsIgnoreCase(temp)) {
                            r.setPicked(false);
                            listaRacks.set(cont, r);
                            break;
                        }
                        cont++;
                    }
                } else {
                    if (selectDAlmacenDiagrama.getESTADO() == 1) {
                        selectDAlmacenDiagrama.setIDRACK(null);
                        selectDAlmacenDiagrama.setESTADO(0);
                        selectDAlmacenDiagrama.setIDDISTRIBUCION("");
                        selectDAlmacenDiagrama.setCOLORHEXADECIMAL("#FFFFFF");
                        getListDAlmacenDiagrama().set(pos, getSelectDAlmacenDiagrama());
                    } else {
                        selectDAlmacenDiagrama.setESTADO(1);
                        selectDAlmacenDiagrama.setCOLORHEXADECIMAL("#" + color);
                        listDAlmacenDiagrama.set(pos, selectDAlmacenDiagrama);
                    }
                }

            } else {
                if (preform && largo > 0 && ancho > 0) {
                    selectDAlmacenDiagrama.setESTADO(1);
                    selectDAlmacenDiagrama.setCOLORHEXADECIMAL("#" + color);
                    selectDAlmacenDiagrama.setIDRACK(selctRack.getIDRACK());
                    listDAlmacenDiagrama.set(pos, selectDAlmacenDiagrama);
                    int ina = listaRacks.indexOf(selctRack);
                    listaRacks.get(ina).setPicked(true);
                    Leyenda leyenda = new Leyenda();
                    leyenda.setNUM(Integer.valueOf(selctRack.getIDRACK()));
                    leyenda.setDESCRIPCION(listaRacks.get(ina).getTIPORACKS());
                    leyenda.setCOLOR("#" + color);
                    listLeyenda.add(leyenda);
                    int bandera = 0;
                    for (int y = 0; y < ancho; y++) {
                        for (int x = 0; x < largo; x++) {
                            bandera = (getDatoEdicion().getLARGOUNIDADDIAGRAMA() * y) + x+ pos;
                            getListDAlmacenDiagrama().get(bandera).setESTADO(1);
                            getListDAlmacenDiagrama().get(bandera).setCOLORHEXADECIMAL("#" + color);
                            getListDAlmacenDiagrama().get(bandera).setIDDISTRIBUCION(selctRack.getIDDISTRIBUCION());
                            getListDAlmacenDiagrama().get(bandera).setIDRACK(selctRack.getIDRACK());
                        }
                    }
                } else {
                    selectDAlmacenDiagrama.setESTADO(1);
                    selectDAlmacenDiagrama.setCOLORHEXADECIMAL("#" + color);
                    selectDAlmacenDiagrama.setIDRACK(selctRack.getIDRACK());
                    listDAlmacenDiagrama.set(pos, selectDAlmacenDiagrama);
                    int ina = listaRacks.indexOf(selctRack);
                    listaRacks.get(ina).setPicked(true);
                    Leyenda leyenda = new Leyenda();
                    leyenda.setNUM(Integer.valueOf(selctRack.getIDRACK()));
                    leyenda.setDESCRIPCION(listaRacks.get(ina).getTIPORACKS());
                    leyenda.setCOLOR("#" + color);
                    listLeyenda.add(leyenda);
                    int bandera = 0;
                    for (int y = 0; y < selctRack.getFILAS(); y++) {
                        for (int x = 0; x < selctRack.getCOLUMNAS(); x++) {
                            bandera = (getDatoEdicion().getLARGOUNIDADDIAGRAMA() * y) + x + pos;
                            getListDAlmacenDiagrama().get(bandera).setESTADO(1);
                            getListDAlmacenDiagrama().get(bandera).setCOLORHEXADECIMAL("#" + color);
                            getListDAlmacenDiagrama().get(bandera).setIDDISTRIBUCION(selctRack.getIDDISTRIBUCION());
                            getListDAlmacenDiagrama().get(bandera).setIDRACK(selctRack.getIDRACK());
                        }
                    }
                }

                selctRack = null;
            }
            RequestContext.getCurrentInstance().update("FormularioEsquemaZona:leyenda");
            RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama");
            RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama:cuadroRack");
            RequestContext.getCurrentInstance().update("FormularioAlmacenRacks:listaRacks");
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return;
    }

    public void onSlideEnd(SlideEndEvent event) {
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama");
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama:boton");
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public DAlmacenDiagrama getSelectDAlmacenDiagrama() {
        return selectDAlmacenDiagrama;
    }

    public void setSelectDAlmacenDiagrama(DAlmacenDiagrama selectDAlmacenDiagrama) {
        this.selectDAlmacenDiagrama = selectDAlmacenDiagrama;
    }

    public List<DAlmacenDiagrama> getListDAlmacenDiagrama() {
        return listDAlmacenDiagrama;
    }

    public void setListDAlmacenDiagrama(List<DAlmacenDiagrama> listDAlmacenDiagrama) {
        this.listDAlmacenDiagrama = listDAlmacenDiagrama;
    }

    public List<Leyenda> getListLeyenda() {
        return listLeyenda;
    }

    public void setListLeyenda(List<Leyenda> listLeyenda) {
        this.listLeyenda = listLeyenda;
    }

    public List<DAlmacen_Racks> getListaRacks() {
        return listaRacks;
    }

    public void setListaRacks(List<DAlmacen_Racks> listaRacks) {
        this.listaRacks = listaRacks;
    }

    public DAlmacen_Racks getSelctRack() {
        return selctRack;
    }

    public void setSelctRack(DAlmacen_Racks selctRack) {
        this.selctRack = selctRack;
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

    public boolean isBorraesg() {
        return borraesg;
    }

    public void setBorraesg(boolean borraesg) {
        this.borraesg = borraesg;
    }

    public Leyenda getSelectedLeyenda() {
        return selectedLeyenda;
    }

    public void setSelectedLeyenda(Leyenda selectedLeyenda) {
        this.selectedLeyenda = selectedLeyenda;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public boolean isPreform() {
        return preform;
    }

    public void setPreform(boolean preform) {
        this.preform = preform;
    }

}
