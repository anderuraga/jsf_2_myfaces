package com.ipartek.formacion.jsf.i18n;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean
@SessionScoped
public class IdiomaController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getRootLogger();

	private String localeCode;

	private static Map<String, Object> countries;

	public IdiomaController() {
		super();

		LOG.info("constructor");

		this.localeCode = "eu";

		countries = new LinkedHashMap<String, Object>();
		countries.put("Castellano", "es");
		countries.put("Euskera", "eu");
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	// value change event listener
	public void cambiar(ValueChangeEvent e) {

		String newLocaleValue = e.getNewValue().toString();
		LOG.info("cambiar idioma " + newLocaleValue);

		this.localeCode = newLocaleValue;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(newLocaleValue));
	}

}
