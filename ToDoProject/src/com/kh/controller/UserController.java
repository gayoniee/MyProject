package com.kh.controller;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
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
				new Menu().loginSuccess(u);
			} else {
				new Menu().displayFail("비밀번호가 틀립니다.");
			}
		} else {
			new Menu().displayFail("아이디가 없습니다.");
		}
				
	}	
	
	public void updateUser(User u, String userPw, String userName, String email, String phone) {
		
		User user = new User();
		
		user.setUserPw(userPw);
		user.setUserName(userName);
		user.setEmail(email);
		user.setPhone(phone);
		
		int result = new UserService().updateUser(u, user);
		
		if(result > 0) {
			new Menu().displaySuccess("내 정보가 수정되었습니다.");
		} else {
			new Menu().displayFail("정보 수정에 실패하였습니다.");
		}	
	}
	
	public void deleteUser(User u) {
		
		int result = new UserService().deleteUser(u);
		
		if(result > 0) {
			new Menu().deleteSuccess("회원탈퇴되었습니다. 메인메뉴로 돌아갑니다.");
		} else {
			new Menu().displayFail("회원탈퇴에 실패하였습니다.");
		}
	}
		
	
	
}
