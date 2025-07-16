package com.hhstechgroup.utility;

import com.hhstechgroup.common.Reports;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProviderInformation provides methods to create, modify, read and write data into excel.
 */
public class ProviderInformation {

    static String environment;
    static String applicationType;
    static String firstName = null;
    static String lastName = null ;
    static String provideEmailID =null;
    static String taxonomy =null;
    static String npi =null;
    static String trackingNum = null;
    static String emailId = null;
    static String Status = null;

    /**
     * This method returns an array of firstName, lastName, trackingNum from excel file using FilePath, enrollmentType, status
     * @param FilePath
     * @param enrollmentType
     * @param status
     * @return
     * @throws IOException
     */
    public static List<Object> getFNameAndLastName(String FilePath, String enrollmentType, String status) throws IOException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(FilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow row = worksheet.getRow(0);
        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum = row.getLastCellNum();

        Object Data[][] = new Object[rowNum - 1][colNum];
        for (int i = 0; i < rowNum - 1; i++) {
            XSSFRow Row = worksheet.getRow(i + 1);
            for (int j = 0; j < colNum; j++) {
                if (Row == null)
                    Data[i][j] = "";
                else {
                    XSSFCell cell = Row.getCell(j);
                    if (cell == null) {
                        Data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value; } }
            }
            if((String.valueOf(Data[i][1]).equalsIgnoreCase(enrollmentType))
                    &&(String.valueOf(Data[i][8]).equalsIgnoreCase(status))) {
                environment = String.valueOf(Data[i][0]);
                firstName = String.valueOf(Data[i][2]);
                lastName = String.valueOf(Data[i][3]);
                String Status = String.valueOf(Data[i][8]);
                trackingNum = String.valueOf(Data[i][9]);
                System.out.println(Arrays.asList(environment,firstName, lastName, Status,trackingNum));
            } else if(i>=rowNum){
                System.out.println("No matching data found for " +enrollmentType+ " with Status " + status);
            }
        }
        return Arrays.asList(environment,firstName, lastName, trackingNum);
    }

    /**
     * This method returns a array of firstName, lastName, provideEmailID, trackingNum from excel file, using FilePath, enrollmentType, status
     * @param FilePath
     * @param enrollmentType
     * @param status
     * @return
     * @throws IOException
     */
    public static List<Object> getProviderNameEMail(String FilePath, String enrollmentType, String status) throws IOException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(FilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow row = worksheet.getRow(0);
        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum = row.getLastCellNum();

        Object Data[][] = new Object[rowNum - 1][colNum];
        String trackingNum = null;
        for (int i = 0; i < rowNum - 1; i++) {
            XSSFRow Row = worksheet.getRow(i + 1);
            for (int j = 0; j < colNum; j++) {
                if (Row == null)
                    Data[i][j] = "";
                else {
                    XSSFCell cell = Row.getCell(j);
                    if (cell == null) {
                        Data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value;
                    } } }
            if ((String.valueOf(Data[i][1]).equalsIgnoreCase(enrollmentType)) && (String.valueOf(Data[i][8]).equalsIgnoreCase(status))) {
                environment = String.valueOf(Data[i][0]);
                firstName = String.valueOf(Data[i][2]);
                lastName = String.valueOf(Data[i][3]);
                provideEmailID = String.valueOf(Data[i][4]);
                String Status = String.valueOf(Data[i][8]);
                trackingNum = String.valueOf(Data[i][9]);
                System.out.println(Arrays.asList(firstName, lastName, provideEmailID, Status, trackingNum));
            }
            else if(i>=rowNum){
                System.out.println("No matching data found for " +enrollmentType+ " with Status " + status);
            }
        }
        return Arrays.asList(environment,firstName, lastName, provideEmailID, trackingNum);
    }


    /**
     * This method returns an array of name, email, taxonomy, npi from excel file using FilePath, enrollmentType, status arguments
     * @param FilePath
     * @param enrollmentType
     * @param status
     * @return
     * @throws IOException
     */
    public static List<Object> getProviderNameEmailTaxonomyNPI(String FilePath, String enrollmentType, String status) throws IOException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(FilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow row = worksheet.getRow(0);
        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum = row.getLastCellNum();

        Object Data[][] = new Object[rowNum - 1][colNum];
        for (int i = 0; i < rowNum - 1; i++) {
            XSSFRow Row = worksheet.getRow(i + 1);
            for (int j = 0; j < colNum; j++) {
                if (Row == null)
                    Data[i][j] = "";
                else {
                    XSSFCell cell = Row.getCell(j);
                    if (cell == null) {
                        Data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value;
                    }
                }
            }
            if(String.valueOf(Data[i][1]).equalsIgnoreCase(enrollmentType) && String.valueOf(Data[i][8]).equalsIgnoreCase(status))
            {
                environment = String.valueOf(Data[i][0]);
                firstName = String.valueOf(Data[i][2]);
                lastName = String.valueOf(Data[i][3]);
                provideEmailID = String.valueOf(Data[i][4]);
                taxonomy = String.valueOf(Data[i][6]);
                npi = String.valueOf(Data[i][7]);
                String Status = String.valueOf(Data[i][8]);
                trackingNum = String.valueOf(Data[i][9]);
                System.out.println(Arrays.asList(environment,firstName, lastName, provideEmailID, taxonomy, npi, Status, trackingNum));
            }
            else if(i>=rowNum){
                System.out.println("No matching data found for " +enrollmentType+ " with Status " + status);
            }
        }
        return Arrays.asList(environment,firstName, lastName, provideEmailID, taxonomy, npi,trackingNum);
    }

    /**
     * This method updates provider data in the excel file using filePath, enrollmentType, firstName, lastName, status arguments
     * @param filePath
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param status
     * @throws IOException
     */
    public static void updateProviderData(String filePath, String enrollmentType, String firstName, String lastName, String status) throws IOException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow row = worksheet.getRow(0);
        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum = row.getLastCellNum();

        Object Data[][] = new Object[rowNum - 1][colNum];
        Cell cell2Update = null;
        for (int i = 0; i < rowNum - 1; i++) {
            XSSFRow Row = worksheet.getRow(i + 1);
            for (int j = 0; j < colNum; j++) {
                if (Row == null)
                    Data[i][j] = "";
                else {
                    XSSFCell cell = Row.getCell(j);
                    if (cell == null) {
                        Data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value;
                    }
                }
            }
            if ((String.valueOf(Data[i][1]).equalsIgnoreCase(enrollmentType))
                    && (String.valueOf(Data[i][2]).equalsIgnoreCase(firstName))
                    && (String.valueOf(Data[i][3]).equalsIgnoreCase(lastName))) {
                cell2Update = worksheet.getRow(i + 1).getCell(8);
                cell2Update.setCellValue(status);
                //  Reports.log("Application status updated to: "+ cell2Update + ", into the Excel sheet");
//                Reports.log("Excel sheet updated successfully....");
//                Reports.log(" Application status of " + firstName + " " + lastName +
//                        "has been updated to: " + cell2Update);
            }
        }
        Reports.log("\nExcel sheet updated successfully....");
        Reports.log("Application status of " + firstName + " " + lastName +
                " has been updated to: " + cell2Update);
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.flush();
    }

    /**
     * This method updates provider data in the excel file using filePath, enrollmentType, firstName, lastName, status
     * and trackingNum arguments
     * @param filePath
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param status
     * @param trackingNum
     * @throws IOException
     */
    public static void updateProviderData(String filePath, String enrollmentType, String firstName, String lastName, String status, String trackingNum) throws IOException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow row = worksheet.getRow(0);
        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum = row.getLastCellNum();

        Object Data[][] = new Object[rowNum - 1][colNum];
        for (int i = 0; i < rowNum - 1; i++) {
            XSSFRow Row = worksheet.getRow(i + 1);
            for (int j = 0; j < colNum; j++) {
                if (Row == null)
                    Data[i][j] = "";
                else {
                    XSSFCell cell = Row.getCell(j);
                    if (cell == null) {
                        Data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value;
                    }
                }
            }
            if((String.valueOf(Data[i][1]).equalsIgnoreCase(enrollmentType))
                    &&(String.valueOf(Data[i][2]).equalsIgnoreCase(firstName))
                    &&(String.valueOf(Data[i][3]).equalsIgnoreCase(lastName))
                    &&(String.valueOf(Data[i][9]).equalsIgnoreCase(trackingNum)))
            {
                Cell cell2Update = worksheet.getRow(i+1).getCell(8);
                cell2Update.setCellValue(status);
                //  Reports.log("Application status updated to: "+ cell2Update + ", into the Excel sheet");
                Reports.log("Excel sheet updated successfully....");
                Reports.log("Application status of "+firstName+" "+lastName+" "+trackingNum+
                        " has been updated to: "+ cell2Update);
            }
        }
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.flush();
    }

    /**
     * This method returns a array of firstName, lastName, provideEmailID, trackingNum from excel file, using FilePath, enrollmentType, status
     * @param FilePath
     * @param status
     * @return
     * @throws IOException
     */
    public static List<Object> getProvider(String FilePath, String status) throws IOException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(FilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow row = worksheet.getRow(0);
        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum = row.getLastCellNum();

        Object Data[][] = new Object[rowNum - 1][colNum];
        String trackingNum = null;
        for (int i = 0; i < rowNum - 1; i++) {
            XSSFRow Row = worksheet.getRow(i + 1);
            for (int j = 0; j < colNum; j++) {
                if (Row == null)
                    Data[i][j] = "";
                else {
                    XSSFCell cell = Row.getCell(j);
                    if (cell == null) {
                        Data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value;
                    } } }

            if (String.valueOf(Data[i][8]).equalsIgnoreCase(status)) {
                environment = String.valueOf(Data[i][0]);
                applicationType = String.valueOf(Data[i][01]);
                firstName = String.valueOf(Data[i][2]);
                lastName = String.valueOf(Data[i][3]);
                provideEmailID = String.valueOf(Data[i][4]);
                String Status = String.valueOf(Data[i][8]);
                trackingNum = String.valueOf(Data[i][9]);
                System.out.println(Arrays.asList(environment,applicationType,firstName, lastName, provideEmailID, Status));
            }
            else if(i>=rowNum){
                System.out.println("No matching data found for with Status " + status);
            }
        }
        return Arrays.asList(applicationType,firstName, lastName, provideEmailID, trackingNum );
    }


    /**
     * This method returns a string trackingNum from excel file using FilePath, enrollmentType, status
     * @param FilePath
     * @param enrollmentType
     * @param status
     * @return
     * @throws IOException
     */
    public static String getTrackingNumber(String FilePath, String enrollmentType, String status) throws IOException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(FilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow row = worksheet.getRow(0);
        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum = row.getLastCellNum();

        Object Data[][] = new Object[rowNum - 1][colNum];
        for (int i = 0; i < rowNum - 1; i++) {
            XSSFRow Row = worksheet.getRow(i + 1);
            for (int j = 0; j < colNum; j++) {
                if (Row == null)
                    Data[i][j] = "";
                else {
                    XSSFCell cell = Row.getCell(j);
                    if (cell == null) {
                        Data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value; } }
            }
            if((String.valueOf(Data[i][1]).equalsIgnoreCase(enrollmentType))
                    &&(String.valueOf(Data[i][8]).equalsIgnoreCase(status))) {
                environment = String.valueOf(Data[i][0]);
                firstName = String.valueOf(Data[i][2]);
                lastName = String.valueOf(Data[i][3]);
                String Status = String.valueOf(Data[i][8]);
                trackingNum = String.valueOf(Data[i][9]);
//                System.out.println(Arrays.asList(environment,firstName, lastName, Status,trackingNum));
            } else if(i>=rowNum){
                System.out.println("No matching data found for " +enrollmentType+ " with Status " + status);
            }
        }
        System.out.println("Tracking/Request Number of "+firstName+ " " +lastName+" is "+trackingNum);
        return trackingNum ;
    }
    /**
     * This method returns a string trackingNum from excel file using FilePath, enrollmentType, status
     * @param FilePath
     * @param enrollmentType
     * @param status
     * @return
     * @throws IOException
     */

    public static List<Object> getProviderNameEMailType(String FilePath, String enrollmentType, String status) throws IOException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(FilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow row = worksheet.getRow(0);
        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum = row.getLastCellNum();

        Object Data[][] = new Object[rowNum - 1][colNum];
        String trackingNum = null;
        for (int i = 0; i < rowNum - 1; i++) {
            XSSFRow Row = worksheet.getRow(i + 1);
            for (int j = 0; j < colNum; j++) {
                if (Row == null)
                    Data[i][j] = "";
                else {
                    XSSFCell cell = Row.getCell(j);
                    if (cell == null) {
                        Data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value;
                    }
                }
            }
            if ((String.valueOf(Data[i][1]).equalsIgnoreCase(enrollmentType)) && (String.valueOf(Data[i][8]).equalsIgnoreCase(status))) {
                environment = String.valueOf(Data[i][0]);
                applicationType = String.valueOf(Data[i][1]);
                firstName = String.valueOf(Data[i][2]);
                lastName = String.valueOf(Data[i][3]);
                provideEmailID = String.valueOf(Data[i][4]);
                Status = String.valueOf(Data[i][8]);
                trackingNum = String.valueOf(Data[i][9]);
//                System.out.println(Arrays.asList(environment, applicationType, firstName, lastName, provideEmailID, Status, trackingNum));
            } else if (i >= rowNum-2) {
                System.out.println("No matching data found for " + enrollmentType + " with Status " + status);
            }
        }

        System.out.println(Arrays.asList(environment, applicationType, firstName, lastName, provideEmailID, Status, trackingNum));
        return Arrays.asList(environment, applicationType, firstName, lastName, provideEmailID, trackingNum);
    }


    /**
     * This method returns an array of name, email, taxonomy, npi from excel file using FilePath, enrollmentType, status arguments
     * @param FilePath
     * @param enrollmentType
     * @param status
     * @return
     * @throws IOException
     */
    public static Map<String, String> getProviderIdAndNPI(String FilePath, String enrollmentType, String status) throws IOException {
        DataFormatter formatter = new DataFormatter();
        Map<String, String> map = new HashMap<String, String>();
        FileInputStream fis = new FileInputStream(FilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow row = worksheet.getRow(0);
        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum = row.getLastCellNum();

        Object Data[][] = new Object[rowNum - 1][colNum];
        for (int i = 0; i < rowNum - 1; i++) {
            XSSFRow Row = worksheet.getRow(i + 1);
            for (int j = 0; j < colNum; j++) {
                if (Row == null)
                    Data[i][j] = "";
                else {
                    XSSFCell cell = Row.getCell(j);
                    if (cell == null) {
                        Data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value;
                    }
                }
            }
            if(String.valueOf(Data[i][1]).equalsIgnoreCase(enrollmentType) && String.valueOf(Data[i][8]).equalsIgnoreCase(status))
            {
                firstName = String.valueOf(Data[i][2]);
                lastName = String.valueOf(Data[i][3]);
                provideEmailID = String.valueOf(Data[i][4]);
                npi = String.valueOf(Data[i][7]);

                map.put("FirstName", firstName);
                map.put("LastName", lastName);
                map.put("ProviderEmailId", provideEmailID);
                map.put("ProviderNPI",npi) ;

//                System.out.println(map);
            }
            else if(i>=rowNum){
                System.out.println("No matching data found for " +enrollmentType+ " with Status " + status);
            }
        }
        return map;

//        return Arrays.asList(firstName, lastName, provideEmailID, npi);
    }


}
