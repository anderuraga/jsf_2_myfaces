package com.ipartek.formacion.jsf.managed.bean;

public class DniBean {

	private String numero;
	private String letra;

	public DniBean() {
		super();
		this.numero = "";
		this.letra = "";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	@Override
	public String toString() {
		return "DniBean [numero=" + numero + ", letra=" + letra + "]";
	}

}
