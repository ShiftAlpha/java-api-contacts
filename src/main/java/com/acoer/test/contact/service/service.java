package com.acoer.test.contact.service;

import com.acoer.test.contact.domain.Contact;


//additional Service class
public interface service {
    Iterable <Contact> listAllContacts();

    Contact getContact(String contact);

    Contact saveContact(Contact contact);

    void deleteContact(String contac);
}