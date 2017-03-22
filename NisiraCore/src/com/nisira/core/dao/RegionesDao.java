/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Regiones;
import com.nisira.core.entity.Regiones;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class RegionesDao extends EntityDao<Regiones>{

    @Override
    public Regiones find(Regiones e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Regiones> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Regiones> findAll(Object e1,Object e2) throws Exception {
        int idempresa=Integer.parseInt(e1.toString());
        int idplantilla=Integer.parseInt(e2.toString());
        Regiones oRegiones = null;
        List<Regiones> listaRegiones=new ArrayList<Regiones>();
        try {
            String sql = "SP_REGIONES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setInt(3,idempresa);/*++IDEMRPESA++*/
            cl.setInt(4,idplantilla);/*++IDPLANTILLA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oRegiones = new Regiones();
                oRegiones.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oRegiones.setIDPLANTILLA(rs.getInt("IDPLANTILLA"));
                oRegiones.setIDREGION(rs.getInt("IDREGION"));
                oRegiones.setJERARQUIA(rs.getInt("JERARQUIA"));
                oRegiones.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                oRegiones.setCX(rs.getInt("CX"));
                oRegiones.setCY(rs.getInt("CY"));
                oRegiones.setLargo(rs.getInt("LARGO"));
                oRegiones.setAncho(rs.getInt("ANCHO"));
                oRegiones.setIDGENERACION(rs.getInt("IDGENERACION"));
                oRegiones.setEstado(rs.getBoolean("ESTADO"));
//                oRegiones.setPLANTILLA(rs.getString("PLANTILLA"));
//                oRegiones.setGENERACION(rs.getString("GENERACION"));
                oRegiones.setIDTIPO(rs.getInt("IDTIPO"));
                oRegiones.setTIPO(rs.getString("TIPO"));
                listaRegiones.add(oRegiones);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaRegiones;
    }
    public Regiones findOne(Object e1,Object e2,Object e3) throws Exception {
        int idempresa=Integer.parseInt(e1.toString());
        int idplantilla=Integer.parseInt(e2.toString());
        int idregion=Integer.parseInt(e3.toString().equals("")?"0":e3.toString());
        Regiones oRegiones = null;
        try {
            String sql = "SP_REGIONES";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setInt(3,idempresa);/*++IDEMRPESA++*/
            cl.setInt(4,idplantilla);/*++IDPLANTILLA++*/
            cl.setInt(5,idregion);/*++IDREGION++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oRegiones = new Regiones();
                oRegiones.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oRegiones.setIDPLANTILLA(rs.getInt("IDPLANTILLA"));
                oRegiones.setIDREGION(rs.getInt("IDREGION"));
                oRegiones.setJERARQUIA(rs.getInt("JERARQUIA"));
                oRegiones.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                oRegiones.setCX(rs.getInt("CX"));
                oRegiones.setCY(rs.getInt("CY"));
                oRegiones.setLargo(rs.getInt("LARGO"));
                oRegiones.setAncho(rs.getInt("ANCHO"));
                oRegiones.setIDGENERACION(rs.getInt("IDGENERACION"));
                oRegiones.setEstado(rs.getBoolean("ESTADO"));
                oRegiones.setPLANTILLA(rs.getString("PLANTILLA"));
                oRegiones.setGENERACION(rs.getString("GENERACION"));
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return oRegiones;
    }
    public String addRegiones(Regiones regiones) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(regiones!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_REGIONES";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setInt(i++,regiones.getIDEMPRESA());
                cl.setInt(i++,regiones.getIDPLANTILLA());
                cl.setInt(i++,regiones.getIDREGION());
                cl.setInt(i++,regiones.getJERARQUIA());
                cl.setInt(i++,regiones.getPRIORIDAD());
                cl.setInt(i++,regiones.getCX());
                cl.setInt(i++,regiones.getCY());
                cl.setInt(i++,regiones.getLargo());
                cl.setInt(i++,regiones.getAncho());
                cl.setInt(i++,regiones.getIDGENERACION());
                cl.setBoolean(i++,regiones.isEstado());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("IDREGION"));                
                }
            }
        return resultado;
    }
    public String addXmlRegiones(String idempresa,String idplantilla,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_REGIONES";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);
                cl.setString(i++,idplantilla);
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
    public String editRegiones(Regiones regiones) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(regiones!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_REGIONES";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setInt(i++,regiones.getIDEMPRESA());
                cl.setInt(i++,regiones.getIDPLANTILLA());
                cl.setInt(i++,regiones.getIDREGION());
                cl.setInt(i++,regiones.getJERARQUIA());
                cl.setInt(i++,regiones.getPRIORIDAD());
                cl.setInt(i++,regiones.getCX());
                cl.setInt(i++,regiones.getCY());
                cl.setInt(i++,regiones.getLargo());
                cl.setInt(i++,regiones.getAncho());
                cl.setInt(i++,regiones.getIDGENERACION());
                cl.setBoolean(i++,regiones.isEstado());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteRegiones(Regiones regiones) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(regiones!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_REGIONES";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setInt(i++,regiones.getIDEMPRESA());
                cl.setInt(i++,regiones.getIDPLANTILLA());
                cl.setInt(i++,regiones.getIDREGION());
                cl.setInt(i++,regiones.getJERARQUIA());
                cl.setInt(i++,regiones.getPRIORIDAD());
                cl.setInt(i++,regiones.getCX());
                cl.setInt(i++,regiones.getCY());
                cl.setInt(i++,regiones.getLargo());
                cl.setInt(i++,regiones.getAncho());
                cl.setInt(i++,regiones.getIDGENERACION());
                cl.setBoolean(i++,regiones.isEstado());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }

    @Override
    public List<Regiones> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
