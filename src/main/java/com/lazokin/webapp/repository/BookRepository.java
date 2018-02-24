package com.lazokin.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.lazokin.webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
