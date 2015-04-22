package asd.bankapp;

import java.util.ArrayList;
import java.util.List;

import asd.bankapp.dao.AccountDao;
import asd.bankapp.dao.TransactionDao;
import mum.asd.fw.FWApplication;
import mum.asd.fw.FWTableModel;
import mum.asd.fw.account.TransactionType;
import mum.asd.fw.form.AccountForm;
import mum.asd.fw.gui.Column;
import mum.asd.fw.gui.DialogButton;
import mum.asd.fw.gui.FormButton;
import mum.asd.fw.service.AccountService;
import mum.asd.fw.service.TransactionService;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		FWApplication app = new FWApplication();
		app.setTitle("Banking Application");
		List<DialogButton> dialogButts = new ArrayList<DialogButton>();
		dialogButts.add(new DialogButton("Deposit", TransactionType.DEPOSIT));
		dialogButts.add(new DialogButton("Withdraw", TransactionType.WITHDRAW));
		app.setDialogButts(dialogButts);

		List<FormButton> formButts = new ArrayList<FormButton>();
		FormButton addPersonal = new FormButton("AddPersonalAccount",
				AccountForm.PERSONAL);
		FormButton addCompany = new FormButton("AddCompanyAccount",
				AccountForm.COMPANY);
		formButts.add(addPersonal);
		formButts.add(addCompany);
		app.setFormButts(formButts);
		AccountDao aDao = new AccountDao();
		TransactionDao tDao = new TransactionDao();

		AccountService as = new BankAccountService(aDao);
		TransactionService ts = new BankTransactionService(aDao, tDao);

		List<Column> cols = getColumns();
		FWTableModel tm = new FWTableModel(cols, as);
		app.setAccountService(as);
		app.setTransactionService(ts);
		tm.setAccountService(as);
		app.setTableModel(tm);
		app.init();
		app.start();
	}

	private static List<Column> getColumns() {
		List<Column> cols = new ArrayList<Column>();

		cols.add(new Column("Accnr", false));
		cols.add(new Column("Name", false));
		cols.add(new Column("city", false));
		cols.add(new Column("P/C", false));
		cols.add(new Column("Ch/S", false));
		cols.add(new Column("balance", false));
		return cols;
	}
}
