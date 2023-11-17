package com.diegodov.Stockify.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diegodov.Stockify.Model.Category;
import com.diegodov.Stockify.Model.Product;
import com.diegodov.Stockify.Model.Provider;
import com.diegodov.Stockify.Model.Rol;
import com.diegodov.Stockify.Model.User;
import com.diegodov.Stockify.Repository.RolRepository;
import com.diegodov.Stockify.Repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final RolRepository rolRepository;

    public UserService(UserRepository userRepository, RolRepository rolRepository) {
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
    }

    //registrar usuario
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    //muestra todos los usuarios
    public List<User> getAllUsers() {
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

    //actualizar usuario
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    //borrar usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean update(Long id, String username, String password) {
        
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(username);
            user.setPassword(password);;
            
            userRepository.save(user); // Guarda el producto actualizado en la base de datos
            return true;
        }

        return false; // Devuelve false si el producto no se encontró o no se pudo actualizar
    }

}
