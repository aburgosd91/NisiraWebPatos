/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DDNFormaUbicacion;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DDNFormaUbicacionDao extends EntityDao<DDNFormaUbicacion>{

    @Override
    public DDNFormaUbicacion find(DDNFormaUbicacion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DDNFormaUbicacion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DDNFormaUbicacion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String addDDNForma_Ubicacion(DDNFormaUbicacion dDNForma_Ubicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dDNForma_Ubicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DDNFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,dDNForma_Ubicacion.getIDEMPRESA());
                cl.setString(i++,dDNForma_Ubicacion.getIDSUCURSAL());
                cl.setString(i++,dDNForma_Ubicacion.getIDALMACEN());
                cl.setString(i++,dDNForma_Ubicacion.getIDNFORMACIONUBICACION());
                cl.setInt(i++,dDNForma_Ubicacion.getFILAS());
                cl.setInt(i++,dDNForma_Ubicacion.getCOLUMNAS());
                cl.setString(i++,dDNForma_Ubicacion.getIDFILA());
                cl.setString(i++,dDNForma_Ubicacion.getIDCOLUMNA());
                cl.setInt(i++,dDNForma_Ubicacion.getPRIORIDAD());
                cl.setInt(i++,dDNForma_Ubicacion.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addXmlDDNForma_Ubicacion(String idempresa,String idsucursal,String idalmacen,
            String idnformacionubicacion,int filas,int columnas,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DDNFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);/*IDEMPRESA*/
                cl.setString(i++,idsucursal);/*IDSUCURSAL*/
                cl.setString(i++,idalmacen);/*IDALMACEN*/
                cl.setString(i++,idnformacionubicacion);/*IDNFORMACIONUBICACION*/
                cl.setInt(i++,filas);/*FILAS*/
                cl.setInt(i++,columnas);/*COLUMNAS*/
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
    public String editDDNForma_Ubicacion(DDNFormaUbicacion dDNForma_Ubicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dDNForma_Ubicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DDNFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,dDNForma_Ubicacion.getIDEMPRESA());
                cl.setString(i++,dDNForma_Ubicacion.getIDSUCURSAL());
                cl.setString(i++,dDNForma_Ubicacion.getIDALMACEN());
                cl.setString(i++,dDNForma_Ubicacion.getIDNFORMACIONUBICACION());
                cl.setInt(i++,dDNForma_Ubicacion.getFILAS());
                cl.setInt(i++,dDNForma_Ubicacion.getCOLUMNAS());
                cl.setString(i++,dDNForma_Ubicacion.getIDFILA());
                cl.setString(i++,dDNForma_Ubicacion.getIDCOLUMNA());
                cl.setInt(i++,dDNForma_Ubicacion.getPRIORIDAD());
                cl.setInt(i++,dDNForma_Ubicacion.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDDNForma_Ubicacion(DDNFormaUbicacion dDNForma_Ubicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dDNForma_Ubicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DDNFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,dDNForma_Ubicacion.getIDEMPRESA());
                cl.setString(i++,dDNForma_Ubicacion.getIDSUCURSAL());
                cl.setString(i++,dDNForma_Ubicacion.getIDALMACEN());
                cl.setString(i++,dDNForma_Ubicacion.getIDNFORMACIONUBICACION());
                cl.setInt(i++,dDNForma_Ubicacion.getFILAS());
                cl.setInt(i++,dDNForma_Ubicacion.getCOLUMNAS());
                cl.setString(i++,dDNForma_Ubicacion.getIDFILA());
                cl.setString(i++,dDNForma_Ubicacion.getIDCOLUMNA());
                cl.setInt(i++,dDNForma_Ubicacion.getPRIORIDAD());
                cl.setInt(i++,dDNForma_Ubicacion.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public List<DDNFormaUbicacion> findAll(Object e1,Object e2,Object e3,
            Object e4,Object e5,Object e6) throws Exception {
        DDNFormaUbicacion dDformaUbicacion = null;
        List<DDNFormaUbicacion> listaDNForma_Ubicacion=new ArrayList<DDNFormaUbicacion>();
        try {
            String sql = "SP_DDNFORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*IDNFORMACIONUBICACION*/
            cl.setInt(7,Integer.parseInt(e5.toString()));/*FILAS*/
            cl.setInt(8,Integer.parseInt(e6.toString()));/*COLUMNAS*/
            rs = cl.executeQuery();
            while (rs.next()) {
                dDformaUbicacion = new DDNFormaUbicacion();
                dDformaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                dDformaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                dDformaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                dDformaUbicacion.setIDNFORMACIONUBICACION(rs.getString("IDNFORMACIONUBICACION"));
                dDformaUbicacion.setFILAS(rs.getInt("FILAS"));
                dDformaUbicacion.setCOLUMNAS(rs.getInt("COLUMNAS"));
                dDformaUbicacion.setIDFILA(rs.getString("IDFILA"));
                dDformaUbicacion.setIDCOLUMNA(rs.getString("IDCOLUMNA"));
                dDformaUbicacion.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                dDformaUbicacion.setESTADO(rs.getInt("ESTADO"));
                dDformaUbicacion.setSELECCIONADO(true);
                listaDNForma_Ubicacion.add(dDformaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDNForma_Ubicacion;
    }

    public List<DDNFormaUbicacion> getRecordIDNFORMACIONUBICACION(Object e1,Object e2,Object e3,Object e4,
            Object e5,Object e6) throws Exception {
        DDNFormaUbicacion dDformaUbicacion = null;
        List<DDNFormaUbicacion> listaDNForma_Ubicacion=new ArrayList<DDNFormaUbicacion>();
        try {
            String sql = "SP_DDNFORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
            cl.setInt(1,6);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*IDNFORMACIONUBICACION*/
            cl.setInt(7,Integer.parseInt(e5.toString()));/*FILAS*/
            cl.setInt(8,Integer.parseInt(e6.toString()));/*COLUMNAS*/
            rs = cl.executeQuery();
            while (rs.next()) {
                dDformaUbicacion = new DDNFormaUbicacion();
                dDformaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                dDformaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                dDformaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                dDformaUbicacion.setIDNFORMACIONUBICACION(rs.getString("IDNFORMACIONUBICACION"));
                dDformaUbicacion.setFILAS(rs.getInt("FILAS"));
                dDformaUbicacion.setCOLUMNAS(rs.getInt("COLUMNAS"));
                dDformaUbicacion.setIDFILA(rs.getString("IDFILA"));
                dDformaUbicacion.setIDCOLUMNA(rs.getString("IDCOLUMNA"));
                dDformaUbicacion.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                dDformaUbicacion.setESTADO(rs.getInt("ESTADO"));
                dDformaUbicacion.setSELECCIONADO(true);
                listaDNForma_Ubicacion.add(dDformaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDNForma_Ubicacion;
    }
    public List<DDNFormaUbicacion> findAll(Object e1,Object e2,Object e3,Object e4) throws Exception {
        DDNFormaUbicacion dDformaUbicacion = null;
        List<DDNFormaUbicacion> listaDNForma_Ubicacion=new ArrayList<DDNFormaUbicacion>();
        try {
            String sql = "SP_DDNFORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*IDNFORMACIONUBICACION*/
            rs = cl.executeQuery();
            while (rs.next()) {
                dDformaUbicacion = new DDNFormaUbicacion();
                dDformaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                dDformaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                dDformaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                dDformaUbicacion.setIDNFORMACIONUBICACION(rs.getString("IDNFORMACIONUBICACION"));
                dDformaUbicacion.setFILAS(rs.getInt("FILAS"));
                dDformaUbicacion.setCOLUMNAS(rs.getInt("COLUMNAS"));
                dDformaUbicacion.setIDFILA(rs.getString("IDFILA"));
                dDformaUbicacion.setIDCOLUMNA(rs.getString("IDCOLUMNA"));
                dDformaUbicacion.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                dDformaUbicacion.setESTADO(rs.getInt("ESTADO"));
                dDformaUbicacion.setSELECCIONADO(true);
                listaDNForma_Ubicacion.add(dDformaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDNForma_Ubicacion;
    }
    public List<DDNFormaUbicacion> syncDDNformaU(Object ide, Object ids, Object desde, Object hasta) throws Exception{
        DDNFormaUbicacion dDformaUbicacion = null;
        List<DDNFormaUbicacion> listaDNForma_Ubicacion=new ArrayList<DDNFormaUbicacion>();
        try {
            String sql = "SP_DDNFORMAUBICACION_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                dDformaUbicacion = new DDNFormaUbicacion();
                dDformaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                dDformaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                dDformaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                dDformaUbicacion.setIDNFORMACIONUBICACION(rs.getString("IDNFORMACIONUBICACION"));
                dDformaUbicacion.setFILAS(rs.getInt("FILAS"));
                dDformaUbicacion.setCOLUMNAS(rs.getInt("COLUMNAS"));
                dDformaUbicacion.setIDFILA(rs.getString("IDFILA"));
                dDformaUbicacion.setIDCOLUMNA(rs.getString("IDCOLUMNA"));
                dDformaUbicacion.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                dDformaUbicacion.setESTADO(rs.getInt("ESTADO"));
                dDformaUbicacion.setFECHACREACION(rs.getString("FECHACREACION"));
                dDformaUbicacion.setSELECCIONADO(true);
                listaDNForma_Ubicacion.add(dDformaUbicacion);
}
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDNForma_Ubicacion;
    }
}
