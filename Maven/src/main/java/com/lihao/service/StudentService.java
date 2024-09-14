package com.lihao.service;

import com.lihao.bean.Page;
import com.lihao.bean.User;
import com.lihao.bean.userDTO.UserBlacklistDto;
import com.lihao.bean.userDTO.UserIdDto;
import com.lihao.exception.Wrong;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    List<User> select_all_student(Page page,String query);
    String insert_student(User user, MultipartFile file) throws Wrong;
    String delete_student(UserIdDto userIdDto) throws Wrong;
    String update_student_blacklist(UserBlacklistDto userBlacklistDto) throws Wrong;
    String update_student(User user,MultipartFile file)throws Wrong;
    User select_student(Long user_id);
}
