/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.DAlmacen_ColumnasBusiness;
import com.nisira.core.entity.Combos;
import com.nisira.core.entity.DAlmacen_Columnas;
import com.nisira.core.entity.DAlmacen_Racks;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_ColumnasService extends BaseService<DAlmacen_Columnas>{
    private DAlmacen_ColumnasBusiness dAlmacen_ColumnasBusiness = new DAlmacen_ColumnasBusiness();
    public DAlmacen_ColumnasService(){
        super.setBaseBusiness(dAlmacen_ColumnasBusiness);
    }
    public List<DAlmacen_Columnas> getRecordDAlmacen_ColumnasEmpresa(String empresa,String sucursal,String almacen,String distribucion,String racks,String piso,String fila) throws Exception{
        return dAlmacen_ColumnasBusiness.getRecordDAlmacen_ColumnasEmpresa(empresa, sucursal, almacen,distribucion, racks, piso, fila);
    }
    public List<DAlmacen_Columnas> getRecordDAlmacen_ColumnasDistribucionActiva(String empresa,String sucursal,String almacen,String racks,String piso) throws Exception{
        return dAlmacen_ColumnasBusiness.getRecordDAlmacen_ColumnasDistribucionActiva(empresa, sucursal, almacen, racks, piso);
    }
    public List<DAlmacen_Racks> getRecordDAlmacen_RacksFilaColumnas(String empresa,String sucursal,String almacen,String racks,String piso,String fila) throws Exception{
        return dAlmacen_ColumnasBusiness.getRecordDAlmacen_RacksFilaColumnas(empresa, sucursal, almacen, racks, piso,fila);
    }
    public List<Integer> getRecordDAlmacen_filasXcolumnas(String empresa,String sucursal,String almacen,String racks,String piso) throws Exception{
        return dAlmacen_ColumnasBusiness.getRecordDAlmacen_filasXcolumnas(empresa, sucursal, almacen, racks, piso);
    }
    public List<Combos> getRecordDAlmacen_cbofilasXcolumnas(String empresa,String sucursal,String almacen,String racks,String piso,String fila) throws Exception{
        return dAlmacen_ColumnasBusiness.getRecordDAlmacen_cbofilasXcolumnas(empresa, sucursal, almacen, racks, piso,fila);
    }
    public String addDAlmacen_Columnas(DAlmacen_Columnas dAlmacen_Columnas) throws Exception{
        return dAlmacen_ColumnasBusiness.addDAlmacen_Columnas(dAlmacen_Columnas);
    }
    public String addXmlDAlmacen_Columnas(String idempresa,String idsucursal,String idalmacen,String iddistribucion,String idrack,
            String idpiso,String idfila,String xml) throws Exception{
        return dAlmacen_ColumnasBusiness.addXmlDAlmacen_Columnas(idempresa, idsucursal, idalmacen,iddistribucion,idrack, idpiso, idfila, xml);
    }
    public String editDAlmacen_Columnas(DAlmacen_Columnas dAlmacen_Columnas) throws Exception{
        return dAlmacen_ColumnasBusiness.editDAlmacen_Columnas(dAlmacen_Columnas);
    }
    public String deleteDAlmacen_Columnas(DAlmacen_Columnas dAlmacen_Columnas) throws Exception{
        return dAlmacen_ColumnasBusiness.deleteDAlmacen_Columnas(dAlmacen_Columnas);
    }

}