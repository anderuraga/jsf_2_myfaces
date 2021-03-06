package com.ipartek.formacion.jsf.managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.flow.FlowScoped;

@ManagedBean
@FlowScoped(value="flowBean")
public class FlowBean implements Serializable {
	
	private String parametro;
	

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getName() {
		return "FlowBasico";
	}

	public String getReturnValue() {
		return "/salida";
	}

}
