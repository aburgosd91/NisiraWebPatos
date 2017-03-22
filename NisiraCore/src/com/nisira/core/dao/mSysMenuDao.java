/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.mSysMenu;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class mSysMenuDao extends EntityDao<mSysMenu> {

    @Override
    public mSysMenu find(mSysMenu e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<mSysMenu> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<mSysMenu> findAll() throws Exception {
        List<mSysMenu> listSysMenu = new ArrayList<mSysMenu>();
        try {
            String sql = "SP_mSysMenu";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();
            while (rs.next()) {
                mSysMenu menu = new mSysMenu();
                menu.setNivel(rs.getInt("nivel"));
                menu.setIdmodulo(rs.getString("idmodulo"));
                menu.setIdtitulo(rs.getString("idtitulo"));
                menu.setIdgrupo(rs.getString("idgrupo"));
                menu.setIdformulario(rs.getString("idformulario"));
                menu.setDescripcion(rs.getString("descripcion"));
                menu.setImagen(rs.getString("imagen"));
                menu.setPrioridad(rs.getInt("prioridad"));
                listSysMenu.add(menu);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listSysMenu;
    }

    public void insertMenu(mSysMenu menu) throws Exception {
        String resultado = "";
        List<mSysMenu> lmenu = new ArrayList<mSysMenu>();
        lmenu.add(menu);
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("MSYSMENU", mSysMenu.class);
        String xml = xstream.toXML(lmenu);
        try {
            String sql = "SP_mSysMenuIngreso";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?,?,?,?)}");
            cl.setInt(1, menu.getNivel());
            cl.setString(2, xml);
            cl.setString(3, menu.getIdmodulo());
            cl.setString(4, menu.getIdtitulo());
            cl.setString(5, menu.getIdgrupo());
            cl.setString(6, menu.getIdformulario());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        } finally {
            cerrar(cn, cl, rs);
        }
    }

    public void borrarMenu(mSysMenu menu) throws Exception {
        String resultado = "";
        try {
            String sql = "SP_mSysMenuBorrar";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?,?,?)}");
            cl.setInt(1, menu.getNivel());
            cl.setString(2, menu.getIdmodulo());
            cl.setString(3, menu.getIdtitulo());
            cl.setString(4, menu.getIdgrupo());
            cl.setString(5, menu.getIdformulario());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
