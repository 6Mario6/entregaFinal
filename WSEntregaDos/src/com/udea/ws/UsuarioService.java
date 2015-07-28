package com.udea.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udea.dto.Usuario;
import com.udea.encode.Cifrar;
import com.udea.exception.MyException;
import com.udea.logica.imp.UsuarioLognImp;
import com.udea.ws.dto.*;
/**<h1> UsuarioService </h1>
*Clase encargada de implementar los servicios a usuarios
 * 
 * @author Jorge Mario Fernandez
 * @version 2.0
 * @since 20-06-15
 *
 */
@Path("usuario")
@Component
public class UsuarioService {

	/**Objeto de la clase logger, el cual nos permite log mensajes usando la clase propia
	 * 
	 */
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private UsuarioLognImp usuariolg;
	/**Con este metodo obtenemos todos los usuarios
	 * @return List<Usuario> retorna la lista de Usuarios
	 * @throws MyException Esta es una excepción propia en caso de inconvenientes
	 */
	@GET
	@Path("/obtener")
	public List<UsuarioWS> obtener() throws RemoteException {
		List<UsuarioWS> usuarios = new ArrayList<UsuarioWS>();
		List<Usuario> listaUsuario = null;
		try {
			listaUsuario = usuariolg.obtener();
			for (Usuario usuario : listaUsuario) {
				UsuarioWS usuarioWS = new UsuarioWS();
				usuarioWS.setIdUsuario(usuario.getIdUsuario());
				usuarioWS.setNombre(usuario.getNombre());
				usuarioWS.setApellido(usuario.getApellido());
				usuarioWS.setEmail(usuario.getEmail());
				usuarios.add(usuarioWS);
			}

		} catch (MyException e) {
			log.error("ocurrió un error al obtener la lista de usuarios", e);
			throw new RemoteException(e.getMessage());

		}
		return usuarios;
	}
	
	/**Este metodo guarda al usuario  dentro de las bases de datos
	 * @param usuario el usuario que se desea guardar enla base de datos
	 * @throws MyException Esta es una excepción propia en caso de inconvenientes
	 */
	@POST
	@Path("/guardar")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String guardarUsuario(@QueryParam("idUsuario") int idUsuario,
			@QueryParam("nombre") String nombre,
			@QueryParam("apellido") String apellido,
			@QueryParam("telefono") String telefono,
			@QueryParam("email") String email,
			@QueryParam("username") String username,
			@QueryParam("password") String password,
			@QueryParam("grupoInvestigacion") String grupoInvestigacion)
			throws RemoteException {
		try {
			usuariolg.guardarUsuario(idUsuario, nombre, apellido, telefono,
					email, username, password, grupoInvestigacion);
		} catch (MyException e) {
			log.error("ocurrió un error al guardar el usuario", e);
			return e.getMessage();
		}
		return "Se ingreso el usuario";
	}

	/**Con este metodo se modifica la información del usuario
	 * @param usuario usuario a la cual se le han modificado los datos
	 * @throws MyException Esta es una excepción propia en caso de inconvenientes
	 */
	@POST
	@Path("/actualizar")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String actualizarUsuario(@FormParam("idUsuario") int idUsuario,
			@FormParam("nombre") String nombre,
			@FormParam("apellido") String apellido,
			@FormParam("telefono") String telefono,
			@FormParam("email") String email,
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("grupoInvestigacion") String grupoInvestigacion)
			throws RemoteException {
		try {
			usuariolg.actualizarUsuario(idUsuario, nombre, apellido, telefono,
					email, username, password, grupoInvestigacion);

		} catch (MyException e) {
			log.error("ocurrió un error  al actualizar el usuario", e);
			return e.getMessage();
		}

		return "actualizado";
	}

	/**Con este metodo se eliminara el usuario de la base de datos
	 * @param usuario el usuario a borrar
	 * @throws MyException Esta es una excepción propia en caso de inconvenientes
	 */
	@PUT
	@Path("/eliminar/{idUsuario}")
	public String eliminarUsuario(@PathParam("idUsuario") int idUsuario)
			throws RemoteException {
		try {
			usuariolg.eliminarUsuario(idUsuario);

		} catch (MyException e) {
			log.error("ocurrió un error al actualizar el usuario", e);
			return e.getMessage();
		}

		return "eliminado";
	}
	/**Con este metodo se valida el usuario del sistema
	 * @param username del usuario 
	 * @param password del usuario
	 * @throws MyException Esta es una excepción propia en caso de inconvenientes
	 */
	@GET
	@Path("/validar")
	public String validar(@QueryParam("username") String username 
			,@QueryParam("password") String password)
			throws RemoteException {
		try {
			Cifrar cifrar= new Cifrar();
			
			System.out.print(" username "+username);
			System.out.print(" password "+cifrar.encrypt(password));
			usuariolg.validar(username, cifrar.encrypt(password));
		} catch (MyException e) {
			log.error("ocurrió un error al eliminar el usuario", e);
			return e.getMessage();
		}
		
		return"Valido";
	}
}
