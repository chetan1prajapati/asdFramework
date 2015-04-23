package mum.asd.fw.account;

import java.util.Date;

public class Deposit extends Entry {

	public Deposit(IAccount acc, String date2, double amount2) {
		super(acc, date2, amount2);
	}


	public TransactionType getTransactionType() {
		return TransactionType.DEPOSIT;
	}


}
