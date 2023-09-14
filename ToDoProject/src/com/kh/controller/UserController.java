package com.kh.controller;

import com.kh.model.service.UserService;
import com.kh.model.vo.User;
import com.kh.view.Menu;

public class UserController {
	
	public void inputUser(String userId, String userPwd, String userName, String age, String gender, String email, String phone) {
		
		User u = new User(userId, userPwd, userName, Integer.parseInt(age), gender, email, phone);
		
		int result = new UserService().inputUser(u);
		
		if(result > 0) {  // insert가 성공적으로 완료
			new Menu().displaySuccess("회원가입 완료!");
		} else {  // insert가 실패
			new Menu().displayFail("회원가입에 실패하였습니다.");
		}
		
	}
	
	public void userLogin(String id, String pw) {
		
		User u = new UserService().userLogin(id, pw);
		
		if(u != null) {
			if(u.getUserPw().equals(pw)) {
				new Menu().loginSuccess();
			} else {
				new Menu().displayFail("비밀번호가 틀립니다.");
			}
		} else {
			new Menu().displayFail("아이디가 없습니다.");
		}
		
			
			
	}	
}