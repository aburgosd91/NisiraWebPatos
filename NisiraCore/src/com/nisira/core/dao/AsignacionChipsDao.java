/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.AsignacionChips;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class AsignacionChipsDao extends EntityDao<AsignacionChips>{

    @Override
    public AsignacionChips find(AsignacionChips e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AsignacionChips> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AsignacionChips> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<AsignacionChips> findAll(Object ide,Object ids) throws Exception {
        List<AsignacionChips> l = new ArrayList<AsignacionChips>();
        try {
            String sql = "SP_ASIGNACIONCHIPS_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, ids);
            rs = cl.executeQuery();
            while (rs.next()) {
                AsignacionChips a = new AsignacionChips();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdsucursal(rs.getInt("IDSUCURSAL"));
                a.setIdasignacionchips(rs.getString("IDASIGNACIONCHIPS"));
                a.setIdzona(rs.getInt("IDZONA"));
                a.setGinicio(rs.getString("GINICIO"));
                a.setGfin(rs.getString("GFIN"));
                a.setNumtag(rs.getInt("NUMTAG"));
                a.setObservacion(rs.getString("OBSERVACION"));
                a.setEstado(rs.getInt("ESTADO"));
                a.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                a.setUsrcreacion(rs.getString("USRCREACION"));
                l.add(a);
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public String grabar(AsignacionChips a) throws Exception{
        List<AsignacionChips> ln = new ArrayList<AsignacionChips>();
        ln.add(a);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(AsignacionChips.class);
        xmlNot = xml + xStream.toXML(ln);
        String id = "";
        try {
            String sql = "SP_ASIGNACIONCHIPS_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, a.getIdempresa());
            cl.setObject(2, a.getIdsucursal());
            cl.setObject(3, a.getIdasignacionchips());
            cl.setObject(4, xmlNot);
            rs = cl.executeQuery();
            while (rs.next()) {
                id = rs.getString("TABLA_ID");
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return id;
    }
}
