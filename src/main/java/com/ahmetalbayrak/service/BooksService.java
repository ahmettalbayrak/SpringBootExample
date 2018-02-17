/**
 * 
 */
package com.ahmetalbayrak.service;

import java.util.List;

import com.ahmetalbayrak.model.Books;

/**
 * @author Ahmet
 *
 */
public interface BooksService extends BaseService<Books>{

	public List<Books> getUsers();
    
    public void update(Books entity, int isbn);
    
    public Books findUserByEmail(String isbn);
}
