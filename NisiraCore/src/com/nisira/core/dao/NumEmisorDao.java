/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.NumEmisor;
import com.nisira.core.entity.Sucursal;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Zavala
 */
public class NumEmisorDao extends EntityDao<NumEmisor> {

    @Override
    public NumEmisor find(NumEmisor e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NumEmisor> findAll(Object e) throws Exception {
        NumEmisor oNumEmisor = null;
        List<NumEmisor> listaNumEmisor = new ArrayList<NumEmisor>();
        try {
            String sql = "SP_SUCURSAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{ CALL " + sql + "(?,?,?)}");
            cl.setInt(1, 5);/*GETRECORD SUCURSAL(5)*/

            cl.setString(2, "");
            cl.setString(3, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oNumEmisor = new NumEmisor();
                oNumEmisor.setIDEMPRESA(rs.getString("IDEMPRESA"));
                listaNumEmisor.add(oNumEmisor);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaNumEmisor;
    }

    @Override
    public List<NumEmisor> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String saveNumEmisor(NumEmisor sucursal) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (sucursal != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_SUCURSAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 1);
            cl.setString(i++, "");

            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public String anularNumEmisor(NumEmisor sucursal) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (sucursal != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_SUCURSAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 2);
            cl.setString(i++, "");
            cl.setString(i++, sucursal.getIDEMPRESA());

            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public String deleteNumEmisor(NumEmisor sucursal) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (sucursal != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_SUCURSAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 3);
            cl.setString(i++, "");
            cl.setString(i++, sucursal.getIDEMPRESA());

            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public String grabarRegistroTempNumEmisorXML(String xml) throws Exception {
        String resultado = "";
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if (xml != null) {
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SINCR_TEMP_PALETA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setString(1, "");
                cl.setString(2, "");
                cl.setString(3, xml);/*XML*/

                //cl.registerOutParameter(6,java.sql.Types.VARCHAR);
                //cl.executeUpdate();            
                //resultado = cl.getString(6);

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

    public ArrayList<NumEmisor> findByDocumento(String idempresa, String iddocumento) throws Exception {
        ArrayList<NumEmisor> listanumemisor = new ArrayList<NumEmisor>();
        NumEmisor oNumEmisor = null;

        try {
            String sql = "SP_NUMEMISOR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, 0);/*GETRECORD SUCURSAL(5)*/

            cl.setString(2, idempresa);
            cl.setString(3, iddocumento);
            rs = cl.executeQuery();
            while (rs.next()) {
                oNumEmisor = new NumEmisor();
                oNumEmisor.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oNumEmisor.setIDDOCUMENTO(rs.getString("IDDOCUMENTO"));
                oNumEmisor.setITEM(rs.getString("ITEM"));
                oNumEmisor.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oNumEmisor.setSERIE(rs.getString("SERIE"));
                oNumEmisor.setNUMERO(rs.getString("NUMERO"));
                oNumEmisor.setFECHACREACION(rs.getString("FECHACREACION"));
                oNumEmisor.setESTADO(rs.getInt("ESTADO"));

                Sucursal suc = new Sucursal();

                suc = new SucursalDao().findById(idempresa, oNumEmisor.getIDSUCURSAL());
                oNumEmisor.setSUCURSAL(suc);
                listanumemisor.add(oNumEmisor);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listanumemisor;
    }

    public List<NumEmisor> sincronizarNumEmisor(Object e1, Object e2) throws Exception {
        NumEmisor oNumEmisor = null;
        List<NumEmisor> listaNumEmisor = new ArrayList<NumEmisor>();
        try {
            String sql = "SP_NUMEMISOR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{ CALL " + sql + "(?,?,?)}");
            int i = 1;
            cl.setInt(i++, 10);/*GETRECORD SUCURSAL(5)*/

            cl.setString(i++, e1.toString());//IDEMPRESA
            cl.setString(i++, "");//IDDOCUMENTO
            cl.setString(i++, "");//XMLCABECERA
            cl.setString(i++, "");//XMLDETALLE
            cl.setString(i++, e2.toString());//IDSUCURSAL
            rs = cl.executeQuery();
            while (rs.next()) {
                oNumEmisor = new NumEmisor();
                oNumEmisor.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oNumEmisor.setIDDOCUMENTO(rs.getString("IDDOCUMENTO"));
                oNumEmisor.setITEM(rs.getString("ITEM"));
                oNumEmisor.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oNumEmisor.setSERIE(rs.getString("SERIE"));
                oNumEmisor.setNUMERO(rs.getString("NUMERO"));
                oNumEmisor.setFECHACREACION(rs.getString("FECHACREACION"));
                oNumEmisor.setESTADO(rs.getInt("ESTADO"));
                listaNumEmisor.add(oNumEmisor);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaNumEmisor;
    }

    public void insertFromProg(String xml) throws Exception {
        try {
            if (xml != null) {
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_NUMEMISOR";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{ CALL " + sql + "(?,?,?,?,?,?)}");
                int i = 1;
                cl.setInt(i++, 2);/*GETRECORD SUCURSAL(5)*/

                cl.setString(i++, "");//IDEMPRESA
                cl.setString(i++, "");//IDDOCUMENTO
                cl.setString(i++, "");//XMLCABECERA
                cl.setString(i++, xml);//XMLDETALLE
                cl.setString(i++, "");//IDSUCURSAL

                //cl.registerOutParameter(6,java.sql.Types.VARCHAR);
                //cl.executeUpdate();            
                //resultado = cl.getString(6);
                cl.executeUpdate();
            }
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
