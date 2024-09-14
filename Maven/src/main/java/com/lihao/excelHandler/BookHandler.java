package com.lihao.excelHandler;

import com.lihao.bean.Book;
import com.lihao.exception.Wrong;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class BookHandler implements ObjectHandler<Book>{
    @Override
    public Sheet deal(Sheet sheet, Book book, Integer count) throws Wrong {
        if(book == null){
            throw new Wrong("服务器错误，请查看日志已排查问题！");
        }
        Row row = sheet.createRow(count++);
        row.createCell(0).setCellValue(book.getBook_id());
        row.createCell(1).setCellValue(book.getBook());
        row.createCell(2).setCellValue(book.getAuthor().getAuthor());
        row.createCell(3).setCellValue(book.getPress().getPress());
        row.createCell(4).setCellValue(book.getCategory().getCategory());
        row.createCell(5).setCellValue(book.getBookshelf());
        row.createCell(6).setCellValue(String.valueOf(book.getBook_money()));
        row.createCell(7).setCellValue(book.getBook_photo());
        row.createCell(8).setCellValue(book.getBook_user_num());
        row.createCell(9).setCellValue(book.getBooks());
        return sheet;
    }
}
