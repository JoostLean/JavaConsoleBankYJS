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
//		BankingSystemHandler handler = new BankingSystemHandler();
		Scanner scanner = new Scanner(System.in);

		menuSelect();

		int choice = scanner.nextInt();
		switch (choice) {
			case MAKE:
				System.out.println("***신규계좌개설***");
				break;
			case DEPOSIT:
				System.out.println("*****입  금*****");
				break;
			case WITHDRAW:
				System.out.println("*****출  금*****");
				break;
			case INQUIRE:
				System.out.println("***계좌정보출력***");
				break;
			case EXIT:
				System.out.println("***프로그램종료***");
				break;
			default:
				System.out.println("메뉴를 선택해주세요.");
				menuSelect();
		}
	}
	
	static void menuSelect() {
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
}

//class BankingSystemHandler extends AccountManager {
//	
//}
