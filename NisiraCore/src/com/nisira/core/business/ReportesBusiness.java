
package com.nisira.core.business;
 
import com.nisira.core.dao.ReportesDao;
import com.nisira.core.entity.Reportes;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jcuzco
 */
public class ReportesBusiness extends BaseBusiness<Reportes> {

     private ReportesDao ReportesDao = new ReportesDao();
    
    public ReportesBusiness(){
        super.setBaseDao(ReportesDao);
    }
    
      public List<Reportes> findIncxOrg() throws Exception {
        return ReportesDao.findIncxOrg();
    }
      public List<Reportes> findHorasxModulo() throws Exception {
        return ReportesDao.findHorasxModulo();
    }
      public List<Reportes> findHorasxModxMes(Integer Mes,Integer Anio) throws Exception {
        return ReportesDao.findHorasxModxMes(Mes,Anio);
    } 
    
       public List<Reportes> findIncEstadoxDia(Date dia) throws Exception {
        return ReportesDao.findIncEstadoxDia(dia);
    } 
        public List<Reportes> findIncDiariasxMes(Integer Mes,Integer Anio) throws Exception {
        return ReportesDao.findIncDiariasxMes(Mes,Anio);
    } 
        public List<Reportes> findIncxOrgxMes(Integer Mes,Integer Anio) throws Exception {
        return ReportesDao.findIncxOrgxMes(Mes,Anio);
    } 
      public List<Reportes> findDiasActividadxMes(Integer Mes,Integer Anio) throws Exception {
        return ReportesDao.findDiasActividadxMes(Mes,Anio);
    }    
}
