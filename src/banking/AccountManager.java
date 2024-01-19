package banking;

import java.util.HashSet;
import java.util.Scanner;

/* 계좌조회, 계좌개설 등을 여기서 */
//interface MainMenuSelect {
//	final int MAKE = 1;
//	final int DEPOSIT = 2;
//	final int WITHDRAW = 3;
//	final int INQUIRE = 4;
//	final int EXIT = 5;
//}

public class AccountManager {
	
	
//	public AccountManager(String accNum, String name, int balance) {
//		super(accNum, name, balance);
//	}

	HashSet<Account> lists = new HashSet<Account>();

	private int numOfAcc = 0;
	private final int MAX_ACCOUNTS = 50;
	private Account[] accounts = new Account[MAX_ACCOUNTS];
	
	public void makeAccount(String accNum, String name, int balance) {
		Account acc = new Account(accNum, name, balance);
		
		if(numOfAcc<MAX_ACCOUNTS) {
//			accounts[numOfAcc++] = new Account(accNum, name, balance);
//			lists.add(accounts[numOfAcc++]);
			lists.add(acc);
			numOfAcc++;
		}
		
	}
	
	public void showAccount() {
//		System.out.println(lists.);
		for(Account acc : lists) {
			System.out.println(lists.toString());
		}
//		for(int i=0 ; i<numOfAcc ; i++) {
//			System.out.println(lists.);
//		}
	}
	
}
