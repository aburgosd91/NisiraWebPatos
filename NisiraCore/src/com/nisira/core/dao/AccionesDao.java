/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;
import com.nisira.core.entity.Acciones;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class AccionesDao extends EntityDao<Acciones>{

    @Override
    public Acciones find(Acciones e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Acciones> findAll(String e) throws Exception {
        List<Acciones> l = new ArrayList<Acciones>();
        try {
            String sql = "SP_Acciones";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                Acciones a = new Acciones();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdaccion(rs.getInt("IDACCION"));
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
    public List<Acciones> findAll(Object e) throws Exception {
        List<Acciones> l = new ArrayList<Acciones>();
        try {
            String sql = "SP_Acciones";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                Acciones a = new Acciones();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdaccion(rs.getInt("IDACCION"));
                a.setDescripcion(rs.getString("DESCRIPCION"));
                a.setFecha(rs.getString("FECHACREACION"));
                a.setEstado((rs.getInt("ESTADO")));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;//To change body of generated methods, choose Tools | Templates.
    }
    public String grabar(Acciones a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ACCIONES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, 1);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdaccion());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, "");
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
    public String actualizar(Acciones a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ACCIONES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, 2);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdaccion());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, "");
            cl.setObject(i++, a.getEstado());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } 
        finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String anular(Acciones a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ACCIONES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 3);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdaccion());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String eliminar(Acciones a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ACCIONES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 4);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdaccion());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    @Override
    public List<Acciones> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
