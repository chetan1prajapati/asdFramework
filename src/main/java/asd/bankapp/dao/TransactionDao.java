package asd.bankapp.dao;

import java.util.List;

import mum.asd.fw.account.Entry;
import mum.asd.fw.common.Functor;
import mum.asd.fw.common.Predicate;
import mum.asd.fw.dao.GenericDao;
import mum.asd.fw.dao.ITransactionDao;
import mum.asd.fw.data.DataSource;

public class TransactionDao implements ITransactionDao {

	public void insert(Entry t) {

	}

	public void update(Entry t) {
		// TODO Auto-generated method stub

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public Entry getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Entry> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public <R> void doAll(Functor<Entry, R> func, Predicate<Entry> p) {
		// TODO Auto-generated method stub

	}

}
