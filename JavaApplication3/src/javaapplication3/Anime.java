/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
import java.net.*;
import java.util.stream.Collectors;
/**
 *
 * @author vegeta
 */
public class Anime {
    public static void main(String[] args) throws Exception{
        String ul="http://animeheaven.eu/i.php?a=Megalo%20Box";
        URL u=new URL(ul);
        HttpURLConnection httpURLConnection=(HttpURLConnection)u.openConnection();
        InputStream is=httpURLConnection.getInputStream();
        String result = new BufferedReader(new InputStreamReader(is))
        .lines().collect(Collectors.joining("\n"));
        Document document=Jsoup.parse(result);
        ArrayList<String> al=new ArrayList<>();
        Elements allElements = 
            document.getElementsByTag("a");
        for (Element element : allElements) {
            if(element.attr("href").contains("watch.php")){
                
                String string="http://animeheaven.eu/"+element.attr("href");
                URL url= new URL(string);
                URI uri = new URI(url.getProtocol(), url.getUserInfo(), IDN.toASCII(url.getHost()), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
                String correctEncodedURL=uri.toASCIIString(); 
                al.add(correctEncodedURL);
                //System.out.println(correctEncodedURL);
            }
        }
        //for(int i=0;i<al.size();i++){
            String ul1=al.get(1);
            System.out.println(ul1);
            URL u1=new URL(ul1);
        HttpURLConnection httpURLCon=(HttpURLConnection)u1.openConnection();
        InputStream is1=httpURLCon.getInputStream();
        String res = new BufferedReader(new InputStreamReader(is1))
        .lines().collect(Collectors.joining("\n"));
            Test t=new Test();
            t.doo(ul1);
        /*Document doc=Jsoup.parse(res);
        ArrayList<String> al1=new ArrayList<>();
        Elements allEle = 
            doc.getElementsByTag("a");
        for (Element element : allEle) {
            if(element.attr("href").contains("force")){
                System.out.println(element.attr("href"));
            }
        }*/
        //}
    }
    
    
}
