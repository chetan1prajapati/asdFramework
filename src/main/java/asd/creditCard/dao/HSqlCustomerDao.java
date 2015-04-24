package asd.creditCard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mum.asd.fw.common.Functor;
import mum.asd.fw.common.Predicate;
import mum.asd.fw.dao.IAddressDao;
import mum.asd.fw.dao.ICustomerDao;
import mum.asd.fw.party.Address;
import mum.asd.fw.party.Company;
import mum.asd.fw.party.Customer;
import mum.asd.fw.party.Person;

public class HSqlCustomerDao implements ICustomerDao {

	private Connection connection;
	IAddressDao addressDao;

	// private List<Customer> lstCustomer;

	public HSqlCustomerDao(Connection connection, IAddressDao addressDao) {
		this.connection = connection;
		this.addressDao = addressDao;
		// lstCustomer = new ArrayList<Customer>();
	}

	public void insert(Customer t) throws SQLException {
		String query = "insert into CUSTOMER(TYPE)" + " values (?)";

		ResultSet rs = null;
		PreparedStatement preparedStmt = connection.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS);
		preparedStmt.setString(1, t.getType());
		int updatedKey = preparedStmt.executeUpdate();
		if (updatedKey == 1) {
			rs = preparedStmt.getGeneratedKeys();
			rs.next();
			int newKey = rs.getInt(1);
			t.setId(newKey);
			// System.out.println(newKey);
			if (t.getType().equals("P")) {
				insertPersonalCustomer(t, newKey);
			} else {
				insertCompanyCustomer(t, newKey);
			}

		}

		// ResultSet keyResultSet = preparedStmt.getGeneratedKeys();
		// int newCustomerId = 0;
		// if (keyResultSet.next()) {
		// newCustomerId = (int) keyResultSet.getInt(1);
		// System.out.println("**"+newCustomerId);
		// }
		//
		// t.setId(newCustomerId);

	}

	private void insertCompanyCustomer(Customer t, int newID)
			throws SQLException {
		String query = " insert into COMPANY_CUSTOMER" + " values ( ?, ?, ?)";

		ResultSet rs = null;
		PreparedStatement preparedStmt = connection.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS);
		preparedStmt.setInt(1, newID);
		preparedStmt.setString(2, t.getName());
		preparedStmt.setInt(3, ((Company) t).getNrOfEmps());

		int updatedKey = preparedStmt.executeUpdate();
		if (updatedKey == 1) {
		}
	}

	private void insertPersonalCustomer(Customer t, int newID)
			throws SQLException {
		String query = " insert into PERSONAL_CUSTOMER" + " values ( ?, ?, ?)";

		ResultSet rs = null;
		PreparedStatement preparedStmt = connection.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS);
		preparedStmt.setInt(1, newID);
		preparedStmt.setString(2, t.getName());
		preparedStmt.setString(3, ((mum.asd.fw.party.Person) t).getDob());

		int updatedKey = preparedStmt.executeUpdate();
		if (updatedKey == 1) {
		}

	}

	public void update(Customer t) throws SQLException {
		// TODO Auto-generated method stub

		String query = " UPDATE CUSTOMER set  ADDRESS = ?, TYPE = ? where CUSTOMER_ID = ?";

		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt(1, t.getId());
		preparedStmt.setString(2, t.getType());
		preparedStmt.setInt(3, t.getId());

		preparedStmt.execute();
		preparedStmt.close();

		if (t.getType().equals("P")) {
			Person p = (Person) t;
			query = " UPDATE PERSONAL_CUSTOMER set  NAME = ?, DOB = ? where CUSTOMER_ID = ?";

			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, p.getName());
			preparedStmt.setString(2, p.getDob());
			preparedStmt.setInt(3, p.getId());

			preparedStmt.executeUpdate();
			preparedStmt.close();
		}

	}

	public void delete(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String query = " SELECT TYPE FROM CUSTOMER where CUSTOMER_ID = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt(1, id);
		ResultSet rs = preparedStmt.executeQuery();
		String type = rs.getString(1);

		query = " DELETE FROM CUSTOMER where CUSTOMER_ID = ?";

		preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt(1, id);

		preparedStmt.execute();

		if (type.equals("P")) {
			query = " DELETE FROM PERSONAL_CUSTOMER where CUSTOMER_ID = ?";
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.executeUpdate();
		}

		else if (type.equals("C"))
			query = " DELETE FROM COMPANY_CUSTOMER where CUSTOMER_ID = ?";
		preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt(1, id);
		preparedStmt.executeUpdate();

		preparedStmt.close();

	}

	public Customer getById(Integer id) throws SQLException {
		// TODO Auto-generated method stub

		String query = " SELECT * from CUSTOMER  JOIN ADDRESS ON ADDRESS.CUSTOMER_ID = CUSTOMER.CUSTOMER_ID";

		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt(1, id);
		ResultSet rs = preparedStmt.executeQuery();

		Address address = null;
		Customer aCustomer = null;

		while (rs.next()) {
			//System.out.println(rs.getString("CUSTOMER.NAME"));
			address = new Address(rs.getString("ADDRESS.STREET"),
					rs.getString("ADDRESS.CITY"),
					rs.getString("ADDRESS.STATE"), rs.getInt("ADDRESS.ZIP"));
			if (rs.getString("CUSTOMER.TYPE").equals("P")) {
				aCustomer = new Person(rs.getString("CUSTOMER.NAME"), address,
						rs.getString("CUSTOMER.DOB"));
			}

			else
				aCustomer = new Company(rs.getString("CUSTOMER.NAME"), address,
						rs.getInt("CUSTOMER.NO_OF_EMPLOYEES"));
		}

		return aCustomer;

	}

	public List<Customer> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Customer> lstCustomer = new ArrayList<Customer>();
		String query = " SELECT * from CUSTOMER where ACCOUNT_ID = ?  JOIN ADDRESS ON ADDRESS.ADDRESS_ID = CUSTOMER.ADDRESS_ID";

		PreparedStatement preparedStmt = connection.prepareStatement(query);
		ResultSet rs = preparedStmt.executeQuery();

		Address address = null;
		Customer aCustomer = null;

		while (rs.next()) {
			address = new Address(rs.getString("ADDRESS.STREET"),
					rs.getString("ADDRESS.CITY"),
					rs.getString("ADDRESS.STATE"), rs.getInt("ADDRESS.ZIP"));
			if (rs.getString("CUSTOMER.TYPE").equals("P"))
				aCustomer = new Person(rs.getString("CUSTOMER.NAME"), address,
						rs.getString("CUSTOMER.DOB"));
			else
				aCustomer = new Company(rs.getString("CUSTOMER.NAME"), address,
						rs.getInt("CUSTOMER.NO_OF_EMPLOYEES"));
			lstCustomer.add(aCustomer);
		}

		return lstCustomer;

	}

	public <R> void doAll(Functor<Customer, R> func, Predicate<Customer> p)
			throws SQLException {

	}

}
