package mum.asd.fw.party;

public class Company extends Customer implements IOrganization {
	public Company(String name, Address address, Integer noe) {
		super(name, address);
		this.nrOfEmps = noe;
	}

	Integer nrOfEmps;

	@Override
	public String getType() {
		return "C";
	}

	public Integer getNrOfEmps() {
		return nrOfEmps;
	}

	public void setNrOfEmps(Integer nrOfEmps) {
		this.nrOfEmps = nrOfEmps;
	}

}
