package com.udea.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;
/**<h1> usuario</h1>
Clase encargada de los setter y getter del elemento usuario
 * 
 * @author Jorge Mario Fernandez
 * @version 2.0
 * @since 25-06-15
 *
 */
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
	/**
	 * retorna la id del usuario
	 * @return entero con la id del usuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * establece la id del usuario
	 * @param idUsuario la nueva id del usuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * retorna el nombre del usuario
	 * @return string con el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * establece el nuevo nombre del usuario
	 * @param nombre el nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * retorna el apellido del usuario 
	 * @return String con el apellido del usuario
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * establece el nuevo apellido del usuario
	 * @param apellido el nuevo apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * retorna el email del usuario
	 * @return string con el email del usuario
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * establece el email del usuario
	 * @param email el nuevo email tipo string
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
