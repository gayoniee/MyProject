package com.kh.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.kh.model.service.ScheduleService;
import com.kh.model.vo.Schedule;
import com.kh.model.vo.User;
import com.kh.view.Menu;

public class ScheduleController {

	public void insertToDo(User u, String title, String detail, String deadline) {
		
		Schedule s = new Schedule(title, detail, transformDate(deadline));
		
		int result = new ScheduleService().insertToDo(u, s);
		
		if(result > 0) {  // insert가 성공적으로 완료
			new Menu().displaySuccess("일정등록 완료!");
		} else {  // insert가 실패
			new Menu().displayFail("일정등록에 실패하였습니다.");
		}
	}
	
	public Date transformDate(String deadline) {
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");		
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            tempDate = beforeFormat.parse(deadline);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        String transDate = afterFormat.format(tempDate);        
        Date d = Date.valueOf(transDate);
        
        return d;
    }
		
	public void viewSchedule(User u) {
		ArrayList<Schedule> list = new ScheduleService().selectList(u);
		
		if(list.isEmpty()) {
			new Menu().displayNoData("전체 조회 결과가 없습니다.");
		} else {
			new Menu().displayScheduleList(list);
		}
	}

	public void updateSchedule(User u, String scheduleId, String title, String detail, String deadline, String clear) {
		Schedule s = new Schedule();
		
		s.setScheduleId(u.getUserNo());
		s.setScheduleNo(Integer.parseInt(scheduleId));
		s.setTitle(title);
		s.setDetail(detail);
		s.setDeadline(transformDate(deadline));
		s.setClear(clear);
		
		int result = new ScheduleService().updateSchedule(u, s, scheduleId);
		
		if(result > 0) {
			new Menu().displaySuccess("일정수정 완료!");
		} else {
			new Menu().displayFail("일정수정에 실패하였습니다.");
		}
	}
	
	public void deleteSchedule(String scheduleId) {
		int result = new ScheduleService().deleteSchedule(scheduleId);
		
		if(result > 0) {
			new Menu().displaySuccess("해당 일정이 삭제되었습니다.");
		} else {
			new Menu().displayFail("일정 삭제에 실패하였습니다.");
		}
		
	}
}
