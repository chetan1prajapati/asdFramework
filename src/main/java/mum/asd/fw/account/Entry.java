package mum.asd.fw.account;

import java.util.Date;

public class Entry {
	public Entry(Account acc, Date date2, double amount2) {
		this.a = acc;
		this.date = date2;
		this.amount = amount2;
	}

	Account a;
	double amount;
	Date date;

}
