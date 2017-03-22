/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Actividades;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class ActividadesDao  extends EntityDao<Actividades>{

    @Override
    public Actividades find(Actividades e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    public List<Actividades> findAll(Actividades e) throws Exception {
        List<Actividades> l = new ArrayList<Actividades>();
        try {
            String sql = "SP_ACTIVIDADES";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, e.getIdempresa());
            rs = cl.executeQuery();
            while (rs.next()) {
                Actividades a = new Actividades();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdactividades(rs.getInt("IDACTIVIDADES"));
                a.setDescripcion(rs.getString("DESCRIPCION"));
                a.setFecha(rs.getString("FECHACREACION"));
                a.setEstado((rs.getInt("ESTADO")));
                a.setIcono((rs.getString("ICONO")));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<Actividades> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    @Override
    public List<Actividades> findAll(Object e) throws Exception {
        List<Actividades> l = new ArrayList<Actividades>();
        try {
            String sql = "SP_ACTIVIDADES";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                Actividades a = new Actividades();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdactividades(rs.getInt("IDACTIVIDADES"));
                a.setDescripcion(rs.getString("DESCRIPCION"));
                a.setFecha(rs.getString("FECHACREACION"));
                a.setEstado((rs.getInt("ESTADO")));
                a.setIcono((rs.getString("ICONO")));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public String grabar(Actividades a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ACTIVIDADES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, 1);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdactividades());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, "");
            cl.setObject(i++, a.getEstado());
            cl.setObject(i++, a.getIcono());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String actualizar(Actividades a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ACTIVIDADES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, 2);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdactividades());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, "");
            cl.setObject(i++, a.getEstado());
            cl.setObject(i++, a.getIcono());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String anular(Actividades a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ACTIVIDADES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 3);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdactividades());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String eliminar(Actividades a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ACTIVIDADES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 4);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdactividades());
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
