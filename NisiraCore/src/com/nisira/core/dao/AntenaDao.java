/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;
import com.nisira.core.entity.Antena;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class AntenaDao extends EntityDao<Antena>{

    @Override
    public Antena find(Antena e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Antena> findAll(String e) throws Exception {
        List<Antena> l = new ArrayList<Antena>();
        try {
            String sql = "SP_ANTENA";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ANTENA */
            cl.setObject(i++, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                Antena a = new Antena();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdantena(rs.getInt("IDANTENA"));
                a.setDescripcion(rs.getString("DESCRIPCION"));
                a.setNroserie(rs.getString("NROSERIE"));
                a.setModelo(rs.getString("MODELO"));
                a.setMarca(rs.getString("MARCA"));
                a.setFrecuencia(rs.getString("FRECUENCIA"));
                a.setEstado((rs.getInt("ESTADO")));
                a.setFechacreacion(rs.getString("FECHACREACION"));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    @Override
    public List<Antena> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String grabar(Antena a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ANTENA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, 1);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ANTENA */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdantena());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, a.getNroserie());
            cl.setObject(i++, a.getModelo());
            cl.setObject(i++, a.getMarca());
            cl.setObject(i++, a.getFrecuencia());
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
    public String actualizar(Antena a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ANTENA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, 2);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ANTENA */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdantena());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, a.getNroserie());
            cl.setObject(i++, a.getModelo());
            cl.setObject(i++, a.getMarca());
            cl.setObject(i++, a.getFrecuencia());
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
    public String anular(Antena a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ANTENA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 3);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ANTENA */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdantena());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String eliminar(Antena a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_ANTENA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 4);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ANTENA */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdantena());
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
    public List<Antena> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
