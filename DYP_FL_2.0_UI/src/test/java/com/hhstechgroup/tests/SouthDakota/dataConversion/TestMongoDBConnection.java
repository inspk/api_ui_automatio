package com.hhstechgroup.tests.SouthDakota.dataConversion;


//import com.hhstechgroup.common.Data;
//import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.MongoDBHandler;
import com.hhstechgroup.utility.SDMongoDBHandler;
import org.bson.Document;
import org.testng.annotations.Test;

import java.util.List;
//import com.hhstechgroup.utility.ExcelWrite;
//import com.hhstechgroup.utility.MongoDBHandler;
//import com.hhstechgroup.utility.SDMongoDBHandler;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoCredential;
//import com.mongodb.ServerAddress;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//import org.testng.annotations.Test;
//
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;

public class TestMongoDBConnection extends BaseClassUI {
    MongoDBHandler mongoDBHandler = new MongoDBHandler();
    ExcelWrite excel = new ExcelWrite(taxonomiesListSheet, 0);
    DataFiles data = new DataFiles();

    @Test
    public void verifyProvidersData() throws Exception {
        String filePath = ".\\src\\main\\java\\com\\hhstechgroup\\utility\\dataBaseconfig.properties";
        String dbName = data.getData("MongoDB_Database_Name", filePath);
        String collection = data.getData("Collection", filePath);
        String userName = data.getData("MongoDB_Username", filePath);
        String password = data.getData("MongoDB_Password", filePath);
        String source = data.getData("MongoDB_Source", filePath);

        Reports.log("This test is to verify the provider data");
        List<Document> documents= (List<Document>) SDMongoDBHandler.connectToMongoDB_SD(dbName, collection, userName, password, source);//        excel.importMongodbToExcelSheet(documents);
//        excel.importMongodbToExcelSheet(documents);
//        excel.verifyAndCompareDataValueBtwnTwoSheet(taxonomiesListSheet);

    }
}

