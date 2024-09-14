package com.lihao.utils;

import com.lihao.bean.Book;
import com.lihao.excelHandler.ObjectHandler;
import com.lihao.exception.Wrong;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Roman;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public class ExcelUtil<T> {
    private ObjectHandler<T> objectHandler;
    public ExcelUtil(Class<? extends ObjectHandler<T>> objectClass) throws InstantiationException, IllegalAccessException {
        this.objectHandler=objectClass.newInstance();
    }
    public Workbook deal(String name, List<T> data , String[] names) throws Wrong {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet(name);
        Row headerRow = sheet.createRow(0);
        int count = 0;
        for(String rowName:names){
            headerRow.createCell(count).setCellValue(rowName);
            count++;
        }
        count=1;
        Boolean bk = false;
        for(T t : data){
            sheet = objectHandler.deal(sheet,t,count);
            count++;
        }
        return workbook;
    }
}
