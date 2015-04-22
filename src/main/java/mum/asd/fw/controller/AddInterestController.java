package mum.asd.fw.controller;

import javax.swing.JOptionPane;

import mum.asd.fw.FWTableModel;
import mum.asd.fw.service.TransactionService;

public class AddInterestController {
	TransactionService transService;
	FWTableModel model;

	public AddInterestController(TransactionService service, FWTableModel model) {
		this.transService = service;
		this.model = model;
	}

	public void operate() {
		transService.addInterest();

		model.refreshData();
		model.fireTableDataChanged();
		JOptionPane.showMessageDialog(null,
				"Added interest to " + model.getRowCount() + " Accounts");
	}
}
