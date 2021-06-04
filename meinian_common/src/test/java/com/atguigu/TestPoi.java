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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TestPoi {

    @Test
    public  void testEncotypePassword(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123");
        System.out.println("encode = " + encode);

        boolean matches = encoder.matches("123", "$2a$10$.llVA3G24aiSxF/b.tqWvuUbCDImOWuvO6bxwd.dRRTumUUldj8Ti");
        System.out.println("matches = " + matches);

    }

    @Test
    public  void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println("time = " + time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(time);
        System.out.println("format = " + format);
        int i = calendar.get(Calendar.MONTH); //美国的月份是从0开始的，11月是他们的一年当中的最后一个月份
        System.out.println("i = " + i);
        int i1 = calendar.get(Calendar.DATE);//当前月份的第几天
        System.out.println("i1 = " + i1);
        int i2 = calendar.get(Calendar.DAY_OF_WEEK);//
        System.out.println("i2 = " + i2);
        int i3 = calendar.get(Calendar.DAY_OF_MONTH);//当前月份的第几天
        System.out.println("i3 = " + i3);
        int i4 = calendar.get(Calendar.DAY_OF_YEAR);//今年的第几天
        System.out.println("i4 = " + i4);
        int i5 = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println("i5 = " + i5);
    }

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
