/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.framework.core.dao.EntityDao;
import com.nisira.core.entity.UbicacionCamara;
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
public class UbicacionCamaraDao extends EntityDao<UbicacionCamara> {

    @Override
    public UbicacionCamara find(UbicacionCamara e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    @Override
    public List<UbicacionCamara> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    
    @Override
    public UbicacionCamara update(UbicacionCamara e) throws Exception {
          throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<UbicacionCamara> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public UbicacionCamara findByIdUbicacionCamara(String idempresa,String idubicacion) throws Exception{

        UbicacionCamara oubicacioncamara = null;
            try {
                String sql = "nsp_distcam_movil_findUbicacionById_s";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
                cl.setString(1,idempresa);
                cl.setString(2,idubicacion);

                rs = cl.executeQuery();

                while (rs.next()) {

                    oubicacioncamara = new UbicacionCamara();
                    oubicacioncamara.setIdempresa(idempresa);
                    oubicacioncamara.setIdcamara(rs.getString("IDCAMARA"));
                    oubicacioncamara.setDesccamara(rs.getString("DESCCAMARA"));
                    oubicacioncamara.setNombrecortocamara(rs.getString("NOMBRECORTOCAMARA"));
                    oubicacioncamara.setTipocamara(rs.getString("TIPOCAMARA"));
                    oubicacioncamara.setIdubicacion(rs.getString("IDUBICACION"));
                    oubicacioncamara.setTipoubicacion(rs.getString("TIPOUBICACION"));

                }
            }
            catch (Exception e)
            {
            }
            finally {
                cerrar(cn, cl, rs);
            }        
        return oubicacioncamara;
    }
    
}
