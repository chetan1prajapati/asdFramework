package mum.asd.fw.controller;

import mum.asd.fw.account.Account;

public interface TransactionController {
	public void operate(Account a, double amount);
}
