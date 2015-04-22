package asd.bankapp;

import java.util.Date;
import java.util.List;

import mum.asd.fw.account.Account;
import mum.asd.fw.account.Deposit;
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

	public void deposit(Account a, double amount) {
		tDao.insert(new Deposit(a, new Date(), amount));
		a.setBalance(a.getBalance() + amount);
		aDao.update(a);

	}

	public void withdraw(Account a, double amount) {
		tDao.insert(new Withdraw(a, new Date(), amount));
		a.setBalance(a.getBalance() - amount);
		aDao.update(a);

	}

	public void charge(Account a, double amount) {
		// TODO Auto-generated method stub

	}

	public void addInterest() {
		List<Account> accounts = aDao.getAll();
		AddInterestFunctor f = new AddInterestFunctor(aDao, tDao);
		Predicate<Account> p = new Predicate<Account>() {
			public boolean test(Account t) {
				return true;
			}
		};
		aDao.doAll(f, p);

	}

}
