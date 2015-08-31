/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Dummy implements Serializable {
 
    private static final long serialVersionUID = 1094801825228386363L;
     
    public String getString(int n){
        return "hola";
    }
    
    public Date getDate(int i){
        return new Date();
    }
    
    public int getInt(int i){
        return i;
    }
    
    public Object getList(int n){
        ArrayList a=new ArrayList();
        for(int i=0;i<20;i++){
            a.add(new Dummy());
        }
        return a;
    }
}
