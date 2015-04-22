package asd.bankapp;

import java.util.List;

import asd.bankapp.dao.AccountDao;
import mum.asd.fw.account.Account;
import mum.asd.fw.account.CompanyAccount;
import mum.asd.fw.account.PersonalAccount;
import mum.asd.fw.service.AccountService;

public class BankAccountService implements AccountService {
	AccountDao aDao;

	public BankAccountService(AccountDao dao) {
		aDao = dao;

	}

	public void addAccount(Account a) {

	}

	public List<Account> getAll() {

		return aDao.getAll();
	}

	public void addCompanyAccount(CompanyAccount acc) {
		aDao.insert(acc);

	}

	public void addPersonalAccount(PersonalAccount acc) {
		aDao.insert(acc);

	}

}
