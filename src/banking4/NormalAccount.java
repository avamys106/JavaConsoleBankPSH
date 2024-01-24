package banking4;

import java.util.InputMismatchException;
import java.util.Scanner;

class NormalAccount extends Account {

	public int interest;
	
	public NormalAccount() {
	}
	
	public NormalAccount(String acnumber, String name, 
			int mymoney, int interest) {
		super(acnumber, name, mymoney);
		this.interest = interest;
	}


	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("기본이자>" + interest +"%");
	}
	
	@Override
	public int hashCode() {
		return super.acnumber.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		NormalAccount nObj = (NormalAccount) obj;
		if(nObj.acnumber.equals(super.acnumber)) {
			System.out.println("일치함");
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void accountCreate() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("보통계좌선택.");
		System.out.print("계좌번호: ");
		acnumber = scanner.nextLine();
		System.out.print("고객이름: ");
		name = scanner.nextLine();
		System.out.print("잔고: ");
		mymoney = scanner.nextInt();
		System.out.print("기본이자%(정수형태로입력): ");
		interest = scanner.nextInt();

	}
	
	@Override
	public void interestCalculation() {
		Scanner scanner = new Scanner(System.in);
		int money;
		System.out.print("입금액:");
		try {
			money = scanner.nextInt();
			if(money > 0) {
				if(money % 500 == 0) {
					mymoney += (mymoney * interest / 100) + money;
					System.out.println("입금이 완료되었습니다.");
				} else {  
					System.out.println("500원 단위로 입금하실수 있습니다.");
				}
			} else {
				System.out.println("음수를 입금할 수 없습니다.");
			}
		} catch (InputMismatchException e) {
			System.out.println("문자를 입력할 수 없습니다.");
		}
	}
	
	@Override
	public void withdrawCalculation() {
		Scanner scanner = new Scanner(System.in);
		int money;
		System.out.print("출금액:");
		try {
			money = scanner.nextInt();
			if(money > 0) {
				if(mymoney >= money) {
					if(money % 1000 == 0) {
						mymoney -= money;
						System.out.println("출금이 완료되었습니다.");
					} else {
						System.out.println("1,000원 단위로 출금하실수 있습니다.");
					}
				} else {
					System.out.println("잔액이 부족 합니다.");
				}
			} else {
				System.out.println("음수를 출금할 수 없습니다.");
			}
		} catch (InputMismatchException e) {
			System.out.println("문자를 입력할 수 없습니다.");
		}
	}
}


