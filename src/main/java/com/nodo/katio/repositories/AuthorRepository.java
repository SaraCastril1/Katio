// PASO 3: Migraciones con base de datos.

package com.nodo.katio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nodo.katio.models.Author;

@Repository
public interface AuthorRepository<User> extends CrudRepository<Author, Integer> {
    User saveAndFlush(Author Author);
}
