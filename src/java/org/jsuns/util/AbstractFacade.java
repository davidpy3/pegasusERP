/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.util;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.X;

public abstract class AbstractFacade<T>{
    
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public AbstractFacade() {
        try{
            String g = this.getClass().getGenericSuperclass().toString();
            X.log("Buscando generico para "+g+" DESDE "+this.getClass());
            entityClass = (Class<T>) Class.forName(g.substring(g.indexOf("<")+1, g.indexOf(">")));
            X.log("Se reconocio generico para "+entityClass);
        } catch (ClassNotFoundException ex) {
            X.alert(ex);
        }
    }
    
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void create(T entity) {
        X.log("Persist "+entity);
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        X.log("Merge "+entity);
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public List<T> findRange(int first,int max) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(max);
        q.setFirstResult(first);
        return q.getResultList();
    }
    
    public List<T> getResultList(String jpql,Object[] extra,int first,int max){
        javax.persistence.Query q = getEntityManager().createQuery(jpql);
        q.setMaxResults(max);
        q.setFirstResult(first);
        List l=q.getResultList();
        if(extra!=null){
            extra[0]=getEntityManager().createQuery(extra[0].toString()).getSingleResult();
        }
        return l;
    }
    
    public List<T> load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
