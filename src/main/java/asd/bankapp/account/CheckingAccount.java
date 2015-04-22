package asd.bankapp.account;

import mum.asd.fw.account.Account;
import mum.asd.fw.account.AccountType;
import mum.asd.fw.party.Customer;

public class CheckingAccount extends Account {
	double interestRate = 0.0325;

	public CheckingAccount(Customer c) {
		super(c);

	}

	public AccountType getAccountType() {
		return AccountType.CHECKING;
	}

	@Override
	public Double getInterestRate() {
		return interestRate;
	}

}
