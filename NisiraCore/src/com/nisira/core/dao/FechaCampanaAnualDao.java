/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.framework.core.dao.EntityDao;
import com.nisira.core.entity.FechaCampanaAnual;
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
public class FechaCampanaAnualDao extends EntityDao<FechaCampanaAnual> {

    @Override
    public FechaCampanaAnual find(FechaCampanaAnual e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    @Override
    public List<FechaCampanaAnual> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    
    @Override
    public FechaCampanaAnual update(FechaCampanaAnual e) throws Exception {
          throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<FechaCampanaAnual> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<FechaCampanaAnual> findByEmpresa(String idempresa) throws Exception{
        ArrayList<FechaCampanaAnual> lista_FechaCampanaAnual = new ArrayList<FechaCampanaAnual>();
        try {            
            String sql = "GETRECORD_RETURN_ALL_FECHA_CAMPANA_ANUAL";            
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setString(1,idempresa);
            rs = cl.executeQuery();

            while (rs.next()) {
                FechaCampanaAnual oFechaCampanaAnual = new FechaCampanaAnual();
                oFechaCampanaAnual.setIdempresa(rs.getString("IDEMPRESA")==null?"":rs.getString("IDEMPRESA"));
                oFechaCampanaAnual.setIdfecha(rs.getString("IDFECHA")==null?"":rs.getString("IDFECHA"));
                oFechaCampanaAnual.setDescripcion(rs.getString("DESCRIPCION")==null?"":rs.getString("DESCRIPCION"));
                oFechaCampanaAnual.setFechainicio(rs.getDate("FECHAINICIO")==null? null:rs.getDate("FECHAINICIO"));                
                oFechaCampanaAnual.setFechafinal(rs.getDate("FECHAFINAL")==null? null:rs.getDate("FECHAFINAL"));                
                lista_FechaCampanaAnual.add(oFechaCampanaAnual);
            }
        }
        catch (Exception e)
        {

        }
        finally {
            cerrar(cn, cl, rs);
        }

        return lista_FechaCampanaAnual;
    }    
}
