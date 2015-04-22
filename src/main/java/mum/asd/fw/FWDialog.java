package mum.asd.fw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mum.asd.fw.account.Account;
import mum.asd.fw.controller.TransactionController;

//inject through DI with actionListener
public class FWDialog extends JDialog implements ActionListener {
	Account account;
	JLabel amountLabel;
	JLabel nameLabel;
	JTextField nameField;
	JTextField amountField;
	JButton okButton;
	JButton cancelButton;

	TransactionController controller;

	FWTableModel model;

	public FWDialog(String str, FWTableModel model) {
		this.amountLabel = new JLabel("Amount : ");
		this.nameLabel = new JLabel("Name : ");
		this.amountField = new JTextField();
		this.nameField = new JTextField();
		this.okButton = new JButton("OK");
		this.cancelButton = new JButton("Cancel");
		this.model = model;

		setModal(true);
		getContentPane().setLayout(null);
		setSize(268, 126);
		setVisible(false);
		this.setTitle(str);
		getContentPane().add(nameLabel);
		nameLabel.setForeground(java.awt.Color.black);
		nameLabel.setBounds(12, 12, 48, 24);
		amountLabel.setText("Amount");
		getContentPane().add(amountLabel);
		amountLabel.setForeground(java.awt.Color.black);
		amountLabel.setBounds(12, 48, 48, 24);
		nameField.setEditable(false);
		getContentPane().add(nameField);
		nameField.setBounds(84, 12, 144, 24);
		okButton.setText("OK");
		okButton.setActionCommand("OK");
		getContentPane().add(okButton);
		okButton.setBounds(36, 84, 84, 24);
		cancelButton.setText("Cancel");
		cancelButton.setActionCommand("Cancel");
		getContentPane().add(cancelButton);
		cancelButton.setBounds(156, 84, 84, 24);
		getContentPane().add(amountField);
		amountField.setBounds(84, 48, 144, 24);
		// nameField.setText(account.getName());

		okButton.addActionListener(this);
		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FWDialog.this.setVisible(false);
				FWDialog.this.dispose();
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		controller.operate(account,
				Double.parseDouble(amountField.getText().trim()));
		model.refreshData();
		model.fireTableDataChanged();

	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
		this.nameField.setText(account.getCustomer().getName());
	}

	public JLabel getAmountLabel() {
		return amountLabel;
	}

	public void setAmountLabel(JLabel amountLabel) {
		this.amountLabel = amountLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getAmountField() {
		return amountField;
	}

	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public TransactionController getController() {
		return controller;
	}

	public void setController(TransactionController controller) {
		this.controller = controller;
	}

}