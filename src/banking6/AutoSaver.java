package banking6;

public class AutoSaver extends Thread {
	@Override
	public void run() {
		while(true) {
			AccountManager acm = new AccountManager();
			acm.saveAccountInfo();
			try {
				System.out.println("계좌정보가 텍스트로 자동저장되었습니다.");
				sleep(5000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
