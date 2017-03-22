/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.ProgramacionUbicacionAlmacen;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class ProgramacionUbicacionAlmacenDao extends EntityDao<ProgramacionUbicacionAlmacen>{
    /*TIPOS DE CONSULTA A PROCEDURE SP_PROGRAMACIONUBICACIONALMACEN
        - INSERT(1)
        - UPDATE(2)
        - APROBAR(3)->AP
        - SELECT-TOTAL(activo-inactivo)(4)
        - INSERTAR XML
    */
    @Override
    public ProgramacionUbicacionAlmacen find(ProgramacionUbicacionAlmacen e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramacionUbicacionAlmacen> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramacionUbicacionAlmacen> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String addProgramacionUbicacionAlmacen(ProgramacionUbicacionAlmacen programacionUbicacionAlmacen) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(programacionUbicacionAlmacen!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PROGRAMACIONUBICACIONALMACEN";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,programacionUbicacionAlmacen.getIDEMPRESA());
                cl.setString(i++,programacionUbicacionAlmacen.getIDPROGRAMACIONUBICACIONALMACEN());
                cl.setString(i++,programacionUbicacionAlmacen.getIDSUCURSAL());
                cl.setString(i++,programacionUbicacionAlmacen.getIDRESPONSABLE());
                cl.setString(i++,programacionUbicacionAlmacen.getIDDOCUMENTO());
                cl.setString(i++,programacionUbicacionAlmacen.getSERIE());
                cl.setString(i++,programacionUbicacionAlmacen.getNUMERO());
                cl.setString(i++,programacionUbicacionAlmacen.getIDESTADO());
                cl.setString(i++,programacionUbicacionAlmacen.getOBSERVACION());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addXmlProgramacionUbicacionAlmacen(String idempresa,String idsucursal,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PROGRAMACIONUBICACIONALMACEN";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);
                cl.setString(i++,idsucursal);
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
    public String editProgramacionUbicacionAlmacen(ProgramacionUbicacionAlmacen programacionUbicacionAlmacen) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(programacionUbicacionAlmacen!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PROGRAMACIONUBICACIONALMACEN";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,programacionUbicacionAlmacen.getIDEMPRESA());
                cl.setString(i++,programacionUbicacionAlmacen.getIDPROGRAMACIONUBICACIONALMACEN());
                cl.setString(i++,programacionUbicacionAlmacen.getIDSUCURSAL());
                cl.setString(i++,programacionUbicacionAlmacen.getIDRESPONSABLE());
                cl.setString(i++,programacionUbicacionAlmacen.getIDDOCUMENTO());
                cl.setString(i++,programacionUbicacionAlmacen.getSERIE());
                cl.setString(i++,programacionUbicacionAlmacen.getNUMERO());
                cl.setString(i++,programacionUbicacionAlmacen.getIDESTADO());
                cl.setString(i++,programacionUbicacionAlmacen.getOBSERVACION());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteProgramacionUbicacionAlmacen(ProgramacionUbicacionAlmacen programacionUbicacionAlmacen) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(programacionUbicacionAlmacen!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_PROGRAMACIONUBICACIONALMACEN";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,programacionUbicacionAlmacen.getIDEMPRESA());
                cl.setString(i++,programacionUbicacionAlmacen.getIDPROGRAMACIONUBICACIONALMACEN());
                cl.setString(i++,programacionUbicacionAlmacen.getIDSUCURSAL());
                cl.setString(i++,programacionUbicacionAlmacen.getIDRESPONSABLE());
                cl.setString(i++,programacionUbicacionAlmacen.getIDDOCUMENTO());
                cl.setString(i++,programacionUbicacionAlmacen.getSERIE());
                cl.setString(i++,programacionUbicacionAlmacen.getNUMERO());
                cl.setString(i++,programacionUbicacionAlmacen.getIDESTADO());
                cl.setString(i++,programacionUbicacionAlmacen.getOBSERVACION());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
}
