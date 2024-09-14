package com.lihao.excelHandler;

import com.lihao.bean.User;
import com.lihao.exception.Wrong;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class UserHandler implements ObjectHandler<User>{
    @Override
    public Sheet deal(Sheet sheet, User user, Integer count) throws Wrong {
        if(user == null){
            throw new Wrong("服务器错误，请查看日志已排查问题！");
        }
        Row row = sheet.createRow(count++);
        row.createCell(0).setCellValue(user.getUser_num());
        row.createCell(1).setCellValue(user.getName());
        row.createCell(2).setCellValue(user.getGender());
        row.createCell(3).setCellValue(user.getUser_account_num());
        row.createCell(4).setCellValue(user.getTelephone_num());
        row.createCell(5).setCellValue(user.getEmail());
        row.createCell(6).setCellValue(user.getUser_photo());
        row.createCell(7).setCellValue(String.valueOf(user.getFee_all()));
        return sheet;
    }
}
