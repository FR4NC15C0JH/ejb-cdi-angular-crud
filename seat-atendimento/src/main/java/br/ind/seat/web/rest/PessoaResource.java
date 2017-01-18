package br.ind.seat.web.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ind.seat.model.Pessoa;
import br.ind.seat.service.IPessoa;

@Path("/pessoas")//caminho URI ao qual o recurso responde
public class PessoaResource {
	
	@EJB
	private IPessoa iPessoa;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> recuperarTodos() {
		return iPessoa.recuperarTodos();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa recuperarPorId(@PathParam("id") Long id) {
		return iPessoa.recuperarPorId(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void salvar(Pessoa pessoa) {
		iPessoa.inserir(pessoa);
	}
    
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void alterar(Pessoa pessoa) {
		iPessoa.alterar(pessoa);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void excluir(@PathParam("id") Long id)  {
		iPessoa.excluirPorId(id);
	}
 }
