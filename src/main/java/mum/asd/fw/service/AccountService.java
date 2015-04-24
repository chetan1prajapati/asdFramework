package mum.asd.fw.service;

import java.sql.SQLException;
import java.util.List;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.dao.IAccountDao;

public interface AccountService {

	void addAccount(IAccount a);

	List<IAccount> getAll() throws SQLException;

	void addCompanyAccount(IAccount acc) throws SQLException;

	void addPersonalAccount(IAccount acc) throws SQLException;

	void addCCAccount(IAccount acc) throws SQLException;

	void setAccountDao(IAccountDao accountDao);

	IAccountDao getAccountDao();

}
