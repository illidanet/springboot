package com.example.imapper;

import com.example.pojos.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ALex on 02/01/2017.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User WHERE NAME = #{name}")
    User findByName(@Param("name") String name);
    @Insert("INSERT INTO User(Name, Age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}
