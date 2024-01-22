package banking2;

class NormalAccount extends Account {

	public static int interest;

	public NormalAccount(String acnumber, String name, 
			int mymoney, int interest) {
		super(acnumber, name, mymoney);
		this.interest = interest;
	}
	public NormalAccount() {
	}

	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("기본이자> " + interest);
	}
	
}
