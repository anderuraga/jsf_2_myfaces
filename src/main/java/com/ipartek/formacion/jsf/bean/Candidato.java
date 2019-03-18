package com.ipartek.formacion.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean
@RequestScoped
public class Candidato {
	
	private static final Logger LOG = LogManager.getRootLogger();
	
	private String nombre;
	private String apellido;
	private int sueldo;

	public Candidato() {
		super();
		this.nombre = "Nombre Sin Especificar";
		this.apellido = "";
		this.sueldo = 0;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		LOG.info("Los setters se hacen en la fase 4, si hay errores de validacion no se ejecuta 4 y 5");
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Candidato [nombre=" + nombre + ", apellido=" + apellido + ", sueldo=" + sueldo + "]";
	}
	
}
