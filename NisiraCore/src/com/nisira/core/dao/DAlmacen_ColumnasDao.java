/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Combos;
import com.nisira.core.entity.DAlmacen_Columnas;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_ColumnasDao extends EntityDao<DAlmacen_Columnas>{
    /*TIPOS DE CONSULTA A PROCEDURE SP_DALMACEN_COLUMNAS
        - INSERT(1)
        - UPDATE(2)
        - DELETE(3)->inactivo
        - SELECT-TOTAL(activo-inactivo)(4)
        - SELECT-filtrado(idempresa,idsucursal,idalmacen,idracks,IDPISO)(5)
        - INSERTAR XML
    */
    @Override
    public DAlmacen_Columnas find(DAlmacen_Columnas e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAlmacen_Columnas> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAlmacen_Columnas> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String addDAlmacen_Columnas(DAlmacen_Columnas dalmacen_columnas) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_columnas!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_COLUMNAS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_columnas.getIDEMPRESA());
                cl.setString(i++,dalmacen_columnas.getIDSUCURSAL());
                cl.setString(i++,dalmacen_columnas.getIDALMACEN());
                cl.setString(i++,dalmacen_columnas.getIDRACK());
                cl.setString(i++,dalmacen_columnas.getIDPISO());
                cl.setString(i++,dalmacen_columnas.getIDFILA());
                cl.setString(i++,dalmacen_columnas.getIDCOLUMNA());
                cl.setString(i++,dalmacen_columnas.getIDUBICACION());
                cl.setString(i++,dalmacen_columnas.getITEMFILA());
                cl.setString(i++,dalmacen_columnas.getITEMPISO());
                cl.setString(i++,dalmacen_columnas.getITEMRACK());
                cl.setString(i++,dalmacen_columnas.getITEM());
                cl.setString(i++,dalmacen_columnas.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_columnas.getESTADO());
                cl.setString(i++,dalmacen_columnas.getCODIGOCLIENTE());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addXmlDAlmacen_Columnas(String idempresa,String idsucursal,String idalmacen,String iddistribucion,String idrack,
            String idpiso,String idfila,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_COLUMNAS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,6);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);
                cl.setString(i++,idsucursal);
                cl.setString(i++,idalmacen);
                cl.setString(i++,iddistribucion);
                cl.setString(i++,idrack);
                cl.setString(i++,idpiso);
                cl.setString(i++,idfila);
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
    public String editDAlmacen_Columnas(DAlmacen_Columnas dalmacen_columnas) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_columnas!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_COLUMNAS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_columnas.getIDEMPRESA());
                cl.setString(i++,dalmacen_columnas.getIDSUCURSAL());
                cl.setString(i++,dalmacen_columnas.getIDALMACEN());
                cl.setString(i++,dalmacen_columnas.getIDRACK());
                cl.setString(i++,dalmacen_columnas.getIDPISO());
                cl.setString(i++,dalmacen_columnas.getIDFILA());
                cl.setString(i++,dalmacen_columnas.getIDCOLUMNA());
                cl.setString(i++,dalmacen_columnas.getIDUBICACION());
                cl.setString(i++,dalmacen_columnas.getITEMFILA());
                cl.setString(i++,dalmacen_columnas.getITEMPISO());
                cl.setString(i++,dalmacen_columnas.getITEMRACK());
                cl.setString(i++,dalmacen_columnas.getITEM());
                cl.setString(i++,dalmacen_columnas.getTIPOUBICACION());
                cl.setInt(i++,(dalmacen_columnas.getESTADO()));
                cl.setString(i++,dalmacen_columnas.getCODIGOCLIENTE());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDAlmacen_Columnas(DAlmacen_Columnas dalmacen_columnas) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dalmacen_columnas!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_COLUMNAS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,dalmacen_columnas.getIDEMPRESA());
                cl.setString(i++,dalmacen_columnas.getIDSUCURSAL());
                cl.setString(i++,dalmacen_columnas.getIDALMACEN());
                cl.setString(i++,dalmacen_columnas.getIDRACK());
                cl.setString(i++,dalmacen_columnas.getIDPISO());
                cl.setString(i++,dalmacen_columnas.getIDFILA());
                cl.setString(i++,dalmacen_columnas.getIDCOLUMNA());
                cl.setString(i++,dalmacen_columnas.getIDUBICACION());
                cl.setString(i++,dalmacen_columnas.getITEMFILA());
                cl.setString(i++,dalmacen_columnas.getITEMPISO());
                cl.setString(i++,dalmacen_columnas.getITEMRACK());
                cl.setString(i++,dalmacen_columnas.getITEM());
                cl.setString(i++,dalmacen_columnas.getTIPOUBICACION());
                cl.setInt(i++,dalmacen_columnas.getESTADO());
                cl.setString(i++,dalmacen_columnas.getCODIGOCLIENTE());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String grabarRegistroTempDColumnasXML(DAlmacen_Columnas dalmacen_columnas,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALMACEN_COLUMNAS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,6);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,dalmacen_columnas.getIDEMPRESA());
                cl.setString(i++,dalmacen_columnas.getIDSUCURSAL());
                cl.setString(i++,dalmacen_columnas.getIDALMACEN());
                cl.setString(i++,dalmacen_columnas.getIDRACK());
                cl.setString(i++,dalmacen_columnas.getIDPISO());
                cl.setString(i++,dalmacen_columnas.getIDFILA());
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
    public List<DAlmacen_Columnas> findAll(Object e1,Object e2,Object e3,Object e4,Object e5,Object e6,Object e7) throws Exception {
        DAlmacen_Columnas oDAlmacen_Columnas = null;
        List<DAlmacen_Columnas> listaDAlmacen_Columnas=new ArrayList<DAlmacen_Columnas>();
        try {
            String sql = "SP_DALMACEN_COLUMNAS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
            cl.setInt(1,5);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDDISTRIBUCION++*/
            cl.setString(7,e5.toString());/*++IDRACK++*/
            cl.setString(8,e6.toString());/*++IDPISO++*/
            cl.setString(9,e7.toString());/*++IDFILA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Columnas = new DAlmacen_Columnas();
                oDAlmacen_Columnas.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Columnas.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Columnas.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Columnas.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Columnas.setIDPISO(rs.getString("IDPISO"));
                oDAlmacen_Columnas.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Columnas.setIDFILA(rs.getString("IDFILA"));
                oDAlmacen_Columnas.setIDCOLUMNA(rs.getString("IDCOLUMNA"));
                oDAlmacen_Columnas.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Columnas.setITEMFILA(rs.getString("ITEMFILA"));
                oDAlmacen_Columnas.setITEMPISO(rs.getString("ITEMPISO"));
                oDAlmacen_Columnas.setITEMRACK(rs.getString("ITEMRACK"));
                oDAlmacen_Columnas.setITEM(rs.getString("ITEM"));
                oDAlmacen_Columnas.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Columnas.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Columnas.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                listaDAlmacen_Columnas.add(oDAlmacen_Columnas);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Columnas;
    }
    public List<DAlmacen_Columnas> findAllDistribucionActiva(Object e1,Object e2,Object e3,Object e4,Object e5) throws Exception {
        DAlmacen_Columnas oDAlmacen_Columnas = null;
        List<DAlmacen_Columnas> listaDAlmacen_Columnas=new ArrayList<DAlmacen_Columnas>();
        try {
            String sql = "SP_DALMACEN_COLUMNAS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDRACK++*/
            cl.setString(7,e5.toString());/*++IDPISO++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Columnas = new DAlmacen_Columnas();
                oDAlmacen_Columnas.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Columnas.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Columnas.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Columnas.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Columnas.setIDPISO(rs.getString("IDPISO"));
                oDAlmacen_Columnas.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Columnas.setIDFILA(rs.getString("IDFILA"));
                oDAlmacen_Columnas.setIDCOLUMNA(rs.getString("IDCOLUMNA"));
                oDAlmacen_Columnas.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Columnas.setITEMFILA(rs.getString("ITEMFILA"));
                oDAlmacen_Columnas.setITEMPISO(rs.getString("ITEMPISO"));
                oDAlmacen_Columnas.setITEMRACK(rs.getString("ITEMRACK"));
                oDAlmacen_Columnas.setITEM(rs.getString("ITEM"));
                oDAlmacen_Columnas.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Columnas.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Columnas.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                listaDAlmacen_Columnas.add(oDAlmacen_Columnas);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Columnas;
    }
    public List<DAlmacen_Racks> findAllRacksFilasColumnas(Object e1,Object e2,Object e3,Object e4,Object e5,Object e6) throws Exception {
        DAlmacen_Racks oDAlmacen_Racks=null;
        List<DAlmacen_Racks> listaDAlmacen_Racks=new ArrayList<DAlmacen_Racks>();
        try {
            String sql = "SP_DALMACEN_COLUMNAS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
            cl.setInt(1,9);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,"");/*++IDDISTRIBUCION++*/
            cl.setString(7,e4.toString());/*++IDRACK++*/
            cl.setString(8,e5.toString());/*++IDPISO++*/
            cl.setString(9,e6.toString());/*++IDFILA++*/
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
                oDAlmacen_Racks.setSELECCION(false);
                oDAlmacen_Racks.setFILAS(rs.getInt("FILAS"));
                oDAlmacen_Racks.setCOLUMNAS(rs.getInt("COLUMNAS"));
                listaDAlmacen_Racks.add(oDAlmacen_Racks);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Racks;
    }
    public List<Integer> filaXcolumna(Object e1,Object e2,Object e3,Object e4,Object e5) throws Exception {
        List<Integer> parametros=new ArrayList<Integer>();
        try {
            String sql = "SP_DALMACEN_COLUMNAS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(7,e4.toString());/*++IDRACK++*/
            cl.setString(8,e5.toString());/*++IDPISO++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                parametros.add(rs.getInt("FILAS"));
                parametros.add(rs.getInt("COLUMNAS"));
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return parametros;
    }
    public List<Combos> cboRackFilasColumnas(Object e1,Object e2,Object e3,Object e4,Object e5,Object e6,Object e7) throws Exception {
        List<Combos> parametros=new ArrayList<Combos>();
        Combos cbo;
        try {
            String sql = "SP_DALMACEN_COLUMNAS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
            cl.setInt(1,10);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDDISTRIBUCION++*/
            cl.setString(7,e5.toString());/*++IDRACK++*/
            cl.setString(8,e6.toString());/*++IDPISO++*/
            cl.setString(9,e7.toString());/*++IDFILA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                cbo=new Combos();
                cbo.setID(rs.getInt("ID"));
                cbo.setDESCRIPCION(rs.getString("DESCRIPCION"));
                cbo.setFilas(rs.getInt("FILAS"));
                cbo.setColumnas(rs.getInt("COLUMNAS"));
                cbo.setESTADO(rs.getBoolean("ESTADO"));
                parametros.add(cbo);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return parametros;
    }
    public List<DAlmacen_Racks> findAllRacksPisosFilasColumnasTotal(Object e1,Object e2,Object e3,Object e4,Object e5,Object e6) throws Exception {
        DAlmacen_Racks oDAlmacen_Racks=null;
        List<DAlmacen_Racks> listaDAlmacen_Racks=new ArrayList<DAlmacen_Racks>();
        try {
            String sql = "SP_DALMACEN_COLUMNAS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
            cl.setInt(1,11);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,"");/*++IDDISTRIBUCION++*/
            cl.setString(7,e4.toString());/*++IDRACK++*/
            cl.setString(8,e5.toString());/*++IDPISO++*/
            cl.setString(9,e6.toString());/*++IDFILA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Racks = new DAlmacen_Racks();
                oDAlmacen_Racks.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Racks.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Racks.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Racks.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Racks.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Racks.setIDTIPORACK(rs.getInt("IDTIPORACKS"));
                oDAlmacen_Racks.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Racks.setITEM(rs.getString("ITEM"));
                oDAlmacen_Racks.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Racks.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Racks.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                oDAlmacen_Racks.setCAPACIDAD(rs.getInt("CAPACIDAD"));
                oDAlmacen_Racks.setSELECCION(false);
                oDAlmacen_Racks.setFILAS(rs.getInt("FILAS"));
                oDAlmacen_Racks.setCOLUMNAS(rs.getInt("COLUMNAS"));
                oDAlmacen_Racks.setPISOS(rs.getInt("PISOS"));
                oDAlmacen_Racks.setTIPORACKS(rs.getString("TIPORACKS"));
                listaDAlmacen_Racks.add(oDAlmacen_Racks);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Racks;
    }
    public List<DAlmacen_Columnas> sincronizarDAlmacen_Columnas(Object ide,Object ids,Object desde,Object hasta) throws Exception {
        DAlmacen_Columnas oDAlmacen_Columnas = null;
        List<DAlmacen_Columnas> listaDAlmacen_Columnas=new ArrayList<DAlmacen_Columnas>();
        try {
            String sql = "SP_DALMACEN_COLUMNAS_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Columnas = new DAlmacen_Columnas();
                oDAlmacen_Columnas.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Columnas.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Columnas.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Columnas.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Columnas.setIDPISO(rs.getString("IDPISO"));
                oDAlmacen_Columnas.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Columnas.setIDFILA(rs.getString("IDFILA"));
                oDAlmacen_Columnas.setIDCOLUMNA(rs.getString("IDCOLUMNA"));
                oDAlmacen_Columnas.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Columnas.setITEMFILA(rs.getString("ITEMFILA"));
                oDAlmacen_Columnas.setITEMPISO(rs.getString("ITEMPISO"));
                oDAlmacen_Columnas.setITEMRACK(rs.getString("ITEMRACK"));
                oDAlmacen_Columnas.setITEM(rs.getString("ITEM"));
                oDAlmacen_Columnas.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Columnas.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Columnas.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                oDAlmacen_Columnas.setFECHACREACION(rs.getString("FECHACREACION"));
                oDAlmacen_Columnas.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                listaDAlmacen_Columnas.add(oDAlmacen_Columnas);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Columnas;
    }
    public List<DAlmacen_Columnas> findAll(Object e1,Object e2,Object e3,Object e4,Object e5,Object e6) throws Exception {
        DAlmacen_Columnas oDAlmacen_Columnas = null;
        List<DAlmacen_Columnas> listaDAlmacen_Columnas=new ArrayList<DAlmacen_Columnas>();
        try {
            String sql = "SP_DALMACEN_COLUMNAS_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setString(1,e1.toString());/*++IDEMRPESA++*/
            cl.setString(2,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(3,e3.toString());/*++IDALMACEN++*/
            cl.setString(4,e4.toString());/*++IDDISTRIBUCION++*/
            cl.setString(5,e5.toString());/*++IDRACK++*/
            cl.setString(6,e6.toString());/*++IDPISO++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacen_Columnas = new DAlmacen_Columnas();
                oDAlmacen_Columnas.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDAlmacen_Columnas.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDAlmacen_Columnas.setIDALMACEN(rs.getString("IDALMACEN"));
                oDAlmacen_Columnas.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacen_Columnas.setIDPISO(rs.getString("IDPISO"));
                oDAlmacen_Columnas.setIDRACK(rs.getString("IDRACK"));
                oDAlmacen_Columnas.setIDFILA(rs.getString("IDFILA"));
                oDAlmacen_Columnas.setIDCOLUMNA(rs.getString("IDCOLUMNA"));
                oDAlmacen_Columnas.setIDUBICACION(rs.getString("IDUBICACION"));
                oDAlmacen_Columnas.setITEMFILA(rs.getString("ITEMFILA"));
                oDAlmacen_Columnas.setITEMPISO(rs.getString("ITEMPISO"));
                oDAlmacen_Columnas.setITEMRACK(rs.getString("ITEMRACK"));
                oDAlmacen_Columnas.setITEM(rs.getString("ITEM"));
                oDAlmacen_Columnas.setTIPOUBICACION(rs.getString("TIPOUBICACION"));
                oDAlmacen_Columnas.setESTADO(rs.getInt("ESTADO"));
                oDAlmacen_Columnas.setCODIGOCLIENTE(rs.getString("CODIGOCLIENTE"));
                listaDAlmacen_Columnas.add(oDAlmacen_Columnas);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDAlmacen_Columnas;
    }
}
