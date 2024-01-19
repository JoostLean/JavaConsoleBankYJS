package banking2;

import java.util.Scanner;

public class BankingSystemMain extends AccountManager implements ICustomDefine {

	public static void main(String[] args) {
		AccountManager accManager = new AccountManager();
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true) {
			accManager.showMenu();
			choice = sc.nextInt();
			switch (choice) {
			case MAKE:
				accManager.makeAccount();
				break;
			case DEPOSIT:
				accManager.deposit();
				break;
			case WITHDRAW:
				accManager.withdraw();
				break;
			case INQUIRE:
				accManager.showAccount();
				break;
			case EXIT:
				return;
			default:
				System.out.println("메뉴를 선택해주세요.");
				break;
			}
		}
	}
}