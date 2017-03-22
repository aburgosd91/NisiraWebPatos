/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Parametros;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ParametrosDao extends EntityDao<Parametros> {

    public void grabar(Parametros e1, Object e2, Object e3) throws Exception {
        List<Parametros> ln = new ArrayList<Parametros>();
        ln.add(e1);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Parametros.class);
        xmlNot = xml + xStream.toXML(ln);
        try {
            String sql = "SP_PARAMETROS_GRABAR";
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

    @Override
    public Parametros find(Parametros e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Parametros find(int e1, String e2) throws Exception {
        Parametros u = new Parametros();
        try {
            String sql = "Select * from PARAMETROS where IDEMPRESA=? and IDPARAMETRO=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setInt(1, e1);
            pr.setString(2, e2);
            rs = pr.executeQuery();
            while (rs.next()) {
                
                u.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                u.setIDPARAMETRO(rs.getString("IDPARAMETRO"));
                u.setVALOR(rs.getInt("VALOR"));
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

    @Override
    public List<Parametros> findAll(Object e) throws Exception {
        List<Parametros> lu = new ArrayList<Parametros>();
        try {
            String sql = "SP_PARAMETROS_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                Parametros u = new Parametros();
                u.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                u.setIDPARAMETRO(rs.getString("IDPARAMETRO"));
                u.setVALOR(rs.getInt("VALOR"));
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
    public List<Parametros> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Parametros> Syncronizar(Object ide, Object desde, Object hasta) throws Exception {
        List<Parametros> l = new ArrayList<Parametros>();
        try {
            String sql = "SP_PARAMETROS_SYNC";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/

            cl.setString(2, desde.toString().replace("-", "").trim());/*++HASTA++*/

            cl.setString(3, hasta.toString().replace("-", "").trim());/*++HASTA++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                Parametros u = new Parametros();
                u.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                u.setIDPARAMETRO(rs.getString("IDPARAMETRO"));
                u.setVALOR(rs.getInt("VALOR"));
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
