/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Dreglas;
import com.nisira.core.entity.Reglas;
import com.nisira.core.entity.ZonaGeneral;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ZonaGeneralDao extends EntityDao<ZonaGeneral> {


    public String addZonaGeneral(ZonaGeneral zonaGeneral) throws Exception {
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(zonaGeneral!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ZONAGENERAL";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setInt(i++,zonaGeneral.getIDEMPRESA());
                cl.setInt(i++,zonaGeneral.getIDSUCURSAL());
                cl.setInt(i++,zonaGeneral.getIDZONAGENERAL());
                cl.setInt(i++,zonaGeneral.getAREA());
                cl.setInt(i++,zonaGeneral.getLARGO());
                cl.setInt(i++,zonaGeneral.getANCHO());
                cl.setString(i++,zonaGeneral.getFECHACREACION());
                cl.setString(i++,zonaGeneral.getCODIGOEQUIVALENTE());
                cl.setInt(i++,zonaGeneral.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String editZonaGeneral(ZonaGeneral zonaGeneral) throws Exception {
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(zonaGeneral!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ZONAGENERAL";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setInt(i++,zonaGeneral.getIDEMPRESA());
                cl.setInt(i++,zonaGeneral.getIDSUCURSAL());
                cl.setInt(i++,zonaGeneral.getIDZONAGENERAL());
                cl.setInt(i++,zonaGeneral.getAREA());
                cl.setInt(i++,zonaGeneral.getLARGO());
                cl.setInt(i++,zonaGeneral.getANCHO());
                cl.setString(i++,zonaGeneral.getFECHACREACION());
                cl.setString(i++,zonaGeneral.getCODIGOEQUIVALENTE());
                cl.setInt(i++,zonaGeneral.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteZonaGeneral(ZonaGeneral zonaGeneral) throws Exception {
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(zonaGeneral!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ZONAGENERAL";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setInt(i++,zonaGeneral.getIDEMPRESA());
                cl.setInt(i++,zonaGeneral.getIDSUCURSAL());
                cl.setInt(i++,zonaGeneral.getIDZONAGENERAL());
                cl.setInt(i++,zonaGeneral.getAREA());
                cl.setInt(i++,zonaGeneral.getLARGO());
                cl.setInt(i++,zonaGeneral.getANCHO());
                cl.setString(i++,zonaGeneral.getFECHACREACION());
                cl.setString(i++,zonaGeneral.getCODIGOEQUIVALENTE());
                cl.setInt(i++,zonaGeneral.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    @Override
    public ZonaGeneral find(ZonaGeneral e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ZonaGeneral> findAll(Object e) throws Exception {
       ZonaGeneral oZonaGeneral = null;
        List<ZonaGeneral> listaZonaGeneral=new ArrayList<ZonaGeneral>();
        try {
            String sql = "SP_ZONAGENERAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oZonaGeneral = new ZonaGeneral();
                oZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
                oZonaGeneral.setAREA(rs.getInt("AREA"));
                oZonaGeneral.setLARGO(rs.getInt("LARGO"));
                oZonaGeneral.setANCHO(rs.getInt("ANCHO"));
                oZonaGeneral.setFECHACREACION(rs.getString("FECHACREACION"));
                oZonaGeneral.setCODIGOEQUIVALENTE(rs.getString("CODIGOEQUIVALENTE"));
                oZonaGeneral.setESTADO(rs.getInt("ESTADO"));
                oZonaGeneral.setSUCURSAL(rs.getString("SUCURSAL"));
                listaZonaGeneral.add(oZonaGeneral);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaZonaGeneral;
    }
    
    @Override
    public List<ZonaGeneral> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<ZonaGeneral> findAll(Object e1,Object e2) throws Exception {
        ZonaGeneral oZonaGeneral = null;
        List<ZonaGeneral> listaZonaGeneral=new ArrayList<ZonaGeneral>();
        try {
            String sql = "SP_ZONAGENERAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,5);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oZonaGeneral = new ZonaGeneral();
                oZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
                oZonaGeneral.setAREA(rs.getInt("AREA"));
                oZonaGeneral.setLARGO(rs.getInt("LARGO"));
                oZonaGeneral.setANCHO(rs.getInt("ANCHO"));
                oZonaGeneral.setFECHACREACION(rs.getString("FECHACREACION"));
                oZonaGeneral.setCODIGOEQUIVALENTE(rs.getString("CODIGOEQUIVALENTE"));
                oZonaGeneral.setESTADO(rs.getInt("ESTADO"));
                listaZonaGeneral.add(oZonaGeneral);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaZonaGeneral;
    }
    
    public List<ZonaGeneral> findAllSincronizacion(Object e1,Object e2,Object desde,Object hasta) throws Exception {
        ZonaGeneral oZonaGeneral = null;
        List<ZonaGeneral> listaZonaGeneral=new ArrayList<ZonaGeneral>();
        try {
            String sql = "SP_ZONAGENERAL";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++,20);/*GETRECORD ALMACEN(5)*/
            cl.setString(i++,"");
            cl.setInt(i++,Integer.valueOf(e1.toString()));/*++IDEMRPESA++*/
            cl.setInt(i++,Integer.valueOf(e2.toString()));/*++IDSUCURSAL++*/
            cl.setInt(i++,0);/*++IDZONAGENERAL++*/
            cl.setInt(i++,0);/*++AREA NUMERIC++*/
            cl.setInt(i++,0);/*++LARGO++*/
            cl.setInt(i++,0);/*++ANCHO++*/
            cl.setString(i++,"");/*++FECHACREACION++*/
            cl.setString(i++,"");/*++CODIGOEQUIVALENTE++*/
            cl.setInt(i++,1);/*++ESTADO++*/
            cl.setString(i++,desde.toString().replace("-", "").trim());/*++DESDE++*/
            cl.setString(i++,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oZonaGeneral = new ZonaGeneral();
                oZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
                oZonaGeneral.setAREA(rs.getInt("AREA"));
                oZonaGeneral.setLARGO(rs.getInt("LARGO"));
                oZonaGeneral.setANCHO(rs.getInt("ANCHO"));
                oZonaGeneral.setFECHACREACION(rs.getString("FECHACREACION"));
                oZonaGeneral.setCODIGOEQUIVALENTE(rs.getString("CODIGOEQUIVALENTE"));
                oZonaGeneral.setESTADO(rs.getInt("ESTADO"));
                listaZonaGeneral.add(oZonaGeneral);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaZonaGeneral;
    }
    

}
