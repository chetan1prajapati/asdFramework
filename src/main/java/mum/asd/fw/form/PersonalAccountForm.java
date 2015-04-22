package mum.asd.fw.form;

import java.util.ArrayList;
import java.util.List;

import mum.asd.fw.gui.InputField;
import mum.asd.fw.gui.SelectOneInput;

public class PersonalAccountForm extends AbstractForm {

	public String getTitle() {
		return "Personal Account";
	}

	public List<InputField> getInputFields() {
		List<InputField> list = new ArrayList<InputField>();
		InputField name = new InputField(1, "Name", "");

		list.add(name);
		return list;
	}

	public SelectOneInput getSelectOneInput() {

		return null;
	}

}
