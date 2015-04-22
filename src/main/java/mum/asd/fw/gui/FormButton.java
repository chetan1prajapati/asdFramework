package mum.asd.fw.gui;

import mum.asd.fw.form.AccountForm;

public class FormButton {
	private String label;
	private AccountForm formType;

	public FormButton(String label, AccountForm formType) {
		this.formType = formType;
		this.label = label;
	}

	public AccountForm getFormType() {
		return formType;
	}

	public void setFormType(AccountForm form) {
		this.formType = form;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
