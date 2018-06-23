/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.prefs.Preferences;

/**
 *
 * @author vegeta
 */
import java.util.*;
public class Ttt {
    public static void main(String args[]){
        Preferences pre=Preferences.systemRoot();
       Scanner sc=new Scanner(System.in);
       String s;
       String res;
       byte[] b;
        while(true){
            s=sc.next();
            if(s.equals("1")){
                System.out.println("enter key to get:");
                res=sc.next();
               b= pre.getByteArray(res,"test".getBytes());
                System.out.println("RESULT :"+res+" value:"+new String(b));
            }
            else{
                System.out.println("enter key and value");
                res=sc.next();
                String val=sc.next();
                pre.putByteArray(res,val.getBytes());
            }
        }
    }
    
}
