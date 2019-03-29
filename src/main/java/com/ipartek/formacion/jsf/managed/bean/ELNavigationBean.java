package com.ipartek.formacion.jsf.managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Size;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean
@RequestScoped
public class ELNavigationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getRootLogger();

	@Size(min = 3, max = 5, message="para txulo txulo esto")
	private String saludo;

	private boolean show;

	public ELNavigationBean() {
		super();
		LOG.info("construido");
		this.saludo = "";
		this.show = false;
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public String mostrar() {
		LOG.info("saludar accion");
		this.show = true;
		return "expresionlenguage";
	}

	public String ocultar() {
		LOG.info("ocultar accion");
		this.show = false;
		return "expresionlenguage";
	}

	public String navegar() {
		LOG.info("navegar accion");
		return "index";
	}

}
