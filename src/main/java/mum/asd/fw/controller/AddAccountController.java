package mum.asd.fw.controller;

import java.sql.SQLException;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.service.AccountService;

public class AddAccountController {
	AccountService accountService;

	public AddAccountController(AccountService as) {
		accountService = as;
	}

	public void addPersonalAccount(IAccount account) throws SQLException {
		accountService.addPersonalAccount(account);
	}

	public void addCompanyAccount(IAccount account) throws SQLException {
		accountService.addCompanyAccount(account);
	}
}
