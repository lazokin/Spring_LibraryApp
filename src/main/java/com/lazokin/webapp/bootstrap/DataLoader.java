package com.lazokin.webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.lazokin.webapp.model.Author;
import com.lazokin.webapp.model.Book;
import com.lazokin.webapp.model.Publisher;
import com.lazokin.webapp.repository.AuthorRepository;
import com.lazokin.webapp.repository.BookRepository;
import com.lazokin.webapp.repository.PublisherRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private PublisherRepository publisherRepository;
	private BookRepository bookRepository;

	public DataLoader(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
	private void initData() {
		
		Publisher hc = new Publisher("Harper Collins", "Harper Collins Address");
		Publisher worxs = new Publisher("Worxs", "Worxs Address");
		publisherRepository.save(hc);
		publisherRepository.save(worxs);
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", hc);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development wihout EJB", "5678", worxs);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
	}

}
