package com.lihao.dao;

import com.lihao.bean.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface NoticeDao {
    List<Notice> select_notice_all();
    int publish(@Param("notice_content") String notice_content,
                 @Param("notice_date") Date notice_date,
                 @Param("manager_id") String manager_id);
}
