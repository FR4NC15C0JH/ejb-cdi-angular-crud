package br.ind.seat.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.ind.seat.model.Geral;
import br.ind.seat.persistence.IGeralDAO;
import br.ind.seat.service.IGeral;

@Stateless
/*
 * @TransactionAttribute – declara que está sendo utilizado alguma transação;
 * TransactionAttributeType.REQUIRED – por padrão a transação utiliza a estratégia required, 
 * que se o método do serviço não possuir alguma transação, uma será criada, e se já possuir uma transação esta será aproveitada.
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class GeralBean implements IGeral{
	
	@Inject
	private IGeralDAO iGeralDAO;
	
	@Override
	public Geral inserir(Geral geral){
		return iGeralDAO.inserir(geral);
	}
	
	@Override
	public List<Geral> recuperarTodos() {
		return iGeralDAO.recuperarTodos();
	}

	@Override
	public Geral recuperarPorId(Long id) {
		return iGeralDAO.recuperarPorId(id);
	}
}
