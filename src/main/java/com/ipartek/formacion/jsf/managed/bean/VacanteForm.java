package com.ipartek.formacion.jsf.managed.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

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
		
	}// enviar
	
	
	
	public void codigoPostalListener( ValueChangeEvent valueChangeEvent) {
		LOG.info("valor modificado");
		FacesContext fc = FacesContext.getCurrentInstance();
		UIViewRoot uiViewRoot = fc.getViewRoot();
		String newCodigoPostal = valueChangeEvent.getNewValue().toString();		
		
		//busca elementos por su ID => formulario:input
		UIInput uiInputCiudad = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
		
		if ( "48902".equals(newCodigoPostal) ) {
			
			uiInputCiudad.setValue("Barakaldo");
			uiInputCiudad.setSubmittedValue("Barakaldo");			
		}else {
			uiInputCiudad.setValue("");
			uiInputCiudad.setSubmittedValue("");		
		}
		
		fc.renderResponse();
		
		
	}// codigoPostalListener

}
