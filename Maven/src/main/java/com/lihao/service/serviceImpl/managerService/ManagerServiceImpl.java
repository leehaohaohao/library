package com.lihao.service.serviceImpl.managerService;

import com.github.pagehelper.PageHelper;
import com.lihao.bean.Manager;
import com.lihao.bean.Page;
import com.lihao.dao.ManagerDao;
import com.lihao.exception.Wrong;
import com.lihao.service.ManagerService;
import com.lihao.utils.DataConfirmUtil;
import com.lihao.utils.FileUtil;
import com.lihao.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public List<Manager> select_all_manager(Page page, String query) {
        PageHelper.startPage(page.getPage_num(), page.getPage_size());
        return managerDao.select_all_manager(query);
    }

    @Override
    public String insert_manager(Manager manager, MultipartFile file) throws Wrong {
        if(DataConfirmUtil.ManagerConfirm(manager)){
            String[] ss = null;
            ss= FileUtil.fileBookLoad(file,StringUtil.getManager_root());
            if(ss==null || ss.length!=2){
                throw new Wrong(StringUtil.getInsert_fail());
            }
            manager.setPhoto(ss[0]);
            if(managerDao.insert_manager(manager)==1){
                return StringUtil.getInsert_success();
            }
            FileUtil.removeFile(ss[1]);
        }
        throw new Wrong(StringUtil.getInsert_fail());
    }

    @Override
    public Manager select_manager(Long manger_id) {
        return managerDao.select_by_id(manger_id);
    }

    @Override
    public int delete_manager(Long manager_id) {

        return managerDao.delete_manager(manager_id);
    }

    @Override
    public String update_manager(Manager manager, MultipartFile file) throws Wrong {
        if(manager.getGender()!=null&& !manager.getGender().equals("男")&&!manager.getGender().equals("女")){
            throw new Wrong(StringUtil.getUpdate_fail());
        }
        if(manager.getAccount_num()!=null&&
                !manager.getAccount_num().isEmpty()){
            throw new Wrong(StringUtil.getUpdate_fail());
        }
        String[] ss = null;
        if(file!=null){
            ss=FileUtil.fileBookLoad(file,StringUtil.getManager_root());
            if(ss==null){
                throw new Wrong(StringUtil.getUpdate_fail());
            }
        }
        if (ss != null && ss.length==2) {
            manager.setPhoto(ss[0]);
        }
        if(managerDao.update(manager)!=1){
            if(ss!=null && ss.length==2){
                FileUtil.removeFile(ss[1]);
            }
            throw new Wrong(StringUtil.getUpdate_fail());
        }
        return StringUtil.getUpdate_success();
    }
}
