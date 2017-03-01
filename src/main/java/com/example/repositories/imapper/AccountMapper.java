package com.example.repositories.imapper;

import com.example.repositories.entities.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by j_chena on 2017/1/16.
 */
@Mapper
public interface AccountMapper {

    @Select("SELECT * FROM User WHERE Email = #{email} limit 1")
    Account findByEmail(@Param("email") String email);
    @Insert("INSERT INTO User(Email, Password) VALUES(#{email}, #{password})")
    int insert(Account account);
}
