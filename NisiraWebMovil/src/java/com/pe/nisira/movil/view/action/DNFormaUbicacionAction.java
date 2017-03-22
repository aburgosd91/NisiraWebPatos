/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.DAlmacen_ColumnasDao;
import com.nisira.core.dao.DDNFormaUbicacionDao;
import com.nisira.core.dao.DDistribucionUbicacionDao;
import com.nisira.core.dao.DNForma_UbicacionDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Combos;
import com.nisira.core.entity.DDNFormaUbicacion;
import com.nisira.core.entity.DDistribucionUbicacion;
import com.nisira.core.entity.DNFormaUbicacion;
import com.nisira.core.entity.Dreglas;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Reglas;
import com.nisira.core.service.MultitablaService;
import com.nisira.core.service.ReglasService;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author alex burgos
 */
@ManagedBean(name = "dNFormaUbicacionAction")
@SessionScoped
public class DNFormaUbicacionAction extends AbstactListAction<DNFormaUbicacion> implements Serializable {
    private List<Almacen> listAlmacen;
    private List<DDistribucionUbicacion> listDDistribucionUbicacion;
    private List<DNFormaUbicacion> listDNFormaUbicacion;
    private List<DDNFormaUbicacion> listDDNFormaUbicacion;
    private String mensaje;
    private UsuarioBean user;
    private DDNFormaUbicacion selectDDNFormaUbicacion;
    private List<Combos> listaFilaxColumna;
    private Combos selectFilaxColumna;
    private int posicion;
    private List<Integer> arregloTemp;
    public DNFormaUbicacionAction() {
        listaFilaxColumna =new ArrayList<Combos>();
        listAlmacen = new ArrayList<Almacen>();
        listDDistribucionUbicacion =new ArrayList<DDistribucionUbicacion>();
        listDNFormaUbicacion =new ArrayList<DNFormaUbicacion>();
        listDDNFormaUbicacion=new ArrayList<DDNFormaUbicacion>();
        selectDDNFormaUbicacion =new DDNFormaUbicacion();
        setDatoSeleccionado(new DNFormaUbicacion());
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_DNFormaUbicacion");
        arregloTemp = new ArrayList<Integer>();
        mensaje = null;
    }

    @Override
    public void buscarTodo() {
        try {             
            getIniciar();
            listDNFormaUbicacion = (new DNForma_UbicacionDao()).findAllAlmacen(Constantes.IDEMPRESAGENERAL,Constantes.IDSUCURSALGENERAL);
            actualiza_ventana("wMnt_DNFormaUbicacion");
            setListaDatos((new DNForma_UbicacionDao()).findAllAlmacen(Constantes.IDEMPRESAGENERAL,Constantes.IDSUCURSALGENERAL));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        setDatoSeleccionado(new DNFormaUbicacion());
        listDDNFormaUbicacion = new ArrayList<DDNFormaUbicacion>();
        selectDDNFormaUbicacion = new DDNFormaUbicacion();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = null;
        actualiza_ventana("wMnt_DNFormaUbicacion");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new DNFormaUbicacion());
        getDatoEdicion().setESTADO(1);
        getDatoEdicion().setIDEMPRESA(Constantes.IDEMPRESAGENERAL);
        getDatoEdicion().setIDSUCURSAL(Constantes.IDSUCURSALGENERAL);
    }

    @Override
    public void grabar() {
        try{
            /*VALIDAR INGRESO*/
            if(getDatoEdicion().getIDEMPRESA()==null){
                this.mensaje = "Empresa no asignada";
                WebUtil.MensajeError(this.mensaje);
            }else if(getDatoEdicion().getIDSUCURSAL()==null){
                this.mensaje = "Sucursal no asignado";
                WebUtil.MensajeError(this.mensaje);
            }else if(getDatoEdicion().getIDALMACEN()==null){
                this.mensaje = "Almacen no asignado";
                WebUtil.MensajeError(this.mensaje);
            }else if(getDatoEdicion().getDESCRIPCION()==null){
                this.mensaje = "El campo descripción se encuentra vacio";
                WebUtil.MensajeError(this.mensaje);
            }else if(getDatoEdicion().getFILAS()==0){
                this.mensaje="Número de Filas mayor a 0";
                WebUtil.MensajeError(getMensaje());
            }else if(getDatoEdicion().getCOLUMNAS()==0){
                this.mensaje="Número de Columnas mayor a 0";
                WebUtil.MensajeError(getMensaje());
            }else{
                if (getDatoEdicion().getIDNFORMACIONUBICACION() == null) {
                    (new DNForma_UbicacionDao()).addXmlDNFormaUbicacionDetalle(getDatoEdicion(), listDDNFormaUbicacion);
                } else {
                    (new DNForma_UbicacionDao()).editXmlDNFormaUbicacionDetalle(getDatoEdicion(), listDDNFormaUbicacion);
                }
            }
        }catch(Exception ex){
            this.mensaje = ex.getMessage();
            WebUtil.MensajeError(this.mensaje);
        }
    }
    
    public void onFilaxDistribucionChange() throws Exception {
        getDatoEdicion().setFILAS(selectFilaxColumna.getFilas());
        getDatoEdicion().setCOLUMNAS(selectFilaxColumna.getColumnas());
        RequestContext.getCurrentInstance().update("datos:filas");
        RequestContext.getCurrentInstance().update("datos:columnas");
        return;
    }
    /*DISTRIBUCION POR RACK*/
    public void filaColumnaSeleccionado() {
        try{
            int pos=listDDNFormaUbicacion.indexOf(selectDDNFormaUbicacion);
            posicion=0;
            int temp=0;
            /*ACCION DE SELECCION*/
            if(selectDDNFormaUbicacion.isSELECCIONADO()){
                selectDDNFormaUbicacion.setSELECCIONADO(false);
                if(listDDNFormaUbicacion.get(pos).getPRIORIDAD()!=0){
                    arregloTemp.remove(arregloTemp.indexOf(listDDNFormaUbicacion.get(pos).getPRIORIDAD()));
                    selectDDNFormaUbicacion.setPRIORIDAD(0);
                }
            }
            else{
                selectDDNFormaUbicacion.setSELECCIONADO(true);
                /*VERIFICAR SI HAY ELEMENTOS EN EL ARREGLO*/
                if(arregloTemp.size()>0){
                   /*ORDENAR ARREGLO ASCENDENTE*/
                    for(int i=0;i<arregloTemp.size()-1;i++){
                        for(int j=i+1;j<arregloTemp.size();j++){
                            if(arregloTemp.get(i)>arregloTemp.get(j)){
                                temp=arregloTemp.get(i);
                                arregloTemp.set(i, arregloTemp.get(j));
                                arregloTemp.set(j, temp);
                            }
                        }
                    }
                    posicion=obtenerPosicion(arregloTemp);
                }
                else{
                    posicion++;
                }
                arregloTemp.add(posicion);
                selectDDNFormaUbicacion.setPRIORIDAD(posicion);
            }
            listDDNFormaUbicacion.set(pos,selectDDNFormaUbicacion);
            RequestContext.getCurrentInstance().update("datos:listDDNFormaUbicacion");
            RequestContext.getCurrentInstance().update("datos:listDDNFormaUbicacion:cuadroNivel");
            RequestContext.getCurrentInstance().update("datos:listDDNFormaUbicacion:cuadroNivel:numerador");
        }catch(Exception ex){
            
        }
        return ;
    }
    public int obtenerPosicion(List<Integer> arreglo){
        int pos=0;boolean t=true;
        for(int i=0;i<arreglo.size() & t;i++){
            if(i>0){
                if(arreglo.get(i)-arreglo.get(i-1)>1){
                    t=false;
                    pos=arreglo.get(i-1)+1;
                }
            }
            else{
                if(arreglo.get(i)!=1){
                    t=false;
                    pos=1;
                }
            }
        }
        if(pos==0)
            pos=arreglo.get(arreglo.size()-1)+1;
        return pos;
    }
    public void onSelectionAlmacen()throws Exception{
        listDDistribucionUbicacion =(new DDistribucionUbicacionDao()).findDistActivos(Constantes.IDEMPRESAGENERAL,Constantes.IDSUCURSALGENERAL, getDatoEdicion().getIDALMACEN());
        /************************************OPCIONAL***************************************/
        listaFilaxColumna = (new DAlmacen_ColumnasDao()).cboRackFilasColumnas(Constantes.IDEMPRESAGENERAL,Constantes.IDSUCURSALGENERAL, getDatoEdicion().getIDALMACEN(), listDDistribucionUbicacion.get(0).getIDDISTRIBUCION(),"001", "001", "001");
        RequestContext.getCurrentInstance().update("datos:iddistribucion");
        RequestContext.getCurrentInstance().update("datos:listaFilaxColumna");
    }
    public void onSelectionDistribucion()throws Exception{
        listaFilaxColumna = (new DAlmacen_ColumnasDao()).cboRackFilasColumnas(Constantes.IDEMPRESAGENERAL,Constantes.IDSUCURSALGENERAL, getDatoEdicion().getIDALMACEN(), getDatoEdicion().getIDDISTRIBUCION(),"001", "001", "001");
        RequestContext.getCurrentInstance().update("datos:listaFilaxColumna");
    }
    
    public void newDDNFormaUbicacion() {
        /*NUEVO DETALLE*/
        try{
            if(getDatoEdicion().getFILAS()==0){
                this.mensaje="Número de Filas mayor a 0";
                WebUtil.MensajeError(getMensaje());
            }else if(getDatoEdicion().getCOLUMNAS()==0){
                this.mensaje="Número de Columnas mayor a 0";
                WebUtil.MensajeError(getMensaje());
            }else if(getDatoEdicion().getIDALMACEN()==null){
                this.mensaje="Almacen no asignado";
                WebUtil.MensajeError(getMensaje());
            }else if(getDatoEdicion().getIDDISTRIBUCION()==null){
                this.mensaje="Periódo de distribución no asignada";
                WebUtil.MensajeError(getMensaje());
            }else{
                listDDNFormaUbicacion.clear();
                arregloTemp =new ArrayList<Integer>();
                /*DEFINIR DDNFORMA_UBICACION*/
                for(int i=0;i<getDatoEdicion().getFILAS();i++){
                    for(int j=0;j<getDatoEdicion().getCOLUMNAS();j++){
                        DDNFormaUbicacion dDNUbicacion=new DDNFormaUbicacion();
                        dDNUbicacion.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
                        dDNUbicacion.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
                        dDNUbicacion.setIDALMACEN(getDatoEdicion().getIDALMACEN());
                        dDNUbicacion.setIDNFORMACIONUBICACION("");
                        dDNUbicacion.setFILAS(getDatoEdicion().getFILAS());
                        dDNUbicacion.setCOLUMNAS(getDatoEdicion().getCOLUMNAS());
                        dDNUbicacion.setIDFILA(WebUtil.idGeneradoTres(i+1));
                        dDNUbicacion.setIDCOLUMNA(WebUtil.idGeneradoTres(j+1));
                        dDNUbicacion.setPRIORIDAD(0);
                        dDNUbicacion.setESTADO(1);
                        dDNUbicacion.setSELECCIONADO(false);
    //                    getTempListDDNForma_Ubicacion().add(dDNUbicacion);
                        listDDNFormaUbicacion.add(dDNUbicacion);
                    }
                }
            }
            RequestContext.getCurrentInstance().update("datos:listDDNFormaUbicacion");
        }catch(Exception ex){
            this.mensaje=ex.getMessage();
            WebUtil.MensajeError(getMensaje());
        }
    }

    public void delDRegla() {
        listDDNFormaUbicacion.clear();
        arregloTemp =new ArrayList<Integer>();
//        listDDNFormaUbicacion.remove(selectDDNFormaUbicacion);
    }

    public void dDNFormaUbicacion() throws Exception {
        if (getLadd() == 1) {
//            Dreglas dr = new Dreglas();
//            dr.setIdparamentro(1);
//            listDReglas.add(dr);
            listAlmacen =(new AlmacenDao()).findAll(Constantes.IDEMPRESAGENERAL,Constantes.IDSUCURSALGENERAL);
            listDDistribucionUbicacion = (new DDistribucionUbicacionDao()).findDistActivos(Constantes.IDEMPRESAGENERAL, Constantes.IDSUCURSALGENERAL, listAlmacen.get(0).getIDALMACEN());
            listaFilaxColumna=(new DAlmacen_ColumnasDao()).cboRackFilasColumnas(Constantes.IDEMPRESAGENERAL,Constantes.IDSUCURSALGENERAL, listAlmacen.get(0).getIDALMACEN(), listDDistribucionUbicacion.get(0).getIDDISTRIBUCION(),"001","001", "001");
            listDDNFormaUbicacion =new ArrayList<DDNFormaUbicacion>();
            arregloTemp =new ArrayList<Integer>();
        } else {
            listAlmacen =(new AlmacenDao()).findAll(Constantes.IDEMPRESAGENERAL,Constantes.IDSUCURSALGENERAL);
            listDDistribucionUbicacion = (new DDistribucionUbicacionDao()).findDistActivos(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDALMACEN());
            listaFilaxColumna=(new DAlmacen_ColumnasDao()).cboRackFilasColumnas(getDatoEdicion().getIDEMPRESA(),getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDALMACEN(), getDatoEdicion().getIDDISTRIBUCION(),"001", "001", "001");
            listDDNFormaUbicacion = (new DDNFormaUbicacionDao()).findAll(getDatoEdicion().getIDEMPRESA(),getDatoEdicion().getIDSUCURSAL(),getDatoEdicion().getIDALMACEN(), getDatoEdicion().getIDNFORMACIONUBICACION()==null?"":getDatoEdicion().getIDNFORMACIONUBICACION());
//            listDReglas = reglasservice.findDreglas(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdregla());
        }
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
            (new DNForma_UbicacionDao()).editXmlDNFormaUbicacionDetalle(getDatoEdicion(), listDDNFormaUbicacion);
        } catch (Exception ex) {
            Logger.getLogger(DNFormaUbicacionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<DNFormaUbicacion> getListDNFormaUbicacion() {
        return listDNFormaUbicacion;
    }

    public void setListDNFormaUbicacion(List<DNFormaUbicacion> listDNFormaUbicacion) {
        this.listDNFormaUbicacion = listDNFormaUbicacion;
    }

    public List<DDNFormaUbicacion> getListDDNFormaUbicacion() {
        return listDDNFormaUbicacion;
    }

    public void setListDDNFormaUbicacion(List<DDNFormaUbicacion> listDDNFormaUbicacion) {
        this.listDDNFormaUbicacion = listDDNFormaUbicacion;
    }

    public UsuarioBean getUser() {
        return user;
    }

    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    public DDNFormaUbicacion getSelectDDNFormaUbicacion() {
        return selectDDNFormaUbicacion;
    }

    public void setSelectDDNFormaUbicacion(DDNFormaUbicacion selectDNFormaUbicacion) {
        this.selectDDNFormaUbicacion = selectDNFormaUbicacion;
    }

    public List<DDistribucionUbicacion> getListDDistribucionUbicacion() {
        return listDDistribucionUbicacion;
    }

    public void setListDDistribucionUbicacion(List<DDistribucionUbicacion> listDDistribucionUbicacion) {
        this.listDDistribucionUbicacion = listDDistribucionUbicacion;
    }

    public List<Almacen> getListAlmacen() {
        return listAlmacen;
    }

    public void setListAlmacen(List<Almacen> listAlmacen) {
        this.listAlmacen = listAlmacen;
    }

    public List<Combos> getListaFilaxColumna() {
        return listaFilaxColumna;
    }

    public void setListaFilaxColumna(List<Combos> listaFilaxColumna) {
        this.listaFilaxColumna = listaFilaxColumna;
    }

    public Combos getSelectFilaxColumna() {
        return selectFilaxColumna;
    }

    public void setSelectFilaxColumna(Combos selectFilaxColumna) {
        this.selectFilaxColumna = selectFilaxColumna;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public List<Integer> getArregloTemp() {
        return arregloTemp;
    }

    public void setArregloTemp(List<Integer> arregloTemp) {
        this.arregloTemp = arregloTemp;
    }

}
