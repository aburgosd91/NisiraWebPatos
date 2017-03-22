/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.DDreglaLlenadoGeneracionDao;
import com.nisira.core.dao.DGeneracionCodigoDao;
import com.nisira.core.dao.DreglaLlenadoGeneracionDao;
import com.nisira.core.dao.GeneracionCodigoDao;
import com.nisira.core.dao.ProcesosDao;
import com.nisira.core.dao.ReglaLlenadoDao;
import com.nisira.core.entity.DDreglaLlenadoGeneracion;
import com.nisira.core.entity.DGeneracionCodigo;
import com.nisira.core.entity.DreglaLlenadoGeneracion;
import com.nisira.core.entity.GeneracionCodigo;
import com.nisira.core.entity.Procesos;
import com.nisira.core.entity.ReglaLlenado;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "reglallenadoAction")
@SessionScoped
public class ReglaLlenadoAction extends AbstactListAction<ReglaLlenado> {

    private UsuarioBean user;
    private GeneracionCodigoDao genDao;
    private DGeneracionCodigoDao dgenDao;
    private ReglaLlenadoDao rgDao;
    private DreglaLlenadoGeneracionDao drgDao;
    private DDreglaLlenadoGeneracionDao ddrgdao;
    private List<GeneracionCodigo> lstgen;
    private int idgen;
    private List<DGeneracionCodigo> lstdgen;
    private List<DGeneracionCodigo> slclstdgen;
    private List<DreglaLlenadoGeneracion> lstdreglall;
    private DreglaLlenadoGeneracion dreglall;
    private DDreglaLlenadoGeneracion ddreglall;
    private String mensaje;
    private List<Procesos> listProces;
    private ProcesosDao proDao;
    private boolean num;
    private int nincio;
    private int nfin;

    public ReglaLlenadoAction() {
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        genDao = new GeneracionCodigoDao();
        dgenDao = new DGeneracionCodigoDao();
        rgDao = new ReglaLlenadoDao();
        drgDao = new DreglaLlenadoGeneracionDao();
        ddrgdao = new DDreglaLlenadoGeneracionDao();
        lstgen = new ArrayList<GeneracionCodigo>();
        idgen = 0;
        lstdgen = new ArrayList<DGeneracionCodigo>();
        slclstdgen = new ArrayList<DGeneracionCodigo>();
        lstdreglall = new ArrayList<DreglaLlenadoGeneracion>();
        dreglall = new DreglaLlenadoGeneracion();
        ddreglall = new DDreglaLlenadoGeneracion();
        mensaje = "";
        listProces = new ArrayList<Procesos>();
        proDao = new ProcesosDao();
        num = false;
        nincio = 0;
        nfin = 0;
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_ReglaLlenado");
            setListaDatos(rgDao.findAll(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL()));
            RequestContext.getCurrentInstance().update("datos:");
            
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        genDao = new GeneracionCodigoDao();
        dgenDao = new DGeneracionCodigoDao();
        rgDao = new ReglaLlenadoDao();
        drgDao = new DreglaLlenadoGeneracionDao();
        ddrgdao = new DDreglaLlenadoGeneracionDao();
        lstgen = new ArrayList<GeneracionCodigo>();
        idgen = 0;
        lstdgen = new ArrayList<DGeneracionCodigo>();
        slclstdgen = new ArrayList<DGeneracionCodigo>();
        lstdreglall = new ArrayList<DreglaLlenadoGeneracion>();
        dreglall = new DreglaLlenadoGeneracion();
        ddreglall = new DDreglaLlenadoGeneracion();
        mensaje = "";
        listProces = new ArrayList<Procesos>();
        proDao = new ProcesosDao();
        num = false;
        actualiza_ventana("wMnt_ReglaLlenado");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new ReglaLlenado());
        getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setIdsucursal(Integer.parseInt(Constantes.IDSUCURSALGENERAL));
        getDatoEdicion().setEstado(1);
    }

    public void findDetalle() throws Exception {
        listProces = proDao.findAll(user.getIDEMPRESA());
        if (getDatoEdicion().getIdreglas() != null) {
            lstgen = genDao.findByIdProceso(user.getIDEMPRESA(), getDatoEdicion().getIdproceso());
            lstdreglall = drgDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdreglas());
            idgen = lstdreglall.get(0).getIdgeneracion();
            lstdgen = dgenDao.findAll(getDatoEdicion().getIdempresa(), idgen);
            for (DreglaLlenadoGeneracion d : lstdreglall) {
                d.setParametro(lstdgen.stream().filter((dg)->dg.getIDREGISTROCODIGO().equalsIgnoreCase(String.valueOf(d.getIdregistrocodigo()))).findAny().get().getPARAMETRO());
                d.setLstddreglallenado(ddrgdao.findAll(d.getIdempresa(), d.getIdsucursal(), d.getIdreglas(), d.getIdgeneracion(), d.getIdregistrocodigo()));
            }
        }
    }

    public void onProcesoSelect() throws Exception {
        lstgen = genDao.findByIdProceso(user.getIDEMPRESA(), getDatoEdicion().getIdproceso());
    }

    public void onGenSelect() throws Exception {
        lstdgen = dgenDao.findAll(getDatoEdicion().getIdempresa(), idgen);
        lstdreglall = drgDao.findAll(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdsucursal(), getDatoEdicion().getIdreglas(), idgen);
        for (DreglaLlenadoGeneracion d : lstdreglall) {
            d.setLstddreglallenado(ddrgdao.findAll(d.getIdempresa(), d.getIdsucursal(), d.getIdreglas(), d.getIdgeneracion(), d.getIdregistrocodigo()));
        }
        RequestContext.getCurrentInstance().update("datos:tbldrgl");
    }

    public void llenarNumeros() {
        if (dreglall != null) {
            dreglall.setDinicio(nincio);
            dreglall.setDfin(nfin);
        }
    }

    public void llenarDreglal() {
        int i = 0;
        for (DGeneracionCodigo d : slclstdgen) {
            DreglaLlenadoGeneracion dg = new DreglaLlenadoGeneracion();
            dg.setIdempresa(Integer.parseInt(d.getIDEMPRESA()));
            dg.setIdsucursal(getDatoEdicion().getIdsucursal());
            dg.setIdgeneracion(Integer.parseInt(d.getIDGENERACION()));
            dg.setIdregistrocodigo(Integer.parseInt(d.getIDREGISTROCODIGO()));
            dg.setDinicio(i + 1);
            dg.setDfin(d.getNUMDIGITO() + i);
            dg.setParametro(d.getPARAMETRO());
            d.setSeleccionado(1);
            dg.setLstddreglallenado(new ArrayList<DDreglaLlenadoGeneracion>());
            lstdreglall.add(dg);
            i = i + d.getNUMDIGITO();
        }
        RequestContext.getCurrentInstance().execute("PF('dgendialog').hide()");
    }

    @Override
    public void grabar() {
        try {
            String idregla = rgDao.grabar(getDatoEdicion());
            drgDao.grabar(idregla, lstdreglall);
            for (DreglaLlenadoGeneracion d : lstdreglall) {
                ddrgdao.grabar(idregla, d.getLstddreglallenado());
            }
        } catch (Exception ex) {
            Logger.getLogger(ReglaLlenadoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onRowSelectDGeneracionCodigo(SelectEvent event) throws IOException {
        nincio = dreglall.getDinicio();
        nfin = dreglall.getDfin();
        RequestContext.getCurrentInstance().update("datos:numeros");
    }

    public void onRowUnselectDGeneracionCodigo(UnselectEvent event) throws IOException {
        nincio = 0;
        nfin = 0;
        RequestContext.getCurrentInstance().update("datos:numeros");
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
            String idregla = rgDao.grabar(getDatoEdicion());
        } catch (Exception ex) {
            Logger.getLogger(ReglaLlenadoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verValores(int i) {
        dreglall = lstdreglall.get(i);
        RequestContext.getCurrentInstance().update("ddform:lstddgr");
        RequestContext.getCurrentInstance().execute("PF('dialogVal').show()");
    }

    public void addValores() {
        DDreglaLlenadoGeneracion dd = new DDreglaLlenadoGeneracion();
        dd.setIdempresa(dreglall.getIdempresa());
        dd.setIdsucursal(dreglall.getIdsucursal());
        dd.setIdreglas(dreglall.getIdreglas());
        dd.setIdgeneracion(dreglall.getIdgeneracion());
        dd.setIdregistrocodigo(dreglall.getIdregistrocodigo());
        if (dreglall.getLstddreglallenado().isEmpty()) {
            dd.setItem(1);
        } else {
            dd.setItem(dreglall.getLstddreglallenado().size() + 1);
        }
        dreglall.getLstddreglallenado().add(dd);
        RequestContext.getCurrentInstance().update("ddform:lstddgr");
    }

    public List<GeneracionCodigo> getLstgen() {
        return lstgen;
    }

    public void setLstgen(List<GeneracionCodigo> lstgen) {
        this.lstgen = lstgen;
    }

    public int getIdgen() {
        return idgen;
    }

    public void setIdgen(int idgen) {
        this.idgen = idgen;
    }

    public List<DGeneracionCodigo> getLstdgen() {
        return lstdgen;
    }

    public void setLstdgen(List<DGeneracionCodigo> lstdgen) {
        this.lstdgen = lstdgen;
    }

    public List<DGeneracionCodigo> getSlclstdgen() {
        return slclstdgen;
    }

    public void setSlclstdgen(List<DGeneracionCodigo> slclstdgen) {
        this.slclstdgen = slclstdgen;
    }

    public List<DreglaLlenadoGeneracion> getLstdreglall() {
        return lstdreglall;
    }

    public void setLstdreglall(List<DreglaLlenadoGeneracion> lstdreglall) {
        this.lstdreglall = lstdreglall;
    }

    public DreglaLlenadoGeneracion getDreglall() {
        return dreglall;
    }

    public void setDreglall(DreglaLlenadoGeneracion dreglall) {
        this.dreglall = dreglall;
    }

    public DDreglaLlenadoGeneracion getDdreglall() {
        return ddreglall;
    }

    public void setDdreglall(DDreglaLlenadoGeneracion ddreglall) {
        this.ddreglall = ddreglall;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Procesos> getListProces() {
        return listProces;
    }

    public void setListProces(List<Procesos> listProces) {
        this.listProces = listProces;
    }

    public boolean isNum() {
        return num;
    }

    public void setNum(boolean num) {
        this.num = num;
    }

    public int getNincio() {
        return nincio;
    }

    public void setNincio(int nincio) {
        this.nincio = nincio;
    }

    public int getNfin() {
        return nfin;
    }

    public void setNfin(int nfin) {
        this.nfin = nfin;
    }

}
