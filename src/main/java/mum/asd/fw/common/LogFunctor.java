package mum.asd.fw.common;

import mum.asd.fw.account.IAccount;

public interface LogFunctor<T,E,R> {
	public void preMessage(T action);
	public  void postMessage(IAccount element1, R element2);
}
