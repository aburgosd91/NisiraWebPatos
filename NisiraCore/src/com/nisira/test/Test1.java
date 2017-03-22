/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class Test1 {
    public static void main(String[] args) {
        long dato =System.currentTimeMillis();
        List<String> prueba =new ArrayList<String>();
        for(int i=0 ;i<10000;i++){
            prueba.add(""+i);
        }
        System.out.println(System.currentTimeMillis()-dato);
        for(String item:prueba){
            if(item.startsWith("10"))
                System.out.println(item);
//            System.out.println(prueba.get(i));
        }
//        prueba.forEach(item->{//1536
//            if(item.startsWith("10"))
//                System.out.println(item);
//	});
        System.out.println(System.currentTimeMillis()-dato); 
    }
}
