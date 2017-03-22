/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Afp;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class AfpDao extends EntityDao<Afp>{

    @Override
    public Afp insert(Afp e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Afp update(Afp e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Afp delete(Afp e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Afp find(Afp e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Afp> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Afp> findAll() throws Exception {
        List<Afp> lista=new ArrayList<Afp>();
        try {            
            String sql ="PRUEBA_SELECT_1";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "}" );
           // cl.setString(1, e.toString());
            rs = cl.executeQuery();
            while(rs.next()){
               Afp col = new Afp();
               col.setIdafp(rs.getString("IDAFP"));
               col.setDescripcion(rs.getString("DESCRIPCION"));
               col.setIdregimen(rs.getInt("IDREGIMEN"));
               col.setEstado(rs.getBoolean("ESTADO"));
               col.setSicroniza(rs.getString("SINCRONIZA").charAt(0));
               col.setFechaCreacion(rs.getString("FECHACREACION"));
               lista.add(col);
            
            }            
        } finally {            
            cerrar(cn, cl, rs);
        }
        return lista;  //To change body of generated methods, choose Tools | Templates.
    }
    public List<Afp> findAllFiltro(String parametro) throws Exception {
        List<Afp> lista=new ArrayList<Afp>();
        try {            
            String sql ="PRUEBA_SELECT_2";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}" );
            cl.setString(1,parametro);
            rs = cl.executeQuery();
            while(rs.next()){
               Afp col = new Afp();
               col.setIdafp(rs.getString("IDAFP"));
               col.setDescripcion(rs.getString("DESCRIPCION"));
               col.setIdregimen(rs.getInt("IDREGIMEN"));
               col.setEstado(rs.getBoolean("ESTADO"));
               col.setSicroniza(rs.getString("SINCRONIZA").charAt(0));
               col.setFechaCreacion(rs.getString("FECHACREACION"));
               lista.add(col);
            
            }            
        } finally {            
            cerrar(cn, cl, rs);
        }
        return lista;  //To change body of generated methods, choose Tools | Templates.
    }
    
}
