/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.ProgramacionLlenado;
import com.nisira.core.entity.TablaPrioridades;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class TablaPrioridadesDao extends EntityDao<TablaPrioridades> {

    @Override
    public TablaPrioridades find(TablaPrioridades e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TablaPrioridades> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TablaPrioridades> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<TablaPrioridades> findAll(Object e1, Object e2, Object e3) throws Exception {
        List<TablaPrioridades> l = new ArrayList<TablaPrioridades>();
        try {
            String sql = "SP_TABLAPRIORIDADES_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, e1);
            cl.setObject(2, e2);
            cl.setObject(3, e3);
            rs = cl.executeQuery();
            while (rs.next()) {
                TablaPrioridades tb =new TablaPrioridades();
                tb.setIdempresa(rs.getInt("IDEMPRESA"));
                tb.setIdsucursal(rs.getInt("IDSUCURSAL"));
                tb.setIdalmacen(rs.getInt("IDALMACEN"));
                tb.setIddistribucion(rs.getString("IDDISTRIBUCION"));
                tb.setIdrack(rs.getInt("IDRACK"));
                tb.setIdpiso(rs.getString("IDPISO").trim());
                tb.setIdfila(rs.getString("IDFILA").trim());
                tb.setIdcolumna(rs.getString("IDCOLUMNA").trim());
                tb.setPidalmacen(rs.getInt("PIDALMACEN"));
                tb.setPidrack(rs.getInt("PIDRACK"));
                tb.setPidpiso(rs.getInt("PIDPISO"));
                tb.setPidfila(rs.getInt("PIDFILA"));
                tb.setPidcolumna(rs.getInt("PIDCOLUMNA"));
                tb.setIdprogramacionllenado(rs.getString("IDPROGRAMACIONLLENADO"));
                l.add(tb);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public void grabar(ProgramacionLlenado p, List<TablaPrioridades> tbl) throws Exception {
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(TablaPrioridades.class);
        xmlNot = xml + xStream.toXML(tbl);
        String id = "";
        try {
            String sql = "SP_TABLAPRIORIDADES_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, p.getIdempresa());
            cl.setObject(2, p.getIdsucursal());
            cl.setObject(3, p.getIdprogramacionllenado());
            cl.setObject(4, xmlNot);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
