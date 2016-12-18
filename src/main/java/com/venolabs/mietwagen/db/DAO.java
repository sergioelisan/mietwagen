package com.venolabs.mietwagen.db;

import java.util.List;

public interface DAO<T> {
	
	void save(T toSave);
	
	void remove(T toSave);
	
	List<T> list();
	
	T get(long id);

}
