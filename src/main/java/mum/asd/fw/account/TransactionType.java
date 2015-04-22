package mum.asd.fw.account;

public enum TransactionType {
	DEPOSIT("Deposit"), WITHDRAW("Withdraw"), CHARGE("Charge");
	String value;

	private TransactionType(String str) {
		this.value = str;
	}

	public String getValue() {
		return value;
	}
}
