/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DreglaLlenadoGeneracion;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DreglaLlenadoGeneracionDao extends EntityDao<DreglaLlenadoGeneracion> {

    @Override
    public DreglaLlenadoGeneracion find(DreglaLlenadoGeneracion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DreglaLlenadoGeneracion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DreglaLlenadoGeneracion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DreglaLlenadoGeneracion> findAll(Object ide, Object ids, Object idr, Object idgen) throws Exception {
        List<DreglaLlenadoGeneracion> l = new ArrayList<DreglaLlenadoGeneracion>();
        try {
            String sql = "SP_DREGLALLENADOGENERACION_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, ids);
            cl.setObject(3, idr);
            cl.setObject(4, idgen);
            rs = cl.executeQuery();
            while (rs.next()) {
                DreglaLlenadoGeneracion r = new DreglaLlenadoGeneracion();
                r.setIdempresa(rs.getInt("IDEMPRESA"));
                r.setIdsucursal(rs.getInt("IDSUCURSAL"));
                r.setIdreglas(rs.getString("IDREGLAS"));
                r.setIdgeneracion(rs.getInt("IDGENERACION"));
                r.setIdregistrocodigo(rs.getInt("IDREGISTROCODIGO"));
                r.setDinicio(rs.getInt("DINICIO"));
                r.setDfin(rs.getInt("DFIN"));
                l.add(r);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<DreglaLlenadoGeneracion> findAll(Object ide, Object ids, Object idr) throws Exception {
        List<DreglaLlenadoGeneracion> l = new ArrayList<DreglaLlenadoGeneracion>();
        try {
            String sql = "SP_DREGLALLENADOGENERACION_VERDET";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, ids);
            cl.setObject(3, idr);
            rs = cl.executeQuery();
            while (rs.next()) {
                DreglaLlenadoGeneracion r = new DreglaLlenadoGeneracion();
                r.setIdempresa(rs.getInt("IDEMPRESA"));
                r.setIdsucursal(rs.getInt("IDSUCURSAL"));
                r.setIdreglas(rs.getString("IDREGLAS"));
                r.setIdgeneracion(rs.getInt("IDGENERACION"));
                r.setIdregistrocodigo(rs.getInt("IDREGISTROCODIGO"));
                r.setDinicio(rs.getInt("DINICIO"));
                r.setDfin(rs.getInt("DFIN"));
                l.add(r);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public void grabar(String idr, List<DreglaLlenadoGeneracion> ldrg) throws Exception {
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(DreglaLlenadoGeneracion.class);
        xmlNot = xml + xStream.toXML(ldrg);
        String id = "";
        try {
            String sql = "SP_DREGLALLENADOGENERACION_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, idr);
            cl.setObject(2, xmlNot);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
    public List<DreglaLlenadoGeneracion> findAllDesc(Object ide, Object ids, Object idr, Object idgen) throws Exception {
        List<DreglaLlenadoGeneracion> l = new ArrayList<DreglaLlenadoGeneracion>();
        try {
            String sql = "SP_DREGLALLENADOGENERACION_COMB";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, ids);
            cl.setObject(3, idr);
            cl.setObject(4, idgen);
            rs = cl.executeQuery();
            while (rs.next()) {
                DreglaLlenadoGeneracion r = new DreglaLlenadoGeneracion();
                r.setIdempresa(rs.getInt("IDEMPRESA"));
                r.setIdsucursal(rs.getInt("IDSUCURSAL"));
                r.setIdreglas(rs.getString("IDREGLAS"));
                r.setIdgeneracion(rs.getInt("IDGENERACION"));
                r.setIdregistrocodigo(rs.getInt("IDREGISTROCODIGO"));
                r.setDinicio(rs.getInt("DINICIO"));
                r.setDfin(rs.getInt("DFIN"));
                r.setParametro(rs.getString("PARAMETRO"));
                l.add(r);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
}
