/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.ProgramacionLlenado;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ProgramacionLlenadoDao extends EntityDao<ProgramacionLlenado> {

    @Override
    public ProgramacionLlenado find(ProgramacionLlenado e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramacionLlenado> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramacionLlenado> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ProgramacionLlenado> findAll(Object e1, Object e2) throws Exception {
        List<ProgramacionLlenado> l = new ArrayList<ProgramacionLlenado>();
        try {
            String sql = "SP_PROGRAMACIONLLENADO_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, e1);
            cl.setObject(2, e2);
            rs = cl.executeQuery();
            while (rs.next()) {
                ProgramacionLlenado r = new ProgramacionLlenado();
                r.setIdempresa(rs.getInt("IDEMPRESA"));
                r.setIdsucursal(rs.getInt("IDSUCURSAL"));
                r.setIdprogramacionllenado(rs.getString("IDPROGRAMACIONLLENADO"));
                r.setIdproceso(rs.getInt("IDPROCESO"));          
                r.setIdforma(rs.getInt("IDFORMA"));
                r.setIdgeneracion(rs.getInt("IDGENERACION"));
                r.setIdreglas(rs.getString("IDREGLAS"));
                r.setFinicio(rs.getTimestamp("FINICIO"));
                r.setFfin(rs.getTimestamp("FFIN"));
                r.setEstado(rs.getInt("ESTADO"));
                r.setUsrcreacion(rs.getString("USRCREACION"));
                r.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                l.add(r);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public String grabar(ProgramacionLlenado p) throws Exception {
        List<ProgramacionLlenado> ln = new ArrayList<ProgramacionLlenado>();
        ln.add(p);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(ProgramacionLlenado.class);
        xmlNot = xml + xStream.toXML(ln);
        String id = "";
        try {
            String sql = "SP_PROGRAMACIONLLENADO_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, p.getIdempresa());
            cl.setObject(2, p.getIdsucursal());
            cl.setObject(3, p.getIdprogramacionllenado());
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
    public List<ProgramacionLlenado> genDProgLlen(Object e1, Object e2,Object e3) throws Exception{
        List<ProgramacionLlenado> l = new ArrayList<ProgramacionLlenado>();
        try {
            String sql = "SP_GENPROGLL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, e1);
            cl.setObject(2, e2);
            cl.setObject(3, e3);
            rs = cl.executeQuery();
            while (rs.next()) {
                ProgramacionLlenado r = new ProgramacionLlenado();
                r.setIdempresa(rs.getInt("IDEMPRESA"));                
                r.setIdprogramacionllenado(rs.getString("IDPROGRAMACIONLLENADO"));
                r.setIdsucursal(rs.getInt("IDSUCURSAL"));
                r.setIdproceso(rs.getInt("IDPROCESO"));          
                r.setIdforma(rs.getInt("IDFORMA"));         
                r.setIdreglas(rs.getString("IDREGLAS"));
                r.setIdgeneracion(rs.getInt("IDGENERACION"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                r.setPROCESO(rs.getString("PROCESO"));
                r.setREGLA(rs.getString("REGLA"));
                r.setCODIGOBARRA(rs.getString("CODIGOBARRA"));
                l.add(r);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
}
