package com.nisira.core.service;

import com.nisira.core.business.ReportesBusiness;
import com.nisira.core.entity.Reportes;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jcuzco
 *         
 */
public class ReportesService extends BaseService<Reportes>{
    private ReportesBusiness ReportesBusiness = new ReportesBusiness();
    
    public ReportesService(){
        super.setBaseBusiness(ReportesBusiness);
        
    }
    
    public List<Reportes> findIncxOrg() throws Exception {
        return ReportesBusiness.findIncxOrg();
    }
    public List<Reportes> findHorasxModulo() throws Exception {
        return ReportesBusiness.findHorasxModulo();
    }
    public List<Reportes> findHorasxModxMes(Integer Mes,Integer Anio) throws Exception {
        return ReportesBusiness.findHorasxModxMes(Mes,Anio);
    }
    
    public List<Reportes> findIncEstadoxDia(Date dia) throws Exception {
        return ReportesBusiness.findIncEstadoxDia(dia);
    }
    public List<Reportes> findIncDiariasxMes(Integer Mes,Integer Anio) throws Exception {
        return ReportesBusiness.findIncDiariasxMes(Mes,Anio);
    }
    public List<Reportes> findIncxOrgxMes(Integer Mes,Integer Anio) throws Exception {
        return ReportesBusiness.findIncxOrgxMes(Mes,Anio);
    }
     public List<Reportes> findDiasActividadxMes(Integer Mes,Integer Anio) throws Exception {
        return ReportesBusiness.findDiasActividadxMes(Mes,Anio);
    }
}
