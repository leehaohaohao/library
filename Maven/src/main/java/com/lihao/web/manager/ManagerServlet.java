package com.lihao.web.manager;

import com.github.pagehelper.PageInfo;
import com.lihao.bean.Manager;
import com.lihao.bean.Page;
import com.lihao.bean.ResponsePack;
import com.lihao.exception.Wrong;
import com.lihao.service.ManagerService;
import com.lihao.service.NoticeService;
import com.lihao.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/manager")
public class ManagerServlet {
    @Autowired
    private ManagerService managerServiceImpl;
    @Autowired
    private NoticeService noticeServiceImpl;
    @RequestMapping("/list")
    public ResponsePack<PageInfo<Manager>> Manager_list(@ModelAttribute Page page, @RequestParam String query){
        List<Manager> managers = managerServiceImpl.select_all_manager(page,query);
        return new ResponsePack<>(true,null,new PageInfo<>(managers));
    }
    @RequestMapping("/add")
    public ResponsePack<String> Manager_add(String name ,String gender , String account_num,
                                            String password,String telephone_num , String email,@RequestPart MultipartFile file) throws Wrong {
        Manager manager = buildManager(name,gender,account_num,password,telephone_num,email);
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(managerServiceImpl.insert_manager(manager,file));
        responsePack.setSuccess(true);
        return responsePack;
    }
    private Manager buildManager(String name, String gender, String account_num, String password, String telephone_num, String email) throws Wrong {
        if (name == null || name.isEmpty() ||
                gender == null || gender.isEmpty() ||
                account_num == null || account_num.isEmpty() ||
                password == null || password.isEmpty() ||
                telephone_num == null || telephone_num.isEmpty() ||
                email == null || email.isEmpty()) {
            throw new Wrong("请填写所有字段");
        }
        return new Manager.Builder()
                .name(name)
                .gender(gender)
                .account_num(account_num)
                .password(password)
                .telephone_num(telephone_num)
                .email(email)
                .build();
    }
    private Manager buildManager(Long manager_id, String name, String gender,
                                 String account_num, String password, String telephone_num,
                                 String email) throws Wrong {
        if (manager_id == null) {
            throw new Wrong("管理员编号错误！");
        }
        Manager.Builder builder = new Manager.Builder().manager_id(manager_id);
        if (name != null && !name.isEmpty()) {
            builder.name(name);
        }
        if (gender != null && !gender.isEmpty()) {
            builder.gender(gender);
        }
        if (account_num != null && !account_num.isEmpty()) {
            builder.account_num(account_num);
        }
        if (password != null && !password.isEmpty()) {
            builder.password(password);
        }
        if (telephone_num != null && !telephone_num.isEmpty()) {
            builder.telephone_num(telephone_num);
        }
        if (email != null && !email.isEmpty()) {
            builder.email(email);
        }
        return builder.build();
    }

    @RequestMapping("/delete")
    public String Manager_delete(@RequestParam Long manager_id){
        return null;
        /*if(managerServiceImpl.delete_manager(manager_id)==1){
            return StringUtil.getDelete_success();
        }else{
            try {
                throw new Wrong(StringUtil.getDelete_fail());
            } catch (Wrong e) {
                throw new RuntimeException(e);
            }
        }*/
    }
    @RequestMapping("/select")
    public ResponsePack<Manager> Manager_select(Long manager_id){
        return new ResponsePack<>(true,null,managerServiceImpl.select_manager(manager_id)) ;
    }
    @RequestMapping("/update")
    public ResponsePack<String> Manager_update(Long manager_id, String name, String gender,
                                               String account_num, String password, String telephone_num,
                                               String email, @RequestPart(value = "file",required = false) MultipartFile file) throws Wrong {
            Manager manager = buildManager(manager_id,name,gender,account_num,password,telephone_num,email);
        return new ResponsePack<>(true,null,managerServiceImpl.update_manager(manager,file));
    }
    @RequestMapping("/notice/publish")
    public ResponsePack<String> notice_publish(String notice_content,String manager_id) throws Wrong {
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(noticeServiceImpl.publish(notice_content,new Date(),manager_id));
        responsePack.setSuccess(true);
        return responsePack;
    }

}
