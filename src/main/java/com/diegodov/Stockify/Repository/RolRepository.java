package com.diegodov.Stockify.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegodov.Stockify.Model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
