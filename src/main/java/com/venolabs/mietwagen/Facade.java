package com.venolabs.mietwagen;

import java.util.Date;
import java.util.List;

import com.venolabs.mietwagen.bo.BOFactory;
import com.venolabs.mietwagen.model.Car;
import com.venolabs.mietwagen.model.Client;
import com.venolabs.mietwagen.model.Rent;
import com.venosyd.patterns.Observer;

public final class Facade {

	private Facade() {
	}

	// <operacoes de interface>
	public static void quit() {

	}

	public static void registerClientsObserver(Observer o) {
		BOFactory.clientBO().register(o);
		BOFactory.clientBO().notifyObservers();
	}

	public static void registerCarsObserver(Observer o) {
		BOFactory.carBO().register(o);
		BOFactory.carBO().notifyObservers();
	}

	public static void registerRentsObserver(Observer o) {
		BOFactory.rentBO().register(o);
		BOFactory.rentBO().notifyObservers();
	}

	// </operacoes de interface>

	// <manter cliente>
	public static void saveClient(Client c) {
		BOFactory.clientBO().save(c);
	}

	public static List<Client> listClients() {
		return BOFactory.clientBO().list();
	}

	public static Client getClientByCPF(String cpf) {
		return BOFactory.clientBO().getByCPF(cpf);
	}

	// </manter cliente>

	// <manter carro>
	public static void saveCar(Car c) {
		BOFactory.carBO().save(c);
	}

	public static List<Car> listCars() {
		return BOFactory.carBO().list();
	}

	public static Car getCar(String plate) {
		return BOFactory.carBO().get(plate);
	}

	// </manter carro>

	// <manter aluguel>
	public static String rentACar(Car car, Client client, Date delivery,
			String observations, boolean paid) {
		return BOFactory.rentBO().rentACar(car, client, delivery, observations,
				paid);
	}

	public static String returnACar(Car car, boolean paid) {
		return BOFactory.rentBO().returnACar(car, paid);
	}

	public static List<Rent> listRents() {
		return BOFactory.rentBO().list();
	}

	public static List<Rent> getOpenRents() {
		return BOFactory.rentBO().getOpenRents();
	}
	// </manter aluguel>

}
