package com.lihao.service;

import com.lihao.bean.Notice;
import com.lihao.exception.Wrong;

import java.util.Date;
import java.util.List;

public interface NoticeService {
    List<Notice> list();
    String publish(String notice_content, Date nowDate, String manager_id) throws Wrong;
}
