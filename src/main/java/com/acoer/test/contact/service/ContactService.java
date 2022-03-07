package com.acoer.test.contact.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.acoer.test.contact.domain.Contact;
import com.acoer.test.contact.domain.DbSequence;
// import com.acoer.test.contact.repo.contactRepo;
import com.acoer.test.contact.repo.contactRepository;


@Service
public class ContactService implements ICrudOperations<Contact> {

	private static final Logger logger = LogManager.getLogger();
	private contactRepository cRepository;

	@Autowired
	private MongoOperations mongoOps;

	public long generateSequence(String seqName) {

        DbSequence counter = mongoOps.findAndModify(query(where("phonenumber").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DbSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }

	@Autowired
    public ContactService(MongoOperations mongoOps) {
        this.mongoOps = mongoOps;
    }

	@Override
	public List<Contact> getAll() throws Exception{

		logger.debug("getAll called");
		
		return ((ContactService) cRepository).getAll();
	}

	@Override
	public  Optional<Contact> search(String searchTerm) throws Exception{

		logger.debug("search called");

		//utilizes mongoOps
		// return mongoOps.findById(null, null, searchTerm);

		// utilizes crepository instance instead of mongoOps
		return cRepository.findById(searchTerm);

	}

	@Override
	public Contact add(Contact itemContact) throws Exception{

		logger.debug("add called");

		return mongoOps.save(itemContact);

		//utilizes cRepository instance instead of mongoOps
		//return cRepository.save(itemContact);

		
	}

	@Override
	public Contact update(Contact newNumber) throws Exception{

		logger.debug("update called");
		
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

		logger.debug("delete called");

		if(item == null){
			throw new Exception("Cannot Delete item");
		} else {
			cRepository.delete(item);
		}
		cRepository.delete(item);
	}

}
