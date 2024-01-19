package banking1;

import java.util.Scanner;

public class JavaConsoleBankPSH {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();
		
		
		while(true) {
			account.menuShow();
			int choice = scanner.nextInt();
			switch(choice) {
			case BankMenu.MAKE:				
				account.makeAccount();
				break;
			case BankMenu.DEPOSIT:
				account.depositMoney();
				break;
//			case BankMenu.WITHDRAW:
//				account.withdrawMoney();
//				break;
			case BankMenu.INQUIRE:
				account.showAccInfo();
				break;
			case BankMenu.EXIT:
				System.out.println("프로그램을 종료합니다");
				return;
				
			}
		}
		
		

	}

}
