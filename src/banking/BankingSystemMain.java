package banking;

import java.util.Scanner;

public class BankingSystemMain {

	public static void main(String[] args) {
		BankingSystemHandler handler = new BankingSystemHandler();
		Scanner scanner = new Scanner(System.in);

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
		
		int choice = scanner.nextInt();
//		switch (choice) {
//			case 1:
//				userResult = "가위"; break;
//			case 2:
//				userResult = "바위"; break;
//			case 3:
//				userResult = "보"; break;
//			default:
//				userResult = "undefined"; break;
//		}
	}
}

class BankingSystemHandler {
	
}
