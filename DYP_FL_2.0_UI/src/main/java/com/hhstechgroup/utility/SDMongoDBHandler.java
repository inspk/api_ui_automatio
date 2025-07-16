package com.hhstechgroup.utility;

import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.common.Reports;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SDMongoDBHandler {

        public static String host = "mongo-new.sd.hhstechgroup.com";
        private static int port = 30012 ;

    DataFiles data = new DataFiles();


    String filePath = ".\\src\\main\\java\\com\\hhstechgroup\\utility\\dataBaseconfig.properties";
    String userName = data.getData("MongoDB_Username", filePath);
    String password = data.getData("MongoDB_Password", filePath);
    String source = data.getData("MongoDB_Source", filePath);

        /**
         * This constructor method creates an SDMongoDBHandler object
         */
        public SDMongoDBHandler() {
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
         public static MongoCollection<Document> connectToMongoDB_SD(String dataBaseName, String collectionName, String username, String password, String source) throws Exception {


                // Creating Credentials
            MongoCredential credential;
            credential = MongoCredential.createScramSha1Credential(username, source,
                    password.toCharArray());

            //Mongo Client to connect to DB server
            MongoClient mongoClient = new MongoClient(new ServerAddress(host,port), Arrays.asList(credential));

            System.out.println("Connected to the database successfully");

            // Accessing the database
            MongoDatabase database = mongoClient.getDatabase(dataBaseName);

            // Retrieving a collection
            MongoCollection<Document> collection_name = database.getCollection(collectionName);

            //   Retrieving the documents
            FindIterable<Document> iterDoc = collection_name.find();
            Iterator it = iterDoc.iterator();
            while (it.hasNext()) {
                String.valueOf(it.next());
//                Reports.log(String.valueOf(it.next()));
            }
            MongoCursor<Document> mongoCursor = iterDoc.iterator();
            List<Document> documents = new ArrayList<>();
            while (mongoCursor.hasNext()) {
                documents.add(mongoCursor.next());
            }
            Reports.log("Connected to "+dataBaseName+", and Getting the "+collectionName+" list ");
            //System.out.println("The number of documents in existing collection is : " + documents.size());
            return collection_name;
        }

    public void updateCollectionFieldValue(String providerID,String DBName, String collectionName) throws Exception {

        MongoCollection<Document> mc = SDMongoDBHandler.connectToMongoDB_SD(DBName, collectionName, userName, password, source);

        Bson filter = Filters.eq("_id", providerID);
        Bson updates = Updates.set("revalidationStatus", "FIRST_NOTIFICATION");
        mc.findOneAndUpdate(filter, updates);

    }
}
