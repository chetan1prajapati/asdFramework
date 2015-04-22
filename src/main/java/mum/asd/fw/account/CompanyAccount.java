package mum.asd.fw.account;

import mum.asd.fw.party.Company;

public class CompanyAccount extends Account {
	public CompanyAccount() {
		super(new Company("", null, 0));
		// TODO Auto-generated constructor stub
	}

	public CompanyAccount(Company company) {
		super(company);
	}

	@Override
	public Double getInterestRate() {
		return null;
	}

}
