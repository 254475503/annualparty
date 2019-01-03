package com.sohu.auto.annualparty.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.sohu.auto.annualparty.utils.ReadExcel;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class testController {
    private final static String excelPath = "src/main/resources/static/participatores.xlsx";
    @RequestMapping("sayHello")
    public String sayHello() {
        return "hello";
    }

    @RequestMapping("getList")
    @ResponseBody
    public List<String> getList()
    {
        List<String> participatores = new ArrayList<>();
        try {
            ReadExcel readExcel = new ReadExcel(excelPath);
            int rownum = readExcel.getAllRowNumber();
            String[] str = new String[rownum];
            for(int i = 0 ; i < rownum+1 ; i++)
            {
                str = readExcel.readLine(i);
                participatores.add(str[0]);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
       return participatores;
    }

    @RequestMapping("getJsonList")
    @ResponseBody
    public String getListJson()
    {

        List<String> participatores = new ArrayList<>();

        try {
            ReadExcel readExcel = new ReadExcel(excelPath);
            int rownum = readExcel.getAllRowNumber();
            String[] str = new String[rownum];
            for(int i = 0 ; i < rownum+1 ; i++)
            {
                str = readExcel.readLine(i);
                participatores.add(str[0]);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("memberList",participatores);
        JSONObject jsonObject = new JSONObject(jsonMap);
        String str = jsonObject.toJSONString();
        return  str;
    }
}
