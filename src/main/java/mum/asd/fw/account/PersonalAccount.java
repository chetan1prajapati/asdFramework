package mum.asd.fw.account;

import mum.asd.fw.party.Person;

public class PersonalAccount extends Account {

	public PersonalAccount() {
		super(new Person("", null, ""));
	}

	@Override
	public Double getInterestRate() {
		// TODO Auto-generated method stub
		return null;
	}


}
