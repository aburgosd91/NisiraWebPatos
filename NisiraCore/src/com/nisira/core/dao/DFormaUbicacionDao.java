/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DFormaUbicacion;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DFormaUbicacionDao extends EntityDao<DFormaUbicacion>{

    @Override
    public DFormaUbicacion find(DFormaUbicacion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DFormaUbicacion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DFormaUbicacion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String addDFormaUbicacion(DFormaUbicacion dFormaUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dFormaUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,dFormaUbicacion.getIDEMPRESA());
                cl.setString(i++,dFormaUbicacion.getIDSUCURSAL());
                cl.setString(i++,dFormaUbicacion.getIDALMACEN());
                cl.setString(i++,dFormaUbicacion.getIDPARAMETRO());
                cl.setString(i++,dFormaUbicacion.getIDFORMACIONUBICACION());
                cl.setString(i++,dFormaUbicacion.getIDRACK());
                cl.setInt(i++,dFormaUbicacion.getPRIORIDAD());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addXmlDFormaUbicacion(String idempresa,String idsucursal,String idalmacen,
            String idparametro,String idformacionubicacion,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);/*IDEMPRESA*/
                cl.setString(i++,idsucursal);/*IDSUCURSAL*/
                cl.setString(i++,idalmacen);/*IDALMACEN*/
                cl.setString(i++,idparametro);/*IDPARAMETRO*/
                cl.setString(i++,idformacionubicacion);/*IDFORMACIONUBICACION*/
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
    public String editDFormaUbicacion(DFormaUbicacion dFormaUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dFormaUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,dFormaUbicacion.getIDEMPRESA());
                cl.setString(i++,dFormaUbicacion.getIDSUCURSAL());
                cl.setString(i++,dFormaUbicacion.getIDALMACEN());
                cl.setString(i++,dFormaUbicacion.getIDPARAMETRO());
                cl.setString(i++,dFormaUbicacion.getIDFORMACIONUBICACION());
                cl.setString(i++,dFormaUbicacion.getIDRACK());
                cl.setInt(i++,dFormaUbicacion.getPRIORIDAD());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDFormaUbicacion(DFormaUbicacion dFormaUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dFormaUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,dFormaUbicacion.getIDEMPRESA());
                cl.setString(i++,dFormaUbicacion.getIDSUCURSAL());
                cl.setString(i++,dFormaUbicacion.getIDALMACEN());
                cl.setString(i++,dFormaUbicacion.getIDPARAMETRO());
                cl.setString(i++,dFormaUbicacion.getIDFORMACIONUBICACION());
                cl.setString(i++,dFormaUbicacion.getIDRACK());
                cl.setInt(i++,dFormaUbicacion.getPRIORIDAD());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public List<DFormaUbicacion> findAll(Object e1,Object e2,Object e3,Object e4,Object e5) throws Exception {
        DFormaUbicacion dformaUbicacion = null;
        List<DFormaUbicacion> listaDFormaUbicacion=new ArrayList<DFormaUbicacion>();
        try {
            String sql = "SP_DFORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDPARAMETRO++*/
            cl.setString(7,e5.toString());/*++IDFORMACIONUBICACION++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                dformaUbicacion = new DFormaUbicacion();
                dformaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                dformaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                dformaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                dformaUbicacion.setIDPARAMETRO(rs.getString("IDPARAMETRO"));
                dformaUbicacion.setIDFORMACIONUBICACION(rs.getString("IDFORMACIONUBICACION"));
                dformaUbicacion.setIDRACK(rs.getString("IDRACK"));
                dformaUbicacion.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                listaDFormaUbicacion.add(dformaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDFormaUbicacion;
    }
    public List<DFormaUbicacion> sincronizarDformaUbi(Object ide,Object ids,Object desde,Object hasta) throws Exception {
        List<DFormaUbicacion> lista=new ArrayList<DFormaUbicacion>();
        try {
            String sql = "SP_DFORMAUBICACION_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                DFormaUbicacion dformaUbicacion = new DFormaUbicacion();
                dformaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                dformaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                dformaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                dformaUbicacion.setIDPARAMETRO(rs.getString("IDPARAMETRO"));
                dformaUbicacion.setIDFORMACIONUBICACION(rs.getString("IDFORMACIONUBICACION"));
                dformaUbicacion.setIDRACK(rs.getString("IDRACK"));
                dformaUbicacion.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                dformaUbicacion.setFECHACREACION(rs.getString("FECHACREACION"));
                lista.add(dformaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }
}
