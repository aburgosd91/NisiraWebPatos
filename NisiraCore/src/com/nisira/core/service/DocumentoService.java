/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;
import com.nisira.core.business.DocumentoBusiness;
import com.nisira.core.entity.Documento;
import java.util.List;
/**
 *
 * @author Victor Zavala Llanos
 */
public class DocumentoService extends BaseService<Documento>{
    private DocumentoBusiness DocumentoBusiness = new DocumentoBusiness();
    public DocumentoService(){
        super.setBaseBusiness(DocumentoBusiness);
    }
    public List<Documento> getRecordDocumentoEmpresa(String empresa) throws Exception{
        return DocumentoBusiness.getRecordDocumentoEmpresa(empresa);
    }
    
    public String saveDocumento(Documento documento) throws Exception{
        return DocumentoBusiness.saveDocumento(documento);
    }
    
    public String anularDocumento(Documento documento) throws Exception{
        return DocumentoBusiness.anularDocumento(documento);
    }
    public String deleteDocumento(Documento documento) throws Exception{
        return DocumentoBusiness.deleteDocumento(documento);
    }
    public Documento findById(String idempresa,String iddocumento) throws Exception{
        return DocumentoBusiness.findById(idempresa,iddocumento);
    }
}
