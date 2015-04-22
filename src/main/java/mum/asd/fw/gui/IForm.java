package mum.asd.fw.gui;

import java.util.List;

public interface IForm {
	String getTitle();

	List<InputField> getInputFields();

	SelectOneInput getSelectOneInput();
}
