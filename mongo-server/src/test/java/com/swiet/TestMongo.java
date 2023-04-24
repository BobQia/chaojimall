package com.swiet;

/**
 * @author DengQiao
 * @Date 2023/4/23
 */

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.swiet.utils.MongoDBUtil;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMongo {


    @Test
    void createUser() {
        MongoDatabase develope = MongoDBUtil.getDatabase("develope");
        MongoCollection<Document> test1 = develope.getCollection("test1");
        FindIterable<Document> documents = test1.find();
        System.out.println(documents);
    }
}
