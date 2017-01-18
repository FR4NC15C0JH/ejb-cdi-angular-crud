package br.ind.seat.web.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ind.seat.model.Preferencial;
import br.ind.seat.service.IPreferencial;

@Path("/preferencial")
public class PreferencialResource {
	
	@EJB
	private IPreferencial iPreferencial;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Preferencial> recuperarTodos() {
		return iPreferencial.recuperarTodos();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Preferencial recuperarPorId(@PathParam("id") Long id) {
		return iPreferencial.recuperarPorId(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void salvar(Preferencial preferencial) {
		iPreferencial.inserir(preferencial);
	}
}
