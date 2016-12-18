package com.venolabs.mietwagen.bo;

import java.util.Date;
import java.util.List;

import com.venolabs.mietwagen.model.Car;
import com.venolabs.mietwagen.model.Client;
import com.venolabs.mietwagen.model.Rent;

public interface RentBO extends IBO<Rent> {

	List<Rent> getOpenRents();
	
	Rent getCarOpenRent(Car car);
	
	List<Rent> getClientOpenRents(Client client);
	
	String rentACar(Car car, Client client, Date delivery,
			String observations, boolean paid);
	
	String returnACar(Car car, boolean paid);
}
