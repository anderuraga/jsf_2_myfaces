package com.ipartek.formacion.jsf.managed.bean;

public class Usuario {

	private long id;
	private String nombre;
	private String pass;

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.pass = "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + "]";
	}

}
