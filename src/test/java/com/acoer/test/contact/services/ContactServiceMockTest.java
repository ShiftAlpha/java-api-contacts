package com.acoer.test.contact.services;

import com.acoer.test.contact.domain.Contact;
import com.acoer.test.contact.repo.contactRepository;
import com.acoer.test.contact.service.ContactService;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

public class ContactServiceMockTest {

    @Spy
    private ContactService contactServiceSpy;
    @Mock
    private contactRepository contactRepository;
    @Mock
    private Contact contact;

    // @Test(NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetContactByIdIsCalledWithoutContext() throws Exception {
        // Act
        // Contact retrievedContact = contactServiceSpy.search(contact);
        // Assert
        // assertThat(retrievedContact, is(equal(contact)));
    }

    public void shouldThrowNullPointerException_whenSaveContactIsCalledWithoutContext() throws Exception {
        // Arrange
        Mockito.doReturn(contact).when(contactRepository).save(contact);
        // Act
        // Contact savedContact = contactServiceSpy.saveContact(contact);
        // Assert
        // assertThat(savedContact, is(equalTo(contact)));
    }

    @Test
    public void shouldVerifyThatGetContactByIdIsCalled() throws Exception {
        // Arrange
        // Mockito.doReturn(contact).when(contactServiceSpy).getContactById(5);
        // Act
        // Contact retrievedContact = contactServiceSpy.getContactById(5);
        // Assert
        // Mockito.verify(contactServiceSpy).getContactById(5);
    }

    @Test
    public void shouldVerifyThatSaveContactIsNotCalled() throws Exception {
        // Arrange
        // Mockito.doReturn(contact).when(contactServiceSpy).getContactById(5);
        // Act
        // Contact retrievedContact = contactServiceSpy.getContactById(5);
        // Assert
        // Mockito.verify(contactServiceSpy, never()).saveContact(contact);
    }
}
