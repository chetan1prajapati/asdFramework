package mum.asd.fw.gui;

import java.util.Map;

// may be replace with supclass type Type<Account>
public class SelectOneInput {
	Map<Integer, String> options;

	public SelectOneInput(Map<Integer, String> opts) {
		this.options = opts;
	}
}
