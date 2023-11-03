package com.diegodov.Stockify.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diegodov.Stockify.Model.Provider;
import com.diegodov.Stockify.Repository.ProviderRepository;


@Service
public class ProviderService {

    @Autowired
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    //add provider
    public void save(Provider provider) {
        LocalDate now = LocalDate.now();
        provider.setDateInitialize(now);
        providerRepository.save(provider);
    }

    //show all providers
    public List<Provider> showAll() {
        return providerRepository.findAll();
    }

    //delete by id
    public void delete(Long id) {
        providerRepository.deleteById(id);
    }

    //show details by id
    public Provider details(Long id) {
        return providerRepository.findById(id).orElse(null);
    }

    //update provider
    public boolean update(Long id, String name) {
        Optional<Provider> providerOptional = providerRepository.findById(id);

        if (providerOptional.isPresent()) {
            Provider provider = providerOptional.get();
            provider.setName(name);
            providerRepository.save(provider);
            return true;
        }
        return false;
    }



}