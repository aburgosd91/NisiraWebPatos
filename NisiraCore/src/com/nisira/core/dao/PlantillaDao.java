/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Plantilla;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class PlantillaDao  extends EntityDao<Plantilla>{

    @Override
    public Plantilla find(Plantilla e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Plantilla> findAll(Object e1) throws Exception {
        Plantilla oPlantilla = null;
        List<Plantilla> listaPlantilla=new ArrayList<Plantilla>();
        try {
            String sql = "SP_PLANTILLA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oPlantilla = new Plantilla();
                oPlantilla.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oPlantilla.setIDPLANTILLA(rs.getInt("IDPLANTILLA"));
                oPlantilla.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oPlantilla.setWIDTH(rs.getInt("WIDTH"));
                oPlantilla.setHEIGHT(rs.getInt("HEIGHT"));
                oPlantilla.setESTADO(rs.getBoolean("ESTADO"));
                listaPlantilla.add(oPlantilla);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaPlantilla;
    }
    public String addPlantilla(Plantilla plantilla) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(plantilla!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PLANTILLA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setInt(i++,plantilla.getIDEMPRESA());
                cl.setInt(i++,plantilla.getIDPLANTILLA());
                cl.setString(i++,plantilla.getDESCRIPCION());
                cl.setInt(i++,plantilla.getWIDTH());
                cl.setInt(i++,plantilla.getHEIGHT());
                cl.setBoolean(i++,plantilla.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("IDPLANTILLA"));                
                }
            }
        return resultado;
    }
    public String addXmlPlantilla(String idempresa,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PLANTILLA";
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
    public String editPlantilla(Plantilla plantilla) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(plantilla!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PLANTILLA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setInt(i++,plantilla.getIDEMPRESA());
                cl.setInt(i++,plantilla.getIDPLANTILLA());
                cl.setString(i++,plantilla.getDESCRIPCION());
                cl.setInt(i++,plantilla.getWIDTH());
                cl.setInt(i++,plantilla.getHEIGHT());
                cl.setBoolean(i++,plantilla.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deletePlantilla(Plantilla plantilla) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(plantilla!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PLANTILLA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setInt(i++,plantilla.getIDEMPRESA());
                cl.setInt(i++,plantilla.getIDPLANTILLA());
                cl.setString(i++,plantilla.getDESCRIPCION());
                cl.setInt(i++,plantilla.getWIDTH());
                cl.setInt(i++,plantilla.getHEIGHT());
                cl.setBoolean(i++,plantilla.isESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    @Override
    public List<Plantilla> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
