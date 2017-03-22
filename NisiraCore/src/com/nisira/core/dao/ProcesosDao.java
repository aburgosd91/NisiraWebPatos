/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Procesos;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ProcesosDao extends EntityDao<Procesos> {

    @Override
    public Procesos find(Procesos e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Procesos> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Procesos> findAll(Object e) throws Exception {
        List<Procesos> l = new ArrayList<Procesos>();
        try {
            String sql = "SP_Procesos_Ver";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                Procesos p = new Procesos();
                p.setIdempresa(rs.getInt("IDEMPRESA"));
                p.setIdproceso(rs.getInt("IDPROCESO"));
                p.setDescripcion(rs.getString("DESCRIPCION"));
                p.setFechainicio(rs.getTimestamp("FECHAINICIO"));
                p.setFechafin(rs.getTimestamp("FECHAFIN"));
                p.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                p.setEstado((rs.getInt("ESTADO")));
                l.add(p);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public void grabar(Procesos p) throws Exception {
        List<Procesos> ln = new ArrayList<Procesos>();
        ln.add(p);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Procesos.class);
        xmlNot = xml + xStream.toXML(ln);
        try {
            Integer id = null;
            String sql = "SP_PROCESOS_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, p.getIdempresa());
            cl.setObject(2, p.getIdproceso());
            cl.setObject(3, xmlNot);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
    public void anular(Procesos p,int estado) throws Exception{
        try {
            String sql = "Update PROCESOS SET FECHAFIN = GETDATE(),ESTADO = ? where IDEMPRESA=? and IDPROCESO=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setInt(1, estado);
            pr.setInt(2, p.getIdempresa());
            pr.setInt(3, p.getIdproceso());
            pr.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
