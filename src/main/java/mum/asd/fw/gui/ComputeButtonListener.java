package mum.asd.fw.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mum.asd.fw.FWDialog;
import mum.asd.fw.account.Account;
import mum.asd.fw.account.IAccount;
import mum.asd.fw.controller.AddInterestController;
import mum.asd.fw.service.TransactionService;

public class ComputeButtonListener implements ActionListener {

	AddInterestController controller;

	public ComputeButtonListener(AddInterestController controller) {
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			controller.operate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void valueChanged(ListSelectionEvent e) {
	}
}
