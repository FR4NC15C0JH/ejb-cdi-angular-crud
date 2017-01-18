package br.ind.seat.service;

import java.util.List;

import javax.ejb.Local;

import br.ind.seat.model.Preferencial;

@Local
public interface IPreferencial {
	
	public Preferencial inserir(Preferencial preferencial);
	
	public List<Preferencial> recuperarTodos();
	
	public Preferencial recuperarPorId(Long id);
}
