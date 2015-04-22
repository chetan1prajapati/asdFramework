package mum.asd.fw.gui;

public class Column {
	String name;
	boolean editable;

	public Column(String name, boolean editable) {
		this.name = name;
		this.editable = editable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

}
