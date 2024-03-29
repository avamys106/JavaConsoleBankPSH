package banking2;

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
		System.out.print("입금액:");
		int money;
		money = scanner.nextInt();
		if(creditRating.equals("A") || creditRating.equals("a")) {
			mymoney += (mymoney * interest / 100) + (mymoney * 0.07) + money;
		} else if (creditRating.equals("B") || creditRating.equals("b")) {
			mymoney += (mymoney * interest / 100) + (mymoney * 0.04) + money;
		} else if (creditRating.equals("C") || creditRating.equals("c")) {
			mymoney += (mymoney * interest / 100) + (mymoney * 0.02) + money;
		} 
	}
	
}

//void showAccInfo() {
//	System.out.println("***계좌정보출력***");
//	System.out.println("--------------");
//	for (int i = 0; i < numOfAccounts; i++) {
//		if(myAccounts[i] instanceof NormalAccount) {
//			((NormalAccount)myAccounts[i]).showAccountInfo();
//		} else if (myAccounts[i] instanceof HighCreditAccount) {
//			((HighCreditAccount)myAccounts[i]).showAccountInfo();
//		}
//		System.out.println("--------------");
//	}
//	System.out.println("전체계좌정보 출력이 완료되었습니다.");
//
//}

//void depositMoney() {
//	Scanner scanner = new Scanner(System.in);
//	String iAcnumber;
//	int money;
//	System.out.println("***입 금***");
//	System.out.println("계좌번호와 입금할 금액을 입력하세요");
//	System.out.print("계좌번호: ");
//	iAcnumber = scanner.nextLine();
//	System.out.print("입금액: ");
//	money = scanner.nextInt();
//	for (int i=0 ; i<numOfAccounts ; i++) {
//		if(iAcnumber.compareTo(myAccounts[i].acnumber)==0) {
//			myAccounts[i].mymoney += money;
//			System.out.println("입금이 완료되었습니다.");
//			System.out.println(myAccounts[i]);
//		} else {
//			System.out.println("계좌번호를 확인해주세요.");
//		}
//	}
//}