package com.trainingappspringboot.demo.repositories;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

//http://websystique.com/springmvc/spring-4-mvc-and-hibernate4-integration-example-using-annotations/
//This Generic class is the base class for all DAO implementation classes. It provides the wrapper methods for common hibernate operations
public abstract class AbstractDao<PK extends Serializable, T> {

//    private final Class<T> persistentClass;
//
//    @SuppressWarnings("unchecked")
//    public AbstractDao() {
//        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
//    }
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    protected Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }
//
//    @SuppressWarnings("unchecked")
//    public T getByKey(PK key) {
//        return (T) getSession().get(persistentClass, key);
//    }
//
//    public void save(T entity) {
//        getSession().saveOrUpdate(entity);
//    }
//
////    public void persist(T entity) {
////        System.out.println("get here");
////        getSession().persist(entity);
////    }
//
//    //saveOrUpdate(), update(), merge() jpa native
//    public void update(T entity) {
//        getSession().merge(entity);
//    }
//
//    public void delete(T entity) {
//        getSession().delete(entity);
//    }
//
////    [‎1/‎3/‎2019 11:09 AM]  Young, Tyler:
////    https://stackoverflow.com/questions/40720799/deprecated-createcriteria-method-in-hibernate-5
//
//    //    protected
//    //    // Create CriteriaBuilder
//    //    CriteriaBuilder builder = session.getCriteriaBuilder();
//    //
//    //    // Create CriteriaQuery
//    //    CriteriaQuery<T> criteria = builder.createQuery(T entity);
//
////    https://www.mkyong.com/hibernate/hibernate-query-examples-hql/
////    criteria way: https://www.baeldung.com/hibernate-sort
//
//    @SuppressWarnings("unchecked")
//    protected Query createCustomQuery(String query) {
//        return getSession().createQuery(query);
//    }
//
//    @Deprecated
//    protected Criteria createEntityCriteria() {
//        return getSession().createCriteria(persistentClass);
//    }
}
