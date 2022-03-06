package com.acoer.test.contact.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.acoer.test.contact.domain.Contact;
// import com.acoer.test.contact.repo.contactRepo;
import com.acoer.test.contact.repo.contactRepository;


@Service
public class ContactService implements ICrudOperations<Contact> {

	private static final Logger logger = LogManager.getLogger();
	private contactRepository cRepository;

	@Autowired
	private MongoOperations mongoOps;

	@Autowired
    public ContactService(MongoOperations mongoOps) {
        this.mongoOps = mongoOps;
    }

	@Override
	public List<Contact> getAll() throws Exception{
		return ((ContactService) cRepository).getAll();
	}

	@Override
	public Optional<Contact> search(String searchTerm) throws Exception{

		return cRepository.findById(searchTerm);

	}

	@Override
	public Contact add(Contact itemContact) throws Exception{

		return cRepository.save(itemContact);
	}

	@Override
	public Contact update(Contact newNumber) throws Exception{
		
		// if(newNumber == null) new com.acoer.test.contact.controller.IllegalArgumentException("");

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
	public void delete(Contact item) throws Exception {
		if(item == null){
			throw new Exception("Cannot Delete item");
		} else {
			cRepository.delete(item);
		}
		cRepository.delete(item);
	}

}
