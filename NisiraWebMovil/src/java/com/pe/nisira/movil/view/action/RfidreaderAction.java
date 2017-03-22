/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AntenaDao;
import com.nisira.core.dao.CpuMovilDao;
import com.nisira.core.dao.EquipoDao;
import com.nisira.core.dao.PuertoDestinoDao;
import com.nisira.core.dao.PuertocomDao;
import com.nisira.core.dao.RfidreaderDao;
import com.nisira.core.entity.Antena;
import com.nisira.core.entity.CpuMovil;
import com.nisira.core.entity.Dantena;
import com.nisira.core.entity.Dpuertocom;
import com.nisira.core.entity.Equipo;
import com.nisira.core.entity.Puertocom;
import com.nisira.core.entity.Rfidreader;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
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
@ManagedBean(name = "rfidreaderAction")
@SessionScoped
public class RfidreaderAction extends AbstactListAction<Rfidreader> implements Serializable {

    private RfidreaderDao rfdao;
    private List<Dantena> lstdantenas;
    private List<CpuMovil> lstcpumovil;
    private List<Antena> lstantena;
    private CpuMovil slccpumovil;
    private Antena slcantena;
    private List<Dpuertocom> lstdpuertocom;
    private List<Puertocom> lstpuertocom;
    private Puertocom slcpuertocom;
    private Dantena slcdantena;
    private Dpuertocom slcdpuertocom;
    private String mensaje;
    private UsuarioBean user;

    public RfidreaderAction() {
        rfdao = new RfidreaderDao();
        lstdantenas = new ArrayList<Dantena>();
        lstdpuertocom = new ArrayList<Dpuertocom>();
        lstcpumovil = new ArrayList<CpuMovil>();
        lstantena = new ArrayList<Antena>();
        slccpumovil = new CpuMovil();
        slcdantena = new Dantena();
        slcdpuertocom = new Dpuertocom();
        slcpuertocom = new Puertocom();
        slcantena = new Antena();
        lstpuertocom = new ArrayList<Puertocom>();
        mensaje = "";
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Rfidread");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_Rfidread");
            setListaDatos(rfdao.findAll(user.getIDEMPRESA()));
            setLstcpumovil((new CpuMovilDao()).findAll(Constantes.IDEMPRESAGENERAL));
        } catch (Exception ex) {
            Logger.getLogger(RfidreaderAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        rfdao = new RfidreaderDao();
        lstdantenas = new ArrayList<Dantena>();
        lstdpuertocom = new ArrayList<Dpuertocom>();
        slcdantena = new Dantena();
        slcdpuertocom = new Dpuertocom();
        setSlccpumovil(new CpuMovil());
        slcpuertocom = new Puertocom();
        setSlcantena(new Antena());
        lstpuertocom = new ArrayList<Puertocom>();
        mensaje = "";
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Rfidread");
        return "";
    }
    public void findDetalles(){
        if(getDatoEdicion().getIdequiporeader()!=0){
            try {
                lstdantenas = rfdao.findDAntenas(user.getIDEMPRESA(),getDatoEdicion().getIdequiporeader());
                lstdpuertocom = rfdao.findDpuertos(user.getIDEMPRESA(),getDatoEdicion().getIdequiporeader());
                setLstcpumovil((new CpuMovilDao()).findAll(Constantes.IDEMPRESAGENERAL));
                setSlccpumovil(getLstcpumovil().stream().filter((e)->e.getIdcpumovil() == getDatoEdicion().getIdcpumovil()).findAny().get());
            } catch (Exception ex) {
                Logger.getLogger(RfidreaderAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void verDiaglogPort() throws Exception {
        lstpuertocom = (new PuertocomDao()).findAll(user.getIDEMPRESA());
        Iterator<Puertocom> it = lstpuertocom.iterator();
        while (it.hasNext()) {
            Puertocom i = it.next();
            for (Dpuertocom c : lstdpuertocom) {
                if (c.getIdpuertocom() == i.getIdpuertocom()) {
                    it.remove();
                    break;
                }
            }
        }
        RequestContext.getCurrentInstance().update("datos:tblP");
        RequestContext.getCurrentInstance().execute("PF('dlgPort').show()");
    }

    public void addDpuertoCom() {
        Dpuertocom d = new Dpuertocom();
        d.setIdempresa(slcpuertocom.getIdempresa());
        d.setIdpuertocom(slcpuertocom.getIdpuertocom());
        d.setOrden(lstdpuertocom.size()+1);
        d.setActivo(1);
        d.setDescripcion(slcpuertocom.getDescripcion());
        d.setIdcpumovil(slccpumovil.getIdcpumovil());
        lstdpuertocom.add(d);
        RequestContext.getCurrentInstance().update("datos:lstpcom");
        RequestContext.getCurrentInstance().execute("PF('dlgPort').hide()");
    }
    public void deleteDpuertoCom(){
        if(slcdpuertocom != null){
            lstdpuertocom.remove(slcdpuertocom);
        }else{
            WebUtil.MensajeAdvertencia("Seleccione detalle de Puerto de Com");
        }
        
    }
    public void verDiaglogEpg() throws Exception {
        setLstantena((new AntenaDao()).findAll(Constantes.IDEMPRESAGENERAL));
        Iterator<Antena> it = getLstantena().iterator();
        while (it.hasNext()) {
            Antena i = it.next();
            for (Dantena c : lstdantenas) {
                if (c.getIdequipoantena() == i.getIdantena()) {
                    it.remove();
                    break;
                }
            }
        }
        RequestContext.getCurrentInstance().update("datos:tblEg");
        RequestContext.getCurrentInstance().execute("PF('dlgEquipog').show()");
    }

    public void addDantena() {
        Dantena d = new Dantena();
        d.setIdempresa(getSlcantena().getIdempresa());
        d.setIdequipoantena(getSlcantena().getIdantena());
        d.setOrden(lstdantenas.size()+1);
        d.setActivo(1);
        d.setDescripcion(getSlcantena().getDescripcion());
        lstdantenas.add(d);
        RequestContext.getCurrentInstance().update("datos:lstdant");
        RequestContext.getCurrentInstance().execute("PF('dlgEquipog').hide()");
    }
    public void deleteDantena(){
        if(slcdantena != null){
            lstdantenas.remove(slcdantena);
        }else{
            WebUtil.MensajeAdvertencia("Seleccione detalle de antena");
        }
    }
    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new Rfidreader());
        getDatoEdicion().setEstado(1);
        getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
    }

    @Override
    public void grabar() {
        try {
            getDatoEdicion().setIdcpumovil(slccpumovil.getIdcpumovil());
            rfdao.grabar(getDatoEdicion(), lstdpuertocom, lstdantenas);
        } catch (Exception ex) {
            Logger.getLogger(RfidreaderAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Dantena> getLstdantenas() {
        return lstdantenas;
    }

    public void setLstdantenas(List<Dantena> lstdantenas) {
        this.lstdantenas = lstdantenas;
    }

    public List<Dpuertocom> getLstdpuertocom() {
        return lstdpuertocom;
    }

    public void setLstdpuertocom(List<Dpuertocom> lstdpuertocom) {
        this.lstdpuertocom = lstdpuertocom;
    }

    public Dantena getSlcdantena() {
        return slcdantena;
    }

    public void setSlcdantena(Dantena slcdantena) {
        this.slcdantena = slcdantena;
    }

    public Dpuertocom getSlcdpuertocom() {
        return slcdpuertocom;
    }

    public void setSlcdpuertocom(Dpuertocom slcdpuertocom) {
        this.slcdpuertocom = slcdpuertocom;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Puertocom> getLstpuertocom() {
        return lstpuertocom;
    }

    public void setLstpuertocom(List<Puertocom> lstpuertocom) {
        this.lstpuertocom = lstpuertocom;
    }

    public Puertocom getSlcpuertocom() {
        return slcpuertocom;
    }

    public void setSlcpuertocom(Puertocom slcpuertocom) {
        this.slcpuertocom = slcpuertocom;
    }

    /**
     * @return the slccpumovil
     */
    public CpuMovil getSlccpumovil() {
        return slccpumovil;
    }

    /**
     * @param slccpumovil the slccpumovil to set
     */
    public void setSlccpumovil(CpuMovil slccpumovil) {
        this.slccpumovil = slccpumovil;
    }

    /**
     * @return the lstcpumovil
     */
    public List<CpuMovil> getLstcpumovil() {
        return lstcpumovil;
    }

    /**
     * @param lstcpumovil the lstcpumovil to set
     */
    public void setLstcpumovil(List<CpuMovil> lstcpumovil) {
        this.lstcpumovil = lstcpumovil;
    }

    /**
     * @return the slcantena
     */
    public Antena getSlcantena() {
        return slcantena;
    }

    /**
     * @param slcantena the slcantena to set
     */
    public void setSlcantena(Antena slcantena) {
        this.slcantena = slcantena;
    }

    /**
     * @return the lstantena
     */
    public List<Antena> getLstantena() {
        return lstantena;
    }

    /**
     * @param lstantena the lstantena to set
     */
    public void setLstantena(List<Antena> lstantena) {
        this.lstantena = lstantena;
    }

}
