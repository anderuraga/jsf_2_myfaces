package com.ipartek.formacion.jsf.managed.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean(eager = true)
@RequestScoped
public class LoginForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getRootLogger();

	@PostConstruct
	public void initialize() {
		LOG.info("PostConstruct");
	}

	@PreDestroy
	public void shutdown() {
		LOG.info("shutdown");
	}

	@NotNull
	@Size(min = 2, max = 150)
	private String nombre;

	@NotNull
	@Size(min = 3, max = 6)
	private String password;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginForm() {
		super();
		LOG.info("LoginForm constructor");
		this.nombre = "";
		this.password = "";
	}

	public String check() {
		LOG.info("check nombre=" + this.nombre + " password=" + this.password);
		String view = "login";

		if ("admin".equalsIgnoreCase(this.nombre) && "admin".equalsIgnoreCase(password)) {
			view = "login-exito";
		} else {
			view = "login";
		}

		return view;
	}

}
