package com.lazokin.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
