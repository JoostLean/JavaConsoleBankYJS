package banking;

public class AccountManager {
//	private String accNum;
//	private String name;
//	private int balance;
//	public AccountManager(String accNum, String name, int balance) {
//		this.accNum = accNum;
//		this.name = name;
//		this.balance = balance;
//	}
	public AccountManager() {
		super();
	}
	void showMenu() {
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
	void makeAccount() {
		System.out.println("***신규계좌개설***");
		System.out.println("계좌번호 : ");
		System.out.println("고객이름 : ");
		System.out.println("잔고 : ");
		System.out.println("계좌개설이 완료되었습니다.");
	}
	void depositMoney() {
		System.out.println("*****입  금*****");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.println("계좌번호:");
		System.out.println("입금액:");
		System.out.println("입금이 완료되었습니다.");
	}
	void withdrawMoney() {
		System.out.println("*****출  금*****");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.println("계좌번호:");
		System.out.println("입금액:");
		System.out.println("출금이 완료되었습니다.");
	}
	void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("-------------");
		System.out.println("계좌번호 : ");
		System.out.println("고객이름 : ");
		System.out.println("잔고 : ");
		System.out.println("-------------");
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
}
