package com.sohu.auto.annualparty.utils;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExcel {
    private HSSFSheet hssfSheet;
    private XSSFSheet xssfSheet;

    public int getAllRowNumber()
    {
        if(hssfSheet!=null)
            return hssfSheet.getLastRowNum();
        else if(xssfSheet!=null)
            return xssfSheet.getLastRowNum();
        else
            return 0;
    }

    public String[] readLine(int rowNumber)
    {

        if(xssfSheet!=null)
        {
            XSSFRow xssfRow = xssfSheet.getRow(rowNumber);
            if(xssfRow!=null)
            {
                String[] resultStrs =  new String[xssfRow.getLastCellNum()];
                for(int i = 0 ; i < xssfRow.getLastCellNum() ; i++)
                {
                    resultStrs[i] = xssfRow.getCell(i).getStringCellValue();
                }
                return  resultStrs;
            }else
                return null;

        }
        else if(hssfSheet!=null)
        {
            HSSFRow hssfRow = hssfSheet.getRow(rowNumber);
            if(hssfRow!=null)
            {
                String[] resultStrs = new String[hssfRow.getLastCellNum()];
               for(int i = 0 ; i < hssfRow.getLastCellNum() ; i++)
               {
                   resultStrs[i] = hssfRow.getCell(i).getStringCellValue();
               }
                return  resultStrs;
            }
            return null;
        }
        else
            return null;
    }


    public ReadExcel(String excelPath) throws Exception
    {
        String fileType = excelPath.substring(excelPath.lastIndexOf(".") + 1, excelPath.length());
        InputStream inputStream = new FileInputStream(excelPath);

        HSSFWorkbook hssfWorkbook = null;
        XSSFWorkbook xssfWorkbook = null;

        if(fileType.equals("xls"))
        {
            hssfWorkbook = new HSSFWorkbook(inputStream);
        }else if(fileType.equals("xlsx"))
        {
            xssfWorkbook = new XSSFWorkbook(inputStream);
        }
        else
        {
            throw new Exception("文档格式不正确。请放入xls或者xlsx文档");
        }

        if(hssfWorkbook!=null)
            this.hssfSheet = hssfWorkbook.getSheetAt(0);
        else if(xssfWorkbook!=null)
            this.xssfSheet = xssfWorkbook.getSheetAt(0);
    }

}
