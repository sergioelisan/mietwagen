package com.venolabs.mietwagen.bo;

import com.venolabs.mietwagen.db.ClientDAO;
import com.venolabs.mietwagen.model.Client;

public class ClientBOImpl extends BOSupport<Client> implements ClientBO {

	public void setClientDao(ClientDAO carDao) {
		setDao(carDao);
	}
	
	@Override
	public Client getByName(String name) {
		return ((ClientDAO) getDao()).getByName(name);
	}

	@Override
	public Client getByCPF(String cpf) {
		return ((ClientDAO) getDao()).getByCPF(cpf);
	}

}
