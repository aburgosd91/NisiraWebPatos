/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DZonaAlmacen;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class DZonaAlmacenDao extends EntityDao<DZonaAlmacen>{

    @Override
    public DZonaAlmacen find(DZonaAlmacen e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DZonaAlmacen> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DZonaAlmacen> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<DZonaAlmacen> findAll(Object e1,Object e2,Object e3) throws Exception {
        DZonaAlmacen oDZonaAlmacen = null;
        List<DZonaAlmacen> listaDZonaAlmacen=new ArrayList<DZonaAlmacen>();
        try {
            String sql = "SP_DZONAALMACEN";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDZONA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaAlmacen = new DZonaAlmacen();
                oDZonaAlmacen.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaAlmacen.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaAlmacen.setIDZONA(rs.getInt("IDZONA"));
                oDZonaAlmacen.setIDALMACEN(rs.getInt("IDALMACEN"));
                oDZonaAlmacen.setFECHACREACION(rs.getString("FECHACREACION"));
                oDZonaAlmacen.setESTADO(rs.getInt("ESTADO"));
                oDZonaAlmacen.setALMACEN(rs.getString("ALMACEN"));
                listaDZonaAlmacen.add(oDZonaAlmacen);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaAlmacen;
    }
    public String addDZonaAlmacen(DZonaAlmacen oDZonaAlmacen) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(oDZonaAlmacen!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONADIAGRAMA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setInt(i++,oDZonaAlmacen.getIDEMPRESA());
                cl.setInt(i++,oDZonaAlmacen.getIDSUCURSAL());
                cl.setInt(i++,oDZonaAlmacen.getIDZONA());
                cl.setInt(i++,oDZonaAlmacen.getIDALMACEN());
                cl.setString(i++,oDZonaAlmacen.getFECHACREACION());
                cl.setInt(i++,oDZonaAlmacen.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("IDZONA"));                
                }
            }
        return resultado;
    }
    public String addXmlDZonaAlmacen(int idempresa,int idsucursal,int idzona,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONADIAGRAMA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setInt(i++,idempresa);
                cl.setInt(i++,idsucursal);
                cl.setInt(i++,idzona);
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
    
    public List<DZonaAlmacen> sincronizarDZonaAlmacen(Object ide,Object ids,Object desde,Object hasta) throws Exception {
        DZonaAlmacen oDZonaAlmacen = null;
        List<DZonaAlmacen> listaDZonaAlmacen=new ArrayList<DZonaAlmacen>();
        try {
            String sql = "SP_DZONAALMACEN_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaAlmacen = new DZonaAlmacen();
                oDZonaAlmacen.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaAlmacen.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaAlmacen.setIDZONA(rs.getInt("IDZONA"));
                oDZonaAlmacen.setIDALMACEN(rs.getInt("IDALMACEN"));
                oDZonaAlmacen.setFECHACREACION(rs.getString("FECHACREACION"));
                oDZonaAlmacen.setESTADO(rs.getInt("ESTADO"));
                oDZonaAlmacen.setSINCRONIZA(rs.getInt("SINCRONIZA"));                        
                listaDZonaAlmacen.add(oDZonaAlmacen);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaAlmacen;
    }
}
