package banking1;

import java.util.Scanner;

class Account {
	Account[] myAccounts = new Account[50];
	int numOfAccounts;
	
	String acnumber;
	String name;
	int mymoney;
	
	public Account(String acnumber, String name, int mymoney) {
		this.acnumber = acnumber;
		this.name = name;
		this.mymoney = mymoney;
	}
	public Account() {
	}
	
	public void menuShow() {
		System.out.println("----------Menu---------");
		System.out.print("1.계좌 개설 ");
		System.out.print("2.입 금 ");
		System.out.println("3.출 금 ");
		System.out.print("4.계좌정보출력 ");
		System.out.print("5.프로그램종료 ");
	}
	
	
//	public void makeAccount() {
//		Scanner scanner = new Scanner(System.in);
//		String iAcnumber, iName;
//		int iMoney;
//		System.out.println("***신규계좌개설***");
//		System.out.print("계좌번호:");iAcnumber = scanner.nextLine();
//		System.out.print("고객이름:");iName = scanner.nextLine();
//		System.out.print("잔고:");iMoney = scanner.nextInt();
//		System.out.println("계좌개설이 완료되었습니다.");
//		Account make = new Account(iAcnumber, iName, iMoney);
//		myAccounts[numOfAccounts++] = make;
//		System.out.println("계좌갯수: " + numOfAccounts);
//		
//		System.out.println(iAcnumber);
//		System.out.println(iName);
//		System.out.println(iMoney);
//		System.out.println(acnumber);
//		
//		System.out.println(make.acnumber);
//		System.out.println(make.name);
//		System.out.println(make.mymoney);
//		
//	}
	public void makeAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호:");acnumber = scanner.nextLine();
		System.out.print("고객이름:");name = scanner.nextLine();
		System.out.print("잔고:");mymoney = scanner.nextInt();
		System.out.println("계좌개설이 완료되었습니다.");
		System.out.println("계좌갯수: " + numOfAccounts);
		
		System.out.println(acnumber);
		System.out.println(name);
		System.out.println(mymoney);
//		myAccounts[numOfAccounts++];
//		a
		
		
	}
	
	public void depositMoney() {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber;
		int iMoney;
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호:");iAcnumber = scanner.nextLine();
		System.out.print("입금액:");iMoney = scanner.nextInt();
		System.out.println("입금이 완료되었습니다.");
//		if(iAcnumber.compareTo(ma[acnumber])==0) {
			mymoney += iMoney;
//			System.out.println("일치합니다");
//			System.out.println(acnumber);
//			System.out.println(name);
//			System.out.println(mymoney);
//		} else {
//			System.out.println("불일치합니다");
//			System.out.println(acnumber);
//			System.out.println(name);
//			System.out.println(mymoney);
//		}
	}
//	public void withdrawMoney() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("***출 금***");
//		System.out.println("계좌번호와 출금할 금액을 입력하세요");
//		System.out.print("계좌번호:");numcode = scanner.nextLine();
//		System.out.print("출금액:");money = scanner.nextInt();
//		if(acnumber == numcode  && mymoney >= money) {
//			mymoney -= money;
//			System.out.println("일치합니다");
//			System.out.println("출금이 완료되었습니다.");
//		} else {
//			System.out.println("잔고가 부족합니다.");
//		}
//		
//	}
	public void showAccInfo() {
		for(int i=0 ; i<numOfAccounts ; i++) {
			myAccounts[i].showAccInfo();
		}
		System.out.println("계좌번호:" + acnumber);
		System.out.println("고객이름:" + name);
		System.out.println("잔고:" + mymoney);
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
	
	
	

}
