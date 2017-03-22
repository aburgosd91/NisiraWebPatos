/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DAlmacen_Pisos;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_PisosDao extends EntityDao<DAlmacen_Pisos>{
    /*TIPOS DE CONSULTA A PROCEDURE SP_DALMACEN_PISO
        - INSERT(1)
        - UPDATE(2)
        - DELETE(3)->inactivo
        - SELECT-TOTAL(activo-inactivo)(4)
        - SELECT-filtrado(idempresa,idsucursal,idalmacen,idracks)(5)
        - INSERTAR XML
    */
    @Override
    public DAlmacen_Pisos find(DAlmacen_Pisos e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAlmacen_Pisos> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAlmacen_Pisos> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String addDAlmacen_Pisos(DAlmacen_Pisos dalmacen_pisos) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_pisos!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_PISOS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_pisos.getIDEMPRESA());
                cl.setString(i++,dalmacen_pisos.getIDSUCURSAL());
                cl.setString(i++,dalmacen_pisos.getIDALMACEN());
                cl.setString(i++,dalmacen_pisos.getIDRACK());
                cl.setString(i++,dalmacen_pisos.getIDPISO());
                cl.setString(i++,dalmacen_pisos.getIDUBICACION());
                cl.setString(i++,dalmacen_pisos.getITEMRACK());
                cl.setString(i++,dalmacen_pisos.getITEM());
                cl.setString(i++,dalmacen_pisos.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_pisos.getESTADO());
                cl.setString(i++,dalmacen_pisos.getCODIGOCLIENTE());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String editDAlmacen_Pisos(DAlmacen_Pisos dalmacen_pisos) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_pisos!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_PISOS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_pisos.getIDEMPRESA());
                cl.setString(i++,dalmacen_pisos.getIDSUCURSAL());
                cl.setString(i++,dalmacen_pisos.getIDALMACEN());
                cl.setString(i++,dalmacen_pisos.getIDRACK());
                cl.setString(i++,dalmacen_pisos.getIDPISO());
                cl.setString(i++,dalmacen_pisos.getIDUBICACION());
                cl.setString(i++,dalmacen_pisos.getITEMRACK());
                cl.setString(i++,dalmacen_pisos.getITEM());
                cl.setString(i++,dalmacen_pisos.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_pisos.getESTADO());
                cl.setString(i++,dalmacen_pisos.getCODIGOCLIENTE());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDAlmacen_Pisos(DAlmacen_Pisos dalmacen_pisos) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_pisos!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_PISOS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_pisos.getIDEMPRESA());
                cl.setString(i++,dalmacen_pisos.getIDSUCURSAL());
                cl.setString(i++,dalmacen_pisos.getIDALMACEN());
                cl.setString(i++,dalmacen_pisos.getIDRACK());
                cl.setString(i++,dalmacen_pisos.getIDPISO());
                cl.setString(i++,dalmacen_pisos.getIDUBICACION());
                cl.setString(i++,dalmacen_pisos.getITEMRACK());
                cl.setString(i++,dalmacen_pisos.getITEM());
                cl.setString(i++,dalmacen_pisos.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_pisos.getESTADO());
                cl.setString(i++,dalmacen_pisos.getCODIGOCLIENTE());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addDPisoXML(String idempresa,String idsucursal,String idalmacen,String iddistribucion,String idrack,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_PISOS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?)}");
                cl.setInt(i++,6);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);
                cl.setString(i++,idsucursal);
                cl.setString(i++,idalmacen);
                cl.setString(i++,iddistribucion);
                cl.setString(i++,idrack);
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
    public String grabarRegistroTempDPisosXML(DAlmacen_Pisos dalmacen_pisos,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_PISOS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
                cl.setInt(i++,6);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,dalmacen_pisos.getIDEMPRESA());
                cl.setString(i++,dalmacen_pisos.getIDSUCURSAL());
                cl.setString(i++,dalmacen_pisos.getIDALMACEN());
                cl.setString(i++,dalmacen_pisos.getIDRACK());
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
    public List<DAlmacen_Pisos> findAll(Object e1,Object e2,Object e3,Object e4,Object e5) throws Exception {
        DAlmacen_Pisos oDAlmacen_Pisos = null;
        List<DAlmacen_Pisos> listaDAlmacen_Pisos=new ArrayList<DAlmacen_Pisos>();
        try {
            String sql = "SP_DALMACEN_PISOS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?)}");
            cl.setInt(1,5);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDDISTRIBUCION++*/
            cl.setString(7,e5.toString());/*++IDRACK++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Pisos = new DAlmacen_Pisos();
                oDAlmacen_Pisos.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Pisos.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Pisos.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Pisos.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Pisos.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Pisos.setIDPISO(rs.getString("IDPISO"));
                oDAlmacen_Pisos.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Pisos.setITEMRACK(rs.getString("ITEMRACK"));
                oDAlmacen_Pisos.setITEM(rs.getString("ITEM"));
                oDAlmacen_Pisos.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Pisos.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Pisos.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                listaDAlmacen_Pisos.add(oDAlmacen_Pisos);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Pisos;
    }
    public List<DAlmacen_Pisos> sincronizarDAlmacen_Pisos(Object e1,Object e2) throws Exception {
        DAlmacen_Pisos oDAlmacen_Pisos = null;
        List<DAlmacen_Pisos> listaDAlmacen_Pisos=new ArrayList<DAlmacen_Pisos>();
        try {
            String sql = "SP_DALMACEN_PISOS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Pisos = new DAlmacen_Pisos();
                oDAlmacen_Pisos.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Pisos.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Pisos.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Pisos.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Pisos.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Pisos.setIDPISO(rs.getString("IDPISO"));
                oDAlmacen_Pisos.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Pisos.setITEMRACK(rs.getString("ITEMRACK"));
                oDAlmacen_Pisos.setITEM(rs.getString("ITEM"));
                oDAlmacen_Pisos.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Pisos.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Pisos.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                oDAlmacen_Pisos.setFECHACREACION(rs.getString("FECHACREACION"));
                oDAlmacen_Pisos.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                listaDAlmacen_Pisos.add(oDAlmacen_Pisos);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Pisos;
    }
    public List<DAlmacen_Pisos> syncDalmPisos(Object ide,Object ids,Object desde,Object hasta) throws Exception{
         List<DAlmacen_Pisos> lista = new ArrayList<DAlmacen_Pisos>();
        try {
            String sql = "SP_DALMACEN_PISOS_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                DAlmacen_Pisos oDAlmacen_Pisos = new DAlmacen_Pisos();
                oDAlmacen_Pisos.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Pisos.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Pisos.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Pisos.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Pisos.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Pisos.setIDPISO(rs.getString("IDPISO"));
                oDAlmacen_Pisos.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Pisos.setITEMRACK(rs.getString("ITEMRACK"));
                oDAlmacen_Pisos.setITEM(rs.getString("ITEM"));
                oDAlmacen_Pisos.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Pisos.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Pisos.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                oDAlmacen_Pisos.setFECHACREACION(rs.getString("FECHACREACION"));
                oDAlmacen_Pisos.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                lista.add(oDAlmacen_Pisos);
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return lista;  
    }
}
