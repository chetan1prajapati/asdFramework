package mum.asd.fw.account;

import mum.asd.fw.party.Customer;

public interface IAccount {
	void addEntry(IEntry e);

	public double getBalance();

	public IEntry getEntry();

	boolean checkEmailCondition();

	void sendEmail();

	AccountType getAccountType();

	void setAccnr(Integer accnr);

	Customer getCustomer();

	Integer getAccnr();
}
