package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager {
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
		System.out.println("-----계좌선택-----");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		int accType;
		while(true) {
			System.out.print("선택:");
			accType = sc.nextInt();
			if(!(accType>=1 && accType<=2)) {
				System.out.println("[1.보통계좌],[2.신용신뢰계좌] 중 하나를 선택해주세요.");
				continue;
			}
			break;
		}
		System.out.print("계좌번호: ");
		String accNum = sc.next();
		System.out.print("고객이름: ");
		String name = sc.next();
		System.out.print("잔고: ");
		int balance = sc.nextInt();
		System.out.print("기본이자%(정수형태로입력): ");
		int interest = sc.nextInt();
		char credit = '0';
		int plusInterest = 0;
		if(accType==1) {
			account[numOfAcc++] = new NormalAccount(accNum, name, balance, accType, interest);
		}
		else if(accType==2) {
			while(true) {
				System.out.print("신용등급(A,B,C등급): ");
				credit = sc.next().charAt(0);
				if(!(credit>='A' && credit<='C')) {
					System.out.println("신용등급을 'A','B','C' 중에 선택해주세요.");
					continue;
				}
				break;
			}
			account[numOfAcc++] = new HighCreditAccount(accNum, name, balance, accType, credit, interest, plusInterest);
		}
		System.out.println("계좌개설이 완료되었습니다.");
	}

	public void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String depoAccNum = sc.next();
		int amount;
		try {
			while(true) {
				System.out.print("입금액 : ");
				amount = sc.nextInt();
				if(amount<0) {
					System.out.println("a");
					System.out.println("마이너스 금액은 입금할 수 없습니다.");
					continue;
				}
				if(!(amount % 500 == 0)) {
					System.out.println("입금은 500원 단위로 가능합니다.");
					continue;
				}
				break;
			}
			return;
		}
		catch(InputMismatchException e) {
			System.out.println("금액에 문자를 입력할 수 없습니다.");
		}
		for(int i=0 ; i<numOfAcc ; i++) {
			if(account[i].getAccType()==1) {
				if(depoAccNum.compareTo(account[i].getAccNum())==0) {
					account[i].setBalance(account[i].getBalance() + 
							(int)(account[i].getBalance() * ((float)account[i].getInterest() / 100)) + amount);
				}
			}
			if(account[i].getAccType()==2) {
				if(depoAccNum.compareTo(account[i].getAccNum())==0) {
					account[i].setBalance(account[i].getBalance() +
							 (int)(account[i].getBalance() * ((float)account[i].getInterest() / 100)) +
							 (int)(account[i].getBalance() * ((float)account[i].getPlusInterest() / 100)) + amount);
				}
			}
		}
		System.out.println("입금이 완료되었습니다.");
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
		System.out.println("출금이 완료되었습니다.");
	}

	public void showAccount() {
		if(numOfAcc>0) {
			for(int i=0 ; i<numOfAcc ; i++) {
				System.out.println("-------------");
				System.out.println("계좌번호>"+ account[i].getAccNum());
				System.out.println("고객이름>"+ account[i].getName());
				System.out.println("잔고>"+ account[i].getBalance());
				System.out.println("기본이자>"+ (int)(account[i].getInterest())+"%");
				if(account[i].getAccType()==2) {
					System.out.println("신용등급>"+ account[i].getCredit());
				}
				System.out.println("-------------");
			}
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
}