package com.ipartek.formacion.jsf.managed.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean(eager=true)
@RequestScoped
public class ConversoresForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getRootLogger();
	
	private String nombre;
	private int edad;
	private float precio;
	private Date fecha;
	private DniBean dni;
	
	public ConversoresForm() {
		super();
		LOG.info("    ConversoresForm constrcutor");
		this.nombre = "Ander";
		this.edad = 37;
		this.precio = 2500.556f; 
		this.fecha = new Date();
		this.dni = new DniBean();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
		
	
	public DniBean getDni() {
		return dni;
	}

	public void setDni(DniBean dni) {
		this.dni = dni;
	}

	public String enviar() {
		LOG.info("    submitado formulario accion: enviar");
		LOG.info("    valor del precio= " + this.precio );
		
		return "conversores";
	}
	
	public String validar() {
		
		LOG.info(" submitado formulario accion: validar");
		
		return "validaciones";
	}
	

}
