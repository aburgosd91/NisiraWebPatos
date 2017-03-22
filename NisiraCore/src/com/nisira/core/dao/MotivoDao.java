/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Motivo;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class MotivoDao extends EntityDao<Motivo> {

    @Override
    public Motivo find(Motivo e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Motivo> findAll(Object e) throws Exception {
        List<Motivo> lu = new ArrayList<Motivo>();
        try {
            String sql = "SP_MOTIVO_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                Motivo u = new Motivo();
                u.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                u.setIDMOTIVO(rs.getString("IDMOTIVO"));
                u.setDESCRIPCION(rs.getString("DESCRIPCION"));
                u.setCODIGOEQUIVALENTE(rs.getString("CODIGOEQUIVALENTE"));
                u.setFECHACREACION(rs.getString("FECHACREACION"));
                u.setESTADO(rs.getBoolean("ESTADO") ? 1 : 0);
                lu.add(u);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lu;
    }

    @Override
    public List<Motivo> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void grabar(Motivo e1, Object e2, Object e3) throws Exception {
        List<Motivo> ln = new ArrayList<Motivo>();
        ln.add(e1);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Motivo.class);
        xmlNot = xml + xStream.toXML(ln);
        try {
            Integer id = null;
            String sql = "SP_MOTIVOS_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, xmlNot);
            cl.setObject(2, e2);
            cl.setObject(3, e3);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }

    public Motivo find(int e1, String e2) throws Exception {
        Motivo u = new Motivo();
        try {
            String sql = "Select * from MOTIVO where IDEMPRESA=? and IDMOTIVO=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setInt(1, e1);
            pr.setString(2, e2);
            rs = pr.executeQuery();
            while (rs.next()) {
                u.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                u.setIDMOTIVO(rs.getString("IDMOTIVO"));
                u.setDESCRIPCION(rs.getString("DESCRIPCION"));
                u.setCODIGOEQUIVALENTE(rs.getString("CODIGOEQUIVALENTE"));
                u.setFECHACREACION(rs.getString("FECHACREACION"));
                u.setESTADO(rs.getBoolean("ESTADO") ? 1 : 0);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return u;
    }

    public List<Motivo> Syncronizar(Object ide, Object desde, Object hasta) throws Exception {
        List<Motivo> l = new ArrayList<Motivo>();
        try {
            String sql = "SP_MOTIVO_SYNC";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(2, desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(3, hasta.toString().replace("-", "").trim());/*++HASTA++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                Motivo u = new Motivo();
                u.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                u.setIDMOTIVO(rs.getString("IDMOTIVO"));
                u.setDESCRIPCION(rs.getString("DESCRIPCION"));
                u.setCODIGOEQUIVALENTE(rs.getString("CODIGOEQUIVALENTE"));
                u.setFECHACREACION(rs.getString("FECHACREACION"));
                u.setESTADO(rs.getBoolean("ESTADO") ? 1 : 0);
                l.add(u);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
}
