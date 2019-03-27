package com.ipartek.formacion.jsf.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ipartek.formacion.jsf.managed.bean.DniBean;

@FacesConverter("conversorDni")
public class DniConverter implements Converter {

	private static final Logger LOG = LogManager.getRootLogger();
	
	/**
	 * Convierte un String en un objeto del tipo deseado. Lanza una
	 * ConverterException si la conversión no se puede llevar a cabo.
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		LOG.info("**DniConverter getAsObject");
		DniBean dni = new DniBean();

		try {
			dni.setNumero(value.substring(0, 8));
			dni.setLetra(value.substring(8, 9));

		} catch (Exception e) {
			LOG.error(e);
			String summary = "Mensaje al inentar convertir el dni " + e.getMessage();
			String detail = "Mensaje con detalle " + e.getMessage();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail );
			throw new ConverterException(message);
		}

		return dni;
	}

	/**
	 * Convierte un objeto en String para que pueda mostrarse en la pantalla del
	 * usuario
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		LOG.info("**DniConverter getAsString");
		DniBean dni = (DniBean) value;
		String separator = (String) component.getAttributes().get("separador");
		return dni.getNumero() + separator + dni.getLetra();
	}

}
