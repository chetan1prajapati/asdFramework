package asd.bankapp;

import java.sql.SQLException;
import java.util.Date;

import mum.asd.fw.account.Deposit;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.account.IEntry;
import mum.asd.fw.account.Withdraw;
import mum.asd.fw.common.AddInterestFunctor;
import mum.asd.fw.common.Predicate;
import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.dao.ITransactionDao;
import mum.asd.fw.service.TransactionService;
import asd.bankapp.dao.AccountDao;
import asd.bankapp.dao.TransactionDao;

public class BankTransactionService implements TransactionService {
	private IAccountDao accountDao;
	private ITransactionDao transactionDao;

	public BankTransactionService() {

	}

	public void deposit(IAccount a, double amount) throws SQLException {
		IEntry e = new Deposit(a, new Date().toString(), amount);
		transactionDao.insert(e);
		a.addEntry(e);
		accountDao.update(a);

	}

	public void withdraw(IAccount a, double amount) throws SQLException {
		IEntry e = new Withdraw(a, new Date().toString(), amount);
		transactionDao.insert(e);
		a.addEntry(e);
		accountDao.update(a);
	}

	public void charge(IAccount a, double amount) {
		// TODO Auto-generated method stub

	}

	public void addInterest() throws SQLException {
		AddInterestFunctor f = new AddInterestFunctor(accountDao,
				transactionDao);
		Predicate<IAccount> p = new Predicate<IAccount>() {
			public boolean test(IAccount t) {
				return true;
			}
		};
		accountDao.doAll(f, p);

	}

	public IAccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public ITransactionDao getTransactionDao() {
		return transactionDao;
	}

	public void setTransactionDao(ITransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

}
