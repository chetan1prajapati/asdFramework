package mum.asd.fw.dao;

import java.sql.SQLException;
import java.util.List;

import mum.asd.fw.common.Functor;
import mum.asd.fw.common.Predicate;

public interface GenericDao<T> {
	void insert(T t) throws SQLException;

	void update(T t) throws SQLException;

	void delete(Integer id) throws SQLException;

	T getById(Integer id) throws SQLException;

	List<T> getAll() throws SQLException;

	<R> void doAll(Functor<T, R> func, Predicate<T> p) throws SQLException;
}
