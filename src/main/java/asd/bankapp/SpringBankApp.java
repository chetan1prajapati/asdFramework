package asd.bankapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBankApp {

	public static void main(String[] args) {

		String[] contextPaths = new String[] { "bank-application-context.xml" };
		new ClassPathXmlApplicationContext(contextPaths);

	}

}
