package com.venolabs.mietwagen.db;

import java.util.List;

import com.venolabs.mietwagen.model.Car;
import com.venolabs.mietwagen.model.Client;
import com.venolabs.mietwagen.model.Rent;

public interface RentDAO extends DAO<Rent> {

	List<Rent> getOpenRents();

	Rent getCarOpenRent(Car car);

	List<Rent> getClientOpenRents(Client client);
}
