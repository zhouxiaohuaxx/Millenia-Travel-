package com.atguigu;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/25
 \* Description: 
*/

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;


public class TestPoi {

    //导出
    @Test
    public void exportExcel()throws Exception{
        XSSFWorkbook sheets = new XSSFWorkbook("F:\\excel\\hello.xlsx");
        XSSFSheet sheetAt = sheets.getSheetAt(0);
        //遍历工作表获得行对象
        for (Row cells : sheetAt) {
            //遍历行对象获取单元格对象
            for (Cell cell : cells) {
                //获得单元格中的值
                String value = cell.getStringCellValue();
                System.out.print(value+",");
            }
            System.out.println();
        }
        sheets.close();
    }
    // 导入excel
    @Test
    public void importExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("hello");
        //创建单元格，0表示第一个单元格
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("编号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("年龄");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("1");
        row1.createCell(1).setCellValue("小明");
        row1.createCell(2).setCellValue("10");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("2");
        row2.createCell(1).setCellValue("小王");
        row2.createCell(2).setCellValue("20");

        //通过输出流将workbook对象下载到磁盘
        FileOutputStream out = new FileOutputStream("F:\\excel\\hello.xlsx");
        workbook.write(out);
        out.flush();//刷新
        out.close();//关闭
        workbook.close();
    }
}
