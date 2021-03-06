package asd.bankapp.account;

import asd.creditCard.account.CCType;
import mum.asd.fw.account.Account;
import mum.asd.fw.account.AccountType;
import mum.asd.fw.account.Deposit;
import mum.asd.fw.account.IEntry;
import mum.asd.fw.account.Withdraw;
import mum.asd.fw.party.Customer;

public class SavingAccount extends Account {
	double interestRate = 0.01;
	boolean emailflag;

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

	public boolean checkEmailCondition() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateBalance(IEntry e) {
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
				// send email to person
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

	public String getExpiryDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setExpiryDate() {
		// TODO Auto-generated method stub
		
	}

	public void setCCType() {
		// TODO Auto-generated method stub
		
	}

	public CCType getCCType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setExpiryDate(String expDate) {
		// TODO Auto-generated method stub
		
	}

	public void setCCType(CCType ccType) {
		// TODO Auto-generated method stub
		
	}

}
