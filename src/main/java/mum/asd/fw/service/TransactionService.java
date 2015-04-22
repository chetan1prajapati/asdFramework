package mum.asd.fw.service;

import mum.asd.fw.account.IAccount;

public interface TransactionService {

	public void deposit(IAccount a, double amount);

	public void withdraw(IAccount a, double amount);

	public void charge(IAccount a, double amount);

	public void addInterest();
}
