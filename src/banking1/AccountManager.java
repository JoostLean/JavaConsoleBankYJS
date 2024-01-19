package banking1;

import java.util.HashSet;
import java.util.Scanner;

import banking.Account;

public class AccountManager {

	static HashSet<Account> lists = new HashSet<Account>();
	
	static final int MAKE = 1;
	static final int DEPOSIT = 2;
	static final int WITHDRAW = 3;
	static final int INQUIRE = 4;
	static final int EXIT = 5;
	
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
			makeAccount(lists);
			selectMenu();
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

//	static void AccountInfoHandler() {
//		lists = new HashSet<Account>();
//	}
	
	static void makeAccount(HashSet<Account> lists) {
		String iAccNum,iName;
		int iBalance;
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌번호 : ");
		iAccNum = sc.next();
		System.out.print("고객이름 : ");
		iName = sc.next();
		System.out.print("잔고 : ");
		iBalance = sc.nextInt();
		sc.close();
		Account newAcc = new Account(iAccNum,iName,iBalance);
		lists.add(newAcc);
	}
	
	static void showAccounts(Account newAcc) {
		System.out.println(newAcc);
	}
}
