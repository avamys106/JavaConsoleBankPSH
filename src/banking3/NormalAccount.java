package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

class NormalAccount extends Account {

	public int interest;

	public NormalAccount(String acnumber, String name, 
			int mymoney, int interest) {
		super(acnumber, name, mymoney);
		this.interest = interest;
	}
	public NormalAccount() {
	}

	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("기본이자>" + interest +"%");
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


