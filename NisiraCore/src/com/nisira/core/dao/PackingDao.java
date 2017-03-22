/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Dpacking;
import com.nisira.core.entity.Packing;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class PackingDao extends EntityDao<Packing> {

    @Override
    public Packing find(Packing e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Packing> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Packing> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Packing> findAll(Object e1, Object e2) throws Exception {
        List<Packing> l = new ArrayList<Packing>();
        try {
            String sql = "SP_PACKINGLIST_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, e1);
            cl.setObject(2, e2);
            rs = cl.executeQuery();
            while (rs.next()) {
                Packing p = new Packing();
                p.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                p.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                p.setIDPACKING(rs.getInt("IDPACKING"));
                p.setFECHA(rs.getString("FECHA"));
                p.setCONTENEDOR(rs.getString("CONTENEDOR"));
                p.setIDDOCUMENTO(rs.getString("IDDOCUMENTO"));
                p.setSERIE(rs.getString("SERIE"));
                p.setNUMERO(rs.getString("NUMERO"));
                p.setIDRESPONSABLE(rs.getInt("IDRESPONSABLE"));
                p.setESTADO(rs.getBoolean("ESTADO") ? 1 : 0);
                p.setIDPUERTODESTINO(rs.getString("IDPUERTODESTINO"));
                p.setIDMOTIVO(rs.getString("IDMOTIVO"));
                p.setIDCLIENTE(rs.getString("IDCLIENTE"));
                p.setFECHACREACION(rs.getString("FECHACREACION"));
                l.add(p);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<Dpacking> findDpacking(Packing p) throws Exception {
        List<Dpacking> l = new ArrayList<Dpacking>();
        try {
            String sql = "SP_DPACKINGLIST_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, p.getIDEMPRESA());
            cl.setObject(2, p.getIDSUCURSAL());
            cl.setObject(3, p.getIDPACKING());
            rs = cl.executeQuery();
            while (rs.next()) {
                Dpacking dp = new Dpacking();
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public void grabar(Packing pack) throws Exception {
        List<Packing> ln = new ArrayList<Packing>();
        ln.add(pack);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Packing.class);
        xmlNot = xml + xStream.toXML(ln);
        try {
            Integer id = null;
            String sql = "SP_PACKING_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, xmlNot);
            cl.setObject(2, pack.getIDEMPRESA());
            cl.setObject(3, pack.getIDSUCURSAL());
            cl.setObject(4, pack.getIDPACKING());
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }

    public List<Packing> Syncronizar(Object ide, Object ids, Object desde, Object hasta) throws Exception {
        List<Packing> l = new ArrayList<Packing>();
        try {
            String sql = "SP_PACKINGLIST_SYNC";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3, desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4, hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                Packing p = new Packing();
                p.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                p.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                p.setIDPACKING(rs.getInt("IDPACKING"));
                p.setFECHA(rs.getString("FECHA"));
                p.setCONTENEDOR(rs.getString("CONTENEDOR"));
                p.setIDDOCUMENTO(rs.getString("IDDOCUMENTO"));
                p.setSERIE(rs.getString("SERIE"));
                p.setNUMERO(rs.getString("NUMERO"));
                p.setIDRESPONSABLE(rs.getInt("IDRESPONSABLE"));
                p.setESTADO(rs.getBoolean("ESTADO") ? 1 : 0);
                p.setIDPUERTODESTINO(rs.getString("IDPUERTODESTINO"));
                p.setIDMOTIVO(rs.getString("IDMOTIVO"));
                p.setIDCLIENTE(rs.getString("IDCLIENTE"));
                p.setFECHACREACION(rs.getString("FECHACREACION"));
                l.add(p);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
}
