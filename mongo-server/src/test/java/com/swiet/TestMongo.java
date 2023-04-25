package com.swiet;

/**
 * @author DengQiao
 * @Date 2023/4/23
 */

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.swiet.utils.MongoDBUtil;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMongo {


    @Test
    void createUser() {
        MongoDatabase develope = MongoDBUtil.getDatabase("develope");
        MongoCollection<Document> test1 = develope.getCollection("test1");
        FindIterable<Document> documents = test1.find();
        System.out.println(documents);
    }
    @Test
    void removeCollection() {
        MongoDatabase develope = MongoDBUtil.getDatabase("develope");
        MongoCollection<Document> test1 = develope.getCollection("test1");
        test1.drop();
    }
    @Test
    void insertManyDocument(){
        MongoCollection collection = MongoDBUtil.getCollection("develope","corpus");
        List<Document> list = new ArrayList<Document>();
        for(int i=0;i<20;i++){
            ArrayList<Document> objects = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                Document document = new Document().append("text", "书写" + j).append("index", "下标" + i);
                objects.add(document);
            }
            Document document = new Document().append("username","liss"+i).append("age",18+i ).append("desc", "prefect"+i)
                    .append("label",objects);
            list.add(document);
        }
        collection.insertMany(list);
    }

    @Test
    void selct(){
        MongoCollection collection = MongoDBUtil.getCollection("develope","corpus");
        Bson and = Filters.and(Filters.eq("username", "liss3"),
                Filters.elemMatch("label", Filters.eq("text", "书写0")));
        Bson update = Updates.set("label.$.index", "搞事情");
        collection.updateOne(and, update);
    }
    @Test
    void selctsize(){
        MongoCollection collection = MongoDBUtil.getCollection("develope","corpus");
        Bson where = Filters.where("this.label.length>1");
        Bson eq = Filters.exists("label");
        Bson and = Filters.and(Arrays.asList(where, eq));
        FindIterable findIterable = collection.find(and);
        MongoCursor iterator = findIterable.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }



}
