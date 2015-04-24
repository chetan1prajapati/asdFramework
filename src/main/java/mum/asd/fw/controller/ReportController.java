package mum.asd.fw.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import mum.asd.fw.FWTableModel;
import mum.asd.fw.service.TransactionService;

public class ReportController {
	TransactionService transService;
	FWTableModel model;

	public ReportController(TransactionService service, FWTableModel model) {
		this.transService = service;
		this.model = model;
	}

	public void operate() throws SQLException {
		transService.addInterest();

		model.refreshData();
		model.fireTableDataChanged();
		JOptionPane.showMessageDialog(null,
				"Added interest to " + model.getRowCount() + " Accounts");
	}
}
