package mum.asd.fw.controller;

import java.sql.SQLException;

import mum.asd.fw.account.IAccount;

public interface TransactionController {
	public void operate(IAccount a, double amount) throws SQLException;
}
