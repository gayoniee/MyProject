package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Schedule;
import com.kh.model.vo.User;

public class ScheduleDao {
	
	public int insertToDo(Connection conn, User u, Schedule s) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO SCHEDULE VALUES(?, SCHEDULE_NO_SEQ.NEXTVAL, ?, ?, ?, DEFAULT)";               
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, u.getUserNo());
			pstmt.setString(2, s.getTitle());
			pstmt.setString(3, s.getDetail());
			pstmt.setString(4, s.getDeadline());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<Schedule> selectList(User u, Connection conn){
		
		ArrayList<Schedule> list = new ArrayList<>();  // 비어있는 상태
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT SCHEDULE_NO, TITLE, DETAIL, DEADLINE, CLEAR_YN"
				+ " FROM SCHEDULE WHERE SCHEDULE_ID = ? ORDER BY SCHEDULE_NO";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, u.getUserNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Schedule s = new Schedule(
					rset.getInt("SCHEDULE_NO"),
					rset.getString("TITLE"),
					rset.getString("DETAIL"),
					rset.getString("DEADLINE"),
					rset.getString("CLEAR_YN"));
				
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
	}
	
		return list;
		
	}
}
