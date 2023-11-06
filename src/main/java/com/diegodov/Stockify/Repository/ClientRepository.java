package com.diegodov.Stockify.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegodov.Stockify.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {    
}
