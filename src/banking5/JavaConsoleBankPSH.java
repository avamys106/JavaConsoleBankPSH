package banking5;

import java.util.InputMismatchException;
import java.util.Scanner;

class choiceErrorException extends Exception {
	public choiceErrorException() {
		super("~~~");
	}
}

public class JavaConsoleBankPSH {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		AccountManager handler = new AccountManager();

		try {
			handler.readFriendInfo();
		} catch (NullPointerException e) {
		}

		
		while (true) {
			try {

				handler.menuShow();
				int choice = menuChoice();
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
				case BankMenu.DELETE:
					handler.deleteAccount();
					break;
				case BankMenu.EXIT:
					handler.saveAccountInfo();
					System.out.println("이용해 주셔서 감사합니다.");
					return;
				}
			} catch (choiceErrorException e) {
				System.out.println("1~6사이의 숫자를 입력해주세요.");
			} 
		}
	}

	public static int menuChoice() throws choiceErrorException {
		Scanner scanner = new Scanner(System.in);
		int inputChoice = 0;
		try {
			inputChoice = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("문자를 입력할 수 없습니다.");
			return inputChoice;
		}
		if (!(inputChoice >= 1 && inputChoice <= 6)) {
			choiceErrorException ex = new choiceErrorException();
			throw ex;
		}
		return inputChoice;
	}
}
