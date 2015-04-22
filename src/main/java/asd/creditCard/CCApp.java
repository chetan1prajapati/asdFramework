package asd.creditCard;

import java.util.ArrayList;
import java.util.List;

import mum.asd.fw.FWApplication;
import mum.asd.fw.FWTableModel;
import mum.asd.fw.account.TransactionType;
import mum.asd.fw.form.AccountForm;
import mum.asd.fw.gui.Column;
import mum.asd.fw.gui.DialogButton;
import mum.asd.fw.gui.FormButton;
import mum.asd.fw.gui.ReportButton;
import mum.asd.fw.service.AccountService;
import mum.asd.fw.service.TransactionService;
import asd.bankapp.BankAccountService;
import asd.bankapp.BankTransactionService;
import asd.bankapp.dao.AccountDao;
import asd.bankapp.dao.TransactionDao;

public class CCApp {

	public static void main(String[] args) {
		FWApplication app = new FWApplication();
		app.setTitle("Credit Card Application");
		List<DialogButton> dialogButts = new ArrayList<DialogButton>();
		dialogButts.add(new DialogButton("Deposit", TransactionType.DEPOSIT));
		dialogButts.add(new DialogButton("Charge", TransactionType.CHARGE));
		app.setDialogButts(dialogButts);

		List<FormButton> formButts = new ArrayList<FormButton>();
		FormButton addPersonal = new FormButton("AddCreditCardAccount",
				AccountForm.CREDIT_CARD);
		formButts.add(addPersonal);
		app.setFormButts(formButts);

		List<ReportButton> reportButts = new ArrayList<ReportButton>();
		reportButts.add(new ReportButton("Get Monthly Report"));
		app.setReportButts(reportButts);
		AccountDao aDao = new AccountDao();
		TransactionDao tDao = new TransactionDao();

		AccountService as = new BankAccountService(aDao);
		TransactionService ts = new BankTransactionService(aDao, tDao);

		List<Column> cols = getColumns();
		FWTableModel tm = new CCTableModel(cols, as);
		app.setAccountService(as);
		app.setTransactionService(ts);
		tm.setAccountService(as);
		app.setTableModel(tm);
		app.init();
		app.start();
	}

	private static List<Column> getColumns() {
		List<Column> cols = new ArrayList<Column>();

		cols.add(new Column("Name", false));
		cols.add(new Column("CC Number", false));
		cols.add(new Column("Exp Date", false));
		cols.add(new Column("Type", false));
		cols.add(new Column("Balance", false));
		return cols;
	}
}
