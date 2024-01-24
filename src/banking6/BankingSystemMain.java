package banking6;

import java.io.Serializable;
import java.util.Scanner;

public class BankingSystemMain extends AccountManager implements ICustomDefine {

	public static void main(String[] args) {
		AccountManager accManager = new AccountManager();
//		AutoSaver autoSaver = new AutoSaver();
//		autoSaver.setDaemon(true);
		Scanner sc = new Scanner(System.in);
		accManager.readAccountInfo();
//		autoSaver.start();
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
			case DELETE:
				accManager.deleteAccount();
				break;
			case SAVE_OPTION:
				accManager.saveOption();
				break;
			case EXIT:
				accManager.exitProgram();
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
			System.out.println(e.getMessage());
		}
		return inputChoice;
	}
}

class MenuException extends Exception {
	public MenuException() {
		super("메뉴 입력 예외발생됨.\n메뉴는 1~5사이의 정수를 입력하세요");
	}
}
