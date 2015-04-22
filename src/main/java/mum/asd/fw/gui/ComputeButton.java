package mum.asd.fw.gui;

import mum.asd.fw.account.Computation;

public class ComputeButton {
	private String label;
	private Computation computation;

	public ComputeButton(String label, Computation c) {
		this.label = label;
		this.computation = c;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Computation getComputation() {
		return computation;
	}

	public void setComputation(Computation computation) {
		this.computation = computation;
	}

}
