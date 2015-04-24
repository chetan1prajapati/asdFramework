package mum.asd.fw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

import asd.creditCard.CCTransactionService;
import asd.creditCard.account.CCAccount;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.controller.AddAccountController;
import mum.asd.fw.party.Address;
import mum.asd.fw.party.Customer;
import mum.asd.fw.service.AccountService;
import mum.asd.fw.service.TransactionService;

public class FWReport extends JDialog implements ActionListener {

	StringBuilder billstring = new StringBuilder();
	protected AccountService accountService;
	protected TransactionService transactionService;
	JFrame parentframe;

	public FWReport() {
		this.parentframe = new JFrame();
		getContentPane().setLayout(null);
		setSize(405, 367);
		// setVisible(false);
		setModal(true);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24, 24, 358, 240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0, 0, 355, 237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156, 276, 96, 24);

		// generate the string for the monthly bill

		JTextField1.setText(billstring.toString());
		// }}

		// {{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		// }}
	}

	public void show1() {

		try {
			List<IAccount> accounts = accountService.getAll();
			for (IAccount ia : accounts) {
				
				CCAccount a = (CCAccount) ia;
				Customer c = a.getCustomer();
				Address add = c.getAddress();
				billstring.append("Name= " + c.getName() + "\n");
				billstring.append("Address= " + add.getStreet() + ", "
						+ add.getCity() + ", " + add.getState() + ", "
						+ add.getZip() + "\n");
				billstring.append("\nCC number = " + a.getAccnr());
				billstring.append("\nCC type = " + a.getCCType());
				CCTransactionService ts = (CCTransactionService) transactionService;
				billstring.append("\nPrevious Balance = $"
						+ ts.getPreviousBalance(a));
				billstring.append("\nTotal Credits = $" + ts.getTotalCredits(a));
				billstring.append("\nTotal Charges = $" + ts.totalCharges(a));
				billstring.append("\nnew Balance = $" + a.getBalance());
				billstring.append("\nTotal amount due = $"
						+ ts.getTotalAmountDue(a));
				billstring.append("\n");
				billstring.append("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JTextField1.setText(billstring.toString());
		// this.setVisible(true);
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	// {{DECLARE_CONTROLS
	javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	javax.swing.JTextArea JTextField1 = new javax.swing.JTextArea();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();

	// }}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public TransactionService getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	

}
