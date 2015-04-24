package asd.creditCard.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import mum.asd.fw.dao.AbstractDaoFactory;
import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.dao.IAddressDao;
import mum.asd.fw.dao.ICustomerDao;
import mum.asd.fw.dao.ITransactionDao;

public class HSQLDaoFactory implements AbstractDaoFactory {

	private DataSource dataSource;
	private ICustomerDao customerDao;
	private IAddressDao addressDao;
	private ITransactionDao transactionDao;
	private IAccountDao accountDao;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConnection() {
		return DataSourceUtils.getConnection(dataSource);// getConnection(dataSource);
	}

	public IAccountDao getAccountDao() {
		if (accountDao == null)
			accountDao = new HsqlAccountDao(getConnection(), getAddressDao(),
					getCustomerDao());
		return new HsqlAccountDao(getConnection(), getAddressDao(),
				getCustomerDao());
	}

	public IAddressDao getAddressDao() {
		if (addressDao == null)
			addressDao = new HSqlAddressDao(getConnection());
		return addressDao;
	}

	public ICustomerDao getCustomerDao() {
		if (customerDao == null)
			customerDao = new HSqlCustomerDao(getConnection(), getAddressDao());
		return customerDao;
	}

	public ITransactionDao getTransactionDao() {
		if (transactionDao == null)
			transactionDao = new HSqlTransactionDao(getConnection());
		return transactionDao;
	}

}
