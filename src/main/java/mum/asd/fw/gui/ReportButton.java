package mum.asd.fw.gui;

import mum.asd.fw.account.ReportType;

public class ReportButton {
	private String label;
	private ReportType reportType;

	public ReportButton(String label, ReportType r) {
		this.label = label;
		this.reportType = r;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

}
