/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.FormaUbicacion;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class FormaUbicacionDao extends EntityDao<FormaUbicacion>{

    @Override
    public FormaUbicacion find(FormaUbicacion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FormaUbicacion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FormaUbicacion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String addFormaUbicacion(FormaUbicacion formaUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(formaUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_FORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,formaUbicacion.getIDEMPRESA());
                cl.setString(i++,formaUbicacion.getIDSUCURSAL());
                cl.setString(i++,formaUbicacion.getIDALMACEN());
                cl.setString(i++,formaUbicacion.getIDPARAMETRO());
                cl.setString(i++,formaUbicacion.getIDFORMACIONUBICACION());
                cl.setString(i++,formaUbicacion.getDESCRIPCION());
                cl.setBoolean(i++,formaUbicacion.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addXmlFormaUbicacion(String idempresa,String idsucursal,String idalmacen,
            String idparametro,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_FORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);/*IDEMPRESA*/
                cl.setString(i++,idsucursal);/*IDSUCURSAL*/
                cl.setString(i++,idalmacen);/*IDALMACEN*/
                cl.setString(i++,idparametro);/*IDPARAMETRO*/
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
    public String editDFormaUbicacion(FormaUbicacion formaUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(formaUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_FORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,formaUbicacion.getIDEMPRESA());
                cl.setString(i++,formaUbicacion.getIDSUCURSAL());
                cl.setString(i++,formaUbicacion.getIDALMACEN());
                cl.setString(i++,formaUbicacion.getIDPARAMETRO());
                cl.setString(i++,formaUbicacion.getIDFORMACIONUBICACION());
                cl.setString(i++,formaUbicacion.getDESCRIPCION());
                cl.setBoolean(i++,formaUbicacion.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDFormaUbicacion(FormaUbicacion formaUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(formaUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_FORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,formaUbicacion.getIDEMPRESA());
                cl.setString(i++,formaUbicacion.getIDSUCURSAL());
                cl.setString(i++,formaUbicacion.getIDALMACEN());
                cl.setString(i++,formaUbicacion.getIDPARAMETRO());
                cl.setString(i++,formaUbicacion.getIDFORMACIONUBICACION());
                cl.setString(i++,formaUbicacion.getDESCRIPCION());
                cl.setBoolean(i++,formaUbicacion.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public List<FormaUbicacion> findAll(Object e1,Object e2,Object e3,Object e4) throws Exception {
        FormaUbicacion formaUbicacion = null;
        List<FormaUbicacion> listaFormaUbicacion=new ArrayList<FormaUbicacion>();
        try {
            String sql = "SP_FORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDPARAMETRO++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                formaUbicacion = new FormaUbicacion();
                formaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                formaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                formaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                formaUbicacion.setIDPARAMETRO(rs.getString("IDPARAMETRO"));
                formaUbicacion.setIDFORMACIONUBICACION(rs.getString("IDFORMACIONUBICACION"));
                formaUbicacion.setDESCRIPCION(rs.getString("DESCRIPCION"));
                formaUbicacion.setESTADO(rs.getBoolean("ESTADO"));
                listaFormaUbicacion.add(formaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaFormaUbicacion;
    }
    public List<FormaUbicacion> sincronizaFormUbi(Object ide,Object ids,Object desde,Object hasta) throws Exception {
        List<FormaUbicacion> lista=new ArrayList<FormaUbicacion>();
        try {
            String sql = "SP_FORMAUBICACION_Sync";
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                FormaUbicacion formaUbicacion = new FormaUbicacion();
                formaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                formaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                formaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                formaUbicacion.setIDPARAMETRO(rs.getString("IDPARAMETRO"));
                formaUbicacion.setIDFORMACIONUBICACION(rs.getString("IDFORMACIONUBICACION"));
                formaUbicacion.setDESCRIPCION(rs.getString("DESCRIPCION"));
                formaUbicacion.setESTADO(rs.getBoolean("ESTADO"));
                formaUbicacion.setFECHACREACION(rs.getString("FECHACREACION"));
                lista.add(formaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }
}
