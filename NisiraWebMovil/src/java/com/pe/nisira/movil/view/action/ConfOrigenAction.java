/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.CONFOGDao;
import com.nisira.core.dao.EmpresaDao;
import com.nisira.core.dao.MontacargaDao;
import com.nisira.core.dao.SucursalDao;
import com.nisira.core.entity.CONFOG;
import com.nisira.core.entity.Empresa;
import com.nisira.core.entity.Sucursal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "confOrigenAction")
@SessionScoped
public class ConfOrigenAction extends AbstactListAction<CONFOG> implements Serializable {

    private CONFOGDao confogDao;
    private List<Empresa> lstemp;
    private EmpresaDao empdao;
    private List<Sucursal> lstsuc;
    private SucursalDao sucDao;

    public ConfOrigenAction() {
        confogDao = new CONFOGDao();
        lstemp = new ArrayList<Empresa>();
        empdao = new EmpresaDao();
        lstsuc = new ArrayList<Sucursal>();
        sucDao = new SucursalDao();
        actualiza_ventana("wMnt_ConfOrigen");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(confogDao.findAll());
        } catch (Exception ex) {
            Logger.getLogger(ConfOrigenAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void findet() {
        try {
            lstemp = empdao.findAll();
            if (getDatoEdicion().getIDOGCONFIG() != 0) {
                lstsuc = sucDao.findbyEmpresa(getDatoEdicion().getIDEMPRESA());
            }
        } catch (Exception ex) {
            Logger.getLogger(ConfIniAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        confogDao = new CONFOGDao();
        lstemp = new ArrayList<Empresa>();
        empdao = new EmpresaDao();
        lstsuc = new ArrayList<Sucursal>();
        sucDao = new SucursalDao();
        actualiza_ventana("wMnt_ConfOrigen");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new CONFOG());
    }

    @Override
    public void grabar() {
        try {
            confogDao.grabar(getDatoEdicion());
        } catch (Exception ex) {
            Logger.getLogger(ConfOrigenAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void onEmpresaSelect() {
        try {
            lstsuc = sucDao.findbyEmpresa(getDatoEdicion().getIDEMPRESA());
        } catch (Exception ex) {
            Logger.getLogger(ConfIniAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empresa> getLstemp() {
        return lstemp;
    }

    public void setLstemp(List<Empresa> lstemp) {
        this.lstemp = lstemp;
    }

    public List<Sucursal> getLstsuc() {
        return lstsuc;
    }

    public void setLstsuc(List<Sucursal> lstsuc) {
        this.lstsuc = lstsuc;
    }

}
