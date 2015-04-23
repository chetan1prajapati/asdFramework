package mum.asd.fw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mum.asd.fw.account.IAccount;
import mum.asd.fw.controller.TransactionController;
import mum.asd.fw.controller.WithdrawController;

//inject through DI with actionListener
public class FWDialog extends JDialog implements ActionListener {
	IAccount account;
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
		setSize(268, 156);
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
		try {
			double amount = Double.parseDouble(amountField.getText().trim());
			controller.operate(account, amount);
			model.refreshData();
			model.fireTableDataChanged();
			

			dispose();
			if (account.getCustomer().getType().equals("C"))
				JOptionPane.showMessageDialog(this,
						"transaction on company account!!");
			if (controller instanceof WithdrawController)
				if (account.getBalance() < 0)
					JOptionPane.showMessageDialog(this,
							"Negative Balance remaining!!");
				else if (amount > 500)
					JOptionPane
							.showMessageDialog(this, "amount exceeded 500!!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Enter a valid Number!!");
		}

	}

	public IAccount getAccount() {
		return account;
	}

	public void setAccount(IAccount account) {
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
