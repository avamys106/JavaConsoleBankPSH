package banking1;

import java.util.Scanner;

public class JavaConsoleBankPSH {

	static Account[] myAccounts = new Account[50];
	static int numOfAccounts;

	static void menuShow() {
		System.out.println("----------Menu---------");
		System.out.print("1.계좌 개설 ");
		System.out.print("2.입 금 ");
		System.out.println("3.출 금 ");
		System.out.print("4.계좌정보출력 ");
		System.out.print("5.프로그램종료 ");
	}

	static void makeAccount() {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber;
		String iName;
		int iMoney;
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호: ");
		iAcnumber = scanner.nextLine();
		System.out.print("고객이름: ");
		iName = scanner.nextLine();
		System.out.print("잔고: ");
		iMoney = scanner.nextInt();
		System.out.println("계좌개설이 완료되었습니다.");
		Account make = new Account(iAcnumber, iName, iMoney);
		myAccounts[numOfAccounts++] = make;
		System.out.println();

	}

	static void depositMoney() {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber;
		int money;
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호: ");
		iAcnumber = scanner.nextLine();
		System.out.print("입금액: ");
		money = scanner.nextInt();
		for (int i=0 ; i<numOfAccounts ; i++) {
			if(iAcnumber.compareTo(myAccounts[i].acnumber)==0) {
				myAccounts[i].mymoney += money;
				System.out.println("입금이 완료되었습니다.");
			} else {
				System.out.println("계좌번호를 확인해주세요.");
			}
		}
	}

	static void withdrawMoney() {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber;
		int money;
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호: ");
		iAcnumber = scanner.nextLine();
		System.out.print("출금액: ");
		money = scanner.nextInt();
		for (int i=0 ; i<numOfAccounts ; i++) {
			if(iAcnumber.compareTo(myAccounts[i].acnumber)==0) {
				if(myAccounts[i].mymoney >= money) {
					myAccounts[i].mymoney -= money;
					System.out.println("출금이 완료되었습니다.");
				} else {
					System.out.println("잔액이 부족 합니다.");
				}
			} else {
				System.out.println("계좌번호를 확인해주세요.");
			}
		}
	}
	
	static void showAccInfo() {
		System.out.println("***계좌정보출력***");
		for (int i = 0; i < numOfAccounts; i++) {
			System.out.println("--------------");
			System.out.println("계좌번호: " + myAccounts[i].acnumber);
			System.out.println("고객명: " + myAccounts[i].name);
			System.out.println("잔고: " + myAccounts[i].mymoney);
			System.out.println("--------------");
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			menuShow();
			int choice = scanner.nextInt();
			switch (choice) {
			case BankMenu.MAKE:
				makeAccount();
				break;
			case BankMenu.DEPOSIT:
				depositMoney();
				break;
			case BankMenu.WITHDRAW:
				withdrawMoney();
				break;
			case BankMenu.INQUIRE:
				showAccInfo();
				break;
			case BankMenu.EXIT:
				System.out.println("이용해 주셔서 감사합니다.");
				return;
			}
		}

	}

}
