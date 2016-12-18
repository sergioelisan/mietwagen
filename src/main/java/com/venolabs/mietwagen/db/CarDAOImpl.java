package com.venolabs.mietwagen.db;

import java.util.List;

import com.venolabs.mietwagen.model.Car;

@SuppressWarnings("unchecked")
public class CarDAOImpl extends DAOSupport<Car> implements CarDAO {

	@Override
	public List<Car> list() {
		return getHibernateTemplate().loadAll(Car.class);
	}

	@Override
	public Car get(long id) {
		return (Car) getHibernateTemplate().load(Car.class, id);
	}

	@Override
	public Car get(String plate) {
		List<Car> cars = getHibernateTemplate()
				.find("from Car where plate=?",	plate);
		
		return !cars.isEmpty() ? cars.get(0) : null;
	}

}
