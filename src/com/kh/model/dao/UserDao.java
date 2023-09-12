package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.User;

public class UserDao {

	public int inputUser(Connection conn, User u) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO USERS VALUES(USER_NO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPw());
			pstmt.setString(3, u.getUserName());
			pstmt.setInt(4, u.getAge());
			pstmt.setString(5, u.getGender());
			pstmt.setString(6, u.getEmail());
			pstmt.setString(7, u.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
	
}
