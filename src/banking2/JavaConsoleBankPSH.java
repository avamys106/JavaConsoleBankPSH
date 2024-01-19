package banking2;

import java.util.Scanner;

public class JavaConsoleBankPSH {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		AccountManager handler = new AccountManager();
		
		while (true) {
			handler.menuShow();
			int choice = scanner.nextInt();
			switch (choice) {
			case BankMenu.MAKE:
				handler.accountShow();
				int AccountChoice = scanner.nextInt();
				handler.makeAccount(AccountChoice);
				break;
			case BankMenu.DEPOSIT:
				handler.depositMoney();
				break;
			case BankMenu.WITHDRAW:
				handler.withdrawMoney();
				break;
			case BankMenu.INQUIRE:
				handler.showAccInfo();
				break;
			case BankMenu.EXIT:
				System.out.println("이용해 주셔서 감사합니다.");
				return;
			}
		}

	}

}
