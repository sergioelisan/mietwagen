package com.venolabs.mietwagen.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.venolabs.mietwagen.db.RentDAO;
import com.venolabs.mietwagen.model.Car;
import com.venolabs.mietwagen.model.Client;
import com.venolabs.mietwagen.model.Rent;
import com.venolabs.mietwagen.strings.Strings;

public class RentBOImpl extends BOSupport<Rent> implements RentBO {

	public void setRentDao(RentDAO carDao) {
		setDao(carDao);
	}
	
	@Override
	public List<Rent> getOpenRents() {
		return ((RentDAO) getDao()).getOpenRents();
	}

	@Override
	public Rent getCarOpenRent(Car car) {
		return ((RentDAO) getDao()).getCarOpenRent(car);
	}

	@Override
	public List<Rent> getClientOpenRents(Client client) {
		return ((RentDAO) getDao()).getClientOpenRents(client);
	}

	@Override
	public String rentACar(Car car, Client client, Date delivery,
			String observations, boolean paid) {
		// verifica se o cliente esta em dia
		if (getClientOpenRents(client).size() > 0)
			return Strings.CLIENT_IS_INDEBITED;

		// verifica se o carro esta alugado
		Optional<Rent> foundRent = getOpenRents().parallelStream()
												 .filter(r -> r.getCar().equals(car))
												 .findFirst();
		
		if (foundRent.isPresent()) {
			DateFormat df = SimpleDateFormat.getDateTimeInstance();
			return Strings.CAR_WILL_BE_DELIVERED_IN + " "
					+ df.format(foundRent.get().getDelivery());
		}
			
		// cria um novo objeto que simboliza uma locacao
		Rent rent = new Rent();
		rent.setCar(car);
		rent.setClient(client);
		rent.setStart(new Date());
		rent.setDelivery(delivery);
		rent.setObservations(observations);
		rent.setPaid(paid);
		rent.setDelivered(false);

		// salva a locacao no banco
		save(rent);

		// retorna sinal de OK, FOI ALUGADO
		return Strings.RENTAL_GRANTED;
	}

	@Override
	public String returnACar(Car car, boolean paid) {
		Rent rent = getCarOpenRent(car);
		if (rent != null) {
			rent.setDelivered(true);
			rent.setPaid(paid);
			save(rent);
			return Strings.CAR_RETURN_SUCESS;
		} else {
			return Strings.CAR_RENT_NOT_REGISTERED;
		}
	}

}
