package com.lihao.web.manager;

import com.github.pagehelper.PageInfo;
import com.lihao.bean.Page;
import com.lihao.bean.ResponsePack;
import com.lihao.bean.User;
import com.lihao.bean.userDTO.UserBlacklistDto;
import com.lihao.bean.userDTO.UserIdDto;
import com.lihao.dao.UserDao;
import com.lihao.excelHandler.UserHandler;
import com.lihao.exception.Wrong;
import com.lihao.service.TeacherService;
import com.lihao.utils.ExcelUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/manager/teacher")
public class ManagerTeacherServlet {
    @Autowired
    private TeacherService teacherServiceImpl;
    @Autowired
    private UserDao userDao;
    @RequestMapping("/list")
    public ResponsePack<PageInfo<User>> Teacher_list(@ModelAttribute("page_num")Page page, @RequestParam("query")String query){
        ResponsePack<PageInfo<User>> responsePack = new ResponsePack();
        responsePack.setData(new PageInfo<>(teacherServiceImpl.select_all_teacher(page,query)));
        responsePack.setSuccess(true);
        return responsePack;
    }
    @RequestMapping("/add")
    public ResponsePack<String> Teacher_add(String gender, String name, String user_num,
                                            String telephone_num, String email, String user_account_num,
                                            BigDecimal fee_all, Boolean blacklist, String password,
                                            @RequestPart MultipartFile file) throws Wrong {
        User user = buildUser(gender,name,user_num,telephone_num,email,user_account_num,fee_all,blacklist,password);
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(teacherServiceImpl.insert_teacher(user,file));
        responsePack.setSuccess(true);
        return responsePack;
    }
    private User buildUser(String gender, String name, String user_num, String telephone_num, String email, String user_account_num, BigDecimal fee_all, Boolean blacklist, String password) throws Wrong {
        if (gender == null || gender.isEmpty() || (!gender.equals("男") && !gender.equals("女")) ||
                name == null || name.isEmpty() ||
                user_num == null || user_num.isEmpty() ||
                telephone_num == null || telephone_num.isEmpty() ||
                email == null || email.isEmpty() ||
                user_account_num == null || user_account_num.isEmpty() ||
                fee_all == null ||
                blacklist == null ||
                password == null || password.isEmpty()) {
            throw new Wrong("未按要求填补信息！");
        }
        return new User.Builder()
                .gender(gender)
                .name(name)
                .user_num(user_num)
                .telephone_num(telephone_num)
                .email(email)
                .user_account_num(user_account_num)
                .fee_all(fee_all)
                .blacklist(blacklist)
                .password(password)
                .build();
    }
    @RequestMapping("/delete")
    public ResponsePack<String> Teacher_delete(@RequestBody UserIdDto userIdDto) throws Wrong {
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(teacherServiceImpl.delete_teacher(userIdDto));
        responsePack.setSuccess(true);
        return responsePack;
    }
    @PostMapping("/blacklist")
    public void Teacher_blacklist(@RequestBody UserBlacklistDto userBlacklistDto) throws Wrong {
        teacherServiceImpl.update_teacher_blacklist(userBlacklistDto);
    }
    @GetMapping("/select")
    public ResponsePack<User> Teacher_select(@RequestParam Long user_id){
        ResponsePack<User> responsePack = new ResponsePack<>();
        responsePack.setData(teacherServiceImpl.select_teacher(user_id));
        responsePack.setSuccess(true);
        return responsePack;
    }
    private User buildUser(Long user_id, String gender, String name, String telephone_num, String email, String user_account_num, BigDecimal fee_all, Boolean blacklist, String password) throws Wrong {
        if (user_id == null ) {
            throw new Wrong("用户编号错误！");
        }
        User.Builder builder = new User.Builder().user_id(user_id);
        if (gender != null && !gender.isEmpty()) {
            builder.gender(gender);
        }
        if (name != null && !name.isEmpty()) {
            builder.name(name);
        }
        if (telephone_num != null && !telephone_num.isEmpty()) {
            builder.telephone_num(telephone_num);
        }
        if (email != null && !email.isEmpty()) {
            builder.email(email);
        }
        if (user_account_num != null && !user_account_num.isEmpty()) {
            builder.user_account_num(user_account_num);
        }
        if (fee_all != null) {
            builder.fee_all(fee_all);
        }
        if (blacklist != null) {
            builder.blacklist(blacklist);
        }
        if (password != null && !password.isEmpty()) {
            builder.password(password);
        }
        return builder.build();
    }

    @RequestMapping("/update")
    public ResponsePack<String> Teacher_update(Long user_id, String gender, String name,
                                               String telephone_num, String email,
                                               String user_account_num, BigDecimal fee_all, Boolean blacklist,
                                               String password,@RequestPart(value = "file",required = false) MultipartFile file) throws Wrong {
        User user = buildUser(user_id,gender,name,telephone_num,email,user_account_num,fee_all,blacklist,password);
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(teacherServiceImpl.update_teacher(user,file));
        responsePack.setSuccess(true);
        return responsePack;
    }
    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws InstantiationException, IllegalAccessException, Wrong, IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=Teachers.xls");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String[] names = new String[]{"学号","姓名","性别","账号","电话号码","邮箱","照片链接","所欠费用"};
        ExcelUtil<User> excelUtil = new ExcelUtil(UserHandler.class);
        List<User> userList = userDao.select_all_teacher("");
        Workbook workbook = excelUtil.deal("Teachers",userList,names);
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
