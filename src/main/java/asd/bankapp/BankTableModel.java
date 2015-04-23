package asd.bankapp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import mum.asd.fw.FWTableModel;
import mum.asd.fw.account.Account;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.gui.Column;
import mum.asd.fw.service.AccountService;

public class BankTableModel extends FWTableModel {
	Logger logger = Logger.getLogger(BankTableModel.class.getName());

	public BankTableModel(AccountService as) {
		super(new ArrayList<Column>(), as);

		cols.add(new Column("Accnr", false));
		cols.add(new Column("Name", false));
		cols.add(new Column("city", false));
		cols.add(new Column("P/C", false));
		cols.add(new Column("Ch/S", false));
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
		Account item = (Account) accountList.get(rowIndex);
		switch (columnIndex) {
		case 0:// "AccountNr", "Name", "City", "P/C", "Ch/S", "Amount"
			return item.getAccnr();
		case 1:
			return item.getCustomer().getName();
		case 2:
			return item.getCustomer().getAddress().getCity();
		case 3:
			return item.getCustomer().getType();
		case 4:
			return item.getAccountType();
		case 5:
			return item.getBalance();

		default:
			return null;
		}
	}

	public void setAccountService(AccountService as) {
		this.accountService = as;
	}

	public void refreshData() {
		try {
			accountList.clear();
			accountList.addAll(accountService.getAll());
			for (IAccount account : accountList) {
				System.out.println(account.getBalance());
			}
		} catch (Exception e) {
 			logger.info("Sql exception on getting all account");
		}

	}

}
