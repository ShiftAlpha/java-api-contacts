package com.acoer.test.contact.ControllerIntegration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// import javax.annotation.security.RunAs;

import com.acoer.test.contact.Application;
import com.acoer.test.contact.domain.Contact;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;


// @RunAs(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerIntegrationTest {

    @Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllContacts() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/contacts",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetContactByNum() {
		Contact contact = restTemplate.getForObject(getRootUrl() + "/contacts/", Contact.class);
		System.out.println(contact.getFName());
		assertNotNull(contact);
	}

	@Test
	public void testCreateContact() {
		Contact contact = new Contact();
		contact.setNum(647508514);
		contact.setFName("admin");
		contact.setSName("admin");

		ResponseEntity<Contact> postResponse = restTemplate.postForEntity(getRootUrl() + "/contacts", contact, Contact.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateContact() {
		int id = 1;
		Contact contact = restTemplate.getForObject(getRootUrl() + "/contact/" + id, Contact.class);
		contact.setFName("admin1");
		contact.setSName("admin2");

		restTemplate.put(getRootUrl() + "/contact/" + id, contact);

		Contact updatedContact = restTemplate.getForObject(getRootUrl() + "/contact/" + id, Contact.class);
		assertNotNull(updatedContact);
	}

	@Test
	public void testDeleteContact() {
		int id = 2;
		Contact contact = restTemplate.getForObject(getRootUrl() + "/contact/" + id, Contact.class);
		assertNotNull(contact);

		restTemplate.delete(getRootUrl() + "/contact/" + id);

		try {
			contact = restTemplate.getForObject(getRootUrl() + "/contact/" + id, Contact.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
    
}
