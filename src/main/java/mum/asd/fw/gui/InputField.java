package mum.asd.fw.gui;

public class InputField {
	private Integer key;
	private String label;
	private String exp;

	public InputField(Integer key, String label, String exp) {
		this.label = label;
		this.exp = exp;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

}
