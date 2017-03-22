/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.GeneracionCodigo;
import com.nisira.core.entity.Plantilla;
import com.nisira.core.entity.Regiones;
import com.nisira.core.service.GeneracionCodigoService;
import com.nisira.core.service.PlantillaService;
import com.nisira.core.service.RegionesService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.pe.nisira.movil.view.util.menuDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "regionesAction")
@ViewScoped
public class RegionesAction {
    private String idempresa;
    private TreeNode patriarca;
    private TreeNode nodoSeleccionado;
    private String[] nodoS = new String[19];
    private int tipo_arbol;
    private Plantilla selectPlantilla;
    private List<Plantilla> lista_tg30wbmodulo;
    private List<String> catalogoXHTML;
    private int TAlto;
    private int TAncho;
    private List<GeneracionCodigo> listGeneracionCodigo;
    private int IDGENERACION;
    public RegionesAction() throws Exception {
        idempresa=ConstantesBD.IDEMPRESA;
        tipo_arbol=0;
        nodoSeleccionado = new DefaultTreeNode();
        this.lista_tg30wbmodulo = new ArrayList<Plantilla>();
        lista_tg30wbmodulo.clear();
        lista_tg30wbmodulo = new PlantillaService().getRecordPlantilla(idempresa);
        selectPlantilla=new Plantilla();
        listGeneracionCodigo=new ArrayList<GeneracionCodigo>();
        IDGENERACION=0;
    }
    public void llenarCatalogo() throws Exception{
        List<String> lista=new ArrayList<String>();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        lista.add((String) servletContext.getRealPath("sistema"));
        lista.add((String) servletContext.getRealPath("sistema/ubiccamara"));
        listGeneracionCodigo=new GeneracionCodigoService().getRecordGeneracionCodigo(idempresa);
        catalogoXHTML=Constantes.catalagoXHTML(lista);
    }
    
    public void llenarArbol() throws Exception {
        nodoS=new String[19];
        patriarca = new DefaultTreeNode("Patriarca", null);
        List<Regiones> listaContenidos = new RegionesService().getRecordRegiones(getIdempresa(),""+tipo_arbol);
        selectPlantilla_metodo(tipo_arbol);
        List<Regiones> listaPadres = new ArrayList<Regiones>();
        for (Regiones cont : listaContenidos) {
            if (cont.getJERARQUIA() == 0) {
                listaPadres.add(cont);
            }
        }
        for (Regiones pad : listaPadres) {
            TreeNode padre = new DefaultTreeNode(convertRegionStringArray(pad), patriarca);
            List<Regiones> listahijos = buscarhijos(pad, listaContenidos);
            llenarramas(listahijos, padre, listaContenidos);
        }
    }
    
    public void llenarramas(List<Regiones> hijos, TreeNode padre, List<Regiones> listaContenidos) {
        for (Regiones e : hijos) {
            TreeNode hijo = new DefaultTreeNode(convertRegionStringArray(e), padre);
            List<Regiones> listahijos = buscarhijos(e, listaContenidos);
            if (listahijos.size() > 0) {
                llenarramas(listahijos, hijo, listaContenidos);
            }
        }
    }
    public List<Regiones> buscarhijos(Regiones padre, List<Regiones> listaContenidos) {
        List<Regiones> lista = new ArrayList<Regiones>();
        for (Regiones cont : listaContenidos) {
            if (cont.getJERARQUIA() != 0) {
                if (cont.getJERARQUIA()==padre.getIDREGION()) {
                    lista.add(cont);
                }
            }
        }
        return lista;
    }
    public String[] convertRegionStringArray(Regiones reg){
        String arreglo[]=new String[19];
        int pos=0;
        arreglo[pos++]=""+reg.getIDEMPRESA();//0
        arreglo[pos++]=""+reg.getIDPLANTILLA();//1
        arreglo[pos++]=""+reg.getIDREGION();//2
        arreglo[pos++]=""+reg.getJERARQUIA();//3
        arreglo[pos++]=""+reg.getPRIORIDAD();//4
        arreglo[pos++]=""+reg.getCX();//5
        arreglo[pos++]=""+reg.getCY();//6
        arreglo[pos++]=""+reg.getLargo();//7
        arreglo[pos++]=""+reg.getAncho();//8
        arreglo[pos++]=""+reg.getIDGENERACION();//9
        return arreglo;
    }
    public Regiones convertStringArrayRegion(String arreglo[]){
        Regiones reg=new Regiones();
        reg.setIDEMPRESA(Integer.parseInt(idempresa));
        reg.setIDPLANTILLA(Integer.parseInt(arreglo[1]==null?"0":arreglo[1]));
        reg.setIDREGION(Integer.parseInt(arreglo[2]==null?"0":arreglo[2]));
        reg.setJERARQUIA(Integer.parseInt(arreglo[3]==null?"0":arreglo[3]));
        reg.setPRIORIDAD(Integer.parseInt(arreglo[4]==null?"0":arreglo[4]));
        reg.setCX(Integer.parseInt(arreglo[5]==null?"0":arreglo[5]));
        reg.setCY(Integer.parseInt(arreglo[6]==null?"0":arreglo[6]));
        reg.setLargo(Integer.parseInt(arreglo[7]==null?"0":arreglo[7]));
        reg.setAncho(Integer.parseInt(arreglo[8]==null?"0":arreglo[8]));
        reg.setIDGENERACION(Integer.parseInt(arreglo[9]==null?"0":arreglo[9]));
        reg.setEstado(true);
        return reg;
    }
    public void selectPlantilla_metodo(int IDPLANTILLA){
        for(int i=0;i<lista_tg30wbmodulo.size();i++){
            if(lista_tg30wbmodulo.get(i).getIDPLANTILLA()==IDPLANTILLA){
                selectPlantilla=lista_tg30wbmodulo.get(i);break;
            }
        }
    }
    public void nuevo_contenido_pagina_productos() throws Exception {
        nodoS=new String[19];
        nodoS[1] = ""+tipo_arbol;
        nodoS[5] = "0";
        nodoS[6] = "0";
        nodoS[7] = ""+selectPlantilla.getHEIGHT();
        nodoS[8] = ""+selectPlantilla.getWIDTH();
//        if (tipo_arbol.equalsIgnoreCase("MENU")) {
//            nodoS[2] = "MENU_GENERAL";      
//        } else if (tipo_arbol.equalsIgnoreCase("DESCRIPCION")) {
//            nodoS[2] = "DESCRIPCION";
//        } 
//        else     
//        {
//            nodoS[2] = "CONT_TAG_TITULO";
//        }
//        nodoS[9] = "1";
//        nodoS[10] = "1";
    }

    public void nuevo_Secundario_contenido_pagina_productos() throws Exception {
        // idcontenido,jerarquia,tipo,titulo,contenido,rutaImagen,pagina,icono,fechaCreacion,
// usuario,habilitado,orden,url,comando,actualiza,style,styleClass,sub_menu

        String jerarquia = nodoS[2];
        String tipo = ""+tipo_arbol ;
//        if (tipo_arbol.equalsIgnoreCase("MENU")) {
//            tipo = "MENU_GENERAL";
//        } else if (tipo_arbol.equalsIgnoreCase("DESCRIPCION")) {
//            tipo = "DESCRIPCION";
//        
//        }else  
//        {
//            tipo = nodoS[2].equalsIgnoreCase("CONT_TAG_TITULO") ? "CONT_TAG_TAG" : "CONT_TAG_PANEL";
//
//        }
        nodoS=new String[19];
        nodoS[3] = jerarquia;
        nodoS[1] = tipo;
    }
     public void borrar_contenido_pagina_productos() throws Exception {
        // idcontenido,jerarquia,tipo,titulo,contenido,rutaImagen,pagina,icono,fechaCreacion,
// usuario,habilitado,orden,url,comando,actualiza,style,styleClass,sub_menu
         if (nodoS == null)
         {
             WebUtil.MensajeError("Seleccione contenido");
         }else{
             new  RegionesService().deleteRegiones(convertStringArrayRegion(nodoS));
         }
    }
    public String return_descripcion(String id) throws Exception{
        String dsc = "";
        Regiones e=new RegionesService().getRegiones(idempresa,""+tipo_arbol,id);
        //List<String[]> listaContenidos = new RegionesService().getRegiones(idempresa,""+tipo_arbol, id)
        if(e!=null)
            dsc="["+e.getIDREGION()+"] - "+e.getPLANTILLA();
        return dsc;
    }

    public void grabar_tg30wbmenu() throws Exception {
        nodoS[9]=""+IDGENERACION;
        if(nodoS[0]== null || nodoS[2].isEmpty()){
            WebUtil.MensajeAlerta("Item registrado.");
            new RegionesService().addRegiones(convertStringArrayRegion(nodoS));
        }else{
            WebUtil.MensajeAlerta("Item actualizado.");
            new RegionesService().editRegiones(convertStringArrayRegion(nodoS));
        }
    }

    public void onNodeSelect(NodeSelectEvent event) {
        nodoS=(String[]) event.getTreeNode().getData();
        IDGENERACION=Integer.parseInt(nodoS[9]);
        RequestContext.getCurrentInstance().update("datos:datosTree");
        RequestContext.getCurrentInstance().update("datos:datosTree:generacion");
    }

    public TreeNode getPatriarca() {
        return patriarca;
    }

    public void setPatriarca(TreeNode patriarca) {
        this.patriarca = patriarca;
    }

    public TreeNode getNodoSeleccionado() {
        return nodoSeleccionado;
    }

    public void setNodoSeleccionado(TreeNode nodoSeleccionado) {
        this.nodoSeleccionado = nodoSeleccionado;
    }

    public String[] getNodoS() {
        return nodoS;
    }

    public int getTipo_arbol() {
        return tipo_arbol;
    }

    public void setTipo_arbol(int tipo_arbol) {
        this.tipo_arbol = tipo_arbol;
    }

    public List<Plantilla> getLista_tg30wbmodulo() {
        return lista_tg30wbmodulo;
    }

    public void setLista_tg30wbmodulo(List<Plantilla> lista_tg30wbmodulo) {
        this.lista_tg30wbmodulo = lista_tg30wbmodulo;
    }

    /**
     * @return the catalogoXHTML
     */
    public List<String> getCatalogoXHTML() {
        return catalogoXHTML;
    }

    /**
     * @param catalogoXHTML the catalogoXHTML to set
     */
    public void setCatalogoXHTML(List<String> catalogoXHTML) {
        this.catalogoXHTML = catalogoXHTML;
    }

    /**
     * @return the idempresa
     */
    public String getIdempresa() {
        return idempresa;
    }

    /**
     * @param idempresa the idempresa to set
     */
    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    /**
     * @return the TAlto
     */
    public int getTAlto() {
        return TAlto;
    }

    /**
     * @param TAlto the TAlto to set
     */
    public void setTAlto(int TAlto) {
        this.TAlto = TAlto;
    }

    /**
     * @return the TAncho
     */
    public int getTAncho() {
        return TAncho;
    }

    /**
     * @param TAncho the TAncho to set
     */
    public void setTAncho(int TAncho) {
        this.TAncho = TAncho;
    }

    /**
     * @return the selectPlantilla
     */
    public Plantilla getSelectPlantilla() {
        return selectPlantilla;
    }

    /**
     * @param selectPlantilla the selectPlantilla to set
     */
    public void setSelectPlantilla(Plantilla selectPlantilla) {
        this.selectPlantilla = selectPlantilla;
    }

    /**
     * @return the listGeneracionCodigo
     */
    public List<GeneracionCodigo> getListGeneracionCodigo() {
        return listGeneracionCodigo;
    }

    /**
     * @param listGeneracionCodigo the listGeneracionCodigo to set
     */
    public void setListGeneracionCodigo(List<GeneracionCodigo> listGeneracionCodigo) {
        this.listGeneracionCodigo = listGeneracionCodigo;
    }
    /**
     * @return the IDGENERACION
     */
    public int getIDGENERACION() {
        return IDGENERACION;
    }

    /**
     * @param IDGENERACION the IDGENERACION to set
     */
    public void setIDGENERACION(int IDGENERACION) {
        this.IDGENERACION = IDGENERACION;
    }
    
}
