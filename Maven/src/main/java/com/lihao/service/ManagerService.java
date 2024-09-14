package com.lihao.service;

import com.lihao.bean.Manager;
import com.lihao.bean.Page;
import com.lihao.exception.Wrong;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ManagerService {
    List<Manager> select_all_manager(Page page, String query);
    String insert_manager(Manager manager, MultipartFile file) throws Wrong;
    Manager select_manager(Long manger_id);
    int delete_manager(Long manager_id);
    String update_manager(Manager manager,MultipartFile file) throws Wrong;
}
