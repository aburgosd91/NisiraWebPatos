/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Almacen;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class AlmacenDao extends EntityDao<Almacen>{
  /*TIPOS DE CONSULTA A PROCEDURE SP_ALMACEN
        - INSERT(1)
        - UPDATE(2)
        - DELETE(3)->inactivo
        - SELECT-TOTAL(4)
        - SELECT-EMPRESA(5)
        - FILTRO ->EMPRESA<DESCRIPCION,DIRECCION>(6)
    */
    @Override
    public Almacen find(Almacen e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Almacen> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Almacen> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*AÑADIDOS APARTE*/
    public String addAlmacen(Almacen almacen) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(almacen!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ALMACEN";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,almacen.getIDEMPRESA());
                cl.setString(i++,almacen.getIDSUCURSAL());
                cl.setString(i++,almacen.getIDALMACEN());
                cl.setString(i++,almacen.getDESCRIPCION());
                cl.setString(i++,almacen.getDIRECCION());
                cl.setInt(i++,almacen.getIDTIPOALMACEN());
                cl.setInt(i++,almacen.getESTADO());
                cl.setString(i++,almacen.getSINCRONIZA());
                cl.setString(i++,almacen.getFECHACREACION());
                cl.setString(i++,almacen.getNOMBRE_CORTO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String editAlmacen(Almacen almacen) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(almacen!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ALMACEN";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,almacen.getIDEMPRESA());
                cl.setString(i++,almacen.getIDSUCURSAL());
                cl.setString(i++,almacen.getIDALMACEN());
                cl.setString(i++,almacen.getDESCRIPCION());
                cl.setString(i++,almacen.getDIRECCION());
                cl.setInt(i++,almacen.getIDTIPOALMACEN());
                cl.setInt(i++,almacen.getESTADO());
                cl.setString(i++,almacen.getSINCRONIZA());
                cl.setString(i++,almacen.getFECHACREACION());
                cl.setString(i++,almacen.getNOMBRE_CORTO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteAlmacen(Almacen almacen) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(almacen!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ALMACEN";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,almacen.getIDEMPRESA());
                cl.setString(i++,almacen.getIDSUCURSAL());
                cl.setString(i++,almacen.getIDALMACEN());
                cl.setString(i++,almacen.getDESCRIPCION());
                cl.setString(i++,almacen.getDIRECCION());
                cl.setInt(i++,almacen.getIDTIPOALMACEN());
                cl.setInt(i++,almacen.getESTADO());
                cl.setString(i++,almacen.getSINCRONIZA());
                cl.setString(i++,almacen.getFECHACREACION());
                cl.setString(i++,almacen.getNOMBRE_CORTO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String grabarRegistroTempAlmacenXML(String xml) throws Exception{
        String resultado = "";
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SINCR_TEMP_ALMACEN";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setString(1,"");
                cl.setString(2,"");
                cl.setString(3,xml);/*XML*/
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
    public List<Almacen> findAll(Object e1,Object e2) throws Exception {
        Almacen oAlmacen = null;
        List<Almacen> listaAlmacen=new ArrayList<Almacen>();
        try {
            String sql = "SP_ALMACEN";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,6);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oAlmacen = new Almacen();
                oAlmacen.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oAlmacen.setIDALMACEN(rs.getString("IDALMACEN"));
                oAlmacen.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oAlmacen.setSUCURSAL(rs.getString("SUCURSAL"));
                oAlmacen.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oAlmacen.setDIRECCION(rs.getString("DIRECCION"));
                oAlmacen.setIDTIPOALMACEN(rs.getInt("IDTIPOALMACEN"));
                oAlmacen.setESTADO(rs.getBoolean("ESTADO")? 1:0);
                oAlmacen.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oAlmacen.setFECHACREACION(rs.getString("FECHACREACION"));
                oAlmacen.setNOMBRE_CORTO(rs.getString("NOMBRE_CORTO"));
                listaAlmacen.add(oAlmacen);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaAlmacen;
    }
    public List<Almacen> recordAlmacenEmpresaActivo(Object e1,Object e2) throws Exception {
        Almacen oAlmacen = null;
        List<Almacen> listaAlmacen=new ArrayList<Almacen>();
        try {
            String sql = "SP_ALMACEN";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oAlmacen = new Almacen();
                oAlmacen.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oAlmacen.setIDALMACEN(rs.getString("IDALMACEN"));
                oAlmacen.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oAlmacen.setSUCURSAL(rs.getString("SUCURSAL"));
                oAlmacen.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oAlmacen.setDIRECCION(rs.getString("DIRECCION"));
                oAlmacen.setIDTIPOALMACEN(rs.getInt("IDTIPOALMACEN"));
                oAlmacen.setESTADO(rs.getBoolean("ESTADO")? 1:0);
                oAlmacen.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oAlmacen.setFECHACREACION(rs.getString("FECHACREACION"));
                oAlmacen.setNOMBRE_CORTO(rs.getString("NOMBRE_CORTO"));
                listaAlmacen.add(oAlmacen);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaAlmacen;
    }
    
    public List<Almacen> getAllByEmpresa(String idempresa) throws Exception {
        Almacen oAlmacen = null;
        List<Almacen> listaAlmacen=new ArrayList<Almacen>();
        try {
            String sql = "RETURNALMACENBY_EMPRESA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");            
            cl.setString(1,idempresa);
            rs = cl.executeQuery();
            while (rs.next()) {
                oAlmacen = new Almacen();
                oAlmacen.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oAlmacen.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oAlmacen.setIDALMACEN(rs.getString("IDALMACEN"));                
                oAlmacen.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oAlmacen.setDIRECCION(rs.getString("DIRECCION"));
                oAlmacen.setIDTIPOALMACEN(rs.getInt("IDTIPOALMACEN"));
                oAlmacen.setESTADO(rs.getBoolean("ESTADO")? 1:0);
                oAlmacen.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oAlmacen.setFECHACREACION(rs.getString("FECHACREACION"));
                oAlmacen.setNOMBRE_CORTO(rs.getString("NOMBRE_CORTO"));
                oAlmacen.setDESCRIPCIONSUCURSAL(rs.getString("DESCRIPCIONSUCURSAL"));
                listaAlmacen.add(oAlmacen);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaAlmacen;
    }
    
    public List<Almacen> sincronizarAlmacen(Object e1,Object e2,Object e3,Object e4) throws Exception {
        Almacen oAlmacen = null;
        List<Almacen> listaAlmacen=new ArrayList<Almacen>();
        try {
            String sql = "SP_ALMACEN";
            cn = obtenerConexionJTDS();
            int i=1;
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++,8);/*GETRECORD ALMACEN(5)*/
            cl.setString(i++,"");
            cl.setString(i++,e1.toString());/*++IDEMRPESA++*/
            cl.setString(i++,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(i++,"");/*++IDALMACEN++*/
            cl.setString(i++,"");/*++DESCRIPCION++*/
            cl.setString(i++,"");/*++DIRECCION++*/
            cl.setString(i++,"");/*++IDTIPOALMACEN++*/
            cl.setInt(i++,0);/*++ESTADO++*/
            cl.setString(i++,"");/*++SINCRONIZA++*/
            cl.setString(i++,"");/*++FECHACREACION++*/
            cl.setString(i++,"");/*++NOMBRE_CORTO++*/
            cl.setString(i++,e3.toString());/*++DESDE++*/
            cl.setString(i++,e4.toString());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oAlmacen = new Almacen();
                oAlmacen.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oAlmacen.setIDALMACEN(rs.getString("IDALMACEN"));
                oAlmacen.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oAlmacen.setSUCURSAL(rs.getString("SUCURSAL"));
                oAlmacen.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oAlmacen.setDIRECCION(rs.getString("DIRECCION"));
                oAlmacen.setIDTIPOALMACEN(rs.getInt("IDTIPOALMACEN"));
                oAlmacen.setESTADO(rs.getBoolean("ESTADO")? 1:0);
                oAlmacen.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oAlmacen.setFECHACREACION(rs.getString("FECHACREACION"));
                oAlmacen.setNOMBRE_CORTO(rs.getString("NOMBRE_CORTO"));
                listaAlmacen.add(oAlmacen);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaAlmacen;
    }
    public List<Almacen> findPorTipo(Object e1,Object e2,Object e3) throws Exception {
        Almacen oAlmacen = null;
        List<Almacen> listaAlmacen=new ArrayList<Almacen>();
        try {
            String sql = "SP_ALMACEN";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
            cl.setInt(1,9);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,"");/*++IDSUCURSAL++*/
            cl.setString(6,"");/*++IDSUCURSAL++*/
            cl.setString(7,"");/*++IDSUCURSAL++*/
            cl.setString(8,e3.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oAlmacen = new Almacen();
                oAlmacen.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oAlmacen.setIDALMACEN(rs.getString("IDALMACEN"));
                oAlmacen.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oAlmacen.setSUCURSAL(rs.getString("SUCURSAL"));
                oAlmacen.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oAlmacen.setDIRECCION(rs.getString("DIRECCION"));
                oAlmacen.setIDTIPOALMACEN(rs.getInt("IDTIPOALMACEN"));
                oAlmacen.setESTADO(rs.getBoolean("ESTADO")? 1:0);
                oAlmacen.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oAlmacen.setFECHACREACION(rs.getString("FECHACREACION"));
                oAlmacen.setNOMBRE_CORTO(rs.getString("NOMBRE_CORTO"));
                listaAlmacen.add(oAlmacen);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaAlmacen;
    }
}
