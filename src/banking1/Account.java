package banking1;

import java.util.Scanner;

class Account {
	Account[] myAccounts = new Account[50];
	int numOfAccounts;
	String acnumber;
	String name;
	int money;
	
	public Account(String acnumber, String name, int money) {
		this.acnumber = acnumber;
		this.name = name;
		this.money = money;
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
	
	public void makeAccount() {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber, iName;
		int iMoney;
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호:");iAcnumber = scanner.nextLine();
		System.out.print("고객이름:");iName = scanner.nextLine();
		System.out.print("잔고:");iMoney = scanner.nextInt();
		System.out.println("계좌개설이 완료되었습니다.");
		Account account = new Account(iAcnumber, iName, iMoney);
		myAccounts[numOfAccounts++] = new Account(iAcnumber, iName, iMoney);
	}
	
	public void depositMoney() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호:");acnumber = scanner.nextLine();
		System.out.print("입금액:");money = scanner.nextInt();
		System.out.println("입금이 완료되었습니다.");
	}
	public void withdrawMoney() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호:");acnumber = scanner.nextLine();
		System.out.print("출금액:");money = scanner.nextInt();
		System.out.println("출금이 완료되었습니다.");
	}
	public void showAccInfo() {
		for(int i=0 ; i<numOfAccounts ; i++) {
			myAccounts[i].showAccInfo();
		}
		System.out.println("계좌번호:" + acnumber);
		System.out.println("고객이름:" + name);
		System.out.println("잔고:" + money);
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
	
	
	

}
