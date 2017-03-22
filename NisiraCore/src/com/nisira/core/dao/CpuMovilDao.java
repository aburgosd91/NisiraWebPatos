/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;
import com.nisira.core.entity.CpuMovil;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class CpuMovilDao extends EntityDao<CpuMovil>{

    @Override
    public CpuMovil find(CpuMovil e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<CpuMovil> findAll(String e) throws Exception {
        List<CpuMovil> l = new ArrayList<CpuMovil>();
        try {
            String sql = "SP_CPUMOVIL";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                CpuMovil a = new CpuMovil();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdcpumovil(rs.getInt("IDCPUMOVIL"));
                a.setDescripcion(rs.getString("DESCRIPCION"));
                a.setModelo(rs.getString("MODELO"));
                a.setMarca(rs.getString("MARCA"));
                a.setProcesador(rs.getInt("PROCESADOR"));
                a.setRam(rs.getInt("RAM"));
                a.setSo(rs.getString("SO"));
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
    public List<CpuMovil> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String grabar(CpuMovil a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_CPUMOVIL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, 1);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_CPUMOVIL */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdcpumovil());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, a.getModelo());
            cl.setObject(i++, a.getMarca());
            cl.setObject(i++, a.getProcesador());
            cl.setObject(i++, a.getRam());
            cl.setObject(i++, a.getSo());
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
    public String actualizar(CpuMovil a) throws Exception {
        String resultado="";
        try {
            int i=1;
            String sql = "SP_CPUMOVIL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, 2);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_CPUMOVIL */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdcpumovil());
            cl.setObject(i++, a.getDescripcion());
            cl.setObject(i++, a.getModelo());
            cl.setObject(i++, a.getMarca());
            cl.setObject(i++, a.getProcesador());
            cl.setObject(i++, a.getRam());
            cl.setObject(i++, a.getSo());
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
    public String anular(CpuMovil a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_CPUMOVIL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 3);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdcpumovil());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String eliminar(CpuMovil a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_CPUMOVIL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 4);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, a.getIdcpumovil());
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
    public List<CpuMovil> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
