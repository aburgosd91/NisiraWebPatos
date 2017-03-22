/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DZonaDiagrama;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class DZonaDiagramaDao extends EntityDao<DZonaDiagrama> {

    @Override
    public DZonaDiagrama find(DZonaDiagrama e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DZonaDiagrama> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DZonaDiagrama> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DZonaDiagrama> findAll(Object e1, Object e2, Object e3) throws Exception {
        DZonaDiagrama oDZonaDiagrama = null;
        List<DZonaDiagrama> listaDZonaDiagrama = new ArrayList<DZonaDiagrama>();
        try {
            String sql = "SP_DZONADIAGRAMA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1, 4);/*GETRECORD ALMACEN(5)*/

            cl.setString(2, "");
            cl.setString(3, e1.toString());/*++IDEMRPESA++*/

            cl.setString(4, e2.toString());/*++IDSUCURSAL++*/

            cl.setString(5, e3.toString());/*++IDZONA++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaDiagrama = new DZonaDiagrama();
                oDZonaDiagrama.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaDiagrama.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaDiagrama.setIDZONA(rs.getInt("IDZONA"));
                oDZonaDiagrama.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDZonaDiagrama.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDZonaDiagrama.setIDACCESORIO(rs.getInt("IDACCESORIO"));
                oDZonaDiagrama.setIDALMACEN(rs.getInt("IDALMACEN"));
                oDZonaDiagrama.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDZonaDiagrama.setCOLOR(rs.getString("COLORHEXADECIMAL"));
                oDZonaDiagrama.setFECHACREACION(rs.getString("FECHACREACION"));
                oDZonaDiagrama.setESTADO(rs.getInt("ESTADO"));
                listaDZonaDiagrama.add(oDZonaDiagrama);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaDiagrama;
    }

    public String addDZonaDiagrama(DZonaDiagrama oDZonaDiagrama) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (oDZonaDiagrama != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_DZONADIAGRAMA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 1);
            cl.setString(i++, "");
            cl.setInt(i++, oDZonaDiagrama.getIDEMPRESA());
            cl.setInt(i++, oDZonaDiagrama.getIDSUCURSAL());
            cl.setInt(i++, oDZonaDiagrama.getIDZONA());
            cl.setInt(i++, oDZonaDiagrama.getCORDENADAX());
            cl.setInt(i++, oDZonaDiagrama.getCORDENADAY());
            cl.setInt(i++, oDZonaDiagrama.getIDACCESORIO());
            cl.setInt(i++, oDZonaDiagrama.getIDALMACEN());
            cl.setString(i++, oDZonaDiagrama.getIDDISTRIBUCION());
            cl.setString(i++, oDZonaDiagrama.getCOLOR());
            cl.setString(i++, oDZonaDiagrama.getFECHACREACION());
            cl.setInt(i++, oDZonaDiagrama.getESTADO());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("IDZONA"));
            }
        }
        return resultado;
    }

    public String addXmlDZonaDiagrama(int idempresa, int idsucursal, int idzona, String xml)
            throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if (xml != null) {
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONADIAGRAMA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++, 5);
                cl.setString(i++, xml);/*XML*/

                cl.setInt(i++, idempresa);
                cl.setInt(i++, idsucursal);
                cl.setInt(i++, idzona);
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));
                }
            }
        } catch (Exception e) {
            resultado = e.toString();
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }

    public String addXmlDZonaDiagrama2(int idempresa, int idsucursal, int idzona, int idalmacen, String xml)
            throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if (xml != null) {
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONADIAGRAMA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++, 6);
                cl.setString(i++, xml);/*XML*/

                cl.setInt(i++, idempresa);
                cl.setInt(i++, idsucursal);
                cl.setInt(i++, idzona);
                cl.setObject(i++, null);
                cl.setObject(i++, null);
                cl.setObject(i++, null);
                cl.setInt(i++, idalmacen);
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));
                }
            }
        } catch (Exception e) {
            resultado = e.toString();
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }

    public String addxmlDzonaDiagramaUbicacion(int idempresa, int idsucursal, int idzona, String xml) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if (xml != null) {
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONADIAGRAMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++, 5);
                cl.setString(i++, xml);/*XML*/

                cl.setInt(i++, idempresa);
                cl.setInt(i++, idsucursal);
                cl.setInt(i++, idzona);
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));
                }
            }

        } catch (Exception e) {
            resultado = e.toString();
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }

    public List<DZonaDiagrama> sincronizarDZonaDiagrama(Object ide, Object ids, Object desde, Object hasta) throws Exception {
        DZonaDiagrama oDZonaDiagrama = null;
        List<DZonaDiagrama> listaDZonaDiagrama = new ArrayList<DZonaDiagrama>();
        try {
            String sql = "SP_DZONADIAGRAMA_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/

            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/

            cl.setString(3, desde.toString().replace("-", "").trim());/*++HASTA++*/

            cl.setString(4, hasta.toString().replace("-", "").trim());/*++HASTA++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaDiagrama = new DZonaDiagrama();
                oDZonaDiagrama.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaDiagrama.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaDiagrama.setIDZONA(rs.getInt("IDZONA"));
                oDZonaDiagrama.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDZonaDiagrama.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDZonaDiagrama.setIDACCESORIO(rs.getInt("IDACCESORIO"));
                oDZonaDiagrama.setIDALMACEN(rs.getInt("IDALMACEN"));
                oDZonaDiagrama.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                oDZonaDiagrama.setCOLOR(rs.getString("COLORHEXADECIMAL"));
                oDZonaDiagrama.setFECHACREACION(rs.getString("FECHACREACION"));
                oDZonaDiagrama.setESTADO(rs.getInt("ESTADO"));
                oDZonaDiagrama.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                listaDZonaDiagrama.add(oDZonaDiagrama);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaDiagrama;
    }

    public void reflejarDzonageneral(String xml){
        try{
        String sql = "SP_SYNCDZGENERA_DZONA";
        cn = obtenerConexionJTDS();
        cl = cn.prepareCall("{CALL " + sql + "(?)}");
        cl.setString(1, xml);/*GETRECORD ALMACEN(5)*/
        String resultado = "";
        rs = cl.executeQuery();
        while (rs.next()) {
            resultado = (rs.getString("mensaje"));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void reflejarDzonageneral(int idempresa,int idsucursal,int idalm,int idzona) throws Exception{
        String sql = "SP_SYNCDZGENERA_DALM";
        cn = obtenerConexionJTDS();
        cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
        cl.setInt(1, idempresa);/*GETRECORD ALMACEN(5)*/
        cl.setInt(2, idsucursal);/*GETRECORD ALMACEN(5)*/
        cl.setInt(3, idalm);/*GETRECORD ALMACEN(5)*/
        cl.setInt(4, idzona);/*GETRECORD ALMACEN(5)*/
        String resultado = "";
        rs = cl.executeQuery();
        while (rs.next()) {
            resultado = (rs.getString("mensaje"));
        }
    }
}
