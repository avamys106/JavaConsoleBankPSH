package banking2;

class HighCreditAccount extends Account {

	int interest;
	String creditRating;
	public HighCreditAccount(String acnumber, String name, 
			int mymoney, int interest, String creditRating) {
		super(acnumber, name, mymoney);
		this.interest = interest;
		this.creditRating = creditRating;
		
	}
	public HighCreditAccount() {
	}
	
	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("기본이자%(정수형태로입력): " + interest);
		System.out.println("신용등급(A,B,C등급): " + creditRating);
		System.out.println("계좌계설이 완료되었습니다.");
	}
}
