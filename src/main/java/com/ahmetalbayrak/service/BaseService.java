/**
 * 
 */
package com.ahmetalbayrak.service;

import java.util.List;

/**
 * @author Ahmet
 *
 */
public interface BaseService<T>  {
    
    public void save(T entity);
    
    public void delete(Long id);
    
}
