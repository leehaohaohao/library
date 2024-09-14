package com.lihao.service.serviceImpl.teacherService;

import com.github.pagehelper.PageHelper;
import com.lihao.bean.Page;
import com.lihao.bean.User;
import com.lihao.bean.UserCategory;
import com.lihao.bean.userDTO.UserBlacklistDto;
import com.lihao.bean.userDTO.UserIdDto;
import com.lihao.dao.UserDao;
import com.lihao.exception.Wrong;
import com.lihao.service.TeacherService;
import com.lihao.utils.FileUtil;
import com.lihao.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;
@Transactional
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> select_all_teacher(Page page,String query) {
        PageHelper.startPage(page.getPage_num(), page.getPage_size());
        return userDao.select_all_teacher(query);
    }

    @Override
    public String insert_teacher(User u, MultipartFile file) throws Wrong {
        if(!u.getGender().equals("男") &&
                !u.getGender().equals("女")
        ){
            throw new Wrong(StringUtil.getInsert_fail());
        }
        String ss[] = FileUtil.fileBookLoad(file,StringUtil.getTeacher_root());
        if(ss!=null){
            UserCategory userCategory = new UserCategory(2L,"教师");
            User user = new User.Builder()
                    .user_account_num(u.getUser_account_num())
                    .password(u.getPassword())
                    .gender(u.getGender())
                    .email(u.getEmail())
                    .user_photo(ss[0])
                    .userCategory(userCategory)
                    .blacklist(u.getBlacklist())
                    .name(u.getName())
                    .fee_all(BigDecimal.ZERO)
                    .user_num(u.getUser_num())
                    .telephone_num(u.getTelephone_num())
                    .build();
            if(userDao.insert_user(user)==1){
                return StringUtil.getInsert_success();
            }
            FileUtil.removeFile(ss[1]);
            throw new Wrong(StringUtil.getInsert_fail());
        }else{
            throw new Wrong(StringUtil.getInsert_fail());
        }

    }

    @Override
    public String delete_teacher(UserIdDto userIdDto) throws Wrong {
        Long[] user_ids = userIdDto.getUser_ids();
        for(Long user_id :user_ids){
            if(userDao.update_user_is_delete_by_id(user_id,true)!=1){
                throw new Wrong(StringUtil.getDelete_fail());
            }
        }
        return StringUtil.getDelete_success();
    }

    @Override
    public String update_teacher_blacklist(UserBlacklistDto userBlacklistDto) throws Wrong {
        if(userDao.update_user_blacklist(userBlacklistDto)!=1){
            throw new Wrong(StringUtil.getBlacklist_fail());
        }
        return StringUtil.getBlacklist_success();
    }

    @Override
    public String update_teacher(User user,MultipartFile file) throws Wrong {

        if(user.getGender()!=null&& !user.getGender().equals("男")&&!user.getGender().equals("女")){
            throw new Wrong(StringUtil.getUpdate_fail());
        }
        if(user.getUser_account_num()!=null&&
                !user.getUser_account_num().isEmpty()&&
                user.getUser_account_num().charAt(0)!='t'){
            throw new Wrong(StringUtil.getUpdate_fail());
        }
        String[] ss = null;
        if(file!=null){
            ss=FileUtil.fileBookLoad(file,StringUtil.getTeacher_root());
            if(ss==null){
                throw new Wrong(StringUtil.getUpdate_fail());
            }
        }
        if (ss != null) {
            user.setUser_photo(ss[0]);
        }
        if(userDao.update_user(user)!=1){
            if(ss!=null){
                FileUtil.removeFile(ss[1]);
            }
            throw new Wrong(StringUtil.getUpdate_fail());
        }
        return StringUtil.getUpdate_success();
    }

    @Override
    public User select_teacher(Long user_id) {
        return userDao.select_by_id(user_id);
    }

}
