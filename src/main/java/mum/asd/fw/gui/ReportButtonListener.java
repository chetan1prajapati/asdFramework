package mum.asd.fw.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mum.asd.fw.FWForm;
import mum.asd.fw.FWReport;

public class ReportButtonListener implements ActionListener {

	FWReport report;

	public ReportButtonListener(FWReport report) {
		this.report = report;

	}

	public void actionPerformed(ActionEvent e) {

		report.setVisible(true);

	}

}
