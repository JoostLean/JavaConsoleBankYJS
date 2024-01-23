package banking4;

public class HighCreditAccount extends Account {

	private int interest;
	private int plusInterest;
	private char credit;
	
	public HighCreditAccount(String accNum, String name, int balance, int accType, char credit, int interest, int plusInterest) {
		super(accNum, name, balance, accType);
		this.interest = interest;
		this.plusInterest = plusInterest;
		this.credit = credit;
	}

	@Override
	public int getInterest() {
		return interest;
	}
	@Override
	public void setInterest(int interest) {
		this.interest = interest;
	}
	@Override
	public int getPlusInterest() {
		if(credit=='A') {
			this.plusInterest = 7;
		}
		else if(credit=='B') {
			this.plusInterest = 4;
		}
		else if(credit=='C') {
			this.plusInterest = 2;
		}
		return plusInterest;
	}
	@Override
	public void setPlusInterest(int plusInterest) {
		this.plusInterest = plusInterest;
	}
	public char getCredit() {
		return credit;
	}
	public void setCredit(char credit) {
		this.credit = credit;
	}
	
//	@Override
//	public int hashCode() {
//		return super.getAccNum().hashCode();
//	}
//	@Override
//	public boolean equals(Object obj) {
//		HighCreditAccount highAcc = (HighCreditAccount) obj;
//		if(highAcc.getAccNum().equals(super.getAccNum())) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
}
