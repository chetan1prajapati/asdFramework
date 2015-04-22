package mum.asd.fw.account;

import java.util.Date;

public abstract class Entry implements IEntry {
	public Entry(IAccount acc, Date date2, double amount2) {
		this.a = acc;
		this.date = date2;
		this.amount = amount2;
	}

	IAccount a;
	double amount;
	Date date;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
