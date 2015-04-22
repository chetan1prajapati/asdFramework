package mum.asd.fw.controller;

import mum.asd.fw.account.Account;
import mum.asd.fw.service.TransactionService;

public class WithdrawController implements TransactionController {
	private TransactionService transService;

	public WithdrawController(TransactionService ts) {
		this.transService = ts;
	}

	public void operate(Account a, double amount) {
		transService.withdraw(a, amount);
	}
}
