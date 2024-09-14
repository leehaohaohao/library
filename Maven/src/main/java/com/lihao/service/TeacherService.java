package com.lihao.service;

import com.lihao.bean.Page;
import com.lihao.bean.User;
import com.lihao.bean.userDTO.UserBlacklistDto;
import com.lihao.bean.userDTO.UserIdDto;
import com.lihao.exception.Wrong;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TeacherService {
    List<User> select_all_teacher(Page page,String query);
    String insert_teacher(User user, MultipartFile file) throws Wrong;
    String delete_teacher(UserIdDto userIdDto) throws Wrong;
    String update_teacher_blacklist(UserBlacklistDto userBlacklistDto) throws Wrong;
    String update_teacher(User user,MultipartFile file)throws Wrong;
    User select_teacher(Long user_id);
}
