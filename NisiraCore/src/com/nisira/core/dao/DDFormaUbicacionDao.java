/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DDFormaUbicacion;
import com.nisira.core.entity.DFormaUbicacion;
import com.nisira.core.entity.FormaUbicacion;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DDFormaUbicacionDao extends EntityDao<DDFormaUbicacion>{

    @Override
    public DDFormaUbicacion find(DDFormaUbicacion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DDFormaUbicacion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DDFormaUbicacion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String addDDFormaUbicacion(DDFormaUbicacion ddFormaUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(ddFormaUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DDFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,ddFormaUbicacion.getIDEMPRESA());
                cl.setString(i++,ddFormaUbicacion.getIDSUCURSAL());
                cl.setString(i++,ddFormaUbicacion.getIDALMACEN());
                cl.setString(i++,ddFormaUbicacion.getIDPARAMETRO());
                cl.setString(i++,ddFormaUbicacion.getIDFORMACIONUBICACION());
                cl.setString(i++,ddFormaUbicacion.getIDRACK());
                cl.setInt(i++,ddFormaUbicacion.getPRIORIDAD());
                cl.setString(i++,ddFormaUbicacion.getUBICACION());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addXmlDDFormaUbicacion(String idempresa,String idsucursal,String idalmacen,
            String idparametro,String idformacionubicacion,String idrack,int prioridad,String xml) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DDFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);/*IDEMPRESA*/
                cl.setString(i++,idsucursal);/*IDSUCURSAL*/
                cl.setString(i++,idalmacen);/*IDALMACEN*/
                cl.setString(i++,idparametro);/*IDPARAMETRO*/
                cl.setString(i++,idformacionubicacion);/*IDFORMACIONUBICACION*/
                cl.setString(i++,idrack);/*IDRACK*/
                cl.setInt(i++,prioridad);/*PRIORIDAD*/
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
    public String editDDFormaUbicacion(DDFormaUbicacion ddFormaUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(ddFormaUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DDFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,ddFormaUbicacion.getIDEMPRESA());
                cl.setString(i++,ddFormaUbicacion.getIDSUCURSAL());
                cl.setString(i++,ddFormaUbicacion.getIDALMACEN());
                cl.setString(i++,ddFormaUbicacion.getIDPARAMETRO());
                cl.setString(i++,ddFormaUbicacion.getIDFORMACIONUBICACION());
                cl.setString(i++,ddFormaUbicacion.getIDRACK());
                cl.setInt(i++,ddFormaUbicacion.getPRIORIDAD());
                cl.setString(i++,ddFormaUbicacion.getUBICACION());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDDFormaUbicacion(DDFormaUbicacion ddFormaUbicacion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(ddFormaUbicacion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DDFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,ddFormaUbicacion.getIDEMPRESA());
                cl.setString(i++,ddFormaUbicacion.getIDSUCURSAL());
                cl.setString(i++,ddFormaUbicacion.getIDALMACEN());
                cl.setString(i++,ddFormaUbicacion.getIDPARAMETRO());
                cl.setString(i++,ddFormaUbicacion.getIDFORMACIONUBICACION());
                cl.setString(i++,ddFormaUbicacion.getIDRACK());
                cl.setInt(i++,ddFormaUbicacion.getPRIORIDAD());
                cl.setString(i++,ddFormaUbicacion.getUBICACION());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public List<DDFormaUbicacion> findAll(Object e1,Object e2,Object e3,Object e4,Object e5,Object e6,Object e7) throws Exception {
        DDFormaUbicacion ddformaUbicacion = null;
        List<DDFormaUbicacion> listaDDFormaUbicacion=new ArrayList<DDFormaUbicacion>();
        try {
            String sql = "SP_DDFORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDALMACEN++*/
            cl.setString(6,e4.toString());/*++IDPARAMETRO++*/
            cl.setString(7,e5.toString());/*++IDFORMACIONUBICACION++*/
            cl.setString(8,e6.toString());/*++IDRACK++*/
            cl.setString(9,e7.toString());/*++PRIORIDAD++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                ddformaUbicacion = new DDFormaUbicacion();
                ddformaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                ddformaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                ddformaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                ddformaUbicacion.setIDPARAMETRO(rs.getString("IDPARAMETRO"));
                ddformaUbicacion.setIDFORMACIONUBICACION(rs.getString("IDFORMACIONUBICACION"));
                ddformaUbicacion.setIDRACK(rs.getString("IDRACK"));
                ddformaUbicacion.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                ddformaUbicacion.setUBICACION(rs.getString("UBICACION"));
                listaDDFormaUbicacion.add(ddformaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDDFormaUbicacion;
    }
}
