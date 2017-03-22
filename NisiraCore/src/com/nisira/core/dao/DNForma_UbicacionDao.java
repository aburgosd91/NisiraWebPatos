/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DDNFormaUbicacion;
import com.nisira.core.entity.DNFormaUbicacion;
import com.nisira.core.util.CoreUtil;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DNForma_UbicacionDao extends EntityDao<DNFormaUbicacion> {

    @Override
    public DNFormaUbicacion find(DNFormaUbicacion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DNFormaUbicacion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DNFormaUbicacion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String addDNForma_Ubicacion(DNFormaUbicacion dNForma_Ubicacion) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (dNForma_Ubicacion != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_DNFORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 1);
            cl.setString(i++, "");
            cl.setString(i++, dNForma_Ubicacion.getIDEMPRESA());
            cl.setString(i++, dNForma_Ubicacion.getIDSUCURSAL());
            cl.setString(i++, dNForma_Ubicacion.getIDALMACEN());
            cl.setString(i++, dNForma_Ubicacion.getIDNFORMACIONUBICACION());
            cl.setInt(i++, dNForma_Ubicacion.getFILAS());
            cl.setInt(i++, dNForma_Ubicacion.getCOLUMNAS());
            cl.setString(i++, dNForma_Ubicacion.getDESCRIPCION());
            cl.setInt(i++, dNForma_Ubicacion.getESTADO());
            cl.setString(i++, dNForma_Ubicacion.getIDDISTRIBUCION());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public String addXmlDNForma_Ubicacion(String idempresa, String idsucursal, String idalmacen, String iddistribucion, String xml) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if (xml != null) {
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DNFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++, 5);
                cl.setString(i++, xml);/*XML*/

                cl.setString(i++, idempresa);/*IDEMPRESA*/

                cl.setString(i++, idsucursal);/*IDSUCURSAL*/

                cl.setString(i++, idalmacen);/*IDALMACEN*/

                cl.setString(i++, "");/*IDNFORMACIONUBICACION*/

                cl.setString(i++, "");/*FILAS*/

                cl.setString(i++, "");/*COLUMNAS*/

                cl.setString(i++, "");/*DESCRIPCION*/

                cl.setString(i++, "");/*ESTADO*/

                cl.setString(i++, iddistribucion);/*IDDISTRIBUCION*/

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

    public String addXmlDNFormaUbicacionDetalle(DNFormaUbicacion dNFormaUbicacion, List<DDNFormaUbicacion> listDDNFormaUbicacion) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if (dNFormaUbicacion != null) {
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String xml_dNFormaUbicacion = CoreUtil.XmlToString("com.nisira.core.entity.DNFormaUbicacion", dNFormaUbicacion);
                String xml_DDNFormaUbicacion = CoreUtil.XmlToString("com.nisira.core.entity.DDNFormaUbicacion", listDDNFormaUbicacion);
                String sql = "SP_DNFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++, 7);
                cl.setString(i++, xml_dNFormaUbicacion);/*XML*/

                cl.setString(i++, dNFormaUbicacion.getIDEMPRESA());/*IDEMPRESA*/

                cl.setString(i++, dNFormaUbicacion.getIDSUCURSAL());/*IDSUCURSAL*/

                cl.setString(i++, dNFormaUbicacion.getIDALMACEN());/*IDALMACEN*/

                cl.setString(i++, "");/*IDNFORMACIONUBICACION*/

                cl.setString(i++, "");/*FILAS*/

                cl.setString(i++, "");/*COLUMNAS*/

                cl.setString(i++, "");/*DESCRIPCION*/

                cl.setString(i++, "");/*ESTADO*/

                cl.setString(i++, dNFormaUbicacion.getIDDISTRIBUCION());/*IDDISTRIBUCION*/

                cl.setString(i++, "");/*FECHACREACION*/

                cl.setString(i++, xml_DDNFormaUbicacion);/*XML_DDNFORMAUBICACION*/

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

    public String editXmlDNFormaUbicacionDetalle(DNFormaUbicacion dNFormaUbicacion, List<DDNFormaUbicacion> listDDNFormaUbicacion) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if (dNFormaUbicacion != null) {
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String xml_dNFormaUbicacion = CoreUtil.XmlToString("com.nisira.core.entity.DNFormaUbicacion", dNFormaUbicacion);
                String xml_DDNFormaUbicacion = CoreUtil.XmlToString("com.nisira.core.entity.DDNFormaUbicacion", listDDNFormaUbicacion);
                String sql = "SP_DNFORMAUBICACION";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++, 8);
                cl.setString(i++, xml_dNFormaUbicacion);/*XML*/

                cl.setString(i++, dNFormaUbicacion.getIDEMPRESA());/*IDEMPRESA*/

                cl.setString(i++, dNFormaUbicacion.getIDSUCURSAL());/*IDSUCURSAL*/

                cl.setString(i++, dNFormaUbicacion.getIDALMACEN());/*IDALMACEN*/

                cl.setString(i++, "");/*IDNFORMACIONUBICACION*/

                cl.setString(i++, "");/*FILAS*/

                cl.setString(i++, "");/*COLUMNAS*/

                cl.setString(i++, "");/*DESCRIPCION*/

                cl.setString(i++, "");/*ESTADO*/

                cl.setString(i++, dNFormaUbicacion.getIDDISTRIBUCION());/*IDDISTRIBUCION*/

                cl.setString(i++, "");/*FECHACREACION*/

                cl.setString(i++, xml_DDNFormaUbicacion);/*XML_DDNFORMAUBICACION*/

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

    public String editDNForma_Ubicacion(DNFormaUbicacion dNForma_Ubicacion) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (dNForma_Ubicacion != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_DNFORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 2);
            cl.setString(i++, "");
            cl.setString(i++, dNForma_Ubicacion.getIDEMPRESA());
            cl.setString(i++, dNForma_Ubicacion.getIDSUCURSAL());
            cl.setString(i++, dNForma_Ubicacion.getIDALMACEN());
            cl.setString(i++, dNForma_Ubicacion.getIDNFORMACIONUBICACION());
            cl.setInt(i++, dNForma_Ubicacion.getFILAS());
            cl.setInt(i++, dNForma_Ubicacion.getCOLUMNAS());
            cl.setString(i++, dNForma_Ubicacion.getDESCRIPCION());
            cl.setInt(i++, dNForma_Ubicacion.getESTADO());
            cl.setString(i++, dNForma_Ubicacion.getIDDISTRIBUCION());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public String deleteDNForma_Ubicacion(DNFormaUbicacion dNForma_Ubicacion) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (dNForma_Ubicacion != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_DNFORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 3);
            cl.setString(i++, "");
            cl.setString(i++, dNForma_Ubicacion.getIDEMPRESA());
            cl.setString(i++, dNForma_Ubicacion.getIDSUCURSAL());
            cl.setString(i++, dNForma_Ubicacion.getIDALMACEN());
            cl.setString(i++, dNForma_Ubicacion.getIDNFORMACIONUBICACION());
            cl.setInt(i++, dNForma_Ubicacion.getFILAS());
            cl.setInt(i++, dNForma_Ubicacion.getCOLUMNAS());
            cl.setString(i++, dNForma_Ubicacion.getDESCRIPCION());
            cl.setInt(i++, dNForma_Ubicacion.getESTADO());
            cl.setString(i++, dNForma_Ubicacion.getIDDISTRIBUCION());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public List<DNFormaUbicacion> findAll(Object e1, Object e2, Object e3, Object e4) throws Exception {
        DNFormaUbicacion dformaUbicacion = null;
        List<DNFormaUbicacion> listaDNForma_Ubicacion = new ArrayList<DNFormaUbicacion>();
        try {
            String sql = "SP_DNFORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(1, 4);/*GETRECORD ALMACEN(5)*/

            cl.setString(2, "");
            cl.setString(3, e1.toString());/*++IDEMRPESA++*/

            cl.setString(4, e2.toString());/*++IDSUCURSAL++*/

            cl.setString(5, e3.toString());/*++IDALMACEN++*/

            cl.setString(6, "");/*++IDNFORMACIONUBICACION++*/

            cl.setString(7, "");/*++FILAS++*/

            cl.setString(8, "");/*++COLUMNAS++*/

            cl.setString(9, "");/*++DESCRIPCION++*/

            cl.setString(10, "");/*++ESTADO++*/

            cl.setString(11, e4.toString());/*++IDDISTRIBUCION++*/

            cl.setString(12, "");/*++FECHACREACION++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                dformaUbicacion = new DNFormaUbicacion();
                dformaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                dformaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                dformaUbicacion.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                dformaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                dformaUbicacion.setIDNFORMACIONUBICACION(rs.getString("IDNFORMACIONUBICACION"));
                dformaUbicacion.setFILAS(rs.getInt("FILAS"));
                dformaUbicacion.setCOLUMNAS(rs.getInt("COLUMNAS"));
                dformaUbicacion.setDESCRIPCION(rs.getString("DESCRIPCION"));
                dformaUbicacion.setESTADO(rs.getInt("ESTADO"));
                listaDNForma_Ubicacion.add(dformaUbicacion);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaDNForma_Ubicacion;
    }

    public List<DNFormaUbicacion> findAllAlmacen(Object e1, Object e2) throws Exception {
        DNFormaUbicacion dformaUbicacion = null;
        List<DNFormaUbicacion> listaDNForma_Ubicacion = new ArrayList<DNFormaUbicacion>();
        try {
            String sql = "SP_DNFORMAUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, 6);/*GETRECORD ALMACEN(5)*/

            cl.setString(2, "");
            cl.setString(3, e1.toString());/*++IDEMRPESA++*/

            cl.setString(4, e2.toString());/*++IDSUCURSAL++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                dformaUbicacion = new DNFormaUbicacion();
                dformaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                dformaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                dformaUbicacion.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                dformaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                dformaUbicacion.setIDNFORMACIONUBICACION(rs.getString("IDNFORMACIONUBICACION"));
                dformaUbicacion.setFILAS(rs.getInt("FILAS"));
                dformaUbicacion.setCOLUMNAS(rs.getInt("COLUMNAS"));
                dformaUbicacion.setDESCRIPCION(rs.getString("DESCRIPCION"));
                dformaUbicacion.setESTADO(rs.getInt("ESTADO"));
                listaDNForma_Ubicacion.add(dformaUbicacion);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaDNForma_Ubicacion;
    }

    public List<DNFormaUbicacion> syncDNforma(Object ide, Object ids, Object desde, Object hasta) throws Exception {
        DNFormaUbicacion dformaUbicacion = null;
        List<DNFormaUbicacion> listaDNForma_Ubicacion = new ArrayList<DNFormaUbicacion>();
        try {
            String sql = "SP_DNFORMAUBICACION_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                dformaUbicacion = new DNFormaUbicacion();
                dformaUbicacion.setIDEMPRESA(rs.getString("IDEMPRESA"));
                dformaUbicacion.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                dformaUbicacion.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                dformaUbicacion.setIDALMACEN(rs.getString("IDALMACEN"));
                dformaUbicacion.setIDNFORMACIONUBICACION(rs.getString("IDNFORMACIONUBICACION"));
                dformaUbicacion.setFILAS(rs.getInt("FILAS"));
                dformaUbicacion.setCOLUMNAS(rs.getInt("COLUMNAS"));
                dformaUbicacion.setDESCRIPCION(rs.getString("DESCRIPCION"));
                dformaUbicacion.setESTADO(rs.getInt("ESTADO"));
                dformaUbicacion.setFECHACREACION(rs.getString("FECHACREACION"));
                listaDNForma_Ubicacion.add(dformaUbicacion);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaDNForma_Ubicacion;
    }
}
