/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/**
 *
 * @author vegeta
 */
public class JavaApplication3 {
    private static final String Boundary = "--7d021a37605f0";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        /*String url="http://ec2-13-127-49-132.ap-south-1.compute.amazonaw"
                + "s.com:8080/ServD/TServlet";
        URL u=new URL(url);
        HttpURLConnection httpURLConnection=(HttpURLConnection)u.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setChunkedStreamingMode(1024);
        
        
        
        DataOutputStream httpOut=new DataOutputStream(httpURLConnection.getOutputStream());
        String str = "ABCDEFGHIJKLMNOPQQRSTUVWXYZ";
        httpOut.write(str.getBytes());
        httpOut.flush();
        httpOut.close();
        
        InputStream is=httpURLConnection.getInputStream();
        String result = new BufferedReader(new InputStreamReader(is))
        .lines().collect(Collectors.joining("\n"));
                System.out.println(result);*/
        t();
                
}
    public static void t() throws Exception{
        String url="http://ec2-13-127-49-132.ap-south-1.compute.amazonaw" +
                "s.com:8080/ServD/upload";
        URL u=new URL(url);
        HttpURLConnection httpURLConnection=(HttpURLConnection)u.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setChunkedStreamingMode(1024);
        
        
        
       DataOutputStream httpOut=new DataOutputStream(httpURLConnection.getOutputStream());
        String str = "fuck you";
        httpOut.write(str.getBytes());
        httpOut.flush();
        httpOut.close();
        
       
        InputStream is=httpURLConnection.getInputStream();
        String result = new BufferedReader(new InputStreamReader(is))
        .lines().collect(Collectors.joining("\n"));
                System.out.println(result);
       
    }
    
    
}
