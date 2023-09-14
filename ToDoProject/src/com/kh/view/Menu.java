package com.kh.view;

import java.util.Scanner;

import com.kh.controller.UserController;


public class Menu {
	
	private Scanner sc = new Scanner(System.in);
	
	private UserController uc = new UserController();
	
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
	
		public void loginSuccess() {
			System.out.println("로그인 성공!");
		}
}