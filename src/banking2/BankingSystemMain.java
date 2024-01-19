package banking2;

import java.util.Scanner;

//import banking1.AccountHandler;

public class BankingSystemMain implements ICustomDefine {
	
	public static void main(String[] args) {
		BankingSystemMain bsm = new BankingSystemMain();
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true) {
			bsm.showMenu();
			choice = sc.nextInt();
			switch (choice) {
			case MAKE:
				bsm.makeAccount();
				break;
			case DEPOSIT:
				bsm.deposit();
				break;
			case WITHDRAW:
				bsm.withdraw();
				break;
			case INQUIRE:
				bsm.showAccount();
				break;
			case EXIT:
				return;
			default:
				System.out.println("메뉴를 선택해주세요.");
				break;
			}
		}
	}
	
	private static final int MAX_NUM = 50;
	private Account[] account = new Account[MAX_NUM]; 
	private int numOfAcc = 0;
	
	public void showMenu() {
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

	public void makeAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌번호 : ");
		String accNum = sc.next();
		System.out.print("고객이름 : ");
		String name = sc.next();
		System.out.print("잔고 : ");
		int balance = sc.nextInt();
		account[numOfAcc++] = new Account(accNum, name, balance);
		System.out.println("계좌개설이 완료되었습니다.");
	}
	
	public void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String depoAccNum = sc.next();
		System.out.print("입금액 : ");
		int amount = sc.nextInt();
		for(int i=0 ; i<numOfAcc ; i++) {
			if(depoAccNum.compareTo(account[i].getAccNum())==0) {
				account[i].setBalance(account[i].getBalance() + amount);
			}
		}
	}

	public void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String depoAccNum = sc.next();
		System.out.print("출금액 : ");
		int amount = sc.nextInt();
		for(int i=0 ; i<numOfAcc ; i++) {
			if(depoAccNum.compareTo(account[i].getAccNum())==0) {
				account[i].setBalance(account[i].getBalance() - amount);
			}
		}
	}

	public void showAccount() {
		if(numOfAcc>0) {
			for(int i=0 ; i<numOfAcc ; i++) {
				System.out.println("계좌번호 : "+ account[i].getAccNum());
				System.out.println("고객이름 : "+ account[i].getName());
				System.out.println("잔고 : "+ account[i].getBalance());
			}
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
}