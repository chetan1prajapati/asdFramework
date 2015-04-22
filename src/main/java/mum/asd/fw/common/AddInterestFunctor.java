package mum.asd.fw.common;

import java.util.Date;

import mum.asd.fw.account.Account;
import mum.asd.fw.account.Deposit;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.account.IEntry;
import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.dao.ITransactionDao;

public class AddInterestFunctor implements Functor<IAccount, Double> {
	IAccountDao aDao;
	ITransactionDao tDao;

	public AddInterestFunctor(IAccountDao aDao, ITransactionDao tDao) {
		this.aDao = aDao;
		this.tDao = tDao;
	}

	public void execute(IAccount t) {
		double interest = ((Account) t).getInterestRate() * t.getBalance();
		IEntry entry = new Deposit(t, new Date(), interest);
		t.addEntry(entry);
		tDao.insert(entry);
		aDao.update(t);

	}

	public Double getValue() {
		return null;
	}

}
