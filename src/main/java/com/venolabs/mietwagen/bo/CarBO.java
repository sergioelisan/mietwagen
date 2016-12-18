package com.venolabs.mietwagen.bo;

import com.venolabs.mietwagen.model.Car;

public interface CarBO extends IBO<Car> {
	
	Car get(String plate);

}
