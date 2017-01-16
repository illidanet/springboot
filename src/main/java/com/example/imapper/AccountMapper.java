package com.example.imapper;

import com.example.pojos.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by j_chena on 2017/1/16.
 */
@Mapper
public interface AccountMapper {

    @Select("SELECT * FROM User WHERE Email = #{email}")
    User findByEmail(@Param("email") String email);
    @Insert("INSERT INTO User(Email, Password) VALUES(#{email}, #{password})")
    int insert(@Param("email") String email, @Param("password") String password);
}
