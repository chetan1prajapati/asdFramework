package mum.asd.fw.account;

import mum.asd.fw.party.Customer;

public abstract class Account implements IAccount {
	protected Integer accnr;
	protected Customer customer;
	protected double balance;

	public Account(Customer customer) {
		this.customer = customer;
	}

	public Integer getAccnr() {
		return accnr;
	}

	public void setAccnr(Integer accnr) {
		this.accnr = accnr;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public IEntry getEntry() {
		return null;
	}

	public AccountType getAccountType() {
		return null;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public abstract Double getInterestRate();

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s %s %s %f %s", accnr, customer.getName(),
				customer.getType(), customer.getAddress().getCity(),
				getBalance(), getAccountType());
	}

}
