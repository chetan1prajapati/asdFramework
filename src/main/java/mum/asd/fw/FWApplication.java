package mum.asd.fw;

import java.util.ArrayList;
import java.util.List;

import mum.asd.fw.account.ReportType;
import mum.asd.fw.account.TransactionType;
import mum.asd.fw.controller.AddAccountController;
import mum.asd.fw.controller.AddInterestController;
import mum.asd.fw.controller.DepositController;
import mum.asd.fw.controller.ReportController;
import mum.asd.fw.controller.TransactionController;
import mum.asd.fw.controller.WithdrawController;
import mum.asd.fw.dao.AbstractDaoFactory;
import mum.asd.fw.dao.IAccountDao;
import mum.asd.fw.dao.ITransactionDao;
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
	AbstractDaoFactory daoFactory;

	public void setComputeButts(List<ComputeButton> computeButts) {
		this.computeButts = computeButts;
	}

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
	ReportController reportController;

	AddInterestController addInterestController;

	FWForm personalAccForm;// = new FWForm("AddPersonalAccount");
	FWForm companyAccForm;// = new FWForm("AddCompanyAccount");
	FWForm ccAccForm;

	FWReport reportDialog;

	public FWApplication() {
		formButts = new ArrayList<FormButton>();
		dialogButts = new ArrayList<DialogButton>();
		reportButts = new ArrayList<ReportButton>();
		computeButts = new ArrayList<ComputeButton>();
		// transactionService = new BankTransactionService();

	}

	public void init() {
		IAccountDao accountDao = getDaoFactory().getAccountDao();
		ITransactionDao transactionDao = getDaoFactory().getTransactionDao();
		getAccountService().setAccountDao(accountDao);
		getTransactionService().setAccountDao(accountDao);
		getTransactionService().setTransactionDao(transactionDao);
		ApplicationBuilder.build(this);

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
			return ccAccForm;
		}
		return null;
	}

	public FWReport getReport(ReportType reportType) {
		switch (reportType) {
		case MONTHLY_REPORT:
			return reportDialog;
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

	public FWForm getPersonalAccForm() {
		return personalAccForm;
	}

	public void setPersonalAccForm(FWForm personalAccForm) {
		this.personalAccForm = personalAccForm;
	}

	public FWForm getCompanyAccForm() {
		return companyAccForm;
	}

	public void setCompanyAccForm(FWForm companyAccForm) {
		this.companyAccForm = companyAccForm;
	}

	public void setAddInterestController(
			AddInterestController addInterestController) {
		this.addInterestController = addInterestController;
	}

	public FWDialog getDepositDialog() {
		return depositDialog;
	}

	public void setDepositDialog(FWDialog depositDialog) {
		this.depositDialog = depositDialog;
	}

	public FWDialog getWithdrawDialog() {
		return withdrawDialog;
	}

	public void setWithdrawDialog(FWDialog withdrawDialog) {
		this.withdrawDialog = withdrawDialog;
	}

	public FWDialog getChargeDialog() {
		return chargeDialog;
	}

	public void setChargeDialog(FWDialog chargeDialog) {
		this.chargeDialog = chargeDialog;
	}

	public void setDaoFactory(AbstractDaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	public AbstractDaoFactory getDaoFactory() {
		return daoFactory;
	}

	public TransactionService getTransactionService() {
		return transactionService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public ReportController getReportController() {
		return reportController;
	}

	public void setReportController(ReportController reportController) {
		this.reportController = reportController;
	}

	public FWForm getCcAccForm() {
		return ccAccForm;
	}

	public void setCcAccForm(FWForm ccAccForm) {
		this.ccAccForm = ccAccForm;
	}

	public FWReport getReportDialog() {
		return reportDialog;
	}

	public void setReportDialog(FWReport reportDialog) {
		this.reportDialog = reportDialog;
	}

	
	
	

}
