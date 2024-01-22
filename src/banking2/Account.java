package banking2;

public class Account {
	String acnumber;
	String name;
	int mymoney;
	
	public Account() {
	}
	
	public Account(String acnumber, String name, int mymoney) {
		this.acnumber = acnumber;
		this.name = name;
		this.mymoney = mymoney;
	}
	
	public void showAccountInfo() {
		System.out.println("계좌번호> " + acnumber);
		System.out.println("고객이름> " + name);
		System.out.println("잔고> " + mymoney);
	}
	

}
