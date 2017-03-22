/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DocumentoDao;
import com.nisira.core.entity.Documento;
import java.util.List;

/**
 *
 * @author Victor Zavala Llanos
 */
public class DocumentoBusiness extends BaseBusiness<Documento>{
    private DocumentoDao documentodao = new  DocumentoDao();
    public DocumentoBusiness(){
        super.setBaseDao(documentodao);
    }
    public List<Documento> getRecordDocumentoEmpresa(String empresa) throws Exception{
        return documentodao.findAll(empresa);
    }
    
    public String saveDocumento(Documento documento) throws Exception{
        return documentodao.saveDocumento(documento);
    }
 
    public String deleteDocumento(Documento documento) throws Exception{
        return documentodao.deleteDocumento(documento);
    }
     public String anularDocumento(Documento documento) throws Exception{
        return documentodao.anularDocumento(documento);
    }
    public Documento findById(String idempresa, String iddocumento) throws Exception{
        return documentodao.findById(idempresa,iddocumento);
    }
    
}
