package banking2;

public class NormalAccount extends Account {

	private int interest;

	Account account = new Account();
	public NormalAccount(int interest) {
		super();
		this.interest = interest;
	}

	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
}
