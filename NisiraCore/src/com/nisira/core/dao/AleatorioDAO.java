
package com.nisira.core.dao;
 
import com.nisira.framework.core.dao.EntityDao;
import com.nisira.core.entity.Aleatorio;
import com.pe.nisira.utilitarios.UtilWeb;
import java.util.ArrayList;

import static com.nisira.framework.core.util.ConstantesFramework.INICIO_SELECT;
import static com.nisira.framework.core.util.ConstantesFramework.FIN_SELECT;

import java.util.List;
/**
 *
 * @author jcuzco
 */
public class AleatorioDAO extends EntityDao<Aleatorio> {

@Override
    public Aleatorio find(Aleatorio e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Aleatorio> findAll(Object e) throws Exception {
        List<Aleatorio> lista=new ArrayList<Aleatorio>();
        try {            
            String sql ="NSP_OBTENERGENERADO";
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL " + sql + "}" );
           // cl.setString(1, e.toString());
            rs = cl.executeQuery();
            while(rs.next()){
                
//                System.out.println(rs.getString("ID"));
                
               Aleatorio col = new Aleatorio();
//               
               col.setGENERADO(rs.getString("GENERADO"));
//               
               lista.add(col);
            
            }            
        } finally {            
            cerrar(cn, cl, rs);
        }
        return lista; 
    }

    public List<Aleatorio> findAll() throws Exception {
     throw new UnsupportedOperationException("Not supported yet.");
    }
        
}
