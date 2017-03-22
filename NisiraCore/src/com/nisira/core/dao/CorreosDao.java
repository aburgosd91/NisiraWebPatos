
package com.nisira.core.dao;
 
import com.nisira.framework.core.dao.EntityDao;
import com.nisira.core.entity.Correos;
import java.util.ArrayList;

import static com.nisira.framework.core.util.ConstantesFramework.INICIO_SELECT;
import static com.nisira.framework.core.util.ConstantesFramework.FIN_SELECT;

import java.util.List;
/**
 *
 * @author jcuzco
 */
public class CorreosDao extends EntityDao<Correos> {

    @Override
    public Correos find(Correos e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Correos> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Correos> findAll() throws Exception {
        List<Correos> lista=new ArrayList<Correos>();
        try {            
            String sql = INICIO_SELECT + "CorreosPersonal" + FIN_SELECT;
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "}");
            
            rs = cl.executeQuery();
            while(rs.next()){
               Correos col = new Correos();
               
            col.setCUsuario(rs.getString("cUsuario"));    
            col.setCNombre(rs.getString("cNombrePersonal"));
            col.setCCorreo(rs.getString("cCorreoEmpresa"));
            col.setCEmpresa(rs.getString("cOrganizacion"));
            col.setBSelec(false);
            
            lista.add(col);
            }            
        } finally {  
            
            cerrar(cn, cl, rs);
        }
        return lista;     
    } 
        
}
