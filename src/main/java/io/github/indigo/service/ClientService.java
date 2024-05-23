package io.github.indigo.service;

import io.github.indigo.model.Client;
import io.github.indigo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {


    private ClientRepository repository;

    @Autowired
    public void setRepository(ClientRepository repository){
     this.repository = repository;
    }

    public ClientService(ClientRepository repository){
        this.repository = repository;
    }

    public void saveClient(Client client){
        validadeClient(client);
        this.repository.persist(client);
    }
    public void validadeClient(Client client){
     // aplicar validações
    }
}
