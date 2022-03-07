package com.acoer.test.contact.service;

import com.acoer.test.contact.domain.Contact;



public interface service {
    Iterable <Contact> listAllProducts();

    Contact getContact(String contact);

    Contact saveContact(Contact contact);

    void deleteContact(String contac);
}