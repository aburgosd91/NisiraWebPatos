/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.ParametroDistribucion;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class ParametroDistribucionDao extends EntityDao<ParametroDistribucion>{

    @Override
    public ParametroDistribucion find(ParametroDistribucion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ParametroDistribucion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String addParametroDistribucion(ParametroDistribucion parametroDistribucion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(parametroDistribucion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PARAMETRO_DISTRIBUCION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,parametroDistribucion.getIDEMPRESA());
                cl.setString(i++,parametroDistribucion.getIDPARAMETRO());
                cl.setString(i++,parametroDistribucion.getNOMBRE());
                cl.setInt(i++,parametroDistribucion.getTIPO());
                cl.setString(i++,parametroDistribucion.getFECHACREACION());
                cl.setString(i++,parametroDistribucion.getFECHA_DETALLE());
                cl.setBoolean(i++,parametroDistribucion.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addXmlParametroDistribucion(String idempresa,String idsucursal,String idalmacen,
            String idparametro,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PARAMETRO_DISTRIBUCION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);/*IDEMPRESA*/
                cl.setString(i++,idsucursal);/*IDSUCURSAL*/
                cl.setString(i++,idalmacen);/*IDALMACEN*/
                cl.setString(i++,idparametro);/*IDPARAMETRO*/
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
    public String editDParametroDistribucion(ParametroDistribucion parametroDistribucion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(parametroDistribucion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PARAMETRO_DISTRIBUCION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,parametroDistribucion.getIDEMPRESA());
                cl.setString(i++,parametroDistribucion.getIDPARAMETRO());
                cl.setString(i++,parametroDistribucion.getNOMBRE());
                cl.setInt(i++,parametroDistribucion.getTIPO());
                cl.setString(i++,parametroDistribucion.getFECHACREACION());
                cl.setString(i++,parametroDistribucion.getFECHA_DETALLE());
                cl.setBoolean(i++,parametroDistribucion.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDParametroDistribucion(ParametroDistribucion parametroDistribucion) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(parametroDistribucion!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PARAMETRO_DISTRIBUCION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,parametroDistribucion.getIDEMPRESA());
                cl.setString(i++,parametroDistribucion.getIDPARAMETRO());
                cl.setString(i++,parametroDistribucion.getNOMBRE());
                cl.setInt(i++,parametroDistribucion.getTIPO());
                cl.setString(i++,parametroDistribucion.getFECHACREACION());
                cl.setString(i++,parametroDistribucion.getFECHA_DETALLE());
                cl.setBoolean(i++,parametroDistribucion.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public List<ParametroDistribucion> findAll(Object e1) throws Exception {
        ParametroDistribucion parametroDistribucion = null;
        List<ParametroDistribucion> listaParametroDistribucion=new ArrayList<ParametroDistribucion>();
        try {
            String sql = "SP_PARAMETRO_DISTRIBUCION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                parametroDistribucion = new ParametroDistribucion();
                parametroDistribucion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                parametroDistribucion.setIDPARAMETRO(rs.getString("IDPARAMETRO"));
                parametroDistribucion.setNOMBRE(rs.getString("NOMBRE"));
                parametroDistribucion.setTIPO(rs.getInt("TIPO"));
                parametroDistribucion.setFECHACREACION(rs.getString("FECHACREACION"));
                parametroDistribucion.setFECHA_DETALLE(rs.getString("FECHA_DETALLE"));
                parametroDistribucion.setESTADO(rs.getBoolean("ESTADO"));
                parametroDistribucion.setTIPOREGLA(rs.getString("TIPOREGLA"));
                listaParametroDistribucion.add(parametroDistribucion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaParametroDistribucion;
    }
    public List<ParametroDistribucion> findAllTipoParametro(Object e1,Object e2) throws Exception {
        ParametroDistribucion parametroDistribucion = null;
        List<ParametroDistribucion> listaParametroDistribucion=new ArrayList<ParametroDistribucion>();
        try {
            String sql = "SP_PARAMETRO_DISTRIBUCION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setInt(1,6);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,"");
            cl.setString(5,"");
            cl.setString(6,e2.toString());/*++TIPO PARAMETRO++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                parametroDistribucion = new ParametroDistribucion();
                parametroDistribucion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                parametroDistribucion.setIDPARAMETRO(rs.getString("IDPARAMETRO"));
                parametroDistribucion.setNOMBRE(rs.getString("NOMBRE"));
                parametroDistribucion.setTIPO(rs.getInt("TIPO"));
                parametroDistribucion.setFECHACREACION(rs.getString("FECHACREACION"));
                parametroDistribucion.setFECHA_DETALLE(rs.getString("FECHA_DETALLE"));
                parametroDistribucion.setESTADO(rs.getBoolean("ESTADO"));
                parametroDistribucion.setTIPOREGLA(rs.getString("TIPOREGLA"));
                listaParametroDistribucion.add(parametroDistribucion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaParametroDistribucion;
    }
    public void anular(String idempresa, String id) throws Exception{
        try {
            String sql = "Update PARAMETRO_DISTRIBUCION SET ESTADO = 2 where IDEMPRESA=? and IDPARAMETRO=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setObject(1, idempresa);
            pr.setObject(2, id);
            pr.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
