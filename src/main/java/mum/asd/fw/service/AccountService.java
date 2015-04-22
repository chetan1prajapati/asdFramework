package mum.asd.fw.service;

import java.util.List;

import mum.asd.fw.account.Account;
import mum.asd.fw.account.CompanyAccount;
import mum.asd.fw.account.PersonalAccount;

public interface AccountService {

	void addAccount(Account a);

	List<Account> getAll();

	void addCompanyAccount(CompanyAccount acc);

	void addPersonalAccount(PersonalAccount acc);

}
