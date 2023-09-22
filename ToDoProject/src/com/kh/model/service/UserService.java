package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.UserDao;
import com.kh.model.vo.User;

public class UserService {

	public int inputUser(User u) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new UserDao().inputUser(conn, u);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
		
	}
	
	public User userLogin(String id, String pw){
		
		Connection conn = JDBCTemplate.getConnection();
		User u = new UserDao().userLogin(conn, id, pw);
		
		JDBCTemplate.close(conn);
		
		return u;
	}
	
	public int updateUser(User u, User user) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new UserDao().updateUser(conn, u, user);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public User viewMyInfo(User u) {
		Connection conn = JDBCTemplate.getConnection();
		User user = new UserDao().viewMyInfo(conn, u);
		JDBCTemplate.close(conn);
		
		return user;
	}
	
	public int deleteUser(User u) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new UserDao().deleteUser(conn, u);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
}
