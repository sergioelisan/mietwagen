package com.venolabs.mietwagen.bo;

import java.util.List;

import com.venosyd.patterns.Observable;

public interface IBO<T> extends Observable {

	void save(T toSave);

	void remove(T toSave);

	List<T> list();

	T get(long id);

}
