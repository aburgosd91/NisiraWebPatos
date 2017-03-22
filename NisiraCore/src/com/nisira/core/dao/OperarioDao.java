/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Operario;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class OperarioDao extends EntityDao<Operario>{

    @Override
    public Operario find(Operario e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Operario> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Operario> findAll(Object e1) throws Exception {
        Operario oOperario = null;
        List<Operario> listaOperario=new ArrayList<Operario>();
        try {
            String sql = "SP_OPERARIO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            int i = 1;
            cl.setInt(i++,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(i++,"");
            cl.setString(i++,"");
            cl.setString(i++,e1.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oOperario = new Operario();
                oOperario.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oOperario.setIDOPERARIO(rs.getString("IDOPERARIO"));
                oOperario.setAP_PATERNO(rs.getString("AP_PATERNO"));
                oOperario.setAP_MATERNO(rs.getString("AP_MATERNO"));
                oOperario.setNOMBRES(rs.getString("NOMBRES"));
                oOperario.setBREVETE(rs.getString("BREVETE"));
                oOperario.setESTADO(rs.getBoolean("ESTADO"));
                listaOperario.add(oOperario);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaOperario;
    }
    public String addOperario(Operario operario) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(operario!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_OPERARIO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,"");
                cl.setString(i++,operario.getIDEMPRESA());
                cl.setString(i++,operario.getIDOPERARIO());
                cl.setString(i++,operario.getAP_PATERNO());
                cl.setString(i++,operario.getAP_MATERNO());
                cl.setString(i++,operario.getNOMBRES());
                cl.setString(i++,operario.getBREVETE());
                cl.setBoolean(i++,operario.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addXmlOperario(String idempresa,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_OPERARIO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,"");/*XML*/
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        }
        catch (Exception e)
        {
            resultado = e.toString();
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String editOperario(Operario operario) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(operario!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_OPERARIO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                
                cl.setString(i++,"");
                cl.setString(i++,"");
                cl.setString(i++,operario.getIDEMPRESA());
                cl.setString(i++,operario.getIDOPERARIO());
                cl.setString(i++,operario.getAP_PATERNO());
                cl.setString(i++,operario.getAP_MATERNO());
                cl.setString(i++,operario.getNOMBRES());
                cl.setString(i++,operario.getBREVETE());
                cl.setBoolean(i++,operario.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteOperario(Operario operario) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(operario!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_OPERARIO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,"");
                cl.setString(i++,operario.getIDEMPRESA());
                cl.setString(i++,operario.getIDOPERARIO());
                cl.setString(i++,operario.getAP_PATERNO());
                cl.setString(i++,operario.getAP_MATERNO());
                cl.setString(i++,operario.getNOMBRES());
                cl.setString(i++,operario.getBREVETE());
                cl.setBoolean(i++,operario.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    
    public List<Operario> findByFiltro(String idempresa, String filtro) throws Exception{
        Operario oOperario = null;
        List<Operario> listaOperario=new ArrayList<Operario>();
        try {
            String sql = "SP_OPERARIO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            int i=1;
            cl.setInt(i++,6);
            cl.setString(i++,filtro);
            cl.setString(i++,null);
            cl.setString(i++,idempresa);
            rs = cl.executeQuery();
            while (rs.next()) {
                oOperario = new Operario();
                oOperario.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oOperario.setIDOPERARIO(rs.getString("IDOPERARIO"));
                oOperario.setAP_PATERNO(rs.getString("AP_PATERNO"));
                oOperario.setAP_MATERNO(rs.getString("AP_MATERNO"));
                oOperario.setNOMBRES(rs.getString("NOMBRES"));
                oOperario.setBREVETE(rs.getString("BREVETE"));
                oOperario.setESTADO(rs.getBoolean("ESTADO"));
                listaOperario.add(oOperario);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaOperario;
    }
    public Operario findOP(Object ide, Object o) throws Exception{
        Operario u = new Operario();
        try {
            String sql = "Select * from OPERARIO where IDEMPRESA=? and IDOPERARIO=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setObject(1, ide);
            pr.setObject(2, o);
            rs = pr.executeQuery();
            while (rs.next()) {
                u.setIDEMPRESA(rs.getString("IDEMPRESA"));
                u.setIDOPERARIO(rs.getString("IDOPERARIO"));
                u.setAP_PATERNO(rs.getString("AP_PATERNO"));
                u.setAP_MATERNO(rs.getString("AP_MATERNO"));
                u.setNOMBRES(rs.getString("NOMBRES"));
                u.setBREVETE(rs.getString("BREVETE"));
                u.setESTADO(rs.getBoolean("ESTADO"));
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return u;
    }
    public void anular(Operario operario) throws Exception{
        try {
            String sql = "Update OPERARIO SET ESTADO = 2 where IDEMPRESA=? and IDOPERARIO=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setObject(1, operario.getIDEMPRESA());
            pr.setObject(2, operario.getIDOPERARIO());
            pr.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
