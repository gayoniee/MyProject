package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ScheduleService;
import com.kh.model.vo.Schedule;
import com.kh.model.vo.User;
import com.kh.view.Menu;

public class ScheduleController {

	public void insertToDo(User u, String title, String detail, String deadline) {
		
		Schedule s = new Schedule(title, detail, deadline);
		
		int result = new ScheduleService().insertToDo(u, s);
		
		if(result > 0) {  // insert가 성공적으로 완료
			new Menu().displaySuccess("일정등록 완료!");
		} else {  // insert가 실패
			new Menu().displayFail("일정등록에 실패하였습니다.");
		}
	}
	
	public void viewSchedule(User u) {
		ArrayList<Schedule> list = new ScheduleService().selectList(u);
		
		if(list.isEmpty()) {
			new Menu().displayNoData("전체 조회 결과가 없습니다.");
		} else {
			new Menu().displayScheduleList(list);
		}
	}

}
