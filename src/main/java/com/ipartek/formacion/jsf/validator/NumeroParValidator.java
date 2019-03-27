package com.ipartek.formacion.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@FacesValidator("espar")
public class NumeroParValidator implements Validator {
	
	private static final Logger LOG = LogManager.getRootLogger();

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		LOG.info("validate");
		int number = ((Integer) value).intValue();

		if (number % 2 != 0) {
			LOG.warn("No pasa la validacion");
			String summary = number + " No es numero par *sumary*";
			String detail = number + "No es numero par *detail*";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail );
			throw new ValidatorException(message);
		}

	}

}
