package com.hhstechgroup.utility;

import com.hhstechgroup.common.Reports;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * ExcelWrite class provides methods to create, modify, read and write data into excel.
 */
public class ExcelWrite {
    public String filePath;// = "ProviderInfo.xlsx";
    private int sheetIndex;
    XSSFWorkbook workbook;
    SoftAssert soft=new SoftAssert();
    /**
     * This constructor method creates an ExcelWrite object using filePath and sheetIndex
     * @param filePath
     * @param sheetIndex
     */
    public ExcelWrite(String filePath, int sheetIndex) {
        this.filePath = filePath;
        this.sheetIndex = sheetIndex;
    }
    /**
     * This method gets sheet from an excel file
     * @return
     * @throws IOException
     */
    private XSSFSheet getSheet() throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        return sheet;
    }
//    /**
//     * This method writes into excel using enrollmentType, firstname, lastname, email, password,
//     * taxonomy, NPI, applicationStatus, trackingNumber arguments
//     * @param enrollmentType
//     * @param firstname
//     * @param lastname
//     * @param email
//     * @param password
//     * @param taxonomy
//     * @param NPI
//     * @param applicationStatus
//     * @param trackingNumber
//     * @throws Exception
//     */
//    public void writeTest(String enrollmentType,String firstname, String lastname, String email, String password,
//                          String taxonomy, String NPI, String applicationStatus, String trackingNumber) throws Exception {
//        XSSFSheet sheet = getSheet();
//        int lastRow = sheet.getLastRowNum()+1;
//       // Reports.log("Lastrow count : "+lastRow);
//        Row row = sheet.createRow(lastRow);
//        row.createCell(0).setCellValue(enrollmentType);
//        row.createCell(1).setCellValue(firstname);
//        row.createCell(2).setCellValue(lastname);
//        row.createCell(3).setCellValue(email);
//        row.createCell(4).setCellValue(password);
//        row.createCell(5).setCellValue(taxonomy);
//        row.createCell(6).setCellValue(NPI);
//        row.createCell(7).setCellValue(applicationStatus);
//        row.createCell(8).setCellValue(trackingNumber);
//        FileOutputStream fos = new FileOutputStream(filePath);
//        this.workbook = workbook;
//        workbook.write(fos);
//        workbook.close();
//    }


    /**
     * This method writes into excel using enrollmentType, firstname, lastname, email, password,
     * taxonomy, NPI, applicationStatus, trackingNumber arguments
     * @param enrollmentType
     * @param firstname
     * @param lastname
     * @param email
     * @param password
     * @param taxonomy
     * @param npi
     * @param applicationStatus
     * @param trackingNumber
     * @throws Exception
     */
    public void writeTestData(String testEnvironment,String enrollmentType,String firstname, String lastname, String email, String password,
                          String taxonomy, String npi, String applicationStatus, String trackingNumber) throws Exception {
        XSSFSheet sheet = getSheet();
        int lastRow = sheet.getLastRowNum()+1;
        // Reports.log("Lastrow count : "+lastRow);
        Row row = sheet.createRow(lastRow);
        row.createCell(0).setCellValue(testEnvironment);
        row.createCell(1).setCellValue(enrollmentType);
        row.createCell(2).setCellValue(firstname);
        row.createCell(3).setCellValue(lastname);
        row.createCell(4).setCellValue(email);
        row.createCell(5).setCellValue(password);
        row.createCell(6).setCellValue(taxonomy);
        row.createCell(7).setCellValue(npi);
        row.createCell(8).setCellValue(applicationStatus);
        row.createCell(9).setCellValue(trackingNumber);
        FileOutputStream fos = new FileOutputStream(filePath);
        this.workbook = workbook;
        workbook.write(fos);
        workbook.close();
    }
    /**
     * This method writes into excel using BaseProviderID,LocationProviderID,Status
     * @param BaseProviderID
     * @param LocationProviderID
     * @param  Status
     */
    public void writeData(String BaseProviderID,String LocationProviderID,String Status) throws IOException {
        XSSFSheet sheet = getSheet();
        int lastRow = sheet.getLastRowNum()+1;
        Row row = sheet.createRow(lastRow);
        row.createCell(0).setCellValue(BaseProviderID);
        row.createCell(1).setCellValue(LocationProviderID);
        row.createCell(2).setCellValue(Status);
        FileOutputStream fos = new FileOutputStream(filePath);
        this.workbook = workbook;
        workbook.write(fos);
        workbook.close();
    }


    /**
     * This method reads from Excel file
     * @throws IOException
     */
    public void readExcel() throws IOException {
        XSSFSheet sheet = getSheet();
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        break;
                }
            }
            System.out.println("");
        }
    }
    /**
     * This method imports mongo data base data To Excel Sheet
     * @param documents
     * @throws IOException
     */
    public void importMongodbToExcelSheet(List<Document> documents) throws IOException {
        // Header
        List<String> headerList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : documents.get(0).entrySet()) {
            headerList.add(entry.getKey());
        }
        //  System.out.println("The number of header list in a document is :  " + headerList.size());

        XSSFSheet sheet = getSheet();
        XSSFRow rowHead = sheet.createRow(0);
        for (int i = 1; i < headerList.size(); i++) {
            //   for (int i = 1; i <= 10 ; i++) {
            // XSSFCell cell0 = rowHead.createCell(i-1);
            // Reports.log("Header list Value :"+headerList.get(i));
            if(headerList.get(i).contains("taxonomyId")){  XSSFCell cell0 = rowHead.createCell(i-1);cell0.setCellValue("Taxonomy Id");}
            if(headerList.get(i).contains("taxonomyDescription")){ XSSFCell cell0 = rowHead.createCell(i-1);cell0.setCellValue("Taxonomy Description");}
            if(headerList.get(i).contains("speciality")){XSSFCell cell0 = rowHead.createCell(i-1);cell0.setCellValue("Speciality");}
            if(headerList.get(i).contains("claimType")){XSSFCell cell0 = rowHead.createCell(i-1);cell0.setCellValue("Claim Type");}
            if(headerList.get(i).contains("riskLevel")){XSSFCell cell0 = rowHead.createCell(i-1);cell0.setCellValue("Risk Level");}
            if(headerList.get(i).contains("documentUploadMandatory")){XSSFCell cell0 = rowHead.createCell(i-1);cell0.setCellValue("Document Upload Mandatory");}
            if(headerList.get(i).contains("providerType")){XSSFCell cell0 = rowHead.createCell(i-1);cell0.setCellValue("Provider Type");}
            if(headerList.get(i).contains("fingerprintRequired")){XSSFCell cell0 = rowHead.createCell(i-1);cell0.setCellValue("Fingerprint Required");}
            if(headerList.get(i).contains("enrollment")){XSSFCell cell0 = rowHead.createCell(i-1);cell0.setCellValue("Enrollment");}
            if(headerList.get(i).contains("requireFees")){XSSFCell cell0 = rowHead.createCell(i-1);cell0.setCellValue("Require Fees");}
            //  cell0.setCellValue(headerList.get(i));
        }
        // Excel data
        Reports.log("______________Taxonomy list from Mongo DB :____________________________");
        for (int i = 0; i < documents.size();i++ ) {
            XSSFRow rows = sheet.createRow(i + 1);
            int colNum = 0;
            for (Map.Entry<String, Object> entry1 : documents.get(i).entrySet()) {
                Reports.log(entry1.getKey() + " :  " +  entry1.getValue());
                if(entry1.getKey().contains("taxonomyId")||entry1.getKey().contains("taxonomyDescription")||
                        entry1.getKey().contains("speciality")||entry1.getKey().contains("claimType")||
                        entry1.getKey().contains("riskLevel")||entry1.getKey().contains("documentUploadMandatory")||
                        entry1.getKey().contains("providerType")||entry1.getKey().contains("fingerprintRequired")||
                        entry1.getKey().contains("enrollment")||entry1.getKey().contains("requireFees")){

                    Cell cell = rows.createCell(colNum, CellType.STRING);
                    cell.setCellValue(String.valueOf(entry1.getValue()));
                    colNum++;
                }
            }
            Reports.log("_______________________________________________________________________________________");
            Reports.log("All the Taxonomy details has been export to an Excel sheet successfully");
        }
        // output file
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.flush();
        System.out.println("Export success");
    }
    /**
     * This method verifies and compare data value between two sheet in an excel file using sheetName
     * @param sheetName
     * @throws IOException
     */
    public void verifyAndCompareDataValueBtwnTwoSheet(String sheetName) throws IOException {
        FileInputStream file1 = new FileInputStream(sheetName);
        Workbook workbook1= new XSSFWorkbook(file1);

        System.out.println("Verifying if both work books have same data.............");

        //iterate through sheet by sheet
        Sheet s1 = workbook1.getSheetAt(0);
        Sheet s2 = workbook1.getSheetAt(1);
        // Iterating through each row
        int rowCounts = s1.getPhysicalNumberOfRows();
        for (int j = 0; j < rowCounts; j++) {
            // Iterating through each cell
            int cellCounts = s1.getRow(j).getPhysicalNumberOfCells();
            for (int k = 0; k < cellCounts; k++) {
                // Getting individual cell
                Cell c1 = s1.getRow(j).getCell(k);
                Cell c2 = s2.getRow(j).getCell(k);
                // Since cell have types and need o use different methods
                if (c1.getCellType().equals(c2.getCellType())) {
                    if (c1.getCellType() == CellType.STRING) {
                        String v1 = c1.getStringCellValue();
                        String v2 = c2.getStringCellValue();

                        soft.assertEquals(v1, v2, "Cell values are different.....");
                        System.out.println("Its matched : "+ v1 + " === "+ v2);
                    }
                    if (c1.getCellType() == CellType.NUMERIC) {
                        // If cell type is numeric, we need to check if data is of Date type
                        if (DateUtil.isCellDateFormatted(c1) | DateUtil.isCellDateFormatted(c2)) {
                            // Need to use DataFormatter to get data in given style otherwise it will come as time stamp
                            DataFormatter df = new DataFormatter();
                            String v1 = df.formatCellValue(c1);
                            String v2 = df.formatCellValue(c2);

                            soft.assertEquals(v1, v2, "Cell values are different.....");
                            System.out.println("Its matched : "+ v1 + " === "+ v2);
                        } else {
                            double v1 = c1.getNumericCellValue();
                            double v2 = c2.getNumericCellValue();

                            soft.assertEquals(v1, v2, "Cell values are different.....");
                            System.out.println("Its matched : "+ v1 + " === "+ v2);
                        }
                    }
                    if (c1.getCellType() == CellType.BOOLEAN) {
                        boolean v1 = c1.getBooleanCellValue();
                        boolean v2 = c2.getBooleanCellValue();

                        soft.assertEquals(v1, v2, "Cell values are different.....");
                        System.out.println("Its matched : "+ v1 + " === "+ v2);
                    }

                } else
                {
                    // If cell types are not same, exit comparison
                    Assert.fail("Non matching cell type.");

                }

            }
        }

        System.out.println("Both sheets in work book have same data.");
        soft.assertAll();
    }
    /**
     * This method verifies sheets in excel file to check if they have same rows and columns
     * @param workbook1
     */
    // This method compares if both excel files have same number of rows and corresponding columns
    public void verifySheetsInExcelFilesHaveSameRowsAndColumns(Workbook workbook1) {
        System.out.println(
                "Verifying if both sheets in work book have same number of rows and columns in all sheets.............");
        int sheetCounts = workbook1.getNumberOfSheets();
        Sheet s1 = workbook1.getSheetAt(0);
        Sheet s2 = workbook1.getSheetAt(1);
        int rowsInSheet1 = s1.getPhysicalNumberOfRows();
        int rowsInSheet2 = s2.getPhysicalNumberOfRows();
        Assert.assertEquals(rowsInSheet1, rowsInSheet2, "Sheets have different count of rows..");
        Iterator<Row> rowInSheet1 = s1.rowIterator();
        Iterator<Row> rowInSheet2 = s2.rowIterator();
        while (rowInSheet1.hasNext()) {
            int cellCounts1 = rowInSheet1.next().getPhysicalNumberOfCells();
            int cellCounts2 = rowInSheet2.next().getPhysicalNumberOfCells();
            Assert.assertEquals(cellCounts1, cellCounts2, "Sheets have different count of columns..");
        }
    }

    /**
     * This method verifies two difference Excel Spreadsshets, and verifies the data in each column and rows.
     * @param expectedExcelFile
     * @param expectedSheetName
     * @param actualExcelFile
     * @param actualSheetName
     */
     
    // public void verifyTwoDifferentExcelSpreadsheets(String expectedExcelFile, String expectedSheetName, String actualExcelFile, String actualSheetName) throws Exception {
    //     Reports.log("       Adding the "+expectedExcelFile+" Spreadsheet to the comparison");
    //     FileInputStream fileInputStream1 = new FileInputStream(expectedExcelFile);
    //     XSSFWorkbook workbook1 = new XSSFWorkbook(fileInputStream1);
    //     XSSFSheet worksheet1 = workbook1.getSheet(expectedSheetName);
    //     int rowCount1 = worksheet1.getPhysicalNumberOfRows();

    //     Reports.log("       Adding the "+actualExcelFile+" Spreadsheet to the comparison");
    //     FileInputStream fileInputStream2 = new FileInputStream(actualExcelFile);
    //     XSSFWorkbook workbook2 = new XSSFWorkbook(fileInputStream2);
    //     XSSFSheet worksheet2 = workbook2.getSheet(actualSheetName);
    //     int rowCount2 = worksheet2.getPhysicalNumberOfRows();

    //     if (rowCount1 == rowCount2){
    //         Reports.log("**********[PASSED]: " + "Row Count for Expected is = " + rowCount1 + " and Row Count on Actual is = "+rowCount2);
    //         Assert.assertEquals(rowCount1,rowCount2);

    //         Reports.log("Comparing the number of Rows of Data on Expected Vs. Actual");
    //         for (int i=1; i<rowCount1; i++){
    //             XSSFRow row1 = worksheet1.getRow(i);
    //             XSSFRow row2 = worksheet2.getRow(i);
    //             /*
    //              * Comparing the column A cell, in the row
    //              */
    //             String colAStr1 = "";
    //             XSSFCell colA1 = row1.getCell(0);
    //             if (colA1 != null){
    //                 colA1.setCellType(CellType.STRING);
    //                 colAStr1 = colA1.getStringCellValue();
    //             }

    //             String colAStr2 = "";
    //             XSSFCell colA2 = row2.getCell(0);
    //             if (colA2 != null){
    //                 colA2.setCellType(CellType.STRING);
    //                 colAStr2 = colA2.getStringCellValue();
    //             }
    //             if (!colAStr1.equals(colAStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colAStr1+ " |Actual value = "+colAStr2);
    //             }

    //             /*
    //              * Comparing the column B cell, in the row
    //              */
    //             String colBStr1 = "";
    //             XSSFCell colB1 = row1.getCell(1);
    //             if (colB1 != null){
    //                 colB1.setCellType(CellType.STRING);
    //                 colBStr1 = colB1.getStringCellValue();
    //             }

    //             String colBStr2 = "";
    //             XSSFCell colB2 = row2.getCell(1);
    //             if (colB2 != null){
    //                 colB2.setCellType(CellType.STRING);
    //                 colBStr2 = colB2.getStringCellValue();
    //             }
    //             if (!colBStr1.equals(colBStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colBStr1+ " |Actual value = "+colBStr2);
    //             }

    //             /*
    //              * Comparing the column C cell, in the row
    //              */
    //             String colCStr1 = "";
    //             XSSFCell colC1 = row1.getCell(2);
    //             if (colC1 != null){
    //                 colC1.setCellType(CellType.STRING);
    //                 colCStr1 = colC1.getStringCellValue();
    //             }

    //             String colCStr2 = "";
    //             XSSFCell colC2 = row2.getCell(2);
    //             if (colC2 != null){
    //                 colC2.setCellType(CellType.STRING);
    //                 colCStr2 = colC2.getStringCellValue();
    //             }
    //             if (!colCStr1.equals(colCStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colCStr1+ " |Actual value = "+ colCStr2);
    //             }

    //             /*
    //              * Comparing the column D cell, in the row
    //              */
    //             String colDStr1 = "";
    //             XSSFCell colD1 = row1.getCell(3);
    //             if (colD1 != null){
    //                 colD1.setCellType(CellType.STRING);
    //                 colDStr1 = colD1.getStringCellValue();
    //             }

    //             String colDStr2 = "";
    //             XSSFCell colD2 = row2.getCell(3);
    //             if (colD2 != null){
    //                 colD2.setCellType(CellType.STRING);
    //                 colDStr2 = colD2.getStringCellValue();
    //             }
    //             if (!colDStr1.equals(colDStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colDStr1+ " |Actual value = "+ colDStr2);
    //             }

    //             /*
    //              * Comparing the column E cell, in the row
    //              */
    //             String colEStr1 = "";
    //             XSSFCell colE1 = row1.getCell(4);
    //             if (colE1 != null){
    //                 colE1.setCellType(CellType.STRING);
    //                 colEStr1 = colE1.getStringCellValue();
    //             }

    //             String colEStr2 = "";
    //             XSSFCell colE2 = row2.getCell(4);
    //             if (colE2 != null){
    //                 colE2.setCellType(CellType.STRING);
    //                 colEStr2 = colE2.getStringCellValue();
    //             }
    //             if (!colEStr1.equals(colEStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colEStr1+ " |Actual value = "+ colEStr2);
    //             }

    //             /*
    //              * Comparing the column F cell, in the row
    //              */
    //             String colFStr1 = "";
    //             XSSFCell colF1 = row1.getCell(5);
    //             if (colF1 != null){
    //                 colF1.setCellType(CellType.STRING);
    //                 colFStr1 = colF1.getStringCellValue();
    //             }

    //             String colFStr2 = "";
    //             XSSFCell colF2 = row2.getCell(5);
    //             if (colF2 != null){
    //                 colF2.setCellType(CellType.STRING);
    //                 colFStr2 = colF2.getStringCellValue();
    //             }
    //             if (!colFStr1.equals(colFStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colFStr1+ " |Actual value = "+ colFStr2);
    //             }

    //             /*
    //              * Comparing the column G cell, in the row
    //              */
    //             String colGStr1 = "";
    //             XSSFCell colG1 = row1.getCell(6);
    //             if (colG1 != null){
    //                 colG1.setCellType(CellType.STRING);
    //                 colGStr1 = colG1.getStringCellValue();
    //             }

    //             String colGStr2 = "";
    //             XSSFCell colG2 = row2.getCell(6);
    //             if (colG2 != null){
    //                 colG2.setCellType(CellType.STRING);
    //                 colGStr2 = colG2.getStringCellValue();
    //             }
    //             if (!colGStr1.equals(colGStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colGStr1+ " |Actual value = "+ colGStr2);
    //             }

    //             /*
    //              * Comparing the column H cell, in the row
    //              */
    //             String colHStr1 = "";
    //             XSSFCell colH1 = row1.getCell(7);
    //             if (colH1 != null){
    //                 colH1.setCellType(CellType.STRING);
    //                 colHStr1 = colH1.getStringCellValue();
    //             }

    //             String colHStr2 = "";
    //             XSSFCell colH2 = row2.getCell(7);
    //             if (colH2 != null){
    //                 colH2.setCellType(CellType.STRING);
    //                 colHStr2 = colH2.getStringCellValue();
    //             }
    //             if (!colHStr1.equals(colHStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colHStr1+ " |Actual value = "+ colHStr2);
    //             }

    //             /*
    //              * Comparing the column I cell, in the row
    //              */
    //             String colIStr1 = "";
    //             XSSFCell colI1 = row1.getCell(8);
    //             if (colI1 != null){
    //                 colI1.setCellType(CellType.STRING);
    //                 colIStr1 = colI1.getStringCellValue();
    //             }

    //             String colIStr2 = "";
    //             XSSFCell colI2 = row2.getCell(8);
    //             if (colI2 != null){
    //                 colI2.setCellType(CellType.STRING);
    //                 colIStr2 = colI2.getStringCellValue();
    //             }
    //             if (!colIStr1.equals(colIStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colIStr1+ " |Actual value = "+ colIStr2);
    //             }

    //             /*
    //              * Comparing the column J cell, in the row
    //              */
    //             String colJStr1 = "";
    //             XSSFCell colJ1 = row1.getCell(9);
    //             if (colJ1 != null){
    //                 colJ1.setCellType(CellType.STRING);
    //                 colJStr1 = colJ1.getStringCellValue();
    //             }

    //             String colJStr2 = "";
    //             XSSFCell colJ2 = row2.getCell(9);
    //             if (colJ2 != null){
    //                 colJ2.setCellType(CellType.STRING);
    //                 colJStr2 = colJ2.getStringCellValue();
    //             }
    //             if (!colJStr1.equals(colJStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colJStr1+ " |Actual value = "+ colJStr2);
    //             }

    //             /*
    //              * Comparing the column K cell, in the row
    //              */
    //             String colKStr1 = "";
    //             XSSFCell colK1 = row1.getCell(10);
    //             if (colK1 != null){
    //                 colK1.setCellType(CellType.STRING);
    //                 colKStr1 = colK1.getStringCellValue();
    //             }

    //             String colKStr2 = "";
    //             XSSFCell colK2 = row2.getCell(10);
    //             if (colK2 != null){
    //                 colK2.setCellType(CellType.STRING);
    //                 colKStr2 = colK2.getStringCellValue();
    //             }
    //             if (!colKStr1.equals(colKStr2)){
    //                 Reports.log("**********[FAILED]: " + "Difference found in (" +actualSheetName+ ") |Expected value = " +colKStr1+ " |Actual value = "+ colKStr2);
    //             }

    //             Reports.log("**********[PASSED]: Expected File, Row number: " + i + "Compared to Actual File, Row number: " + row2);
    //         }

    //         Reports.log("**********[PASSED]: All fields verified and no issues found.");
    //     }
    //     else {
    //         Reports.log("**********[FAILED]: " + "Row Count 1 =  " + rowCount1 + " and Row Count 2 = " +rowCount2);
    //         Assert.assertEquals(rowCount1,rowCount2);
    //     }
    // }
}










