package mum.asd.fw.account;

import asd.creditCard.account.CCType;
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

	void setExpiryDate(String expDate);

	String getExpiryDate();

	void setCCType(CCType ccType);

	CCType getCCType();
}
