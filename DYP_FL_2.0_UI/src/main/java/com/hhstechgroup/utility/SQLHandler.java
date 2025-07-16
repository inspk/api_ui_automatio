package com.hhstechgroup.utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * SQLHandler class provides method to connect to postgresql data base
 */
public class SQLHandler {
    public static Connection connection;
    public static Statement stmt;
    public static ResultSet resultSet;
    /**
     * This method connects to postgresql data base
     * @param driverName
     * @param url
     * @param user
     * @param password
     * @throws Exception
     * @return
     */
    public static Connection connect(String driverName, String url, String user, String password) throws Exception {
        Class.forName(driverName);
        if (user != null && password != null) {
            connection = DriverManager.getConnection(url, user, password);
        } else {
            connection = DriverManager.getConnection(url);
        }
        stmt = connection.createStatement();
        System.out.println("Opened database successfully");
        return connection;
    }

    /**
     * This method returns a list of data from database using  columnName, tableName, databasesName arguments
     * @param columnName
     * @param tableName
     * @param databasesName
     * @return
     */
    public static ArrayList<String> getColumnData(String columnName, String tableName, String[] databasesName) {
        ArrayList<String> out = new ArrayList<>(200);
        for (int i = 0; i < databasesName.length; i++) {
            try {
                com.hhstechgroup.utility.SQLHandler.connect("org.postgresql.Driver", "jdbc:postgresql://IP:port/" + databasesName[i], "username", "password");
                ResultSet rs = com.hhstechgroup.utility.SQLHandler.stmt.executeQuery("SELECT " + columnName + " FROM " + tableName);
                while (rs.next()) {
                    String s = rs.getString(1);
                    if (s != null) {
                        out.add(s.trim());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                com.hhstechgroup.utility.SQLHandler.disconnect();
            }
        }
        return out;
    }

    /**
     * This method returns an array list of data using columnName, tableName, databasesName, secondColumnName, secondData arguments
     * @param columnName
     * @param tableName
     * @param databasesName
     * @param secondColumnName
     * @param secondData
     * @return
     */
    public static ArrayList<String> getMultipleData(String columnName, String tableName, String[] databasesName, String secondColumnName, HashSet<String> secondData) {
        ArrayList<String> out = new ArrayList<>(200);
        for (int i = 0; i < databasesName.length; i++) {
            try {
                com.hhstechgroup.utility.SQLHandler.connect("org.postgresql.Driver", "jdbc:postgresql://IPaddress:port/" + databasesName[i], "username", "password");
                ResultSet rs = com.hhstechgroup.utility.SQLHandler.stmt.executeQuery("SELECT " + columnName + ", " + secondColumnName + " FROM " + tableName);
                while (rs.next()) {
                    String s = rs.getString(1);
                    if (s != null && secondData.contains(rs.getString(2).trim())) {
                        out.add(s.trim());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                com.hhstechgroup.utility.SQLHandler.disconnect();
            }
        }
        return out;
    }
    /**
     * This method returns an arraylist of data from the column using databasesName, query
     * @param databasesName
     * @param query
     * @return
     */
    public static ArrayList<String> getColumnDataFromQuery(String[] databasesName, String query) {
        ArrayList<String> out = new ArrayList<>();
        for (int j = 0; j < databasesName.length; j++) {
            try {
                com.hhstechgroup.utility.SQLHandler.connect("org.postgresql.Driver", "jdbc:postgresql://IP:port/" + databasesName[j], "username", "password");
                ResultSet rs = com.hhstechgroup.utility.SQLHandler.stmt.executeQuery(query);
                while (rs.next()) {
                    String s = rs.getString(1);
                    if (s != null) {
                        out.add(s.trim());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                com.hhstechgroup.utility.SQLHandler.disconnect();
            }
        }
        return out;
    }
    public static ResultSet resultSet(String query) throws SQLException {
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet .next()) {
                System.out.println(resultSet .getString(1) + " |\t " + resultSet .getString(2) +" |\t "+ resultSet .getString(3) +" |\t "+
                        resultSet .getString(4)+" |\t "+ resultSet .getString(5)+" |\t "+ resultSet .getString(6)+" |\t "+ resultSet .getString(7));
        }}catch (SQLException e){
            e.printStackTrace();
        }

        return resultSet;
    }
    /**
     * This method disconnect
     */
    public static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
