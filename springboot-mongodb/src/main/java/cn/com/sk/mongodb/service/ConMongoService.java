package cn.com.sk.mongodb.service;

import com.mongodb.client.*;
import org.bson.Document;

public class ConMongoService {

    public static void main(String[] args) {


        MongoClient mongoClient = MongoClients.create("mongodb://192.168.1.7:27017");
        System.out.println(mongoClient);
        MongoDatabase test_mongodb = mongoClient.getDatabase("test_mongodb");
//        System.out.println(test_mongodb);
//        test_mongodb.createCollection("test_mongodb");
        MongoCollection<Document> test_mongodb1 = test_mongodb.getCollection("test_mongodb");
        System.out.println("获取的结果"+test_mongodb1);
        FindIterable<Document> documents = test_mongodb1.find();
        System.out.println(documents.first().toJson());
    }
}
