/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.CONFINICIODao;
import com.nisira.core.dao.EmpresaDao;
import com.nisira.core.dao.MontacargaDao;
import com.nisira.core.dao.SucursalDao;
import com.nisira.core.entity.CONFINICIO;
import com.nisira.core.entity.Empresa;
import com.nisira.core.entity.Montacarga;
import com.nisira.core.entity.Sucursal;
import com.pe.nisira.movil.view.util.Encryption;
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
@ManagedBean(name = "confIniAction")
@SessionScoped
public class ConfIniAction extends AbstactListAction<CONFINICIO> implements Serializable {

    private CONFINICIODao confinidao;
    private List<Empresa> lstemp;
    private EmpresaDao empdao;
    private List<Sucursal> lstsuc;
    private List<Montacarga> lstmont;
    private SucursalDao sucDao;
    public ConfIniAction() {
        confinidao = new CONFINICIODao();
        lstemp = new ArrayList<Empresa>();
        empdao = new EmpresaDao();
        lstsuc = new ArrayList<Sucursal>();
        lstmont = new ArrayList<Montacarga>();
        sucDao = new SucursalDao();
        actualiza_ventana("wMnt_ConfInicial");
    }

    @Override
    public void buscarTodo() {
        try {           
            setListaDatos(confinidao.findAll());
        } catch (Exception ex) {
            Logger.getLogger(ConfIniAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void findet(){
        try {
            lstemp = empdao.findAll();
            if(getDatoEdicion().getIDCONFIG() !=0){
                lstsuc = sucDao.findbyEmpresa(getDatoEdicion().getIDEMPRESA());
                lstmont = (new MontacargaDao()).findAll(getDatoEdicion().getIDEMPRESA());
            }
        } catch (Exception ex) {
            Logger.getLogger(ConfIniAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getIniciar() {
        confinidao = new CONFINICIODao();
        lstemp = new ArrayList<Empresa>();
        empdao = new EmpresaDao();
        lstsuc = new ArrayList<Sucursal>();
        lstmont = new ArrayList<Montacarga>();
        sucDao = new SucursalDao();
        actualiza_ventana("wMnt_ConfInicial");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new CONFINICIO());
    }

    @Override
    public void grabar() {
        try {
            String us = Encryption.encrypt(getDatoEdicion().getUSUARIO());
            String pass = Encryption.encrypt(getDatoEdicion().getCLAVE());
            getDatoEdicion().setUSUARIO(us);
            getDatoEdicion().setCLAVE(pass);
            confinidao.grabar(getDatoEdicion());
        } catch (Exception ex) {
            Logger.getLogger(ConfIniAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void onEmpresaSelect(){
        try {
            lstsuc = sucDao.findbyEmpresa(getDatoEdicion().getIDEMPRESA());
            lstmont = (new MontacargaDao()).findAll(getDatoEdicion().getIDEMPRESA());
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

    public List<Montacarga> getLstmont() {
        return lstmont;
    }

    public void setLstmont(List<Montacarga> lstmont) {
        this.lstmont = lstmont;
    }

}
