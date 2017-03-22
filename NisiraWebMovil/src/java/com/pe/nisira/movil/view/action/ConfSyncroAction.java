/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.CONFIGTABLASINCRODao;
import com.nisira.core.entity.CONFIGTABLASINCRO;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;        
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "confSyncroAction")
@SessionScoped
public class ConfSyncroAction extends AbstactListAction<CONFIGTABLASINCRO> implements Serializable {
    
    private List<CONFIGTABLASINCRO> pendTablas;
    private List<CONFIGTABLASINCRO> instTablas;
    private CONFIGTABLASINCRODao confDao;
    private UsuarioBean user;
    
    public ConfSyncroAction() {
        pendTablas = new ArrayList<CONFIGTABLASINCRO>();
        instTablas = new ArrayList<CONFIGTABLASINCRO>();
        confDao = new CONFIGTABLASINCRODao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_ConfSyncro");
    }
    
    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_ConfSyncro");
            setLadd(2);
            setListaDatos(confDao.findAll(user.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(ConfSyncroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getIniciar() {        
        pendTablas = new ArrayList<CONFIGTABLASINCRO>();
        instTablas = new ArrayList<CONFIGTABLASINCRO>();
        confDao = new CONFIGTABLASINCRODao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_ConfSyncro");
        return "";
    }
    
    @Override
    public void nuevo() {
        try {
            pendTablas = confDao.findAll();
            instTablas = new ArrayList<CONFIGTABLASINCRO>();
            Iterator<CONFIGTABLASINCRO> it = pendTablas.iterator();
            while (it.hasNext()) {
                CONFIGTABLASINCRO i = it.next();
                for (CONFIGTABLASINCRO c : getListaDatos()) {
                    if (c.getIDTABLASINCRO() == i.getIDTABLASINCRO()) {
                        it.remove();
                        break;
                    }
                }
            }
            RequestContext.getCurrentInstance().update("datos:listaPend");
            RequestContext.getCurrentInstance().execute("PF('diagTab').show()");
        } catch (Exception ex) {
            Logger.getLogger(ConfSyncroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void doVerLista() throws IOException {
        setLadd(1);
        RequestContext.getCurrentInstance().update("datos");
        
    }
    @Override
    public void doNuevo() throws IOException {        
        nuevo();
    }
    
    public void addTablas() {
        for (CONFIGTABLASINCRO c : instTablas) {
            c.setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
            c.setTIPOSINCRO(1);
            c.setUPDOWN(1);
            c.setESTADO(1);
            getListaDatos().add(c);
        }
        setFiltroDatos(getListaDatos());
        RequestContext.getCurrentInstance().update("datos");
        RequestContext.getCurrentInstance().execute("PF('diagTab').hide()");
    }
    
    @Override
    public void grabar() {
        try {
            confDao.grabar(getListaDatos(), user.getIDEMPRESA());
        } catch (Exception ex) {
            Logger.getLogger(ConfSyncroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<CONFIGTABLASINCRO> getPendTablas() {
        return pendTablas;
    }
    
    public void setPendTablas(List<CONFIGTABLASINCRO> pendTablas) {
        this.pendTablas = pendTablas;
    }
    
    public List<CONFIGTABLASINCRO> getInstTablas() {
        return instTablas;
    }
    
    public void setInstTablas(List<CONFIGTABLASINCRO> instTablas) {
        this.instTablas = instTablas;
    }
    
}
