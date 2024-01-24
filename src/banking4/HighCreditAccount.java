package banking4;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class HighCreditAccount extends Account {

	public int interest;
	public String creditRating;

	public HighCreditAccount(String acnumber, String name, int mymoney, int interest, String creditRating) {
		super(acnumber, name, mymoney);
		this.interest = interest;
		this.creditRating = creditRating;

	}

	public HighCreditAccount() {
	}

	@Override
	public void accountCreate() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("신용신뢰계좌선택.");
		System.out.print("계좌번호: ");
		acnumber = scanner.nextLine();
		System.out.print("고객이름: ");
		name = scanner.nextLine();
		System.out.print("잔고: ");
		mymoney = scanner.nextInt();
		System.out.print("기본이자%(정수형태로입력): ");
		interest = scanner.nextInt();
		scanner.nextLine();
		System.out.print("신용등급(A,B,C등급): ");
		creditRating = scanner.nextLine();
		System.out.println("계좌개설이 완료되었습니다.");
		System.out.println();
	}
	
	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("기본이자>" + interest + "%");
		System.out.println("신용등급>" + creditRating);
	}

	@Override
	public void interestCalculation() {
		Scanner scanner = new Scanner(System.in);
		int money;
		System.out.print("입금액:");
		try {
			money = scanner.nextInt();
			if (money > 0) {
				if (money % 500 == 0) {
					if (creditRating.equals("A") || creditRating.equals("a")) {
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
			if (money > 0) {
				if (mymoney >= money) {
					if (money % 1000 == 0) {
						mymoney -= money;
						System.out.println("출금이 완료되었습니다.");
					} else {
						System.out.println("1,000원 단위로 출금하실수 있습니다.");
					}
				} else if (mymoney < money) {
					String choiceTxt;
					String y1 = "Y";
					String y2 = "y";
					String n1 = "N";
					String n2 = "n";
					
					System.out.println("■ 잔고가 부족합니다. 금액전체를 출금할까요?(Y/N)");
					System.out.println("- YES(Y): 금액전체 출금처리");
					System.out.println("- NO(N): 출금요청취소");
					choiceTxt = scanner.next();
					if (choiceTxt.equals(y1) || choiceTxt.equals(y2)) {
						mymoney = 0;
						System.out.println("금액전체를 출금했습니다.");
						System.out.println("잔고: " + mymoney);
					} else if (choiceTxt.equals(n1) || choiceTxt.equals(n2)) {
						System.out.println("출금요청을 취소하셨습니다.");
					} else {
						System.out.println("Y 또는 N키를 눌러 진행하십시오");
					}
				}
			} else {
				System.out.println("음수를 출금할 수 없습니다.");
			}
		} catch (InputMismatchException e) {
			System.out.println("문자를 입력할 수 없습니다.");
		}
	}
}
