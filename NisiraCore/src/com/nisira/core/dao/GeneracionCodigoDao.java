/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.GeneracionCodigo;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class GeneracionCodigoDao extends EntityDao<GeneracionCodigo> {

    @Override
    public GeneracionCodigo find(GeneracionCodigo e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String addGeneracionCodigo(GeneracionCodigo generacionCodigo) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (generacionCodigo != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_GENERACION_CODIGOS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 1);
            cl.setString(i++, "");
            cl.setInt(i++, generacionCodigo.getIDEMPRESA());
            cl.setInt(i++, generacionCodigo.getIDGENERACION());
            cl.setInt(i++, generacionCodigo.getTIPO());
            cl.setString(i++, generacionCodigo.getDESCRIPCION());
            cl.setInt(i++, generacionCodigo.getBARCODETOTAL());
            cl.setInt(i++, generacionCodigo.getESTADO());
            cl.setString(i++, "");
            cl.setString(i++, "");
            cl.setString(i++, generacionCodigo.getPARAMETRO());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("IDGENERACION"));
            }
        }
        return resultado;
    }

    public int addXmlGeneracionCodigo(int tipo, int idempresa, int idgen, String xml)
            throws Exception {
        Integer id = null;
        String sql = "SP_GENERACIONCODIGOS_GRABAR";
        cn = obtenerConexionJTDS();
        cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
        cl.setInt(1, tipo);
        cl.setString(2, xml);
        cl.setInt(3, idempresa);
        cl.setInt(4, idgen);
        rs = cl.executeQuery();
        while (rs.next()) {
            id = rs.getInt("TABLA_ID");
        }
        return id;
    }

    public String editGeneracionCodigo(GeneracionCodigo generacionCodigo) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (generacionCodigo != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_GENERACION_CODIGOS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 2);
            cl.setString(i++, "");
            cl.setInt(i++, generacionCodigo.getIDEMPRESA());
            cl.setInt(i++, generacionCodigo.getIDGENERACION());
            cl.setInt(i++, generacionCodigo.getTIPO());
            cl.setString(i++, generacionCodigo.getDESCRIPCION());
            cl.setInt(i++, generacionCodigo.getBARCODETOTAL());
            cl.setInt(i++, generacionCodigo.getESTADO());
            cl.setString(i++, "");
            cl.setString(i++, "");
            cl.setString(i++, generacionCodigo.getPARAMETRO());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    public String deleteGeneracionCodigo(GeneracionCodigo generacionCodigo) throws Exception {
        String resultado = "";
        int i = 1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (generacionCodigo != null) {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_GENERACION_CODIGOS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
            cl.setInt(i++, 3);
            cl.setString(i++, "");
            cl.setInt(i++, generacionCodigo.getIDEMPRESA());
            cl.setInt(i++, generacionCodigo.getIDGENERACION());
            cl.setInt(i++, generacionCodigo.getTIPO());
            cl.setString(i++, generacionCodigo.getDESCRIPCION());
            cl.setInt(i++, generacionCodigo.getBARCODETOTAL());
            cl.setInt(i++, generacionCodigo.getESTADO());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        }
        return resultado;
    }

    @Override
    public List<GeneracionCodigo> findAll(Object e1) throws Exception {
        GeneracionCodigo oGeneracionCodigo = null;
        List<GeneracionCodigo> listaGeneracionCodigo = new ArrayList<GeneracionCodigo>();
        try {
            String sql = "SP_GENERACION_CODIGOS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, 4);/*GETRECORD ALMACEN(5)*/

            cl.setString(2, "");
            cl.setString(3, e1.toString());/*++IDEMRPESA++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                oGeneracionCodigo = new GeneracionCodigo();
                oGeneracionCodigo.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oGeneracionCodigo.setIDGENERACION(rs.getInt("IDGENERACION"));
                oGeneracionCodigo.setTIPO(rs.getInt("TIPO"));
                oGeneracionCodigo.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oGeneracionCodigo.setBARCODETOTAL(rs.getInt("BARCODETOTAL"));
                oGeneracionCodigo.setESTADO(rs.getInt("ESTADO"));
//                oGeneracionCodigo.setFECHACREACION("04-02-2016");
                oGeneracionCodigo.setSINCRONIZADO(0);
                oGeneracionCodigo.setPARAMETRO(rs.getString("PARAMETRO"));
                oGeneracionCodigo.setIDPROCESO(rs.getInt("IDPROCESO"));
                listaGeneracionCodigo.add(oGeneracionCodigo);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaGeneracionCodigo;
    }

    public List<GeneracionCodigo> SincroGenCodigo(Object e1, Object desde, Object hasta) throws Exception {
        GeneracionCodigo oGeneracionCodigo = null;
        List<GeneracionCodigo> listaGeneracionCodigo = new ArrayList<GeneracionCodigo>();
        try {
            String sql = "SP_GENERACION_CODIGOS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(1, 6);/*GETRECORD ALMACEN(5)*/

            cl.setString(2, "");
            cl.setInt(3, Integer.valueOf(e1.toString()));/*++IDEMRPESA++*/

            cl.setInt(4, 0);/*++IDGENERACION++*/

            cl.setInt(5, 0);/*++TIPO_++*/

            cl.setString(6, e1.toString());/*++DESCRIPCION++*/

            cl.setInt(7, 0);/*++NUMDIGITOTOTAL++*/

            cl.setInt(8, 0);/*++ESTADO++*/

            cl.setString(9, desde.toString().replace("-", "").trim());/*++DESDE++*/

            cl.setString(10, hasta.toString().replace("-", "").trim());/*++HASTA++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                oGeneracionCodigo = new GeneracionCodigo();
                oGeneracionCodigo.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oGeneracionCodigo.setIDGENERACION(rs.getInt("IDGENERACION"));
                oGeneracionCodigo.setTIPO(rs.getInt("TIPO"));
                oGeneracionCodigo.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oGeneracionCodigo.setBARCODETOTAL(rs.getInt("BARCODETOTAL"));
                oGeneracionCodigo.setESTADO(rs.getInt("ESTADO"));
                oGeneracionCodigo.setFECHACREACION(rs.getString("FECHACREACION"));
                oGeneracionCodigo.setSINCRONIZADO(0);
                oGeneracionCodigo.setPARAMETRO(rs.getString("PARAMETRO"));
                oGeneracionCodigo.setIDPROCESO(rs.getInt("IDPROCESO"));
                listaGeneracionCodigo.add(oGeneracionCodigo);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaGeneracionCodigo;
    }

    @Override
    public List<GeneracionCodigo> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<GeneracionCodigo> findByIdProceso(Object ide, Object idp) throws Exception {
        List<GeneracionCodigo> listaGeneracionCodigo = new ArrayList<GeneracionCodigo>();
        try {
            String sql = "SP_GENERACION_Proceso";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, ide);/*++IDEMRPESA++*/

            cl.setObject(2, idp);
            rs = cl.executeQuery();
            while (rs.next()) {
                GeneracionCodigo oGeneracionCodigo = new GeneracionCodigo();
                oGeneracionCodigo.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oGeneracionCodigo.setIDGENERACION(rs.getInt("IDGENERACION"));
                oGeneracionCodigo.setTIPO(rs.getInt("TIPO"));
                oGeneracionCodigo.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oGeneracionCodigo.setBARCODETOTAL(rs.getInt("BARCODETOTAL"));
                oGeneracionCodigo.setESTADO(rs.getInt("ESTADO"));
//                oGeneracionCodigo.setFECHACREACION("04-02-2016");
                oGeneracionCodigo.setSINCRONIZADO(0);
                oGeneracionCodigo.setPARAMETRO(rs.getString("PARAMETRO"));
                listaGeneracionCodigo.add(oGeneracionCodigo);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaGeneracionCodigo;
    }

    public GeneracionCodigo fineOne(Object e1,Object e2) throws Exception {
        GeneracionCodigo rl = new GeneracionCodigo();
        try {
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select * from GENERACIONCODIGOS where IDEMPRESA = ? and IDGENERACION = ?");
            pr.setObject(1, e1);
            pr.setObject(2, e2);
            rs = pr.executeQuery();
            while (rs.next()) {
                rl.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                rl.setIDGENERACION(rs.getInt("IDGENERACION"));
                rl.setTIPO(rs.getInt("TIPO"));
                rl.setDESCRIPCION(rs.getString("DESCRIPCION"));
                rl.setBARCODETOTAL(rs.getInt("BARCODETOTAL"));
                rl.setESTADO(rs.getInt("ESTADO"));
//                oGeneracionCodigo.setFECHACREACION("04-02-2016");
                rl.setSINCRONIZADO(0);
                rl.setPARAMETRO(rs.getString("PARAMETRO"));
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return rl;

    }
}
