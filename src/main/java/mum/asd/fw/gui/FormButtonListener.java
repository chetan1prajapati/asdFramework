package mum.asd.fw.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mum.asd.fw.FWForm;

public class FormButtonListener implements ActionListener {

	FWForm form;

	public FormButtonListener(FWForm form) {
		this.form = form;
		
	}

	public void actionPerformed(ActionEvent e) {

		form.setVisible(true);
		

	}

}
