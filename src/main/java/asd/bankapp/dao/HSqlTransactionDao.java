package asd.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mum.asd.fw.account.IEntry;
import mum.asd.fw.common.Functor;
import mum.asd.fw.common.Predicate;
import mum.asd.fw.dao.IAddressDao;
import mum.asd.fw.dao.ICustomerDao;
import mum.asd.fw.dao.ITransactionDao;
import mum.asd.fw.party.Address;
import mum.asd.fw.party.Company;
import mum.asd.fw.party.Customer;
import mum.asd.fw.party.Person;

public class HSqlTransactionDao implements ITransactionDao {

	private Connection connection;

	public HSqlTransactionDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(IEntry t) throws SQLException {
		String query = "INSERT INTO ENTRY VALUES(null,?,?,?,?) ";
		// ACCOUNT_ID INTEGER NOT NULL,TYPE VARCHAR(20) NOT NULL,DATE
		// VARCHAR(20),AMOUNT

		PreparedStatement preparedStmt = connection.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS);
		preparedStmt.setInt(1, t.getAccount().getAccnr());
		preparedStmt.setString(2, t.getTransactionType().getValue());
		preparedStmt.setString(3, t.getDate());
		preparedStmt.setDouble(4, t.getAmount());

		// execute the preparedstatement

		preparedStmt.executeUpdate();

		// Get the value of autogenerated key in the database
		ResultSet keyResultSet = preparedStmt.getGeneratedKeys();
		int newId = 0;
		if (keyResultSet.next()) {
			newId = (int) keyResultSet.getInt(1);
			// t.setId(newId);
		}

		preparedStmt.close();

	}

	public void update(IEntry t) throws SQLException {
		// TODO Auto-generated method stub

	}

	public IEntry getById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public <R> void doAll(Functor<IEntry, R> func, Predicate<IEntry> p)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	public void delete(Integer id) throws SQLException {
		// TODO Auto-generated method stub

	}

	public List<IEntry> getAll() throws SQLException {
		return null;
	}

}
