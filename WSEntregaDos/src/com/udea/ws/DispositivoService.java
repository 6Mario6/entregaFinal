package com.udea.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udea.dto.Dispositivo;
import com.udea.dto.Usuario;
import com.udea.exception.MyException;
import com.udea.logica.imp.DispositivoLogImp;
import com.udea.ws.dto.DispositivoWS;
import com.udea.ws.dto.UsuarioWS;

/**<h1> DispositivoService </h1>
*Clase encargada de implementar los servicios a los dipositivos
 * 
 * @author Jorge Mario Fernandez
 * @version 2.0
 * @since 20-06-15
 *
 */
@Path("dispositivo")
@Component
public class DispositivoService {
	/**Objeto de la clase logger, el cual nos permite log mensajes usando la clase propia
	 * 
	 */
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private DispositivoLogImp DispositivoLog;
	
	/**Con este metodo obtenemos todos los dispositivos
	 * @return List<DispositivoWS> retorna la lista de dispositivos
	 * @throws MyException Esta es una excepción propia en caso de inconvenientes
	 */
	@GET
	@Path("/obtener")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DispositivoWS> obtener() throws RemoteException {
		List<DispositivoWS> dispositivos = new ArrayList<DispositivoWS>();
		List<Dispositivo> listaDispositivo = null;
		try {
			listaDispositivo = DispositivoLog.obtener();
			String nombreEstado;
			for (Dispositivo dispositivo : listaDispositivo) {
				DispositivoWS dispositivoWS = new DispositivoWS();
				dispositivoWS.setDescripcion(dispositivo.getDescripcion());
				nombreEstado=DispositivoLog.getEstDao().obtenerEstado(dispositivo.getEstado()).getNombre();
				dispositivoWS.setEstado(nombreEstado);
				dispositivoWS.setFechaAdquisicion(dispositivo.getFechaAdquisicion());
				dispositivoWS.setIdDispositivo(dispositivo.getIdDispositivo());
				dispositivoWS.setNombre(dispositivo.getNombre());
				dispositivos.add(dispositivoWS);
			}

		} catch (MyException e) {
			throw new RemoteException(e.getMessage());

		}
		return dispositivos;
	}
	
	/**Este metodo guarda el dispositivo  dentro de las bases de datos
	 *@param idDispositivo identificacion del dispositivo
	 *@param idCategoria identificacion de la categoria del dispositivo
	 *@param idEstado identificacion del estado del dispositivo
	 *@param idAdministrador identificacion del usuario
	 *@param nombre el nombre del dispositivo
	 *@param descripcion La descripcion del dispositivo
	 *@param fecha_adquisicion la fecha en la que se adquirio el dispositivo
	 * @throws MyException Esta es una excepción propia en caso de inconvenientes
	 */
	@POST
	@Path("/guardar")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String guardarDispositivo(@FormParam("idDispositivo") int idDispositivo,
			@FormParam("idCategoria") int idCategoria,
			@FormParam("idEstado") int idEstado,
			@FormParam("idAdministrador") int idAdministrador,
			@FormParam("nombre") String nombre,
			@FormParam("descripcion") String descripcion,
			@FormParam("fecha_adquisicion") Date fecha_adquisicion)
			throws RemoteException {
		try {
			DispositivoLog.guardarDispositivo(idDispositivo, idCategoria, idEstado,
					idAdministrador, nombre, descripcion, fecha_adquisicion);
		} catch (MyException e) {
			log.error("ocurrió un error  al guardar el dispositivo", e);
			return e.getMessage();
		}
		return "Se ingreso el dispositivo";
	}
	/**Con este metodo se modifica la información del Dispositivo
	 *@param idDispositivo identificacion del dispositivo
	 *@param idCategoria identificacion de la categoria del dispositivo
	 *@param idEstado identificacion del estado del dispositivo
	 *@param idAdministrador identificacion del usuario
	 *@param nombre el nombre del dispositivo
	 *@param descripcion La descripcion del dispositivo
	 *@param fecha_adquisicion la fecha en la que se adquirio el dispositivo
	 * @throws MyException Esta es una excepción propia en caso de inconvenientes
	 */
	@POST
	@Path("/actualizar")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String actualizarDispositivo(@FormParam("idDispositivo") int idDispositivo,
			@FormParam("idCategoria") int idCategoria,
			@FormParam("idEstado") int idEstado,
			@FormParam("idAdministrador") int idAdministrador,
			@FormParam("nombre") String nombre,
			@FormParam("descripcion") String descripcion,
			@FormParam("fecha_adquisicion") Date fecha_adquisicion)
			throws RemoteException {
		try {
			DispositivoLog.actualizarDispositivo(idDispositivo, idCategoria, 
					idEstado, idAdministrador, nombre, descripcion, fecha_adquisicion);

		} catch (MyException e) {
			log.error("ocurrió un error  al actualizar el dispositivo", e);
			return e.getMessage();
		}

		return "actualizado";
	}
	/**Con este metodo se eliminara el Dispositivo de la base de datos
	 * @param idDispositivo la identificacion del usuario a eliminar
	 * @throws MyException Esta es una excepción propia en caso de inconvenientes
	 */
	@PUT
	@Path("/eliminar/{idDispositivo}")
	public String eliminarDispositivo(@PathParam("idDispositivo") int idDispositivo)
			throws RemoteException {
		try {
			DispositivoLog.eliminarDispositivo(idDispositivo);

		} catch (MyException e) {
			log.error("ocurrió un error al eliminar el dispositivo", e);
			return e.getMessage();
		}

		return "eliminado";
	}

}
