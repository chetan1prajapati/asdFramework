package mum.asd.fw.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mum.asd.fw.FWDialog;
import mum.asd.fw.account.IAccount;

public class DialogButtonListener implements ActionListener,
		ListSelectionListener {
	int index = -1;
	List<IAccount> accounts;
	FWDialog dialog;
	JTable table;

	public DialogButtonListener(List<IAccount> list, FWDialog dialog,
			JTable table) {
		this.accounts = list;
		this.dialog = dialog;
		this.table = table;
	}

	public void actionPerformed(ActionEvent e) {
		//System.out.println("OOOOOOOOOOOOOOOo");
		if (index > -1)
			dialog.setVisible(true);
		else
			JOptionPane.showMessageDialog(dialog, "Select One Customer!!");
	}

	public void valueChanged(ListSelectionEvent e) {

		if (!e.getValueIsAdjusting()) {

			// JTable table = (JTable) e.getSource();
			index = table.getSelectedRow();

			if (index >= 0) {
				//System.out.println(accounts.get(index));
				dialog.setAccount(accounts.get(index));
			}

		}

	}
}
