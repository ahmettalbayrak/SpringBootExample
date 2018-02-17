/**
 * 
 */
package com.ahmetalbayrak.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Ahmet
 *
 */

@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T, Long>{

}
