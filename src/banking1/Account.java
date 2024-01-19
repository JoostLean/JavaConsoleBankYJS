package banking1;

public class Account {

	private String accNum;
	private String name;
	private int balance;

	public Account(String accNum, String name, int balance) {
		this.accNum = accNum;
		this.name = name;
		this.balance = balance;
	}
	
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
}
