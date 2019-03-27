package com.ipartek.formacion.jsf.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.flow.FlowScoped;

@ManagedBean
@FlowScoped(value="flowBean")
public class FlowBean {
	
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
