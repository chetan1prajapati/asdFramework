package mum.asd.fw;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import mum.asd.fw.account.Account;
import mum.asd.fw.gui.Column;
import mum.asd.fw.service.AccountService;

public class FWTableModel extends AbstractTableModel {

	private List<Column> cols;
	private List<Account> accountList;
	private AccountService accountService;

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

	public Object getValueAt(int rowIndex, int columnIndex) {
		Account item = accountList.get(rowIndex);
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

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public void setAccountService(AccountService as) {
		this.accountService = as;
	}

	public void refreshData() {
		
		accountList = accountService.getAll();
		for (Account account : accountList) {
			System.out.println(account.getBalance());
		}

	}

}

// class TableModel extends AbstractTableModel {
//
// List<Account> accounts = new ArrayList<Account>();
//
// String[] columns = { "AccountNr", "Name", "City", "P/C", "Ch/S", "Amount" };
// private final Class[] columnClass = new Class[] { String.class,
// String.class, String.class, Integer.class, Integer.class,
// Double.class };
// JTable table;
// IAccountService service;
//
// public TableModel(JTable table, AccountService service) {
// this.table = table;
// this.service = service;
// accounts = service.getAll();
//
// }
//
// @Override
// public int getRowCount() {
//
// return accounts.size();
// }
//
// @Override
// public int getColumnCount() {
// return columns.length;
// }
//
// @Override
// public String getColumnName(int column) {
// return columns[column];
// }
//
// @Override
// public Class<?> getColumnClass(int columnIndex) {
// return columnClass[columnIndex];
// }
//
// @Override
// public boolean isCellEditable(int rowIndex, int columnIndex) {
// if (columnIndex == 1)
// return true;
// else
// return false;
// }
//
// @Override
// public Object getValueAt(int rowIndex, int columnIndex) {
// Account item = accounts.get(rowIndex);
// switch (columnIndex) {
// case 0:// "AccountNr", "Name", "City", "P/C", "Ch/S", "Amount"
// return item.getAccNr();
// case 1:
// return item.getCustomer().getName();
// case 2:
// return item.getCustomer().getAddress().getCity();
// case 3:
// return item.getCustomer().getType();
// case 4:
// return item.getAccountType();
// case 5:
// return item.getBalance();
//
// default:
// return null;
// }
// }
//
// @Override
// public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
// // System.out.println(rowIndex);
// // BillItem row = items.get(rowIndex);
// //
// // if (0 == columnIndex) {
// // String newValue = (String) aValue;
// // row.setCode(newValue);
// // int index = codeList.indexOf(newValue);
// // if (index > -1) {
// // row.setName(allItems.get(index).getName());
// // row.setRate(allItems.get(index).getRate());
// // }
// // } else if (1 == columnIndex) {
// // String newValue = (String) aValue;
// // row.setName(newValue);
// // int index = nameList.indexOf(newValue);
// // if (index > -1) {
// // row.setCode(allItems.get(index).getCode());
// // row.setRate(allItems.get(index).getRate());
// // }
// // } else if (2 == columnIndex) {
// // row.setQty((Integer) aValue);
// // Float f = row.getRate() * row.getQty();
// // row.setTotal(Math.round(f*100)/100.0f);
// // } else if (3 == columnIndex) {
// // row.setRate((Float) aValue);
// //
// // } else if (4 == columnIndex) {
// // row.setTotal((Float) aValue);
// // }
// //
// // fireTableDataChanged();
// }
//
// public void addEmptyItem() {
// // accounts.add(new BankAccount());
// fireTableDataChanged();
//
// }
//
// public void removeSelected(int[] selectedRows) {
// if (selectedRows.length > 0) {
// for (int i = selectedRows.length - 1; i >= 0; i--) {
// accounts.remove(selectedRows[i]);
// }
// fireTableDataChanged();
// }
//
// }
//
// public void displayItems() {
// // for (BillItem b : items) {
// // System.out.println(b.getQty());
// // }
//
// }
//
// }
