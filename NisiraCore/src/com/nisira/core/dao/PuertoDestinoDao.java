/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.PuertoDestino;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class PuertoDestinoDao extends EntityDao<PuertoDestino> {

    @Override
    public PuertoDestino find(PuertoDestino e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PuertoDestino> findAll(Object e) throws Exception {
        List<PuertoDestino> lu = new ArrayList<PuertoDestino>();
        try {
            String sql = "SP_PUERTOSDESTINO_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                PuertoDestino u = new PuertoDestino();
                u.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                u.setIDPUERTODESTINO(rs.getString("IDPUERTODESTINO"));
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
    public List<PuertoDestino> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void grabar(PuertoDestino e1, Object e2, Object e3) throws Exception {
        List<PuertoDestino> ln = new ArrayList<PuertoDestino>();
        ln.add(e1);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(PuertoDestino.class);
        xmlNot = xml + xStream.toXML(ln);
        try {
            String sql = "SP_PUERTODESTINO_GRABAR";
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

    public PuertoDestino find(int e1, String e2) throws Exception {
        PuertoDestino u = new PuertoDestino();
        try {
            String sql = "Select * from PUERTOSDESTINO where IDEMPRESA=? and IDPUERTODESTINO=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setInt(1, e1);
            pr.setString(2, e2);
            rs = pr.executeQuery();
            while (rs.next()) {
                u.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                u.setIDPUERTODESTINO(rs.getString("IDPUERTODESTINO"));
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

    public List<PuertoDestino> Syncronizar(Object ide, Object desde, Object hasta) throws Exception {
        List<PuertoDestino> l = new ArrayList<PuertoDestino>();
        try {
            String sql = "SP_PUERTOSDESTINO_SYNC";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(2, desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(3, hasta.toString().replace("-", "").trim());/*++HASTA++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                PuertoDestino u = new PuertoDestino();
                u.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                u.setIDPUERTODESTINO(rs.getString("IDPUERTODESTINO"));
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
