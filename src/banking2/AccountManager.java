package banking2;

import java.util.Scanner;

class AccountManager {

	Account[] myAccounts = new Account[50];
	int numOfAccounts;
	NormalAccount nAccount = new NormalAccount();
	HighCreditAccount hcAccount = new HighCreditAccount();

	void menuShow() {
		System.out.println("----------Menu---------");
		System.out.print("1.계좌 개설 ");
		System.out.print("2.입 금 ");
		System.out.println("3.출 금 ");
		System.out.print("4.계좌정보출력 ");
		System.out.print("5.프로그램종료 ");
	}

	public AccountManager() {
//		myAccounts = new Account[];
//		numOfAccounts = 0;
	}

	void accountShow() {
		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
	}

	void makeAccount(int choice) {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber, iName, cRating;
		int iMoney, mInterest;
		if (choice == 1) {
			System.out.println("보통계좌선택.");
			System.out.print("계좌번호: ");
			iAcnumber = scanner.nextLine();
			System.out.print("고객이름: ");
			iName = scanner.nextLine();
			System.out.print("잔고: ");
			iMoney = scanner.nextInt();
			System.out.print("기본이자%(정수형태로입력): ");
			mInterest = scanner.nextInt();
			NormalAccount normal = new NormalAccount(iAcnumber, iName, iMoney, mInterest);
			myAccounts[numOfAccounts++] = normal;
			System.out.println("계좌개설이 완료되었습니다.");
			System.out.println();
		} else if (choice == 2) {
			System.out.println("신용신뢰계좌선택.");
			System.out.print("계좌번호: ");
			iAcnumber = scanner.nextLine();
			System.out.print("고객이름: ");
			iName = scanner.nextLine();
			System.out.print("잔고: ");
			iMoney = scanner.nextInt();
			System.out.print("기본이자%(정수형태로입력): ");
			mInterest = scanner.nextInt();
			scanner.nextLine();
			System.out.print("신용등급(A,B,C등급): ");
			cRating = scanner.nextLine();
			HighCreditAccount high = new HighCreditAccount(iAcnumber, iName, iMoney, mInterest, cRating);
			myAccounts[numOfAccounts++] = high;
			System.out.println("계좌개설이 완료되었습니다.");
			System.out.println();
		}
	}

	void depositMoney() {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber;
		int money;

		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호: ");
		iAcnumber = scanner.nextLine();
		System.out.print("입금액: ");
		money = scanner.nextInt();
		for (int i = 0; i < numOfAccounts; i++) {
			if (iAcnumber.compareTo(myAccounts[i].acnumber) == 0 
					&& myAccounts[i] instanceof NormalAccount) {
				myAccounts[i].mymoney += (myAccounts[i].mymoney * nAccount.interest / 100) + money;
			} else if (iAcnumber.compareTo(myAccounts[i].acnumber) == 0 
					&& myAccounts[i] instanceof HighCreditAccount) {
				System.out.println(hcAccount.creditRating);
				myAccounts[i].mymoney += money;
//				if (hcAccount.equals(myAccounts[i])) {
//					System.out.println("true");
//					myAccounts[i].mymoney += money;
//				}
			}
		}

	}


	void withdrawMoney() {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber;
		int money;
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호: ");
		iAcnumber = scanner.nextLine();
		System.out.print("출금액: ");
		money = scanner.nextInt();
		for (int i = 0; i < numOfAccounts; i++) {
			if (iAcnumber.compareTo(myAccounts[i].acnumber) == 0) {
				if (myAccounts[i].mymoney >= money) {
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

	void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("--------------");
		for (int i = 0; i < numOfAccounts; i++) {
			if (myAccounts[i] instanceof NormalAccount) {
				((NormalAccount) myAccounts[i]).showAccountInfo();
				System.out.println(myAccounts[i].mymoney);
				System.out.println(nAccount.interest);
			} else if (myAccounts[i] instanceof HighCreditAccount) {
				((HighCreditAccount) myAccounts[i]).showAccountInfo();
				System.out.println(myAccounts[i].mymoney);
				System.out.println(hcAccount.interest);
				System.out.println(hcAccount.creditRating);
			}
			System.out.println("--------------");
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");

	}

}
