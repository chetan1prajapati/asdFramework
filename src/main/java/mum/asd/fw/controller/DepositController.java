package mum.asd.fw.controller;

import mum.asd.fw.account.Account;
import mum.asd.fw.service.TransactionService;

public class DepositController implements TransactionController {
	private TransactionService transService;

	public DepositController(TransactionService ts) {
		this.transService = ts;
	}

	public void operate(Account a, double amount) {
		transService.deposit(a, amount);
	}
}
