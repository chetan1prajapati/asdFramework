package mum.asd.fw.account;

import java.util.Date;

public interface IEntry {
	double getAmount();

	public void setAmount(double amount);

	public String getDate();

	public void setDate(String date);

	public IAccount getAccount();

	public void setAccount(IAccount account);

	TransactionType getTransactionType();
	
	

}
