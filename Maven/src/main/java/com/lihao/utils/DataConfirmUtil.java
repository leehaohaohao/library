package com.lihao.utils;

import com.lihao.bean.Manager;
import com.lihao.exception.Wrong;

public class DataConfirmUtil {
    public static Boolean ManagerConfirm(Manager manager){
        if(manager.getGender()==null || manager.getGender().isEmpty()){
            return false;
        }
        if(!manager.getGender().equals("男")&&!manager.getGender().equals("女")){
            return false;
        }
        if(manager.getEmail().isEmpty() || manager.getAccount_num().isEmpty() ||
        manager.getPassword().isEmpty() || manager.getName().isEmpty() ||
        manager.getTelephone_num().isEmpty() ||
                manager.getEmail()==null || manager.getAccount_num()==null ||
                manager.getPassword()==null || manager.getName()==null ||
                manager.getTelephone_num()==null ){
            return false;
        }
        return true;
    }

}
