package com.udea.ws;

import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udea.dto.SolicitudPrestamo;
import com.udea.dto.Usuario;
import com.udea.exception.MyException;
import com.udea.logica.imp.SolicitudPrestamoLogImp;
import com.udea.ws.dto.SolicitudPrestamoWS;
import com.udea.ws.dto.UsuarioWS;

/**<h1> DispositivoService </h1>
*Clase encargada de implementar los servicios prestamo de dispositivos
 * @author Mario Fernandez
 * @author David Montoya
 * @version 3.0
 * @since 28-07-15
 *
 */
@Path("solicitud")
@Component
public class SolicitudPrestamoService {
	/**Objeto de la clase logger, el cual nos permite log mensajes usando la clase propia
	 * 
	 */
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SolicitudPrestamoLogImp solicitudlg;
	
	@GET
	@Path("/obtener")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SolicitudPrestamoWS> obtener() throws RemoteException {
		List<SolicitudPrestamoWS> solicitudes = new ArrayList<SolicitudPrestamoWS>();
		List<SolicitudPrestamo> listaSolicitudes = null;
		try {
			listaSolicitudes = solicitudlg.obtener();
			for (SolicitudPrestamo solicitud : listaSolicitudes) {
				SolicitudPrestamoWS solicitudWS = new SolicitudPrestamoWS();
				solicitudWS.setAdministrador(solicitud.getAdministrador());
				solicitudWS.setDispositivo(solicitud.getDispositivo());
				solicitudWS.setEstadoSolicitud(solicitud.getEstadoSolicitud());
				solicitudWS.setFechaSolicitudInicio(solicitud.getFechaSolicitudInicio());
				solicitudWS.setHoraSolicitudInicio(solicitud.getHoraSolicitudInicio());
				solicitudWS.setIdReservacion(solicitud.getIdReservacion());
				solicitudWS.setUsuario(solicitud.getUsuario());
				solicitudes.add(solicitudWS);
			}

		} catch (MyException e) {
			log.error("ocurrió un error al obtener la lista de usuarios", e);
			throw new RemoteException(e.getMessage());
		}
		return solicitudes;
	}
	
	@POST
	@Path("/guardar")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String guardarSolicitud(@QueryParam("idReservacion") int idReservacion,
			@QueryParam("idDispositivo") int idDispositivo,
			@QueryParam("idUsuarioPrestamo") int idUsuarioPrestamo,
			@QueryParam("idAdministrador") int idAdministrador,
			@QueryParam("fechasolicitudinicio") String fecha_solicitud_inicio,
			@QueryParam("horasolicitudinicio") String hora_solicitud_inicio,
			@QueryParam("estadosolicitud") String estado_solicitud)
			throws RemoteException {
		try {
			Date date = new Date();	
			Time time = new Time(0);
	
solicitudlg.realizarSolicitud(idReservacion, idDispositivo, 1, idUsuarioPrestamo, date, time, estado_solicitud);
			
		} catch (MyException e) {
			log.error("ocurrió un error al guardar la solicitud", e);
			return e.getMessage();
		}
		return "Se ingreso la solicitud";
	}

	
}
