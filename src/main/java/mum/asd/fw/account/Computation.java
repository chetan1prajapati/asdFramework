package mum.asd.fw.account;

public enum Computation {
	ADD_INTEREST("Add Interest");
	String value;

	private Computation(String str) {
		this.value = str;
	}

	public String getValue() {
		return value;
	}
}
