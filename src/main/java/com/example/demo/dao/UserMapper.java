package com.example.demo.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {

	@Select("select id,name,phone,user.limit from user")
	List<User> getAll();
}
