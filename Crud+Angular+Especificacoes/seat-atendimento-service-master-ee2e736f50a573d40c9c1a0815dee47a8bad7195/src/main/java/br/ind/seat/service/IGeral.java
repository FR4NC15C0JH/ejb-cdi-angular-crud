package br.ind.seat.service;

import java.util.List;

import javax.ejb.Local;

import br.ind.seat.model.Geral;

@Local
public interface IGeral {
	
	public Geral inserir(Geral geral);
	
	public List<Geral> recuperarTodos();
	
	public Geral recuperarPorId(Long id);
}
