package banking2;

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
		money = scanner.nextInt();
		mymoney += (mymoney * interest / 100) + money;
		
		

	}

	
}
