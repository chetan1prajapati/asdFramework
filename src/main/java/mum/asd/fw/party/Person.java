package mum.asd.fw.party;


public class Person extends Customer implements IPerson {
	public Person(String name, Address address, String dob) {
		super(name, address);
		this.dob = dob;
	}

	String dob;

	@Override
	public String getType() {
		return "P";
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDob() {
		return dob;
	}
}
