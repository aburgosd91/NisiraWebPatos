/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DDreglaLlenadoGeneracion;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DDreglaLlenadoGeneracionDao extends EntityDao<DDreglaLlenadoGeneracion> {

    @Override
    public DDreglaLlenadoGeneracion find(DDreglaLlenadoGeneracion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DDreglaLlenadoGeneracion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DDreglaLlenadoGeneracion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DDreglaLlenadoGeneracion> findAll(Object ide, Object ids, Object idr, Object idg, Object idrc) throws Exception {
        List<DDreglaLlenadoGeneracion> l = new ArrayList<DDreglaLlenadoGeneracion>();
        try {
            String sql = "SP_DDREGLALLENADOGENERACION_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, ids);
            cl.setObject(3, idr);
            cl.setObject(4, idg);
            cl.setObject(5, idrc);
            rs = cl.executeQuery();
            while (rs.next()) {
                DDreglaLlenadoGeneracion r = new DDreglaLlenadoGeneracion();
                r.setIdempresa(rs.getInt("IDEMPRESA"));
                r.setIdsucursal(rs.getInt("IDSUCURSAL"));
                r.setIdreglas(rs.getString("IDREGLAS"));
                r.setIdgeneracion(rs.getInt("IDGENERACION"));
                r.setIdregistrocodigo(rs.getInt("IDREGISTROCODIGO"));
                r.setItem(rs.getInt("ITEM"));
                r.setValor(rs.getString("VALOR"));
                l.add(r);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public void grabar(String idr, List<DDreglaLlenadoGeneracion> lddrg) throws Exception {

        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(DDreglaLlenadoGeneracion.class);
        xmlNot = xml + xStream.toXML(lddrg);
        String id = "";
        try {
            String sql = "SP_DDREGLALLENADOGENERACION_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, idr);
            cl.setObject(2, xmlNot);
            cl.executeUpdate();            
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
