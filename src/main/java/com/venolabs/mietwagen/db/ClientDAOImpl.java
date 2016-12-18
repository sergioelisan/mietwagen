package com.venolabs.mietwagen.db;

import java.util.List;

import com.venolabs.mietwagen.model.Client;

@SuppressWarnings("unchecked")
public class ClientDAOImpl extends DAOSupport<Client> implements ClientDAO {

	@Override
	public List<Client> list() {
		return getHibernateTemplate().loadAll(Client.class);
	}

	@Override
	public Client get(long id) {
		return (Client) getHibernateTemplate().load(Client.class, id);
	}

	@Override
	public Client getByName(String name) {
		List<Client> clients = getHibernateTemplate().find(
				"from Client where name=?", name);
		
		return !clients.isEmpty() ? clients.get(0) : null;
	}

	@Override
	public Client getByCPF(String cpf) {
		List<Client> clients = getHibernateTemplate().find(
				"from Client where cpf=?", cpf);
		
		return !clients.isEmpty() ? clients.get(0) : null;
	}

}
