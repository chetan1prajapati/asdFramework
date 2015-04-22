package asd.bankapp;

import java.util.List;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.service.AccountService;
import asd.bankapp.dao.AccountDao;

public class BankAccountService implements AccountService {
	AccountDao aDao;

	public BankAccountService(AccountDao dao) {
		aDao = dao;

	}

	public void addAccount(IAccount a) {

	}

	public List<IAccount> getAll() {

		return aDao.getAll();
	}

	public void addCompanyAccount(IAccount acc) {
		aDao.insert(acc);

	}

	public void addPersonalAccount(IAccount acc) {
		aDao.insert(acc);

	}

}
