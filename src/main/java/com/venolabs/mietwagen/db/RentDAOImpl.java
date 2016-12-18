package com.venolabs.mietwagen.db;

import java.util.List;

import com.venolabs.mietwagen.model.Car;
import com.venolabs.mietwagen.model.Client;
import com.venolabs.mietwagen.model.Rent;

@SuppressWarnings("unchecked")
public class RentDAOImpl extends DAOSupport<Rent> implements RentDAO {

	@Override
	public List<Rent> list() {
		return getHibernateTemplate().loadAll(Rent.class);
	}

	@Override
	public Rent get(long id) {
		return (Rent) getHibernateTemplate().load(Rent.class, id);
	}

	@Override
	public List<Rent> getOpenRents() {
		return getHibernateTemplate().find("from Rent where delivered=0");
	}

	@Override
	public Rent getCarOpenRent(Car car) {
		return (Rent) getHibernateTemplate().find(
				"from Rent where car_id=? and delivered=0", car.getId())
				.get(0);
	}

	@Override
	public List<Rent> getClientOpenRents(Client client) {
		return getHibernateTemplate().find(
				"from Rent where car_id=? and delivered=0", client.getId());
	}

}
