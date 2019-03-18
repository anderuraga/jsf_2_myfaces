package com.ipartek.formacion.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class VacanteForm {

	
	
	public VacanteForm() {
		super();		
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
		
		String view = "fallo";
		if ( "admin".equals(this.candidato.getNombre()) ) {
			view = "exito";
		}
		
		return view;
		
	}

}
