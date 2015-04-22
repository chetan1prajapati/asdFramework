package mum.asd.fw.controller;

import mum.asd.fw.account.IAccount;

public interface TransactionController {
	public void operate(IAccount a, double amount);
}
