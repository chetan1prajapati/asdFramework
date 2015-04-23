package asd.bankapp.dao;

import java.util.List;

import mum.asd.fw.account.Account;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.common.Functor;
import mum.asd.fw.common.Predicate;
import mum.asd.fw.dao.IAccountDao;

public class AccountDao implements IAccountDao {

	

	public void insert(IAccount t) {
//		mum.asd.fw.data.DataSource.getAccounts().add(t);
//		System.out.println(mum.asd.fw.data.DataSource.accounts.size());
	}

	public void update(IAccount t) {
//		for (IAccount a : mum.asd.fw.data.DataSource.getAccounts()) {
//			System.out.println(a.getBalance());
//			a.getBalance();
//		}
//		System.out.println(t.getBalance());
//		System.out.println("update");

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public Account getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IAccount> getAll() {

		return null;//mum.asd.fw.data.DataSource.getAccounts();
	}

	public <R> void doAll(Functor<IAccount, R> func, Predicate<IAccount> p) {
//		List<IAccount> all = getAll();
//		for (IAccount account : all) {
//			func.execute(account);
//		}

	}

}
