package com.lihao.dao;

import com.lihao.bean.Press;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

public interface PressDao {
    Press select(Long press_id);
    Press select_press(String press);
    @Insert("insert into t_press (press) values (#{press})")
    int insert_press(String press);
}
