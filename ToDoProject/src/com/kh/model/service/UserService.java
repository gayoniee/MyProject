package com.kh.model.service;

import java.sql.Connection;

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
}
