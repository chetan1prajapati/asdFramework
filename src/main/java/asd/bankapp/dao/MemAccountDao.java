package asd.bankapp.dao;

import java.util.List;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.common.Functor;
import mum.asd.fw.common.Predicate;
import mum.asd.fw.dao.IAccountDao;

public class MemAccountDao implements IAccountDao {

	public void insert(IAccount t) {

	}

	public void update(IAccount t) {

	}

	public void delete(Integer id) {

	}

	public IAccount getById(Integer id) {
		return null;
	}

	public List<IAccount> getAll() {
		return null;
	}

	public <R> void doAll(Functor<IAccount, R> func, Predicate<IAccount> p) {

	}
}
