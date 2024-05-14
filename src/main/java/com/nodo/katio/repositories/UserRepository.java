// PASO 3: Migraciones con base de datos.

package com.nodo.katio.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nodo.katio.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    User saveAndFlush(User user);
    
    Optional<User> findByName(String name);
}
