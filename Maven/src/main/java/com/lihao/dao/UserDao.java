package com.lihao.dao;

import com.lihao.bean.User;
import com.lihao.bean.userDTO.UserBaseInfoDto;
import com.lihao.bean.userDTO.UserBlacklistDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

/**
 * 非管理员操作实现接口
 * @author lihao
 * @version 1.0
 * @since 1.0
 */
public interface UserDao {
    /**
     * 非管理员查询
     * @param account 账号
     * @return
     */
    User select(String account) ;
    User select_by_id(Long user_id);
    String blacklist(Long user_id);

    /**
     * 非管理员更改
     * @param user 用户实体类
     * @return
     */
    void update(User user) ;
    Long select_user_id(String user_account_num);
    String login_confirm(String user_account_num);
    Integer update_user_fee_all(@Param("user_id") Long user_id,@Param("fee_all") BigDecimal fee_all);
    List<User> select_all_student(String query);
    List<User> select_all_teacher(String query);
    @Insert("insert into t_user (gender,name,user_num,telephone_num,user_photo,email,user_category_id,user_account_num,fee_all,blacklist,password) " +
            "values (#{gender},#{name},#{user_num},#{telephone_num},#{user_photo},#{email},#{userCategory.user_category_id},#{user_account_num},#{fee_all},#{blacklist},#{password})")
    Integer insert_user(User user);
    @Update("update t_user set is_delete=#{is_delete} where user_id = #{user_id}")
    Integer update_user_is_delete_by_id(@Param("user_id") Long user_id, @Param("is_delete") boolean is_delete);
    @Update("update t_user set blacklist=#{blacklist} where user_id = #{user_id}")
    Integer update_user_blacklist(UserBlacklistDto userBlacklistDto);
    Integer update_user(User user);
    List<User> sc();
    @Select("select name,user_photo from t_user where user_id = #{user_id}")
    UserBaseInfoDto userBaseInfo(Long user_id);
}
