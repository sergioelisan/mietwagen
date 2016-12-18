package com.venolabs.mietwagen.db;

import com.venolabs.mietwagen.model.Client;

public interface ClientDAO extends DAO<Client> {

	Client getByName(String name);

	Client getByCPF(String cpf);
}
