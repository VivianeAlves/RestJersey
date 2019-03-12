package controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Viviane
 */
@Path("hello")
public class helloController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMensagem(@QueryParam("usuario") String usuario) {
		return "Bem vindo: " + usuario;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("usuarios/{id}")
	public String getUsuario(@PathParam("id") long id) {
		return "Recuperando usuario com ID: " + id;
	}
}
