package banking;

import java.util.Scanner;

interface BankingSystemMainMenu {
	final int MAKE = 1;
	final int DEPOSIT = 2;
	final int WITHDRAW = 3;
	final int INQUIRE = 4;
	final int EXIT = 5;
}

/* 화면 기능 */

public class BankingSystemMain implements BankingSystemMainMenu {

	public static void main(String[] args) {
		selectMenu();
//		AccountManager accountManager = new AccountManager();
//		Scanner scanner = new Scanner(System.in);
//		
//		showMenu();
//		int choice;
//		choice = scanner.nextInt();
//		switch (choice) {
//		case MAKE:
//			makeAccount(accountManager, scanner);
//			break;
//		case DEPOSIT:
//			depositMoney();
//			break;
//		case WITHDRAW:
//			withdrawMoney();
//			break;
//		case INQUIRE:
//			showAccInfo(accountManager);
//			break;
//		case EXIT:
//			System.out.println("***프로그램종료***");
//			System.out.println("프로그램이 종료되었습니다.");
//			break;
//		default:
//			System.out.println("다시 입력해주세요.");
//			showMenu();
//			break;
//		}
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
		AccountManager accountManager = new AccountManager();
		Scanner scanner = new Scanner(System.in);
		
		int choice;
		do {
			showMenu();
			choice = scanner.nextInt();
			
			switch (choice) {
			case MAKE:
				makeAccount(accountManager, scanner);
				break;
			case DEPOSIT:
				depositMoney(accountManager, scanner);
				break;
			case WITHDRAW:
				withdrawMoney(accountManager, scanner);
				break;
			case INQUIRE:
				showAccInfo(accountManager);
				break;
			case EXIT:
				System.out.println("***프로그램종료***");
				System.out.println("프로그램이 종료되었습니다.");
				return;
			default:
				System.out.println("다시 입력해주세요.");
				selectMenu();
				break;
			}
		}
		while(choice<6);
	}
	static void makeAccount(AccountManager accountManager, Scanner scanner) {
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호 : ");
		String accNum = scanner.next();
		System.out.print("고객이름 : ");
		String name = scanner.next();
		System.out.print("잔고 : ");
		int balance = scanner.nextInt();

		accountManager.makeAccount(accNum, name, balance);
		System.out.println("계좌개설이 완료되었습니다.");
		
		selectMenu();	
	}
	static void depositMoney(AccountManager accountManager, Scanner scanner) {
		System.out.println("*****입  금*****");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.println("계좌번호:");
		System.out.println("입금액:");
		System.out.println("입금이 완료되었습니다.");
		selectMenu();
	}
	static void withdrawMoney(AccountManager accountManager, Scanner scanner) {
		System.out.println("*****출  금*****");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.println("계좌번호:");
		System.out.println("입금액:");
		System.out.println("출금이 완료되었습니다.");
		selectMenu();
	}
	static void showAccInfo(AccountManager acc) {
		System.out.println("***계좌정보출력***");
		acc.showAccount();
		System.out.println("-------------");
		System.out.println("계좌번호 : ");
		System.out.println("고객이름 : ");
		System.out.println("잔고 : ");
		System.out.println("-------------");
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
		selectMenu();
	}
}