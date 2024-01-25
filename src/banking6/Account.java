package banking6;

import java.io.Serializable;
import java.util.Scanner;

abstract class Account implements Serializable{
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
		System.out.print("계좌번호:" + acnumber + " ");
		System.out.println("고객명:" + name + " ");
		System.out.print("잔고:" + mymoney + " ");
	}
	
	public void accountCreate() {
		
	}
	
	public void interestCalculation() {

	}
	
	public void withdrawCalculation() {
		
	}
	

}
