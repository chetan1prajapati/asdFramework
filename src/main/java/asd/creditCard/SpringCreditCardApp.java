package asd.creditCard;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCreditCardApp {

	public static void main(String[] args) {

		String[] contextPaths = new String[] { "cc-application-context.xml" };
		new ClassPathXmlApplicationContext(contextPaths);

	}

}
