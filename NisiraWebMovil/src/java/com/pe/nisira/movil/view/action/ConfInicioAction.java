/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.CONFIGTABLASINCRO;
import com.nisira.core.entity.ConfigWeb;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable; 
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
@ManagedBean(name = "confInicioAction")
@SessionScoped
public class ConfInicioAction extends AbstactListAction<ConfigWeb> implements Serializable {
    
    private UsuarioBean user;
    private boolean existe;
    public ConfInicioAction() {
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        existe = false;
        actualiza_ventana("wMnt_ConfInicio");
    }
    
    @Override
    public void buscarTodo() {
        try {
            setLadd(2);
            String [] array =Constantes.LlenarConfig();
            if(array!=null){
                ConfigWeb web = new ConfigWeb();
                web.setIdempresa(Integer.parseInt(array[0]));
                web.setIdsucursal(Integer.parseInt(array[1]));
                web.setDisco(array[2]);
                web.setPath(array[3]);
                web.setImgplant(array[4]);
                setDatoEdicion(web);
            }else{
                existe=true;
            }
        } catch (Exception ex) {
            Logger.getLogger(ConfInicioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getIniciar() {        
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        existe = false;
        actualiza_ventana("wMnt_ConfInicio");
        return "";
    }
    
    @Override
    public void nuevo() {
        try {
            if(!existe){
                Constantes.configWeb=getDatoEdicion();
                if(Constantes.CrearConfigOrigen())
                    WebUtil.MensajeAdvertencia("");
            }
            RequestContext.getCurrentInstance().update("datos:listaPend");
        } catch (Exception ex) {
            Logger.getLogger(ConfInicioAction.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public void grabar() {
        try {
            if(!existe){
                Constantes.configWeb=getDatoEdicion();
                if(Constantes.CrearConfigOrigen())
                    WebUtil.MensajeAdvertencia("Se guardo correctamente");
            }
        } catch (Exception ex) {
            Logger.getLogger(ConfInicioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}
