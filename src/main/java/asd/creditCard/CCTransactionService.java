package asd.creditCard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mum.asd.fw.account.Deposit;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.account.IEntry;
import mum.asd.fw.account.TransactionType;
import mum.asd.fw.account.Withdraw;
import mum.asd.fw.common.AddInterestFunctor;
import mum.asd.fw.common.Functor;
import mum.asd.fw.common.Predicate;
import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.dao.ITransactionDao;
import mum.asd.fw.service.TransactionService;
import asd.bankapp.dao.AccountDao;
import asd.bankapp.dao.TransactionDao;
import asd.creditCard.account.CCAccount;

public class CCTransactionService implements TransactionService {
	private IAccountDao accountDao;
	private ITransactionDao transactionDao;

	public CCTransactionService() {

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

	public Double getPreviousBalance(CCAccount a) {
		List<IEntry> list = new ArrayList<IEntry>();
		try {
			list = transactionDao.getAll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (list != null && list.size() > 0) {
			IEntry e = list.get(list.size() - 1);
			return a.getBalance() - e.getAmount();
		}

		return a.getBalance();
	}

	public String getTotalCredits(CCAccount a) {
		// TODO Auto-generated method stub
		return "1";
	}

	public Double totalCharges(CCAccount a) {
		List<IEntry> list = new ArrayList<IEntry>();
		Double sum = 0.0;
		try {
			list = transactionDao.getAll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (list != null)
			for (IEntry e : list) {
				if (TransactionType.CHARGE.equals(e.getTransactionType()))
					sum += e.getAmount();
			}
		return sum;
	}

	public Double getTotalAmountDue(CCAccount a) {

		return a.getBalance();
	}

}
