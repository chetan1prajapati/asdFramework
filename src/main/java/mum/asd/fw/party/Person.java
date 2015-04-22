package mum.asd.fw.party;

import java.util.Date;

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
}
