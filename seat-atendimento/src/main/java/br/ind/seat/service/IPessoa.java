package br.ind.seat.service;

import java.util.List;

import javax.ejb.Local;

import br.ind.seat.model.Pessoa;

@Local
public interface IPessoa {

	public Pessoa inserir(Pessoa pessoa);

	public List<Pessoa> recuperarTodos();
	
	public Pessoa recuperarPorId(Long id);
	
	public void excluirPorId(Long id);
	
	public Pessoa alterar(Pessoa pessoa);
	
}
