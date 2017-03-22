/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DAlmacenDiagrama;
import com.nisira.core.entity.Leyenda;
import com.nisira.core.entity.ZonaAlmacen;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DAlmacenDiagramaDAO extends EntityDao<DAlmacenDiagrama>{

    @Override
    public DAlmacenDiagrama find(DAlmacenDiagrama e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAlmacenDiagrama> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAlmacenDiagrama> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<ZonaAlmacen> findZonaAlmacen(int idempresa,int idsucursal) throws Exception{
        List<ZonaAlmacen> listaZonaAlmacen = new ArrayList<ZonaAlmacen>();
        try {
            String sql = "SP_ZonaAlmacen";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1,idempresa);/*GETRECORD ALMACEN(5)*/
            cl.setInt(2,idsucursal);
            rs = cl.executeQuery();
            while (rs.next()) {
                ZonaAlmacen za = new ZonaAlmacen();
                za.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                za.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                za.setIDALMACEN(rs.getInt("IDALMACEN"));
                za.setIDZONA(rs.getInt("IDZONA"));
                za.setSUCURSAL(rs.getString("SUCURSAL"));
                za.setDESCRIPCION(rs.getString("DESCRIPCION"));
                za.setALMACEN(rs.getString("ALMACEN"));
                za.setAREA(rs.getInt("area"));
                za.setAREAUNIDADDIAGRAMA(rs.getInt("AREAUNIDADDIAGRAMA"));
                za.setLARGOUNIDADDIAGRAMA(rs.getInt("LARGOUNIDADDIAGRAMA"));
                za.setANCHOUNIDADDIAGRAMA(rs.getInt("ANCHOUNIDADDIAGRAMA"));
                za.setTIPOZONA(rs.getString("TIPOZONA"));
                za.setUNIDADMEDIDA(rs.getString("UNIDADMEDIDA"));
                listaZonaAlmacen.add(za);
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return listaZonaAlmacen;
    }
    public List<DAlmacenDiagrama> findAll(Object e1,Object e2) throws Exception {
        DAlmacenDiagrama oDAlmacenDiagrama = null;
        List<DAlmacenDiagrama> listaDZonaDiagrama=new ArrayList<DAlmacenDiagrama>();
        try {
            String sql = "SP_DALAMCENDIAGRAMA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacenDiagrama = new DAlmacenDiagrama();
                oDAlmacenDiagrama.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDAlmacenDiagrama.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDAlmacenDiagrama.setIDRACK(rs.getString("IDRACK"));
                oDAlmacenDiagrama.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDAlmacenDiagrama.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDAlmacenDiagrama.setESTADO(rs.getInt("ESTADO"));
                oDAlmacenDiagrama.setIDALMACEN(rs.getInt("IDALMACEN"));
                oDAlmacenDiagrama.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacenDiagrama.setCOLORHEXADECIMAL(rs.getString("COLORHEXADECIMAL"));
                oDAlmacenDiagrama.setFECHACREACION(rs.getString("FECHACREACION"));
                listaDZonaDiagrama.add(oDAlmacenDiagrama);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaDiagrama;
    }
    public List<DAlmacenDiagrama> findAll(Object e1,Object e2,Object e3) throws Exception {
        DAlmacenDiagrama oDAlmacenDiagrama = null;
        List<DAlmacenDiagrama> listaDZonaDiagrama=new ArrayList<DAlmacenDiagrama>();
        try {
            String sql = "SP_DALAMCENDIAGRAMA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1,6);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacenDiagrama = new DAlmacenDiagrama();
                oDAlmacenDiagrama.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDAlmacenDiagrama.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDAlmacenDiagrama.setIDRACK(rs.getString("IDRACK"));
                oDAlmacenDiagrama.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDAlmacenDiagrama.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDAlmacenDiagrama.setESTADO(rs.getInt("ESTADO"));
                oDAlmacenDiagrama.setIDALMACEN(rs.getInt("IDALMACEN"));
                oDAlmacenDiagrama.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacenDiagrama.setCOLORHEXADECIMAL(rs.getString("COLORHEXADECIMAL"));
                oDAlmacenDiagrama.setFECHACREACION(rs.getString("FECHACREACION"));
                listaDZonaDiagrama.add(oDAlmacenDiagrama);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaDiagrama;
    }
    public List<Leyenda> findLeyenda(Object e1,Object e2,Object e3,Object e4,Object e5) throws Exception{
        List<Leyenda> listLeyenda = new ArrayList<Leyenda>();
        try {
            String sql = "SP_LEYENDA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setString(1,e1.toString());/*++IDTIPO++*/
            cl.setString(2,e2.toString());/*++IDEMRPESA++*/
            cl.setString(3,e3.toString());/*++IDSUCURSAL++*/
            cl.setString(4,e4.toString());/*++IDALMACEN++*/
            cl.setString(5,e5.toString());/*++IDZONAGENERAL++*/
            rs = cl.executeQuery();
            while(rs.next()){
                Leyenda l = new Leyenda();
                l.setNUM(rs.getInt("ID"));
                l.setDESCRIPCION(rs.getString("descripcion"));
                l.setCOLOR(rs.getString("COLORHEXADECIMAL"));
               listLeyenda.add(l);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listLeyenda;
    }
    
    public String addDZonaDiagrama(DAlmacenDiagrama oDAlmacenDiagrama) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(oDAlmacenDiagrama!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALAMCENDIAGRAMA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setInt(i++,oDAlmacenDiagrama.getIDEMPRESA());
                cl.setInt(i++,oDAlmacenDiagrama.getIDSUCURSAL());               
                cl.setInt(i++,oDAlmacenDiagrama.getIDALMACEN());
                cl.setInt(i++,Integer.valueOf(oDAlmacenDiagrama.getIDRACK()));
                cl.setInt(i++,oDAlmacenDiagrama.getCORDENADAX());
                cl.setInt(i++,oDAlmacenDiagrama.getCORDENADAY());
                cl.setInt(i++,oDAlmacenDiagrama.getESTADO());
                cl.setString(i++,oDAlmacenDiagrama.getIDDISTRIBUCION());
                cl.setString(i++,oDAlmacenDiagrama.getCOLORHEXADECIMAL());
                cl.setString(i++,oDAlmacenDiagrama.getFECHACREACION());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("IDRACK"));                
                }
            }
        return resultado;
    }
    public String addXmlDZonaDiagrama(int idempresa,int idsucursal,int idalmacen,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DALAMCENDIAGRAMA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setInt(i++,idempresa);
                cl.setInt(i++,idsucursal);
                cl.setInt(i++,idalmacen);
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
    public List<DAlmacenDiagrama> sincronizarDAlmacenDiagrama(Object e1,Object e2) throws Exception {
        DAlmacenDiagrama oDAlmacenDiagrama = null;
        List<DAlmacenDiagrama> listaDZonaDiagrama=new ArrayList<DAlmacenDiagrama>();
        try {
            String sql = "SP_DALAMCENDIAGRAMA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacenDiagrama = new DAlmacenDiagrama();
                oDAlmacenDiagrama.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDAlmacenDiagrama.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDAlmacenDiagrama.setIDRACK(rs.getString("IDRACK"));
                oDAlmacenDiagrama.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDAlmacenDiagrama.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDAlmacenDiagrama.setESTADO(rs.getInt("ESTADO"));
                oDAlmacenDiagrama.setIDALMACEN(rs.getInt("IDALMACEN"));
                oDAlmacenDiagrama.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDAlmacenDiagrama.setCOLORHEXADECIMAL(rs.getString("COLORHEXADECIMAL"));
                oDAlmacenDiagrama.setFECHACREACION(rs.getString("FECHACREACION"));
                oDAlmacenDiagrama.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                listaDZonaDiagrama.add(oDAlmacenDiagrama);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaDiagrama;
    }
    public void generarUbicacion(int idempresa,int idsucursal,int idalmacen,int idzona) throws Exception{
        String sql = "SP_DALMACENDIAGRAMAUBICACIONUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setInt(3,idempresa);/*++IDEMRPESA++*/
            cl.setInt(4,idsucursal);/*++IDSUCURSAL++*/
            cl.setInt(5,idalmacen);/*++IDALMACEN++*/
            cl.setInt(6, idzona);
            cl.executeUpdate();
    }
}
