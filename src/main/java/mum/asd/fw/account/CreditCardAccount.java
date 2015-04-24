package mum.asd.fw.account;

import mum.asd.fw.party.Customer;
public class CreditCardAccount{
	
}

abstract class CreditCardAccount1 implements IAccount {
	private String ccNo;
	private String expDate;
	private double lastMonthBal;
	protected Customer customer;

	public String getCcNo() {
		return ccNo;
	}

	public void setCcNo(String ccNo) {
		this.ccNo = ccNo;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String date) {
		this.expDate = date;
	}

	public double getLastMonthBal() {
		return lastMonthBal;
	}

	public void setLastMonthBal(double lastMonthBal) {
		this.lastMonthBal = lastMonthBal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public abstract String getType();

}
