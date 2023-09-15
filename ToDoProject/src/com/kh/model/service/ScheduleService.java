package com.kh.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ScheduleDao;
import com.kh.model.vo.Schedule;

public class ScheduleService {

public int inputUser(Schedule s) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ScheduleDao().insertToDo(conn, s);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
		
	}
	
}
