/**
 * 
 */
package com.ahmetalbayrak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmetalbayrak.model.Books;
import com.ahmetalbayrak.repository.BooksRepository;

/**
 * @author Ahmet
 *
 */
@Service("booksService")
public class BooksServiceImpl implements BooksService {
	
	@Autowired
	private BooksRepository booksRepository;

	@Override
	public void save(Books entity) {
		booksRepository.save(entity);
		
	}

	@Override
	public void delete(Long id) {
		booksRepository.delete(id);
		
	}

	@Override
	public List<Books> getBooks() {
		
		return booksRepository.findAll();
	}

}
