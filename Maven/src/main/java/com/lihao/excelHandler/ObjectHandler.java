package com.lihao.excelHandler;

import com.lihao.exception.Wrong;
import org.apache.poi.ss.usermodel.Sheet;

public interface ObjectHandler<T> {
    Sheet deal(Sheet sheet ,T t ,Integer count) throws Wrong;
}
