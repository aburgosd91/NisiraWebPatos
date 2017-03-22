/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DAlmacen_Filas;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_FilasDao extends EntityDao<DAlmacen_Filas>{
    /*TIPOS DE CONSULTA A PROCEDURE SP_DALMACEN_FILAS
        - INSERT(1)
        - UPDATE(2)
        - DELETE(3)->inactivo
        - SELECT-TOTAL(activo-inactivo)(4)
        - SELECT-filtrado(idempresa,idsucursal,idalmacen,idracks,IDPISO)(5)
        - INSERTAR XML
    */
    @Override
    public DAlmacen_Filas find(DAlmacen_Filas e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAlmacen_Filas> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAlmacen_Filas> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String addDAlmacen_Filas(DAlmacen_Filas dalmacen_filas) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_filas!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_FILAS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_filas.getIDEMPRESA());
                cl.setString(i++,dalmacen_filas.getIDSUCURSAL());
                cl.setString(i++,dalmacen_filas.getIDALMACEN());
                cl.setString(i++,dalmacen_filas.getIDRACK());
                cl.setString(i++,dalmacen_filas.getIDPISO());
                cl.setString(i++,dalmacen_filas.getIDFILA());
                cl.setString(i++,dalmacen_filas.getIDUBICACION());
                cl.setString(i++,dalmacen_filas.getITEMPISO());
                cl.setString(i++,dalmacen_filas.getITEMRACK());
                cl.setString(i++,dalmacen_filas.getITEM());
                cl.setString(i++,dalmacen_filas.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_filas.getESTADO());
                cl.setString(i++,dalmacen_filas.getCODIGOCLIENTE());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addDFilaXML(String idempresa,String idsucursal,String idalmacen,String iddistribucion,String idrack,String idpiso,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_FILAS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,6);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);
                cl.setString(i++,idsucursal);
                cl.setString(i++,idalmacen);
                cl.setString(i++,iddistribucion);
                cl.setString(i++,idrack);
                cl.setString(i++,idpiso);
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
    public String editDAlmacen_Filas(DAlmacen_Filas dalmacen_filas) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_filas!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_FILAS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_filas.getIDEMPRESA());
                cl.setString(i++,dalmacen_filas.getIDSUCURSAL());
                cl.setString(i++,dalmacen_filas.getIDALMACEN());
                cl.setString(i++,dalmacen_filas.getIDRACK());
                cl.setString(i++,dalmacen_filas.getIDPISO());
                cl.setString(i++,dalmacen_filas.getIDFILA());
                cl.setString(i++,dalmacen_filas.getIDUBICACION());
                cl.setString(i++,dalmacen_filas.getITEMPISO());
                cl.setString(i++,dalmacen_filas.getITEMRACK());
                cl.setString(i++,dalmacen_filas.getITEM());
                cl.setString(i++,dalmacen_filas.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_filas.getESTADO());
                cl.setString(i++,dalmacen_filas.getCODIGOCLIENTE());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDAlmacen_Filas(DAlmacen_Filas dalmacen_filas) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_filas!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_FILAS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_filas.getIDEMPRESA());
                cl.setString(i++,dalmacen_filas.getIDSUCURSAL());
                cl.setString(i++,dalmacen_filas.getIDALMACEN());
                cl.setString(i++,dalmacen_filas.getIDRACK());
                cl.setString(i++,dalmacen_filas.getIDPISO());
                cl.setString(i++,dalmacen_filas.getIDFILA());
                cl.setString(i++,dalmacen_filas.getIDUBICACION());
                cl.setString(i++,dalmacen_filas.getITEMPISO());
                cl.setString(i++,dalmacen_filas.getITEMRACK());
                cl.setString(i++,dalmacen_filas.getITEM());
                cl.setString(i++,dalmacen_filas.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_filas.getESTADO());
                cl.setString(i++,dalmacen_filas.getCODIGOCLIENTE());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String grabarRegistroTempDFilasXML(DAlmacen_Filas dalmacen_filas,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_FILAS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?)}");
                cl.setInt(i++,6);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,dalmacen_filas.getIDEMPRESA());
                cl.setString(i++,dalmacen_filas.getIDSUCURSAL());
                cl.setString(i++,dalmacen_filas.getIDALMACEN());
                cl.setString(i++,dalmacen_filas.getIDRACK());
                cl.setString(i++,dalmacen_filas.getIDPISO());
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
    public List<DAlmacen_Filas> findAll(Object e1,Object e2,Object e3,Object e4,Object e5,Object e6) throws Exception {
        DAlmacen_Filas oDAlmacen_Filas = null;
        List<DAlmacen_Filas> listaDAlmacen_Filas=new ArrayList<DAlmacen_Filas>();
        try {
            String sql = "SP_DALMACEN_FILAS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
            cl.setInt(1,5);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDDISTRIBUCION++*/
            cl.setString(7,e5.toString());/*++IDRACK++*/
            cl.setString(8,e6.toString());/*++IDPISO++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Filas = new DAlmacen_Filas();
                oDAlmacen_Filas.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Filas.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Filas.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Filas.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Filas.setIDPISO(rs.getString("IDPISO"));
                oDAlmacen_Filas.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Filas.setIDFILA(rs.getString("IDFILA"));
                oDAlmacen_Filas.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Filas.setITEMPISO(rs.getString("ITEMPISO"));
                oDAlmacen_Filas.setITEMRACK(rs.getString("ITEMRACK"));
                oDAlmacen_Filas.setITEM(rs.getString("ITEM"));
                oDAlmacen_Filas.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Filas.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Filas.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                listaDAlmacen_Filas.add(oDAlmacen_Filas);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Filas;
    }
    public List<DAlmacen_Filas> sincronizarDAlmacen_Filas(Object e1,Object e2) throws Exception {
        DAlmacen_Filas oDAlmacen_Filas = null;
        List<DAlmacen_Filas> listaDAlmacen_Filas=new ArrayList<DAlmacen_Filas>();
        try {
            String sql = "SP_DALMACEN_FILAS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Filas = new DAlmacen_Filas();
                oDAlmacen_Filas.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Filas.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Filas.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Filas.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Filas.setIDPISO(rs.getString("IDPISO"));
                oDAlmacen_Filas.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Filas.setIDFILA(rs.getString("IDFILA"));
                oDAlmacen_Filas.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Filas.setITEMPISO(rs.getString("ITEMPISO"));
                oDAlmacen_Filas.setITEMRACK(rs.getString("ITEMRACK"));
                oDAlmacen_Filas.setITEM(rs.getString("ITEM"));
                oDAlmacen_Filas.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Filas.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Filas.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                oDAlmacen_Filas.setFECHACREACION(rs.getString("FECHACREACION"));
                oDAlmacen_Filas.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                listaDAlmacen_Filas.add(oDAlmacen_Filas);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Filas;
    }
    public List<DAlmacen_Filas> syncProgalm(Object ide,Object ids,Object desde,Object hasta) throws Exception{
         List<DAlmacen_Filas> listaProg = new ArrayList<DAlmacen_Filas>();
        try {
            String sql = "SP_DALMACEN_FILAS_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                DAlmacen_Filas oDAlmacen_Filas = new DAlmacen_Filas();
                oDAlmacen_Filas.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Filas.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Filas.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Filas.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Filas.setIDPISO(rs.getString("IDPISO"));
                oDAlmacen_Filas.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Filas.setIDFILA(rs.getString("IDFILA"));
                oDAlmacen_Filas.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Filas.setITEMPISO(rs.getString("ITEMPISO"));
                oDAlmacen_Filas.setITEMRACK(rs.getString("ITEMRACK"));
                oDAlmacen_Filas.setITEM(rs.getString("ITEM"));
                oDAlmacen_Filas.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Filas.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Filas.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                oDAlmacen_Filas.setFECHACREACION(rs.getString("FECHACREACION"));
                oDAlmacen_Filas.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                listaProg.add(oDAlmacen_Filas);
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return listaProg;        
    }
}
