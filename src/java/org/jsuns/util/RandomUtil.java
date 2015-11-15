/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomUtil {

    private static String A="aeiou";
    private static String L="bcdfghjklmnpqrstvwxyz";
    
    public static String getW(int wordLength,boolean spaces) {
        Random r = new Random(); // Intialize a Random Number Generator with SysTime as the seed
        StringBuilder sb = new StringBuilder(wordLength);
        int s=(int)Math.ceil(8*Math.random())+4;
        int c=(int)Math.ceil(Math.random());
        for(int i =0;i<wordLength;i++){ // For each letter in the word
            c++;
            if(c%2==1)
                sb.append(A.charAt((int)(A.length()*Math.random())));
            else
                sb.append(L.charAt((int)(L.length()*Math.random())));
            if(spaces&&c==s){
                sb.append(' ');
                s=c+(int)Math.ceil(6*Math.random())+6;
            }
        }
        return sb.toString();
    }

    public static String getCode(int i) {
        return UUID.randomUUID().toString().substring(0,i);
    }
    
    public static double getNumber(int max,int min,int decimal){
        return min+Math.random()*(max-min);
    }
    
    public static Date getDate(){
        return new Date(1981+(int)(Math.random()*34),1+(int)(Math.random()*11),1+(int)(Math.random()*28));
    }
}
