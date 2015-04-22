package asd.bankapp.dao;

import java.util.List;

import mum.asd.fw.account.IEntry;
import mum.asd.fw.common.Functor;
import mum.asd.fw.common.Predicate;
import mum.asd.fw.dao.ITransactionDao;

public class TransactionDao implements ITransactionDao {

	public void insert(IEntry t) {
		// TODO Auto-generated method stub

	}

	public void update(IEntry t) {
		// TODO Auto-generated method stub

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public IEntry getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IEntry> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public <R> void doAll(Functor<IEntry, R> func, Predicate<IEntry> p) {
		// TODO Auto-generated method stub

	}
}
