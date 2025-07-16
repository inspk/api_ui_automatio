package com.hhstechgroup.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * SQLHandler class provides method to connect to postgresql data base
 */
public class DbExcelExporter {
    /**
     * This method gets a file name
     *
     * @param baseName
     * @return
     */
    private String getFileName(String baseName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTimeInfo = dateFormat.format(new java.util.Date());
        return baseName.concat(String.format("_%s.xlsx", dateTimeInfo));
    }

    /**
     * This method export data from Data bade and stores in excel file
     *
     * @param driver
     * @param jdbcUrl
     * @param username
     * @param Password
     * @param table
     * @throws Exception
     */
    public void export(String driver, String jdbcUrl, String username, String Password, String table) throws Exception {

        SQLHandler sql1 = new SQLHandler();
        String excelFilePath = System.getProperty("user.dir")+ File.separator + "DBExcelFiles"+ File.separator + getFileName(table.concat("_Export"));

        try (Connection connection = sql1.connect(driver, jdbcUrl, username, Password)) {
            String sql = "SELECT * FROM ".concat(table);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(table);

            writeHeaderLine(result, sheet);

            writeDataLines(result, workbook, sheet);

           // File file = new File("C:\\Users\\leila.kariminiazaghe\\NewSDBranch\\acceptance-tests\\DataBaseExcelFiles");
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();

            statement.close();

        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }

    /**
     * This method write header line containing column names
     *
     * @param result
     * @param sheet
     * @throws SQLException
     */
    private void writeHeaderLine(ResultSet result, XSSFSheet sheet) throws SQLException {
        // write header line containing column names
        ResultSetMetaData metaData = result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        Row headerRow = sheet.createRow(0);

        // exclude the first column which is the ID field
        for (int i = 2; i <= numberOfColumns; i++) {
            String columnName = metaData.getColumnName(i);
            Cell headerCell = headerRow.createCell(i - 2);
            headerCell.setCellValue(columnName);
        }
    }

    /**
     * This method writes data from table in data base into rows in excel file
     *
     * @param result
     * @param workbook
     * @param sheet
     * @throws SQLException
     */
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet)
            throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        int rowCount = 1;

        while (result.next()) {
            Row row = sheet.createRow(rowCount++);

            for (int i = 2; i <= numberOfColumns; i++) {
                Object valueObject = result.getObject(i);

                Cell cell = row.createCell(i - 2);

                if (valueObject instanceof Boolean)
                    cell.setCellValue((Boolean) valueObject);
                else if (valueObject instanceof Double)
                    cell.setCellValue((double) valueObject);
                else if (valueObject instanceof String)
                    cell.setCellValue((String) valueObject);
                else if (valueObject instanceof Integer)
                    cell.setCellValue((Integer) valueObject);
                else if (valueObject instanceof Date) {
                    cell.setCellValue((Date) valueObject);
                    formatDateCell(workbook, cell);
                } else cell.getStringCellValue();
            }
        }
    }

    /**
     * This method format dates in cells
     *
     * @param workbook
     * @param cell
     */
    private void formatDateCell(XSSFWorkbook workbook, Cell cell) {
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        cell.setCellStyle(cellStyle);
    }
}


