package com.acoer.test.contact.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionException;

import javax.management.relation.RelationNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acoer.test.contact.domain.Contact;
import com.acoer.test.contact.repo.contactRepository;
import com.acoer.test.contact.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Controller
@RequestMapping("/contacts")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE })
@Api(tags = { "Contacts API - " })

public class ContactController {
	private static final Logger logger = LogManager.getLogger();

	@Autowired
	private ContactService contactService;

	@Autowired
	private contactRepository cRepository;

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	@ApiOperation(value = "Get all contacts", notes = "Get all contacts")
	// api annotations
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach isnot found")
	})

	// Create
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Contact contact) throws Exception{

		logger.info("Adding to contacts list");
		try {
			contactService.add(contact);
			return new ResponseEntity<>("Entry saved successfully", HttpStatus.OK);

		} catch (CancellationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (CompletionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	// Update
	@RequestMapping(value = "/update/{phonenumber}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable Contact phoneNum, @RequestBody Contact contact) throws Exception {

		logger.info("Updating number in contacts list");

		Contact storedContact = (Contact) contactService.getAll();
		storedContact.setFName(contact.getFName());
		storedContact.setSName(contact.getSName());
		storedContact.setNum(contact.getNum());
		contactService.add(storedContact);
		return new ResponseEntity<>("Entry updated successfully", HttpStatus.OK);
	}

	// Delete
	@RequestMapping(value = "/delete/{phonenumber}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Contact phoneNum) throws Exception {

		logger.info("Deleting number & entry in contacts list");

		contactService.delete(phoneNum);
		return new ResponseEntity<>("Number deleted successfully", HttpStatus.OK);
	}

	// List all
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Contact>> getContacts() {

		logger.info("Retrieving list of contacts");

		List<Contact> result = new ArrayList<Contact>();
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}

	// Search
	@ApiOperation(value = "Search a Contact with a phone number", response = Contact.class)
	@RequestMapping(value = "/Search/{phonenumber}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Contact> showContact(@PathVariable String phoneNum, Model model) throws Exception{
		Contact contact = (Contact) contactService.search(phoneNum).orElseThrow();
		return ResponseEntity.ok().body(contact);
	}

}
