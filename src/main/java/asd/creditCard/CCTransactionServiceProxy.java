package asd.creditCard;

import java.sql.SQLException;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.common.LogFunctor;
import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.dao.ITransactionDao;
import mum.asd.fw.service.TransactionService;

public class CCTransactionServiceProxy implements TransactionService {
	TransactionService service;
	LogFunctor<String, IAccount, Double> func;

	public CCTransactionServiceProxy(TransactionService service,
			LogFunctor<String, IAccount, Double> func) {
		this.service = service;
		this.func = func;
	}

	public void addInterest() throws SQLException {
		service.addInterest();
	}

	public void deposit(IAccount a, double amount) throws SQLException {
		func.preMessage("Deposit");
		service.deposit(a, amount);
		func.postMessage(a, amount);
	}

	public void withdraw(IAccount a, double amount) throws SQLException {
		func.preMessage("Withdraw");
		service.withdraw(a, amount);
		func.postMessage(a, amount);

	}

	public void charge(IAccount a, double amount) {
		service.charge(a, amount);
	}

	public IAccountDao getAccountDao() {

		return service.getAccountDao();
	}

	public void setAccountDao(IAccountDao accountDao) {
		service.setAccountDao(accountDao);

	}

	public ITransactionDao getTransactionDao() {
		return service.getTransactionDao();
	}

	public void setTransactionDao(ITransactionDao transactionDao) {
		service.setTransactionDao(transactionDao);

	}

}
