/**
 * 
 */
package com.ahmetalbayrak.repository;

import org.springframework.stereotype.Repository;

import com.ahmetalbayrak.model.Books;

/**
 * @author Ahmet
 *
 */
@Repository("booksRepository")
public interface BooksRepository extends BaseRepository<Books, Long>{

}
