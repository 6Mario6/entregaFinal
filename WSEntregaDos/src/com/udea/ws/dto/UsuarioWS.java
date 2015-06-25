package com.udea.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioWS {
	/**
	 * la id del usuario
	 */
	private int idUsuario;
	/**
	 * el nombre del usuario
	 */
	private String nombre;
	/**
	 * el apellido del usuario
	 */
	private String apellido;
	/**
	 * el email del usuario
	 */
	private String email;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
