package br.ind.seat.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.ind.seat.model.Pessoa;
import br.ind.seat.persistence.IPessoaDAO;
import br.ind.seat.service.IPessoa;


@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PessoaBean implements IPessoa {

	@Inject
	private IPessoaDAO iPessoaDAO;

	@Override
	public Pessoa inserir(Pessoa pessoa) {
		return iPessoaDAO.inserir(pessoa);
	}

	@Override
	public List<Pessoa> recuperarTodos() {
		return iPessoaDAO.recuperarTodos();
	}

	@Override
	public void excluirPorId(Long id) {
		iPessoaDAO.excluirPorId(id);		
	}

	@Override
	public Pessoa alterar(Pessoa pessoa) {
		return iPessoaDAO.alterar(pessoa);
	}

	@Override
	public Pessoa recuperarPorId(Long id) {
		return iPessoaDAO.recuperarPorId(id);
	}

}
