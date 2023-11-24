package com.diegodov.Stockify.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodov.Stockify.Model.User;
import com.diegodov.Stockify.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    //registrar usuario
    public User save(User user) {
        return userRepository.save(user);
    }

    //muestra todos los usuarios
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //buscar usuario por id
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User by id " + id + " was not found"));
    }

    //buscar usuario por username
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new RuntimeException("User by username " + username + " was not found"));
    }

    //borrar usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    //actualizar usuario
    public boolean update(Long id, String username, String password) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(username);
            user.setPassword(password);;
            
            userRepository.save(user);
        }
        return false;
    }

}
