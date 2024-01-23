package banking4;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class AccountManager {
	private static final int MAX_NUM = 50;
	private Account[] account = new Account[MAX_NUM]; 
	private int numOfAcc = 0;

	HashSet<Account> lists = new HashSet<Account>();

	public void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.계좌정보삭제");
		System.out.println("6.프로그램종료");
		System.out.print("선택:");
	}

	public boolean handleOverlapAccount(Account acc) {
		Scanner sc = new Scanner(System.in);
		if(lists.contains(acc)) {
			while(true) {
				System.out.println("중복계좌발견됨. 덮어쓸까요?(y or n)");
				String choice = sc.next();
				if(choice.equals("y")) {
					lists.remove(acc);
					lists.add(acc);
					return true;
				}
				else if(choice.equals("n")) {
					System.out.println("기존 계좌 정보를 유지합니다.");
					return false;
				}
				else {
					System.out.println("'y' 또는 'n'을 입력해주세요.");
				}
			}
		}
		else {
			lists.add(acc);
			return true;
		}
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
		char credit;
		int plusInterest = 0;
		if(accType==1) {
			Account acc = new NormalAccount(accNum, name, balance, accType, interest);
			handleOverlapAccount(acc);
//			if(lists.contains(acc)) {
//				while(true) {
//					System.out.println("중복계좌발견됨. 덮어쓸까요?(y or n)");
//					String choice = sc.next();
//					if(choice.equals("y")) {
//						lists.remove(acc);
//						lists.add(acc);
//						return;
//					}
//					else if(choice.equals("n")) {
//						System.out.println("기존 계좌 정보를 유지합니다.");
//						return;
//					}
//					else {
//						System.out.println("'y' 또는 'n'을 입력해주세요.");
//					}
//				}
//			}
//			lists.add(acc);
//			account[numOfAcc++] = new NormalAccount(accNum, name, balance, accType, interest);
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
			Account acc = new HighCreditAccount(accNum, name, balance, accType, credit, interest, plusInterest);
			handleOverlapAccount(acc);
//			if(lists.contains(acc)) {
//				while(true) {
//					System.out.println("중복계좌발견됨. 덮어쓸까요?(y or n)");
//					String choice = sc.next();
//					if(choice.equals("y")) {
//						lists.remove(highAcc);
//						lists.add(highAcc);
//						return;
//					}
//					else if(choice.equals("n")) {
//						System.out.println("기존 계좌 정보를 유지합니다.");
//						return;
//					}
//					else {
//						System.out.println("'y' 또는 'n'을 입력해주세요.");
//					}
//				}
//			}
//			lists.add(highAcc);
//			account[numOfAcc++] = new HighCreditAccount(accNum, name, balance, accType, credit, interest, plusInterest);
		}
		System.out.println("계좌개설이 완료되었습니다.");
	}
	
	public void deleteAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("***계좌정보삭제***");
		System.out.println("삭제할 계좌번호를 입력하세요");
		System.out.print("계좌번호:");
		String accNum = sc.next();
		Iterator<Account> itr = lists.iterator();
		while(itr.hasNext()) {
			Account acc = itr.next();
			if(acc.getAccNum().equals(accNum)) {
				lists.remove(acc);
				System.out.println("삭제가 완료되었습니다.");
			}
		}
//		for(int i=0 ; i<lists.size() ; i++) {
//			Account acc = itr.next();
//			if(accNum==acc.getAccNum()) {
//				lists.remove(acc);
//			}
//		}
	}

	int readDepositAmount() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				return sc.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("금액에 문자를 입력할 수 없습니다.");
				System.out.print("입금액 : ");
				sc.nextLine();
			}
		}
	}
	
	public void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String depoAccNum = sc.next();
		int amount = 0;
		while(true) {
			System.out.print("입금액 : ");
			amount = readDepositAmount();
			if(amount<0) {
				System.out.println("마이너스 금액은 입금할 수 없습니다.");
				continue;
			}
			if(!(amount % 500 == 0)) {
				System.out.println("입금은 500원 단위로 가능합니다.");
				continue;
			}
			break;
		}
		Iterator<Account> itr = lists.iterator();
		for(int i=0 ; i<lists.size() ; i++) {
			Account acc = itr.next();
			if(acc.getAccType()==1) {
				if(depoAccNum.compareTo(acc.getAccNum())==0) {
					acc.setBalance(acc.getBalance() +
							(int)(acc.getBalance() * ((float)acc.getInterest() / 100)) + amount);
				}
			}
			if(acc.getAccType()==2) {
				if(depoAccNum.compareTo(acc.getAccNum())==0) {
					acc.setBalance(acc.getBalance() +
							(int)(acc.getBalance() * ((float)acc.getInterest() / 100)) + 
							(int)(acc.getBalance() * ((float)acc.getPlusInterest() / 100)) + 
							amount);
				}
			}
		}
//		for(int i=0 ; i<numOfAcc ; i++) {
//			if(account[i].getAccType()==1) {
//				if(depoAccNum.compareTo(account[i].getAccNum())==0) {
//					account[i].setBalance(account[i].getBalance() + 
//							(int)(account[i].getBalance() * ((float)account[i].getInterest() / 100)) + amount);
//				}
//			}
//			if(account[i].getAccType()==2) {
//				if(depoAccNum.compareTo(account[i].getAccNum())==0) {
//					account[i].setBalance(account[i].getBalance() +
//							 (int)(account[i].getBalance() * ((float)account[i].getInterest() / 100)) +
//							 (int)(account[i].getBalance() * ((float)account[i].getPlusInterest() / 100)) + amount);
//				}
//			}
//		}
		System.out.println("입금이 완료되었습니다.");
	}

	int readInsufSelect() throws InputMismatchException {
		Scanner sc = new Scanner(System.in);
		int read = 0;
		
		while(true) {
			try {
				read = sc.nextInt();
				if(!(read==1 || read==2)) {
					System.out.println("'YES(1)'와 'NO(2)' 중 하나를 선택해주세요.");
					System.out.println("YES(1): 금액전체 출금처리");
					System.out.println("NO(2): 출금요청취소");
					continue;
				}
				else if(read==1 || read==2) {
					return read;
				}
			}
			catch(Exception e) {
				sc.next();
				return read;
//				e.printStackTrace();
			}
		}
//		return read;
	}

	public void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String depoAccNum = sc.next();
		int amount;
		while(true) {
			System.out.print("출금액 : ");
			amount = sc.nextInt();
			if(amount<0) {
				System.out.println("마이너스 금액은 출금할 수 없습니다.");
				continue;
			}
			if(!(amount % 1000 == 0)) {
				System.out.println("출금은 1000원 단위로 가능합니다.");
				continue;
			}
			break;
		}
		Iterator<Account> itr = lists.iterator();
		for(int i=0 ; i<numOfAcc ; i++) {
			Account acc = itr.next();
			if(depoAccNum.compareTo(acc.getAccNum())==0 && acc.getBalance() < amount) {
//				String insufSelect = "";
				int insufSelect;
				System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
				System.out.println("YES(1): 금액전체 출금처리");
				System.out.println("NO(2): 출금요청취소");
				insufSelect = readInsufSelect();
				if(insufSelect == 1) {
					acc.setBalance(acc.getBalance() - amount);
					System.out.println("출금이 완료되었습니다.");
				}
				else if(insufSelect == 2) {
					System.out.println("출금요청이 취소되었습니다.");
					return;
				}
			} else if (depoAccNum.compareTo(account[i].getAccNum())==0) {
				acc.setBalance(acc.getBalance() - amount);
				System.out.println("출금이 완료되었습니다.");
			}
		}
	}

	public void showAccount() {
		if(lists.size()>0) {
			Iterator<Account> itr = lists.iterator();
			while(itr.hasNext()) {
				Account acc = itr.next();
				System.out.println("-------------");
				System.out.println("계좌번호>"+ acc.getAccNum());
				System.out.println("고객이름>"+ acc.getName());
				System.out.println("잔고>"+ acc.getBalance());
				System.out.println("기본이자>"+ (int)(acc.getInterest())+"%");
				if(acc.getAccType()==2) {
					System.out.println("신용등급>"+ acc.getCredit());
				}
				System.out.println("-------------");
			}
//			for(int i=0 ; i<lists.size() ; i++) {
//				System.out.println("-------------");
//				System.out.println("계좌번호>"+ account[i].getAccNum());
//				System.out.println("고객이름>"+ account[i].getName());
//				System.out.println("잔고>"+ account[i].getBalance());
//				System.out.println("기본이자>"+ (int)(account[i].getInterest())+"%");
//				if(account[i].getAccType()==2) {
//					System.out.println("신용등급>"+ account[i].getCredit());
//				}
//				System.out.println("-------------");
//			}
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
}