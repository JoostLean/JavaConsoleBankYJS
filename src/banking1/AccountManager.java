package banking1;

import java.util.Scanner;

interface BankingSystemMainMenu {
	final int MAKE = 1;
	final int DEPOSIT = 2;
	final int WITHDRAW = 3;
	final int INQUIRE = 4;
	final int EXIT = 5;
}

public class AccountManager extends Account implements BankingSystemMainMenu {
	public AccountManager() {}
	public AccountManager(String accNum, String name, int balance) {
		super(accNum, name, balance);
	}
	static void showMenu() {
		System.out.println("-----Menu-----");
		System.out.print("1.계좌개설");
		System.out.print("   ");
		System.out.print("2.입금");
		System.out.print("   ");
		System.out.println("3.출금");
		System.out.print("4.계좌정보출력");
		System.out.print("  ");
		System.out.println("5.프로그램종료");
		System.out.print("선택:");
	}
	static void selectMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		showMenu();
		choice = scanner.nextInt();
		
		switch (choice) {
		case MAKE:
			System.out.println("***신규계좌개설***");
			Account.makeAccount();
			break;
		case DEPOSIT:
			System.out.println("*****입  금*****");
			selectMenu();
			break;
		case WITHDRAW:
			System.out.println("*****출  금*****");
			selectMenu();
			break;
		case INQUIRE:
			System.out.println("***계좌정보출력***");
			selectMenu();
			break;
		case EXIT:
			System.out.println("***프로그램종료***");
			System.out.println("프로그램이 종료되었습니다.");
			scanner.close();
			return;
		default:
			System.out.println("잘못 입력하셨습니다.");
			selectMenu();
			break;
		}
		scanner.close();
	}
}
