package com.example.services;

import com.example.models.AppRole;
import com.example.models.AppUser;
import com.example.repositories.IRoleRepository;
import com.example.repositories.IUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IRoleRepository roleRepository;

    AppUser defaultUser;
    public AppUserService() {
        AppUser user = new AppUser();
        user.setUsername("user");
        user.setPassword("{noop}password");
        user.setRoles(Collections.singleton(new AppRole(1L, "ROLE_USER")));
        this.defaultUser = user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = userRepository.findByName(username);

        if(user == null) {
            return defaultUser;
        }

        String pass = user.getPassword();
        user.setPassword("{noop}" + pass);
        return user;
    }

    public AppUser findUserById(Long id) {

        Optional<AppUser> user = userRepository.findById(id);
        return user.orElse(new AppUser());
    }

    public Iterable<AppUser> allUsers() {

        return userRepository.findAll();
    }

    public boolean saveUser(AppUser user) {

        if(userRepository.findByName(user.getUsername()) != null) return false;

        if(!(user.getPassword().equals(user.getPassConfirm()))) return false;

        user.setRoles(Collections.singleton(new AppRole(1L, "ROLE_USER")));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(long id) {

        if(userRepository.existsById(id)) {

            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}