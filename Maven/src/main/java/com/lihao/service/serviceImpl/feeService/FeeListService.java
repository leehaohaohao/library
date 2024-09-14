package com.lihao.service.serviceImpl.feeService;

import com.github.pagehelper.PageHelper;
import com.lihao.bean.Fee;
import com.lihao.bean.Page;
import com.lihao.dao.FeeDao;
import com.lihao.service.FeeService;
import com.lihao.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
@Transactional
@Service
public class FeeListService implements FeeService {
    @Autowired
    private FeeDao feeDao;
    @Override
    public List<Fee> excute(HttpServletRequest request, Page page , Fee fee) {
        Long user_id = SessionUtil.getUserId(request);
        PageHelper.startPage(page.getPage_num(), page.getPage_size());
        return feeDao.select_by_user_id(user_id);
    }
}
