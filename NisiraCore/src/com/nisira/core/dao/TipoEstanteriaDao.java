/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.TipoEstanteria;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class TipoEstanteriaDao  extends EntityDao<TipoEstanteria>{

    @Override
    public TipoEstanteria find(TipoEstanteria e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    public List<TipoEstanteria> findAll(TipoEstanteria e) throws Exception {
        List<TipoEstanteria> l = new ArrayList<TipoEstanteria>();
        try {
            String sql = "SP_TIPOESTANTERIA";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_TIPOESTANTERIA */
            rs = cl.executeQuery();
            while (rs.next()) {
                TipoEstanteria a = new TipoEstanteria();
                a.setIdtipoestanteria(rs.getInt("IDTIPOESTANTERIA"));
                a.setDescripcion(rs.getString("DESCRIPCION"));
                a.setFecha(rs.getString("FECHACREACION"));
                a.setEstado((rs.getInt("ESTADO")));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<TipoEstanteria> findAll() throws Exception {
        List<TipoEstanteria> l = new ArrayList<TipoEstanteria>();
        try {
            String sql = "SP_TIPOESTANTERIA";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_TIPOESTANTERIA */
            rs = cl.executeQuery();
            while (rs.next()) {
                TipoEstanteria a = new TipoEstanteria();
                a.setIdtipoestanteria(rs.getInt("IDTIPOESTANTERIA"));
                a.setDescripcion(rs.getString("DESCRIPCION"));
                a.setFecha(rs.getString("FECHACREACION"));
                a.setEstado((rs.getInt("ESTADO")));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
        
    }
    @Override
    public List<TipoEstanteria> findAll(Object e) throws Exception {
        List<TipoEstanteria> l = new ArrayList<TipoEstanteria>();
        try {
            String sql = "SP_TIPOESTANTERIA";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_TIPOESTANTERIA */
            cl.setObject(i++, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                TipoEstanteria a = new TipoEstanteria();
                a.setIdtipoestanteria(rs.getInt("IDTIPOESTANTERIA"));
                a.setDescripcion(rs.getString("DESCRIPCION"));
                a.setFecha(rs.getString("FECHACREACION"));
                a.setEstado((rs.getInt("ESTADO")));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public String grabar(TipoEstanteria a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_TIPOESTANTERIA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?)}");
            cl.setObject(i++, 1);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_TIPOESTANTERIA */
            cl.setObject(i++, a.getIdtipoestanteria());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, a.getEstado());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String actualizar(TipoEstanteria a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_TIPOESTANTERIA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?)}");
            cl.setObject(i++, 2);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_TIPOESTANTERIA */
            cl.setObject(i++, a.getIdtipoestanteria());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, a.getEstado());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String anular(TipoEstanteria a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_TIPOESTANTERIA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(i++, 3);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_TIPOESTANTERIA */
            cl.setObject(i++, a.getIdtipoestanteria());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String eliminar(TipoEstanteria a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_TIPOESTANTERIA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 4);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_TIPOESTANTERIA */
            cl.setObject(i++, a.getIdtipoestanteria());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
}
