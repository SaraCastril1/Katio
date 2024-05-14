package com.nodo.katio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nodo.katio.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
