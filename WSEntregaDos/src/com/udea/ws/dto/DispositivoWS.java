package com.udea.ws.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
/**<h1> DispositivoWS</h1>
Clase encargada de los setter y getter de los dispositivos
 * 
 * @author Jorge Mario Fernandez
 * @version 2.0
 * @since 25-06-15
 *
 */
@XmlRootElement
public class DispositivoWS {
	
	//private InventarioDispositivo invDispositivo;
	/**
	 * Entero que define la id del dispositivo
	 */
	private int idDispositivo;
	/**
	 * atributo de la clase estado
	 */
	private String estado;
	/**
	 * String nombre del dispositivo
	 * 
	 */
	private String nombre;
	/**
	 * String que describe el dispositivo
	 */
	private String descripcion;
	/**
	 * atributo de tipo date que determina la fecha de adquisicion
	 */
	private Date fechaAdquisicion;

	/**
	 * retorna la id del dispositivo
	 * @return la id del dispositivo
	 */
	public int getIdDispositivo() {
		return idDispositivo;
	}
	/**
	 * establece la id del dispositivo
	 * @param idDispositivo la nueva id del dispositivo
	 */

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
/**
 * retorna el nombre del dispositivo
 * @return un string con el nombre del dispositivo
 */
	public String getNombre() {
		return nombre;
	}
/**
 * establece el nombre del dispositivo
 * @param nombre string con el nuevo nombre del dispositivo
 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/**
 * retorna la descripcion del dispositivo
 * @return un string con la descripción del dispositivo
 */
	public String getDescripcion() {
		return descripcion;
	}
/**
 * establece la descripcion del dispositivo
 * @param descripcion string con la nueva descripcion del dispositivo
 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/**
 * retorna la fecha de adquisicion del dispositivo
 * @return un tipo date con la fecha de adquisicion
 */
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
/**
 * establece la fecha de adquisicion del dispositivo
 * @param fechaAdquisicion establece la nueva fecha de adquisicion
 */
	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
/**
 * retorna el estado del dispositivo
 * @return elemento de la clase estado
 */
	public String getEstado() {
		return estado;
	}
/**
 * establece el nuevo estado del dispositivo
 * @param estado el nuevo estado del dispositivo
 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
