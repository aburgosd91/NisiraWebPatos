/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.annotation.Tabla;
import com.nisira.core.entity.DZonaAccesorio;
import com.nisira.core.entity.TablaAlmacen;
import com.nisira.core.entity.Zona;
import com.nisira.core.util.CoreUtil;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class ZonaDao extends EntityDao<Zona> {

    @Override
    public Zona find(Zona e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Zona> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Zona> findAll(Object e1, Object e2) throws Exception {
        Zona oZona = null;
        List<Zona> listaZona = new ArrayList<Zona>();
        try {
            String sql = "SP_ZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, 7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2, "");
            cl.setString(3, e1.toString());/*++IDEMRPESA++*/
            cl.setString(4, e2.toString());/*++IDSUCURSAL++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                oZona = new Zona();
                oZona.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oZona.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oZona.setIDZONA(rs.getInt("IDZONA"));
                oZona.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oZona.setIDTIPOZONA(rs.getInt("IDTIPOZONA"));
                oZona.setIDUNIDADMEDIDA(rs.getInt("IDUNIDADMEDIDA"));
                oZona.setAREA(rs.getDouble("AREA"));
                oZona.setAREAUNIDADDIAGRAMA(rs.getInt("AREAUNIDADDIAGRAMA"));
                oZona.setLARGOUNIDADDIAGRAMA(rs.getInt("LARGOUNIDADDIAGRAMA"));
                oZona.setANCHOUNIDADDIAGRAMA(rs.getInt("ANCHOUNIDADDIAGRAMA"));
                oZona.setFECHACREACION(rs.getString("FECHACREACION"));
                oZona.setESTADO(rs.getBoolean("ESTADO"));
                oZona.setSUCURSAL(rs.getString("SUCURSAL"));
                oZona.setTIPOZONA(rs.getString("TIPOZONA"));
                oZona.setUNIDADMEDIDA(rs.getString("UNIDADMEDIDA"));
                oZona.setCOLOR(rs.getString("COLOR").replace("#", "").trim());
                oZona.setIDPROCESO(rs.getInt("IDPROCESO"));
                listaZona.add(oZona);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaZona;
    }
    public List<Zona> findAllAcc(Object e1, Object e2,Object e3) throws Exception {
        Zona oZona = null;
        List<Zona> listaZona = new ArrayList<Zona>();
        try {
            String sql = "SP_ZONA_ACCESORIO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, e1);/*GETRECORD ALMACEN(5)*/
            cl.setObject(2, e2);
            cl.setObject(3, e3);
            rs = cl.executeQuery();
            while (rs.next()) {
                oZona = new Zona();
                oZona.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oZona.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oZona.setIDZONA(rs.getInt("IDZONA"));
                oZona.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oZona.setIDTIPOZONA(rs.getInt("IDTIPOZONA"));
                oZona.setIDUNIDADMEDIDA(rs.getInt("IDUNIDADMEDIDA"));
                oZona.setAREA(rs.getDouble("AREA"));
                oZona.setAREAUNIDADDIAGRAMA(rs.getInt("AREAUNIDADDIAGRAMA"));
                oZona.setLARGOUNIDADDIAGRAMA(rs.getInt("LARGOUNIDADDIAGRAMA"));
                oZona.setANCHOUNIDADDIAGRAMA(rs.getInt("ANCHOUNIDADDIAGRAMA"));
                oZona.setFECHACREACION(rs.getString("FECHACREACION"));
                oZona.setESTADO(rs.getBoolean("ESTADO"));
                listaZona.add(oZona);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaZona;
    }
    public String addZona(Zona tipozona) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (tipozona != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_ZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 1);//1
            cl.setString(i++, "");//2
            cl.setInt(i++, tipozona.getIDEMPRESA());//3
            cl.setInt(i++, tipozona.getIDSUCURSAL());//4
            cl.setInt(i++, tipozona.getIDZONA());//5
            cl.setString(i++, tipozona.getDESCRIPCION());//6
            cl.setInt(i++, tipozona.getIDTIPOZONA());//7
            cl.setInt(i++, tipozona.getIDUNIDADMEDIDA());//8
            cl.setDouble(i++, tipozona.getAREA());//9
            cl.setDouble(i++, tipozona.getAREAUNIDADDIAGRAMA());//10
            cl.setDouble(i++, tipozona.getLARGOUNIDADDIAGRAMA());//11
            cl.setDouble(i++, tipozona.getANCHOUNIDADDIAGRAMA());//12
            cl.setString(i++, tipozona.getFECHACREACION());//14
            cl.setBoolean(i++, tipozona.isESTADO());//15
            cl.setString("COLOR", tipozona.getCOLOR());//16
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("IDZONA"));
            }
        }
        return resultado;
    }

    public String addZonaDetalle(Zona tipozona, List<TablaAlmacen> obj, List<DZonaAccesorio> listDZonaAccesorio) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (tipozona != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String zonaXml = "";
            String dzonaalmacenXml = "";
            String dzonaaccesorioXml = "";
            zonaXml = CoreUtil.XmlToString("com.nisira.core.entity.Zona", tipozona);
            dzonaalmacenXml = CoreUtil.XmlToString("com.nisira.core.entity.TablaAlmacen", obj);
            dzonaaccesorioXml = CoreUtil.XmlToString("com.nisira.core.entity.DZonaAccesorio", listDZonaAccesorio);

            String sql = "SP_ZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 6);//1
            cl.setString(i++, zonaXml);//2
            cl.setInt(i++, tipozona.getIDEMPRESA());//3
            cl.setInt(i++, tipozona.getIDSUCURSAL());//4
            cl.setInt(i++, tipozona.getIDZONA());//5
            cl.setString(i++, tipozona.getDESCRIPCION());//6
            cl.setInt(i++, tipozona.getIDTIPOZONA());//7
            cl.setInt(i++, tipozona.getIDUNIDADMEDIDA());//8
            cl.setDouble(i++, tipozona.getAREA());//9
            cl.setDouble(i++, tipozona.getAREAUNIDADDIAGRAMA());//10
            cl.setDouble(i++, tipozona.getLARGOUNIDADDIAGRAMA());//11
            cl.setDouble(i++, tipozona.getANCHOUNIDADDIAGRAMA());//12
            cl.setString(i++, tipozona.getFECHACREACION());//14
            cl.setBoolean(i++, tipozona.isESTADO());//15
            cl.setString(i++, dzonaalmacenXml);//16
            cl.setString(i++, dzonaaccesorioXml);//17
            cl.setString(i++, tipozona.getCOLOR());//18
            cl.setInt(i++, tipozona.getIDPROCESO());//19

            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public String editZonaDetalle(Zona tipozona, List<TablaAlmacen> obj, List<DZonaAccesorio> listDZonaAccesorio) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (tipozona != null) {
        //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String zonaXml = "";
            String dzonaalmacenXml = "";
            String dzonaaccesorioXml = "";
            zonaXml = CoreUtil.XmlToString("com.nisira.core.entity.Zona", tipozona);
            dzonaalmacenXml = CoreUtil.XmlToString("com.nisira.core.entity.TablaAlmacen", obj);
            dzonaaccesorioXml = CoreUtil.XmlToString("com.nisira.core.entity.DZonaAccesorio", listDZonaAccesorio);

            String sql = "SP_ZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 8);//1
            cl.setString(i++, zonaXml);//2
            cl.setInt(i++, tipozona.getIDEMPRESA());//3
            cl.setInt(i++, tipozona.getIDSUCURSAL());//4
            cl.setInt(i++, tipozona.getIDZONA());//5
            cl.setString(i++, tipozona.getDESCRIPCION());//6
            cl.setInt(i++, tipozona.getIDTIPOZONA());//7
            cl.setInt(i++, tipozona.getIDUNIDADMEDIDA());//8
            cl.setDouble(i++, tipozona.getAREA());//9
            cl.setDouble(i++, tipozona.getAREAUNIDADDIAGRAMA());//10
            cl.setDouble(i++, tipozona.getLARGOUNIDADDIAGRAMA());//11
            cl.setDouble(i++, tipozona.getANCHOUNIDADDIAGRAMA());//12
            cl.setString(i++, tipozona.getFECHACREACION());//14
            cl.setBoolean(i++, tipozona.isESTADO());//15
            cl.setString(i++, dzonaalmacenXml);//16
            cl.setString(i++, dzonaaccesorioXml);//17
            cl.setString(i++, tipozona.getCOLOR());//18
            cl.setInt(i++, tipozona.getIDPROCESO());//19
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public String addXmlZona(String idempresa, String idsucursal, String xml) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if (xml != null) {
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_ZONA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                cl.setInt(i++, 5);
                cl.setString(i++, xml);/*XML*/

                cl.setString(i++, idempresa);
                cl.setString(i++, idsucursal);
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

    public String editZona(Zona tipozona) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (tipozona != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_ZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 2);
            cl.setString(i++, "");
            cl.setInt(i++, tipozona.getIDEMPRESA());
            cl.setInt(i++, tipozona.getIDSUCURSAL());
            cl.setInt(i++, tipozona.getIDZONA());
            cl.setString(i++, tipozona.getDESCRIPCION());
            cl.setInt(i++, tipozona.getIDTIPOZONA());
            cl.setInt(i++, tipozona.getIDUNIDADMEDIDA());
            cl.setDouble(i++, tipozona.getAREA());
            cl.setDouble(i++, tipozona.getAREAUNIDADDIAGRAMA());
            cl.setDouble(i++, tipozona.getLARGOUNIDADDIAGRAMA());
            cl.setDouble(i++, tipozona.getANCHOUNIDADDIAGRAMA());
            cl.setString(i++, CoreUtil.fechaEspaniol(tipozona.getFECHACREACION()));
            cl.setBoolean(i++, tipozona.isESTADO());
            cl.setString("COLOR", tipozona.getCOLOR());//18
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public String deleteZona(Zona tipozona) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (tipozona != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_ZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 3);
            cl.setString(i++, "");
            cl.setInt(i++, tipozona.getIDEMPRESA());
            cl.setInt(i++, tipozona.getIDSUCURSAL());
            cl.setInt(i++, tipozona.getIDZONA());
            cl.setString(i++, tipozona.getDESCRIPCION());
            cl.setInt(i++, tipozona.getIDTIPOZONA());
            cl.setInt(i++, tipozona.getIDUNIDADMEDIDA());
            cl.setDouble(i++, tipozona.getAREA());
            cl.setDouble(i++, tipozona.getAREAUNIDADDIAGRAMA());
            cl.setDouble(i++, tipozona.getLARGOUNIDADDIAGRAMA());
            cl.setDouble(i++, tipozona.getANCHOUNIDADDIAGRAMA());
            cl.setString(i++, tipozona.getFECHACREACION());
            cl.setBoolean(i++, tipozona.isESTADO());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public String calculoAreaDiagrama(int idempresa, int unidadmedida, double area) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
        String sql = "SP_CALCULAR_DIAGRAMA";
        cn = obtenerConexionJTDS();
        cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
        cl.setInt(i++, idempresa);
        cl.setInt(i++, unidadmedida);
        cl.setDouble(i++, area);
        rs = cl.executeQuery();
        while (rs.next()) {
            resultado = (rs.getString("AREADIAGRAMA"));
        }
        return resultado;
    }

    @Override
    public List<Zona> findAll(Object e) throws Exception {
        Zona oZona = null;
        List<Zona> listaZona = new ArrayList<Zona>();
        try {
            String sql = "SP_ZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, 4);/*GETRECORD ALMACEN(5)*/

            cl.setString(2, "");
            cl.setString(3, e.toString());/*++IDEMRPESA++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                oZona = new Zona();
                oZona.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oZona.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oZona.setIDZONA(rs.getInt("IDZONA"));
                oZona.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oZona.setIDTIPOZONA(rs.getInt("IDTIPOZONA"));
                oZona.setIDUNIDADMEDIDA(rs.getInt("IDUNIDADMEDIDA"));
                oZona.setAREA(rs.getDouble("AREA"));
                oZona.setAREAUNIDADDIAGRAMA(rs.getInt("AREAUNIDADDIAGRAMA"));
                oZona.setLARGOUNIDADDIAGRAMA(rs.getInt("LARGOUNIDADDIAGRAMA"));
                oZona.setANCHOUNIDADDIAGRAMA(rs.getInt("ANCHOUNIDADDIAGRAMA"));
                oZona.setFECHACREACION(rs.getString("FECHACREACION"));
                oZona.setESTADO(rs.getBoolean("ESTADO"));
                oZona.setSUCURSAL(rs.getString("SUCURSAL"));
                oZona.setTIPOZONA(rs.getString("TIPOZONA"));
                oZona.setUNIDADMEDIDA(rs.getString("UNIDADMEDIDA"));
                oZona.setCOLOR(rs.getString("COLOR"));
                oZona.setIDPROCESO(rs.getInt("IDPROCESO"));
                listaZona.add(oZona);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaZona;
    }

    public List<Zona> findNotAlmacenes(Object e, Object e2) throws Exception {
        Zona oZona = null;
        List<Zona> listaZona = new ArrayList<Zona>();
        try {
            String sql = "SP_ZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, 9);/*GETRECORD ALMACEN(5)*/

            cl.setString(2, "");
            cl.setString(3, e.toString());/*++IDEMRPESA++*/

            cl.setString(4, e2.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oZona = new Zona();
                oZona.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oZona.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oZona.setIDZONA(rs.getInt("IDZONA"));
                oZona.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oZona.setIDTIPOZONA(rs.getInt("IDTIPOZONA"));
                oZona.setIDUNIDADMEDIDA(rs.getInt("IDUNIDADMEDIDA"));
                oZona.setAREA(rs.getDouble("AREA"));
                oZona.setAREAUNIDADDIAGRAMA(rs.getInt("AREAUNIDADDIAGRAMA"));
                oZona.setLARGOUNIDADDIAGRAMA(rs.getInt("LARGOUNIDADDIAGRAMA"));
                oZona.setANCHOUNIDADDIAGRAMA(rs.getInt("ANCHOUNIDADDIAGRAMA"));
                oZona.setFECHACREACION(rs.getString("FECHACREACION"));
                oZona.setESTADO(rs.getBoolean("ESTADO"));
                oZona.setSUCURSAL(rs.getString("SUCURSAL"));
                oZona.setTIPOZONA(rs.getString("TIPOZONA"));
                oZona.setUNIDADMEDIDA(rs.getString("UNIDADMEDIDA"));
                oZona.setCOLOR(rs.getString("COLOR"));
                listaZona.add(oZona);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaZona;
    }

    public List<Zona> findAllEmpresaSucursal(String empresa, String sucursal) throws Exception {
        Zona oZona = null;
        List<Zona> listaZona = new ArrayList<Zona>();
        try {
            String sql = "SP_ZONA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, 4);/*GETRECORD ALMACEN(5)*/

            cl.setString(2, "");
            cl.setString(3, empresa);/*++IDEMRPESA++*/

            cl.setString(4, sucursal);/*++IDSUCURSAL++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                oZona = new Zona();
                oZona.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oZona.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oZona.setIDZONA(rs.getInt("IDZONA"));
                oZona.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oZona.setIDTIPOZONA(rs.getInt("IDTIPOZONA"));
                oZona.setIDUNIDADMEDIDA(rs.getInt("IDUNIDADMEDIDA"));
                oZona.setAREA(rs.getDouble("AREA"));
                oZona.setAREAUNIDADDIAGRAMA(rs.getInt("AREAUNIDADDIAGRAMA"));
                oZona.setLARGOUNIDADDIAGRAMA(rs.getInt("LARGOUNIDADDIAGRAMA"));
                oZona.setANCHOUNIDADDIAGRAMA(rs.getInt("ANCHOUNIDADDIAGRAMA"));
                oZona.setFECHACREACION(rs.getString("FECHACREACION"));
                oZona.setESTADO(rs.getBoolean("ESTADO"));
                oZona.setSUCURSAL(rs.getString("SUCURSAL"));
                oZona.setTIPOZONA(rs.getString("TIPOZONA"));
                oZona.setUNIDADMEDIDA(rs.getString("UNIDADMEDIDA"));
                oZona.setCOLOR(rs.getString("COLOR"));
                listaZona.add(oZona);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaZona;
    }

    public List<Zona> sincronizarZona(Object ide, Object ids, Object desde, Object hasta) throws Exception {
        List<Zona> lista = new ArrayList<Zona>();
        try {
            String sql = "SP_ZONA_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));
            cl.setInt(2, Integer.parseInt(ids.toString()));
            cl.setString(3, desde.toString().replace("-", "").trim());
            cl.setString(4, hasta.toString().replace("-", "").trim());
            rs = cl.executeQuery();
            while (rs.next()) {
                Zona oZona = new Zona();
                oZona.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oZona.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oZona.setIDZONA(rs.getInt("IDZONA"));
                oZona.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oZona.setIDTIPOZONA(rs.getInt("IDTIPOZONA"));
                oZona.setIDUNIDADMEDIDA(rs.getInt("IDUNIDADMEDIDA"));
                oZona.setAREA(rs.getDouble("AREA"));
                oZona.setAREAUNIDADDIAGRAMA(rs.getInt("AREAUNIDADDIAGRAMA"));
                oZona.setLARGOUNIDADDIAGRAMA(rs.getInt("LARGOUNIDADDIAGRAMA"));
                oZona.setANCHOUNIDADDIAGRAMA(rs.getInt("ANCHOUNIDADDIAGRAMA"));
                oZona.setFECHACREACION(rs.getString("FECHACREACION"));
                oZona.setESTADO(rs.getBoolean("ESTADO"));
                oZona.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                oZona.setCOLOR(rs.getString("COLOR"));
                lista.add(oZona);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }
    public void anular(int idempresa, int idsuc,int idzona,int est) throws Exception{
        try {
            String sql = "SP_ZONA_ELIMINAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, idempresa);
            cl.setObject(2, idsuc);
            cl.setObject(3, idzona);
            cl.setObject(4, est);
            cl.executeUpdate();            
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
