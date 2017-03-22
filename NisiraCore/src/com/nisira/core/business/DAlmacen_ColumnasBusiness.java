/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DAlmacen_ColumnasDao;
import com.nisira.core.entity.Combos;
import com.nisira.core.entity.DAlmacen_Columnas;
import com.nisira.core.entity.DAlmacen_Racks;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_ColumnasBusiness extends BaseBusiness<DAlmacen_Columnas>{
    private DAlmacen_ColumnasDao dAlmacen_ColumnasDao= new  DAlmacen_ColumnasDao();
    public DAlmacen_ColumnasBusiness(){
        super.setBaseDao(dAlmacen_ColumnasDao);
    }
    public List<DAlmacen_Columnas> getRecordDAlmacen_ColumnasEmpresa(String empresa,String sucursal,String almacen,String distribucion,String racks,String piso,String fila) throws Exception{
        return dAlmacen_ColumnasDao.findAll(empresa,sucursal,almacen,distribucion,racks,piso,fila);
    }
    public List<DAlmacen_Columnas> getRecordDAlmacen_ColumnasDistribucionActiva(String empresa,String sucursal,String almacen,String racks,String piso) throws Exception{
        return dAlmacen_ColumnasDao.findAllDistribucionActiva(empresa,sucursal,almacen,racks,piso);
    }
    public List<DAlmacen_Racks> getRecordDAlmacen_RacksFilaColumnas(String empresa,String sucursal,String almacen,String racks,String piso,String fila) throws Exception{
        return dAlmacen_ColumnasDao.findAllRacksFilasColumnas(empresa,sucursal,almacen,racks,piso,fila);
    }
    public List<Integer> getRecordDAlmacen_filasXcolumnas(String empresa,String sucursal,String almacen,String racks,String piso) throws Exception{
        return dAlmacen_ColumnasDao.filaXcolumna(empresa,sucursal,almacen,racks,piso);
    }
    public List<Combos> getRecordDAlmacen_cbofilasXcolumnas(String empresa,String sucursal,String almacen,String racks,String piso,String fila) throws Exception{
        return dAlmacen_ColumnasDao.cboRackFilasColumnas(empresa,sucursal,almacen,"",racks,piso,fila);
    }
    public String addDAlmacen_Columnas(DAlmacen_Columnas dAlmacen_Columnas) throws Exception{
        return dAlmacen_ColumnasDao.addDAlmacen_Columnas(dAlmacen_Columnas);
    }
    public String addXmlDAlmacen_Columnas(String idempresa,String idsucursal,String idalmacen,String iddistribucion,String idrack,
            String idpiso,String idfila,String xml) throws Exception{
        return dAlmacen_ColumnasDao.addXmlDAlmacen_Columnas(idempresa, idsucursal, idalmacen,iddistribucion, idrack, idpiso, idfila, xml);
    }
    public String editDAlmacen_Columnas(DAlmacen_Columnas dAlmacen_Columnas) throws Exception{
        return dAlmacen_ColumnasDao.editDAlmacen_Columnas(dAlmacen_Columnas);
    }
    public String deleteDAlmacen_Columnas(DAlmacen_Columnas dAlmacen_Columnas) throws Exception{
        return dAlmacen_ColumnasDao.deleteDAlmacen_Columnas(dAlmacen_Columnas);
    }
}
