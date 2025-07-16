package com.hhstechgroup.utility;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * ExcelFileReading class provides methods to create, modify, read and write data into excel.
 */
public class ExcelFileReading {
    public String filePath;
    private int sheetIndex;

    /**
     * This constructor method creates an ExcelFileReading object using filePath and sheetIndex
     * @param filePath
     * @param sheetIndex
     */
    public ExcelFileReading(String filePath, int sheetIndex) {
        this.filePath = filePath;
        this.sheetIndex = sheetIndex;
    }

    /**
     * This method gets the sheet of the excel file
     * @return
     * @throws IOException
     */
    public XSSFSheet getSheet() throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        return sheet;
    }

    /**
     * This method gets excel as map using the environment
     * @param env
     * @return
     * @throws IOException
     */
    public Map<String, Map<String, String>> getExcelAsMap(String env) throws IOException {
        XSSFSheet sheet = getSheet();
        Map<String, Map<String, String>> completeSheetData = new HashMap<String, Map<String, String>>();
        List<String> columnHeader = new ArrayList<String>();
        Row row = sheet.getRow(0);
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            columnHeader.add(cellIterator.next().getStringCellValue());
        }
        int rowCount = row.getLastCellNum();
        int columnCount = row.getLastCellNum();
        for (int i = 1; i <= rowCount; i++) {
            Map<String, String> singleRowData = new HashMap<String, String>();
            Row row1 = sheet.getRow(i);
            if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(env)) {
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = row1.getCell(j);
                    singleRowData.put(columnHeader.get(j), getCellValueAsString(cell));
                    //  singleRowData.put(columnHeader.get(j), getCellValueAsString(cell));
                }
            }
            completeSheetData.put(String.valueOf(i), singleRowData);
        }
        return completeSheetData;
    }

    /**
     * This method gets excel as array list using the environment
     * @param env
     * @return
     * @throws IOException
     */
    public ArrayList<String> getExcelAsArray(String env) throws IOException {
        XSSFSheet sheet = getSheet();
        ArrayList<String> completeSheetData = new ArrayList<>();
        //  Map<String, Map<String, String>> completeSheetData = new HashMap<String, Map<String, String>>();
        List<String> columnHeader = new ArrayList<String>();
        Row row = sheet.getRow(0);

        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            columnHeader.add(cellIterator.next().getStringCellValue());
        }
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int columnCount = row.getLastCellNum();
        for (int i = 1; i <= rowCount; i++) {
            try {
                Row row1 = sheet.getRow(i);
                if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(env)) {
                    for (int j = 0; j < columnCount; j++) {
                        Cell cell = row1.getCell(j);
                        completeSheetData.add(cell.getStringCellValue());
                    }
                }
            } catch (NullPointerException e) {
            }/*
                // Map<String, String> singleRowData = new HashMap<String, String>();
                Row row1 = sheet.getRow(i);
                // List<String> arrName = new ArrayList<String>();
                if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(env)) {
                    for (int j = 0; j < columnCount; j++) {
                        Cell cell = row1.getCell(j);
                        completeSheetData.add(cell.getStringCellValue());
                    }
                }
*/
        }
        return completeSheetData;
    }

    /**
     * This method gets cell value as string using the cell
     * @param cell
     * @return
     */
    public String getCellValueAsString(Cell cell) {
        String cellValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue = cell.getCellFormula();
            case BLANK:
                cellValue = "BLANK";
            default:
                cellValue = "DEFAULT";
        }
        return cellValue;
    }

    /**
     * This method gets sheet name using the index
     * @param index
     * @return
     * @throws IOException
     */
    public String getSheetName(int index) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        String sheet = workbook.getSheetName(index);
        return sheet;
    }

    /**
     * This method gets sheet count
     * @return
     * @throws IOException
     */
    public int getSheetCount() throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        int sheetCount = workbook.getNumberOfSheets();
        return sheetCount;
    }

    /**
     * This method total column count
     * @return
     * @throws IOException
     */
    public int totolColumnCount() throws IOException {
        XSSFSheet sheet = getSheet();
        Row row = sheet.getRow(0);
        int lastColumnNum = row.getLastCellNum();
        return lastColumnNum;
    }

    /**
     * This method contains value using row, fcell, lcell
     * @param row
     * @param fcell
     * @param lcell
     * @return
     */
    public boolean containsValue(XSSFRow row, int fcell, int lcell)
    {
        boolean flag = false;
        for (int i = fcell; i < lcell; i++) {
            if (StringUtils.isEmpty(String.valueOf(row.getCell(i))) == true ||
                    StringUtils.isWhitespace(String.valueOf(row.getCell(i))) == true ||
                    StringUtils.isBlank(String.valueOf(row.getCell(i))) == true ||
                    String.valueOf(row.getCell(i)).length() == 0 ||
                    row.getCell(i) == null) {}
            else {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * This method deletes all record from excel sheet using sheet
     * @param sheet
     */
    public void DeleteAllRecordFromExcelSheet(Sheet sheet){

        int numberOfRows = sheet.getPhysicalNumberOfRows();

        if(numberOfRows > 0) {
            for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
                if(sheet.getRow(i) != null) {
                    sheet.removeRow( sheet.getRow(i));
                } else {
                    System.out.println("Info: clean sheet='" + sheet.getSheetName() + "' ... skip line: " + i);
                }
            }
        } else {
            System.out.println("Info: clean sheet='" + sheet.getSheetName() + "' ... is empty");
        }
    }
}




