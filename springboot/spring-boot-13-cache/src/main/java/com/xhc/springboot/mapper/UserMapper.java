package com.xhc.springboot.mapper;

import com.xhc.springboot.entities.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Auther: xhc
 */
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Update("UPDATE `user` SET  `username`=#{username}, `real_name`=#{realName}, `password`=#{password}, `gender`=#{gender}, `user_type`=#{userType} WHERE `id`=#{id}")
    int updateUser(User user);

    @Insert("INSERT INTO `user` ( `username`, `real_name`, `password`, `gender`, `birthday`, `user_type`) VALUES ( #{username}, #{realName}, #{password}, #{gender}, #{userType})")
    int addUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUserById(Integer id);
}
