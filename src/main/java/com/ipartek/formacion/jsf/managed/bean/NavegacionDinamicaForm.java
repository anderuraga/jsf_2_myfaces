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
	
	
	private String nombre;
	
	/**
	 * Se puede hacer mejor y gestionar los mensajes con JSF
	 */
	private String mensaje;
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public NavegacionDinamicaForm() {
		super();		
		LOG.info("constructor @RequestScoped");		
		this.nombre = "";
		this.mensaje = "";
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
			this.mensaje = "*Escribe \"admin\" para ir a la index.xhtml si no vuelves a esta misma pagina";
			return "nagevacion";
		}
		
	}
	
	

}
