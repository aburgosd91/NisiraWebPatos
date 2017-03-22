/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Dreglas;
import com.nisira.core.entity.Reglas;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ReglasDao extends EntityDao<Reglas> {

    @Override
    public Reglas find(Reglas e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reglas> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reglas> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer insertaReglas(int tipo, String xml, int idempresa, int idregla) throws Exception {
        Integer id = null;
        String sql = "SP_REGLAS_GRABAR";
        cn = obtenerConexionJTDS();
        cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
        cl.setInt(1, tipo);
        cl.setString(2, xml);
        cl.setInt(3, idempresa);
        cl.setInt(4, idregla);
        rs = cl.executeQuery();
        while (rs.next()) {
            id = rs.getInt("TABLA_ID");
        }
        return id;
    }

    public void insertaDreglas(int tipo, String xml, int idempresa, int idregla) throws Exception {
        String sql = "SP_DREGLAS_GRABAR";
        cn = obtenerConexionJTDS();
        cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
        cl.setInt(1, tipo);
        cl.setString(2, xml);
        cl.setInt(3, idempresa);
        cl.setInt(4, idregla);
        cl.executeUpdate();
    }

    public List<Reglas> findReglas(int idempresa) throws Exception {
        List<Reglas> lista = new ArrayList<Reglas>();
        try {
            String sql = "SELECT_REGLAS_ALL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setInt(1, idempresa);
            rs = cl.executeQuery();
            while (rs.next()) {
                Reglas r = new Reglas();
                r.setIdempresa(rs.getInt("IDEMPRESA"));
                r.setIdregla(rs.getInt("IDREGLA"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                r.setCantidadparametros(rs.getInt("CANTIDADPARAMETROS"));
                r.setEstado(rs.getInt("ESTADO"));
                lista.add(r);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<Dreglas> findDreglas(int idempresa, int idregla) throws Exception {
        List<Dreglas> lista = new ArrayList<Dreglas>();
        try {
            String sql = "SELECT_DREGLAS_ALL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1, idempresa);/*GETRECORD ALMACEN(5)*/

            cl.setInt(2, idregla);
            rs = cl.executeQuery();
            while (rs.next()) {
                Dreglas d = new Dreglas();
                d.setIdempresa(rs.getInt("IDEMPRESA"));
                d.setIdregla(rs.getInt("IDREGLA"));
                d.setIdparamentro(rs.getInt("IDPARAMETRO"));
                d.setDescripcion(rs.getString("DESCRIPCION"));
                d.setPrioridad(rs.getInt("PRIORIDAD"));
                d.setTipo(rs.getString("TIPO"));
                d.setValor(rs.getString("VALOR"));
                d.setCondicion(rs.getString("CONDICION"));
                d.setEstado(rs.getInt("ESTADO"));
                lista.add(d);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<Reglas> syncReglas(Object ide, Object desde, Object hasta) throws Exception {
        List<Reglas> lista = new ArrayList<Reglas>();
        try {
            String sql = "SP_REGLA_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));
            cl.setString(2, desde.toString().replace("-", "").trim());
            cl.setString(3, hasta.toString().replace("-", "").trim());
            rs = cl.executeQuery();
            while (rs.next()) {
                Reglas r = new Reglas();
                r.setIdempresa(rs.getInt("IDEMPRESA"));
                r.setIdregla(rs.getInt("IDREGLA"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                r.setCantidadparametros(rs.getInt("CANTIDADPARAMETROS"));
                r.setEstado(rs.getInt("ESTADO"));
                r.setFechacreacion(rs.getString("FECHACREACION"));
                lista.add(r);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<Dreglas> syncDReglas(Object ide, Object desde, Object hasta) throws Exception {
        List<Dreglas> lista = new ArrayList<Dreglas>();
        try {
            String sql = "SP_DREGLA_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));
            cl.setString(2, desde.toString().replace("-", "").trim());
            cl.setString(3, hasta.toString().replace("-", "").trim());
            rs = cl.executeQuery();
            while (rs.next()) {
                Dreglas d = new Dreglas();
                d.setIdempresa(rs.getInt("IDEMPRESA"));
                d.setIdregla(rs.getInt("IDREGLA"));
                d.setIdparamentro(rs.getInt("IDPARAMETRO"));
                d.setDescripcion(rs.getString("DESCRIPCION"));
                d.setPrioridad(rs.getInt("PRIORIDAD"));
                d.setTipo(rs.getString("TIPO"));
                d.setValor(rs.getString("VALOR"));
                d.setCondicion(rs.getString("CONDICION"));
                d.setEstado(rs.getInt("ESTADO"));
                d.setFechacreacion(rs.getString("FECHACREACION"));
                lista.add(d);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }
}
