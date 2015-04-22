package mum.asd.fw.form;

public enum AccountForm {
	PERSONAL("Personal"), COMPANY("Company"), CREDIT_CARD("CCAccount");
	String value;

	AccountForm(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}
}
