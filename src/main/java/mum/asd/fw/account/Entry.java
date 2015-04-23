package mum.asd.fw.account;

import java.util.Date;

public abstract class Entry implements IEntry {
	public Entry(IAccount acc, String date2, double amount2) {
		this.account = acc;
		this.date = date2;
		this.amount = amount2;
	}

	protected IAccount account;
	protected double amount;
	protected String date;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public IAccount getAccount() {
		return account;
	}

	public void setAccount(IAccount account) {
		this.account = account;
	}

}
