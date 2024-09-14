package com.lihao.service.serviceImpl.serviceUtil;

import com.lihao.bean.Press;
import com.lihao.dao.PressDao;
import com.lihao.exception.Wrong;
import com.lihao.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PressServiceUtil {
    @Autowired
    private PressDao pressDao;
    public Press pressHandle(String name) throws Wrong {
        Press press = pressDao.select_press(name);
        if(press==null){
            if(pressDao.insert_press(name)==1){
                press = pressDao.select_press(name);
            }else{
                throw new Wrong(StringUtil.getInsert_fail());
            }
        }
        return press;
    }
}
