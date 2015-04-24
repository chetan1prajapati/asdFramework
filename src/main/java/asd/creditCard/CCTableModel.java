package asd.creditCard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import asd.bankapp.BankTableModel;
import asd.creditCard.account.CCAccount;
import mum.asd.fw.FWTableModel;
import mum.asd.fw.account.Account;
import mum.asd.fw.account.CreditCardAccount;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.gui.Column;
import mum.asd.fw.service.AccountService;

public class CCTableModel extends FWTableModel {
	Logger logger = Logger.getLogger(BankTableModel.class.getName());

	public CCTableModel(AccountService as) {
		super(new ArrayList<Column>(), as);

		cols.add(new Column("Name", false));
		cols.add(new Column("CC Number", false));
		cols.add(new Column("Exp Date", false));
		cols.add(new Column("Type", false));
		cols.add(new Column("balance", false));
	}

	public void addColumn(Column col) {
		cols.add(col);
	}

	public List<Column> getCols() {
		return cols;
	}

	public String getColumnName(int column) {
		return cols.get(column).getName();
	}

	public void setCols(List<Column> cols) {
		this.cols = cols;
	}

	public int getRowCount() {
		return accountList.size();
	}

	public int getColumnCount() {
		return cols.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		CCAccount item = (CCAccount) accountList.get(rowIndex);
		switch (columnIndex) {
		case 0:// "AccountNr", "Name", "City", "P/C", "Ch/S", "Amount"
			return item.getCustomer().getName();
		case 1:
			return item.getAccnr();
		case 2:
			return item.getExpiryDate();
		case 3:
			return item.getCCType();
		case 4:
			return item.getBalance();
		default:
			return null;
		}
	}

	public List<IAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<IAccount> accountList) {
		this.accountList = accountList;
	}

	public void setAccountService(AccountService as) {
		this.accountService = as;
	}

	public void refreshData() {

		try {
			accountList.clear();
			accountList.addAll(accountService.getAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
