/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mv1;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;

/**
 *
 * @author vegeta
 */
public class User {
    public static String database="test";
    public static String createUser(String htno,String jyear,String sec,String dept,String course,String password,String name,String role){
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase(database); 
        MongoCollection<Document> mcol=mdb.getCollection("users");
        Document doc=new Document().append("htno",htno)
                .append("jyear",jyear)
                .append("sec",sec)
                .append("dept",dept)
                .append("course",course)
                .append("password",password)
                .append("name",name)
                .append(htno,password)
                .append("role",role);
        
        
        mcol.insertOne(doc);
       /* mcol.find().forEach(new Block<Document>() {
       @Override
       public void apply(final Document document) {
           Servlet.ou.println(document.toJson());
       }
       });*/
        mc.close();
        return doc.toJson();
    }
    public static String signin(String htno,String pswd){
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase(database); 
        MongoCollection<Document> mcol=mdb.getCollection("users");
      
      /*   mcol.find().forEach(new Block<Document>() {
       @Override
       public void apply(final Document document) {
           Servlet.ou.println(document.toJson());
       }
       });
       */
        String ret;
         FindIterable<Document> documents= mcol.find(eq(htno,pswd));
        for(Document a:documents){
            
             ret=a.toJson();
        }
        ret="failure";
        mc.close();
        return ret;
    }
}
