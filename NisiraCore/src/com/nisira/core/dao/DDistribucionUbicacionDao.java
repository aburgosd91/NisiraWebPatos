/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DDistribucionUbicacion;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DDistribucionUbicacionDao extends EntityDao<DDistribucionUbicacion>{
    /*TIPOS DE CONSULTA A PROCEDURE SP_ALMACEN_DISTRIBUCIONUBICACION
        - INSERT(1)
        - UPDATE(2)
        - DELETE(3)->inactivo
        - SELECT- ACTIVO + DIEMPRESA +IDSUCURSAL(4)
    */
    @Override
    public DDistribucionUbicacion find(DDistribucionUbicacion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DDistribucionUbicacion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DDistribucionUbicacion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String addDDistribucionUbicacion(DDistribucionUbicacion dDistribucionUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dDistribucionUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ALMACEN_DISTRIBUCIONUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,dDistribucionUbicacion.getIDEMPRESA());
                cl.setString(i++,dDistribucionUbicacion.getIDSUCURSAL());
                cl.setString(i++,dDistribucionUbicacion.getIDALMACEN());
                cl.setString(i++,dDistribucionUbicacion.getIDDISTRIBUCION());
                cl.setString(i++,dDistribucionUbicacion.getFECHAINICIO());
                cl.setString(i++,dDistribucionUbicacion.getFECHAFIN());
                cl.setInt(i++,Integer.parseInt((dDistribucionUbicacion.getESTADO()?"1":"0")));
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String editDDistribucionUbicacion(DDistribucionUbicacion dDistribucionUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dDistribucionUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ALMACEN_DISTRIBUCIONUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,dDistribucionUbicacion.getIDEMPRESA());
                cl.setString(i++,dDistribucionUbicacion.getIDSUCURSAL());
                cl.setString(i++,dDistribucionUbicacion.getIDALMACEN());
                cl.setString(i++,dDistribucionUbicacion.getIDDISTRIBUCION());
                cl.setString(i++,dDistribucionUbicacion.getFECHAINICIO());
                cl.setString(i++,dDistribucionUbicacion.getFECHAFIN());
                cl.setInt(i++,Integer.parseInt((dDistribucionUbicacion.getESTADO()?"1":"0")));
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDDistribucionUbicacion(DDistribucionUbicacion dDistribucionUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dDistribucionUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ALMACEN_DISTRIBUCIONUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,dDistribucionUbicacion.getIDEMPRESA());
                cl.setString(i++,dDistribucionUbicacion.getIDSUCURSAL());
                cl.setString(i++,dDistribucionUbicacion.getIDALMACEN());
                cl.setString(i++,dDistribucionUbicacion.getIDDISTRIBUCION());
                cl.setString(i++,dDistribucionUbicacion.getFECHAINICIO());
                cl.setString(i++,dDistribucionUbicacion.getFECHAFIN());
                cl.setInt(i++,Integer.parseInt((dDistribucionUbicacion.getESTADO()?"1":"0")));
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String grabarRegistroTempDDistribucionUbicacionXML(String xml) throws Exception{
        String resultado = "";
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ALMACEN_DISTRIBUCIONUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
                cl.setInt(1,5);
                cl.setString(2,xml);/*XML*/
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
    public List<DDistribucionUbicacion> recordDDistribucionUbicacionEmpresaActivo(Object e1,Object e2,Object e3) throws Exception {
        DDistribucionUbicacion oDDistribucionUbicacion = null;
        List<DDistribucionUbicacion> listaDDistribucionUbicacion=new ArrayList<DDistribucionUbicacion>();
        try {
            String sql = "SP_ALMACEN_DISTRIBUCIONUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1,4);/*GETRECORD DISTRIBUCIONUBICACION(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDDistribucionUbicacion = new DDistribucionUbicacion();
                oDDistribucionUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDDistribucionUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                oDDistribucionUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDDistribucionUbicacion.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDDistribucionUbicacion.setFECHAINICIO(rs.getString("FECHAINICIO").substring(0,10));
                oDDistribucionUbicacion.setFECHAFIN(rs.getString("FECHAFIN"));
                oDDistribucionUbicacion.setESTADO(rs.getBoolean("ESTADO"));
                listaDDistribucionUbicacion.add(oDDistribucionUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDDistribucionUbicacion;
    }
    public List<DDistribucionUbicacion> findDistActivos(Object e1,Object e2,Object e3) throws Exception {
        DDistribucionUbicacion oDDistribucionUbicacion = null;
        List<DDistribucionUbicacion> listaDDistribucionUbicacion=new ArrayList<DDistribucionUbicacion>();
        try {
            String sql = "SP_ALMACEN_DISTRIBUCIONUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1,6);/*GETRECORD DISTRIBUCIONUBICACION(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDDistribucionUbicacion = new DDistribucionUbicacion();
                oDDistribucionUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDDistribucionUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                oDDistribucionUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oDDistribucionUbicacion.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDDistribucionUbicacion.setFECHAINICIO(rs.getString("FECHAINICIO").substring(0,10));
                oDDistribucionUbicacion.setFECHAFIN(rs.getString("FECHAFIN"));
                oDDistribucionUbicacion.setESTADO(rs.getBoolean("ESTADO"));
                listaDDistribucionUbicacion.add(oDDistribucionUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDDistribucionUbicacion;
    }
}
