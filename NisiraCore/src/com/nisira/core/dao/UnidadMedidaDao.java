/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.UnidadMedida;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class UnidadMedidaDao extends EntityDao<UnidadMedida>  {
    public List<UnidadMedida> findAll(Object e1) throws Exception {
        UnidadMedida oUnidadMedida = null;
        List<UnidadMedida> listaUnidadMedida=new ArrayList<UnidadMedida>();
        try {
            String sql = "SP_UNIDADMEDIDA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oUnidadMedida = new UnidadMedida();
                oUnidadMedida.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oUnidadMedida.setIDUNIDAD(rs.getInt("IDUNIDADMEDIDA"));
                oUnidadMedida.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oUnidadMedida.setFACTORUNIDADDIAGRAMA(rs.getDouble("FACTORUNIDADDIAGRAMA"));
                oUnidadMedida.setFECHACREACION(rs.getString("FECHACREACION"));
                oUnidadMedida.setESTADO(rs.getBoolean("ESTADO"));
                listaUnidadMedida.add(oUnidadMedida);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaUnidadMedida;
    }
    public List<UnidadMedida> findAllActivo(Object e1) throws Exception {
        UnidadMedida oUnidadMedida = null;
        List<UnidadMedida> listaUnidadMedida=new ArrayList<UnidadMedida>();
        try {
            String sql = "SP_UNIDADMEDIDA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,6);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oUnidadMedida = new UnidadMedida();
                oUnidadMedida.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oUnidadMedida.setIDUNIDAD(rs.getInt("IDUNIDADMEDIDA"));
                oUnidadMedida.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oUnidadMedida.setFACTORUNIDADDIAGRAMA(rs.getDouble("FACTORUNIDADDIAGRAMA"));
                oUnidadMedida.setFECHACREACION(rs.getString("FECHACREACION"));
                oUnidadMedida.setESTADO(rs.getBoolean("ESTADO"));
                listaUnidadMedida.add(oUnidadMedida);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaUnidadMedida;
    }
    public String addUnidadMedida(UnidadMedida tipozona) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(tipozona!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_UNIDADMEDIDA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setInt(i++,tipozona.getIDEMPRESA());
                cl.setInt(i++,tipozona.getIDUNIDAD());
                cl.setString(i++,tipozona.getDESCRIPCION());
                cl.setDouble(i++,tipozona.getFACTORUNIDADDIAGRAMA());
                cl.setString(i++,tipozona.getFECHACREACION());
                cl.setBoolean(i++,tipozona.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("IDUNIDADMEDIDA"));                
                }
            }
        return resultado;
    }
    public String addXmlUnidadMedida(String idempresa,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_UNIDADMEDIDA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);
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
    public String editUnidadMedida(UnidadMedida tipozona) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(tipozona!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_UNIDADMEDIDA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setInt(i++,tipozona.getIDEMPRESA());
                cl.setInt(i++,tipozona.getIDUNIDAD());
                cl.setString(i++,tipozona.getDESCRIPCION());
                cl.setDouble(i++,tipozona.getFACTORUNIDADDIAGRAMA());
                cl.setString(i++,tipozona.getFECHACREACION());
                cl.setBoolean(i++,tipozona.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteUnidadMedida(UnidadMedida tipozona) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(tipozona!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_UNIDADMEDIDA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setInt(i++,tipozona.getIDEMPRESA());
                cl.setInt(i++,tipozona.getIDUNIDAD());
                cl.setString(i++,tipozona.getDESCRIPCION());
                cl.setDouble(i++,tipozona.getFACTORUNIDADDIAGRAMA());
                cl.setString(i++,tipozona.getFECHACREACION());
                cl.setBoolean(i++,tipozona.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }

    @Override
    public UnidadMedida find(UnidadMedida e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UnidadMedida> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void anular(UnidadMedida e,int estado) throws Exception{
        try {
            String sql = "Update UNIDADMEDIDA SET ESTADO = ? where IDEMPRESA=? and IDUNIDADMEDIDA=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setObject(1, estado);
            pr.setObject(2, e.getIDEMPRESA());
            pr.setObject(3, e.getIDUNIDAD());
            pr.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
