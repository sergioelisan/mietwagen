package com.venolabs.mietwagen.bo;

import com.venolabs.mietwagen.db.CarDAO;
import com.venolabs.mietwagen.model.Car;

public class CarBOImpl extends BOSupport<Car> implements CarBO {

	public void setCarDao(CarDAO carDao) {
		setDao(carDao);
	}
	
	@Override
	public Car get(String plate) {
		return ((CarDAO) getDao()).get(plate);
	}

}
