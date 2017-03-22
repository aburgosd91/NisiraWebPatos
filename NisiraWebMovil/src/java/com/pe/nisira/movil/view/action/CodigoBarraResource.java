/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;


import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@PushEndpoint("/codigobarra")
public class CodigoBarraResource {
    @OnMessage(encoders = {JSONEncoder.class})
    public String onMessage(String filename) {
        return filename;
    }
}
