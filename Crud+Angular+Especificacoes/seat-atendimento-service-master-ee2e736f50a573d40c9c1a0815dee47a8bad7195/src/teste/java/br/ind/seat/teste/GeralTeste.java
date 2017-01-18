package br.ind.seat.teste;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;

public class GeralTeste {
	
	@Test
	public void testaConexaoServicoGeral(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/atendimento");
		String conteudo = target.path("/geral").request().get(String.class);
//		Assert.assertTrue(conteudo.contains("nome:Francisco Jorge"));
	}
}
