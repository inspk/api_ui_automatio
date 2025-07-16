package com.hhstechgroup.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * DataFiles class is used to read data from a file. It returns data in byte format like fileInputStream class.
 */
public class DataFiles {
    /**
     * This method Stores data in ProviderData.properties file
     *
     * @param key
     * @param value
     * @param index
     * @param status
     */
    public static void save(String key, String value, String index, String status) {
        try {
            String filename = "ProviderData.properties";
            if (!Files.exists(Paths.get(filename))) {

                Files.createFile(Paths.get(filename));
            }
            Properties properties = new Properties();
            properties.load(new FileInputStream(filename));
            key = String.format("%s.%s.%s", status, key, index);
            properties.put(key, value);
            properties.store(new FileOutputStream(filename), null);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method Stores gets data which stored in ProviderData.properties file
     *
     * @param key
     * @param index
     * @param status
     * @return
     */

    public static String getData(String key, String index, String status) {
        try {
            String filename = "ProviderData.properties";
            if (!Files.exists(Paths.get(filename))) {
                throw new RuntimeException("Data properties file is not found");
            }
            Properties properties = new Properties();
            properties.load(new FileInputStream(filename));
            key = String.format("%s.%s.%s", status, key, index);
            String value = properties.get(key).toString();
            if (value == null) {
                new RuntimeException("Cannot find " + key);
            }
            return value;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This method Stores gets data which stored in ProviderData.properties file
     *
     * @param parameter
     * @param type
     * @param stage
     * @return
     */
    public String getValueFromDataFile(String parameter, String type, String stage) {
        String value = getData(parameter, type, stage);
        return value;
    }

    public static String getData(String key,String filePath) {
        try {
            String filename = filePath;
            if (!Files.exists(Paths.get(filename))) {
                throw new RuntimeException("Data properties file is not found");
            }
            Properties properties = new Properties();
            properties.load(new FileInputStream(filename));
            String value = properties.get(key).toString();
            if (value == null) {
                new RuntimeException("Cannot find " + key);
            }
            return value;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
