package mum.asd.fw.common;

public interface Functor<T, R> {
	void execute(T t);

	R getValue();
}
