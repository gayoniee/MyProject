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
		String sql = "INSERT INTO SCHEDULE VALUES(?, SCHEDULE_ID_SEQ.NEXTVAL, ?, ?, ?, DEFAULT)";               
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, u.getUserNo());
			pstmt.setString(2, s.getTitle());
			pstmt.setString(3, s.getDetail());
			pstmt.setDate(4, s.getDeadline());
			
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
		
		String sql = "SELECT * FROM SCHEDULE WHERE SCHEDULE_NO = ? ORDER BY SCHEDULE_ID";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, u.getUserNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Schedule s = new Schedule(
					rset.getInt("SCHEDULE_ID"),
					rset.getString("TITLE"),
					rset.getString("DETAIL"),
					rset.getDate("DEADLINE"),
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
	
	public int updateSchedule(Connection conn, User u, Schedule s, String scheduleId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE SCHEDULE SET TITLE = ?, DETAIL = ?, DEADLINE = ?, CLEAR_YN = ? WHERE SCHEDULE_ID = ?";               
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, s.getTitle());
			pstmt.setString(2, s.getDetail());
			pstmt.setDate(3, s.getDeadline());
			pstmt.setString(4, s.getClear());
			pstmt.setInt(5, Integer.parseInt(scheduleId));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int deleteSchedule(Connection conn, String scheduleId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM SCHEDULE WHERE SCHEDULE_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(scheduleId));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
}
