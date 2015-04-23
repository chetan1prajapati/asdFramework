package mum.asd.fw.account;


public class Withdraw extends Entry {

	public Withdraw(IAccount acc, String date2, double amount2) {
		super(acc, date2, amount2);
	}

	public TransactionType getTransactionType() {
		// TODO Auto-generated method stub
		return TransactionType.WITHDRAW;
	}

}
