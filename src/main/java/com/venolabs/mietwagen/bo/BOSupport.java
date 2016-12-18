package com.venolabs.mietwagen.bo;

import java.util.List;

import com.venolabs.mietwagen.db.DAO;

public abstract class BOSupport<T> implements IBO<T> {

	private DAO<T> dao;

	public void setDao(DAO<T> dao) {
		this.dao = dao;
	}

	public DAO<T> getDao() {
		return dao;
	}

	@Override
	public void save(T toSave) {
		dao.save(toSave);
		notifyObservers();
	}

	@Override
	public void remove(T toRemove) {
		dao.remove(toRemove);
		notifyObservers();
	}

	@Override
	public List<T> list() {
		return dao.list();
	}

	@Override
	public T get(long id) {
		return dao.get(id);
	}

}
