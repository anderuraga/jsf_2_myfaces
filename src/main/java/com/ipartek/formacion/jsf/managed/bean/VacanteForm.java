package com.ipartek.formacion.jsf.managed.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ipartek.formacion.jsf.bean.Candidato;
import com.ipartek.formacion.jsf.helper.ProvinciaHelper;

@ManagedBean
@RequestScoped
public class VacanteForm {

	private static final Logger LOG = LogManager.getRootLogger();
	
	public boolean mostrarComentario;
	
	public VacanteForm() {
		super();		
		LOG.info("constructor @RequestScoped");
		this.mostrarComentario = false;
	}
	
	
	
	@ManagedProperty(value="#{candidato}")
	private Candidato candidato;
	
	
	@ManagedProperty(value="#{provinciaHelper}")
	private ProvinciaHelper provinciaHelper;
	
	

	public boolean isMostrarComentario() {
		return mostrarComentario;
	}



	public void setMostrarComentario(boolean mostrarComentario) {
		this.mostrarComentario = mostrarComentario;
	}



	public Candidato getCandidato() {
		return candidato;
	}



	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	
	
	public ProvinciaHelper getProvinciaHelper() {
		return provinciaHelper;
	}

	
	

	public void setProvinciaHelper(ProvinciaHelper provinciaHelper) {
		this.provinciaHelper = provinciaHelper;
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
	
	
	/**
	 * 
	 * @param valueChangeEvent
	 */
	public void codigoPostalListener( ValueChangeEvent valueChangeEvent) {
		LOG.info("codigoPostalListener valor modificado");
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
	
	
	public void comentarioListener( ActionEvent actionEvent) {
		LOG.info("ocultarComentario ActionEvent");
		mostrarComentario = !mostrarComentario;
	}

}
