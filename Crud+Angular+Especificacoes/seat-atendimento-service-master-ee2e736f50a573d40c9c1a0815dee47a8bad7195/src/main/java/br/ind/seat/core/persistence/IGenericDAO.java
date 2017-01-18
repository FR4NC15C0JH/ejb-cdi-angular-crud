package br.ind.seat.core.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public interface IGenericDAO<T, ID> extends Serializable {
    
    public Class<T> getClasseDaEntidade();

    public void setClasseDaEntidade(Class<T> classeDaEntidade);

    public Query createQuery(String sql);
    
    public TypedQuery<T> createQuery(String sql,Class<T> classeDaEntidade);
    
    public Query createNativeQuery(String sql);
    
    public List<T> recuperarTodos();

    public T inserir(T entidade);

    public T alterar(T entidade);

    public void excluir(T entidade);
    
    public void excluirPorId(ID id);
    
    public T recuperarPorId(ID id);
    
    public EntityManager getEntityManager();
    
}