/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_RacksDao extends EntityDao<DAlmacen_Racks>{
    /*TIPOS DE CONSULTA A PROCEDURE SP_DALMACEN_RACKS
        - INSERT(1)
        - UPDATE(2)
        - DELETE(3)->inactivo
        - SELECT-TOTAL(activo-inactivo)(4)
        - SELECT-filtrado(idempresa,idsucursal,idalmacen)(5)
<<<<<<< HEAD
        - SELECT (*) +CAPADIDAD + DISPONIBILIDAD(7)
    */
    @Override
    public DAlmacen_Racks find(DAlmacen_Racks e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<DAlmacen_Racks> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<DAlmacen_Racks> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String addDAlmacen_Racks(DAlmacen_Racks dalmacen_racks) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_racks!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_RACKS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_racks.getIDEMPRESA());
                cl.setString(i++,dalmacen_racks.getIDSUCURSAL());
                cl.setString(i++,dalmacen_racks.getIDALMACEN());
                cl.setString(i++,dalmacen_racks.getIDRACK());
                cl.setString(i++,dalmacen_racks.getIDUBICACION());
                cl.setString(i++,dalmacen_racks.getITEM());
                cl.setString(i++,dalmacen_racks.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_racks.getESTADO());
                cl.setString(i++,dalmacen_racks.getCODIGOCLIENTE());
                cl.setInt(i++,dalmacen_racks.getIDTIPORACK());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    
    public String editDAlmacen_Racks(DAlmacen_Racks dalmacen_racks) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_racks!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_RACKS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_racks.getIDEMPRESA());
                cl.setString(i++,dalmacen_racks.getIDSUCURSAL());
                cl.setString(i++,dalmacen_racks.getIDALMACEN());
                cl.setString(i++,dalmacen_racks.getIDRACK());
                cl.setString(i++,dalmacen_racks.getIDUBICACION());
                cl.setString(i++,dalmacen_racks.getITEM());
                cl.setString(i++,dalmacen_racks.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_racks.getESTADO());
                cl.setString(i++,dalmacen_racks.getCODIGOCLIENTE());
                cl.setInt(i++,dalmacen_racks.getIDTIPORACK());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    
    public String deleteDAlmacen_Racks(DAlmacen_Racks dalmacen_racks) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_racks!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_RACKS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_racks.getIDEMPRESA());
                cl.setString(i++,dalmacen_racks.getIDSUCURSAL());
                cl.setString(i++,dalmacen_racks.getIDALMACEN());
                cl.setString(i++,dalmacen_racks.getIDRACK());
                cl.setString(i++,dalmacen_racks.getIDUBICACION());
                cl.setString(i++,dalmacen_racks.getITEM());
                cl.setString(i++,dalmacen_racks.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_racks.getESTADO());
                cl.setString(i++,dalmacen_racks.getCODIGOCLIENTE());
                cl.setInt(i++,dalmacen_racks.getIDTIPORACK());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    
    public List<DAlmacen_Racks> findAll(Object e1,Object e2,Object e3,Object e4) throws Exception {
        DAlmacen_Racks oDAlmacen_Racks = null;
        List<DAlmacen_Racks> listaDAlmacen_Racks=new ArrayList<DAlmacen_Racks>();
        try {
            String sql = "SP_DALMACEN_RACKS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setInt(1,11);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDDISTRIBUCION++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Racks = new DAlmacen_Racks();
                oDAlmacen_Racks.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Racks.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Racks.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Racks.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Racks.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Racks.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Racks.setITEM(rs.getString("ITEM"));
                oDAlmacen_Racks.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Racks.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Racks.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                oDAlmacen_Racks.setIDTIPORACK(rs.getInt("IDTIPORACKS"));
                listaDAlmacen_Racks.add(oDAlmacen_Racks);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Racks;
    }
    
    public List<DAlmacen_Racks> findAllPeriodo(Object e1,Object e2,Object e3,Object e4) throws Exception {
        DAlmacen_Racks oDAlmacen_Racks = null;
        List<DAlmacen_Racks> listaDAlmacen_Racks=new ArrayList<DAlmacen_Racks>();
        try {
            String sql = "SP_DALMACEN_RACKS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setInt(1,9);/*GETRECORD PERIODO ACTIVO(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDDISTRIBUCION++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Racks = new DAlmacen_Racks();
                oDAlmacen_Racks.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Racks.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Racks.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Racks.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Racks.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Racks.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Racks.setITEM(rs.getString("ITEM"));
                oDAlmacen_Racks.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Racks.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Racks.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                oDAlmacen_Racks.setCAPACIDAD(rs.getInt("CAPACIDAD"));
                oDAlmacen_Racks.setIDTIPORACK(rs.getInt("IDTIPORACKS"));
                listaDAlmacen_Racks.add(oDAlmacen_Racks);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Racks;
    }
    
    public List<DAlmacen_Racks> findAllCapacidad(Object e1,Object e2,Object e3,Object e4) throws Exception {
        DAlmacen_Racks oDAlmacen_Racks = null;
        List<DAlmacen_Racks> listaDAlmacen_Racks=new ArrayList<DAlmacen_Racks>();
        try {
            String sql = "SP_DALMACEN_RACKS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDDISTRIBUCION++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Racks = new DAlmacen_Racks();
                oDAlmacen_Racks.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Racks.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Racks.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Racks.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Racks.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Racks.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Racks.setITEM(rs.getString("ITEM"));
                oDAlmacen_Racks.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Racks.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Racks.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                oDAlmacen_Racks.setCAPACIDAD(rs.getInt("CAPACIDAD"));
                oDAlmacen_Racks.setIDTIPORACK(rs.getInt("IDTIPORACKS"));
                oDAlmacen_Racks.setSELECCION(false);
                listaDAlmacen_Racks.add(oDAlmacen_Racks);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Racks;
    }
    
    public String addDRackXML(String idempresa,String idsucursal,String idalmacen,String iddistribucion,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_RACKS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
                cl.setInt(i++,6);
                cl.setString(i++,xml);/*+++++++ XML +++++++*/
                cl.setString(i++,idempresa);
                cl.setString(i++,idsucursal);
                cl.setString(i++,idalmacen);
                cl.setString(i++,iddistribucion);
                //cl.registerOutParameter(6,java.sql.Types.VARCHAR);
                //cl.executeUpdate();            
                //resultado = cl.getString(6);
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
    
    public String grabarRegistroTempDRackXML(DAlmacen_Racks dalmacen_racks,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_RACKS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++,6);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,dalmacen_racks.getIDEMPRESA());
                cl.setString(i++,dalmacen_racks.getIDSUCURSAL());
                cl.setString(i++,dalmacen_racks.getIDALMACEN());
                //cl.registerOutParameter(6,java.sql.Types.VARCHAR);
                //cl.executeUpdate();            
                //resultado = cl.getString(6);
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
    
    public List<DAlmacen_Racks> sincronizarDAlmacen_Racks(Object ide,Object ids,Object desde,Object hasta) throws Exception {
        DAlmacen_Racks oDAlmacen_Racks = null;
        List<DAlmacen_Racks> listaDAlmacen_Racks=new ArrayList<DAlmacen_Racks>();
        try {
            String sql = "SP_DALMACEN_RACKS_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Racks = new DAlmacen_Racks();
                oDAlmacen_Racks.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Racks.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Racks.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Racks.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Racks.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Racks.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Racks.setITEM(rs.getString("ITEM"));
                oDAlmacen_Racks.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Racks.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Racks.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                oDAlmacen_Racks.setIDTIPORACK(rs.getInt("IDTIPORACKS"));
                oDAlmacen_Racks.setFECHACREACION(rs.getString("FECHACREACION"));
                oDAlmacen_Racks.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                listaDAlmacen_Racks.add(oDAlmacen_Racks);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Racks;
    }
}
