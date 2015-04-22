package asd.bankapp.account;

import mum.asd.fw.account.Account;
import mum.asd.fw.account.AccountType;
import mum.asd.fw.account.Deposit;
import mum.asd.fw.account.IEntry;
import mum.asd.fw.party.Customer;

public class SavingAccount extends Account {
	double interestRate = 0.0325;

	public SavingAccount(Customer cust) {
		super(cust);
	}

	public AccountType getAccountType() {
		return AccountType.SAVING;
	}

	@Override
	public Double getInterestRate() {
		return interestRate;
	}

	public void addEntry(IEntry e) {
		if (e instanceof Deposit) {
			balance += e.getAmount();
		} else
			balance -= e.getAmount();

	}

	public boolean checkEmailCondition() {
		// TODO Auto-generated method stub
		return false;
	}

	public void sendEmail() {
		// TODO Auto-generated method stub

	}

}
