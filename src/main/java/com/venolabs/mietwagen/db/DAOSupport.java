package com.venolabs.mietwagen.db;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class DAOSupport<T> extends HibernateDaoSupport implements DAO<T> {

	@Override
	public void save(T toSave) {
		getHibernateTemplate().saveOrUpdate(toSave);
	}
	
	@Override
	public void remove(T toSave) {
		getHibernateTemplate().delete(toSave);
	}
	
}
