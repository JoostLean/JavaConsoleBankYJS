package banking6;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class AccountManager {
	private static final int MAX_NUM = 50;
	private Account[] account = new Account[MAX_NUM]; 
	private int numOfAcc = 0;
	//AutoSaver를 멤버변수로 선언한다.
	AutoSaver autoSaver = null;

	HashSet<Account> lists = new HashSet<Account>();
	
	public void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.계좌정보삭제");
		System.out.println("6.저장옵션");
		System.out.println("7.프로그램종료");
		System.out.print("선택:");
	}

	public void makeAccount() {
		//스캐너 생성
		Scanner sc = new Scanner(System.in);
		System.out.println("-----계좌선택-----");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		int accType;
		/* while문을 통해 보통계좌인지 신용신뢰계좌가 아닌 번호를 누르면 다시 선택하게 한다.
		while문 내에 있는 accType로 계좌의 종류를 입력받는다. */
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
		/* 정보를 모두 입력받은 후 상단에서 입력받은 accType의 종류에 따라
		1번이면 보통계좌로, 2번이면 신용신뢰계좌로 Account 생성자를 생성한다. */
		if(accType==1) {
			Account acc = new NormalAccount(accNum, name, balance, accType, interest);
			handleOverlapAccount(acc);
		}
		else if(accType==2) {
			while(true) {
				System.out.print("신용등급(A,B,C등급): ");
				credit = sc.next().charAt(0);
				//신용등급을 'A', 'B', 'C' 외에 다른 것을 입력하면 입력되지 않도록 한다.
				if(!(credit>='A' && credit<='C')) {
					System.out.println("신용등급을 'A','B','C' 중에 선택해주세요.");
					continue;
				}
				break;
			}
			Account acc = new HighCreditAccount(accNum, name, balance, accType, credit, interest, plusInterest);
			/* 계좌가 중복되어 저장되지 않게 handleOverlapAccount 메소드를 만들어서
			계좌 중복여부를 확인하고, 중복되어 있으면 덮어씌울지 여부를 물어본다. */
			handleOverlapAccount(acc);
		}
		System.out.println("계좌개설이 완료되었습니다.");
	}
	
	public void deleteAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("***계좌정보삭제***");
		System.out.println("삭제할 계좌번호를 입력하세요");
		System.out.print("계좌번호:");
		String accNum = sc.next();
		//일치하는 정보를 검색하기 위한 이터레이터 생성
		Iterator<Account> itr = lists.iterator();
		//HashSet 컬렉션 전체를 대상으로 반복
		while(itr.hasNext()) {
			Account acc = itr.next();
			//입력받은 AccNum과 HashSet 컬렉션에 저장된 AccNum이 같은지 확인
			if(acc.getAccNum().equals(accNum)) {
				//같으면 삭제
				lists.remove(acc);
				System.out.println("삭제가 완료되었습니다.");
			}
		}
	}
	
	public void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String depoAccNum = sc.next();
		int amount = 0;
		/* 마이너스 금액 또는 500원 외의 단위 입력시 메시지가 표시되게 while문으로 돌린다.
		금액에 문자를 입력할 수 없도록 readDepositAmount 메소드 안에서 예외처리한다. */
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
		//이터레이터 생성하여 for문 안에서 Account의 하위 메서드를 읽을 수 있게 한다.
		Iterator<Account> itr = lists.iterator();
		for(int i=0 ; i<lists.size() ; i++) {
			Account acc = itr.next();
			//계좌의 종류에 따라 입금받는 금액의 공식이 각각 다르게 한다.
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
		System.out.println("입금이 완료되었습니다.");
	}

	public void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String depoAccNum = sc.next();
		int amount;
		// 마이너스 금액 또는 500원 외의 단위 입력시 메시지가 표시되게 while문으로 돌린다.
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
				/* insufSelect라는 int형을 하나 만들고 1번이나 2번 외에 다른 숫자를 입력시
				메시지 출력후 다시 입력받도록 readInsufSelect 내에서 처리한다. */
				int insufSelect;
				System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
				System.out.println("YES(1): 금액전체 출금처리");
				System.out.println("NO(2): 출금요청취소");
				insufSelect = readInsufSelect();
				//1번 선택시 현재 보유 금액에서 상단에서 입력받은 출금액(amount)만큼 빼준다.
				if(insufSelect == 1) {
					acc.setBalance(acc.getBalance() - amount);
					System.out.println("출금이 완료되었습니다.");
				}
				//2번 선택시 작업을 취소한다.
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
			//이터레이터 생성
			Iterator<Account> itr = lists.iterator();
			//이터레이터를 통해 Account의 하위 메서드에 접근하여 고객의 정보를 출력한다.
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
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
	public void saveOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("저장옵션을 선택하세요.");
		System.out.println("1.자동저장On, 2.자동저장Off");
		System.out.print("선택:");
		int choice = sc.nextInt();
		try {
			/* 1번 선택시 autoSaver를 생성자로 생성하여 변수에 들어오게 하고
			데몬쓰레드로 만든 후 스타트한다. */
			if(choice==1) {
				if(!autoSaver.isAlive()) {
					autoSaver = new AutoSaver();
					autoSaver.setDaemon(true);
					autoSaver.start();
				}
				else {
					System.out.println("이미 자동저장이 실행중입니다.");
				}
			}
			/* 2번 선택시 interrupt를 통해 종료시킨다. */
			else if(choice==2) {
				if(autoSaver.isAlive()) {
					autoSaver.interrupt();
				}
			}
		}
		catch(NullPointerException e) {
			/* 처음 생성시 1번을 선택하면 autoSaver가 null값이기 때문에
			아래와 같이 null인 상태에서는 이렇게 초기화한다. */
			autoSaver = new AutoSaver();
			autoSaver.setDaemon(true);
			autoSaver.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exitProgram() {
		//프로그램 종료 후 saveAccountInfo라는 메서드를 통해 계좌정보를 저장한다.
		System.out.println("프로그램을 종료합니다.");
		saveAccountInfo();
	}


	/* 하위 기능요소 */
	boolean handleOverlapAccount(Account acc) {
		Scanner sc = new Scanner(System.in);
		//makeAccount에서 생성하려는 계좌정보를 입력받는다.
		/* HashSet에 저장된 리스트와 makeAccount에서 만든 acc가 일치하면
		if문에서 중복계좌를 어떻게 할지 물어본다. */
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
		/* 일치하지 않으면 그대로 add해준다. */
		else {
			lists.add(acc);
			return true;
		}
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
			}
		}
	}
	
	void saveAccountInfo() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/banking6/AccountInfo.obj"));
			for(Account acc : lists) {
				out.writeObject(acc);
			}
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

//	void saveAccountToTxt() {
//		try {
//			Writer out = new FileWriter("src/banking6/AutoSaveAccount.txt");
//			for(Account acc : lists) {
//				out.write(acc.toString());
//				out.write(acc.getAccNum());
//				out.write(acc.getName());
//				out.write(acc.getBalance());
//				out.write(acc.getInterest());
//				if(acc.getAccType()==2) {
//					out.write(acc.getPlusInterest());
//				}
//			}
//			out.close();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

	void readAccountInfo() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/banking6/AccountInfo.obj"));
			while(true) {
				Account inputList = (Account)in.readObject();
				lists.add(inputList);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}
		catch(EOFException e) {
			System.out.println("계좌정보 불러오기 완료.");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("알수 없는 오류로 인하여\n계좌정보 불러오기에 실패하였습니다.");
		}
	}
}
