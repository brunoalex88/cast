package com.obruno.validators;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.obruno.validators.MaxDateValidator")
public class MaxDateValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Date date = (Date) value;
		
		if (date == null)
			return;
		
        if (((Date) value).after(new Date())) {
        	FacesMessage message = 
        			new FacesMessage("Data de recolhimento não pode ser maior que a data atual");
        	message.setSeverity(FacesMessage.SEVERITY_ERROR);
        	throw new ValidatorException(message);
        	
        }
	}

}
