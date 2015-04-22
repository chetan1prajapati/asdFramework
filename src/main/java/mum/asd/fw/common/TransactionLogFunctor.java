package mum.asd.fw.common;

import java.text.DecimalFormat;

import mum.asd.fw.account.Account;
import mum.asd.fw.account.IAccount;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TransactionLogFunctor implements LogFunctor<String, IAccount, Double> {
	Logger logger;
	StringBuffer sb;

	public TransactionLogFunctor() {
		logger = Logger.getLogger(TransactionLogFunctor.class.getName());
		PropertyConfigurator.configure("log4j.properties");
	}

	@Override
	public void preMessage(String action) {
		logger.info("Action: " + action);
	}

	@Override
	public void postMessage(IAccount account, Double amount){
		DecimalFormat df = new DecimalFormat("#####.00");
		
		sb = new StringBuffer("");
		sb.append("Account ID: " + ((Account)account).getAccnr());
		sb.append(" | Name: " + ((Account)account).getCustomer().getName());
		sb.append(" | Account Type: " + ((Account)account).getAccountType());
		sb.append(" | Balance: " + df.format(((Account)account).getBalance()));
		sb.append(" | Deposited Amount: " + df.format(amount));
		logger.info(sb);
		logger.info("========================================");
	}

	
	
}
