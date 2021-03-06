package mum.asd.fw.form;

import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mum.asd.fw.FWForm;
import mum.asd.fw.FWTableModel;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.controller.AddAccountController;
import mum.asd.fw.gui.IForm;
import mum.asd.fw.gui.SelectOneInput;
import mum.asd.fw.party.Address;
import mum.asd.fw.party.Person;
import mum.asd.fw.service.AccountService;
import asd.bankapp.account.CheckingAccount;
import asd.bankapp.account.SavingAccount;

public class AddPersonalForm extends FWForm {
	// AddAccountController controller;
	FWTableModel model;

	public AddPersonalForm(String title, IForm form, FWTableModel model) {
		super(title, form);

		this.parentframe = new JFrame();
		SelectOneInput s1 = form.getSelectOneInput();
		this.model = model;
		setTitle("Add personal account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283, 333);
		setVisible(false);

		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36, 0, 84, 24);
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setSelected(false);
		JRadioButton_Sav.setBounds(36, 24, 84, 24);

		ButtonGroup bg = new ButtonGroup();
		bg.add(JRadioButton_Chk);
		bg.add(JRadioButton_Sav);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 84, 48, 24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 108, 48, 24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12, 132, 48, 24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12, 156, 48, 24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12, 180, 48, 24);
		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 204, 96, 24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12, 228, 48, 24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 84, 156, 20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84, 132, 156, 20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84, 156, 156, 20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84, 108, 156, 20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84, 180, 156, 20);
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84, 204, 156, 20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84, 228, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 264, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 264, 84, 24);

		// {{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);

	}

	// {{DECLARE_CONTROLS
	javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	javax.swing.JLabel JLabel8 = new javax.swing.JLabel();

	// }}

	public IForm getForm() {
		return form;
	}

	public void setForm(IForm form) {
		this.form = form;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void actionPerformed(ActionEvent e) {

	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		try {
			IAccount acc = null;
			Integer zip = Integer.parseInt(JTextField_ZIP.getText());
			Address add = new Address(JTextField_STR.getText(),
					JTextField_CT.getText(), JTextField_ST.getText(), zip);

			Person p = new Person(JTextField_NAME.getText(), add,
					JTextField_BD.getText());
			if (JRadioButton_Chk.isSelected())
				acc = new CheckingAccount(p);
			else
				acc = new SavingAccount(p);

			controller.addPersonalAccount(acc);
			model.refreshData();
			model.fireTableDataChanged();

			dispose();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Invalid number of zip");
		}

	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		// make this frame invisible if Cancel button is clicked
		dispose();
	}

	public AddAccountController getController() {
		return controller;
	}

	public void setController(AddAccountController controller) {
		this.controller = controller;
	}

}
