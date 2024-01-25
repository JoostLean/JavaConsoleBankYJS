package banking6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;

public class AutoSaver extends Thread {
	private HashSet<Account> lists;

	@Override
	public void run() {
		AccountManager acm = new AccountManager();
		HashSet<Account> lists = acm.lists;
		while(true) {
			try {
//				acm.saveAccountInfo();
//				acm.saveAccountToTxt();
				sleep(5000);
				BufferedWriter out = new BufferedWriter(new FileWriter("src/banking6/AutoSaveAccount.txt"));
				for(Account acc : lists) {
					out.write(acc.getAccNum());
					out.write(acc.getName());
					out.write(acc.getBalance());
					out.write(acc.getInterest());
					if(acc.getAccType()==2) {
						out.write(acc.getPlusInterest());
					}
				}
				out.flush();
				out.close();
				System.out.println("계좌정보가 텍스트로 자동저장되었습니다.");
			}
			catch(InterruptedException e) {
//			e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
