package banking4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class AccountManager {

	HashSet<Account> AccountSet;
	NormalAccount nAccount = new NormalAccount();
	HighCreditAccount hcAccount = new HighCreditAccount();

	void menuShow() {
		System.out.println("----------Menu---------");
		System.out.print("1.계좌 개설 ");
		System.out.print("2.입 금 ");
		System.out.println("3.출 금 ");
		System.out.print("4.계좌정보출력 ");
		System.out.println("5.프로그램종료 ");
		System.out.print("선택: ");
		System.out.println();
//		System.out.println(nAccount);
//		System.out.println(AccountSet);

	}

	public AccountManager() {
		AccountSet = new HashSet<Account>();
	}

	void accountShow() {
		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
	}

//	void makeAccount(int choice) {
//		Scanner scanner = new Scanner(System.in);
//		String iAcnumber, choiceTxt;
//		if (choice == 1) {
//			System.out.println("보통계좌선택.");
//			System.out.print("계좌번호: ");
//			iAcnumber = scanner.nextLine();
//			Iterator<Account> it = AccountSet.iterator();
//			while (it.hasNext()) {
//				Account item = it.next();
//				if (iAcnumber.equals(item.acnumber)) {
//					System.out.println("중복계좌발견됨.");
//					System.out.println("덮어쓸까요?(Y/N)");
//					choiceTxt = scanner.nextLine();
//					if (choiceTxt.equals("Y") || choiceTxt.equals("y")) {
//						System.out.println("계좌를 덮어쓰기합니다.");
//					} else if (choiceTxt.equals("N") || choiceTxt.equals("n")) {
//						System.out.println("계좌를 덮어쓰기를 취소합니다.");
//					} else {
//						System.out.println("Y또는 N키를 눌러 진행하십시오.");
//					}
//
//				} else if (!(iAcnumber.equals(item.acnumber))) {
//					nAccount.accountCreate();
//					AccountSet.add(nAccount);
//				}
//			}
//			
//
//		} else if (choice == 2) {
//			System.out.println("신용신뢰계좌선택.");
//			System.out.print("계좌번호: ");
//			iAcnumber = scanner.nextLine();
//			hcAccount.accountCreate();
//			AccountSet.add(hcAccount);
//		}
//	}
	void makeAccount(int choice) {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber, iName, cRating, choiceTxt;
		int iMoney, mInterest;
		
		if (choice == 1) {
			nAccount.accountCreate();
//			System.out.println("보통계좌선택.");
//			System.out.print("계좌번호: ");
//			iAcnumber = scanner.nextLine();
//			System.out.print("고객이름: ");
//			iName = scanner.nextLine();
//			System.out.print("잔고: ");
//			iMoney = scanner.nextInt();
//			System.out.print("기본이자%(정수형태로입력): ");
//			mInterest = scanner.nextInt();
//			NormalAccount normal = new NormalAccount(iAcnumber, iName, iMoney, mInterest);
//			AccountSet.add(normal);
			if(AccountSet.contains(nAccount)) {
				System.out.println("중복계좌발견됨.");
				System.out.println("덮어쓸까요?(Y/N)");
				choiceTxt = scanner.nextLine();
				if(choiceTxt.equals("Y") || choiceTxt.equals("y")) {
					System.out.println("계좌를 덮어쓰기하였습니다.");
					AccountSet.add(nAccount);
//					AccountSet.add(normal);
				} else if( choiceTxt.equals("N") || choiceTxt.equals("n")) {
					System.out.println("취소합니다.");
				}
			} else {
				AccountSet.add(nAccount);
//				AccountSet.add(normal);
				System.out.println("계좌개설이 완료되었습니다.");
				System.out.println();
			}
		} else if (choice == 2) {
			hcAccount.accountCreate();
			AccountSet.add(hcAccount);
		}
	}
//	void makeAccount(int choice) {
//		Scanner scanner = new Scanner(System.in);
//		String iAcnumber, choiceTxt;
//		if (choice == 1) {
//			nAccount.accountCreate();
//			Iterator<Account> it = AccountSet.iterator();
//			while (it.hasNext()) {
//				Account item = it.next();
//				if (AccountSet.equals(item.acnumber)) {
//					System.out.println("중복계좌발견됨.");
//					System.out.println("덮어쓸까요?(Y/N)");
//					choiceTxt = scanner.nextLine();
//					if (choiceTxt.equals("Y")) {
//						AccountSet.add(nAccount);
//					}
//				} else {
//					AccountSet.add(nAccount);
//				}
//			}
//		}
//	}
//	void makeAccount(int choice) {
//		Scanner scanner = new Scanner(System.in);
//		String iAcnumber, choiceTxt;
//		Iterator<Account> it = AccountSet.iterator();
//
//		if (choice == 1) {
//			nAccount.accountCreate();
//				if (AccountSet.contains(nAccount)) {
//					System.out.println("중복계좌 발견됨. 덮어쓸까요?(Y/N)");
//					choiceTxt = scanner.nextLine();
//					if (choiceTxt.equals("Y") || choiceTxt.equals("y")) {
//						System.out.println("계좌를 재설정합니다.");
//					} else if (choiceTxt.equals("N") || choiceTxt.equals("n")) {
//						System.out.println("덮어쓰기를 취소합니다.");
//						return;
//					} else if (!(choiceTxt.equals("N") || choiceTxt.equals("n") || choiceTxt.equals("Y")
//							|| choiceTxt.equals("y"))) {
//						System.out.println("Y또는 N키를 눌러 진행하십시오.");
//						return;
//					}
//				} else {
//					AccountSet.add(nAccount);
//					System.out.println("계좌개설이 완료되었습니다.");
//					System.out.println();
//				}
//				AccountSet.add(nAccount);
//				System.out.println("계좌개설이 완료되었습니다.");
//				System.out.println();
//		} else if (choice == 2) {
//			hcAccount.accountCreate();
//			AccountSet.add(hcAccount);
//		}
//	}

//	void makeAccount(int choice) {
//		Scanner scanner = new Scanner(System.in);
//		String iAcnumber, iName, cRating, choiceTxt;
//		int iMoney, mInterest;
//		Iterator<Account> it = AccountSet.iterator();
//		if (choice == 1) {
//			System.out.println("보통계좌선택.");
//			System.out.print("계좌번호: ");
//			iAcnumber = scanner.nextLine();
//			System.out.print("고객이름: ");
//			iName = scanner.nextLine();
//			System.out.print("잔고: ");
//			iMoney = scanner.nextInt();
//			System.out.print("기본이자%(정수형태로입력): ");
//			mInterest = scanner.nextInt();
//			NormalAccount normal = new NormalAccount(iAcnumber, iName, iMoney, mInterest);
//			AccountSet.add(normal);
//			System.out.println("계좌개설이 완료되었습니다.");
//			System.out.println();
//			
//			while (it.hasNext()) {
//				Account item = it.next();
//				if (iAcnumber.equals(item.acnumber)) {
//					System.out.println("중복계좌가 발견되었습니다.");
//					System.out.println("덮어쓸까요? (Y/N)");
//					choiceTxt = scanner.nextLine();
//					if(choiceTxt.equals("Y") || choiceTxt.equals("y")) {
//						System.out.println("기존 계좌를 덮어쓰기 하였습니다.");
//					} else if(choiceTxt.equals("N") || choiceTxt.equals("N")) {
//						System.out.println("기존의 정보를 유지합니다.");
//					}
//				}
//			}
//
//
//
//
//		} else if (choice == 2) {
//			System.out.println("신용신뢰계좌선택.");
//			System.out.print("계좌번호: ");
//			iAcnumber = scanner.nextLine();
//			System.out.print("고객이름: ");
//			iName = scanner.nextLine();
//			System.out.print("잔고: ");
//			iMoney = scanner.nextInt();
//			System.out.print("기본이자%(정수형태로입력): ");
//			mInterest = scanner.nextInt();
//			scanner.nextLine();
//			System.out.print("신용등급(A,B,C등급): ");
//			cRating = scanner.nextLine();
//			HighCreditAccount high = new HighCreditAccount(iAcnumber, iName, iMoney, mInterest, cRating);
//			AccountSet.add(high);
//			System.out.println("계좌개설이 완료되었습니다.");
//			System.out.println();
//		}
//	}

	void depositMoney() {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber;
		int money;

		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호:");
		iAcnumber = scanner.nextLine();
		Iterator<Account> it = AccountSet.iterator();
		while (it.hasNext()) {
			Account item = it.next();
			if (iAcnumber.equals(item.acnumber)) {
				item.interestCalculation();
			} else {

			}
		}
	}

//	void withdrawMoney() {
//		Scanner scanner = new Scanner(System.in);
//		String iAcnumber;
//		int money;
//		System.out.println("***출 금***");
//		System.out.println("계좌번호와 출금할 금액을 입력하세요");
//		System.out.print("계좌번호:");
//		iAcnumber = scanner.nextLine();
//		for (int i = 0; i < numOfAccounts; i++) {
//			if (iAcnumber.compareTo(myAccounts[i].acnumber) == 0
//					&& myAccounts[i] instanceof NormalAccount) {
//				((NormalAccount)myAccounts[i]).withdrawCalculation();
//			} else if (iAcnumber.compareTo(myAccounts[i].acnumber) == 0
//					&& myAccounts[i] instanceof HighCreditAccount) {
//				((HighCreditAccount)myAccounts[i]).withdrawCalculation();
//			} 
//		}
//	}
//
	void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("--------------");
		System.out.println(AccountSet.size());
		for (Account ar : AccountSet) {
			System.out.println("주소값" + ar);
			System.out.println("해시코드" + ar.hashCode());
			nAccount.showAccountInfo();
//			hcAccount.showAccountInfo();
			System.out.println("전체 계좌 개수" + AccountSet.size());
			System.out.println("--------------");
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
		Iterator<Account> it = AccountSet.iterator();
		while (it.hasNext()) {
			Account item = it.next();
			System.out.println(item);
//			System.out.println(nAccount);
//			System.out.println("메인해쉬코드" + item.hashCode());
//			System.out.println("노말해쉬코드" + nAccount.hashCode());
		}

	}

}
