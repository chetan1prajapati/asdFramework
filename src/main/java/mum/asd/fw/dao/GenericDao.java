package mum.asd.fw.dao;

import java.util.List;

import mum.asd.fw.common.Functor;
import mum.asd.fw.common.Predicate;

public interface GenericDao<T> {
	void insert(T t);

	void update(T t);

	void delete(Integer id);

	T getById(Integer id);

	List<T> getAll();

	<R> void doAll(Functor<T, R> func, Predicate<T> p);
}
