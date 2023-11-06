package com.diegodov.Stockify.Service;

import org.springframework.stereotype.Service;

import com.diegodov.Stockify.Model.Client;
import com.diegodov.Stockify.Repository.ClientRepository;

@Service
public class ClientService {
    
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }
    
}
