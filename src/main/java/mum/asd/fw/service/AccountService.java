package mum.asd.fw.service;

import java.util.List;

import mum.asd.fw.account.IAccount;

public interface AccountService {

	void addAccount(IAccount a);

	List<IAccount> getAll();

	void addCompanyAccount(IAccount acc);

	void addPersonalAccount(IAccount acc);

}
