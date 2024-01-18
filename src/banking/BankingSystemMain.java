package banking;

import java.util.Scanner;
import banking.AccountManager;

interface BankingSystemMainMenu {
	final int MAKE = 1;
	final int DEPOSIT = 2;
	final int WITHDRAW = 3;
	final int INQUIRE = 4;
	final int EXIT = 5;
}

public class BankingSystemMain implements BankingSystemMainMenu {

	public static void main(String[] args) {
		BankingSystemHandler handler = new BankingSystemHandler();
		Scanner scanner = new Scanner(System.in);

		handler.showMenu();

		int choice = scanner.nextInt();
		switch (choice) {
			case MAKE:
				handler.makeAccount();
				break;
			case DEPOSIT:
				handler.depositMoney();
				break;
			case WITHDRAW:
				handler.withdrawMoney();
				break;
			case INQUIRE:
				handler.showAccInfo();
				break;
			case EXIT:
				System.out.println("***프로그램종료***");
				System.out.println("프로그램이 종료되었습니다.");
				break;
			default:
				System.out.println("메뉴를 선택해주세요.");
				handler.showMenu();
		}
	}
}

class BankingSystemHandler extends AccountManager {
	public BankingSystemHandler() {
		super();
	}
}
