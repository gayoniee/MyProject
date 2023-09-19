package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ScheduleDao;
import com.kh.model.vo.Schedule;
import com.kh.model.vo.User;
public class ScheduleService {

	public int insertToDo(User u, Schedule s) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ScheduleDao().insertToDo(conn, u, s);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
		
	}
	
	public ArrayList<Schedule> selectList(User u) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Schedule> list = new ScheduleDao().selectList(u, conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public int updateSchedule(User u, Schedule s, String scheduleId) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ScheduleDao().updateSchedule(conn, u, s, scheduleId);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteSchedule(String scheduleId) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ScheduleDao().deleteSchedule(conn, scheduleId);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
}
