package mum.asd.fw.controller;

import mum.asd.fw.account.CompanyAccount;
import mum.asd.fw.account.PersonalAccount;
import mum.asd.fw.service.AccountService;

public class AddAccountController {
	AccountService accountService;

	public AddAccountController(AccountService as) {
		accountService = as;
	}

	public void addPersonalAccount(PersonalAccount account) {
		accountService.addPersonalAccount(account);
	}

	public void addCompanyAccount(CompanyAccount account) {
		accountService.addCompanyAccount(account);
	}
}
