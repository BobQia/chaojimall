package com.swiet.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {

    private static MongoClient client = null;

    static {
        if(client==null){
            client = new MongoClient("192.168.64.4", 27017);
        }
    }

    //获取MongoDB数据库
    public static MongoDatabase getDatabase(String databaseName){
        return client.getDatabase(databaseName);
    }

    //获取Mongo集合
    public static MongoCollection getCollection(String databaseName, String collectionName){
        return getDatabase(databaseName).getCollection(collectionName);
    }
}
