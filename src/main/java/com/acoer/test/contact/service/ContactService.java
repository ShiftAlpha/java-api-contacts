/**
 * 
 */
package com.acoer.test.contact.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.acoer.test.contact.domain.Contact;
import com.acoer.test.contact.repo.contactRepo;

import com.acoer.test.contact.controller.*;

@Service
public class ContactService implements ICrudOperations<Contact> {

	private static final Logger logger = LogManager.getLogger();

	@Autowired
	private MongoOperations mongoOps;

	@Override
	public List<Contact> getAll() {
		// return contactRepo.getAll();
		return null;
	}

	@Override
	public List<Contact> search(String searchTerm) {

		return null;
		// return contactRepo.search(searchTerm).orElseThrow(() -> new ResourceNotFoundException(UNABLE_TO_LOCATE));
	}

	@Override
	public Contact add(Contact itemContact) {

		// return contactRepo.save(item);
		return null;
	}

	@Override
	public Contact update(Contact newNumber) {
		
		// if(number == null) new com.acoer.test.contact.controller.IllegalArgumentException("");

		// 	return contactRepo.search(searchTerm).map(contact -> {
		// 		Contact.setNum(newNumber.getNum());
				


		// 	}).orElseGet(() -> 
		// 	{
		// 		new ResourceNotFoundException("Unable to find number :" + number);
		// 		return null;
		// 	});
		
			return null;

	}

	@Override
	public void delete(Contact item) {
		// contactRepo.delete(item);

	}

}
