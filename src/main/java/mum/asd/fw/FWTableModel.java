package mum.asd.fw;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.gui.Column;
import mum.asd.fw.service.AccountService;

public abstract class FWTableModel extends AbstractTableModel {

	protected List<Column> cols;
	protected List<IAccount> accountList;
	protected AccountService accountService;

	public FWTableModel(List<Column> col, AccountService as) {
		cols = col;
		this.accountService = as;
		accountList = accountService.getAll();
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
		// TODO Auto-generated method stub
		return accountList.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols.size();
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


