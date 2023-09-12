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
}
