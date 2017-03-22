/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.QuickNotes;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class QuickNotesDao  extends EntityDao<QuickNotes>{
    @Override
    public QuickNotes find(QuickNotes e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<QuickNotes> findAll(String e) throws Exception {
        List<QuickNotes> l = new ArrayList<QuickNotes>();
        try {
            String sql = "SP_QuickNotes";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_QUICKNOTES */
            cl.setObject(i++, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                QuickNotes a = new QuickNotes();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdnotes(rs.getString("IDNOTES"));
                a.setMensaje(rs.getString("MENSAJE"));
                a.setFechacreacion(rs.getString("FECHACREACION"));
                a.setEstado((rs.getInt("ESTADO")));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    @Override
    public List<QuickNotes> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String grabar(QuickNotes a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_QUICKNOTES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, 1);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_QUICKNOTES */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdnotes());
            cl.setObject(i++, a.getMensaje());
            cl.setObject(i++, a.getFechacreacion());
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
    public String actualizar(QuickNotes a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_QUICKNOTES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, 2);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_QUICKNOTES */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdnotes());
            cl.setObject(i++, a.getMensaje());
            cl.setObject(i++, a.getFechacreacion());
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
    public String anular(QuickNotes a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_QUICKNOTES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 3);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_QUICKNOTES */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdnotes());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String eliminar(QuickNotes a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_QUICKNOTES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 4);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_QUICKNOTES */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdnotes());
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
    public List<QuickNotes> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
