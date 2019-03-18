package com.ipartek.formacion.jsf.managed.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ipartek.formacion.jsf.bean.Candidato;

@ManagedBean
@RequestScoped
public class VacanteForm {

	private static final Logger LOG = LogManager.getRootLogger();
	
	public VacanteForm() {
		super();		
		LOG.info("constructor @RequestScoped");
	}
	
	
	
	@ManagedProperty(value="#{candidato}")
	private Candidato candidato;



	public Candidato getCandidato() {
		return candidato;
	}



	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	/**
	 * Logica del Controlador para ir a una vista u otra
	 * @return vies o vista a donde vamos
	 */
	public String enviar() {
		
		LOG.info("enviar candidato=" + this.candidato);
		
		String view = "validacion";
		if ( "admin".equals(this.candidato.getNombre()) ) {
			view = "exito";
		}else {
			
			/* 
			 * mensaje personalizado y global, mirar validacion.xhtml
			 * <h:messages globalOnly="true"></h:messages>
			 *  
			 */
			
			String mensaje = "Mensaje global para este formulario, independiente de los mensajes de los atributos";
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje);
			FacesContext fc = FacesContext.getCurrentInstance();
			String clientId = null; 
			fc.addMessage(clientId, fm);
			
			
		}
		
		return view;
		
	}

}
