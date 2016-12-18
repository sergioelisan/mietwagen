package com.venolabs.mietwagen.db;

import com.venolabs.mietwagen.model.Car;

public interface CarDAO extends DAO<Car> {

	Car get(String plate);
	
}
