/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcomp.localtest;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author vegeta
 */
public class MBT {
    
    
    public static void main(String[] args) {
       MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase("test126"); 
        MongoCollection<Document> mcol=mdb.getCollection("sub");
        ArrayList al=new ArrayList();
      /*  mcol.find(eq("_id",new ObjectId("5b23bc0c05f89124c8090889"))).forEach((Block<Document>) (t) -> {
          ArrayList al1=(ArrayList)t.get("al");
          
          al1.forEach(ab->{al.add(ab);});
        });
        System.out.println("ARRAY LIST:"+al);
        al.add("fuxk123");
        
        mcol.updateOne(eq("_id",new ObjectId("5b23bc0c05f89124c8090889")),combine(set("al",al)));
        mcol.find(eq("_id",new ObjectId("5b23bc0c05f89124c8090889"))).forEach((Block<Document>) (t) -> {
            System.out.println("UPDATED DOCUMENT:");
            System.out.println(t);
        });*/
        FindIterable<Document> documents= mcol.find();
        for(Document a:documents){
            System.out.println(a);
        }
        mcol.updateOne(
                eq("_id", new ObjectId("5b23bc0c05f89124c8090889")),
                combine(set("fuxk1234", 21)));
       documents= mcol.find();
        for(Document a:documents){
            System.out.println(a);
        }
        mc.close();
       
    }
}
