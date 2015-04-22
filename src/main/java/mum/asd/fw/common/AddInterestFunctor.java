package mum.asd.fw.common;

import java.util.Date;

import mum.asd.fw.account.Account;
import mum.asd.fw.account.Entry;
import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.dao.ITransactionDao;

public class AddInterestFunctor implements Functor<Account, Double> {
	IAccountDao aDao;
	ITransactionDao tDao;

	public AddInterestFunctor(IAccountDao aDao, ITransactionDao tDao) {
		this.aDao = aDao;
		this.tDao = tDao;
	}

	public void execute(Account t) {
		double interest = t.getInterestRate() * t.getBalance();
		Entry entry = new Entry(t, new Date(), interest);
		t.setBalance(t.getBalance() + interest);
		tDao.insert(entry);
		aDao.update(t);

	}

	public Double getValue() {
		return null;
	}

}
