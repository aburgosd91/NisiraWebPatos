/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.mSysFormularioDAO;
import com.nisira.core.dao.mSysMenuDao;
import com.nisira.core.entity.mSysFormulario;
import com.nisira.core.entity.mSysGrupo;
import com.nisira.core.entity.mSysMenu;
import com.nisira.core.entity.mSysModulo;
import com.nisira.core.entity.mSysOpcion;
import com.nisira.core.entity.mSysTitulo;
import static com.pe.nisira.movil.view.util.WebUtil.cerosIzquierda;
import com.pe.nisira.movil.view.util.menuDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "msysMenuAction")
@SessionScoped
public class mSysMenuAction {

    private TreeNode patriarca;
    private TreeNode nodoSeleccionado;
    private mSysMenu nodoS = new mSysMenu();
    private mSysFormularioDAO frmDao;
    private List<mSysFormulario> lfrm;
    private mSysFormulario frm;
    private String tipo_arbol;
    private List<mSysMenu> listaContenidos;
    private mSysMenuDao menudao;
    private List<Object[]> lista_seleccion;

    public mSysMenuAction() {
        listaContenidos = new ArrayList<mSysMenu>();
        menudao = new mSysMenuDao();
        frmDao = new mSysFormularioDAO();
        lfrm = new ArrayList<mSysFormulario>();
        frm = new mSysFormulario();
    }

    public void Nuevo() throws Exception {
        nodoS = new mSysMenu();
        nodoS.setNivel(0);
        int k = 0;
        for (mSysMenu m : listaContenidos) {
            if (m.getNivel() == 0) {
                k++;
            }
        }
        nodoS.setIdmodulo(cerosIzquierda(k + 1, 3));
    }

    public void NuevoSec() {
        mSysMenu tempnodo = new mSysMenu();
        tempnodo.setNivel(nodoS.getNivel());
        tempnodo.setIdmodulo(nodoS.getIdmodulo());
        tempnodo.setIdtitulo(nodoS.getIdtitulo());
        tempnodo.setIdgrupo(nodoS.getIdgrupo());
        tempnodo.setIdformulario(nodoS.getIdformulario());
        nodoS = new mSysMenu();
        switch (tempnodo.getNivel()) {
            case 0:
                nodoS.setNivel(1);
                nodoS.setIdmodulo(tempnodo.getIdmodulo());
                int k = 0;
                for (mSysMenu m : listaContenidos) {
                    if (m.getNivel() == 1 &&  tempnodo.getIdmodulo().equalsIgnoreCase(m.getIdmodulo())) {
                        k++;
                    }
                }
                nodoS.setIdtitulo(cerosIzquierda(k + 1, 3));
                break;
            case 1:
                nodoS.setNivel(2);
                nodoS.setIdmodulo(tempnodo.getIdmodulo());
                nodoS.setIdtitulo(tempnodo.getIdtitulo());
                int k2 = 0;
                for (mSysMenu m : listaContenidos) {
                    if (m.getNivel() == 2 &&  tempnodo.getIdmodulo().equalsIgnoreCase(m.getIdmodulo()) && tempnodo.getIdmodulo().equalsIgnoreCase(m.getIdmodulo())) {
                        k2++;
                    }
                }
                nodoS.setIdgrupo(cerosIzquierda(k2 + 1, 3));
                break;
            case 2:
                nodoS.setNivel(3);
                nodoS.setIdmodulo(tempnodo.getIdmodulo());
                nodoS.setIdtitulo(tempnodo.getIdtitulo());
                nodoS.setIdgrupo(tempnodo.getIdgrupo());
                int k3 = 0;
                break;
        }
    }

    public void grabar() throws Exception{
        menudao.insertMenu(nodoS);
    }
    
    public void selectFrm(){
        nodoS.setIdformulario(frm.getIdformulario());
    }
    public void borrar() throws Exception{
        menudao.borrarMenu(nodoS);
    }
    public void llenarArbol() throws Exception {
        lfrm = frmDao.findAllFrm();
        patriarca = new DefaultTreeNode("Patriarca", null);
        listaContenidos = menudao.findAll();
        List<mSysMenu> listaPadres = new ArrayList<mSysMenu>();
        for (mSysMenu cont : listaContenidos) {
            if (cont.getNivel() == 0) {
                listaPadres.add(cont);
            }
        }
        for (mSysMenu pad : listaPadres) {
            TreeNode padre = new DefaultTreeNode(pad, patriarca);
            List<mSysMenu> listahijos = buscarhijos(pad, listaContenidos);
            llenarramas(listahijos, padre, listaContenidos);
        }
    }

    public void llenarramas(List<mSysMenu> hijos, TreeNode padre, List<mSysMenu> listaContenidos) {
        for (mSysMenu e : hijos) {
            TreeNode hijo = new DefaultTreeNode(e, padre);
            List<mSysMenu> listahijos = buscarhijos(e, listaContenidos);
            if (listahijos.size() > 0) {
                llenarramas(listahijos, hijo, listaContenidos);
            }
        }
    }

    public List<mSysMenu> buscarhijos(mSysMenu padre, List<mSysMenu> listaContenidos) {
        List<mSysMenu> lista = new ArrayList<mSysMenu>();
        for (mSysMenu cont : listaContenidos) {
            switch (padre.getNivel()) {
                case 0:
                    if (cont.getNivel() == 1 && cont.getIdmodulo().equalsIgnoreCase(padre.getIdmodulo())) {
                        lista.add(cont);
                    }
                    break;
                case 1:
                    if (cont.getNivel() == 2 && cont.getIdmodulo().equalsIgnoreCase(padre.getIdmodulo()) && cont.getIdtitulo().equalsIgnoreCase(padre.getIdtitulo())) {
                        lista.add(cont);
                    }
                    break;
                case 2:
                    if (cont.getNivel() == 3 && cont.getIdmodulo().equalsIgnoreCase(padre.getIdmodulo()) && cont.getIdtitulo().equalsIgnoreCase(padre.getIdtitulo()) && cont.getIdgrupo().equalsIgnoreCase(padre.getIdgrupo())) {
                        lista.add(cont);
                    }
                    break;
                default:
                    break;
            }
        }
        return lista;
    }

    public void onNodeSelect(NodeSelectEvent event) throws Exception {
        nodoS = (mSysMenu) event.getTreeNode().getData();
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

    public mSysMenu getNodoS() {
        return nodoS;
    }

    public void setNodoS(mSysMenu nodoS) {
        this.nodoS = nodoS;
    }

    public String getTipo_arbol() {
        return tipo_arbol;
    }

    public void setTipo_arbol(String tipo_arbol) {
        this.tipo_arbol = tipo_arbol;
    }

    public List<Object[]> getLista_seleccion() {
        return lista_seleccion;
    }

    public void setLista_seleccion(List<Object[]> lista_seleccion) {
        this.lista_seleccion = lista_seleccion;
    }

    public List<mSysFormulario> getLfrm() {
        return lfrm;
    }

    public void setLfrm(List<mSysFormulario> lfrm) {
        this.lfrm = lfrm;
    }

    public mSysFormulario getFrm() {
        return frm;
    }

    public void setFrm(mSysFormulario frm) {
        this.frm = frm;
    }

}
