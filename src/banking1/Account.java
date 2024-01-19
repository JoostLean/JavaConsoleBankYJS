package banking1;

import java.util.HashSet;
import java.util.Scanner;

public class Account {

	private String accNum;
	private String name;
	private int balance;

//	public Account(String accNum, String name, int balance) {
//		// TODO Auto-generated constructor stub
//	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

//	public Account() {}
//	public Account(String accNum, String name, int balance) {
//		this.accNum = accNum;
//		this.name = name;
//		this.balance = balance;
//	}
	
//	static void makeAccount() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("계좌번호 : ");
//		String toAccNum = sc.next();
//		System.out.println("고객이름 : ");
//		String toName = sc.next();
//		System.out.println("잔고 : ");
//		int toBalance = sc.nextInt();
//	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
