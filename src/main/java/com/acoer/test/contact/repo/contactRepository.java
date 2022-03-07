package com.acoer.test.contact.repo;

import com.acoer.test.contact.domain.Contact;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface contactRepository extends MongoRepository<Contact, String>{
}
