package com.kh.controller;

import com.kh.model.service.ScheduleService;
import com.kh.model.vo.Schedule;
import com.kh.view.Menu;

public class ScheduleController {

	public void insertToDo(String schedulNo, String title, String detail, String deadline, String clear) {
		
		Schedule s = new Schedule(Integer.parseInt(schedulNo), title, detail, deadline, clear);
		
		int result = new ScheduleService().insertToDo(s);
		
		if(result > 0) {  // insert가 성공적으로 완료
			new Menu().displaySuccess("일정등록 완료!");
		} else {  // insert가 실패
			new Menu().displayFail("일정등록에 실패하였습니다.");
		}
	}

}
