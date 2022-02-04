package com.alkemy.disney.disney.auth.service;

import com.alkemy.disney.disney.auth.dto.UserDTO;
import com.alkemy.disney.disney.auth.entity.UserEntity;
import com.alkemy.disney.disney.auth.repository.UserRepository;
import com.alkemy.disney.disney.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //Buscar por nombre de usuario
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null){
            throw new UsernameNotFoundException("Username or password not found");
        }
        //return new User(userEntity.getUsername(),userEntity.getPassword(), Collections.emptyList());
        
        return User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }

    public boolean save(UserDTO userDTO){

        String pass = userDTO.getPassword();
        String passEncript = passwordEncoder.encode(pass);

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passEncript);

        userEntity = userRepository.save(userEntity);

        if (userEntity != null){
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }
        return userEntity != null;
    }
}
