/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.util;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
 
public class RequestListener implements ServletRequestListener {
 
	public void requestInitialized(ServletRequestEvent event) {
//                        System.out.println("getSource()="
//				+ event.getSource());
//                         System.out.println("event.getServletRequest().getLocalAddr()="
//				+ ((HttpServletRequest)event.getServletRequest()).getRequestURI());
//            System.out.println("event.getServletRequest().getLocalAddr()="
//				+ event.getServletRequest().getLocalAddr());
//		System.out.println("now initializing request"
//				+ event.getServletRequest().getRemoteAddr());
 
	}
 
    @Override
    public void requestDestroyed(ServletRequestEvent event){
//        System.out.println("DESTROYED="+event.getServletRequest().getRemoteAddr());
    }
    
}