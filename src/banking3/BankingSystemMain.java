package banking3;

import java.util.Scanner;

public class BankingSystemMain extends AccountManager implements ICustomDefine {

	public static void main(String[] args) {
		AccountManager accManager = new AccountManager();
		Scanner sc = new Scanner(System.in);
		while(true) {
			accManager.showMenu();
			int choice = readCount();
//			choice = sc.nextInt();
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
				break;
			}
		}
	}
	
	public static int readCount() {
		Scanner sc = new Scanner(System.in);
		int inputChoice = 0;
		try {
			inputChoice = sc.nextInt();
			if(inputChoice<0 || inputChoice>7) {
				MenuException ex = new MenuException();
				throw ex;
			}
		}
		catch(MenuException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return inputChoice;
	}
}

class MenuException extends Exception {
	public MenuException() {
		super("사용가능한 메뉴를 입력해주세요.");
	}
}
