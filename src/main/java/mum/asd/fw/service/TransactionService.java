package mum.asd.fw.service;

import mum.asd.fw.account.Account;

public interface TransactionService {

	public void deposit(Account a, double amount);

	public void withdraw(Account a, double amount);

	public void charge(Account a, double amount);

	public void addInterest();
}
