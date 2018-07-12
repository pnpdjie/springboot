package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;

@RestController
public class MainController {
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	UserMapper dao;

	@RequestMapping("first")
	public String firstController() {
		return "firstController";

	}

	@RequestMapping("jdbcTest")
	public List<User> JdbcTest() {
		List<Map<String, Object>> list = jdbc.queryForList("select * from user");
		List<User> userList = new ArrayList<>();
		for (Map<String, Object> map : list) {
			User user = new User();

			user.setName(map.get("name").toString());

			user.setPhone(map.get("phone").toString());

			user.setLimit(Integer.valueOf(map.get("limit").toString()));

			
			userList.add(user);
		}
		return userList;
	}

	@RequestMapping("getUsers")
	public List<User> getUsers() {
		return dao.getAll();
	}
}
