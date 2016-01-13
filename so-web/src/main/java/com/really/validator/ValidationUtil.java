package com.really.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class ValidationUtil {

	public static boolean validateEmail(String email) {
		
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email != null ? email : "");
		boolean b = m.matches();
		if (!b) {
			return false;
		}
		return true;
	}
	
	public static boolean validateContactNO(String contactNo) {
		
		final String CONTACT_NO = "[789]{1}[0-9]{9}";
		Pattern p = Pattern.compile(CONTACT_NO);
		Matcher m = p.matcher(contactNo != null ? contactNo : "");
		boolean b = m.matches();
		if (!b) {
			return false;
		}
		return true;
	}
}
