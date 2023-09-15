package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public User userLogin(Connection conn, String id, String pw) {
		
		User u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new User (rset.getInt("USER_NO"),
							 rset.getString("USER_ID"),
							 rset.getString("USER_PW"),
							 rset.getString("USER_NAME"),
							 rset.getInt("AGE"),
							 rset.getString("GENDER"),
							 rset.getString("EMAIL"),
							 rset.getString("PHONE"),
							 rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return u;
	}
	
}
