package asd.creditCard;

import java.util.List;

import mum.asd.fw.FWTableModel;
import mum.asd.fw.account.Account;
import mum.asd.fw.account.CreditCardAccount;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.gui.Column;
import mum.asd.fw.service.AccountService;

public class CCTableModel extends FWTableModel {

	public CCTableModel(List<Column> col, AccountService as) {
		super(col, as);
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
		CreditCardAccount item = (CreditCardAccount) accountList.get(rowIndex);
		switch (columnIndex) {
		case 0:// "AccountNr", "Name", "City", "P/C", "Ch/S", "Amount"
			return item.getCustomer().getName();
		case 1:
			return item.getCcNo();
		case 2:
			return item.getExpDate();
		case 3:
			return item.getType();
		case 4:
			return item.getLastMonthBal();
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

		accountList = accountService.getAll();
		for (IAccount account : accountList) {
			System.out.println(account.getBalance());
		}

	}

}
