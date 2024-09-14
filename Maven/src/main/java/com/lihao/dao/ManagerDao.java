package com.lihao.dao;

import com.lihao.bean.Manager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 管理员操作实现接口
 * @author lihao
 * @version 1.0
 * @since 1.0
 */

public interface ManagerDao {
    /**
     * 管理员查询
     * @param account 账号
     * @return
     */
    Manager select(String account);
    String login_confirm(String account_num);
    Long select_manager_id(String account_num);
    Manager select_by_id(Long manager_id);
    @Select("select permissions from t_manager where manager_id = #{manager_id}")
    Boolean select_permissions(Long manager_id);
    @Select("select * from t_manager where name like concat('%',#{query},'%')")
    List<Manager> select_all_manager(String query);
    @Insert("insert into t_manager (name,gender,telephone_num,email,photo,account_num,password) " +
            "values (#{name},#{gender},#{telephone_num},#{email},#{photo},#{account_num},#{password})")
    Integer insert_manager(Manager manager);
    @Update("update t_manager set isdelete = 1 where manager_id = #{manager_id}")
    int delete_manager(Long manager_id);
    int update(Manager manager);
}
