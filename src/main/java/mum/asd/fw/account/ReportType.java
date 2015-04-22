package mum.asd.fw.account;

public enum ReportType {
	MONTHLY_REPORT("Monthly Report");
	String value;

	private ReportType(String str) {
		this.value = str;
	}

	public String getValue() {
		return value;
	}
}
