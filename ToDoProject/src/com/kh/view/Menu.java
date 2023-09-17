package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ScheduleController;
import com.kh.controller.UserController;
import com.kh.model.vo.Schedule;
import com.kh.model.vo.User;


public class Menu {
	
	private Scanner sc = new Scanner(System.in);
	
	private UserController uc = new UserController();
	private ScheduleController scr = new ScheduleController();
	
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("\n==일정 관리 프로그램==");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 프로그램 종료");
			
			System.out.print(">> 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1:{
					userLogin();
				}break;
				case 2:{
					inputUser();
				}break;
				case 0:{
					System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다");
				}return;
				default:{
					System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}
	}
	
	public void inputUser() {
		
		System.out.println("\n=== 회원 가입 ===");
		
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.print("나이 : ");
		String age = sc.nextLine();  // "20"
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("전화번호(-빼고입력) : ");
		String phone = sc.nextLine();
		
		uc.inputUser(userId, userPwd, userName, age, gender, email, phone);
	
	}
	
	public void userLogin() {
		
		System.out.print("\n아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("\n비밀번호 : ");
		String pw = sc.nextLine();
		
		 uc.userLogin(id, pw);
		
	}
	
	public void toDoMenu(User u) {
		
		while(true) {
			
			System.out.println("\n==To-Do Menu==");
			System.out.println("1. 일정 추가");
			System.out.println("2. 내 일정 조회");
			System.out.println("3. 일정 수정");
			System.out.println("4. 일정 삭제");
			System.out.println("5. 내 정보 수정");
			System.out.println("6. 내 정보 조회");
			System.out.println("7. 회원 탈퇴");
			System.out.println("0. 로그아웃");
			
			System.out.print(">> 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1:{
					insertToDo(u);
				}break;
				case 2:{
					scr.viewSchedule(u);
				}break;
				case 3:{
					
				}break;
				case 4:{
					
				}break;
				case 5:{
					
				}break;
				case 6:{
					
				}break;
				case 7:{
					
				}break;
				case 0:{
					System.out.println("메인 메뉴로 돌아갑니다.");
				}return;
				default:{
					System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}
	}
	
	public void insertToDo(User u) {
		System.out.println("\n=== 일정 등록 ===");
		
		System.out.print("일정 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("세부내용 : ");
		String detail = sc.nextLine();
		
		System.out.print("마감일(YY/MM/DD) : ");
		String deadline = sc.nextLine();
		
		scr.insertToDo(u, title, detail, deadline);
	}
	
	
	//-------------------------------응답화면----------------------------------
	
		/**
		 * 서비스 요청 처리 후 성공했을 경우 사용자가 보게될 응답 화면
		 * @param message : 객체별 성공 메세지
		 */
		public void displaySuccess(String message) {
			System.out.println("\n서비스 요청 성공 : " + message);
		}
		
		/**
		 * 서비스 요청 처리 후 실패했을 경우 사용자가 보게될 응답 화면
		 * @param message : 객체별 실패 메세지
		 */
		public void displayFail(String message) {
			System.out.println("\n서비스 요청 실패 : " + message);
		}
	
		public void loginSuccess(User u) {
			System.out.println("로그인 성공!");
			toDoMenu(u);
		}
		
		public void displayNoData(String message) {
			System.out.println("\n" + message);
		}
		
		
		public void displayScheduleList(ArrayList<Schedule> list) {
			System.out.println("\n조회된 데이터는 다음과 같습니다\n");
			
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			
				
		}
}