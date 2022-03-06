package com.acoer.test.contact.service;

import java.util.List;
import java.util.Optional;

import com.acoer.test.contact.domain.Contact;

public interface ICrudOperations<T> {

	/**
	 * Returns all the items
	 * *
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<T> getAll() throws Exception;

	/**
	 * Returns items matching the searchTerm
	 * 
	 * @param searchTerm
	 * @return
	 */
	public Optional<Contact> search(String searchTerm) throws Exception;

	/**
	 * Adds a new item to the DB
	 * 
	 * @param item
	 * @return
	 */
	public T add(T item) throws Exception;

	/**
	 * Updates an existing item to the DB
	 * 
	 * @param item
	 * @return
	 */
	public T update(T item) throws Exception;

	/**
	 * Removes an item from the DB
	 * 
	 * @param item
	 */
	public void delete(T item) throws Exception;
}
