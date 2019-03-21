package com.ipartek.formacion.jsf.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 
 * name = "nombre" del ManagedBean para referenciarlo, si no se usa el mismo nombre de la clase
 * eager = "true" then managed bean is created before it is requested for the first time otherwise "lazy" initialization is used in which bean will be created only when it is requested
 * requestScoped = Ambito de Request
 * 
 */

@ManagedBean(name="navegacionEjemplo1", eager=true)
@RequestScoped
public class NavegacionDinamicaForm {

	private static final Logger LOG = LogManager.getRootLogger();
	
	@ManagedProperty(value="#{nombre}")
	private String nombre;
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public NavegacionDinamicaForm() {
		super();		
		LOG.info("constructor @RequestScoped");		
		this.nombre = "";
	}
	
	
	/**
	 * Navegacion dinamica a traves de este ManagedBean
	 * @return outcome String nombre de la vista  redireccionar
	 */
	public String accion(){
		LOG.info("accion nombre=" + this.nombre);
		if ( "admin".equals(this.nombre) ) {
			return "index";
		}else {
			return "nagevacion";
		}
		
	}
	
	

}
