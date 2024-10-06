package com.company.intersegrega.service;

import com.company.intersegrega.entity.Entity;

public interface PersistenceService<T extends Entity> {

	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(Long id);
	
}
