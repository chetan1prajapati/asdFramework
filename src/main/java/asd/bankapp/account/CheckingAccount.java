package asd.bankapp.account;

import mum.asd.fw.account.Account;
import mum.asd.fw.account.AccountType;
import mum.asd.fw.account.Deposit;
import mum.asd.fw.account.IEntry;
import mum.asd.fw.account.Withdraw;
import mum.asd.fw.party.Customer;

public class CheckingAccount extends Account {
	double interestRate = 0.0325;
	boolean emailflag;

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

	// public void addEntry(IEntry e) {
	// if (e instanceof Deposit) {
	// balance += e.getAmount();
	// } else
	// balance -= e.getAmount();
	// }

	public boolean checkEmailCondition() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateBalance(IEntry e) {
		System.out.println("update balance");
		if (e instanceof Deposit) {
			balance += e.getAmount();
		} else
			balance -= e.getAmount();
	}

	@Override
	public void checkEmailCondition(IEntry e) {
		emailflag = false;
		if (getCustomer().getType().equals("C")) {
			// send email to company
			emailflag = true;
		} else if (getCustomer().getType().equals("P")) {
			if (e.getAmount() > 500
					|| (e instanceof Withdraw && e.getAmount() > getBalance())) {
				emailflag = true;
			}
		}
	}

	@Override
	public void sendEmail() {
		if (emailflag) {
			System.out.println("email sent");
		}
	}
}
