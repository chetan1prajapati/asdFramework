package mum.asd.fw.form;

import java.util.List;

import mum.asd.fw.gui.IForm;
import mum.asd.fw.gui.InputField;
import mum.asd.fw.gui.SelectOneInput;

public abstract class AbstractForm implements IForm {
	protected String title;
	protected SelectOneInput select;
	protected List<InputField> fields;

	public SelectOneInput getSelect() {
		return select;
	}

	public void setSelect(SelectOneInput select) {
		this.select = select;
	}

	public List<InputField> getFields() {
		return fields;
	}

	public void setFields(List<InputField> fields) {
		this.fields = fields;
	}

}
