/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.DAlmacenDiagramaDAO;
import com.nisira.core.dao.DZonaAccesorioDao;
import com.nisira.core.dao.DZonaDiagramaDao;
import com.nisira.core.dao.ZonaDao;
import com.nisira.core.entity.DZonaAccesorio;
import com.nisira.core.entity.DZonaDiagrama;
import com.nisira.core.entity.DZonaDiagramaUbicacion;
import com.nisira.core.entity.Leyenda;
import com.nisira.core.entity.Zona;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SlideEndEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "esquemaZonaAction")
@SessionScoped
public class EsquemaZonaAction extends AbstactListAction<Zona> implements Serializable {

    private List<DZonaAccesorio> lstDZonaAcc;
    private DZonaAccesorio sltDZonaAcc;
    private DZonaAccesorioDao dzonaccDo;
    private List<DZonaDiagrama> lstDZonaDiagram;
    private DZonaDiagrama slcDzonaDiagram;
    private DZonaDiagramaDao dzonaDiagDao;
    private ZonaDao zonadao;
    private UsuarioBean usuarioLogueadoBean;
    private String mensaje;
    private int escala;
    private boolean preform;
    private int largo;
    private int ancho;
    private List<Leyenda> listLeyenda;
    private String color;
    private DAlmacenDiagramaDAO daoDAlmacenDiagrama;
    private List<DZonaDiagramaUbicacion> lstDzonaDiaUbicacion;

    public EsquemaZonaAction() {
        lstDZonaAcc = new ArrayList<DZonaAccesorio>();
        sltDZonaAcc = new DZonaAccesorio();
        dzonaccDo = new DZonaAccesorioDao();
        lstDZonaDiagram = new ArrayList<DZonaDiagrama>();
        slcDzonaDiagram = new DZonaDiagrama();
        dzonaDiagDao = new DZonaDiagramaDao();
        zonadao = new ZonaDao();
        usuarioLogueadoBean = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = null;
        escala = 0;
        preform = false;
        largo = 0;
        ancho = 0;
        listLeyenda = new ArrayList<Leyenda>();
        daoDAlmacenDiagrama = new DAlmacenDiagramaDAO();
        lstDzonaDiaUbicacion = new ArrayList<DZonaDiagramaUbicacion>();
        actualiza_ventana("wMnt_EsquemaZona");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_EsquemaZona");
            setListaDatos(zonadao.findNotAlmacenes(usuarioLogueadoBean.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        lstDZonaAcc = new ArrayList<DZonaAccesorio>();
        sltDZonaAcc = new DZonaAccesorio();
        dzonaccDo = new DZonaAccesorioDao();
        lstDZonaDiagram = new ArrayList<DZonaDiagrama>();
        slcDzonaDiagram = new DZonaDiagrama();
        dzonaDiagDao = new DZonaDiagramaDao();
        zonadao = new ZonaDao();
        usuarioLogueadoBean = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = null;
        escala = 0;
        preform = false;
        largo = 0;
        ancho = 0;
        listLeyenda = new ArrayList<Leyenda>();
        daoDAlmacenDiagrama = new DAlmacenDiagramaDAO();
        lstDzonaDiaUbicacion = new ArrayList<DZonaDiagramaUbicacion>();
        actualiza_ventana("wMnt_EsquemaZona");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Zona());
    }

    @Override
    public void grabar() {
        String td = null;
        String Inicio = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_rack = new XStream();
        xStream_rack = new XStream();
        xStream_rack.processAnnotations(DZonaDiagrama.class);
        String xmlDet = Inicio.concat(xStream_rack.toXML(lstDZonaDiagram));
        td = xmlDet;

        try {
            dzonaDiagDao.addXmlDZonaDiagrama(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), xmlDet);
            duplicar();
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public void duplicar() throws Exception {
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
        dzonaDiagDao.addxmlDzonaDiagramaUbicacion(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), xmlUbi);
        dzonaDiagDao.reflejarDzonageneral(xmlUbi);
    }

    @Override
    public void eliminar() {
        try {
            if (lstDZonaDiagram.isEmpty()) {
                lstDZonaDiagram = dzonaDiagDao.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA());
            }
            for (DZonaDiagrama dz : lstDZonaDiagram) {
                if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                    dz.setESTADO(0);
                }
                if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                    dz.setESTADO(2);
                }
            }
            String td = null;
            String Inicio = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream_rack = new XStream();
            xStream_rack = new XStream();
            xStream_rack.processAnnotations(DZonaDiagrama.class);
            String xmlDet = Inicio.concat(xStream_rack.toXML(lstDZonaDiagram));
            td = xmlDet;
            dzonaDiagDao.addXmlDZonaDiagrama(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), xmlDet);
        } catch (Exception ex) {
            Logger.getLogger(EsquemaZonaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciarMantenedorEsquemaZona() throws Exception {
        escala = 50;
        lstDZonaAcc = dzonaccDo.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA());
        lstDZonaDiagram = dzonaDiagDao.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA());
        if (lstDZonaDiagram == null || lstDZonaDiagram.isEmpty()) {
            for (int x = 0; x < getDatoEdicion().getANCHOUNIDADDIAGRAMA(); x++) {
                for (int y = 0; y < getDatoEdicion().getLARGOUNIDADDIAGRAMA(); y++) {
                    DZonaDiagrama variableDZonaDiagrama = new DZonaDiagrama();
                    variableDZonaDiagrama.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                    variableDZonaDiagrama.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                    variableDZonaDiagrama.setIDZONA(getDatoEdicion().getIDZONA());
                    variableDZonaDiagrama.setIDALMACEN(null);
                    variableDZonaDiagrama.setIDDISTRIBUCION(null);
                    variableDZonaDiagrama.setCORDENADAX(x);
                    variableDZonaDiagrama.setCORDENADAY(y);
                    variableDZonaDiagrama.setIDACCESORIO(null);
                    variableDZonaDiagrama.setCOLOR("#FFFFFF");
                    lstDZonaDiagram.add(variableDZonaDiagrama);
                }
            }
        } else {
            listLeyenda = daoDAlmacenDiagrama.findLeyenda(3, getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), "", getDatoEdicion().getIDZONA());
            for (Leyenda l : listLeyenda) {
                for (DZonaAccesorio lr : lstDZonaAcc) {
                    if (l.getNUM() == lr.getIDACCESORIO()) {
                        lr.setPicked(true);
                    }
                }
            }
        }
        RequestContext.getCurrentInstance().update("datos:cboalmacen");
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona");
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama");
    }

    public void onSlideEnd(SlideEndEvent event) {
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama");
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama:boton");
    }

    public void mostrarColor() {
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona:descripcionColor");
    }

    public void ubicacionSeleccionado() {
        try {
            int pos = lstDZonaDiagram.indexOf(slcDzonaDiagram);
            if (sltDZonaAcc != null) {
                if (preform && largo > 0 && ancho > 0) {
                    slcDzonaDiagram.setESTADO(1);
                    slcDzonaDiagram.setCOLOR("#" + color);
                    lstDZonaDiagram.set(pos, slcDzonaDiagram);
                    int bandera = 0;
                    for (int x = 0; x < ancho; x++) {
                        for (int y = 0; y < largo; y++) {
                            bandera = (getDatoEdicion().getLARGOUNIDADDIAGRAMA() * x) + y + pos;
                            getLstDZonaDiagram().get(bandera).setESTADO(1);
                            getLstDZonaDiagram().get(bandera).setCOLOR("#" + color);
                            getLstDZonaDiagram().get(bandera).setIDACCESORIO(sltDZonaAcc.getIDACCESORIO());
                        }
                    }
                } else {
                    if (slcDzonaDiagram.getESTADO() == 1) {
                        slcDzonaDiagram.setIDACCESORIO(null);
                        slcDzonaDiagram.setESTADO(0);
                        slcDzonaDiagram.setCOLOR("#FFFFFF");
                        getLstDZonaDiagram().set(pos, slcDzonaDiagram);
                    } else {
                        slcDzonaDiagram.setESTADO(1);
                        slcDzonaDiagram.setCOLOR("#" + color);
                        slcDzonaDiagram.setIDACCESORIO(sltDZonaAcc.getIDACCESORIO());
                        lstDZonaDiagram.set(pos, slcDzonaDiagram);
                    }
                }
                /*ACCIÓN DE SELECCIÓN*/

            } else {
                WebUtil.MensajeAdvertencia("SELECCIONE UN ACCESORIO");
            }
            RequestContext.getCurrentInstance().update("FormularioEsquemaZona:leyenda");
            RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama");
            RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama:cuadroRack");
            RequestContext.getCurrentInstance().update("FormularioAlmacenRacks:listaRacks");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void getClear() {
        for (int i = 0; i < lstDZonaDiagram.size(); i++) {
            lstDZonaDiagram.get(i).setCOLOR("#FFFFFF");
            lstDZonaDiagram.get(i).setESTADO(0);
        }
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama");
        RequestContext.getCurrentInstance().update("FormularioEsquemaZona:listDZonaDiagrama:cuadroRack");
    }

    public String cerosIzquierda(Object e1, int cantidad) {
        return WebUtil.cerosIzquierda(e1.toString(), cantidad);
    }

    public List<DZonaAccesorio> getLstDZonaAcc() {
        return lstDZonaAcc;
    }

    public void setLstDZonaAcc(List<DZonaAccesorio> lstDZonaAcc) {
        this.lstDZonaAcc = lstDZonaAcc;
    }

    public DZonaAccesorio getSltDZonaAcc() {
        return sltDZonaAcc;
    }

    public void setSltDZonaAcc(DZonaAccesorio sltDZonaAcc) {
        this.sltDZonaAcc = sltDZonaAcc;
    }

    public List<DZonaDiagrama> getLstDZonaDiagram() {
        return lstDZonaDiagram;
    }

    public void setLstDZonaDiagram(List<DZonaDiagrama> lstDZonaDiagram) {
        this.lstDZonaDiagram = lstDZonaDiagram;
    }

    public DZonaDiagrama getSlcDzonaDiagram() {
        return slcDzonaDiagram;
    }

    public void setSlcDzonaDiagram(DZonaDiagrama slcDzonaDiagram) {
        this.slcDzonaDiagram = slcDzonaDiagram;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getEscala() {
        return escala;
    }

    public void setEscala(int escala) {
        this.escala = escala;
    }

    public List<Leyenda> getListLeyenda() {
        return listLeyenda;
    }

    public void setListLeyenda(List<Leyenda> listLeyenda) {
        this.listLeyenda = listLeyenda;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPreform() {
        return preform;
    }

    public void setPreform(boolean preform) {
        this.preform = preform;
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

}
