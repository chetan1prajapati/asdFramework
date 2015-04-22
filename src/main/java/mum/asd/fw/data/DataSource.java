package mum.asd.fw.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import asd.bankapp.account.CheckingAccount;
import mum.asd.fw.account.Account;
import mum.asd.fw.party.Customer;
import mum.asd.fw.party.Person;
import mum.asd.fw.party.Address;

public class DataSource {
	public static List<Account> accounts = new ArrayList<Account>();
	static {
		Address add = new Address("1street", "fairfield", "IA", "555444");
		Customer c = new Person("Nuhendra", add, "");
		Account a = new CheckingAccount(c);
		accounts.add(a);
		a.setAccnr(0);

		add = new Address("2street", "fairfield", "IA", "555444");
		c = new Person("Sachindra", add, "");
		a = new CheckingAccount(c);
		accounts.add(a);
		a.setAccnr(1);
		add = new Address("3street", "fairfield", "IA", "555444");
		c = new Person("Chetan", add, "");
		a = new CheckingAccount(c);
		accounts.add(a);
		a.setAccnr(2);
	}

	public static List<Account> getAccounts() {
		return accounts;
	}
}
