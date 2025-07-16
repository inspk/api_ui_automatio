package com.dyp.base;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoDBUtils {

    private static final String CONNECTION_STRING = "mongodb://root:HhsM0ng02430@ab8893a8ebe7941dd9a3f88d85a274eb-524665045.us-east-2.elb.amazonaws.com:30001/admin?retryWrites=true&loadBalanced=false&serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=admin&authMechanism=SCRAM-SHA-1";
    private static final String DB_NAME = "providermgmt";
    private static final String COLLECTION_NAME = "programParticipationInfo";

    public static String getObjectIdByRuntimeId(String runtimeId) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DB_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            Document query = new Document("runtimeId", runtimeId);
            Document projection = new Document("_id", 1);
            Document result = collection.find(query).projection(projection).first();

            if (result != null && result.getObjectId("_id") != null) {
                ObjectId objectId = result.getObjectId("_id");
                return objectId.toHexString();
            } else {
                System.out.println("No document found for runtimeId: " + runtimeId);
                return null;
            }
        }
    }
}
