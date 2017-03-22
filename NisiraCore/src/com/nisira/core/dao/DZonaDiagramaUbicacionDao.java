/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DZonaDiagrama;
import com.nisira.core.entity.DZonaDiagramaUbicacion;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class DZonaDiagramaUbicacionDao extends EntityDao<DZonaDiagramaUbicacion> {
    @Override
    public DZonaDiagramaUbicacion find(DZonaDiagramaUbicacion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DZonaDiagramaUbicacion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DZonaDiagramaUbicacion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<DZonaDiagramaUbicacion> findAll(Object e1,Object e2,Object e3) throws Exception {
        return null;
    }
    
    public List<DZonaDiagramaUbicacion> genListaComparacion(Object e1,Object e2) throws Exception{
        List<DZonaDiagramaUbicacion> lst = new ArrayList<DZonaDiagramaUbicacion>();
        int i=1;
        try {
            String sql = "SP_DZONADIAGRAMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,6);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                DZonaDiagramaUbicacion oDZonaDiagramaUbicacion = new DZonaDiagramaUbicacion();
                oDZonaDiagramaUbicacion.setIDEMPRESA(rs.getInt("IDEMPRESA"));                
                oDZonaDiagramaUbicacion.setIDZONA(rs.getInt("IDZONA"));
                oDZonaDiagramaUbicacion.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaDiagramaUbicacion.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDZonaDiagramaUbicacion.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDZonaDiagramaUbicacion.setIDUBICACION(rs.getString("IDUBICACION"));
                oDZonaDiagramaUbicacion.setIDACCESORIO(rs.getString("IDACCESORIO"));
                oDZonaDiagramaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                lst.add(oDZonaDiagramaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return lst;
    }
    
    public String addDZonaDiagramaUbicacion(DZonaDiagrama oDZonaDiagrama) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(oDZonaDiagrama!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONADIAGRAMA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setInt(i++,oDZonaDiagrama.getIDEMPRESA());
                cl.setInt(i++,oDZonaDiagrama.getIDSUCURSAL());
                cl.setInt(i++,oDZonaDiagrama.getIDZONA());
                cl.setInt(i++,oDZonaDiagrama.getCORDENADAX());
                cl.setInt(i++,oDZonaDiagrama.getCORDENADAY());
                cl.setInt(i++,oDZonaDiagrama.getIDACCESORIO());
                cl.setInt(i++,oDZonaDiagrama.getIDALMACEN());
                cl.setString(i++,oDZonaDiagrama.getIDDISTRIBUCION());
                cl.setString(i++,oDZonaDiagrama.getCOLOR());
                cl.setString(i++,oDZonaDiagrama.getFECHACREACION());
                cl.setInt(i++,oDZonaDiagrama.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("IDZONA"));                
                }
            }
        return resultado;
    }
    public String addXmlDZonaDiagramaUbicacion(int idempresa,int idsucursal,int idzona,String xml) 
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
    
    public List<DZonaDiagramaUbicacion> sincronizarDZonaDiagramaUbicacion(Object ide,Object ids,Object desde,Object hasta) throws Exception {
        DZonaDiagramaUbicacion oDZonaDiagramaUbicacion = null;
        List<DZonaDiagramaUbicacion> listaDZonaDiagramaUbicacion=new ArrayList<DZonaDiagramaUbicacion>();
        try {
            String sql = "SP_DZONADIAGRAMAUBICACION_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaDiagramaUbicacion = new DZonaDiagramaUbicacion();
                oDZonaDiagramaUbicacion.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaDiagramaUbicacion.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaDiagramaUbicacion.setIDZONA(rs.getInt("IDZONA"));
                oDZonaDiagramaUbicacion.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDZonaDiagramaUbicacion.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDZonaDiagramaUbicacion.setIDUBICACION(rs.getString("IDUBICACION"));
                oDZonaDiagramaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                oDZonaDiagramaUbicacion.setIDACCESORIO(rs.getString("IDACCESORIO"));
                oDZonaDiagramaUbicacion.setFECHACREACION(rs.getString("FECHACREACION"));
                oDZonaDiagramaUbicacion.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                listaDZonaDiagramaUbicacion.add(oDZonaDiagramaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaDiagramaUbicacion;
    }  
}
