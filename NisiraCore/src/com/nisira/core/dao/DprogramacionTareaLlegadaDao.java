/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DprogramacionTareaLlegada;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DprogramacionTareaLlegadaDao extends EntityDao<DprogramacionTareaLlegada>{

    @Override
    public DprogramacionTareaLlegada find(DprogramacionTareaLlegada e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DprogramacionTareaLlegada> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DprogramacionTareaLlegada> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<DprogramacionTareaLlegada> findAll(Object ide, Object ids, Object idp) throws Exception {
        List<DprogramacionTareaLlegada> l = new ArrayList<DprogramacionTareaLlegada>();
        try {
            String sql = "SP_DPROGRAMACIONTAREALLEGADA_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, ids);
            cl.setObject(3, idp);
            rs = cl.executeQuery();
            while (rs.next()) {
                DprogramacionTareaLlegada d = new DprogramacionTareaLlegada();
                d.setIdempresa(rs.getInt("IDEMPRESA"));
                d.setIdsucursal(rs.getInt("IDSUCURSAL"));
                d.setIdprogramaciontarea(rs.getString("IDPROGRAMACIONTAREA"));
                d.setItem(rs.getInt("ITEM"));
                d.setIdprogramacionllenado(rs.getString("IDPROGRAMACIONLLENADO"));
                d.setIdproceso(rs.getInt("IDPROCESO"));
                d.setIdforma(rs.getInt("IDFORMA"));
                d.setIdgeneracion(rs.getInt("IDGENERACION"));
                d.setIdreglas(rs.getString("IDREGLAS"));
                l.add(d);
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public void grabar(Object ide, Object ids, Object idp, List<DprogramacionTareaLlegada> lst) throws Exception {
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(DprogramacionTareaLlegada.class);
        xmlNot = xml + xStream.toXML(lst);
        String id = "";
        try {
            String sql = "SP_DPROGRAMACIONTAREALLEGADA_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, ids);
            cl.setObject(3, idp);
            cl.setObject(4, xmlNot);
            cl.executeUpdate();            
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
