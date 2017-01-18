package br.ind.seat.core.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@SuppressWarnings("serial")
public class GenericDAO<T, ID> implements IGenericDAO<T, ID> {

    protected Class<T> classeDaEntidade; 

    @PersistenceContext(unitName = "java:postgresDS")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public Class<T> getClasseDaEntidade() {
        if (classeDaEntidade == null) {
            try {
                classeDaEntidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            } catch (Exception e) {
                throw new RuntimeException("EntityClass deve ser informado !");
            }
        }
        return classeDaEntidade;
    }

    @Override
    public void setClasseDaEntidade(Class<T> classeDaEntidade) {
        this.classeDaEntidade = classeDaEntidade;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<T> recuperarTodos(){
        return this.getEntityManager().createQuery("Select entidade FROM " + getClasseDaEntidade().getSimpleName() + " entidade").getResultList();
    }

    @Override
    public Query createQuery(String sql){
        return this.getEntityManager().createQuery(sql);
    }
    
    @Override
    public TypedQuery<T> createQuery(String sql,Class<T> classeDaEntidade){
        return this.getEntityManager().createQuery(sql,classeDaEntidade);
    }

    @Override
    public T inserir(T entidade){
        this.getEntityManager().persist(entidade);
        this.getEntityManager().flush();
        return entidade;
    }

    @Override
    public T alterar(T entidade){
        return this.getEntityManager().merge(entidade);
    }
    
    @Override
    public void excluir(T entidade){
    	this.getEntityManager().remove(this.getEntityManager().contains(entidade) ? entidade : this.getEntityManager().merge(entidade));
    }

    @Override
    public void excluirPorId(ID id) {
    	this.getEntityManager().remove(this.recuperarPorId(id));
    }

    @Override
    public T recuperarPorId(ID id){
        return this.getEntityManager().find(getClasseDaEntidade(), id);
    }

	@Override
	public Query createNativeQuery(String sql) {
		return this.getEntityManager().createNativeQuery(sql);
	}

}
