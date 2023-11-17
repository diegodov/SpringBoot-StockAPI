package com.diegodov.Stockify.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodov.Stockify.Model.Rol;
import com.diegodov.Stockify.Repository.RolRepository;

@Service
public class RolService {

    @Autowired
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

}
