package com.douglaz.system.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class MessageReturn {
	
	@Autowired
	static MessageSource messageSource;
	 
	public static String errorFields(BindingResult bindingResult) {

        String messages = "Inválid Fields \n";

        messages += bindingResult.getAllErrors().stream().filter((object) -> (object instanceof FieldError))
                .map((object) -> (FieldError) object).map((fieldError) -> fieldError.getField() + " - " + messageSource.getMessage(fieldError, null) + "\n")
                .reduce(messages, String::concat);

        return messages;
    }

}
