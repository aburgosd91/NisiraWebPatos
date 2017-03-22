/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.TipoZona;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class TipoZonaDao extends EntityDao<TipoZona>{

    @Override
    public TipoZona find(TipoZona e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoZona> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<TipoZona> findAll(Object e1) throws Exception {
        TipoZona oTipoZona = null;
        List<TipoZona> listaTipoZona=new ArrayList<TipoZona>();
        try {
            String sql = "SP_TIPOZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oTipoZona = new TipoZona();
                oTipoZona.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oTipoZona.setIDTIPOZONA(rs.getInt("IDTIPOZONA"));
                oTipoZona.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oTipoZona.setFECHACREACION(rs.getString("FECHACREACION"));
                oTipoZona.setESTADO(rs.getBoolean("ESTADO"));
                listaTipoZona.add(oTipoZona);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaTipoZona;
    }
    public List<TipoZona> findAllActivo(Object e1) throws Exception {
        TipoZona oTipoZona = null;
        List<TipoZona> listaTipoZona=new ArrayList<TipoZona>();
        try {
            String sql = "SP_TIPOZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,6);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oTipoZona = new TipoZona();
                oTipoZona.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oTipoZona.setIDTIPOZONA(rs.getInt("IDTIPOZONA"));
                oTipoZona.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oTipoZona.setFECHACREACION(rs.getString("FECHACREACION"));
                oTipoZona.setESTADO(rs.getBoolean("ESTADO"));
                listaTipoZona.add(oTipoZona);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaTipoZona;
    }
    public String addTipoZona(TipoZona tipozona) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(tipozona!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_TIPOZONA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setInt(i++,tipozona.getIDEMPRESA());
                cl.setInt(i++,tipozona.getIDTIPOZONA());
                cl.setString(i++,tipozona.getDESCRIPCION());
                cl.setString(i++,tipozona.getFECHACREACION());
                cl.setBoolean(i++,tipozona.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("IDTIPOZONA"));                
                }
            }
        return resultado;
    }
    public String addXmlTipoZona(String idempresa,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_TIPOZONA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setInt(i++,5);
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
    public String editTipoZona(TipoZona tipozona) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(tipozona!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_TIPOZONA";
                cn = obtenerConexionJTDS();
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setInt(i++,tipozona.getIDEMPRESA());
                cl.setInt(i++,tipozona.getIDTIPOZONA());
                cl.setString(i++,tipozona.getDESCRIPCION());
                cl.setString(i++,tipozona.getFECHACREACION());
                cl.setBoolean(i++,tipozona.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteTipoZona(TipoZona tipozona) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(tipozona!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_TIPOZONA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setInt(i++,tipozona.getIDEMPRESA());
                cl.setInt(i++,tipozona.getIDTIPOZONA());
                cl.setString(i++,tipozona.getDESCRIPCION());
                cl.setString(i++,tipozona.getFECHACREACION());
                cl.setBoolean(i++,tipozona.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public void anular(TipoZona tipozona) throws Exception{
        try {
            String sql = "Update TIPOZONA SET ESTADO = 2 where IDEMPRESA=? and IDTIPOZONA=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setObject(1, tipozona.getIDEMPRESA());
            pr.setObject(2, tipozona.getIDTIPOZONA());
            pr.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
