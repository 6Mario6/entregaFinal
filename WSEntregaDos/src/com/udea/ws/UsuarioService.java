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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udea.dto.Usuario;
import com.udea.encode.Cifrar;
import com.udea.exception.MyException;
import com.udea.logica.imp.UsuarioLognImp;
import com.udea.ws.dto.*;

@Path("usuario")
@Component
public class UsuarioService {

	@Autowired
	private UsuarioLognImp usuariolg;
	
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
			throw new RemoteException(e.getMessage());

		}
		return usuarios;
	}
	

	@POST
	@Path("/guardar")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String guardarUsuario(@FormParam("idUsuario") int idUsuario,
			@FormParam("nombre") String nombre,
			@FormParam("apellido") String apellido,
			@FormParam("telefono") String telefono,
			@FormParam("email") String email,
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("grupoInvestigacion") String grupoInvestigacion)
			throws RemoteException {
		try {
			System.out.print("idUsuario: "+idUsuario);
			System.out.print(" nombre "+ nombre );
			System.out.print(" apellido "+ apellido);
			System.out.print(" telefono "+telefono);
			System.out.print(" email "+email);
			System.out.print(" username "+username);
			System.out.print(" password "+password);
			System.out.print(" grupoInvestigacion "+grupoInvestigacion);
			
			System.out.print(idUsuario);
			usuariolg.guardarUsuario(idUsuario, nombre, apellido, telefono,
					email, username, password, grupoInvestigacion);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "Se ingreso el usuario";
	}

	//@Produces(MediaType.TEXT_HTML)
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
			return e.getMessage();
		}

		return "actualizado";
	}

//	@Produces(MediaType.TEXT_HTML)
	@PUT
	@Path("/eliminar/{idUsuario}")
	public String eliminarUsuario(@PathParam("idUsuario") int idUsuario)
			throws RemoteException {
		try {
			usuariolg.eliminarUsuario(idUsuario);

		} catch (MyException e) {
			return e.getMessage();
		}

		return "eliminado";
	}

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
			return e.getMessage();
		}
		
		return"Valido";
	}
}
