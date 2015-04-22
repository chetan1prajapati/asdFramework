package mum.asd.fw;

import java.util.ArrayList;
import java.util.List;

import mum.asd.fw.account.ReportType;
import mum.asd.fw.account.TransactionType;
import mum.asd.fw.controller.AddAccountController;
import mum.asd.fw.controller.AddInterestController;
import mum.asd.fw.controller.DepositController;
import mum.asd.fw.controller.TransactionController;
import mum.asd.fw.controller.WithdrawController;
import mum.asd.fw.form.AccountForm;
import mum.asd.fw.form.AddCompanyForm;
import mum.asd.fw.form.AddPersonalForm;
import mum.asd.fw.form.CompanyAccountForm;
import mum.asd.fw.form.PersonalAccountForm;
import mum.asd.fw.gui.ComputeButton;
import mum.asd.fw.gui.DialogButton;
import mum.asd.fw.gui.FormButton;
import mum.asd.fw.gui.IForm;
import mum.asd.fw.gui.ReportButton;
import mum.asd.fw.service.AccountService;
import mum.asd.fw.service.TransactionService;

public class FWApplication {
	String title;
	List<FormButton> formButts;
	FWTableModel tableModel;
	List<DialogButton> dialogButts;
	AccountService accountService;
	TransactionService transactionService;

	List<ReportButton> reportButts;
	List<ComputeButton> computeButts;

	FWDialog depositDialog;// = new FWDialog("Deposit",);
	FWDialog withdrawDialog;// = new FWDialog("Withdraw");
	FWDialog chargeDialog;// = new FWDialog("Charge");
	TransactionController depositController;
	TransactionController withdrawController;
	AddAccountController addAccountController;

	AddInterestController addInterestController;

	FWForm personalAccForm;// = new FWForm("AddPersonalAccount");
	FWForm companyAccForm;// = new FWForm("AddCompanyAccount");

	FWReport monthlyReport;

	public FWApplication() {
		formButts = new ArrayList<FormButton>();
		dialogButts = new ArrayList<DialogButton>();
		reportButts = new ArrayList<ReportButton>();
		computeButts = new ArrayList<ComputeButton>();
		// transactionService = new BankTransactionService();

	}

	public void init() {
		depositController = new DepositController(transactionService);
		withdrawController = new WithdrawController(transactionService);
		addAccountController = new AddAccountController(accountService);
		addInterestController = new AddInterestController(transactionService,
				tableModel);
		depositDialog = new FWDialog("Deposit", tableModel);
		depositDialog.setController(depositController);
		withdrawDialog = new FWDialog("Withdraw", tableModel);
		withdrawDialog.setController(withdrawController);
		IForm pform = new PersonalAccountForm();
		IForm cform = new CompanyAccountForm();

		personalAccForm = new AddPersonalForm("AddPersonalAccount", pform,
				tableModel);
		personalAccForm.setController(addAccountController);
		companyAccForm = new AddCompanyForm("AddCompanyAccount", cform,
				tableModel);
		companyAccForm.setController(addAccountController);

		monthlyReport = new FWReport();

	}

	public List<FormButton> getFormButts() {
		return formButts;
	}

	public void setFormButts(List<FormButton> formButts) {
		this.formButts = formButts;
	}

	public FWTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(FWTableModel tm) {
		this.tableModel = tm;
	}

	public List<DialogButton> getDialogButts() {
		return dialogButts;
	}

	public void setDialogButts(List<DialogButton> dialogButts) {
		this.dialogButts = dialogButts;
	}

	public void start() {
		ApplicationBuilder.build(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public FWDialog getDialog(TransactionType transactionType) {
		switch (transactionType) {
		case DEPOSIT:
			return depositDialog;
		case WITHDRAW:
			return withdrawDialog;
		case CHARGE:
			return chargeDialog;
		}
		return null;
	}

	public FWForm getForm(AccountForm formType) {
		switch (formType) {
		case PERSONAL:
			return personalAccForm;
		case COMPANY:
			return companyAccForm;
		case CREDIT_CARD:
			return null;
		}
		return null;
	}

	public FWReport getReport(ReportType reportType) {
		switch (reportType) {
		case MONTHLY_REPORT:
			return monthlyReport;
		}
		return null;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setTransactionService(TransactionService ts) {
		this.transactionService = ts;

	}

	public List<ReportButton> getReportButts() {
		return reportButts;
	}

	public void setReportButts(List<ReportButton> reportButts) {
		this.reportButts = reportButts;
	}

	public void setComputeButtons(List<ComputeButton> computeButtons) {
		this.computeButts = computeButtons;

	}

	public List<ComputeButton> getComputeButts() {
		return computeButts;
	}

	public AddInterestController getAddInterestController() {
		return addInterestController;
	}

}
