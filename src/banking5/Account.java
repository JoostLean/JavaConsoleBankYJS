package banking5;

import java.io.Serializable;
import java.util.Objects;

public abstract class Account implements Serializable {

	private String accNum;
	private String name;
	private int balance;
	private int accType;
	private int interest;
	private int plusInterest;
	private char credit;

	public Account(String accNum, String name, int balance, int accType) {
		this.accType = accType;
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

	@Override
	public int hashCode() {
		return Objects.hash(accNum, accType, balance, credit, interest, name, plusInterest);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accNum, other.accNum) && accType == other.accType && balance == other.balance
				&& credit == other.credit && interest == other.interest && Objects.equals(name, other.name)
				&& plusInterest == other.plusInterest;
	}
}
