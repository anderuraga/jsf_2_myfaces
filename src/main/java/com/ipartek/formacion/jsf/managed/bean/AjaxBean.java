package com.ipartek.formacion.jsf.managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "ajaxBean", eager = true)
@RequestScoped
public class AjaxBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getSaludo() {
		return "Kaixo " + this.nombre;
	}

}
