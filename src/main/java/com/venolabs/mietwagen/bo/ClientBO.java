package com.venolabs.mietwagen.bo;

import com.venolabs.mietwagen.model.Client;

public interface ClientBO extends IBO<Client> {

	Client getByName(String name);
	
	Client getByCPF(String cpf);
}
