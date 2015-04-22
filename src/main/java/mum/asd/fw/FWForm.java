package mum.asd.fw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import mum.asd.fw.controller.AddAccountController;
import mum.asd.fw.gui.IForm;
import mum.asd.fw.service.AccountService;

public class FWForm extends JDialog implements ActionListener {
	protected IForm form;
	protected AccountService accountService;
	protected AddAccountController controller;
	protected JFrame parentframe;

	public FWForm(String title, IForm form) {
		this.form = form;
		this.setTitle(title);

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("sfasdf");

	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public AddAccountController getController() {
		return controller;
	}

	public void setController(AddAccountController controller) {
		this.controller = controller;
	}

}
