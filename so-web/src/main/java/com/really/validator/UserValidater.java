package com.really.validator;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.really.model.UserData;

@Component
public class UserValidater
{
	public boolean supports(Class<?> clazz) {
		return UserData.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors)
	{
		UserData userData=(UserData)target;
		//ValidationUtils.rejectIfEmpty(errors, "userId", "error.id.empty");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.firstname.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.lastname.empty");
		ValidationUtils.rejectIfEmpty(errors, "sex", "error.sex.empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "error.address.empty");
		ValidationUtils.rejectIfEmpty(errors, "phoneNo", "error.contact.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.email.empty");
		//ValidationUtils.rejectIfEmpty(errors, "pwd", "error.pwd.empty");
		
		if (userData.getEmail() != null && userData.getEmail().trim().length() > 0) {
			boolean b = ValidationUtil.validateEmail(userData.getEmail());
			if (userData.getEmail().contains("@") != true && !b) {
				errors.rejectValue("email", "error.email.first.rule");
			} else if (userData.getEmail().contains(".com") != true
					&& userData.getEmail().contains(".net") != true
					&& userData.getEmail().contains(".co.in") != true && !b) {
				errors.rejectValue("email", "error.email.second.rule");
			} else if (!b) {
				errors.rejectValue("email", "error.email.required");
			}
		}
		
		if (userData.getPhoneNo() != null && userData.getPhoneNo()!= "") {
			boolean b = ValidationUtil.validateContactNO(userData.getPhoneNo());
			
			if (userData.getPhoneNo().length() < 10) {
				errors.rejectValue("phoneNo", "error.contact.length");
			}
			else if (!b) {
				errors.rejectValue("phoneNo", "error.contact.type");
			}
			
		}
		
		
		
		
	}
	
}
