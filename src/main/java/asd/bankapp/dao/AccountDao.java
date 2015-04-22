package asd.bankapp.dao;

import java.util.List;

import mum.asd.fw.account.Account;
import mum.asd.fw.common.Functor;
import mum.asd.fw.common.Predicate;
import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.data.DataSource;

public class AccountDao implements IAccountDao {

	public void insert(Account t) {
		DataSource.getAccounts().add(t);
		System.out.println(DataSource.accounts.size());
	}

	public void update(Account t) {
		for (Account a : DataSource.getAccounts()) {
			System.out.println(a.getBalance());
			a.getBalance();
		}
		System.out.println(t.getBalance());
		System.out.println("update");

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public Account getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> getAll() {

		return DataSource.getAccounts();
	}

	public <R> void doAll(Functor<Account, R> func, Predicate<Account> p) {
		List<Account> all = getAll();
		for (Account account : all) {
			func.execute(account);
		}

	}

}
