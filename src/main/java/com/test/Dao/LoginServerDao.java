package com.test.Dao;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.test.Service.User;

public interface LoginServerDao {
	public void setDataSource(DataSource dataSource);
	public boolean checkLogin(String username,String password);
	public boolean AddUser(User user);
	public String DeltUser();
	public boolean UpdateUser(User user);
	public boolean Check_username(User user);
	public List<User> listStudents(String name);
	public User FindUser(String name);
	public String SessionShow(HttpSession session);
}
