/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AsignacionChipsDao;
import com.nisira.core.dao.DAsignacionChipsDao;
import com.nisira.core.dao.DZonaDiagramaDao;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.ZonaDao;
import com.nisira.core.entity.AsignacionChips;
import com.nisira.core.entity.ChipsList;
import com.nisira.core.entity.DAsignacionChips;
import com.nisira.core.entity.DAsignacionChipsDet;
import com.nisira.core.entity.DZonaDiagrama;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Zona;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "asignacionChips")
@SessionScoped
public class AsignacionChipAction extends AbstactListAction<AsignacionChips> {

    private List<DAsignacionChips> lstDAsigChips;
    private DAsignacionChips slcDAsigChip;
    private AsignacionChipsDao asigDao;
    private DAsignacionChipsDao dasigDao;
    private List<Zona> lstZona;
    private Zona slcZona;
    private ZonaDao zonaDao;
    private UsuarioBean user;
    private String mensaje;
    private int dif;
    private int ubsc;
    private int ubc;
    private int taga;
    private List<Multitabla> listTipoRacks;
    private Integer tipostr;
    private int pansize;
    private String NO;
    private String NC;
    private String NE;
    private String CO;
    private String CE;
    private String SO;
    private String SC;
    private String SE;
    private String focus;
    private String focusB;

    public AsignacionChipAction() {
        lstDAsigChips = new ArrayList<DAsignacionChips>();
        slcDAsigChip = new DAsignacionChips();
        asigDao = new AsignacionChipsDao();
        dasigDao = new DAsignacionChipsDao();
        lstZona = new ArrayList<Zona>();
        slcZona = new Zona();
        zonaDao = new ZonaDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        dif = 0;
        ubsc = 0;
        ubc = 0;
        taga = 0;
        mensaje = "";
        listTipoRacks = new ArrayList<Multitabla>();
        tipostr = 0;
        pansize = 0;
        NO = null;
        NC = null;
        NE = null;
        CO = null;
        CE = null;
        SO = null;
        SC = null;
        SE = null;
        focus = "NO";
        focusB = "NOB";
        actualiza_ventana("wMnt_AsignacionChips");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_AsignacionChips");
            setListaDatos(asigDao.findAll(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        lstDAsigChips = new ArrayList<DAsignacionChips>();
        slcDAsigChip = new DAsignacionChips();
        asigDao = new AsignacionChipsDao();
        dasigDao = new DAsignacionChipsDao();
        lstZona = new ArrayList<Zona>();
        slcZona = new Zona();
        zonaDao = new ZonaDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);;
        mensaje = "";
        dif = 0;
        ubsc = 0;
        ubc = 0;
        taga = 0;
        pansize = 0;
        listTipoRacks = new ArrayList<Multitabla>();
        tipostr = 0;
        NO = "";
        NC = "";
        NE = "";
        CO = "";
        CE = "";
        SO = "";
        SC = "";
        SE = "";
        focus = "NO";
        focusB = "NOB";
        actualiza_ventana("wMnt_AsignacionChips");
        return "";
    }

    public void findDetalle() throws Exception {
        lstZona = zonaDao.findAll(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL());
        pansize = (7 * (Integer.parseInt(user.getW()))) / 1366;
        this.listTipoRacks = (new MultitablaDao()).findTiporRacks(user.getIDEMPRESA());
        if (getDatoEdicion().getIdasignacionchips() != null) {
            List<DAsignacionChips> temlstDAsigChips = dasigDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdasignacionchips());
            slcZona = lstZona.stream().filter((zona) -> zona.getIDZONA() == getDatoEdicion().getIdzona()).findAny().get();
            int t = 0;
            int ta = 0;
            int tab = 0;
            for (DAsignacionChips da : temlstDAsigChips) {
                if (da.isProc()) {
                    if (!da.getSeriechip().equalsIgnoreCase("")) {
                        da.setColor("#41e63c");
                        List<DAsignacionChips> l = temlstDAsigChips.stream().filter(det -> det.getIdubicacion().equalsIgnoreCase(da.getIdubicacion())).collect(Collectors.toList());
                        for (DAsignacionChips tl : l) {
                            DAsignacionChipsDet ndet = new DAsignacionChipsDet();
                            ndet.setSeriechip(tl.getSeriechip());
                            ndet.setPosicion(tl.getPosicion());
                            da.getLisdet().add(ndet);
                            temlstDAsigChips.get(temlstDAsigChips.indexOf(tl)).setProc(false);
                            ta++;
                        }
                        lstDAsigChips.add(da);
                        tab++;
                        t++;
                    } else {
                        if (da.getIdubicacion().equalsIgnoreCase("")) {
                            lstDAsigChips.add(da);
                        } else {
                            da.setColor("#f00");
                            lstDAsigChips.add(da);
                            t++;
                        }
                    }
                }
            }
            dif = (t * 4) - ta;
            taga = ta;
            ubsc = t - tab;
            ubc = tab;
        }
    }

    public void onZonaSelect() throws Exception {
        slcZona = lstZona.stream().filter((zona) -> zona.getIDZONA() == getDatoEdicion().getIdzona()).findAny().get();
        lstDAsigChips = dasigDao.gendAll(slcZona.getIDEMPRESA(), slcZona.getIDSUCURSAL(), slcZona.getIDZONA());
        int t = 0;
        for (DAsignacionChips da : lstDAsigChips) {
            if (!da.getIdubicacion().trim().equalsIgnoreCase("") && !da.getIdubicacion().contains("B")) {
                da.setColor("#f00");
                da.setEstadoasignacion(1);
                t++;
            } else {
                String nid = da.getIdubicacion().replace("B", "");
                da.setIdubicacion(nid.trim());
                da.setColor("#FFF");
            }
            if (da.getTiporack() != 0) {
                String r = listTipoRacks.stream().filter((m) -> m.getVALOR().equalsIgnoreCase(String.valueOf(da.getTiporack()))).findAny().get().getDESCRIPCION();
                da.setDesc(r.substring(0, 1));
            }
        }
        dif = t * 4;
        ubsc = t;
        RequestContext.getCurrentInstance().update("datos:listDasigna");
    }

    public void confirmar(int i) {
        slcDAsigChip = lstDAsigChips.get(i);
        if (!slcDAsigChip.getLisdet().isEmpty()) {
            for (DAsignacionChipsDet det : slcDAsigChip.getLisdet()) {
                switch (det.getPosicion()) {
                    case "NO":
                        NO = det.getSeriechip();
                        break;
                    case "NC":
                        NC = det.getSeriechip();
                        break;
                    case "NE":
                        NE = det.getSeriechip();
                        break;
                    case "CO":
                        CO = det.getSeriechip();
                        break;
                    case "CE":
                        CE = det.getSeriechip();
                        break;
                    case "SO":
                        SO = det.getSeriechip();
                        break;
                    case "SC":
                        SC = det.getSeriechip();
                        break;
                    case "SE":
                        SE = det.getSeriechip();
                        break;
                }
            }
        }
        RequestContext.getCurrentInstance().update("datos:pan");
        RequestContext.getCurrentInstance().update("datos:chips");
        RequestContext.getCurrentInstance().execute("PF('detDeasig').show()");
    }

    public void onhideClear() {
        NO = "";
        NC = "";
        NE = "";
        CO = "";
        CE = "";
        SO = "";
        SC = "";
        SE = "";
        focus = "NO";
        focusB = "NOB";
        RequestContext.getCurrentInstance().update("datos:chips");
    }

    public void grabarDet() {
        if (!NO.equalsIgnoreCase("")) {
            DAsignacionChipsDet det = new DAsignacionChipsDet();
            det.setPosicion("NO");
            det.setSeriechip(NO);
            slcDAsigChip.setColor("#41e63c");
            slcDAsigChip.getLisdet().add(det);
            NO = "";
            taga = taga + 1;
            dif = dif - 1;
        }
        if (!NC.equalsIgnoreCase("")) {
            DAsignacionChipsDet det = new DAsignacionChipsDet();
            det.setPosicion("NC");
            det.setSeriechip(NC);
            slcDAsigChip.setColor("#41e63c");
            slcDAsigChip.getLisdet().add(det);
            NC = "";
            taga = taga + 1;
            dif = dif - 1;
        }
        if (!NE.equalsIgnoreCase("")) {
            DAsignacionChipsDet det = new DAsignacionChipsDet();
            det.setPosicion("NE");
            det.setSeriechip(NE);
            slcDAsigChip.setColor("#41e63c");
            slcDAsigChip.getLisdet().add(det);
            NE = "";
            taga = taga + 1;
            dif = dif - 1;
        }
        if (!CO.equalsIgnoreCase("")) {
            DAsignacionChipsDet det = new DAsignacionChipsDet();
            det.setPosicion("CO");
            det.setSeriechip(CO);
            slcDAsigChip.setColor("#41e63c");
            slcDAsigChip.getLisdet().add(det);
            CO = "";
            taga = taga + 1;
            dif = dif - 1;
        }
        if (!CE.equalsIgnoreCase("")) {
            DAsignacionChipsDet det = new DAsignacionChipsDet();
            det.setPosicion("CE");
            det.setSeriechip(CE);
            slcDAsigChip.setColor("#41e63c");
            slcDAsigChip.getLisdet().add(det);
            CE = "";
            taga = taga + 1;
            dif = dif - 1;
        }
        if (!SO.equalsIgnoreCase("")) {
            DAsignacionChipsDet det = new DAsignacionChipsDet();
            det.setPosicion("SO");
            det.setSeriechip(SO);
            slcDAsigChip.setColor("#41e63c");
            slcDAsigChip.getLisdet().add(det);
            SO = "";
        }
        if (!SC.equalsIgnoreCase("")) {
            DAsignacionChipsDet det = new DAsignacionChipsDet();
            det.setPosicion("SC");
            det.setSeriechip(SC);
            slcDAsigChip.setColor("#41e63c");
            slcDAsigChip.getLisdet().add(det);
            SC = "";
            taga = taga + 1;
            dif = dif - 1;
        }
        if (!SE.equalsIgnoreCase("")) {
            DAsignacionChipsDet det = new DAsignacionChipsDet();
            det.setPosicion("SE");
            det.setSeriechip(SE);
            slcDAsigChip.setColor("#41e63c");
            slcDAsigChip.getLisdet().add(det);
            SE = "";
            taga = taga + 1;
            dif = dif - 1;
        }
        ubsc = ubsc - 1;
        ubc = ubc + 1;
        grabar();
        RequestContext.getCurrentInstance().update("datos:listDasigna");
        RequestContext.getCurrentInstance().execute("PF('detDeasig').hide()");

    }

    @Override
    public void nuevo() {
        setDatoEdicion(new AsignacionChips());
        getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setIdsucursal(Integer.parseInt(Constantes.getIDSUCURSALGENERAL()));
        getDatoEdicion().setUsrcreacion(user.getIDUSUARIO());
        getDatoEdicion().setGinicio("");
        getDatoEdicion().setGfin("");
        getDatoEdicion().setEstado(1);
    }

    @Override
    public void grabar() {
        try {
            String idasig = asigDao.grabar(getDatoEdicion());
            getDatoEdicion().setIdasignacionchips(idasig);
            List<DAsignacionChips> nDeasig = new ArrayList<DAsignacionChips>();
            for (DAsignacionChips d : lstDAsigChips) {
                if (!d.getLisdet().isEmpty()) {
                    for (DAsignacionChipsDet det : d.getLisdet()) {
                        DAsignacionChips n = new DAsignacionChips();
                        n.setIdempresa(d.getIdempresa());
                        n.setIdsucursal(d.getIdsucursal());
                        n.setIdasignacionchips(d.getIdasignacionchips());
                        n.setIdzona(d.getIdzona());
                        n.setCordenadax(d.getCordenadax());
                        n.setCordenaday(d.getCordenaday());
                        n.setIdubicacion(d.getIdubicacion());
                        n.setCordenadaxt(d.getCordenadaxt());
                        n.setCordenadayt(d.getCordenadayt());
                        n.setEstadoasignacion(d.getEstadoasignacion());
                        n.setSeriechip(det.getSeriechip());
                        n.setPosicion(det.getPosicion());
                        n.setDesc(d.getDesc());
                        nDeasig.add(n);
                    }
                } else {
                    d.setSeriechip("");
                    nDeasig.add(d);
                }
            }
            dasigDao.grabar(getDatoEdicion(), nDeasig);
        } catch (Exception ex) {
            Logger.getLogger(AsignacionChipAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void changeFocus(String focusE) {
        switch (focusE) {
            case "NO": focusB= "NEB"; focus = "NE";
                break;
            case "NE": focusB= "SOB"; focus = "SO";
                break;
            case "SO": focusB= "SEB"; focus = "SE";
                break;
//         case "SE": focusB= "NOB";
//                break;
        }
    }

    public void resetSAsig() {
        for (DAsignacionChips da : lstDAsigChips) {
            if (da.getSeriechip() != null) {
                da.setEstadoasignacion(2);
                da.setColor("#f00");
                da.setSeriechip(null);
            }
        }
        RequestContext.getCurrentInstance().update("datos:listDasigna");
    }

    public void resetConfi() {
        for (DAsignacionChips da : lstDAsigChips) {
            if (da.getSeriechip() != null) {
                da.setEstadoasignacion(3);
                da.setColor("#41e63c");
            }
        }
        RequestContext.getCurrentInstance().update("datos:listDasigna");
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
            String idasig = asigDao.grabar(getDatoEdicion());
        } catch (Exception ex) {
            Logger.getLogger(AsignacionChipAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<DAsignacionChips> getLstDAsigChips() {
        return lstDAsigChips;
    }

    public void setLstDAsigChips(List<DAsignacionChips> lstDAsigChips) {
        this.lstDAsigChips = lstDAsigChips;
    }

    public DAsignacionChips getSlcDAsigChip() {
        return slcDAsigChip;
    }

    public void setSlcDAsigChip(DAsignacionChips slcDAsigChip) {
        this.slcDAsigChip = slcDAsigChip;
    }

    public List<Zona> getLstZona() {
        return lstZona;
    }

    public Zona getSlcZona() {
        return slcZona;
    }

    public void setSlcZona(Zona slcZona) {
        this.slcZona = slcZona;
    }

    public void setLstZona(List<Zona> lstZona) {
        this.lstZona = lstZona;
    }

    public UsuarioBean getUser() {
        return user;
    }

    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }

    public List<Multitabla> getListTipoRacks() {
        return listTipoRacks;
    }

    public void setListTipoRacks(List<Multitabla> listTipoRacks) {
        this.listTipoRacks = listTipoRacks;
    }

    public Integer getTipostr() {
        return tipostr;
    }

    public void setTipostr(Integer tipostr) {
        this.tipostr = tipostr;
    }

    public int getPansize() {
        return pansize;
    }

    public void setPansize(int pansize) {
        this.pansize = pansize;
    }

    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public String getNC() {
        return NC;
    }

    public void setNC(String NC) {
        this.NC = NC;
    }

    public String getNE() {
        return NE;
    }

    public void setNE(String NE) {
        this.NE = NE;
    }

    public String getCO() {
        return CO;
    }

    public void setCO(String CO) {
        this.CO = CO;
    }

    public String getCE() {
        return CE;
    }

    public void setCE(String CE) {
        this.CE = CE;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }

    public String getSC() {
        return SC;
    }

    public void setSC(String SC) {
        this.SC = SC;
    }

    public String getSE() {
        return SE;
    }

    public void setSE(String SE) {
        this.SE = SE;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public int getUbsc() {
        return ubsc;
    }

    public void setUbsc(int ubsc) {
        this.ubsc = ubsc;
    }

    public int getUbc() {
        return ubc;
    }

    public void setUbc(int ubc) {
        this.ubc = ubc;
    }

    public int getTaga() {
        return taga;
    }

    public void setTaga(int taga) {
        this.taga = taga;
    }

    public String getFocusB() {
        return focusB;
    }

    public void setFocusB(String focusB) {
        this.focusB = focusB;
    }

}
