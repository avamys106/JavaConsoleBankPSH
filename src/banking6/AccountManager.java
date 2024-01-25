package banking6;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class AccountManager {

	HashSet<Account> AccountSet;

	void menuShow() {
		System.out.println("----------Menu---------");
		System.out.print("1.계좌개설 ");
		System.out.print("2.입 금 ");
		System.out.println("3.출 금 ");
		System.out.print("4.계좌정보출력 ");
		System.out.println("5.계좌정보삭제 ");
		System.out.print("6.저장옵션(미구현) ");
		System.out.println("7.프로그램종료 ");
		System.out.print("선택: ");
		System.out.println();
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

	void makeAccount(int choice) {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber, iName, cRating, choiceTxt;
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
			if (AccountSet.add(normal) == false) {
				System.out.println("중복계좌발견됨.");
				System.out.println("덮어쓸까요?(Y/N)");
				scanner.nextLine();
				choiceTxt = scanner.nextLine();
				if (choiceTxt.equals("Y") || choiceTxt.equals("y")) {
					AccountSet.remove(normal);
					AccountSet.add(normal);
					System.out.println("계좌를 덮어쓰기하였습니다.");
				} else if (choiceTxt.equals("N") || choiceTxt.equals("n")) {
					System.out.println("계좌 덮어쓰기를 취소합니다.");
				} else {
					System.out.println("Y또는 N키를 눌러 진행하십시오.");
				}
			} else {
				System.out.println("계좌개설이 완료되었습니다.");
			}
		} else if (choice == 2) {
			System.out.println("보통계좌선택.");
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
			if (AccountSet.add(high) == false) {
				System.out.println("중복계좌발견됨.");
				System.out.println("덮어쓸까요?(Y/N)");
				scanner.nextLine();
				choiceTxt = scanner.nextLine();
				if (choiceTxt.equals("Y") || choiceTxt.equals("y")) {
					AccountSet.remove(high);
					AccountSet.add(high);
					System.out.println("계좌를 덮어쓰기하였습니다.");
				} else if (choiceTxt.equals("N") || choiceTxt.equals("n")) {
					System.out.println("계좌 덮어쓰기를 취소합니다.");
				} else {
					System.out.println("Y또는 N키를 눌러 진행하십시오.");
				}
			} else {
				System.out.println("계좌개설이 완료되었습니다.");
			}
		}
	}

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

	void withdrawMoney() {
		Scanner scanner = new Scanner(System.in);
		String iAcnumber;
		int money;
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호:");
		iAcnumber = scanner.nextLine();
		Iterator<Account> it = AccountSet.iterator();
		while (it.hasNext()) {
			Account item = it.next();
			if (iAcnumber.equals(item.acnumber)) {
				item.withdrawCalculation();
			}
		}
	}

	void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("--------------");
		for (Account ar : AccountSet) {
			ar.showAccountInfo();
			System.out.println("--------------");
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}

	void deleteAccount() {
		Scanner scanner = new Scanner(System.in);
		String deleteNum;
		System.out.println("삭제할 계좌번호를 입력하세요:");
		deleteNum = scanner.nextLine();
		Iterator<Account> it = AccountSet.iterator();
		while (it.hasNext()) {
			Account item = it.next();
			if (deleteNum.equals(item.acnumber)) {
				AccountSet.remove(item);
				System.out.println("계좌번호가 삭제되었습니다.");
			}
		}
	}

	public void saveAccountInfo() {
		try {
			ObjectOutputStream out = new ObjectOutputStream
					(new FileOutputStream("src/banking6/AccountInfo.obj"));
			for (Account ar : AccountSet) {
				out.writeObject(ar);
			}
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readFriendInfo() {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream (
					new FileInputStream("src/banking6/AccountInfo.obj"));
			while(true) {
				Account ar = (Account)in.readObject();
				AccountSet.add(ar);
			}
		}catch (FileNotFoundException e) {
			System.out.println("AccountInfo.Obj 파일없음");
		}
		catch (EOFException e) {
			System.out.println("AccountInfo.Obj 복원완료.");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("알 수 없는 예외발생");
		}
		finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}