package banking2;

public class Account {

	private String accNum;
	private String name;
	private int balance;
	private int accType;
	private int interest;
	private int plusInterest;
	private char credit;

//	public abstract double calc();
	
	public Account(String accNum, String name, int balance, int accType, char credit, int interest, int plusInterest) {
		this.accType = accType;
		this.accNum = accNum;
		this.name = name;
		this.balance = balance;
		this.interest = interest;
		this.plusInterest = plusInterest;
		this.credit = credit;
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
	public int getAccType() {
		return accType;
	}
	public void setAccType(int accType) {
		this.accType = accType;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public int getPlusInterest() {
		return plusInterest;
	}
	public void setPlusInterest(int plusInterest) {
		this.plusInterest = plusInterest;
	}
	public char getCredit() {
		return credit;
	}
	public void setCredit(char credit) {
		this.credit = credit;
	}
}