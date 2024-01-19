package banking2;

class NormalAccount extends Account {

	int interest;

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
		System.out.println("기본이자%(정수형태로입력): " + interest);
		System.out.println("계좌계설이 완료되었습니다.");
	}

}
