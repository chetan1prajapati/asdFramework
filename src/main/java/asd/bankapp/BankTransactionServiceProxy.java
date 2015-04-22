package asd.bankapp;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.common.LogFunctor;
import mum.asd.fw.service.TransactionService;

public class BankTransactionServiceProxy implements TransactionService{
	TransactionService service;
	LogFunctor<String, IAccount, Double> func;
	
	public BankTransactionServiceProxy(TransactionService service, LogFunctor<String, IAccount, Double> func){
		this.service = service;
		this.func    = func;
	}

	@Override
	public void addInterest() {
		service.addInterest();
	}

	@Override
	public void deposit(IAccount a, double amount) {
		func.preMessage("Deposit");
		service.deposit(a, amount);
		func.postMessage(a, amount);
	}

	@Override
	public void withdraw(IAccount a, double amount) {
		func.preMessage("Withdraw");
		service.withdraw(a, amount);
		func.postMessage(a, amount);
		
	}

	@Override
	public void charge(IAccount a, double amount) {
		service.charge(a, amount);
	}

}
