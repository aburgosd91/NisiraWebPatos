/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.ReglaLlenado;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ReglaLlenadoDao extends EntityDao<ReglaLlenado> {

    @Override
    public ReglaLlenado find(ReglaLlenado e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReglaLlenado> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReglaLlenado> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ReglaLlenado> findAll(Object e1, Object e2) throws Exception {
        List<ReglaLlenado> l = new ArrayList<ReglaLlenado>();
        try {
            String sql = "SP_REGLALLENADO_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, e1);
            cl.setObject(2, e2);
            rs = cl.executeQuery();
            while (rs.next()) {
                ReglaLlenado r = new ReglaLlenado();
                r.setIdempresa(rs.getInt("IDEMPRESA"));
                r.setIdsucursal(rs.getInt("IDSUCURSAL"));
                r.setIdreglas(rs.getString("IDREGLAS"));
                r.setIdproceso(rs.getInt("IDPROCESO"));
                r.setEstado(rs.getInt("ESTADO"));
                r.setFechacreacion(rs.getString("FECHACREACION"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                l.add(r);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public List<ReglaLlenado> findAllProceso(Object e1, Object e2,Object e3) throws Exception {
        List<ReglaLlenado> l = new ArrayList<ReglaLlenado>();
        try {
            String sql = "SP_REGLALLENADO_PROCESO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, e1);
            cl.setObject(2, e2);
            cl.setObject(3, e3);
            rs = cl.executeQuery();
            while (rs.next()) {
                ReglaLlenado r = new ReglaLlenado();
                r.setIdempresa(rs.getInt("IDEMPRESA"));
                r.setIdsucursal(rs.getInt("IDSUCURSAL"));
                r.setIdreglas(rs.getString("IDREGLAS"));
                r.setIdproceso(rs.getInt("IDPROCESO"));
                r.setEstado(rs.getInt("ESTADO"));
                r.setFechacreacion(rs.getString("FECHACREACION"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                l.add(r);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public String grabar(ReglaLlenado p) throws Exception {
        List<ReglaLlenado> ln = new ArrayList<ReglaLlenado>();
        ln.add(p);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(ReglaLlenado.class);
        xmlNot = xml + xStream.toXML(ln);
        String id = "";
        try {
            String sql = "SP_REGLALLENADO_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, p.getIdempresa());
            cl.setObject(2, p.getIdsucursal());
            cl.setObject(3, p.getIdreglas());
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

    public ReglaLlenado fineOne(Object e1,Object e2,Object e3) throws Exception {
        ReglaLlenado rl = new ReglaLlenado();
        try {
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select * from REGLALLENADO where IDEMPRESA = ? and IDSUCURSAL = ? and IDREGLAS = ?");
            pr.setObject(1, e1);
            pr.setObject(2, e2);
            pr.setObject(3, e3);
            rs = pr.executeQuery();
            while (rs.next()) {
                rl.setIdempresa(rs.getInt("IDEMPRESA"));
                rl.setIdsucursal(rs.getInt("IDSUCURSAL"));
                rl.setIdreglas(rs.getString("IDREGLAS"));
                rl.setIdproceso(rs.getInt("IDPROCESO"));
                rl.setEstado(rs.getInt("ESTADO"));
                rl.setFechacreacion(rs.getString("FECHACREACION"));
                rl.setDescripcion(rs.getString("DESCRIPCION"));
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return rl;
    }
}
