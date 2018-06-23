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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import org.bson.Document;
import org.bson.types.ObjectId;
/**
 *
 * @author vegeta
 */
public class Task {
    
    public static void createTask(String name,String jyear,ArrayList<String> section,ArrayList<String> course,ArrayList<String> dept){
        String timestamp=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
           
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase("test"); 
        MongoCollection<Document> mcol=mdb.getCollection("task");
        Document task=new Document().append("name",name)
                .append("jyear",jyear)
                .append("section",section)
                .append("course",course)
                .append("active", "no")
                .append("dept",dept)
                .append("timestamp",timestamp)
                ;
        mcol.insertOne(task);
        ObjectId id=(ObjectId)task.get("_id");
        MongoCollection<Document> subcol=mdb.getCollection("sub");
        
        Document sub=new Document().
                append("id",id.toString())
                ;
        subcol.insertOne(sub);
        mc.close();
    }
    public static void activate(String id){
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase("test"); 
        MongoCollection<Document> mcol=mdb.getCollection("task");
        mcol.updateOne(eq("_id",new ObjectId(id)),combine(set("active","yes")));
        mc.close();
    }
    public static void close(String id){
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase("test"); 
        MongoCollection<Document> mcol=mdb.getCollection("task");
        mcol.updateOne(eq("_id",new ObjectId(id)),combine(set("active","no")));
        mc.close();
    }
    public static void delete(String id){
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase("test"); 
        MongoCollection<Document> mcol=mdb.getCollection("task");
        mcol.deleteOne(eq("_id", new ObjectId(id)));
        MongoCollection<Document> submcol=mdb.getCollection("sub");
        submcol.deleteOne(eq("id", id));
        mc.close();
        //need to delete submitted files.will be done later
    }
    public static void getsub(String id){
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase("test"); 
        MongoCollection<Document> mcol=mdb.getCollection("sub");
        //incomplete
        
    }
    
    public static ArrayList<String> getAllTasks(){
        ArrayList<String> al=new ArrayList<>();
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase("test"); 
        MongoCollection<Document> mcol=mdb.getCollection("task");
        mcol.find().forEach(
           (Block<Document>)doc->{
               al.add(doc.toJson());
            }
        );
        mc.close();
        return al;
    }
    public static String submitTask(String id,String htno,String content){
        String response="";
        try {
            String timestamp=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            String path="/pfiles/"+id+"/"+htno+"/"+timestamp+".txt";
            File f=new File(path);
            f.createNewFile();
            FileOutputStream fos=new FileOutputStream(f);
            fos.write(content.getBytes());
            fos.close();
            response=response+"file written ";
            
            
        } catch (Exception e) {
         response=response+" failure:"+e.getMessage(); 
        }
        return response;
    }
    public static void allot(String id,String htno,String per){
        int i=0;
        MongoClient mc=MongoClients.create();
        MongoDatabase mdb=mc.getDatabase("test"); 
        MongoCollection<Document> mcol=mdb.getCollection("sub");
        mcol.updateOne(
                eq("id",id),
                combine(set(htno,per)));
        
    }
}
