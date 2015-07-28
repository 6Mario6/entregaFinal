package com.udea.ws.dto;

import java.sql.Time;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
/**<h1> SolicitudprestamoWS</h1>
Clase encargada de los setter y getter del elemento Solicitud prestamo
 * 
 * @author Mario Fernandez
 * @author David Montoya
 * @version 3.0
 * @since 28-07-15
 *
 */
@XmlRootElement
public class SolicitudPrestamoWS {
	/**
	 * entero con la id de la reservacion
	 */
	private int idReservacion;
	/**
	 * el adminsitrador asociado a la solicitud
	 */
	private int idAdministrador;
	/**
	 * el dispositivo asociado a la solicitud
	 */
	private int idDispositivo;
	/**
	 * el usuario asociado a la solicitud
	 */
	private int idUsuario;
	/**
	 * la fecha de solicitud inicio
	 */
	private Date fechaSolicitudInicio;
	/**
	 * la hora de solicitud de inciio
	 */
	private Time horaSolicitudInicio;
	/**
	 * establece el estado de la solicitud
	 */
	private String estadoSolicitud;
/**
 * retorna la id de la reservacion
 * @return entero con la id de la reservacion
 */
	public int getIdReservacion() {
		return idReservacion;
	}
/**
 * establece la id de la reservacion
 * @param idReservacion la nueva id de la reservacion
 */
	public void setIdReservacion(int idReservacion) {
		this.idReservacion = idReservacion;
	}
/**
 * retorna la fecha de inicio de la solicitud
 * @return date con la fehca de inicio
 */
	public Date getFechaSolicitudInicio() {
		return fechaSolicitudInicio;
	}
/**
 * establece la fecha de incioo de la solicitud
 * @param fechaSolicitudInicio la nueva fecha de solicitud
 */
	public void setFechaSolicitudInicio(Date fechaSolicitudInicio) {
		this.fechaSolicitudInicio = fechaSolicitudInicio;
	}
/**
 * retorna la hora de la solicitud de inicio
 * @return retorna la hora de inicio
 */
	public Time getHoraSolicitudInicio() {
		return horaSolicitudInicio;
	}
/**
 * establece la nueva hora de la solicitud para iniciar
 * @param horaSolicitudInicio la nueva hora de inicio
 */
	public void setHoraSolicitudInicio(Time horaSolicitudInicio) {
		this.horaSolicitudInicio = horaSolicitudInicio;
	}
/**
 * retorna el estado de la solicitud
 * @return entero con el estado
 */
	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}
/**
 * establece el estado de la solicitud
 * @param estadoSolicitud el nuevo estado de la solicitud
 */
	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
/**
 * retorna el administrado asociado
 * @return elemento de la clase administrador
 */
	public int getAdministrador() {
		return idAdministrador;
	}
/**
 * establece el nuevo administrador asociado a la solicitud
 * @param administrador el nuevo administrador
 */
	public void setAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
/**
 * retorna el usuario asociado a la solicitud
 * @return retorna un usuario
 */
	public int getUsuario() {
		return idUsuario;
	}
/**
 * establece el nuevo usuario asociado a la solicitud
 * @param usuario el nuevo usuario
 */
	public void setUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
/**
 * retorna la id del dispositivo
 * @return elemento de tipo dispositivo
 */
	public int getDispositivo() {
		return idDispositivo;
	}
/**
 * establece el nuevo dispositivo asociado
 * @param dispositivo el nuevo dispositivo
 */
	public void setDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
}
