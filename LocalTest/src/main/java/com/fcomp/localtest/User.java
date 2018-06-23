/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcomp.localtest;

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
    public void createUser(String htno,String jyear,String sec,String dept,String course,String password,String name){
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase("test"); 
        MongoCollection<Document> mcol=mdb.getCollection("users");
        Document doc=new Document().append("htno",htno)
                .append("jyear",jyear)
                .append("sec",sec)
                .append("dept",dept)
                .append("course",course)
                .append("password",password)
                .append("name",name)
                .append(htno,password);
        mc.close();
    }
    public String signin(String htno,String pswd){
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase("test"); 
        MongoCollection<Document> mcol=mdb.getCollection("sub");
         
         FindIterable<Document> documents= mcol.find(eq(htno,pswd));
        for(Document a:documents){
            mc.close();
            return "suceess";
        }
        mc.close();
        return "failure";
    }
    
    
}
