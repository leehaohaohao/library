package com.lihao.service.serviceImpl.noticeService;

import com.lihao.bean.Notice;
import com.lihao.dao.NoticeDao;
import com.lihao.exception.Wrong;
import com.lihao.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    @Override
    public List<Notice> list() {
        return noticeDao.select_notice_all();
    }

    @Override
    public String publish(String notice_content, Date nowDate, String manager_id) throws Wrong {
        if(noticeDao.publish(notice_content,nowDate,manager_id) != 1){
            throw new Wrong("发布失败！");
        }
        return "发布成功！";
    }
}
