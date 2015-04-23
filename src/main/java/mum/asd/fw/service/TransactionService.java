package mum.asd.fw.service;

import java.sql.SQLException;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.dao.ITransactionDao;

public interface TransactionService {

	public IAccountDao getAccountDao();

	public void setAccountDao(IAccountDao accountDao);

	public ITransactionDao getTransactionDao();

	public void setTransactionDao(ITransactionDao transactionDao);

	public void deposit(IAccount a, double amount) throws SQLException;

	public void withdraw(IAccount a, double amount) throws SQLException;

	public void charge(IAccount a, double amount);

	public void addInterest() throws SQLException;
	
	
}
