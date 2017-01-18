package br.ind.seat.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.ind.seat.model.Preferencial;
import br.ind.seat.persistence.IPreferencialDAO;
import br.ind.seat.service.IPreferencial;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PreferencialBean implements IPreferencial{
	
	@Inject
	private IPreferencialDAO iPreferencialDAO;
	
	@Override
	public Preferencial inserir(Preferencial preferencial) {
		return iPreferencialDAO.inserir(preferencial);
	}

	@Override
	public List<Preferencial> recuperarTodos() {
		return iPreferencialDAO.recuperarTodos();
	}

	@Override
	public Preferencial recuperarPorId(Long id) {
		return iPreferencialDAO.recuperarPorId(id);
	}
	
	

}
