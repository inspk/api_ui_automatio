package com.hhstechgroup.tests.SouthDakota.dataConversion;

import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.DbExcelExporter;
import com.hhstechgroup.utility.SQLHandler;
import org.testng.annotations.Test;

import java.io.File;

public class PostgresConnection extends BaseClassUI {

    @Test
    public void verifyConnectionToPostgresDBAndRetrieveData() throws Exception {
        SQLHandler sql = new SQLHandler();
        DataFiles data = new DataFiles();
        DbExcelExporter sq = new DbExcelExporter();

        String path = System.getProperty("user.home") + File.separator + "Documents";
        path += File.separator + "dataBaseconfig.properties";
        String Host = data.getData("Host", path);
        String port = data.getData("Port", path);
        String DB_Name = data.getData("Postgres-Database_Name", path);
        String User=data.getData("Postgres_Username", path);
        String Pass= data.getData("Postgres_Password",path);
        String Driver = data.getData("Postgres_Driver", path);
        String URL= "jdbc:postgresql://"+ Host+ ":" +port+"/"+DB_Name;

        Reports.log(URL);
        sq.export(Driver, URL, User, Pass,"Provider_info");
        System.out.println("Data retrieved from DB and has written successfully to excel");
        sql.disconnect();

    }
}