package asd.bankapp;

import java.util.Date;

import mum.asd.fw.account.Deposit;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.account.IEntry;
import mum.asd.fw.account.Withdraw;
import mum.asd.fw.common.AddInterestFunctor;
import mum.asd.fw.common.Predicate;
import mum.asd.fw.service.TransactionService;
import asd.bankapp.dao.AccountDao;
import asd.bankapp.dao.TransactionDao;

public class BankTransactionService implements TransactionService {
	private AccountDao aDao;
	private TransactionDao tDao;

	public BankTransactionService(AccountDao aDao, TransactionDao tDao) {
		this.aDao = aDao;
		this.tDao = tDao;
	}

	public void deposit(IAccount a, double amount) {
		IEntry e = new Deposit(a, new Date(), amount);
		tDao.insert(e);
		a.addEntry(e);
		aDao.update(a);

	}

	public void withdraw(IAccount a, double amount) {
		IEntry e = new Withdraw(a, new Date(), amount);
		tDao.insert(e);
		a.addEntry(e);
		aDao.update(a);

	}

	public void charge(IAccount a, double amount) {
		// TODO Auto-generated method stub

	}

	public void addInterest() {
		AddInterestFunctor f = new AddInterestFunctor(aDao, tDao);
		Predicate<IAccount> p = new Predicate<IAccount>() {
			public boolean test(IAccount t) {
				return true;
			}
		};
		aDao.doAll(f, p);

	}

}
