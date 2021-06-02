package com.atguigu;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/29
 \* Description: 
*/

import com.atguigu.utils.POIUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;

public class POITest {


    @Test
    public void readExcel()throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook("F:\\迅雷下载\\ordersetting_template.xlsx");
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        for (Row cells : sheetAt) {
            for (Cell cell : cells) {
                System.out.println( cell.getStringCellValue());
            }
        }
    }
    @Test
    public void writeExcel() throws  Exception{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheetAt = workbook.createSheet("个人信息");

        XSSFRow row = sheetAt.createRow(0);
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("年龄");

        XSSFRow row2 = sheetAt.createRow(1);
        row2.createCell(0).setCellValue("huaSheng");
        row2.createCell(1).setCellValue(12);

        FileOutputStream outputStream = new FileOutputStream("F:\\迅雷下载\\information.xlsx");
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        workbook.close();
    }


}
