package banking5;

import java.io.Serializable;

public class NormalAccount extends Account {

	private int interest;
	
	public NormalAccount(String accNum, String name, int balance, int accType, int interest) {
		super(accNum, name, balance, accType);
		this.interest = interest;
	}

	@Override
	public int getInterest() {
		return interest;
	}
	@Override
	public void setInterest(int interest) {
		this.interest = interest;
	}
}
