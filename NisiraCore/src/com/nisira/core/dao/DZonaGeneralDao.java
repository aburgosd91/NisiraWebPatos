/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Dreglas;
import com.nisira.core.entity.Reglas;
import com.nisira.core.entity.DZonaGeneral;
import com.nisira.core.util.CoreUtil;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DZonaGeneralDao extends EntityDao<DZonaGeneral> {


    public String addDZonaGeneral(DZonaGeneral dZonaGeneral) throws Exception {
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dZonaGeneral!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONAGENERAL";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setInt(i++,dZonaGeneral.getIDEMPRESA());
                cl.setInt(i++,dZonaGeneral.getIDSUCURSAL());
                cl.setInt(i++,dZonaGeneral.getIDZONAGENERAL());
                cl.setInt(i++,dZonaGeneral.getIDZONA());
                cl.setInt(i++,dZonaGeneral.getCORDENADAX());
                cl.setInt(i++,dZonaGeneral.getCORDENADAY());
                cl.setString(i++,dZonaGeneral.getIDUBICACION());
                cl.setString(i++,dZonaGeneral.getFECHACREACION());
                cl.setInt(i++,dZonaGeneral.getSINCRONIZA());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String editDZonaGeneral(DZonaGeneral dZonaGeneral) throws Exception {
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dZonaGeneral!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONAGENERAL";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setInt(i++,dZonaGeneral.getIDEMPRESA());
                cl.setInt(i++,dZonaGeneral.getIDSUCURSAL());
                cl.setInt(i++,dZonaGeneral.getIDZONAGENERAL());
                cl.setInt(i++,dZonaGeneral.getIDZONA());
                cl.setInt(i++,dZonaGeneral.getCORDENADAX());
                cl.setInt(i++,dZonaGeneral.getCORDENADAY());
                cl.setString(i++,dZonaGeneral.getIDUBICACION());
                cl.setString(i++,dZonaGeneral.getFECHACREACION());
                cl.setInt(i++,dZonaGeneral.getSINCRONIZA());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDZonaGeneral(DZonaGeneral dZonaGeneral) throws Exception {
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dZonaGeneral!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONAGENERAL";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setInt(i++,dZonaGeneral.getIDEMPRESA());
                cl.setInt(i++,dZonaGeneral.getIDSUCURSAL());
                cl.setInt(i++,dZonaGeneral.getIDZONAGENERAL());
                cl.setInt(i++,dZonaGeneral.getIDZONA());
                cl.setInt(i++,dZonaGeneral.getCORDENADAX());
                cl.setInt(i++,dZonaGeneral.getCORDENADAY());
                cl.setString(i++,dZonaGeneral.getIDUBICACION());
                cl.setString(i++,dZonaGeneral.getFECHACREACION());
                cl.setInt(i++,dZonaGeneral.getSINCRONIZA());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addXmlDZonaGeneral(Object e1,Object e2,Object e3,List<DZonaGeneral> listDZonaGeneral) throws Exception {
        String resultado = ""; 
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("DZONAGENERAL", DZonaGeneral.class);
        String xml = xstream.toXML(listDZonaGeneral);
        int i=1;
        try {
            //DataBaseConeccion db= new DataBaseConeccion(context);
            if(listDZonaGeneral.size()>0){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONAGENERAL";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++,6);
                cl.setString(i++,xml);
                cl.setString(i++, e1.toString());//IDEMPRESA
                cl.setString(i++, e2.toString());//IDSUCURSAL
                cl.setString(i++, e3.toString());//IDZONAGENERAL
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    @Override
    public DZonaGeneral find(DZonaGeneral e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DZonaGeneral> findAll(Object e) throws Exception {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }
    
    @Override
    public List<DZonaGeneral> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<DZonaGeneral> findAll(Object e1,Object e2,Object e3) throws Exception {
        DZonaGeneral oDZonaGeneral = null;
        List<DZonaGeneral> listaDZonaGeneral=new ArrayList<DZonaGeneral>();
        try {
            String sql = "SP_DZONAGENERAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDZONAGENERAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaGeneral = new DZonaGeneral();
                oDZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
                oDZonaGeneral.setIDZONA(rs.getInt("IDZONA"));
                oDZonaGeneral.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDZonaGeneral.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDZonaGeneral.setDCORDENADAX(rs.getInt("DCORDENADAX"));
                oDZonaGeneral.setDCORDENADAY(rs.getInt("DCORDENADAY"));
                oDZonaGeneral.setCOLOR(rs.getString("COLOR"));
                oDZonaGeneral.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                oDZonaGeneral.setPUERTA(rs.getInt("PUERTA"));
                listaDZonaGeneral.add(oDZonaGeneral);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaGeneral;
    }
    public List<DZonaGeneral> findAll(Object e1,Object e2) throws Exception {
        DZonaGeneral oDZonaGeneral = null;
        List<DZonaGeneral> listaDZonaGeneral=new ArrayList<DZonaGeneral>();
        try {
            String sql = "SP_DZONAGENERAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,8);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaGeneral = new DZonaGeneral();
                oDZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
                oDZonaGeneral.setIDZONA(rs.getInt("IDZONA"));
                oDZonaGeneral.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDZonaGeneral.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDZonaGeneral.setCOLOR(rs.getString("COLOR"));
                oDZonaGeneral.setIDUBICACION(rs.getString("IDUBICACION"));
                oDZonaGeneral.setFECHACREACION(rs.getString("FECHACREACION"));
                oDZonaGeneral.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                oDZonaGeneral.setPUERTA(rs.getInt("PUERTA"));
                listaDZonaGeneral.add(oDZonaGeneral);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaGeneral;
    }
    
    public List<DZonaGeneral> findAllSincronizacion(Object e1,Object e2,Object desde, Object hasta) throws Exception {
        DZonaGeneral oDZonaGeneral = null;
        List<DZonaGeneral> listaDZonaGeneral=new ArrayList<DZonaGeneral>();
        try {
            String sql = "SP_DZONAGENERAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(1,8);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setInt(3,Integer.valueOf(e1.toString()));/*++IDEMRPESA++*/
            cl.setInt(4,Integer.valueOf(e2.toString()));/*++IDSUCURSAL++*/
            cl.setInt(5,0);/*++IDZONAGENERAL++*/
            cl.setInt(6,0);/*++IDZONA++*/
            cl.setInt(7,0);/*++CORDENADAX++*/
            cl.setInt(8,0);/*++CORDENADAY++*/
            cl.setString(9,"");/*++COLOR++*/
            cl.setString(10,"");/*++IDUBICACION++*/
            cl.setString(11,"");/*++FECHACREACION++*/
            cl.setInt(12,0);/*++@SINCRONIZA++*/
            cl.setString(13,desde.toString().replace("-", "").trim());/*++DESDE++*/
            cl.setString(14,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaGeneral = new DZonaGeneral();
                oDZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
                oDZonaGeneral.setIDZONA(rs.getInt("IDZONA"));
                oDZonaGeneral.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDZonaGeneral.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDZonaGeneral.setCOLOR(rs.getString("COLOR"));
                oDZonaGeneral.setIDUBICACION(rs.getString("IDUBICACION"));
                oDZonaGeneral.setFECHACREACION(rs.getString("FECHACREACION"));
                oDZonaGeneral.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                oDZonaGeneral.setPUERTA(rs.getInt("PUERTA"));
                listaDZonaGeneral.add(oDZonaGeneral);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaGeneral;
    }
}
