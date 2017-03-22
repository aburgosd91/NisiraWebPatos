package com.nisira.core.dao;

import com.nisira.framework.core.dao.EntityDao;
import com.nisira.core.entity.Reportes;
import java.util.ArrayList;
import static com.nisira.framework.core.util.ConstantesFramework.INICIO_SELECT;
import static com.nisira.framework.core.util.ConstantesFramework.FIN_SELECT;
import java.util.Date;
import com.pe.nisira.utilitarios.UtilWeb;
import java.sql.ResultSetMetaData;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author jcuzco
 */
public class ReportesDao extends EntityDao<Reportes> {

    @Override
    public Reportes find(Reportes e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Reportes> findAll(Object e) throws Exception {
        List<Reportes> lista = new ArrayList<Reportes>();
        try {
            String sql = INICIO_SELECT + "RepIncidenciasxOrg" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setString(1, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                Reportes col = new Reportes();

                col.setCNombre(rs.getString("cNombre"));

                lista.add(col);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    @Override
    public List<Reportes> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Reportes> findIncxOrg() throws Exception {
        List<Reportes> lista = new ArrayList<Reportes>();
        try {
            String sql = INICIO_SELECT + "RepIncidenciasxOrg" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "}");

            rs = cl.executeQuery();
            while (rs.next()) {
                Reportes col = new Reportes();

                col.setCNombre(rs.getString("cNombre"));
                col.setICantidad((Integer.parseInt(rs.getString("iCantidad"))));
                col.setICantidadD(rs.getDouble("iHoras"));


                lista.add(col);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<Reportes> findHorasxModulo() throws Exception {
        List<Reportes> lista = new ArrayList<Reportes>();
        try {
            String sql = INICIO_SELECT + "RepHorasxModulo" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "}");

            rs = cl.executeQuery();
            while (rs.next()) {
                Reportes col = new Reportes();

                col.setCNombre(rs.getString("cNombre"));
                col.setICantidadD(rs.getDouble("iCantidadD"));
                col.setICantidad(Integer.parseInt(rs.getString("iCantidad")));

                lista.add(col);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<Reportes> findIncEstadoxDia(Date dia) throws Exception {
        List<Reportes> lista = new ArrayList<Reportes>();
        try {
            String sql = INICIO_SELECT + "RepIncidenciasEstadoxDia" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setTimestamp(1, UtilWeb.convertirDateTimestamp(dia));
            rs = cl.executeQuery();
            while (rs.next()) {
                Reportes col = new Reportes();

                col.setCNombre(rs.getString("cEstado"));
                col.setICantidad(Integer.parseInt(rs.getString("Cantidad")));

                lista.add(col);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<Reportes> findIncDiariasxMes(Integer Mes, Integer Anio) throws Exception {
        List<Reportes> lista = new ArrayList<Reportes>();
        try {
            String sql = INICIO_SELECT + "RepIncidenciasDiariasxMes" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1, Mes);
            cl.setInt(2, Anio);
            rs = cl.executeQuery();
            while (rs.next()) {
                Reportes col = new Reportes();

                col.setCNombre(rs.getString("dia"));
                col.setICantidad(Integer.parseInt(rs.getString("cantidad")));

                lista.add(col);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<Reportes> findIncxOrgxMes(Integer Mes, Integer Anio) throws Exception {
        List<Reportes> lista = new ArrayList<Reportes>();
        try {
            String sql = INICIO_SELECT + "RepIncidenciasxOrgxMes" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1, Mes);
            cl.setInt(2, Anio);
            rs = cl.executeQuery();
            while (rs.next()) {
                Reportes col = new Reportes();

                col.setCNombre(rs.getString("cNombre"));
                col.setICantidad((Integer.parseInt(rs.getString("iCantidad"))));
                col.setICantidadD(rs.getDouble("iHoras"));

                lista.add(col);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<Reportes> findHorasxModxMes(Integer Mes, Integer Anio) throws Exception {
        List<Reportes> lista = new ArrayList<Reportes>();
        try {
            String sql = INICIO_SELECT + "RepHorasxModuloxMes" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1, Mes);
            cl.setInt(2, Anio);
            rs = cl.executeQuery();
            while (rs.next()) {
                Reportes col = new Reportes();

                col.setCNombre(rs.getString("cNombre"));
                col.setICantidadD(rs.getDouble("iCantidadD"));
                col.setICantidad(Integer.parseInt(rs.getString("iCantidad")));

                lista.add(col);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<Reportes> findDiasActividadxMes(Integer Mes, Integer Anio) throws Exception {
        List<Reportes> lista = new ArrayList<Reportes>();
        try {
            String sql = INICIO_SELECT + "RepDiasActividadxMes" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1, Mes);
            cl.setInt(2, Anio);
            rs = cl.executeQuery();
            while (rs.next()) {
                Reportes col = new Reportes();

                col.setCNombre(rs.getString("cNombre"));
                col.setICantidad(Integer.parseInt(rs.getString("cCantidad")));

                lista.add(col);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public Vector horasDiasActividad(Integer Mes, Integer Anio,String valor) throws Exception {
        Vector v = new Vector();
        try {
            String sql = INICIO_SELECT + "RepDiasHorasActividadxMes" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, Mes);
            cl.setInt(2, Anio);
            cl.setString(3, valor);

            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            v.add(titCols);
            while (rs.next()) {

                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                v.add(reg);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return v;
    }

    public Vector horasDiasActividadDetalle(String dia,String mes, String anio,String valor,String usuario) throws Exception {
        Vector v = new Vector();
        
        
        try {
            String sql = INICIO_SELECT + "RepDiasHorasActividadxMes_Detalle" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setString(1, dia);
            cl.setString(2, mes);
            cl.setString(3, anio);
            cl.setString(4, valor);
            cl.setString(5, usuario);
            
            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            v.add(titCols);
            while (rs.next()) {

                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                v.add(reg);
               
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return v;
    }


    public Vector horasDiasActividadDesarrollo(Integer Mes, Integer Anio,String valor,String act) throws Exception {
        Vector v = new Vector();
        try {  
           
            String sql = INICIO_SELECT + "RepDiasAvanceActividadDesarrolloxMes" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Mes);
            cl.setInt(2, Anio);
            cl.setString(3, valor);
            cl.setString(4,act);

            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            v.add(titCols);
            while (rs.next()) {

                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                v.add(reg);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return v;
    }

    public Vector horasDiasActividadDetalleDesarrollo(String dia,String mes, String anio,String valor,String usuario) throws Exception {
        Vector v = new Vector();
        
        
        try {
            String sql = INICIO_SELECT + "RepDiasHorasActividadDesarrolloxMes_Detalle" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setString(1, dia);
            cl.setString(2, mes);
            cl.setString(3, anio);
            cl.setString(4, valor);
            cl.setString(5, usuario);
            
            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            v.add(titCols);
            while (rs.next()) {

                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                v.add(reg);
               
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return v;
    }

    
    public Vector diaVacaciones(String dia,String mes, String anio,String usuario) throws Exception {
        Vector v = new Vector(); 
        try {
            String sql = "diaVacaciones";
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setString(1, dia);
            cl.setString(2, mes);
            cl.setString(3, anio);
            cl.setString(4, usuario);
            
            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            v.add(titCols);
            while (rs.next()) {

                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                v.add(reg); 
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return v;
    }
    
    public Vector devuelve_cumpleanos_xmes() throws Exception {
        Vector v = new Vector();
        boolean datos=false;
        try {
            String sql = "devuelve_cumpleanos_xmes";
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();
            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            v.add(titCols);
            while (rs.next()) {
                datos=true;
                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                v.add(reg); 
            }
            if (!datos){
                String[] reg = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    reg[i] = " ";
                }
                v.add(reg); 
            }
     
        } finally {
            cerrar(cn, cl, rs);
        }
        return v;
    }
    
    public Vector tiposExcepciones() throws Exception {
        Vector v = new Vector();
        boolean datos=false;
        try {
            cn = obtenerConexion();
            pr = cn.prepareStatement("select * from TG20TipoVacAct where iHabilitado=1");
            rs = pr.executeQuery();
            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            v.add(titCols);
            while (rs.next()) {
                datos=true;
                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                v.add(reg); 
            }
            if (!datos){
                String[] reg = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    reg[i] = " ";
                }
                v.add(reg); 
            }
     
        } finally {
            cerrar(cn, pr, rs);
        }
        return v;
    }
    
    
    
    
    
    
    
    
    




}
