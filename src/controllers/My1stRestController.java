package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("teste")
public class My1stRestController {
	@Context
	private UriInfo context;

	public My1stRestController() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getXml() {
		return "meuPrimeiroTesteREst";
	}

	@PUT
	@Consumes("application/json")
	public void putJson(String content) {
	}

}