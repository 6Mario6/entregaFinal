package com.udea.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
	
}
