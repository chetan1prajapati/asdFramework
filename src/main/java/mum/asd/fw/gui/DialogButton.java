package mum.asd.fw.gui;

import mum.asd.fw.account.TransactionType;

public class DialogButton {
	private String label;
	TransactionType transactionType;

	public DialogButton(String label, TransactionType t) {
		this.label = label;
		this.transactionType = t;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

}
