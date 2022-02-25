package com.alkemy.disney.disney.auth.repository;

import com.alkemy.disney.disney.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    //UserEntity findByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE u.username =:nombre")
    UserEntity buscarUsuario(String nombre);
}
