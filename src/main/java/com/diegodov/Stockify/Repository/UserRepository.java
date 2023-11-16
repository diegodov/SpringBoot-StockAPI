package com.diegodov.Stockify.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegodov.Stockify.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findUserByUsername(String username);

}
