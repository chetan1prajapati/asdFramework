package mum.asd.fw.controller;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.service.TransactionService;

public class DepositController implements TransactionController {
	private TransactionService transService;

	public DepositController(TransactionService ts) {
		this.transService = ts;
	}

	public void operate(IAccount a, double amount) {
		transService.deposit(a, amount);
	}

}
