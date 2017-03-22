/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Puertocom;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class PuertocomDao extends EntityDao<Puertocom> {

    @Override
    public Puertocom find(Puertocom e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Puertocom> findAll(Object e) throws Exception {
        List<Puertocom> l = new ArrayList<Puertocom>();
        try {
            String sql = "SP_PUERTOCOM_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                Puertocom p = new Puertocom();
                p.setIdempresa(rs.getInt("IDEMPRESA"));
                p.setIdpuertocom(rs.getInt("IDPUERTOCOM"));
                p.setDescripcion(rs.getString("DESCRIPCION"));
                p.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                p.setEstado((rs.getInt("ESTADO")));
                l.add(p);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<Puertocom> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void grabar(Puertocom p) throws Exception {
        List<Puertocom> ln = new ArrayList<Puertocom>();
        ln.add(p);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Puertocom.class);
        xmlNot = xml + xStream.toXML(ln);
        try {
            Integer id = null;
            String sql = "SP_PUERTOCOM_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, p.getIdempresa());
            cl.setObject(2, p.getIdpuertocom());
            cl.setObject(3, xmlNot);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }

    public void anular(Puertocom p,int estado) throws Exception {
        try {
            String sql = "Update PUERTOCOM SET ESTADO = ? where IDEMPRESA=? and IDPUERTOCOM=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setInt(1, estado);
            pr.setInt(2, p.getIdempresa());
            pr.setInt(3, p.getIdpuertocom());
            pr.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
