package asd.creditCard.account;

import mum.asd.fw.account.Account;
import mum.asd.fw.account.AccountType;
import mum.asd.fw.account.Deposit;
import mum.asd.fw.account.IEntry;
import mum.asd.fw.account.Withdraw;
import mum.asd.fw.party.Customer;

public class CCAccount extends Account {
	double interestRate = 0.01;
	boolean emailflag;
	CCType cCType;

	public CCAccount(Customer cust) {
		super(cust);
	}

	public AccountType getAccountType() {
		return AccountType.CREDIT_CARD;
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

		return expiryDate;
	}

	public CCType getCCType() {

		return cCType;
	}


	public void setCCType(CCType ccType) {
		this.cCType = ccType;

	}

	public void setExpiryDate(String expDate) {
		this.expiryDate = expDate;
		
	}
}
