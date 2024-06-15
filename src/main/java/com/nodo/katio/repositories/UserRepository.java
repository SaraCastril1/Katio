// PASO 3: Migraciones con base de datos.

package com.nodo.katio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nodo.katio.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    User saveAndFlush(User user);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM USERS WHERE id = :id")
    User findById(@Param("id") long id);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM USERS WHERE name LIKE %:name%")
    Iterable<User> findByName(@Param("name") String name);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM USERS WHERE email LIKE :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query(nativeQuery = true,
        value = "SELECT * FROM USERS WHERE email = :email and passhash = :passhash")
    Optional<User> findLoggedUser (@Param("email") String email, @Param("passhash") String passhash);


    @Query(nativeQuery = true, 
        value = "SELECT * FROM USERS WHERE email LIKE %:email%")
    Optional<User> findByUsername(@Param("email") String email);

}
