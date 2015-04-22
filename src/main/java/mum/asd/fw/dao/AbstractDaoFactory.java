package mum.asd.fw.dao;

public interface AbstractDaoFactory {
	
	public IAccountDao getAccountDao();

	public IAddressDao getAddressDao();

	public ICustomerDao getCustomerDao();

	public ITransactionDao getTransactionDao();

}
