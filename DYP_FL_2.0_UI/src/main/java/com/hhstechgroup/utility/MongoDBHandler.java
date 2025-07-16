package com.hhstechgroup.utility;

import com.hhstechgroup.common.Reports;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * MongoDBHandler provides method to connect to mongoDB data base
 */
public class MongoDBHandler {

    public String host = "sit-dyp.hhstechgroup.com:27017";
    private int port = 27017 ;

    /**
     * This constructor method creates an MongoDBHandler object
     */
    public MongoDBHandler() {
        this.host = host;
        this.port = port;
    }

    /**
     * This method returns a list of documents in MongoDB using dataBaseName, collectionName arguments
     * @param dataBaseName
     * @param collectionName
     * @return
     * @throws Exception
     */
    public List<Document> connectToMongoDb(String dataBaseName, String collectionName) throws Exception {
        // code to create the connection
        MongoClient mongoClient = new MongoClient(host, port);
        // code to connect to the database
        //mongoClient.getDatabaseNames().forEach(System.out::println);
        mongoClient.getDatabaseNames();

        DB db = mongoClient.getDB(dataBaseName);
        MongoDatabase database = mongoClient.getDatabase(dataBaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Reports.log("Mongo DB connection established successfully.... ");
        //   Retrieving the documents
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            it.next();
           //System.out.println(it.next());
        }
        MongoCursor<Document> mongoCursor = iterDoc.iterator();
        List<Document> documents = new ArrayList<>();
        while (mongoCursor.hasNext()) {
            documents.add(mongoCursor.next());
        }
        Reports.log("Connected to "+dataBaseName+",  Get the "+collectionName+" list ");
        //System.out.println("The number of documents in exsiting collection is : " + documents.size());
              return documents;
    }
}