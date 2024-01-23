package banking4;

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
	
//	@Override
//	public int hashCode() {
//		return super.getAccNum().hashCode();
//	}
//	@Override
//	public boolean equals(Object obj) {
//		NormalAccount defAcc = (NormalAccount) obj;
//		if(defAcc.getAccNum().equals(super.getAccNum())) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
}
