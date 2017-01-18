package br.ind.seat.web.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ind.seat.model.Geral;
import br.ind.seat.service.IGeral;

@Path("/geral")
public class GeralResource {
	
	@EJB
	private IGeral iGeral;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Geral> recuperarTodos() {
		return iGeral.recuperarTodos();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Geral recuperarPorId(@PathParam("id") Long id) {
		return iGeral.recuperarPorId(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void salvar(Geral geral) {
		iGeral.inserir(geral);
	}

}
