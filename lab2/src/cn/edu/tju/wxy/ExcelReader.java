package cn.edu.tju.wxy;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


import java.io.*;
import java.util.*;


public class ExcelReader {
    private final static String Path = System.getProperty("user.dir") +
            File.separator + "resource" + File.separator + "Selenium+Lab2020.xlsx";

    public static List<ExcelData> readExcel() {

        Workbook workbook = null;
        FileInputStream inputStream = null;

        try {
            File excelFile = new File(Path);
            if (!excelFile.exists()) {
                return null;
            }
            inputStream = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(inputStream);
            return parseExcel(workbook);
        } catch (Exception e) {
            return null;
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                return null;
            }
        }
    }

    private static List<ExcelData> parseExcel(Workbook workbook) {
        List<ExcelData> resultDataList = new ArrayList<>();
        // 解析sheet
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            if (sheet == null) continue;

            int firstRowNum = sheet.getFirstRowNum();
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int j = firstRowNum; j < rowEnd; j++) {
                Row row = sheet.getRow(j);
                if (row == null) continue;

                ExcelData resultData = convertRowToData(row);
                if (resultData.getUser() == null || resultData.getPassword() == null) {
                    continue;
                }
                resultDataList.add(resultData);
            }
        }

        return resultDataList;
    }

    private static String convertCellValueToString(Cell cell) {
        if (cell == null) {
            return null;
        }
        String returnValue = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:   //数字
                returnValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:    //字符串
                returnValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:   //布尔
                returnValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:     // 空值
                break;
            case Cell.CELL_TYPE_FORMULA:   // 公式
                returnValue = cell.getCellFormula();
                break;
            case Cell.CELL_TYPE_ERROR:     // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }

    private static ExcelData convertRowToData(Row row) {
        ExcelData resultData = new ExcelData();
        int cellNum = 1;

        String name = convertCellValueToString(row.getCell(cellNum));
        resultData.setUser(name);
        cellNum++;

        String password = convertCellValueToString(row.getCell(cellNum));
        resultData.setPassword(password);

        return resultData;
    }


}
