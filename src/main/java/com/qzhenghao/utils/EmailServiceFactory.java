package com.qzhenghao.utils;

public class EmailServiceFactory {

	public static EmailService getEmailService(){
		return new EmailServiceImpl();
	}
}
