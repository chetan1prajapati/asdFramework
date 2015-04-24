package asd.creditCard;

import java.sql.SQLException;
import java.util.List;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.service.AccountService;
import asd.bankapp.dao.AccountDao;

public class CCAccountService implements AccountService {
	IAccountDao accountDao;

	public CCAccountService() {

	}

	public void addAccount(IAccount a) {

	}

	public List<IAccount> getAll() throws SQLException {

		return accountDao.getAll();
	}

	public void addCompanyAccount(IAccount acc) throws SQLException {
		accountDao.insert(acc);

	}

	public void addPersonalAccount(IAccount acc) throws SQLException {
		accountDao.insert(acc);

	}

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;

	}

	public IAccountDao getAccountDao() {
		return accountDao;

	}

	public void addCCAccount(IAccount acc) throws SQLException {
		accountDao.insert(acc);

	}

}
