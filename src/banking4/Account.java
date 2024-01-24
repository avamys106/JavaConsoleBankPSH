package banking4;

import java.util.Scanner;

abstract class Account {
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
	
	public String getAcnumber() {
		return acnumber;
	}

	public void setAcnumber(String acnumber) {
		this.acnumber = acnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMymoney() {
		return mymoney;
	}

	public void setMymoney(int mymoney) {
		this.mymoney = mymoney;
	}

	public void showAccountInfo() {
		System.out.println("계좌번호> " + acnumber);
		System.out.println("고객이름> " + name);
		System.out.println("잔고> " + mymoney);
	}
	
	public void accountCreate() {
		
	}
	
	public void interestCalculation() {

	}
	
	public void withdrawCalculation() {
		
	}
	

}
