/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Caracteristicas_Producto;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class Caracteristicas_ProductoDao extends EntityDao<Caracteristicas_Producto> {

    @Override
    public Caracteristicas_Producto find(Caracteristicas_Producto e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Caracteristicas_Producto> findAll(Object e) throws Exception {
        List<Caracteristicas_Producto> listaCaract = new ArrayList<Caracteristicas_Producto>();
        try {
            String sql = "SP_CARACTERISTICAS_PRODUCTO_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1,e);
            rs = cl.executeQuery();
            while (rs.next()) {
                Caracteristicas_Producto c = new Caracteristicas_Producto();
                c.setIdcaracteristicas(rs.getInt("IDCARACTERISTICAS"));
                c.setValor(rs.getInt("VALOR"));
                c.setDep_id(rs.getInt("DEP_ID"));
                c.setDescripcion(rs.getString("DESCRIPCION"));
                c.setAbrev(rs.getString("ABREV"));
                c.setEstado(rs.getInt("ESTADO"));
                c.setIdempresa(rs.getInt("IDEMPRESA"));
                listaCaract.add(c);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaCaract;
    }

    @Override
    public List<Caracteristicas_Producto> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int grabar(Caracteristicas_Producto p) throws Exception {
        List<Caracteristicas_Producto> ln = new ArrayList<Caracteristicas_Producto>();
        ln.add(p);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Caracteristicas_Producto.class);
        xmlNot = xml + xStream.toXML(ln);
        int id = 0;
        try {
            String sql = "SP_CARACTERISTICAS_PRODUCTO_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, p.getIdempresa());
            cl.setObject(2, p.getIdcaracteristicas());
            cl.setObject(3, p.getDescripcion());
            cl.setObject(4, xmlNot);
            rs = cl.executeQuery();
            while (rs.next()) {
                id = rs.getInt("TABLA_ID");
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return id;
    }

    public void grabardet(int idempresa,List<Caracteristicas_Producto> lp) throws Exception {
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Caracteristicas_Producto.class);
        xmlNot = xml + xStream.toXML(lp);
        String id = "";
        try {
            String sql = "SP_CARACTERISTICAS_PRODUCTO_DETGRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, idempresa);
            cl.setObject(2, xmlNot);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }

    public List<Caracteristicas_Producto> findDet(Object e) throws Exception {
        List<Caracteristicas_Producto> listaCaract = new ArrayList<Caracteristicas_Producto>();
        try {
            String sql = "SP_CARACTERISTICAS_PRODUCTO_CABVER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1,e);
            rs = cl.executeQuery();
            while (rs.next()) {
                Caracteristicas_Producto c = new Caracteristicas_Producto();
                c.setIdcaracteristicas(rs.getInt("IDCARACTERISTICAS"));
                c.setValor(rs.getInt("VALOR"));
                c.setDep_id(rs.getInt("DEP_ID"));
                c.setDescripcion(rs.getString("DESCRIPCION"));
                c.setAbrev(rs.getString("ABREV"));
                c.setEstado(rs.getInt("ESTADO"));
                c.setIdempresa(rs.getInt("IDEMPRESA"));
                listaCaract.add(c);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaCaract;
    }
    public List<Caracteristicas_Producto> findFilter(Object e,Object e2) throws Exception {
        List<Caracteristicas_Producto> listaCaract = new ArrayList<Caracteristicas_Producto>();
        try {
            String sql = "SP_CARACT_FILTRO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1,e);
            cl.setObject(2,e2);
            rs = cl.executeQuery();
            while (rs.next()) {
                Caracteristicas_Producto c = new Caracteristicas_Producto();
                c.setIdcaracteristicas(rs.getInt("IDCARACTERISTICAS"));
                c.setValor(rs.getInt("VALOR"));
                c.setDep_id(rs.getInt("DEP_ID"));
                c.setDescripcion(rs.getString("DESCRIPCION"));
                c.setAbrev(rs.getString("ABREV"));
                c.setEstado(rs.getInt("ESTADO"));
                c.setIdempresa(rs.getInt("IDEMPRESA"));
                listaCaract.add(c);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaCaract;
    }
}
