/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.framework.core.dao.EntityDao;
import com.nisira.core.entity.Empresa;
import java.util.ArrayList;
import java.util.List;
import static com.nisira.framework.core.util.ConstantesFramework.INICIO_SELECT;
import static com.nisira.framework.core.util.ConstantesFramework.FIN_SELECT;
import com.nisira.core.entity.Privilegios;
import static com.nisira.core.util.CoreUtil.consulta;

/**
 *
 * @author Antenor
 */
public class EmpresaDao extends EntityDao<Empresa> {

    @Override
    public Empresa find(Empresa e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Empresa> findAll() throws Exception {
        ArrayList<Empresa> lista_empresa = new ArrayList<Empresa>();
        try {
            String sql = "GETRECORD_RETURN_ALL_EMPRESAS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();

            while (rs.next()) {

                Empresa oEmpresa = new Empresa();
                oEmpresa.setIdempresa(rs.getString("IDEMPRESA") == null ? "" : rs.getString("IDEMPRESA"));
                oEmpresa.setDescripcion(rs.getString("DESCRIPCION") == null ? "" : rs.getString("DESCRIPCION"));
                lista_empresa.add(oEmpresa);
            }
        } catch (Exception e) {

        } finally {
            cerrar(cn, cl, rs);
        }

        return lista_empresa;
    }

    @Override
    public Empresa update(Empresa e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Empresa> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Empresa> findByBaseDatos(String idbasedatos) throws Exception {
        ArrayList<Empresa> lista_empresa = new ArrayList<Empresa>();
        try {
            String sql = "GETRECORD_RETURN_ALL_EMPRESAS";
            cn = obtenerConexionJTDS(idbasedatos);
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();

            while (rs.next()) {

                Empresa oEmpresa = new Empresa();
                oEmpresa.setIdbasedatos(rs.getString("IDBASEDATOS") == null ? "" : rs.getString("IDBASEDATOS"));
                oEmpresa.setIdempresa(rs.getString("IDEMPRESA") == null ? "" : rs.getString("IDEMPRESA"));
                oEmpresa.setDescripcion(rs.getString("DESCRIPCION") == null ? "" : rs.getString("DESCRIPCION"));
                lista_empresa.add(oEmpresa);
            }
        } catch (Exception e) {

        } finally {
            cerrar(cn, cl, rs);
        }

        return lista_empresa;
    }

    public ArrayList<Empresa> findByEmpresasMovil(String idbasedatos) throws Exception {
        ArrayList<Empresa> lista_empresa = new ArrayList<Empresa>();
        try {
            String sql = "Select_Empresas_MNT";
            cn = obtenerConexionJTDS(idbasedatos);
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();

            while (rs.next()) {
                Empresa oEmpresa = new Empresa();
                oEmpresa.setIdempresa(rs.getString("IDEMPRESA"));
                oEmpresa.setDireccion(rs.getString("DIRECCION"));
                oEmpresa.setRazon_social(rs.getString("RAZON_SOCIAL"));
                oEmpresa.setRuc(rs.getString("RUC"));
                oEmpresa.setRuta_exportar(rs.getString("RUTA_EXPORTAR"));
                oEmpresa.setRuta_reportes(rs.getString("RUTA_REPORTES"));
                lista_empresa.add(oEmpresa);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista_empresa;
    }

    public void updateEmpres(Empresa emp) throws Exception {
        try {
            String sql = "Mnt_update_Empresa";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(emp.getIdempresa()));/*GETRECORD ALMACEN(5)*/

            cl.setString(2, emp.getDireccion());
            cl.setString(3, emp.getRazon_social());
            cl.setString(4, emp.getRuc());
            cl.setString(5, emp.getRuta_exportar());
            cl.setString(6, emp.getRuta_reportes());
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
