package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

class HighCreditAccount extends Account {

	public int interest;
	public String creditRating;
	public HighCreditAccount(String acnumber, String name, 
			int mymoney, int interest, String creditRating) {
		super(acnumber, name, mymoney);
		this.interest = interest;
		this.creditRating = creditRating;
		
	}
	public HighCreditAccount() {
	}
	
	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("기본이자>" + interest +"%");
		System.out.println("신용등급>" + creditRating);
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
					if(creditRating.equals("A") || creditRating.equals("a")) {
						mymoney += (mymoney * interest / 100) + (mymoney * 0.07) + money;
						System.out.println("입금이 완료되었습니다.");
					} else if (creditRating.equals("B") || creditRating.equals("b")) {
						mymoney += (mymoney * interest / 100) + (mymoney * 0.04) + money;
						System.out.println("입금이 완료되었습니다.");
					} else if (creditRating.equals("C") || creditRating.equals("c")) {
						mymoney += (mymoney * interest / 100) + (mymoney * 0.02) + money;
						System.out.println("입금이 완료되었습니다.");
					} 
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
				} else if(mymoney < money){
					System.out.println("■ 잔고가 부족합니다. 금액전체를 출금할까요?");
					
				}
			} else {
				System.out.println("음수를 출금할 수 없습니다.");
			}
		} catch  (InputMismatchException e) {
			System.out.println("문자를 입력할 수 없습니다.");
		}
	}
}
