package com.hhstechgroup.utility;

import java.io.*;
import java.util.*;

import com.hhstechgroup.utility.CsvFileReading;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * CsvFileReading class provides methods to create, modify, read and write data into excel.
 */
public class CsvFileReading {
    public String filePath;

    /**
     * This constructor method creates an CsvFileReading object using filePath
     *
     * @param filePath
     */
    public CsvFileReading(String filePath) {
        this.filePath = filePath;
    }


    /**
     * This method gets csv as array list using the environment
     *
     * @param env
     * @return
     * @throws IOException
     */
    public List<String> getCsvAsArray(String env) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        List<String> row = null;
        while ((line = br.readLine()) != null) {
            String[] elements = line.split(",");
            if (elements.length > 0 && elements[0].equalsIgnoreCase(env)) {
                row = new ArrayList<>();
                for (String element : elements) {
                    row.add(element.trim());
                }
            }
        }
        return row;
    }

    /**
     * This method gets csv as array list by passing 2 parameter enrollmentType and status
     *
     * @param enrollmentType
     * @param status
     * @return
     * @throws IOException
     */

    public List<String> getCsvAsArray(String enrollmentType, String status) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        List<String> row = null;
        while ((line = br.readLine()) != null) {
            String[] elements = line.split(",");
            if (elements.length > 0 && elements[1].equalsIgnoreCase(enrollmentType) && elements[1].equalsIgnoreCase(status)) {
                row = new ArrayList<>();
                for (String element : elements) {
                    row.add(element.trim());
                }
            }
        }
        return row;
    }

    /**
     * This method write data into csv file
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param firstname
     * @param lastname
     * @param email
     * @param password
     * @param taxonomy
     * @param npi
     * @param applicationStatus
     * @param trackingNumber
     * @throws IOException
     */
    public void writeToCsv(String testEnvironment, String enrollmentType, String firstname, String lastname, String email, String password,
                           String taxonomy, String npi, String applicationStatus, String trackingNumber) throws IOException {

        FileWriter csvFile = new FileWriter("ProviderInfo.csv", true);
        String[] Title =
                {testEnvironment, enrollmentType, firstname, lastname, email, password, taxonomy, npi, applicationStatus, trackingNumber};
        for (String data : Title) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < Title.length; i++) {
                line.append(data);
                if (i != Title.length - 1) {
                    line.append(',');
                    break;
                }
            }
            csvFile.write(line.toString());
        }
        csvFile.close();
    }

    public void readFromCsv() {

        CSVReader reader = null;
        try {
            //parsing a CSV file into CSVReader class constructor
            reader = new CSVReader(new FileReader("ProviderInfo.csv"));
            String[] nextLine;
            //reads one line at a time
            while ((nextLine = reader.readNext()) != null) {
                for (String token : nextLine) {
                    System.out.print(token);
                }
                System.out.print("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns a string trackingNum from csv file using FilePath, enrollmentType, status
     * @param FilePath
     * @param enrollmentType
     * @param status
     * @return
     * @throws IOException
     */
    public static String getTrackingNumberFromCsvFile(String FilePath, String enrollmentType, String status) throws IOException {

        CsvFileReading csvFileReading = new CsvFileReading(FilePath);
        List<String> row = csvFileReading.getCsvAsArray(enrollmentType, status);
        String TrackingID = null;
        for (int i = 0; i < row.size(); i++) {
            if (i == 9) {
                TrackingID = row.get(i);
                System.out.println("Tracking ID is  : " + TrackingID);
            }
        }
        return TrackingID;
    }
// TBD
    /**
     * This method update csv file
     * @param fileToUpdate
     * @throws IOException
     */

    public static void updateCSV(String fileToUpdate) throws IOException {
        File inputFile = new File(fileToUpdate);

        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
        List<String[]> csvBody = reader.readAll();
        // get CSV row column and replace with by using row and column
        for (int i = 0; i < csvBody.size(); i++) {
            String[] strArray = csvBody.get(i);
            for (int j = 0; j < strArray.length; j++) {
                if (strArray[j].equalsIgnoreCase("Update")) { //String to be replaced
                    csvBody.get(i)[j] = "Updated"; //Target replacement
                }
            }
        }
        reader.close();

        // Write to CSV file which is open
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
    }
}









